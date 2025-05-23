package com.tencent.gdtad.api.motivevideo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.ad.tangram.AdSettings;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dynamic.IDynamicApi;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAdLoader;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoParams;
import com.tencent.gdtad.basics.motivevideo.data.StartGdtMotiveVideoParams;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.util.GdtUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtDemoMvFragment extends QPublicBaseFragment implements View.OnClickListener {

    @NonNull
    private List<qq_ad_get.QQAdGetRsp.AdInfo> C = new LinkedList();
    private final Handler D;
    private final ResultReceiver E;

    @NonNull
    private final HashMap<Integer, String> F;

    @NonNull
    private final GdtAdLoader.Listener G;
    private CheckBox H;
    private CheckBox I;
    private CheckBox J;
    private CheckBox K;
    private EditText L;
    private EditText M;
    private EditText N;
    private EditText P;
    private TextView Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private boolean U;
    private long V;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements GdtAdLoader.Listener {
        a() {
        }

        @Override // com.tencent.gdtad.aditem.GdtAdLoader.Listener
        public void onResponse(@NonNull GdtAdLoader gdtAdLoader) {
            List<qq_ad_get.QQAdGetRsp.AdInfo> linkedList = new LinkedList<>();
            if (gdtAdLoader.getSession() != null && gdtAdLoader.getSession().response != null && gdtAdLoader.getSession().response.ret.get() == 0 && gdtAdLoader.getSession().response.pos_ads_info.size() > 0 && gdtAdLoader.getSession().response.pos_ads_info.get(0).ret.get() == 0 && gdtAdLoader.getSession().response.pos_ads_info.get(0).ads_info.size() > 0) {
                linkedList = gdtAdLoader.getSession().response.pos_ads_info.get(0).ads_info.get();
            }
            GdtDemoMvFragment.this.Bh(linkedList);
        }
    }

    public GdtDemoMvFragment() {
        Handler handler = new Handler(Looper.getMainLooper());
        this.D = handler;
        this.E = new ResultReceiver(handler) { // from class: com.tencent.gdtad.api.motivevideo.GdtDemoMvFragment.1
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int i3, Bundle bundle) {
                super.onReceiveResult(i3, bundle);
                GdtDemoMvFragment.this.th(bundle);
                GdtDemoMvFragment.this.Ch(1);
            }
        };
        this.F = new HashMap<>();
        this.G = new a();
        this.V = 0L;
    }

    private void Ah(qq_ad_get.QQAdGetRsp.AdInfo adInfo) {
        int i3;
        qq_ad_get.QQAdGetRsp.AdInfo.Ext vh5 = vh(adInfo);
        if (vh5 == null) {
            return;
        }
        PBUInt32Field pBUInt32Field = vh5.disbale_dialog_before_reward;
        if (this.K.isChecked()) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        pBUInt32Field.set(i3);
        Fh(adInfo, vh5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ch(int i3) {
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity != null) {
            qBaseActivity.setRequestedOrientation(i3);
        }
    }

    private void Dh(@Nullable qq_ad_get.QQAdGetRsp.AdInfo adInfo) {
        List<qq_ad_get.QQAdGetRsp.AdInfo.ExpParam> expMap;
        this.F.clear();
        if (adInfo == null || (expMap = new GdtAd(adInfo).getExpMap()) == null) {
            return;
        }
        for (qq_ad_get.QQAdGetRsp.AdInfo.ExpParam expParam : expMap) {
            if (expParam != null) {
                this.F.put(Integer.valueOf(expParam.key.get()), expParam.value.get());
            }
        }
    }

    private void Eh(@Nullable qq_ad_get.QQAdGetRsp.AdInfo adInfo, int i3) {
        if (adInfo == null) {
            return;
        }
        qq_ad_get.QQAdGetRsp.AdInfo.RewardInfo.PassThroughData passThroughData = new qq_ad_get.QQAdGetRsp.AdInfo.RewardInfo.PassThroughData();
        passThroughData.reward_type.set(i3);
        Object pbToJson = GdtJsonPbUtil.pbToJson(passThroughData);
        if (pbToJson instanceof JSONObject) {
            adInfo.reward_info.pass_through_data.set(pbToJson.toString());
        }
        adInfo.dynamic_info.module_id.set(DKEngine.DKModuleID.PCAD_REWARD);
        adInfo.dynamic_info.template_id.set("qq-reward-click");
        adInfo.dynamic_info.hippy_type.set(4);
        adInfo.reward_info.reward_time.set(3);
        adInfo.reward_info.render_type.set(2);
    }

    private static void Fh(qq_ad_get.QQAdGetRsp.AdInfo adInfo, qq_ad_get.QQAdGetRsp.AdInfo.Ext ext) {
        if (adInfo != null && ext != null) {
            adInfo.ext.set(ext);
            Object pbToJson = GdtJsonPbUtil.pbToJson(ext);
            if (pbToJson != null) {
                adInfo.ext_json.set(pbToJson.toString());
                return;
            }
            return;
        }
        GdtLog.e("GdtDemoMvFragment", "setExtAndExtJson error");
    }

    private void Gh(@Nullable GdtMotiveVideoPageData gdtMotiveVideoPageData) {
        if (gdtMotiveVideoPageData == null) {
            return;
        }
        gdtMotiveVideoPageData.antiSpamParams = "{\"lt\":2,\"ig\":0}";
        qq_ad_get.QQAdGetRsp.AdInfo Jh = Jh(gdtMotiveVideoPageData.adsContent);
        if (Jh == null) {
            QLog.e("GdtDemoMvFragment", 4, "[setPageDataUIParams] adInfo is null");
            return;
        }
        if (this.I.isChecked() && !TextUtils.isEmpty(this.L.getText())) {
            this.F.put(Integer.valueOf(GdtAd.EXP_KEY_EXPERIMENT), this.L.getText().toString());
        }
        if (this.J.isChecked()) {
            this.F.put(Integer.valueOf(GdtAd.EXP_KEY_MOTIVE_VIDEO_FEEDBACK_STYLE), "1");
        }
        yh(Jh);
        Ah(Jh);
        gdtMotiveVideoPageData.adsContent = rh(Jh);
    }

    private static void Ih(@Nullable Activity activity, Class<? extends QPublicBaseFragment> cls, @Nullable Bundle bundle) {
        if (activity != null && bundle != null) {
            GdtLog.i("GdtDemoMvFragment", "start");
            Intent intent = new Intent();
            intent.putExtra("public_fragment_window_feature", 1);
            intent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
            intent.putExtras(bundle);
            QPublicFragmentActivity.start(activity, intent, cls);
            return;
        }
        GdtLog.i("GdtDemoMvFragment", "start error");
    }

    @Nullable
    private qq_ad_get.QQAdGetRsp.AdInfo Jh(@NonNull String str) {
        try {
            return (qq_ad_get.QQAdGetRsp.AdInfo) GdtJsonPbUtil.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject(str));
        } catch (JSONException e16) {
            GdtLog.e("GdtDemoMvFragment", "setPageDataUIParams", e16);
            return null;
        }
    }

    private void Kh() {
        StringBuilder sb5 = new StringBuilder();
        Iterator<Integer> it = this.F.keySet().iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            sb5.append(String.format(Locale.ENGLISH, "%d : %s\n", Integer.valueOf(intValue), this.F.get(Integer.valueOf(intValue))));
        }
        this.Q.setText(sb5.toString());
    }

    @NonNull
    private String rh(qq_ad_get.QQAdGetRsp.AdInfo adInfo) {
        Object pbToJson = GdtJsonPbUtil.pbToJson(adInfo);
        if (pbToJson != null && !JSONObject.NULL.equals(pbToJson)) {
            return pbToJson.toString();
        }
        return "";
    }

    public static void start(Activity activity, Class<? extends QPublicBaseFragment> cls) {
        Ih(activity, cls, new Bundle());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void th(Bundle bundle) {
        if (bundle == null) {
            Hh("fail to get reward information");
            AdLog.e("GdtDemoMvFragment", "[GdtDemoMvFragment.java][decodeResult] bundle is error");
        } else {
            Hh(String.format(Locale.ENGLISH, "canBeRewarded: %b", Boolean.valueOf(bundle.getBoolean("profitable_flag"))));
        }
    }

    @NonNull
    public static GdtHandler.Params uh(boolean z16, WeakReference<Activity> weakReference) {
        GdtHandler.Params params = new GdtHandler.Params();
        params.processId = 1;
        params.activity = weakReference;
        params.reportForClick = z16;
        return params;
    }

    @Nullable
    private static qq_ad_get.QQAdGetRsp.AdInfo.Ext vh(qq_ad_get.QQAdGetRsp.AdInfo adInfo) {
        try {
            return (qq_ad_get.QQAdGetRsp.AdInfo.Ext) GdtJsonPbUtil.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo.Ext(), new JSONObject(adInfo.ext_json.get()));
        } catch (Throwable th5) {
            QLog.e("GdtDemoMvFragment", 4, "[getExtFromExtJson]", th5);
            return null;
        }
    }

    private void wh() {
        DKEngine.setDebug(this.S);
        if (this.T) {
            DKConfiguration.setBundleConfigUrl("https://ttc.gdt.qq.com/style_factory/module_list");
        }
        if (this.U) {
            DKConfiguration.setTemplateServiceConfigUrl("https://ttc.gdt.qq.com/style_factory");
        }
        if (this.S || this.T || this.U) {
            ((IDynamicApi) QRoute.api(IDynamicApi.class)).initDynamicSDK();
        }
    }

    private void yh(@Nullable qq_ad_get.QQAdGetRsp.AdInfo adInfo) {
        if (adInfo == null) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        Iterator<Integer> it = this.F.keySet().iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            qq_ad_get.QQAdGetRsp.AdInfo.ExpParam expParam = new qq_ad_get.QQAdGetRsp.AdInfo.ExpParam();
            expParam.key.set(intValue);
            expParam.value.set(this.F.get(Integer.valueOf(intValue)));
            linkedList.add(expParam);
        }
        qq_ad_get.QQAdGetRsp.AdInfo.Ext vh5 = vh(adInfo);
        if (vh5 != null) {
            vh5.exp_map.set(linkedList);
        }
        Fh(adInfo, vh5);
    }

    @Nullable
    private GdtMotiveVideoPageData zh(@Nullable qq_ad_get.QQAdGetRsp.AdInfo adInfo, int i3, boolean z16, boolean z17) {
        if (adInfo == null) {
            QLog.e("GdtDemoMvFragment", 4, "[mockPageData] error");
            return null;
        }
        if (z17) {
            Eh(adInfo, 2);
        } else {
            Eh(adInfo, Integer.MIN_VALUE);
        }
        GdtMotiveVideoPageData createMVPageData = GdtUtil.createMVPageData(adInfo, i3);
        if (this.H.isChecked() && createMVPageData != null) {
            createMVPageData.containerType = 1;
        }
        if (!z16) {
            Gh(createMVPageData);
        }
        return createMVPageData;
    }

    public void Bh(@Nullable List<qq_ad_get.QQAdGetRsp.AdInfo> list) {
        if (list != null && !list.isEmpty()) {
            this.C = list;
            Dh(list.get(0));
            Kh();
            Hh("\u6570\u636e\u52a0\u8f7d\u6210\u529f!");
        }
    }

    public void Hh(final CharSequence charSequence) {
        getQBaseActivity().runOnUiThread(new Runnable() { // from class: com.tencent.gdtad.api.motivevideo.GdtDemoMvFragment.3
            @Override // java.lang.Runnable
            public void run() {
                QQToast.makeText(GdtDemoMvFragment.this.getContext(), charSequence, 0).show();
            }
        });
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(@Nullable Activity activity) {
        super.initWindowStyleAndAnimation(activity);
        if (activity == null) {
            return;
        }
        activity.setRequestedOrientation(1);
        activity.getWindow().addFlags(1024);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, @Nullable Intent intent) {
        if (intent != null && i16 == -1) {
            if (i3 == 101) {
                Bundle extras = intent.getExtras();
                if (extras == null) {
                    GdtLog.e("GdtDemoMvFragment", "onActivityResult b==null ");
                    return;
                }
                th(extras);
            } else if (i3 == 102) {
                this.R = intent.getBooleanExtra("isDynamic", false);
                this.S = intent.getBooleanExtra("isHippyTest", false);
                this.T = intent.getBooleanExtra("isJsBundleTest", false);
                this.U = intent.getBooleanExtra("isModeTest", false);
            }
        }
        Ch(1);
        super.onActivityResult(i3, i16, intent);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x014c  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(@NonNull View view) {
        int parseInt;
        int parseInt2;
        String obj;
        boolean z16;
        boolean z17;
        int i3;
        qq_ad_get.QQAdGetRsp.AdInfo adInfo;
        EventCollector.getInstance().onViewClickedBefore(view);
        QLog.e("GdtDemoMvFragment", 4, "[onClick]");
        int id5 = view.getId();
        if (SystemClock.uptimeMillis() - this.V >= 600) {
            this.V = SystemClock.uptimeMillis();
            if (this.C.isEmpty() && id5 != R.id.tf_ && id5 != R.id.th_ && id5 != R.id.tfa) {
                Hh("\u8bf7\u5148\u52a0\u8f7d\u5e7f\u544a\u6570\u636e");
            } else {
                int i16 = Integer.MIN_VALUE;
                if (id5 == R.id.tf_) {
                    xh();
                } else if (id5 == R.id.tfa) {
                    Hh("\u529f\u80fd\u5f85\u5b8c\u5584");
                } else if (id5 == R.id.th_) {
                    AdSettings.setTestMode(!AdSettings.isTestMode());
                    Button button = (Button) view;
                    if (AdSettings.isTestMode()) {
                        i3 = R.string.f13786080;
                    } else {
                        i3 = R.string.f1378507z;
                    }
                    button.setText(i3);
                } else {
                    if (id5 == R.id.tgz) {
                        z17 = true;
                        z16 = true;
                        i16 = 1;
                    } else if (id5 == R.id.tgw) {
                        i16 = 0;
                        z17 = true;
                        z16 = z17;
                    } else if (id5 == R.id.tgy) {
                        z16 = false;
                        z17 = true;
                        i16 = 1;
                    } else if (id5 == R.id.tgv) {
                        z16 = false;
                        i16 = 0;
                        z17 = true;
                    } else if (id5 == R.id.tck) {
                        if (TextUtils.isEmpty(this.M.getText())) {
                            parseInt2 = Integer.MIN_VALUE;
                        } else {
                            parseInt2 = Integer.parseInt(this.M.getText().toString());
                        }
                        if (TextUtils.isEmpty(this.N.getText())) {
                            obj = "";
                        } else {
                            obj = this.N.getText().toString();
                        }
                        if (parseInt2 != Integer.MIN_VALUE && !TextUtils.isEmpty(obj)) {
                            this.F.put(Integer.valueOf(parseInt2), obj);
                        }
                    } else if (id5 == R.id.tgd) {
                        if (TextUtils.isEmpty(this.M.getText())) {
                            parseInt = Integer.MIN_VALUE;
                        } else {
                            parseInt = Integer.parseInt(this.M.getText().toString());
                        }
                        if (parseInt != Integer.MIN_VALUE) {
                            this.F.remove(Integer.valueOf(parseInt));
                        }
                    } else if (id5 == R.id.tgf) {
                        Dh(this.C.get(0));
                    } else if (id5 == R.id.ted) {
                        QPublicFragmentActivity.startForResult(this, (Class<? extends QPublicBaseFragment>) GdtMotiveDemoHippyConfigFragment.class, 102);
                    } else {
                        Hh("cannot handle this click event");
                        QLog.e("GdtDemoMvFragment", 4, "[onClick] cannot handle");
                    }
                    if (z17) {
                        qq_ad_get.QQAdGetRsp.AdInfo adInfo2 = this.C.get(0);
                        if (this.C.size() > 1) {
                            adInfo = this.C.get(1);
                        } else {
                            adInfo = null;
                        }
                        GdtMotiveVideoPageData zh5 = zh(adInfo2, i16, z16, this.R);
                        GdtMotiveVideoPageData zh6 = zh(adInfo, i16, z16, this.R);
                        if (zh5 != null) {
                            StartGdtMotiveVideoParams build = StartGdtMotiveVideoParams.build(getQBaseActivity(), zh5);
                            build.secondVideoData = zh6;
                            build.resultReceiver = this.E;
                            wh();
                            Ch(i16);
                            ((IGdtAPI) QRoute.api(IGdtAPI.class)).startGdtMotiveVideo(build);
                        }
                    }
                    Kh();
                }
                z17 = false;
                z16 = z17;
                if (z17) {
                }
                Kh();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.f167999oo, viewGroup, false);
        inflate.findViewById(R.id.tf_).setOnClickListener(this);
        inflate.findViewById(R.id.th_).setOnClickListener(this);
        inflate.findViewById(R.id.tgz).setOnClickListener(this);
        inflate.findViewById(R.id.tgw).setOnClickListener(this);
        inflate.findViewById(R.id.tgy).setOnClickListener(this);
        inflate.findViewById(R.id.tgv).setOnClickListener(this);
        inflate.findViewById(R.id.tck).setOnClickListener(this);
        inflate.findViewById(R.id.tgd).setOnClickListener(this);
        inflate.findViewById(R.id.tgf).setOnClickListener(this);
        inflate.findViewById(R.id.tfa).setOnClickListener(this);
        inflate.findViewById(R.id.ted).setOnClickListener(this);
        this.H = (CheckBox) inflate.findViewById(R.id.tpu);
        this.I = (CheckBox) inflate.findViewById(R.id.tpt);
        this.L = (EditText) inflate.findViewById(R.id.ux5);
        this.M = (EditText) inflate.findViewById(R.id.ux7);
        this.N = (EditText) inflate.findViewById(R.id.ux8);
        this.P = (EditText) inflate.findViewById(R.id.f165110ux3);
        this.J = (CheckBox) inflate.findViewById(R.id.tpd);
        this.Q = (TextView) inflate.findViewById(R.id.f107806be);
        this.K = (CheckBox) inflate.findViewById(R.id.tpe);
        AdSettings.setTestMode(false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @NonNull
    public qq_ad_get.QQAdGet sh(long j3, String str) {
        qq_ad_get.QQAdGet.PositionInfo.PositionExt positionExt = new qq_ad_get.QQAdGet.PositionInfo.PositionExt();
        positionExt.deep_link_version.set(1);
        qq_ad_get.QQAdGet.PositionInfo positionInfo = new qq_ad_get.QQAdGet.PositionInfo();
        positionInfo.pos_id.set(str);
        positionInfo.ad_count.set(2);
        positionInfo.pos_ext.set(positionExt);
        qq_ad_get.QQAdGet.UserInfo userInfo = new qq_ad_get.QQAdGet.UserInfo();
        userInfo.f435899qq.set(j3);
        qq_ad_get.QQAdGet qQAdGet = new qq_ad_get.QQAdGet();
        qQAdGet.position_info.add(positionInfo);
        qQAdGet.user_info.set(userInfo);
        return qQAdGet;
    }

    public void xh() {
        String charSequence;
        if (QLog.isColorLevel()) {
            QLog.d("GdtDemoMvFragment", 2, "[loadAdFromAms]");
        }
        GdtMotiveVideoParams gdtMotiveVideoParams = new GdtMotiveVideoParams();
        AppInterface appInterface = ((ICmGameHelper) QRoute.api(ICmGameHelper.class)).getAppInterface();
        if (appInterface == null) {
            return;
        }
        if (TextUtils.isEmpty(this.P.getHint())) {
            charSequence = "6020954314138204";
        } else {
            charSequence = this.P.getHint().toString();
        }
        if (!TextUtils.isEmpty(this.P.getText())) {
            charSequence = this.P.getText().toString();
        }
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity == null) {
            return;
        }
        gdtMotiveVideoParams.clickParams = uh(true, new WeakReference(qBaseActivity.getActivity()));
        GdtAdLoader.Session session = new GdtAdLoader.Session();
        session.request = sh(Long.parseLong(appInterface.getCurrentAccountUin()), charSequence);
        ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).loadAd(session, new WeakReference<>(this.G), new WeakReference<>(getContext()));
        Hh("\u5f00\u59cb\u52a0\u8f7d\u6570\u636e...");
    }
}
