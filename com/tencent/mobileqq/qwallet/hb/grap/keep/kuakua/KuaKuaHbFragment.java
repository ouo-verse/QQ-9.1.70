package com.tencent.mobileqq.qwallet.hb.grap.keep.kuakua;

import al2.b;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cl2.a;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qwallet.hb.HbInfo;
import com.tencent.mobileqq.qwallet.hb.send.impl.BaseHbFragment;
import com.tencent.mobileqq.qwallet.hb.send.impl.BaseHbUIFragment;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import x05.c;

/* compiled from: P */
/* loaded from: classes16.dex */
public class KuaKuaHbFragment extends BaseHbUIFragment implements View.OnClickListener {

    /* renamed from: d0, reason: collision with root package name */
    private final Map<String, String> f277472d0 = new HashMap();

    /* renamed from: e0, reason: collision with root package name */
    private final KuaKuaHbBundleInfo f277473e0 = new KuaKuaHbBundleInfo();

    /* renamed from: f0, reason: collision with root package name */
    private String f277474f0;

    /* renamed from: g0, reason: collision with root package name */
    private TextView f277475g0;

    /* renamed from: h0, reason: collision with root package name */
    private ViewGroup f277476h0;

    /* renamed from: i0, reason: collision with root package name */
    private RecyclerView f277477i0;

    /* renamed from: j0, reason: collision with root package name */
    private b f277478j0;

    /* renamed from: k0, reason: collision with root package name */
    private LinearLayout f277479k0;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class KuaKuaHbBundleInfo extends HbInfo.a {
        public int skinId;
        public JSONArray subjectList;
    }

    private void Zh() {
        final LinkedList<String> Yh = Yh(this.f277473e0.subjectList);
        if (Yh != null && Yh.size() > 0) {
            this.f277476h0.post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.grap.keep.kuakua.KuaKuaHbFragment.1

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.qwallet.hb.grap.keep.kuakua.KuaKuaHbFragment$1$a */
                /* loaded from: classes16.dex */
                class a implements View.OnClickListener {

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ LinearLayout f277481d;

                    a(LinearLayout linearLayout) {
                        this.f277481d = linearLayout;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        EventCollector.getInstance().onViewClickedBefore(view);
                        KuaKuaHbFragment.this.di();
                        KuaKuaHbFragment.this.ci(this.f277481d);
                        KuaKuaHbFragment.this.f277479k0 = this.f277481d;
                        EventCollector.getInstance().onViewClicked(view);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (KuaKuaHbFragment.this.f277476h0 != null) {
                        for (String str : Yh) {
                            LinearLayout linearLayout = new LinearLayout(((BaseHbFragment) KuaKuaHbFragment.this).D);
                            linearLayout.setOrientation(1);
                            TextView textView = new TextView(((BaseHbFragment) KuaKuaHbFragment.this).D);
                            textView.setText(str);
                            textView.setTextSize(1, 16.0f);
                            textView.setTextColor(KuaKuaHbFragment.this.getResources().getColor(R.color.f157610ca4));
                            linearLayout.addView(textView, new RelativeLayout.LayoutParams(-2, -2));
                            ImageView imageView = new ImageView(((BaseHbFragment) KuaKuaHbFragment.this).D);
                            imageView.setImageResource(R.drawable.nuk);
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewUtils.dip2px(15.0f), ViewUtils.dip2px(9.0f));
                            layoutParams.topMargin = ViewUtils.dip2px(8.0f);
                            layoutParams.gravity = 1;
                            imageView.setVisibility(8);
                            linearLayout.addView(imageView, layoutParams);
                            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
                            marginLayoutParams.rightMargin = ScreenUtil.dip2px(21.0f);
                            KuaKuaHbFragment.this.f277476h0.addView(linearLayout, marginLayoutParams);
                            textView.setOnClickListener(new a(linearLayout));
                        }
                        if (!KuaKuaHbFragment.this.ai()) {
                            KuaKuaHbFragment.this.fi();
                        }
                    }
                }
            });
        }
    }

    private boolean bi(String str, String str2, JSONArray jSONArray) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && jSONArray != null && jSONArray.length() >= 0) {
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i3);
                    if (jSONObject != null) {
                        String optString = jSONObject.optString("typeName");
                        if (!TextUtils.isEmpty(optString) && optString.trim().equals(str)) {
                            JSONArray optJSONArray = jSONObject.optJSONArray("subjects");
                            for (int i16 = 0; i16 < optJSONArray.length(); i16++) {
                                if (str2.trim().equals(optJSONArray.getString(i16))) {
                                    this.f277474f0 = jSONObject.optString("typeId");
                                    return true;
                                }
                            }
                            JSONArray optJSONArray2 = jSONObject.optJSONArray("recommend");
                            for (int i17 = 0; i17 < optJSONArray2.length(); i17++) {
                                if (str2.trim().equals(optJSONArray2.getString(i17))) {
                                    this.f277474f0 = jSONObject.optString("typeId");
                                    return true;
                                }
                            }
                        }
                    }
                } catch (Throwable th5) {
                    QLog.e("KuaKuaHbFragment", 1, "error msg in qqpay-impl module: ", th5);
                }
            }
        }
        return false;
    }

    private void ei() {
        if (!zh()) {
            return;
        }
        int j3 = c.j(this.R.getText().toString(), 1);
        String l3 = c.l(String.valueOf(c.i(this.S.getText().toString())));
        if (TextUtils.isEmpty(l3)) {
            QQToast.makeText(getActivity(), R.string.iqa, 0).show();
            return;
        }
        String trim = this.f277475g0.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            return;
        }
        qh(this.f277473e0, this.G, j3, l3, "hongbao.wrap.go");
        Map<String, String> mapPacketExtra = this.D.getMapPacketExtra();
        mapPacketExtra.put(WadlProxyConsts.CHANNEL, String.valueOf(this.G));
        mapPacketExtra.put("type", "1");
        mapPacketExtra.put("wishing", trim);
        mapPacketExtra.put("bus_type", "2");
        mapPacketExtra.put("total_num", j3 + "");
        mapPacketExtra.put("total_amount", l3);
        if (this.f277473e0.skinId > 0) {
            mapPacketExtra.put("skin_id", this.f277473e0.skinId + "");
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type_id", this.f277474f0);
            mapPacketExtra.put("client_extend", jSONObject.toString());
        } catch (JSONException e16) {
            QLog.e("KuaKuaHbFragment", 1, "error msg in qqpay-impl module: ", e16);
        }
        this.F.b(mapPacketExtra);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fi() {
        LinearLayout linearLayout;
        ViewGroup viewGroup = this.f277476h0;
        if (viewGroup != null) {
            View childAt = viewGroup.getChildAt(0);
            if ((childAt instanceof LinearLayout) && (linearLayout = (LinearLayout) childAt) != null) {
                ci(linearLayout);
                this.f277479k0 = linearLayout;
            }
        }
    }

    private void gi(String str) {
        ViewGroup viewGroup;
        int childCount;
        if (TextUtils.isEmpty(str) || (viewGroup = this.f277476h0) == null || (childCount = viewGroup.getChildCount()) <= 0) {
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.f277476h0.getChildAt(i3);
            if (childAt instanceof LinearLayout) {
            }
        }
    }

    @Override // com.tencent.mobileqq.qwallet.hb.send.impl.BaseHbUIFragment
    public boolean Ah() {
        if (super.Ah() && TextUtils.isEmpty(this.f277475g0.getText().toString().trim())) {
            this.L.setEnabled(false);
        }
        return this.L.isEnabled();
    }

    @Override // com.tencent.mobileqq.qwallet.hb.send.impl.BaseHbUIFragment
    protected String Ch() {
        return HardCodeUtil.qqStr(R.string.f213235pn);
    }

    @Override // com.tencent.mobileqq.qwallet.hb.send.impl.BaseHbUIFragment
    public int Dh() {
        return R.layout.hgq;
    }

    @Override // com.tencent.mobileqq.qwallet.hb.send.impl.BaseHbUIFragment
    public void Hh(Bundle bundle) {
        super.Hh(bundle);
        HbInfo.c(bundle, this.f277473e0);
        this.f277475g0 = (TextView) this.K.findViewById(R.id.z2p);
        this.f277476h0 = (ViewGroup) this.K.findViewById(R.id.yc5);
        this.f277477i0 = (RecyclerView) this.K.findViewById(R.id.x6z);
        a aVar = new a(ViewUtils.dip2px(10.0f), ViewUtils.dip2px(14.0f), 0);
        aVar.setAutoMeasureEnabled(true);
        this.f277477i0.setLayoutManager(aVar);
        b bVar = new b();
        this.f277478j0 = bVar;
        bVar.o0(this.f277475g0);
        this.f277477i0.setAdapter(this.f277478j0);
        if (QLog.isColorLevel()) {
            QLog.i("KuaKuaHbFragment", 2, "bizParams:" + this.f277473e0.biz_params);
        }
        if (HbInfo.f277195c.contains(this.f277473e0.recv_type)) {
            this.R.setText("1");
            this.K.findViewById(R.id.jv9).setVisibility(8);
        } else {
            if (!TextUtils.isEmpty(this.f277473e0.people_num)) {
                this.R.setHint(HardCodeUtil.qqStr(R.string.ndu) + this.f277473e0.people_num + HardCodeUtil.qqStr(R.string.ndy));
            }
            this.R.addTextChangedListener(this.f277644a0);
        }
        this.L.setOnClickListener(this);
    }

    public LinkedList<String> Yh(JSONArray jSONArray) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                if (jSONObject != null) {
                    String optString = jSONObject.optString("typeId");
                    String optString2 = jSONObject.optString("typeName");
                    String optString3 = jSONObject.optString("subjects");
                    String optString4 = jSONObject.optString("recommend");
                    if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && (!TextUtils.isEmpty(optString3) || !TextUtils.isEmpty(optString4))) {
                        linkedHashSet.add(optString2);
                    }
                }
            } catch (Throwable th5) {
                QLog.e("KuaKuaHbFragment", 1, "error msg in qqpay-impl module: ", th5);
            }
        }
        return new LinkedList<>(linkedHashSet);
    }

    public boolean ai() {
        JSONArray jSONArray;
        KuaKuaHbBundleInfo kuaKuaHbBundleInfo = this.f277473e0;
        if (kuaKuaHbBundleInfo != null && !StringUtil.isEmpty(kuaKuaHbBundleInfo.biz_params) && (jSONArray = this.f277473e0.subjectList) != null && jSONArray.length() >= 1) {
            try {
                if (QLog.isColorLevel()) {
                    QLog.i("KuaKuaHbFragment", 2, "bizParams:" + this.f277473e0.biz_params);
                }
                if (!StringUtil.isEmpty(this.f277473e0.biz_params)) {
                    JSONObject jSONObject = new JSONObject(this.f277473e0.biz_params);
                    String optString = jSONObject.optString("subject");
                    String optString2 = jSONObject.optString("subject_type");
                    if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString) && bi(optString2, optString, this.f277473e0.subjectList)) {
                        this.f277472d0.put(optString2, optString);
                        this.f277475g0.setText(optString);
                        gi(optString2);
                        return true;
                    }
                }
            } catch (Exception e16) {
                QLog.e("KuaKuaHbFragment", 1, "error msg in qqpay-impl module: ", e16);
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qwallet.hb.send.impl.BaseHbUIFragment
    public void initData() {
        this.f277475g0.addTextChangedListener(this.f277644a0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.b7m) {
            ei();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qwallet.hb.send.impl.BaseHbFragment
    public void sh() {
        super.sh();
        Zh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void di() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ci(LinearLayout linearLayout) {
    }
}
