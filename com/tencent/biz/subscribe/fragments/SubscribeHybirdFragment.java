package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StShare;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead$StGetFeedDetailRsp;
import android.R;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.beans.SubscribeColorNoteReserveBean;
import com.tencent.biz.subscribe.comment.CommentBottomBar;
import com.tencent.biz.subscribe.comment.CommentPresenter;
import com.tencent.biz.subscribe.event.FollowUpdateEvent;
import com.tencent.biz.subscribe.utils.h;
import com.tencent.biz.subscribe.widget.StatusView;
import com.tencent.biz.subscribe.widget.SubscribeShareHelper;
import com.tencent.biz.subscribe.widget.commodity.CommodityBean;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.utils.t;
import com.tencent.mobileqq.webview.webso.WebSoService;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SubscribeHybirdFragment extends WebViewFragment {
    private CommentBottomBar C;
    private CertifiedAccountMeta$StFeed D;
    private ExtraTypeInfo E;
    private ImageView F;
    private SubscribeShareHelper G;
    protected IColorNoteController H;
    private CertifiedAccountMeta$StShare I;
    private int J;
    private StatusView K;
    private View L;
    private com.tencent.biz.subscribe.utils.c M;
    private g N;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a extends com.tencent.mobileqq.webview.swift.proxy.a {
        a(t tVar) {
            super(tVar);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onDataInit(Bundle bundle) {
            SubscribeHybirdFragment.this.getUIStyleHandler().f314512m.Q = false;
            SubscribeHybirdFragment.this.getUIStyleHandler().f314512m.f314631n = true;
            SubscribeHybirdFragment.this.G = new SubscribeShareHelper(SubscribeHybirdFragment.this.getHostActivity());
            SubscribeHybirdFragment.this.initData();
            super.onDataInit(bundle);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onFinalState(Bundle bundle) {
            super.onFinalState(bundle);
            SubscribeHybirdFragment.this.Gh(bundle);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public void onProgressChanged(WebView webView, int i3) {
            super.onProgressChanged(webView, i3);
            if (i3 > 25 && SubscribeHybirdFragment.this.F != null) {
                SubscribeHybirdFragment.this.F.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements com.tencent.mobileqq.colornote.f {
        b() {
        }

        @Override // com.tencent.mobileqq.colornote.f
        public ColorNote getColorNote() {
            if (SubscribeHybirdFragment.this.D != null && SubscribeHybirdFragment.this.E != null) {
                byte[] b16 = h.b(new SubscribeColorNoteReserveBean(SubscribeHybirdFragment.this.D.toByteArray(), SubscribeHybirdFragment.this.E.pageType));
                ve0.b bVar = new ve0.b();
                bVar.f441502b = SubscribeHybirdFragment.this.D;
                bVar.f441505e = SubscribeHybirdFragment.this.E;
                String str = SubscribeHybirdFragment.this.D.f24925id.get();
                String h16 = bVar.h();
                bVar.c();
                String b17 = bVar.b();
                String f16 = bVar.f();
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                return new ColorNote.a().g(R.id.edit).i(str).d(h16).h(f16).e(b17).f(b16).a();
            }
            QLog.e("SubscribeHybirdFragment", 1, "initColorNote, shareInfoBean is null");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class c implements ha1.a {
        c() {
        }

        @Override // ha1.a
        public void onColorNoteAnimFinish() {
            if (SubscribeHybirdFragment.this.getQBaseActivity() != null) {
                SubscribeHybirdFragment.this.getQBaseActivity().finish();
                SubscribeHybirdFragment.this.getQBaseActivity().overridePendingTransition(0, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class d extends com.tencent.mobileqq.colornote.g {
        d() {
        }

        @Override // com.tencent.mobileqq.colornote.g
        public void onAddColorNote(Bundle bundle, boolean z16) {
            super.onAddColorNote(bundle, z16);
            if (SubscribeHybirdFragment.this.getQBaseActivity() != null) {
                SubscribeHybirdFragment.this.getQBaseActivity().finish();
                SubscribeHybirdFragment.this.getQBaseActivity().overridePendingTransition(0, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ve0.b f96071d;

        e(ve0.b bVar) {
            this.f96071d = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            SubscribeHybirdFragment.this.Nh(this.f96071d);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class f implements CommentPresenter.h {
        f() {
        }

        @Override // com.tencent.biz.subscribe.comment.CommentPresenter.h
        public void a(CertifiedAccountRead$StGetFeedDetailRsp certifiedAccountRead$StGetFeedDetailRsp, boolean z16, long j3, String str) {
            if (certifiedAccountRead$StGetFeedDetailRsp != null && certifiedAccountRead$StGetFeedDetailRsp.feed.get() != null) {
                SubscribeHybirdFragment.this.yh(certifiedAccountRead$StGetFeedDetailRsp, j3, str);
            } else {
                QQToast.makeText(SubscribeHybirdFragment.this.getHostActivity(), HardCodeUtil.qqStr(com.tencent.mobileqq.R.string.tx5), 0).show();
            }
        }

        @Override // com.tencent.biz.subscribe.comment.CommentPresenter.h
        public void b(int i3) {
            SubscribeHybirdFragment.this.C.E(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class g extends BroadcastReceiver {
        g() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                if (TextUtils.equals(action, "action_update_follow_state")) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("uin", intent.getStringExtra("uin"));
                        jSONObject.put("followState", intent.getIntExtra("followState", 0));
                        if (SubscribeHybirdFragment.this.getWebView() != null) {
                            SubscribeHybirdFragment.this.getWebView().callJs(WebViewPlugin.toJsScript("updateFollowState", jSONObject, null));
                            return;
                        }
                        return;
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                        return;
                    }
                }
                if (TextUtils.equals(action, "action_get_lbs_location")) {
                    try {
                        String[] stringArrayExtra = intent.getStringArrayExtra("code");
                        String[] stringArrayExtra2 = intent.getStringArrayExtra("location");
                        JSONObject jSONObject2 = new JSONObject();
                        JSONObject jSONObject3 = new JSONObject();
                        if (stringArrayExtra != null && stringArrayExtra2 != null) {
                            if (stringArrayExtra.length == 4 && stringArrayExtra2.length == 4) {
                                int i3 = 0;
                                for (int i16 = 4; i3 < i16; i16 = 4) {
                                    if ("0".equals(stringArrayExtra[i3])) {
                                        stringArrayExtra[i3] = "";
                                        stringArrayExtra2[i3] = "";
                                    }
                                    i3++;
                                }
                                jSONObject2.put("country", stringArrayExtra[0]);
                                jSONObject2.put("province", stringArrayExtra[1]);
                                jSONObject2.put("city", stringArrayExtra[2]);
                                jSONObject2.put(GdtGetUserInfoHandler.KEY_AREA, stringArrayExtra[3]);
                                jSONObject3.put("country", stringArrayExtra2[0]);
                                jSONObject3.put("province", stringArrayExtra2[1]);
                                jSONObject3.put("city", stringArrayExtra2[2]);
                                jSONObject3.put(GdtGetUserInfoHandler.KEY_AREA, stringArrayExtra2[3]);
                            }
                        }
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("code", jSONObject2);
                        jSONObject4.put("location", jSONObject3);
                        if (SubscribeHybirdFragment.this.getWebView() != null) {
                            SubscribeHybirdFragment.this.getWebView().callJs(WebViewPlugin.toJsScript("getlbslocationCallback", jSONObject4, null));
                        }
                    } catch (JSONException e17) {
                        e17.printStackTrace();
                    }
                }
            }
        }
    }

    private void Ah() {
        int i3 = this.E.pageType;
        if (i3 != 7000 && i3 != 8001) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        CommentBottomBar commentBottomBar = new CommentBottomBar(getQBaseActivity());
        this.C = commentBottomBar;
        commentBottomBar.l(getHostActivity(), this.D, new f());
        ve0.b bVar = new ve0.b();
        bVar.f441506f = false;
        bVar.f441501a = 2;
        this.C.setShareClickListener(xh(bVar));
        this.C.setLayoutParams(layoutParams);
        getUIStyleHandler().W.addView(this.C);
        ViewStub viewStub = new ViewStub(getHostActivity());
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 80;
        viewStub.setLayoutParams(layoutParams2);
        getUIStyleHandler().W.addView(viewStub);
        getUIStyleHandler().S.setPadding(0, 0, 0, ImmersiveUtils.dpToPx(50.0f));
        if (this.C.k() != null) {
            this.C.k().q1(viewStub);
        }
    }

    private void Bh() {
        StatusView statusView = new StatusView(getQBaseActivity());
        this.K = statusView;
        statusView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.K.setVisibility(8);
        getUIStyleHandler().S.addView(this.K);
    }

    private void Ch() {
        String j3 = SubscribeUtils.j();
        if (new File(j3).exists()) {
            ImageView imageView = new ImageView(getQBaseActivity());
            this.F = imageView;
            imageView.setBackgroundColor(-1);
            this.F.setScaleType(ImageView.ScaleType.CENTER_CROP);
            try {
                this.F.setImageURI(Uri.fromFile(new File(j3 + "/certified_account_preload_pic.png")));
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            this.F.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            if (getUIStyleHandler() != null && getUIStyleHandler().S != null) {
                getUIStyleHandler().S.addView(this.F);
            }
        }
    }

    private void Dh() {
        getSwiftTitleUI().M.setBackgroundColor(-1);
        getSwiftTitleUI().E.setImageResource(com.tencent.mobileqq.R.drawable.f160838ns);
        getSwiftTitleUI().f314054i.setBackgroundResource(com.tencent.mobileqq.R.drawable.f160834no);
        getSwiftTitleUI().E.setVisibility(0);
    }

    private boolean Eh(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        if (!SubscribeUtils.r(certifiedAccountMeta$StFeed.status.get())) {
            if (SubscribeUtils.o(certifiedAccountMeta$StFeed.poster.attr.get())) {
                if (this.L == null) {
                    View inflate = LayoutInflater.from(getQBaseActivity()).inflate(com.tencent.mobileqq.R.layout.c7g, (ViewGroup) null, false);
                    this.L = inflate;
                    inflate.setLayoutParams(new ViewGroup.LayoutParams(-1, ImmersiveUtils.dpToPx(44.0f)));
                    getUIStyleHandler().S.addView(this.L);
                }
                this.L.setVisibility(0);
                return false;
            }
            StatusView statusView = this.K;
            if (statusView != null && statusView.getVisibility() == 8) {
                View view = this.L;
                if (view != null && view.getVisibility() == 0) {
                    this.L.setVisibility(8);
                }
                this.K.x(null);
                return true;
            }
            return true;
        }
        StatusView statusView2 = this.K;
        if (statusView2 != null) {
            statusView2.t();
        }
        View view2 = this.L;
        if (view2 != null && view2.getVisibility() == 0) {
            this.L.setVisibility(8);
        }
        return false;
    }

    private boolean Fh(long j3, String str) {
        if (j3 != 0) {
            StatusView statusView = this.K;
            if (statusView != null) {
                statusView.x(str);
                return true;
            }
            return true;
        }
        return false;
    }

    private void Kh(int i3) {
        CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed = this.D;
        if (certifiedAccountMeta$StFeed != null && !StringUtil.isEmpty(certifiedAccountMeta$StFeed.poster.f24929id.get())) {
            VSReporter.n(this.D.poster.f24929id.get(), "auth_share", "exp_" + SubscribeShareHelper.s(this.E), i3, 0, new String[0]);
        }
    }

    private void Oh(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        this.D = certifiedAccountMeta$StFeed;
        CommentBottomBar commentBottomBar = this.C;
        if (commentBottomBar != null) {
            commentBottomBar.setCurrentFeed(certifiedAccountMeta$StFeed);
        }
        com.tencent.biz.subscribe.utils.c cVar = this.M;
        if (cVar != null) {
            cVar.c(certifiedAccountMeta$StFeed.poster);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (getIntent() != null) {
            long longExtra = getIntent().getLongExtra("PERF_OPEN_PAGE_TIME", 0L);
            if (longExtra != 0) {
                VSReporter.q("subscribe_open_h5_page_time", VSReporter.e(0L, System.currentTimeMillis() - longExtra));
            }
            this.E = (ExtraTypeInfo) getIntent().getSerializableExtra(ExtraTypeInfo.KEY_SUBSCRIBE_INTENT_EXTRA_TYPE_INFO);
        }
        if (this.E == null) {
            this.E = new ExtraTypeInfo();
        }
        CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed = new CertifiedAccountMeta$StFeed();
        this.D = certifiedAccountMeta$StFeed;
        try {
            this.D = certifiedAccountMeta$StFeed.mergeFrom(this.intent.getByteArrayExtra("bundle_key_subscribe_feed_bytes_array"));
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static void wh(Context context, FollowUpdateEvent followUpdateEvent) {
        if (context != null && followUpdateEvent != null) {
            Intent intent = new Intent("action_update_follow_state");
            intent.putExtra("uin", followUpdateEvent.useId);
            intent.putExtra("followState", followUpdateEvent.followStatus);
            context.sendBroadcast(intent);
        }
    }

    private View.OnClickListener xh(ve0.b bVar) {
        return new e(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yh(CertifiedAccountRead$StGetFeedDetailRsp certifiedAccountRead$StGetFeedDetailRsp, long j3, String str) {
        CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed = certifiedAccountRead$StGetFeedDetailRsp.feed.get();
        if (Fh(j3, str) || Eh(certifiedAccountMeta$StFeed)) {
            return;
        }
        this.I = certifiedAccountRead$StGetFeedDetailRsp.share.get();
        Oh(certifiedAccountMeta$StFeed);
        if (this.E.pageType == 8001) {
            WebSoService.j().e();
            VSReporter.n(getUin(), "auth_image", "exp", 0, 0, "", "", certifiedAccountMeta$StFeed.poster.nick.get(), certifiedAccountMeta$StFeed.title.get());
        }
        if (!StringUtil.isEmpty(certifiedAccountRead$StGetFeedDetailRsp.detailUrl.get())) {
            if (getWebView() != null) {
                getWebView().loadUrl(certifiedAccountRead$StGetFeedDetailRsp.detailUrl.get());
                return;
            } else {
                QLog.e("SubscribeHybirdFragment", 2, "webview init exception it's null");
                return;
            }
        }
        QLog.e("SubscribeHybirdFragment", 2, "detailUrl is null");
    }

    private void zh() {
        ExtraTypeInfo extraTypeInfo = this.E;
        if ((extraTypeInfo != null && extraTypeInfo.pageType != 8001) || this.H != null) {
            return;
        }
        IColorNoteController iColorNoteController = (IColorNoteController) QRoute.api(IColorNoteController.class);
        this.H = iColorNoteController;
        iColorNoteController.init(getQBaseActivity(), false, true);
        this.H.attachToActivity(getQBaseActivity());
        this.H.setServiceInfo(new b());
        this.H.setOnColorNoteAnimFinishListener(new c());
        this.H.setOnColorNoteCurdListener(new d());
    }

    public void Gh(Bundle bundle) {
        if (getQBaseActivity().getRequestedOrientation() != 1) {
            getQBaseActivity().setRequestedOrientation(1);
        }
        getWebView().setVerticalScrollBarEnabled(false);
        getWebView().setHorizontalScrollBarEnabled(false);
        getWebView().getSettings().setDefaultTextEncodingName("utf-8");
        getWebView().getSettings().setUserAgentString(getWebView().getSettings().getUserAgentString() + " QQ_APP_Subscribe");
        if (NetworkUtil.isNetworkAvailable(getQBaseActivity())) {
            getWebView().getSettings().setCacheMode(2);
        }
        if (getUIStyleHandler() != null && getUIStyleHandler().U != null) {
            getUIStyleHandler().U.l(false);
        }
        switch (this.E.pageType) {
            case 8000:
            case 8002:
                if (getQBaseActivity().getIntent() != null && this.E.pageType == 8002) {
                    getSwiftTitleUI().E.setVisibility(0);
                    break;
                } else {
                    getSwiftTitleUI().E.setVisibility(8);
                    break;
                }
            case 8001:
                Dh();
                Ch();
                break;
        }
        if (SimpleUIUtil.getSimpleUISwitch()) {
            if (getWebTitleBarInterface().a3() != null) {
                getWebTitleBarInterface().a3().setBackgroundColor(-1);
            }
            this.J = getQBaseActivity().getWindow().getDecorView().getSystemUiVisibility() | 1024 | 8192;
            getQBaseActivity().getWindow().getDecorView().setSystemUiVisibility(this.J);
        }
        if (this.E.pageType == 8002) {
            getSwiftTitleUI().E.setOnClickListener(this);
        } else {
            ve0.b bVar = new ve0.b();
            bVar.f441506f = true;
            bVar.f441501a = 1;
            getSwiftTitleUI().E.setOnClickListener(xh(bVar));
        }
        Ah();
        Bh();
        zh();
        if (this.E.pageType == 8001) {
            this.M = new com.tencent.biz.subscribe.utils.c(getQBaseActivity());
        }
        if (getQBaseActivity() != null) {
            this.N = new g();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("action_update_follow_state");
            intentFilter.addAction("action_get_lbs_location");
            getQBaseActivity().registerReceiver(this.N, intentFilter);
        }
    }

    public void Hh(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        if (com.tencent.biz.subscribe.d.f(certifiedAccountMeta$StFeed.type.get())) {
            ImageView imageView = this.F;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            this.D = certifiedAccountMeta$StFeed;
            this.C.t(certifiedAccountMeta$StFeed);
            if (getWebView() != null) {
                getWebView().pageUp(true);
                return;
            }
            return;
        }
        com.tencent.biz.subscribe.d.o(getQBaseActivity(), certifiedAccountMeta$StFeed);
        if (getQBaseActivity() != null) {
            getQBaseActivity().finish();
        }
    }

    public void Ih() {
        if (getHostActivity() != null) {
            Intent intent = new Intent();
            intent.setAction("action_refresh_return_page");
            if (getHostActivity() != null) {
                getHostActivity().sendBroadcast(intent);
            }
        }
    }

    public void Jh() {
        Intent intent = new Intent();
        intent.setAction("action_reload_get_main_page");
        if (getHostActivity() != null) {
            getHostActivity().sendBroadcast(intent);
        }
    }

    public void Lh(ArrayList<CommodityBean> arrayList) {
        if (getHostActivity() != null) {
            Intent intent = new Intent();
            intent.putExtra("attach_goods", arrayList);
            intent.setAction("action_attach_goods");
            if (getHostActivity() != null) {
                getHostActivity().sendBroadcast(intent);
            }
        }
    }

    public void Mh(String str, String str2, String str3, String str4, String str5) {
        int parseInt;
        CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed = this.D;
        if (certifiedAccountMeta$StFeed != null) {
            certifiedAccountMeta$StFeed.poster.f24929id.set(str);
            this.D.poster.nick.set(str2);
            this.D.poster.icon.set(str3);
            this.D.poster.desc.set(str4);
            PBUInt32Field pBUInt32Field = this.D.poster.type;
            if (StringUtil.isEmpty(str5)) {
                parseInt = 0;
            } else {
                parseInt = Integer.parseInt(str5);
            }
            pBUInt32Field.set(parseInt);
            VSReporter.n(str, "auth_person", "exp", 0, 0, new String[0]);
        }
    }

    protected void Nh(ve0.b bVar) {
        if (bVar == null) {
            bVar = new ve0.b();
        }
        if (this.G != null) {
            Kh(bVar.f441501a);
            bVar.f441503c = getCurrentUrl();
            bVar.f441502b = this.D;
            bVar.f441504d = this.I;
            bVar.f441505e = this.E;
            this.G.T(bVar, this.H);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webview.swift.WebViewProvider
    public void doOnBackEvent() {
        String str;
        String str2;
        CommentBottomBar commentBottomBar = this.C;
        if (commentBottomBar != null && commentBottomBar.s()) {
            return;
        }
        ExtraTypeInfo extraTypeInfo = this.E;
        if (extraTypeInfo != null) {
            int i3 = extraTypeInfo.pageType;
            if (i3 != 7000) {
                if (i3 != 7002) {
                    if (i3 != 8001) {
                        str2 = "";
                        VSReporter.n(getUin(), str2, "clk_return", 0, 0, "", "");
                    } else {
                        str = "auth_image";
                    }
                } else {
                    str = "auth_person";
                }
            } else {
                str = "auth_video";
            }
            str2 = str;
            VSReporter.n(getUin(), str2, "clk_return", 0, 0, "", "");
        }
        super.doOnBackEvent();
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
    public t getWebViewKernelCallBack() {
        return new a(this.webViewSurface);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        CommentBottomBar commentBottomBar = this.C;
        if (commentBottomBar != null) {
            commentBottomBar.u();
        }
        ImageView imageView = this.F;
        if (imageView != null) {
            imageView.setImageDrawable(null);
        }
        IColorNoteController iColorNoteController = this.H;
        if (iColorNoteController != null) {
            iColorNoteController.onDestroy();
        }
        SubscribeShareHelper subscribeShareHelper = this.G;
        if (subscribeShareHelper != null) {
            subscribeShareHelper.M();
        }
        if (getQBaseActivity() != null && this.N != null) {
            getQBaseActivity().unregisterReceiver(this.N);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        IColorNoteController iColorNoteController = this.H;
        if (iColorNoteController != null) {
            iColorNoteController.onPause();
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        IColorNoteController iColorNoteController = this.H;
        if (iColorNoteController != null) {
            iColorNoteController.onResume();
        }
    }
}
