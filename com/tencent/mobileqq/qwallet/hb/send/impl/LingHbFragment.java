package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletFeatureApi;
import com.tencent.mobileqq.qwallet.hb.HbInfo;
import com.tencent.mobileqq.qwallet.hb.panel.RedPacketManager;
import com.tencent.mobileqq.qwallet.report.impl.ReportUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import qk2.HbRecommendConfig;

/* compiled from: P */
/* loaded from: classes16.dex */
public class LingHbFragment extends BaseHbUIFragment implements View.OnClickListener {

    /* renamed from: d0, reason: collision with root package name */
    private al2.b f277662d0;

    /* renamed from: e0, reason: collision with root package name */
    private RecyclerView f277663e0;

    /* renamed from: f0, reason: collision with root package name */
    private List<String> f277664f0 = new ArrayList();

    private boolean Rh(String str) {
        if (65536 == this.G) {
            if (bl2.b.a(str) < 4) {
                zk2.b bVar = zk2.b.f452710a;
                zk2.b.o(HardCodeUtil.qqStr(R.string.eg8));
                return false;
            }
            if (bl2.b.e(str).length() > 0) {
                zk2.b bVar2 = zk2.b.f452710a;
                zk2.b.o(getString(R.string.eg6));
                return false;
            }
            return true;
        }
        return true;
    }

    private boolean Uh() {
        JSONObject f16;
        if (((IQWalletFeatureApi) QRoute.api(IQWalletFeatureApi.class)).isFeatureSwitch(IQWalletFeatureApi.QWALLET_FORBID_CUSTOM_TEXT_COMMAND, false) || (f16 = RedPacketManager.f(HbInfo.b(this.G, 2))) == null || !f16.has("allowEditCommand")) {
            return true;
        }
        return !f16.optBoolean("allowEditCommand", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Vh(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        zk2.b.o("\u53e3\u4ee4\u7ea2\u5305\u6682\u4e0d\u652f\u6301\u81ea\u5b9a\u4e49\u53e3\u4ee4");
        EventCollector.getInstance().onViewClicked(view);
    }

    private void Wh() {
        RecyclerView.LayoutManager layoutManager = this.f277663e0.getLayoutManager();
        if (layoutManager instanceof cl2.a) {
            List<String> Zh = Zh(this.f277664f0, ((cl2.a) layoutManager).getLayoutChildIndex());
            this.f277664f0 = Zh;
            this.f277662d0.r0(Zh);
        }
    }

    private void Xh() {
        String str;
        if (!zh()) {
            return;
        }
        int j3 = x05.c.j(this.R.getText().toString(), 1);
        String l3 = x05.c.l(String.valueOf(x05.c.i(this.S.getText().toString())));
        if (TextUtils.isEmpty(l3)) {
            zk2.b bVar = zk2.b.f452710a;
            zk2.b.o(HardCodeUtil.qqStr(R.string.iqa));
            return;
        }
        String Th = Th();
        if (!Rh(Th)) {
            return;
        }
        qh(this.Y, this.G, j3, l3, "hongbao.wrap.go");
        Map<String, String> mapPacketExtra = this.D.getMapPacketExtra();
        mapPacketExtra.put(WadlProxyConsts.CHANNEL, String.valueOf(this.G));
        mapPacketExtra.put("type", "1");
        mapPacketExtra.put("wishing", Th);
        mapPacketExtra.put("total_num", j3 + "");
        mapPacketExtra.put("total_amount", l3);
        this.F.b(mapPacketExtra);
        if (com.tencent.mobileqq.qwallet.hb.aio.impl.d.g(this.Y.recv_type)) {
            str = this.Y.guild_id;
        } else {
            str = this.Y.recv_uin;
        }
        HbInfo.a aVar = this.Y;
        ReportUtils.g("redpack.paybtn.click", aVar.recv_type, aVar.panel_name, "", str);
    }

    private void Yh() {
        if (this.G == 32 && Uh()) {
            this.T.setFocusable(false);
            this.T.setFocusableInTouchMode(false);
            EditText editText = this.T;
            if (editText instanceof ClearableEditText) {
                ((ClearableEditText) editText).setClearButtonStyle(1);
            }
            this.T.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qwallet.hb.send.impl.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LingHbFragment.Vh(view);
                }
            });
        }
    }

    @NonNull
    private List<String> Zh(@NonNull List<String> list, int i3) {
        int i16;
        int size = list.size();
        if (i3 != -1 && (i16 = i3 + 1) < size) {
            ArrayList arrayList = new ArrayList(size);
            arrayList.addAll(list.subList(i16, size));
            arrayList.addAll(list.subList(0, i16));
            return arrayList;
        }
        return list;
    }

    @Override // com.tencent.mobileqq.qwallet.hb.send.impl.BaseHbUIFragment
    public boolean Ah() {
        if (super.Ah() && TextUtils.isEmpty(Th())) {
            this.L.setEnabled(false);
        }
        return this.L.isEnabled();
    }

    @Override // com.tencent.mobileqq.qwallet.hb.send.impl.BaseHbUIFragment
    protected String Ch() {
        if (32 == this.G) {
            return HardCodeUtil.qqStr(R.string.nof);
        }
        return HardCodeUtil.qqStr(R.string.noe);
    }

    @Override // com.tencent.mobileqq.qwallet.hb.send.impl.BaseHbUIFragment
    public int Dh() {
        return R.layout.cch;
    }

    @Override // com.tencent.mobileqq.qwallet.hb.send.impl.BaseHbUIFragment
    public String Eh() {
        return this.T.getText().toString();
    }

    @Override // com.tencent.mobileqq.qwallet.hb.send.impl.BaseHbUIFragment
    public void Hh(Bundle bundle) {
        super.Hh(bundle);
        QLog.i("LingHbFragment", 2, "init view...");
        this.K.findViewById(R.id.xke).setOnClickListener(this);
        this.L.setOnClickListener(this);
        this.T.setFocusable(true);
        this.T.addTextChangedListener(this.f277644a0);
        this.f277663e0 = (RecyclerView) this.K.findViewById(R.id.yiw);
        cl2.a aVar = new cl2.a(ViewUtils.dip2px(10.0f), ViewUtils.dip2px(14.0f), 2);
        aVar.setAutoMeasureEnabled(true);
        this.f277663e0.setLayoutManager(aVar);
        al2.b bVar = new al2.b();
        this.f277662d0 = bVar;
        bVar.o0(this.T);
        this.f277663e0.setAdapter(this.f277662d0);
        if (com.tencent.mobileqq.qwallet.hb.aio.impl.d.e(this.Y.recv_type)) {
            this.M.setText(R.string.e7l);
        } else {
            this.M.setText(R.string.e7k);
        }
        if (this.G == 65536) {
            ((TextView) this.K.findViewById(R.id.f167049md2)).setText(R.string.iqc);
            ((TextView) this.K.findViewById(R.id.f108626dm)).setText(R.string.f2176161h);
        }
        Yh();
    }

    @NonNull
    public List<String> Sh() {
        ArrayList arrayList = new ArrayList();
        for (HbRecommendConfig.RecommendItem recommendItem : com.tencent.mobileqq.qwallet.hb.send.model.c.b()) {
            if (com.tencent.mobileqq.qwallet.hb.send.model.c.a(recommendItem, this.G)) {
                QLog.i("LingHbFragment", 2, "flag = " + recommendItem.getFlag() + " txt = " + recommendItem.getText());
                arrayList.add(recommendItem.getText());
            }
        }
        return arrayList;
    }

    public String Th() {
        String Eh = Eh();
        if (TextUtils.isEmpty(Eh)) {
            return this.T.getHint().toString();
        }
        return Eh;
    }

    @Override // com.tencent.mobileqq.qwallet.hb.send.impl.BaseHbUIFragment
    public void initData() {
        List<String> list;
        super.initData();
        List<String> Sh = Sh();
        this.f277664f0 = Sh;
        this.f277662d0.r0(Sh);
        if (this.T != null && (list = this.f277664f0) != null && list.size() > 0) {
            this.T.setHint(this.f277664f0.get(0));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (view.getId() == R.id.b7m) {
            Xh();
        } else if (id5 == R.id.xke) {
            QLog.i("LingHbFragment", 2, "change others...");
            if (this.G == 65536) {
                str = "yyhongbao.word.change";
            } else {
                str = "klhongbao.word.change";
            }
            ph(str, "");
            Wh();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.qwallet.hb.send.impl.BaseHbUIFragment, com.tencent.mobileqq.qwallet.hb.send.impl.BaseHbFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z16) {
        super.setUserVisibleHint(z16);
        if (z16) {
            ph("hongbao.wrap.hopngbaokey", "");
        }
    }
}
