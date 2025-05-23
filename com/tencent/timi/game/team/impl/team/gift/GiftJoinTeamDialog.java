package com.tencent.timi.game.team.impl.team.gift;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qqgift.updatasystem.QQGiftPanelResource;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.base.ui.TimiGamePageLoadingView;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.ui.widget.BaseSlideUpDialog;
import com.tencent.timi.game.ui.widget.k;
import com.tencent.timi.game.utils.l;
import com.tencent.timi.game.utils.w;
import fm4.g;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qh2.f;
import trpc.yes.common.PremadesTeamServerOuterClass$BatchGetGameTeamInfoRsp;
import trpc.yes.common.YoloRoomOuterClass$YoloGiftConfig;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;

/* compiled from: P */
/* loaded from: classes26.dex */
public class GiftJoinTeamDialog extends BaseSlideUpDialog implements k {
    private View T;
    private View U;
    private TextView V;
    private TextView W;
    private TextView X;
    private TextView Y;
    private ImageView Z;

    /* renamed from: a0, reason: collision with root package name */
    private TimiGamePageLoadingView f379774a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f379775b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f379776c0;

    /* renamed from: d0, reason: collision with root package name */
    private int f379777d0;

    /* renamed from: e0, reason: collision with root package name */
    private nh2.c f379778e0;

    /* renamed from: f0, reason: collision with root package name */
    private int f379779f0;

    /* renamed from: g0, reason: collision with root package name */
    private e f379780g0;

    /* renamed from: h0, reason: collision with root package name */
    private YoloRoomOuterClass$YoloRoomInfo f379781h0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (GiftJoinTeamDialog.this.f379780g0 != null) {
                GiftJoinTeamDialog.this.f379780g0.b(GiftJoinTeamDialog.this);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (GiftJoinTeamDialog.this.f379780g0 != null) {
                e eVar = GiftJoinTeamDialog.this.f379780g0;
                GiftJoinTeamDialog giftJoinTeamDialog = GiftJoinTeamDialog.this;
                eVar.a(giftJoinTeamDialog, giftJoinTeamDialog.f379777d0);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class c implements rh2.c {
        c() {
        }

        @Override // rh2.c
        public void e(com.tencent.mobileqq.qqgift.data.service.d dVar) {
            GiftJoinTeamDialog.this.o0(dVar);
            GiftJoinTeamDialog.this.hideLoadingView();
        }

        @Override // qh2.d
        public void onFailed(int i3, String str) {
            l.e("GiftJoinTeamDialog", "getGiftDetail failed,errorCode == " + i3 + ", errorMessage = " + str);
            GiftJoinTeamDialog.this.hideLoadingView();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class d implements DialogInterface.OnDismissListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            ((IQQGiftManager) QRoute.api(IQQGiftManager.class)).destroySDKImpl(10003);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface e {
        void a(GiftJoinTeamDialog giftJoinTeamDialog, int i3);

        void b(GiftJoinTeamDialog giftJoinTeamDialog);
    }

    public GiftJoinTeamDialog(@NotNull Context context, YoloRoomOuterClass$YoloGiftConfig yoloRoomOuterClass$YoloGiftConfig, PremadesTeamServerOuterClass$BatchGetGameTeamInfoRsp premadesTeamServerOuterClass$BatchGetGameTeamInfoRsp) {
        super(context);
        this.f379775b0 = yoloRoomOuterClass$YoloGiftConfig.gift_material_id.get();
        this.f379776c0 = yoloRoomOuterClass$YoloGiftConfig.gift_num.get();
        this.f379779f0 = yoloRoomOuterClass$YoloGiftConfig.gift_id.get();
        this.f379781h0 = premadesTeamServerOuterClass$BatchGetGameTeamInfoRsp.share_yolo_room_msg.get(0).room_info;
    }

    private void initView() {
        View inflate = View.inflate(getContext(), R.layout.hu6, null);
        this.T = inflate;
        this.U = inflate.findViewById(R.id.vq6);
        this.V = (TextView) this.T.findViewById(R.id.vqb);
        this.W = (TextView) this.T.findViewById(R.id.vq7);
        this.X = (TextView) this.T.findViewById(R.id.vq_);
        this.Y = (TextView) this.T.findViewById(R.id.vqa);
        this.Z = (ImageView) this.T.findViewById(R.id.vq8);
        this.f379774a0 = (TimiGamePageLoadingView) this.T.findViewById(R.id.vq9);
        setContentView(this.T);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0(QQGiftPanelResource qQGiftPanelResource) {
        this.Z.setBackgroundDrawable(um4.a.f439223a.a(qQGiftPanelResource.f265002b, URLDrawable.URLDrawableOptions.obtain()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0(com.tencent.mobileqq.qqgift.data.service.d dVar) {
        if (dVar == null) {
            return;
        }
        this.V.setText("\u786e\u5b9a\u9001".concat(String.valueOf(this.f379776c0)).concat("\u4e2a").concat(dVar.f264876e).concat("\u52a0\u5165\u8f66\u961f\u5417"));
        int i3 = dVar.f264878f;
        this.f379777d0 = i3;
        this.W.setText(Html.fromHtml("\u5f85\u652f\u4ed8<font color=\"#F5A300\">".concat(String.valueOf(i3 * this.f379776c0)).concat("\u91d1\u5e01</font>")));
        r0();
    }

    private void p0() {
        um4.k kVar = um4.k.f439239a;
        kVar.c();
        nh2.c d16 = kVar.d();
        this.f379778e0 = d16;
        if (d16 != null) {
            d16.b().e(this.f379775b0, new f() { // from class: com.tencent.timi.game.team.impl.team.gift.GiftJoinTeamDialog.3
                @Override // qh2.f
                public void c(int i3, final QQGiftPanelResource qQGiftPanelResource) {
                    w.c(new Runnable() { // from class: com.tencent.timi.game.team.impl.team.gift.GiftJoinTeamDialog.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            GiftJoinTeamDialog.this.n0(qQGiftPanelResource);
                        }
                    });
                }

                @Override // qh2.g
                public void onLoadFail(int i3, int i16, int i17, String str) {
                    l.e("GiftJoinTeamDialog", "getGiftResource failed,errorCode == " + i16 + ", errorMsg = " + str);
                }
            });
        }
        showLoadingView();
        nh2.c cVar = this.f379778e0;
        if (cVar != null) {
            cVar.a().K(this.f379779f0, new c());
        }
        setOnDismissListener(new d());
    }

    private void q0() {
        this.X.setOnClickListener(new a());
        this.Y.setOnClickListener(new b());
    }

    private void r0() {
        YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo = this.f379781h0;
        if (yoloRoomOuterClass$YoloRoomInfo != null) {
            ConcurrentHashMap<String, String> L = YoloRoomUtil.L(yoloRoomOuterClass$YoloRoomInfo);
            gh4.e I0 = ((gh4.f) mm4.b.b(gh4.f.class)).I0();
            if (((g) mm4.b.b(g.class)).j0(5) != null && I0 != null) {
                L.putAll(I0.getMReporterHelper().E());
                L.put("yes_gift_price", String.valueOf(this.f379777d0));
                ((ug4.b) mm4.b.b(ug4.b.class)).G2(this.T, I0.getMReporterHelper().C());
                ((ug4.b) mm4.b.b(ug4.b.class)).a(this.X, true, null, "em_yes_payjointeam_win_close", L);
                ((ug4.b) mm4.b.b(ug4.b.class)).a(this.Y, true, null, "em_yes_payjointeam_win_confirm", L);
            }
        }
    }

    @Override // com.tencent.timi.game.ui.widget.k
    public void hideLoadingView() {
        TimiGamePageLoadingView timiGamePageLoadingView = this.f379774a0;
        if (timiGamePageLoadingView != null) {
            timiGamePageLoadingView.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.timi.game.ui.widget.BaseSlideUpDialog, com.tencent.timi.game.ui.widget.j, android.app.Dialog
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        initView();
        q0();
        p0();
    }

    public void s0(e eVar) {
        this.f379780g0 = eVar;
    }

    public void showLoadingView() {
        u0(R.string.f23156727);
    }

    public void u0(int i3) {
        this.f379774a0.setHintText(getContext().getString(R.string.f23156727));
        this.f379774a0.d();
    }

    @Override // com.tencent.timi.game.ui.widget.k
    public void K(@NotNull String str) {
    }
}
