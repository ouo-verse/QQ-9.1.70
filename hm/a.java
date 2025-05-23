package hm;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.qzone.album.util.o;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.ak;
import com.qzone.feed.utils.h;
import com.qzone.publish.ui.activity.QZonePublishMoodNewStyleActivity;
import com.qzone.reborn.base.k;
import com.qzone.reborn.configx.g;
import com.qzone.util.ar;
import com.qzone.widget.dynamicgridview.DynamicArrayList;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.kuikly.core.render.android.expand.module.l;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyRouter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.widget.Switch;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.ugcsetting.UgcSettingUtil;
import cooperation.qzone.widget.RoundCornerLinearLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
import s8.f;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a extends k implements View.OnClickListener {
    protected ImageView C;
    protected View D;
    protected TextView E;
    private ImageView F;
    protected View G;
    protected TextView H;
    protected ImageView I;
    public String K;
    public String L;
    protected View M;
    protected TextView N;
    public Switch P;
    private SimpleDateFormat Q;

    /* renamed from: d, reason: collision with root package name */
    private final QZonePublishMoodNewStyleActivity f405263d;

    /* renamed from: e, reason: collision with root package name */
    private gm.c f405264e;

    /* renamed from: f, reason: collision with root package name */
    private hm.b f405265f;

    /* renamed from: h, reason: collision with root package name */
    private fm.b f405266h;

    /* renamed from: i, reason: collision with root package name */
    private View f405267i;

    /* renamed from: m, reason: collision with root package name */
    protected Switch f405268m;
    protected String J = h.f(1);
    private final BroadcastReceiver R = new C10452a();

    /* compiled from: P */
    /* renamed from: hm.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    class C10452a extends BroadcastReceiver {
        C10452a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String a16 = l.a(intent);
            if (TextUtils.isEmpty(a16) || !a16.equals("qzone_mood_time_setting_complete")) {
                return;
            }
            JSONObject b16 = l.b(intent);
            try {
                a.this.R9(b16.getLong("publish_time") / 1000, b16.getLong("schedule_delete"));
            } catch (JSONException e16) {
                RFWLog.e("QZonePublishMoodSettingPart", RFWLog.USR, e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class b implements CompoundButton.OnCheckedChangeListener {
        b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            if (z16) {
                a.this.f405265f.a2().postValue(1);
                LpReportInfo_pf00064.allReport(586, 47, 2);
            } else {
                a.this.f405265f.a2().postValue(0);
            }
            a.this.f405265f.Q1().postValue(Boolean.valueOf(z16));
            a aVar = a.this;
            aVar.da(aVar.f405268m, Boolean.valueOf(z16));
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class c implements CompoundButton.OnCheckedChangeListener {
        c() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            if (!a.this.M9() && z16) {
                a.this.P.setChecked(false);
                a.this.ea();
            } else {
                a.this.f405265f.S1().postValue(Boolean.valueOf(z16));
            }
            a.this.f405264e.g2(a.this.P.isChecked());
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            a.this.ba("an_yuanshipin");
        }
    }

    public a(QZonePublishMoodNewStyleActivity qZonePublishMoodNewStyleActivity) {
        this.f405263d = qZonePublishMoodNewStyleActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean M9() {
        return LoginData.getInstance().isQzoneVip();
    }

    private long N9() {
        String str;
        if (getActivity() != null && getActivity().getIntent() != null) {
            str = getActivity().getIntent().getStringExtra("postDate");
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        return o.b(str, 0L);
    }

    private int O9(int i3) {
        if (i3 != 4) {
            if (i3 != 16) {
                if (i3 != 64) {
                    if (i3 == 128) {
                        return 4;
                    }
                    return 0;
                }
                return 2;
            }
            return 3;
        }
        return 1;
    }

    private String P9(long j3) {
        try {
            if (this.Q == null) {
                this.Q = new SimpleDateFormat("MM\u6708dd\u65e5 HH:mm\u53d1\u8868", Locale.getDefault());
            }
            return this.Q.format(Long.valueOf(j3));
        } catch (Exception e16) {
            RFWLog.e("QZonePublishMoodSettingPart", RFWLog.USR, e16);
            return "";
        }
    }

    private void W9() {
        Long value = this.f405265f.Z1().getValue();
        long j3 = 0;
        long longValue = value != null ? value.longValue() * 1000 : 0L;
        Long value2 = this.f405265f.X1().getValue();
        if (value2 != null && value2.longValue() > 0) {
            j3 = 1;
        }
        ((IQQKuiklyRouter) QRoute.api(IQQKuiklyRouter.class)).jump(BaseApplication.getContext().getApplicationContext(), String.format("mqqapi://kuikly/open?src_type=app&version=1&local_bundle_name=nearbypro&bottom_nav_bar_immersive=1&use_host_display_metrics=1&page_name=qzone_mood_time&publish_time=%d&schedule_delete=%d", Long.valueOf(longValue), Long.valueOf(j3)));
    }

    private void X9() {
        com.qzone.misc.network.report.b.f(this.f405266h.P1());
        Bundle bundle = new Bundle();
        int U1 = this.f405265f.U1();
        ArrayList<String> value = this.f405265f.W1().getValue();
        bundle.putInt(UgcSettingUtil.KEY_PERMISSION_CODE, U1);
        if (value != null && value.size() > 0) {
            bundle.putStringArrayList("uin_list", value);
            ArrayList<String> arrayList = new ArrayList<>(value.size());
            Iterator<String> it = value.iterator();
            while (it.hasNext()) {
                arrayList.add(f.f().g(it.next()));
            }
            bundle.putStringArrayList(UgcSettingUtil.KEY_NICKNAMES, arrayList);
        }
        if (h.h(U1) && !TextUtils.isEmpty(this.K)) {
            bundle.putString(UgcSettingUtil.KEY_UGC_SETTING_RAW_JSON, this.K);
        }
        yo.d.k(this.f405263d.getActivity(), yo.f.j(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_UGC_PERMIT_SETTING, "https://h5.qzone.qq.com/ugc/setting?_wv=3&type={type}&uin={uin}&qua={qua}"), "{type}", "mood"), com.qzone.publish.ui.model.b.f51928b, bundle, null, null);
    }

    private void Y9() {
        com.qzone.misc.network.report.b.g(this.f405266h.P1());
        this.f405263d.fk(false);
        if (g.f53821a.b().R()) {
            W9();
            return;
        }
        Intent C = ak.C(this.f405263d.getActivity());
        C.putExtra("SchedualPublishTime", this.f405265f.Z1().getValue());
        C.putExtra("SchedualDeleteTime", this.f405265f.X1().getValue());
        C.putExtra("VideoSelected", this.f405264e.W1());
        this.f405263d.startActivityForResult(C, 6004);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa(ArrayList<String> arrayList) {
        boolean W1 = this.f405264e.W1();
        ga(arrayList, W1);
        ha(W1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba(String str) {
        ak.Q(this.f405263d.getActivity(), ak.r(this.f405263d.getActivity(), str, BaseApplication.getContext().getResources().getString(R.string.gln), false, LoginData.getInstance().getUin(), LoginData.getInstance().isQzoneVip()), 999);
    }

    private void ca() {
        this.f405264e.S1().observeForever(new e());
        l.c(BaseApplication.getContext().getApplicationContext(), this.R);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void da(View view, Boolean bool) {
        String str;
        HashMap hashMap = new HashMap();
        if (bool.booleanValue()) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("after_switch_state", str);
        fo.b l3 = new fo.b().l(hashMap);
        l3.g(ClickPolicy.REPORT_NONE);
        fo.c.b("dt_clck", view, "em_qz_long_pic_switch", l3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ea() {
        QZoneHelper.showQzoneVipOriginalVideoDialog(this.f405263d.getActivity(), new d());
    }

    private void ga(ArrayList<String> arrayList, boolean z16) {
        if (this.f405267i == null) {
            return;
        }
        if (arrayList != null && arrayList.size() >= 3 && !z16 && L9()) {
            this.f405267i.setVisibility(0);
            LpReportInfo_pf00064.allReport(586, 47, 1);
        } else {
            this.f405267i.setVisibility(8);
        }
    }

    public boolean K9() {
        return (this.f405266h.T1() || this.f405266h.S1()) ? false : true;
    }

    public boolean L9() {
        return !this.f405266h.T1();
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZonePublishMoodSettingPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        super.handleBroadcastMessage(str, obj);
        if (TextUtils.equals(str, "set_permission_public")) {
            this.f405265f.T1().setValue(1);
            this.f405265f.T1().postValue(1);
            Z9(1);
        } else if (TextUtils.equals(str, "long_pic_check_box_toggle")) {
            this.f405268m.setChecked(((Boolean) obj).booleanValue());
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (intent == null) {
            QZLog.e("QZonePublishMoodSettingPart", "onActivityResult data is null");
            return;
        }
        if (i3 == com.qzone.publish.ui.model.b.f51928b) {
            Q9(intent);
            return;
        }
        if (i3 == 6004) {
            if (i16 == -1) {
                R9(intent.getLongExtra("SchedualPublishTime", 0L), intent.getLongExtra("SchedualDeleteTime", 0L));
            }
        } else if (i16 == 2) {
            int intExtra = intent.getIntExtra(PeakConstants.KEY_SHOW_TYPE, 0);
            Switch r65 = this.f405268m;
            if (r65 != null) {
                r65.setChecked(intExtra == 1);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.D) {
            Y9();
        } else if (view == this.G) {
            X9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        View findViewById = view.findViewById(R.id.f69263i_);
        ((RoundCornerLinearLayout) findViewById.findViewById(R.id.f69253i9)).setRadius(ar.d(8.0f));
        findViewById.setVisibility(0);
        S9(findViewById);
        U9(findViewById);
        V9(findViewById);
        T9(findViewById);
        ca();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Switch r06 = this.f405268m;
        if (r06 != null) {
            r06.setChecked(intent.getIntExtra(PeakConstants.KEY_SHOW_ORIGIN_TYPE, 0) == 1);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        this.f405264e = (gm.c) getViewModel(gm.c.class);
        this.f405265f = (hm.b) getViewModel(hm.b.class);
        this.f405266h = (fm.b) getViewModel(fm.b.class);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        l.f(BaseApplication.getContext().getApplicationContext(), this.R);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class e implements Observer<DynamicArrayList<String>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: hm.a$e$a, reason: collision with other inner class name */
        /* loaded from: classes38.dex */
        public class C10453a implements Observer<ArrayList<String>> {
            C10453a() {
            }

            @Override // androidx.lifecycle.Observer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onChanged(ArrayList<String> arrayList) {
                a.this.aa(arrayList);
            }
        }

        e() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(DynamicArrayList<String> dynamicArrayList) {
            if (dynamicArrayList == null) {
                return;
            }
            dynamicArrayList.getLiveData().observeForever(new C10453a());
        }
    }

    private void ha(boolean z16) {
        if (z16) {
            View view = this.M;
            if (view != null) {
                view.setVisibility(0);
                this.f405263d.Oq();
                return;
            }
            return;
        }
        View view2 = this.M;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    public void Z9(int i3) {
        LpReportInfo_pf00064.allReport(586, 60, O9(i3));
        if (h.h(i3) && !TextUtils.isEmpty(this.L)) {
            this.J = this.L;
        } else {
            this.J = h.f(i3);
        }
        String replace = this.J.replace(",", "\u3001");
        this.J = replace;
        this.H.setText(replace);
        this.f405265f.F.postValue(Integer.valueOf(i3));
        QLog.d("QZonePublishMoodSettingPart", 1, "onPermissionChange  mPermissionDesc = " + this.J);
    }

    private void Q9(Intent intent) {
        if (intent == null) {
            return;
        }
        Bundle extras = intent.getExtras();
        int U1 = this.f405265f.U1();
        if (extras.containsKey(UgcSettingUtil.KEY_PERMISSION_CODE)) {
            U1 = extras.getInt(UgcSettingUtil.KEY_PERMISSION_CODE, 1);
        }
        if (extras.containsKey("uin_list")) {
            ArrayList<String> stringArrayList = extras.getStringArrayList("uin_list");
            if (stringArrayList == null) {
                stringArrayList = new ArrayList<>();
            }
            this.f405265f.W1().postValue(stringArrayList);
        }
        if (h.h(U1)) {
            this.K = extras.getString(UgcSettingUtil.KEY_UGC_SETTING_RAW_JSON);
            this.L = extras.getString(UgcSettingUtil.KEY_TAG_INFO);
        }
        this.f405265f.T1().postValue(Integer.valueOf(U1));
        Z9(U1);
    }

    private void S9(View view) {
        this.f405267i = view.findViewById(R.id.f68753gw);
        this.f405268m = (Switch) view.findViewById(R.id.f68763gx);
        ImageView imageView = (ImageView) view.findViewById(R.id.f68743gv);
        this.C = imageView;
        s5.a.a(imageView, fd.a.f398307f);
        this.f405268m.setOnCheckedChangeListener(new b());
        this.f405268m.setChecked(u5.b.R("_shuoshuo", LoginData.getInstance().getUin()) == 1);
    }

    private void T9(View view) {
        this.M = view.findViewById(R.id.ktc);
        this.N = (TextView) view.findViewById(R.id.kte);
        Switch r26 = (Switch) view.findViewById(R.id.ktd);
        this.P = r26;
        r26.setOnCheckedChangeListener(new c());
    }

    private void U9(View view) {
        View findViewById = view.findViewById(R.id.f68973hh);
        this.G = findViewById;
        fo.c.n(findViewById, "em_qz_permission_set");
        this.G.setOnClickListener(this);
        this.H = (TextView) view.findViewById(R.id.f68923hc);
        ImageView imageView = (ImageView) view.findViewById(R.id.f68963hg);
        this.I = imageView;
        s5.a.a(imageView, fd.a.f398307f);
        long uin = LoginData.getInstance().getUin();
        int U = u5.b.U("_shuoshuo", uin);
        ArrayList<String> V = u5.b.V("_shuoshuo", uin);
        this.f405265f.T1().postValue(Integer.valueOf(U));
        this.f405265f.W1().postValue(V);
        Z9(U);
    }

    private void V9(View view) {
        View findViewById = view.findViewById(R.id.f69853jv);
        this.D = findViewById;
        fo.c.n(findViewById, "em_qz_timing_set");
        this.E = (TextView) view.findViewById(R.id.f69873jx);
        this.F = (ImageView) view.findViewById(R.id.f69833jt);
        this.D.setOnClickListener(this);
        s5.a.a(this.F, fd.a.f398307f);
        if (!K9()) {
            this.D.setVisibility(8);
            return;
        }
        long uin = LoginData.getInstance().getUin();
        long N9 = N9();
        if (N9 == 0) {
            N9 = u5.b.Z("key_shuoshuo_timer", uin);
        }
        R9(N9, 0L);
        this.D.setVisibility(0);
        QZonePublishMoodNewStyleActivity.zq(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R9(long j3, long j16) {
        String a16;
        if (j3 < 0) {
            j3 = 0;
        }
        this.f405265f.Z1().postValue(Long.valueOf(j3));
        this.f405265f.X1().postValue(Long.valueOf(j16));
        if (j3 > 0) {
            if (j16 > 0) {
                a16 = com.qzone.util.l.a(R.string.f172570s64);
            } else {
                a16 = P9(j3 * 1000);
                if (TextUtils.isEmpty(a16)) {
                    a16 = com.qzone.util.l.a(R.string.s6i);
                }
            }
        } else if (j16 > 0) {
            a16 = com.qzone.util.l.a(R.string.f172566s60);
        } else {
            a16 = com.qzone.util.l.a(R.string.s5l);
        }
        this.E.setText(a16);
    }
}
