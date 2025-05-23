package com.qzone.component.banner.general.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.qzone.util.am;
import com.qzone.util.ar;
import com.qzone.util.l;
import com.tencent.gamecenter.wadl.api.IQQGameCommApi;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import i6.d;
import java.util.HashSet;
import java.util.List;
import mqq.app.MobileQQ;
import r01.c;
import tencent.im.qqgame.QQGameQfsSubscribe;

/* compiled from: P */
/* loaded from: classes39.dex */
public class GameCenterGameBottom extends FrameLayout implements WadlTrpcListener {
    private i6.a C;
    private final HashSet<String> D;

    /* renamed from: d, reason: collision with root package name */
    private d f46589d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f46590e;

    /* renamed from: f, reason: collision with root package name */
    private LinearLayout f46591f;

    /* renamed from: h, reason: collision with root package name */
    private Button f46592h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f46593i;

    /* renamed from: m, reason: collision with root package name */
    private Context f46594m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            LpReportInfo_pf00064.allReport(619, 18, 3, "", "1");
            GameCenterGameBottom.this.r("914336");
            GameCenterGameBottom.this.f();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b implements IPicLoadStateListener {
        b() {
        }

        @Override // com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            if (loadState.isFinishSuccess() && (option.getAnimatable() instanceof c)) {
                c cVar = (c) option.getAnimatable();
                cVar.setLoopCount(1);
                cVar.start();
            }
        }
    }

    public GameCenterGameBottom(Context context) {
        super(context);
        this.D = new HashSet<>();
        i(context);
    }

    private void e(String str) {
        QLog.i("GameCenterGameBottom", 1, "btnClickWhenGameOnline jumpUrl: " + str);
        if (h()) {
            String g16 = l6.d.g(this.C, "package_name");
            QLog.i("GameCenterGameBottom", 1, "start game packageName: " + g16);
            PackageUtil.startAppWithPkgName(this.f46594m, g16, null, "biz_src_zf_games", 0);
            r("205992");
            return;
        }
        if (am.h(str)) {
            str = l6.d.g(this.C, "gamezone_auto_url");
            QLog.i("GameCenterGameBottom", 1, "go download game gameZoneAutoDownloadUrl: " + str);
            if (am.h(str)) {
                return;
            }
        }
        GameCenterUtil.jumpUrlOrSchema(MobileQQ.sMobileQQ, str);
    }

    private boolean g() {
        return l6.d.f(this.C, "game_status") == 3;
    }

    private boolean h() {
        String g16 = l6.d.g(this.C, "package_name");
        boolean z16 = !am.h(g16) && ((IQQGameCommApi) QRoute.api(IQQGameCommApi.class)).hasGameInstall(g16);
        QLog.i("GameCenterGameBottom", 2, "hasInstall hasInstall: " + z16 + ",packageName: " + g16);
        return z16;
    }

    private void i(Context context) {
        this.f46594m = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.f127691c, (ViewGroup) null, false);
        this.f46590e = (TextView) inflate.findViewById(R.id.niv);
        this.f46591f = (LinearLayout) inflate.findViewById(R.id.mg6);
        Button button = (Button) inflate.findViewById(R.id.f195762);
        this.f46592h = button;
        button.setOnClickListener(new a());
        this.f46593i = (ImageView) inflate.findViewById(R.id.kxt);
        addView(inflate);
        this.D.add(WadlProxyConsts.CMD_QUERY_SUBSCRIBE_STATUS);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(this);
    }

    private boolean j() {
        int f16 = l6.d.f(this.C, "subscribe_status");
        if (QLog.isColorLevel()) {
            QLog.i("GameCenterGameBottom", 2, "isAppointment: " + f16);
        }
        return f16 == 2;
    }

    private boolean k() {
        int f16 = l6.d.f(this.C, "app_type");
        if (QLog.isColorLevel()) {
            QLog.i("GameCenterGameBottom", 2, "isMiniGame: " + f16);
        }
        return f16 == 4;
    }

    private boolean l() {
        int f16 = l6.d.f(this.C, "app_type");
        if (QLog.isColorLevel()) {
            QLog.i("GameCenterGameBottom", 2, "isGame: " + f16);
        }
        return f16 == 1 || f16 == 2;
    }

    private boolean m() {
        return false;
    }

    private void p(Intent intent, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        PBBytesField pBBytesField;
        String stringExtra = intent.getStringExtra("appid");
        QLog.i("GameCenterGameBottom", 1, "onQuerySubscribeRsp appId: " + stringExtra);
        i6.a aVar = this.C;
        if (aVar == null || !aVar.g().equals(stringExtra)) {
            return;
        }
        if (trpcInovkeRsp != null && (pBBytesField = trpcInovkeRsp.data) != null && pBBytesField.get() != null) {
            try {
                QQGameQfsSubscribe.GetUserGameStatusRsp getUserGameStatusRsp = new QQGameQfsSubscribe.GetUserGameStatusRsp();
                getUserGameStatusRsp.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                final int i3 = getUserGameStatusRsp.result.get();
                if (QLog.isColorLevel()) {
                    QLog.i("GameCenterGameBottom", 2, "subscribeStatus: " + i3);
                }
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.qzone.component.banner.general.view.GameCenterGameBottom.4
                    @Override // java.lang.Runnable
                    public void run() {
                        int i16 = i3;
                        if (i16 == 2) {
                            GameCenterGameBottom.this.f46592h.setText(l.a(R.string.f132884m));
                            GameCenterGameBottom.this.f46592h.setBackground(ContextCompat.getDrawable(GameCenterGameBottom.this.f46594m, R.drawable.f13600a));
                            GameCenterGameBottom.this.f46592h.setClickable(false);
                        } else if (i16 == 3) {
                            GameCenterGameBottom.this.f46592h.setText(l.a(R.string.f132904o));
                            GameCenterGameBottom.this.f46592h.setClickable(true);
                        }
                    }
                });
                return;
            } catch (Exception e16) {
                QLog.e("GameCenterGameBottom", 1, e16, new Object[0]);
                return;
            }
        }
        QLog.i("GameCenterGameBottom", 1, "rsp.data.get() == null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(String str) {
        i6.a aVar = this.C;
        if (aVar != null) {
            int f16 = l6.d.f(aVar, "app_type");
            l6.d.j(this.C.g(), str, "", this.C.s(), "20", String.valueOf(f16), this.C.e(), String.valueOf(this.C.c()), l6.d.a(f16));
            l6.d.k(this.C.d(), 102, "tianshu.289");
        }
    }

    private void s(String str, String str2, String str3) {
        if (QLog.isColorLevel()) {
            QLog.i("GameCenterGameBottom", 2, "setBtnInfo btnText: " + str + ",jumpUrl: " + str2 + ",appId: " + str3);
        }
        this.f46592h.setBackground(ContextCompat.getDrawable(this.f46594m, R.drawable.f13590_));
        if (l6.d.h(this.C)) {
            this.f46592h.setText(str);
            this.f46592h.setClickable(true);
            return;
        }
        if (l()) {
            if (g()) {
                this.f46592h.setText(l.a(R.string.f132904o));
                this.f46592h.setClickable(true);
                return;
            } else if (!j()) {
                this.f46592h.setText(l.a(R.string.f132874l));
                this.f46592h.setClickable(true);
                return;
            } else {
                if (j()) {
                    this.f46592h.setText(l.a(R.string.f132884m));
                    this.f46592h.setBackground(ContextCompat.getDrawable(this.f46594m, R.drawable.f13600a));
                    this.f46592h.setClickable(false);
                    return;
                }
                return;
            }
        }
        if (m()) {
            this.f46592h.setText(l.a(R.string.f132924q));
            this.f46592h.setClickable(true);
        } else if (k()) {
            this.f46592h.setText(l.a(R.string.f132914p));
            this.f46592h.setClickable(true);
        }
    }

    private void t(String str) {
        if (QLog.isColorLevel()) {
            QLog.i("GameCenterGameBottom", 2, "setDispatchText text: " + str);
        }
        this.f46590e.setText(str);
    }

    private void u(String str) {
        if (QLog.isColorLevel()) {
            QLog.i("GameCenterGameBottom", 2, "setDynamicInfo dynamicUrl: " + str);
        }
        if (am.h(str)) {
            this.f46593i.setVisibility(8);
        } else {
            this.f46593i.setVisibility(0);
            com.tencent.mobileqq.qzone.picload.c.a().i(Option.obtain().setNeedShowLoadingDrawable(false).setUrl(str).setTargetView(this.f46593i), new b());
        }
    }

    private void v(List<String> list) {
        this.f46591f.removeAllViews();
        if (list != null && list.size() != 0) {
            this.f46591f.setVisibility(0);
            int i3 = 0;
            for (String str : list) {
                if (QLog.isColorLevel()) {
                    QLog.i("GameCenterGameBottom", 2, "setGameLabel label: " + str);
                }
                TextView textView = new TextView(this.f46594m);
                this.f46591f.addView(textView);
                textView.setText(str);
                textView.setTextSize(1, 10.0f);
                textView.setIncludeFontPadding(false);
                textView.setPadding(ar.d(6.0f), ar.d(3.0f), ar.d(6.0f), ar.d(3.0f));
                if (i3 > 0) {
                    ((LinearLayout.LayoutParams) textView.getLayoutParams()).leftMargin = ar.d(6.0f);
                }
                textView.setBackground(ContextCompat.getDrawable(this.f46594m, R.drawable.f13610b));
                textView.setTextColor(ContextCompat.getColor(this.f46594m, R.color.qui_common_text_secondary));
                i3++;
            }
            return;
        }
        this.f46591f.setVisibility(4);
    }

    private void w(String str) {
        this.f46591f.removeAllViews();
        TextView textView = new TextView(this.f46594m);
        textView.setText(str);
        textView.setTextColor(Color.parseColor("#999999"));
        textView.setTextSize(1, 12.0f);
        textView.setIncludeFontPadding(false);
        this.f46591f.addView(textView);
    }

    public void f() {
        String b16 = l6.d.b(this.C);
        if (l6.d.h(this.C)) {
            GameCenterUtil.jumpUrlOrSchema(MobileQQ.sMobileQQ, b16);
            if (l6.d.i(this.C)) {
                ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.qzone.component.banner.general.view.GameCenterGameBottom.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (GameCenterGameBottom.this.f46589d != null) {
                            GameCenterGameBottom.this.f46589d.b();
                        }
                    }
                }, 3000L);
                return;
            }
            return;
        }
        if (l()) {
            if (g()) {
                e(b16);
                return;
            } else if (!j()) {
                if (am.h(b16)) {
                    b16 = l6.d.g(this.C, "gamezone_auto_url");
                }
                QLog.i("GameCenterGameBottom", 1, "go yuyue game gameZoneAutoSubscribeUrl\uff1a " + b16);
            }
        } else if (k()) {
            if (am.h(b16)) {
                b16 = l6.d.g(this.C, "minigame_jump_url");
            }
            QLog.i("GameCenterGameBottom", 1, "go mini game detail\uff1a " + b16);
        } else if (m()) {
            if (am.h(b16)) {
                b16 = l6.d.g(this.C, "cloudgame_jump_url");
            }
            QLog.i("GameCenterGameBottom", 1, "go yun game detail\uff1a " + b16);
        } else {
            if (am.h(b16)) {
                b16 = l6.d.g(this.C, "gamezone_jump_url");
            }
            QLog.i("GameCenterGameBottom", 1, "go game detail\uff1a " + b16);
        }
        GameCenterUtil.jumpUrlOrSchema(MobileQQ.sMobileQQ, b16);
    }

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
    public HashSet<String> getFilterCmds() {
        return this.D;
    }

    public void o() {
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).removeListener(this);
        com.tencent.mobileqq.qzone.picload.c.a().k();
    }

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
    public void onTrpcRsp(Intent intent, String str, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        if (WadlProxyConsts.CMD_QUERY_SUBSCRIBE_STATUS.equals(str)) {
            try {
                if (l() && !l6.d.h(this.C)) {
                    if (j3 == 0 && trpcInovkeRsp != null) {
                        p(intent, trpcInovkeRsp);
                        return;
                    }
                    QLog.w("GameCenterGameBottom", 1, "rsp errors!");
                }
            } catch (Throwable th5) {
                QLog.e("GameCenterGameBottom", 1, th5, new Object[0]);
            }
        }
    }

    public void q() {
        if (l6.d.h(this.C)) {
            QLog.i("GameCenterGameBottom", 2, "onResume is act, don't query ");
            return;
        }
        if (l()) {
            i6.a aVar = this.C;
            if (aVar != null && !am.h(aVar.g())) {
                Bundle bundle = new Bundle();
                bundle.putString("appid", this.C.g());
                String a16 = l6.d.a(l6.d.f(this.C, "app_type"));
                if (QLog.isColorLevel()) {
                    QLog.i("GameCenterGameBottom", 2, "querySubscribeStatus appid: " + this.C.g() + ", channelId: " + a16);
                }
                ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).querySubscribeStatus(this.C.g(), a16, bundle);
                return;
            }
            QLog.i("GameCenterGameBottom", 1, "querySubscribeStatus appid is null ");
        }
    }

    public void setActionCallback(d dVar) {
        QLog.i("GameCenterGameBottom", 1, "setActionInterface actionCallback=" + dVar);
        this.f46589d = dVar;
    }

    public GameCenterGameBottom(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.D = new HashSet<>();
        i(context);
    }

    public void n(i6.a aVar) {
        if (aVar == null) {
            return;
        }
        this.C = aVar;
        if (QLog.isColorLevel()) {
            QLog.i("GameCenterGameBottom", 2, aVar.toString());
        }
        s(aVar.k(), aVar.j(), aVar.g());
        t(aVar.t());
        if (!am.h(aVar.f()) && !l6.d.h(this.C)) {
            u(aVar.f());
        } else {
            this.f46593i.setVisibility(8);
        }
        if (!am.h(aVar.u())) {
            w(aVar.u());
        } else {
            v(l6.d.e(aVar));
        }
    }
}
