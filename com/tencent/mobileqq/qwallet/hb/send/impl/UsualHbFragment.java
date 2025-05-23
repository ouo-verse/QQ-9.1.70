package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import bl2.HbSkinInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qwallet.hb.HbInfo;
import com.tencent.mobileqq.qwallet.hb.panel.preview.SkinPreviewDialogFragment;
import com.tencent.mobileqq.qwallet.hb.panel.recommend.HbListRecommendSkinViewModel;
import com.tencent.mobileqq.qwallet.hb.panel.recommend.SendHbOpActivitiesViewModel;
import com.tencent.mobileqq.qwallet.hb.send.model.HbSkinViewModel;
import com.tencent.mobileqq.qwallet.hb.skin.remote.HbSkinRemoteDataSource;
import com.tencent.mobileqq.qwallet.report.impl.ReportUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qwallet.plugin.QWalletPicHelper;
import java.util.Map;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class UsualHbFragment extends BaseHbUIFragment implements View.OnClickListener {

    /* renamed from: d0, reason: collision with root package name */
    private HbSkinViewModel f277697d0;

    /* renamed from: e0, reason: collision with root package name */
    private HbListRecommendSkinViewModel f277698e0;

    /* renamed from: f0, reason: collision with root package name */
    private SendHbOpActivitiesViewModel f277699f0;

    /* renamed from: g0, reason: collision with root package name */
    private TextView f277700g0;

    /* renamed from: h0, reason: collision with root package name */
    private ImageView f277701h0;

    /* renamed from: i0, reason: collision with root package name */
    private ImageView f277702i0;

    /* renamed from: j0, reason: collision with root package name */
    private TextView f277703j0;

    /* renamed from: k0, reason: collision with root package name */
    private View f277704k0;

    /* renamed from: l0, reason: collision with root package name */
    private View f277705l0;

    /* renamed from: m0, reason: collision with root package name */
    private View f277706m0;

    /* renamed from: n0, reason: collision with root package name */
    private View f277707n0;

    /* renamed from: o0, reason: collision with root package name */
    private TextView f277708o0;

    /* renamed from: p0, reason: collision with root package name */
    private TextView f277709p0;

    /* renamed from: q0, reason: collision with root package name */
    private ImageView f277710q0;

    /* renamed from: r0, reason: collision with root package name */
    private HbSkinInfo f277711r0 = bl2.d.a();

    /* renamed from: s0, reason: collision with root package name */
    private SkinPreviewDialogFragment f277712s0;

    /* renamed from: t0, reason: collision with root package name */
    private View f277713t0;

    private void Wh() {
        if (com.tencent.mobileqq.qwallet.hb.aio.impl.d.g(this.Y.recv_type)) {
            return;
        }
        this.f277699f0.N1().observe(getLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.qwallet.hb.send.impl.ai
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UsualHbFragment.this.Zh((SendHbOpActivitiesViewModel.SendHbOpActivitiesBean) obj);
            }
        });
        this.f277699f0.W1();
    }

    private void Xh() {
        QLog.i("UsualHbFragment", 2, "init data skin");
        this.f277697d0.S1().observe(this, new Observer() { // from class: com.tencent.mobileqq.qwallet.hb.send.impl.ag
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UsualHbFragment.this.ai((HbSkinInfo) obj);
            }
        });
        if (!com.tencent.mobileqq.qwallet.hb.aio.impl.d.g(this.Y.recv_type)) {
            this.f277698e0.w2().observe(getLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.qwallet.hb.send.impl.ah
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    UsualHbFragment.this.bi((String) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Yh(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int jumpActionType = this.f277699f0.getJumpActionType();
        if (jumpActionType != 1) {
            if (jumpActionType == 2) {
                ei();
            }
        } else {
            com.tencent.mobileqq.qwallet.utils.k.h(getActivity(), this.f277699f0.getJumpSchema());
        }
        this.f277699f0.S1();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Zh(SendHbOpActivitiesViewModel.SendHbOpActivitiesBean sendHbOpActivitiesBean) {
        if (sendHbOpActivitiesBean != null && !TextUtils.isEmpty(sendHbOpActivitiesBean.getContent())) {
            this.f277707n0.setVisibility(0);
            if (!TextUtils.isEmpty(sendHbOpActivitiesBean.getTag())) {
                this.f277708o0.setText(sendHbOpActivitiesBean.getTag());
                this.f277708o0.setVisibility(0);
            } else {
                this.f277708o0.setVisibility(8);
            }
            this.f277709p0.setText(sendHbOpActivitiesBean.getContent());
            com.tencent.mobileqq.qwallet.utils.i.a(this.f277710q0, sendHbOpActivitiesBean.getRightIconUrl());
            this.f277707n0.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qwallet.hb.send.impl.aj
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UsualHbFragment.this.Yh(view);
                }
            });
            this.f277699f0.T1();
            fi();
            return;
        }
        this.f277707n0.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ai(HbSkinInfo hbSkinInfo) {
        boolean z16 = false;
        if (hbSkinInfo == null) {
            gi(null, null, false);
            return;
        }
        this.f277711r0 = hbSkinInfo;
        this.f277700g0.setText(hbSkinInfo.getTitle());
        if ((hbSkinInfo.getType() & 8) != 0) {
            z16 = true;
        }
        gi(hbSkinInfo.getMakeUrl(), hbSkinInfo.getAioUrl(), z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void bi(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f277703j0.setVisibility(8);
        } else {
            this.f277703j0.setVisibility(0);
            this.f277703j0.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ci(int i3) {
        SkinPreviewDialogFragment skinPreviewDialogFragment = this.f277712s0;
        if (skinPreviewDialogFragment != null) {
            skinPreviewDialogFragment.dismissAllowingStateLoss();
            this.f277712s0 = null;
        }
        this.f277697d0.W1(i3, "", 0);
    }

    private void di() {
        String str;
        int i3;
        if (!zh()) {
            return;
        }
        int j3 = x05.c.j(this.R.getText().toString(), 1);
        String l3 = x05.c.l(String.valueOf(Bh()));
        if (TextUtils.isEmpty(l3)) {
            zk2.b bVar = zk2.b.f452710a;
            zk2.b.o(HardCodeUtil.qqStr(R.string.iqa));
            return;
        }
        qh(this.Y, Vh(), j3, l3, "hongbao.wrap.go");
        String Eh = Eh();
        int Vh = Vh();
        Map<String, String> mapPacketExtra = this.D.getMapPacketExtra();
        mapPacketExtra.put(WadlProxyConsts.CHANNEL, String.valueOf(Vh));
        mapPacketExtra.put("type", "1");
        mapPacketExtra.put("wishing", Eh);
        mapPacketExtra.put("bus_type", this.C.getString("bus_type"));
        mapPacketExtra.put("total_num", j3 + "");
        mapPacketExtra.put("total_amount", l3);
        if (512 == Vh) {
            mapPacketExtra.put("feeds_sid", this.C.getString("feedsid"));
        }
        mapPacketExtra.put("skin_id", "" + this.f277711r0.getSkinId());
        mapPacketExtra.put("outer_skin_id", this.f277711r0.getOuterSkinId());
        mapPacketExtra.put("skin_from", String.valueOf(this.f277711r0.getSkinFrom()));
        JSONObject jSONObject = new JSONObject();
        try {
            HbSkinInfo hbSkinInfo = this.f277711r0;
            if (hbSkinInfo != null) {
                i3 = hbSkinInfo.getType();
            } else {
                i3 = 0;
            }
            jSONObject.put("skin_type", String.valueOf(i3));
        } catch (JSONException e16) {
            QLog.e("UsualHbFragment", 1, "sendRedPackage: ", e16);
        }
        mapPacketExtra.put("client_extend", jSONObject.toString());
        this.F.b(mapPacketExtra);
        if (com.tencent.mobileqq.qwallet.hb.aio.impl.d.g(this.Y.recv_type)) {
            str = this.Y.guild_id;
        } else {
            str = this.Y.recv_uin;
        }
        HbInfo.a aVar = this.Y;
        ReportUtils.g("redpack.paybtn.click", aVar.recv_type, aVar.panel_name, String.format("%s;%s;%s", Integer.valueOf(this.f277711r0.getSkinId()), this.f277711r0.getOuterSkinId(), Integer.valueOf(this.f277711r0.getSkinFrom())), str);
    }

    private void ei() {
        SkinPreviewDialogFragment Fh = SkinPreviewDialogFragment.Fh(2, this.f277699f0.Q1(), com.tencent.mobileqq.qwallet.hb.panel.e.h(com.tencent.mobileqq.qwallet.hb.aio.impl.d.g(this.Y.recv_type), null).a());
        this.f277699f0.R1().q2(new WeakReference<>(this.f277697d0.Q1()));
        Fh.Jh(new com.tencent.mobileqq.qwallet.hb.panel.b() { // from class: com.tencent.mobileqq.qwallet.hb.send.impl.ak
            @Override // com.tencent.mobileqq.qwallet.hb.panel.b
            public final void Q5(int i3) {
                UsualHbFragment.this.ci(i3);
            }
        });
        Fh.show(getActivity().getSupportFragmentManager(), "UsualHbFragment");
        this.f277712s0 = Fh;
    }

    private void fi() {
        if (this.f277707n0.getVisibility() == 8) {
            com.tencent.mobileqq.qwallet.utils.impl.b.a(this.f277704k0, 8.0f);
        } else {
            com.tencent.mobileqq.qwallet.utils.impl.b.b(this.f277704k0, 8.0f, true, false);
            com.tencent.mobileqq.qwallet.utils.impl.b.b(this.f277707n0, 8.0f, false, true);
        }
    }

    private void gi(String str, String str2, boolean z16) {
        float f16;
        int i3;
        boolean z17 = true;
        int i16 = 0;
        if (!TextUtils.isEmpty(str)) {
            this.f277702i0.setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(str));
            this.f277701h0.setImageDrawable(null);
        } else if (!TextUtils.isEmpty(str2)) {
            this.f277701h0.setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(str2));
            this.f277702i0.setImageDrawable(null);
            if (z16) {
                f16 = 1.2f;
            } else {
                f16 = 1.0f;
            }
            this.f277701h0.setScaleX(f16);
            this.f277701h0.setScaleY(f16);
        } else {
            z17 = false;
        }
        View view = this.f277705l0;
        if (z17) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        view.setVisibility(i3);
        View view2 = this.f277706m0;
        if (!z17) {
            i16 = 8;
        }
        view2.setVisibility(i16);
    }

    @Override // com.tencent.mobileqq.qwallet.hb.send.impl.BaseHbUIFragment
    protected float Bh() {
        float i3 = x05.c.i(this.S.getText().toString());
        if (x05.c.j(this.Y.bus_type, 1) == 1) {
            return x05.c.j(this.R.getText().toString(), 0) * i3;
        }
        return i3;
    }

    @Override // com.tencent.mobileqq.qwallet.hb.send.impl.BaseHbUIFragment
    protected String Ch() {
        return HardCodeUtil.qqStr(R.string.e8q);
    }

    @Override // com.tencent.mobileqq.qwallet.hb.send.impl.BaseHbUIFragment
    public int Dh() {
        return R.layout.ccm;
    }

    @Override // com.tencent.mobileqq.qwallet.hb.send.impl.BaseHbUIFragment
    public void Hh(Bundle bundle) {
        super.Hh(bundle);
        QLog.i("UsualHbFragment", 2, "init view...");
        this.f277697d0 = this.D.getViewModel();
        this.f277698e0 = this.D.getHbListRecommendskinViewModel();
        this.f277699f0 = (SendHbOpActivitiesViewModel) new ViewModelProvider(this.D).get(SendHbOpActivitiesViewModel.class);
        getLifecycle().addObserver(this.f277699f0);
        this.L.setOnClickListener(this);
        this.f277700g0 = (TextView) this.K.findViewById(R.id.f111366l1);
        this.f277701h0 = (ImageView) this.K.findViewById(R.id.xkj);
        this.f277702i0 = (ImageView) this.K.findViewById(R.id.xkk);
        this.f277705l0 = this.K.findViewById(R.id.ydz);
        this.f277706m0 = this.K.findViewById(R.id.yfl);
        this.f277703j0 = (TextView) this.K.findViewById(R.id.f111356l0);
        View findViewById = this.K.findViewById(R.id.f85954qc);
        this.f277704k0 = findViewById;
        findViewById.setOnClickListener(this);
        this.f277707n0 = this.K.findViewById(R.id.f85984qf);
        this.f277708o0 = (TextView) this.K.findViewById(R.id.f86004qh);
        this.f277709p0 = (TextView) this.K.findViewById(R.id.f86014qi);
        this.f277710q0 = (ImageView) this.K.findViewById(R.id.f85994qg);
        this.f277713t0 = this.K.findViewById(R.id.f66773bj);
        fi();
        TextView textView = (TextView) this.K.findViewById(R.id.mcz);
        ImageView imageView = (ImageView) this.K.findViewById(R.id.fub);
        if (String.valueOf(2).equals(this.Y.bus_type)) {
            textView.setText(R.string.e7k);
            imageView.setVisibility(0);
        } else {
            textView.setText(R.string.e7l);
            imageView.setVisibility(8);
        }
        if (com.tencent.mobileqq.qwallet.hb.aio.impl.d.h(this.f277697d0.getRecvType())) {
            ViewGroup.LayoutParams layoutParams = this.f277713t0.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = ViewUtils.dip2px(46.0f);
            }
        }
    }

    public int Vh() {
        return this.G;
    }

    @Override // com.tencent.mobileqq.qwallet.hb.send.impl.BaseHbUIFragment
    public void initData() {
        super.initData();
        if (1 == this.G) {
            Xh();
            Wh();
        }
        if (2048 == this.G) {
            this.f277704k0.setVisibility(8);
            this.f277707n0.setVisibility(8);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (i3 == 1001 && i16 == -1) {
            String stringExtra = intent.getStringExtra("id");
            if (!TextUtils.isEmpty(stringExtra)) {
                this.f277697d0.W1(0, stringExtra, 1);
                HbSkinRemoteDataSource.f277873a.n(0, stringExtra, 1);
                this.f277697d0.U1();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.b7m) {
            di();
        } else if (id5 == R.id.f85954qc) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(getActivity().getWindow().getDecorView().getWindowToken(), 0);
            }
            ph("hongbao.wrap.vip", "");
            if (512 == this.G) {
                th("https://h5.qzone.qq.com/redpacket/skin/index?_proxy=1&_wv=16777219&feedsid=" + this.C.getString("feedsid"));
            } else {
                this.D.switchToHbSkinListFragment(new Bundle());
                com.tencent.mobileqq.qwallet.c.e("sendredpack.luckycover.click", "", Long.toString(NetConnInfoCenter.getServerTimeMillis()), "", "");
            }
            if (!com.tencent.mobileqq.qwallet.hb.aio.impl.d.g(this.Y.recv_type)) {
                this.f277698e0.A2();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.qwallet.hb.send.impl.BaseHbUIFragment, com.tencent.mobileqq.qwallet.hb.send.impl.BaseHbFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z16) {
        super.setUserVisibleHint(z16);
        if (z16) {
            if (String.valueOf(2).equals(this.Y.bus_type)) {
                ph("hongbao.wrap.random", "");
            } else {
                ph("hongbao.wrap.identical", "");
            }
        }
    }
}
