package com.tencent.aelight.camera.ae.flashshow.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil;
import com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit;
import com.tencent.aelight.camera.ae.flashshow.dashboard.LSDashboardUtil;
import com.tencent.aelight.camera.ae.g;
import com.tencent.aelight.camera.ae.util.AECacheMonitor;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.qipc.api.IAECameraGetInfoServer;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.picker.Config;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.ScrollView;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.light.DebugUtils;
import org.light.device.OfflineConfig;
import org.light.utils.LightLogUtil;

/* loaded from: classes32.dex */
public class LSDashboardPart extends lq.a {
    private TextView C;
    private ScrollView D;
    private CheckBox E;
    private CheckBox F;
    private CheckBox G;
    private CheckBox H;
    private CheckBox I;
    private CheckBox J;
    private CheckBox K;
    private CheckBox L;
    private CheckBox M;
    private TextView N;
    private TextView P;
    private TextView Q;
    private TextView R;
    private CheckBox S;
    private TextView T;
    private RecyclerView U;
    private DashboardAdapter V;
    private RecyclerView W;
    private DashboardAdapter X;
    private RecyclerView Y;
    private DashboardAdapter Z;

    /* renamed from: a0, reason: collision with root package name */
    private RecyclerView f64652a0;

    /* renamed from: b0, reason: collision with root package name */
    private DashboardAdapter f64653b0;

    /* renamed from: c0, reason: collision with root package name */
    private EditText f64654c0;

    /* renamed from: d0, reason: collision with root package name */
    private TextView f64655d0;

    /* renamed from: e0, reason: collision with root package name */
    private TextView f64656e0;

    /* renamed from: f0, reason: collision with root package name */
    private Pattern f64657f0;

    /* renamed from: g0, reason: collision with root package name */
    private EditText f64658g0;

    /* renamed from: h0, reason: collision with root package name */
    private TextView f64659h0;

    /* renamed from: i0, reason: collision with root package name */
    private Dialog f64660i0;

    /* renamed from: m, reason: collision with root package name */
    private LSMiddleCameraUnit f64661m;

    /* renamed from: com.tencent.aelight.camera.ae.flashshow.ui.LSDashboardPart$6, reason: invalid class name */
    /* loaded from: classes32.dex */
    class AnonymousClass6 implements View.OnClickListener {
        AnonymousClass6() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            AECacheMonitor.g().o(new AECacheMonitor.c() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.LSDashboardPart.6.1
                @Override // com.tencent.aelight.camera.ae.util.AECacheMonitor.c
                public void a(long j3, HashMap<String, String> hashMap, final String str) {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.LSDashboardPart.6.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            LSDashboardPart.this.T.setText(str);
                        }
                    });
                }
            });
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes32.dex */
    public static class DashboardAdapter extends RecyclerView.Adapter<q> {

        /* renamed from: d, reason: collision with root package name */
        private Context f64683d;

        /* renamed from: e, reason: collision with root package name */
        private List<r> f64684e = new LinkedList();

        public DashboardAdapter(Context context) {
            this.f64683d = context;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f64684e.size();
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(q qVar, int i3) {
            qVar.b(this.f64684e.get(i3));
        }

        public void putData(List<r> list) {
            this.f64684e = list;
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.LSDashboardPart.DashboardAdapter.1
                @Override // java.lang.Runnable
                public void run() {
                    DashboardAdapter.this.notifyDataSetChanged();
                }
            });
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public q onCreateViewHolder(ViewGroup viewGroup, int i3) {
            return new q(LayoutInflater.from(this.f64683d).inflate(R.layout.dlg, viewGroup, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            LSDashboardPart.this.U.setVisibility(z16 ? 0 : 8);
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class b implements CompoundButton.OnCheckedChangeListener {
        b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            LSDashboardPart.this.W.setVisibility(z16 ? 0 : 8);
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class c implements CompoundButton.OnCheckedChangeListener {
        c() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            LSDashboardPart.this.Y.setVisibility(z16 ? 0 : 8);
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class d implements CompoundButton.OnCheckedChangeListener {
        d() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            LSDashboardPart.this.f64652a0.setVisibility(z16 ? 0 : 8);
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class e implements CompoundButton.OnCheckedChangeListener {
        e() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            AEDashboardUtil.w(z16);
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class f implements CompoundButton.OnCheckedChangeListener {
        f() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            AEDashboardUtil.u(z16);
            QQToast.makeText(BaseApplication.getContext(), "\u6740\u8fdb\u7a0b\u91cd\u65b0\u8fdb\u76f8\u673a", 0).show();
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class g implements CompoundButton.OnCheckedChangeListener {
        g() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            if (z16) {
                LightLogUtil.init();
            }
            LightLogUtil.setMinPriority(z16 ? 2 : 6);
            w53.a.e(z16 ? 2 : 5);
            AECameraPrefsUtil.f().l(AECameraConstants.SP_KEY_DEBUG_ENABLE_LIGHT_SDK_LOG, z16, 4);
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class h implements CompoundButton.OnCheckedChangeListener {
        h() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            tq.d.e(z16);
            QQToast.makeText(BaseApplication.getContext(), "\u91cd\u542f\u76f8\u673a\u6027\u80fd\u6570\u636e\u624d\u4f1a\u6536\u96c6", 0).show();
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class i implements CompoundButton.OnCheckedChangeListener {
        i() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            if (!new File("/sdcard/light_sdk_images").exists()) {
                new File("/sdcard/light_sdk_images").mkdirs();
            }
            DebugUtils.setImageDebugInfo(z16, "/sdcard/light_sdk_images", z16, z16, z16, z16, z16);
            ms.a.f("AEVideoStoryDashboardPart", "mLightImageCheckBox:" + z16);
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* loaded from: classes32.dex */
    class j implements View.OnClickListener {
        j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            LSDashboardPart.this.D.setVisibility(LSDashboardPart.this.D.getVisibility() == 0 ? 8 : 0);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes32.dex */
    class k implements View.OnClickListener {
        k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Editable text = LSDashboardPart.this.f64658g0.getText();
            if (!TextUtils.isEmpty(text)) {
                LSDashboardPart.this.f64658g0.setText("");
                for (String str : text.toString().trim().split("\\|")) {
                    String trim = str.trim();
                    if (!TextUtils.isEmpty(trim)) {
                        AECameraPrefsUtil.f().q(trim, 0);
                        AECameraPrefsUtil.f().q(trim, 4);
                        ms.a.a("AEVideoStoryDashboardPart", "clear sp: " + trim);
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes32.dex */
    class l implements View.OnClickListener {
        l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            com.tencent.mobileqq.wink.picker.g.f324860a.h(((lq.a) LSDashboardPart.this).f415377f, 1030, WinkContext.INSTANCE.d().getTraceId(), new Config.a().a());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class m implements CompoundButton.OnCheckedChangeListener {

        /* loaded from: classes32.dex */
        class a implements Observer<Boolean> {
            a() {
            }

            @Override // androidx.lifecycle.Observer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onChanged(Boolean bool) {
                LSDashboardPart.this.J(false);
            }
        }

        m() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            List<com.tencent.aelight.camera.ae.flashshow.autotest.g> f16;
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            if (com.tencent.aelight.camera.ae.flashshow.autotest.b.f64151q && (f16 = com.tencent.aelight.camera.ae.flashshow.autotest.i.d().c().f()) != null && !f16.isEmpty()) {
                com.tencent.aelight.camera.ae.flashshow.autotest.b.f64152r = z16;
                if (z16) {
                    com.tencent.aelight.camera.ae.flashshow.autotest.i.d().c().i().observe(LSDashboardPart.this.f64661m, new a());
                    LSDashboardPart.this.J(true);
                }
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class n implements View.OnClickListener {
        n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            LSDashboardPart.this.f64654c0.setText("");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class o implements View.OnClickListener {
        o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Editable text = LSDashboardPart.this.f64654c0.getText();
            if (!TextUtils.isEmpty(text)) {
                LSDashboardPart.this.E(text.toString());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes32.dex */
    public static class p extends ViewModel {

        /* renamed from: i, reason: collision with root package name */
        public final MutableLiveData<String> f64701i = new MutableLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes32.dex */
    public static class q extends RecyclerView.ViewHolder {

        /* renamed from: d, reason: collision with root package name */
        private TextView f64702d;

        public q(View view) {
            super(view);
            this.f64702d = (TextView) view.findViewById(R.id.f163715rm2);
        }

        public void b(r rVar) {
            this.f64702d.setText(rVar.f64703a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes32.dex */
    public static class r {

        /* renamed from: a, reason: collision with root package name */
        public CharSequence f64703a;

        r() {
        }
    }

    /* loaded from: classes32.dex */
    public interface s {
        void b(List<LSDashboardUtil.c> list, List<LSDashboardUtil.b> list2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes32.dex */
    public static class t {
        static CharSequence a(LSDashboardUtil.c cVar) {
            if (cVar.f64228b) {
                return cVar.toString();
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            String cVar2 = cVar.toString();
            SpannableString spannableString = new SpannableString(cVar2);
            spannableString.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), 0, cVar2.length(), 17);
            spannableStringBuilder.append((CharSequence) spannableString);
            return spannableStringBuilder;
        }

        static CharSequence b(LSDashboardUtil.d dVar) {
            if ("failed".equals(dVar.f64233c)) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                String dVar2 = dVar.toString();
                SpannableString spannableString = new SpannableString(dVar2);
                spannableString.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), 0, dVar2.length(), 17);
                spannableStringBuilder.append((CharSequence) spannableString);
                return spannableStringBuilder;
            }
            return dVar.toString();
        }
    }

    public LSDashboardPart(Activity activity, View view, lq.b bVar) {
        super(activity, view, bVar);
        this.f64661m = (LSMiddleCameraUnit) bVar.b(65537, new Object[0]);
    }

    private void C() {
        this.E.setOnCheckedChangeListener(new a());
        this.F.setOnCheckedChangeListener(new b());
        this.G.setOnCheckedChangeListener(new c());
        this.H.setOnCheckedChangeListener(new d());
        this.I.setOnCheckedChangeListener(new e());
        this.J.setChecked(AEDashboardUtil.j());
        this.J.setOnCheckedChangeListener(new f());
        this.K.setOnCheckedChangeListener(new g());
        this.L.setOnCheckedChangeListener(new h());
        this.M.setOnCheckedChangeListener(new i());
    }

    private void D() {
        this.V = new DashboardAdapter(this.f415377f);
        this.X = new DashboardAdapter(this.f415377f);
        this.Z = new DashboardAdapter(this.f415377f);
        this.f64653b0 = new DashboardAdapter(this.f415377f);
        this.U.setLayoutManager(new LinearLayoutManager(this.f415377f, 1, false));
        this.U.setAdapter(this.V);
        this.W.setLayoutManager(new LinearLayoutManager(this.f415377f, 1, false));
        this.W.setAdapter(this.X);
        this.Y.setLayoutManager(new LinearLayoutManager(this.f415377f, 1, false));
        this.Y.setAdapter(this.Z);
        this.f64652a0.setLayoutManager(new LinearLayoutManager(this.f415377f, 1, false));
        this.f64652a0.setAdapter(this.f64653b0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(final String str) {
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToast.makeText(this.f64661m.A(), "\u7f51\u7edc\u4e0d\u53ef\u7528", 0).show();
            return;
        }
        J(true);
        String str2 = "test" + System.currentTimeMillis();
        StringBuilder sb5 = new StringBuilder();
        String str3 = g.a.C0559a.f65247a;
        sb5.append(str3);
        String str4 = File.separator;
        sb5.append(str4);
        sb5.append("test_material_zip");
        sb5.append(str4);
        sb5.append(str2);
        sb5.append(".zip");
        final String sb6 = sb5.toString();
        final String str5 = str3 + str4 + "test_materials" + str4 + str2 + str4;
        HttpNetReq httpNetReq = new HttpNetReq();
        httpNetReq.mCallback = new INetEngineListener() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.LSDashboardPart.9
            @Override // com.tencent.mobileqq.transfile.INetEngineListener
            public void onResp(NetResp netResp) {
                ms.a.a("AEVideoStoryDashboardPart", "downLoadMaterial---result=" + netResp.mResult + ", url=" + str);
                if (netResp.mResult == 0) {
                    int unZipFolder = ZipUtils.unZipFolder(sb6, str5);
                    String str6 = str5;
                    if (unZipFolder == 0) {
                        str6 = LSDashboardPart.this.G(str6);
                    }
                    ms.a.a("AEVideoStoryDashboardPart", "downLoadMaterial---realMaterialFolder=" + str6);
                    ((p) com.tencent.aelight.camera.ae.flashshow.ay.a(LSDashboardPart.this.f64661m).get(p.class)).f64701i.postValue(str6);
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.LSDashboardPart.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            LSDashboardPart.this.J(false);
                        }
                    });
                    return;
                }
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.LSDashboardPart.9.2
                    @Override // java.lang.Runnable
                    public void run() {
                        LSDashboardPart.this.J(false);
                        QQToast.makeText(LSDashboardPart.this.f64661m.A(), "\u4e0b\u8f7d\u7d20\u6750\u5931\u8d25", 0).show();
                    }
                });
            }

            @Override // com.tencent.mobileqq.transfile.INetEngineListener
            public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
            }
        };
        httpNetReq.mReqUrl = str;
        httpNetReq.mHttpMethod = 0;
        httpNetReq.mOutPath = sb6;
        httpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
        httpNetReq.mExcuteTimeLimit = 60000L;
        try {
            ((IHttpEngineService) BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IHttpEngineService.class, "all")).sendReq(httpNetReq);
        } catch (Exception e16) {
            if (ms.a.g()) {
                e16.printStackTrace();
            }
        }
        httpNetReq.mCallback.onUpdateProgeress(httpNetReq, 1L, 100L);
        ms.a.f("AEVideoStoryDashboardPart", "startDownloadMaterial url: " + str);
    }

    private void F() {
        QIPCClientHelper.getInstance().callServer(IAECameraGetInfoServer.NAME, "ACTION_GET_ENV_INFO", null, new EIPCResultCallback() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.LSDashboardPart.19
            @Override // eipc.EIPCResultCallback
            public void onCallback(final EIPCResult eIPCResult) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.LSDashboardPart.19.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LSDashboardPart.this.N.setText(eIPCResult.data.getString("KEY_ENV_INFO") + ", PerfLevel: " + OfflineConfig.getPhonePerfLevel(BaseApplication.getContext()));
                    }
                });
            }
        });
    }

    private void H() {
        CharSequence text;
        this.f64657f0 = Pattern.compile("https?://.+\\.zip");
        ClipboardManager clipboardManager = (ClipboardManager) this.f64661m.A().getSystemService("clipboard");
        if (clipboardManager != null && ClipboardMonitor.hasPrimaryClip(clipboardManager) && ClipboardMonitor.getPrimaryClipDescription(clipboardManager) != null && ClipboardMonitor.getPrimaryClipDescription(clipboardManager).hasMimeType("text/plain") && (text = ClipboardMonitor.getPrimaryClip(clipboardManager).getItemAt(0).getText()) != null) {
            Matcher matcher = this.f64657f0.matcher(text);
            if (matcher.find()) {
                this.f64654c0.setText(matcher.group(0));
            }
        }
        this.f64655d0.setOnClickListener(new n());
        this.f64656e0.setOnClickListener(new o());
    }

    private void I() {
        LSDashboardUtil.i().observe(this.f64661m, new Observer<LSDashboardUtil.d>() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.LSDashboardPart.20
            @Override // androidx.lifecycle.Observer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onChanged(LSDashboardUtil.d dVar) {
                List<LSDashboardUtil.d> h16 = LSDashboardUtil.h(dVar);
                final LinkedList linkedList = new LinkedList();
                for (LSDashboardUtil.d dVar2 : h16) {
                    r rVar = new r();
                    rVar.f64703a = t.b(dVar2);
                    linkedList.add(rVar);
                }
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.LSDashboardPart.20.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LSDashboardPart.this.X.putData(linkedList);
                    }
                });
            }
        });
        LSDashboardUtil.j().observe(this.f64661m, new Observer<Float>() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.LSDashboardPart.21
            @Override // androidx.lifecycle.Observer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onChanged(final Float f16) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.LSDashboardPart.21.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LSDashboardPart.this.P.setText("\u5f53\u524d\u5e27\u7387:" + f16);
                    }
                });
            }
        });
    }

    public String G(String str) {
        String[] list;
        File file = new File(str);
        if (file.isDirectory() && (list = file.list()) != null) {
            for (String str2 : list) {
                if (!TextUtils.isEmpty(str2) && !str2.startsWith(".")) {
                    return str + str2;
                }
            }
        }
        return str;
    }

    @Override // lq.a
    protected void e() {
        View inflate = ((ViewStub) this.f415376e.findViewById(R.id.rm9)).inflate();
        this.C = (TextView) inflate.findViewById(R.id.rmu);
        this.D = (ScrollView) inflate.findViewById(R.id.s0d);
        this.C.setOnClickListener(new j());
        this.f64658g0 = (EditText) this.f415376e.findViewById(R.id.f163748rt0);
        TextView textView = (TextView) this.f415376e.findViewById(R.id.s3a);
        this.f64659h0 = textView;
        textView.setOnClickListener(new k());
        this.f64654c0 = (EditText) inflate.findViewById(R.id.rms);
        this.f64655d0 = (TextView) inflate.findViewById(R.id.rmq);
        this.f64656e0 = (TextView) inflate.findViewById(R.id.rmr);
        this.N = (TextView) inflate.findViewById(R.id.rmi);
        this.P = (TextView) inflate.findViewById(R.id.rmn);
        this.Q = (TextView) inflate.findViewById(R.id.rmj);
        this.R = (TextView) inflate.findViewById(R.id.rmd);
        this.S = (CheckBox) inflate.findViewById(R.id.rme);
        this.T = (TextView) inflate.findViewById(R.id.rmc);
        this.E = (CheckBox) inflate.findViewById(R.id.rmb);
        this.F = (CheckBox) inflate.findViewById(R.id.rmm);
        this.G = (CheckBox) inflate.findViewById(R.id.rmt);
        this.H = (CheckBox) inflate.findViewById(R.id.rmp);
        CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.rmg);
        this.I = checkBox;
        checkBox.setChecked(AEDashboardUtil.r());
        this.J = (CheckBox) inflate.findViewById(R.id.rmh);
        this.K = (CheckBox) inflate.findViewById(R.id.rmk);
        this.L = (CheckBox) inflate.findViewById(R.id.rns);
        this.M = (CheckBox) inflate.findViewById(R.id.rnr);
        this.U = (RecyclerView) inflate.findViewById(R.id.rma);
        this.W = (RecyclerView) inflate.findViewById(R.id.rml);
        this.Y = (RecyclerView) inflate.findViewById(R.id.rm_);
        this.f64652a0 = (RecyclerView) inflate.findViewById(R.id.rmo);
        H();
        C();
        D();
        F();
        this.Q.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.LSDashboardPart.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.LSDashboardPart.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.aelight.camera.ae.flashshow.autotest.i.d().b();
                        com.tencent.aelight.camera.ae.flashshow.autotest.b.f64141g = true;
                    }
                }, 64, null, true);
                LSDashboardPart.this.Q.setVisibility(8);
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        this.R.setOnClickListener(new l());
        this.S.setOnCheckedChangeListener(new m());
        this.T.setOnClickListener(new AnonymousClass6());
        I();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(boolean z16) {
        if (z16) {
            Activity activity = this.f415377f;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            if (this.f64660i0 == null) {
                ReportDialog reportDialog = new ReportDialog(this.f415377f, R.style.qZoneInputDialog);
                this.f64660i0 = reportDialog;
                reportDialog.setCancelable(false);
                this.f64660i0.setCanceledOnTouchOutside(false);
                this.f64660i0.setContentView(R.layout.f168383uh);
            }
            this.f64660i0.show();
            return;
        }
        Dialog dialog = this.f64660i0;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.f64660i0.dismiss();
    }

    @Override // lq.a
    public void l(int i3, Object... objArr) {
        if (i3 == 720897) {
            List<LSDashboardUtil.c> list = (List) objArr[0];
            List<LSDashboardUtil.b> list2 = (List) objArr[1];
            LinkedList linkedList = new LinkedList();
            for (LSDashboardUtil.c cVar : list) {
                r rVar = new r();
                rVar.f64703a = t.a(cVar);
                linkedList.add(rVar);
            }
            LinkedList linkedList2 = new LinkedList();
            for (LSDashboardUtil.b bVar : list2) {
                r rVar2 = new r();
                rVar2.f64703a = bVar.toString();
                linkedList2.add(rVar2);
            }
            this.V.putData(linkedList);
            this.Z.putData(linkedList2);
            return;
        }
        if (i3 != 720898 || this.f64653b0 == null) {
            return;
        }
        List<String> b16 = LSDashboardUtil.f64214d.b();
        LinkedList linkedList3 = new LinkedList();
        for (String str : b16) {
            r rVar3 = new r();
            rVar3.f64703a = str;
            linkedList3.add(rVar3);
        }
        this.f64653b0.putData(linkedList3);
    }

    @Override // lq.a
    public void g(int i3, int i16, Intent intent) {
        boolean z16;
        if (i3 == 1030 && i16 == -1 && intent != null) {
            ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(QQWinkConstants.INPUT_MEDIA);
            if (parcelableArrayListExtra.size() <= 0) {
                return;
            }
            Iterator it = parcelableArrayListExtra.iterator();
            while (it.hasNext()) {
                String str = ((LocalMediaInfo) it.next()).mMimeType;
                if (str == null || str.contains("video")) {
                    z16 = false;
                    break;
                }
            }
            z16 = true;
            if (!z16) {
                com.tencent.aelight.camera.ae.flashshow.autotest.b.m(true, parcelableArrayListExtra);
            }
            ArrayList arrayList = new ArrayList();
            Iterator it5 = parcelableArrayListExtra.iterator();
            while (it5.hasNext()) {
                arrayList.add(new com.tencent.aelight.camera.ae.flashshow.autotest.g((LocalMediaInfo) it5.next()));
            }
            com.tencent.aelight.camera.ae.flashshow.autotest.b.f64151q = true;
            com.tencent.aelight.camera.ae.flashshow.autotest.f.INSTANCE.a().m(arrayList, z16);
        }
    }
}
