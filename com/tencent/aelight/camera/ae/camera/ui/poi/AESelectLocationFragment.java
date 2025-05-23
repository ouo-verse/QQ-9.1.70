package com.tencent.aelight.camera.ae.camera.ui.poi;

import LBS_V2_PROTOCOL.GPS_V2;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.camera.ui.poi.a;
import com.tencent.biz.qqstory.model.i;
import com.tencent.biz.qqstory.model.lbs.LbsManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForPeak;
import com.tencent.mobileqq.activity.en;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.tribe.data.TroopBarPOI;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.base.ToastUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import cooperation.qzone.Lbs.QzoneLbsConstant;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AESelectLocationFragment extends PublicBaseFragment implements en, View.OnClickListener, TextWatcher {
    private com.tencent.aelight.camera.ae.camera.ui.poi.a C;
    private RecyclerView D;
    private View E;
    private EditText F;
    private View G;
    private TextView H;
    private ImageView I;
    private ProgressBar J;
    private String K;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements OnApplyWindowInsetsListener {
        a() {
        }

        @Override // android.support.v4.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            ViewGroup viewGroup;
            if ((view instanceof ViewGroup) && (viewGroup = (ViewGroup) view.findViewById(R.id.f163788s05)) != null) {
                viewGroup.setPadding(0, windowInsetsCompat.getSystemWindowInsetTop(), 0, 0);
            }
            return windowInsetsCompat;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements a.d {
        b() {
        }

        @Override // com.tencent.aelight.camera.ae.camera.ui.poi.a.d
        public void a(String str) {
            AESelectLocationFragment.this.wh(str);
        }
    }

    public static void th(Context context, int i3) {
        PublicFragmentActivity.b.e(context, new Intent(), PublicFragmentActivityForPeak.class, AESelectLocationFragment.class, i3);
    }

    private void uh(String str) {
        if (!NetworkUtil.isNetworkAvailable(getBaseActivity())) {
            ms.a.f("AESelectLocationFragment", "requestPoiList---no network");
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.poi.AESelectLocationFragment.3
                @Override // java.lang.Runnable
                public void run() {
                    ToastUtil.a().e(HardCodeUtil.qqStr(R.string.v7o));
                }
            });
        } else {
            this.D.setVisibility(8);
            this.J.setVisibility(0);
            ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).startLocation(new AnonymousClass4(QzoneLbsConstant.BUSINESS_ID_QZONE_ADDRESS_SELECT, false, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wh(String str) {
        ms.a.a("AESelectLocationFragment", "setSelectResult" + str);
        com.tencent.aelight.camera.ae.report.b.b().M(str == null ? "none" : str);
        Intent intent = new Intent();
        intent.putExtra(QZoneHelper.INDEX_MOOD_SELECT_LOCATION_ITEM_SELECT_POI, str);
        getBaseActivity().setResult(-1, intent);
        getBaseActivity().finish();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        ms.a.a("AESelectLocationFragment", "onTextChanged :" + ((Object) editable));
        this.H.setText(editable);
        this.K = editable.toString();
        if (this.F.getText() != null && !this.F.getText().toString().equals("")) {
            this.I.setVisibility(0);
            this.G.setVisibility(0);
        } else {
            this.G.setVisibility(8);
            this.I.setVisibility(4);
        }
        uh(this.K);
    }

    @Override // com.tencent.mobileqq.activity.en
    public void onBackPressed() {
        getBaseActivity().finish();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        view.getId();
        int id5 = view.getId();
        if (id5 == R.id.roj) {
            com.tencent.aelight.camera.ae.report.b.b().N();
            getBaseActivity().finish();
        } else if (id5 == R.id.f163738rr0) {
            this.F.setText("");
        } else if (id5 == R.id.rrq) {
            wh(this.K);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT > 23) {
            getBaseActivity().getWindow().setBackgroundDrawable(null);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        InputMethodUtil.hide(this.F);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.tencent.aelight.camera.ae.report.b.b().J0();
        xh();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        initView(view);
        uh(null);
    }

    public void vh() {
        getBaseActivity().getWindow().getDecorView().setSystemUiVisibility(9216);
    }

    void xh() {
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null || !(baseActivity instanceof PublicFragmentActivity)) {
            return;
        }
        SystemBarActivityModule.getSystemBarComp(baseActivity).setStatusBarColor(-1);
        vh();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.aelight.camera.ae.camera.ui.poi.AESelectLocationFragment$4, reason: invalid class name */
    /* loaded from: classes32.dex */
    public class AnonymousClass4 extends LbsManagerServiceOnLocationChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f63240a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(String str, boolean z16, String str2) {
            super(str, z16);
            this.f63240a = str2;
        }

        @Override // com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener
        public void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo) {
            LbsManager.e eVar;
            if (sosoLbsInfo == null) {
                return;
            }
            GPS_V2 b16 = com.tencent.mobileqq.qzone.api.impl.util.a.b(sosoLbsInfo.mLocation);
            LbsManager lbsManager = (LbsManager) i.c(9);
            if (TextUtils.isEmpty(this.f63240a)) {
                eVar = null;
            } else {
                eVar = LbsManager.e.a();
                eVar.c(this.f63240a);
            }
            lbsManager.h(new com.tencent.biz.qqstory.model.lbs.a(b16.iLat, b16.iLon, b16.eType), eVar, new LbsManager.d() { // from class: com.tencent.aelight.camera.ae.camera.ui.poi.AESelectLocationFragment.4.1
                @Override // com.tencent.biz.qqstory.model.lbs.LbsManager.d
                public void a(final int i16, LbsManager.e eVar2, List<TroopBarPOI> list) {
                    final ArrayList arrayList = new ArrayList();
                    if (i16 == 0 && list != null) {
                        for (TroopBarPOI troopBarPOI : list) {
                            if (troopBarPOI != null) {
                                arrayList.add(new a.c(troopBarPOI.f293485f, 0));
                            }
                        }
                    }
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.poi.AESelectLocationFragment.4.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AESelectLocationFragment.this.J.setVisibility(8);
                            AESelectLocationFragment.this.D.setVisibility(0);
                            if (i16 == 0) {
                                AESelectLocationFragment.this.C.v(arrayList);
                            }
                        }
                    });
                }
            });
        }
    }

    private void initView(View view) {
        this.D = (RecyclerView) view.findViewById(R.id.s0_);
        this.E = view.findViewById(R.id.roj);
        this.F = (EditText) view.findViewById(R.id.s0f);
        this.H = (TextView) view.findViewById(R.id.s3g);
        this.G = view.findViewById(R.id.rrq);
        this.I = (ImageView) view.findViewById(R.id.f163738rr0);
        this.J = (ProgressBar) view.findViewById(R.id.rsw);
        this.I.setOnClickListener(this);
        this.G.setOnClickListener(this);
        this.E.setOnClickListener(this);
        this.F.addTextChangedListener(this);
        if (this.D == null) {
            ms.a.a("AESelectLocationFragment", "mRecycleView is null ");
            return;
        }
        this.D.setLayoutManager(new LinearLayoutManager(getBaseActivity(), 1, false));
        com.tencent.aelight.camera.ae.camera.ui.poi.a aVar = new com.tencent.aelight.camera.ae.camera.ui.poi.a(getBaseActivity());
        this.C = aVar;
        this.D.setAdapter(aVar);
        this.C.u(new b());
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.dl9, viewGroup, false);
        initView(inflate);
        ViewCompat.setOnApplyWindowInsetsListener(inflate, new a());
        ViewCompat.requestApplyInsets(inflate);
        return inflate;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
    }
}
