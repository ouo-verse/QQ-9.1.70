package com.tencent.aelight.camera.ae.camera.ui.dashboard;

import android.app.Activity;
import android.app.Dialog;
import android.content.ClipboardManager;
import android.content.Context;
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
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.ae.g;
import com.tencent.aelight.camera.ae.util.AECacheMonitor;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.qipc.api.IAECameraGetInfoServer;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
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
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.ScrollView;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.light.DebugUtils;
import org.light.device.OfflineConfig;
import org.light.utils.LightLogUtil;

/* loaded from: classes32.dex */
public class AEVideoStoryDashboardPart extends com.tencent.aelight.camera.ae.part.b {
    private CheckBox C;
    private CheckBox D;
    private CheckBox E;
    private CheckBox F;
    private CheckBox G;
    private CheckBox H;
    private TextView I;
    private TextView J;
    private TextView K;
    private TextView L;
    private RecyclerView M;
    private DashboardAdapter N;
    private RecyclerView P;
    private DashboardAdapter Q;
    private RecyclerView R;
    private DashboardAdapter S;
    private RecyclerView T;
    private DashboardAdapter U;
    private EditText V;
    private TextView W;
    private TextView X;
    private Pattern Y;
    private EditText Z;

    /* renamed from: a0, reason: collision with root package name */
    private TextView f62647a0;

    /* renamed from: b0, reason: collision with root package name */
    private Dialog f62648b0;

    /* renamed from: d, reason: collision with root package name */
    private AEPituCameraUnit f62649d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f62650e;

    /* renamed from: f, reason: collision with root package name */
    private ScrollView f62651f;

    /* renamed from: h, reason: collision with root package name */
    private CheckBox f62652h;

    /* renamed from: i, reason: collision with root package name */
    private CheckBox f62653i;

    /* renamed from: m, reason: collision with root package name */
    private CheckBox f62654m;

    /* renamed from: com.tencent.aelight.camera.ae.camera.ui.dashboard.AEVideoStoryDashboardPart$5, reason: invalid class name */
    /* loaded from: classes32.dex */
    class AnonymousClass5 implements View.OnClickListener {
        AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            AECacheMonitor.g().o(new AECacheMonitor.c() { // from class: com.tencent.aelight.camera.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.5.1
                @Override // com.tencent.aelight.camera.ae.util.AECacheMonitor.c
                public void a(long j3, HashMap<String, String> hashMap, final String str) {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.5.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AEVideoStoryDashboardPart.this.L.setText(str);
                        }
                    });
                }
            });
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes32.dex */
    public static class DashboardAdapter extends RecyclerView.Adapter<p> {

        /* renamed from: d, reason: collision with root package name */
        private Context f62676d;

        /* renamed from: e, reason: collision with root package name */
        private List<q> f62677e = new LinkedList();

        public DashboardAdapter(Context context) {
            this.f62676d = context;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f62677e.size();
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(p pVar, int i3) {
            pVar.b(this.f62677e.get(i3));
        }

        public void putData(List<q> list) {
            this.f62677e = list;
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.DashboardAdapter.1
                @Override // java.lang.Runnable
                public void run() {
                    DashboardAdapter.this.notifyDataSetChanged();
                }
            });
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public p onCreateViewHolder(ViewGroup viewGroup, int i3) {
            return new p(LayoutInflater.from(this.f62676d).inflate(R.layout.dlg, viewGroup, false));
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
            AEVideoStoryDashboardPart.this.P.setVisibility(z16 ? 0 : 8);
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
            AEVideoStoryDashboardPart.this.R.setVisibility(z16 ? 0 : 8);
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
            AEVideoStoryDashboardPart.this.T.setVisibility(z16 ? 0 : 8);
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
            AEDashboardUtil.w(z16);
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
            AEDashboardUtil.v(z16);
            QQToast.makeText(BaseApplication.getContext(), "\u91cd\u542f\u76f8\u673a\u663e\u793a\u5207\u6362\u6548\u679c", 0).show();
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
            LightLogUtil.setMinPriority(z16 ? 4 : 7);
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
            tq.d.e(z16);
            QQToast.makeText(BaseApplication.getContext(), "\u91cd\u542f\u76f8\u673a\u6027\u80fd\u6570\u636e\u624d\u4f1a\u6536\u96c6", 0).show();
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
            if (!new File("/sdcard/light_sdk_images").exists()) {
                new File("/sdcard/light_sdk_images").mkdirs();
            }
            DebugUtils.setImageDebugInfo(z16, "/sdcard/light_sdk_images", false, z16, z16, z16, z16);
            ms.a.f("AEVideoStoryDashboardPart", "mLightImageCheckBox:" + z16);
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* loaded from: classes32.dex */
    class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            AEVideoStoryDashboardPart.this.f62651f.setVisibility(AEVideoStoryDashboardPart.this.f62651f.getVisibility() == 0 ? 8 : 0);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes32.dex */
    class j implements View.OnClickListener {
        j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Editable text = AEVideoStoryDashboardPart.this.Z.getText();
            if (!TextUtils.isEmpty(text)) {
                AEVideoStoryDashboardPart.this.Z.setText("");
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
    class k implements View.OnClickListener {
        k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            AEVideoStoryDashboardPart.this.K();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class l implements View.OnClickListener {
        l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            AEVideoStoryDashboardPart.this.V.setText("");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class m implements View.OnClickListener {
        m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Editable text = AEVideoStoryDashboardPart.this.V.getText();
            if (!TextUtils.isEmpty(text)) {
                AEVideoStoryDashboardPart.this.F(text.toString());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class n implements CompoundButton.OnCheckedChangeListener {
        n() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            AEVideoStoryDashboardPart.this.M.setVisibility(z16 ? 0 : 8);
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* loaded from: classes32.dex */
    public static class o extends ViewModel {

        /* renamed from: i, reason: collision with root package name */
        public final MutableLiveData<String> f62692i = new MutableLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes32.dex */
    public static class p extends RecyclerView.ViewHolder {

        /* renamed from: d, reason: collision with root package name */
        private TextView f62693d;

        public p(View view) {
            super(view);
            this.f62693d = (TextView) view.findViewById(R.id.f163715rm2);
        }

        public void b(q qVar) {
            this.f62693d.setText(qVar.f62694a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes32.dex */
    public static class q {

        /* renamed from: a, reason: collision with root package name */
        public CharSequence f62694a;

        q() {
        }
    }

    /* loaded from: classes32.dex */
    public interface r {
        void b(List<AEDashboardUtil.c> list, List<AEDashboardUtil.b> list2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes32.dex */
    public static class s {
        static CharSequence a(AEDashboardUtil.c cVar) {
            if (cVar.f62625b) {
                return cVar.toString();
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            String cVar2 = cVar.toString();
            SpannableString spannableString = new SpannableString(cVar2);
            spannableString.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), 0, cVar2.length(), 17);
            spannableStringBuilder.append((CharSequence) spannableString);
            return spannableStringBuilder;
        }

        static CharSequence b(AEDashboardUtil.d dVar) {
            if ("failed".equals(dVar.f62630c)) {
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

    public AEVideoStoryDashboardPart(Activity activity, View view, com.tencent.aelight.camera.ae.part.c cVar) {
        super(activity, view, cVar);
        this.f62649d = (AEPituCameraUnit) cVar.b(65537, new Object[0]);
    }

    private void D() {
        this.f62652h.setOnCheckedChangeListener(new n());
        this.f62653i.setOnCheckedChangeListener(new a());
        this.f62654m.setOnCheckedChangeListener(new b());
        this.C.setOnCheckedChangeListener(new c());
        this.D.setOnCheckedChangeListener(new d());
        this.E.setOnCheckedChangeListener(new e());
        this.F.setOnCheckedChangeListener(new f());
        this.G.setOnCheckedChangeListener(new g());
        this.H.setOnCheckedChangeListener(new h());
    }

    private void E() {
        this.N = new DashboardAdapter(this.mActivity);
        this.Q = new DashboardAdapter(this.mActivity);
        this.S = new DashboardAdapter(this.mActivity);
        this.U = new DashboardAdapter(this.mActivity);
        this.M.setLayoutManager(new LinearLayoutManager(this.mActivity, 1, false));
        this.M.setAdapter(this.N);
        this.P.setLayoutManager(new LinearLayoutManager(this.mActivity, 1, false));
        this.P.setAdapter(this.Q);
        this.R.setLayoutManager(new LinearLayoutManager(this.mActivity, 1, false));
        this.R.setAdapter(this.S);
        this.T.setLayoutManager(new LinearLayoutManager(this.mActivity, 1, false));
        this.T.setAdapter(this.U);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(final String str) {
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToast.makeText(this.f62649d.z(), "\u7f51\u7edc\u4e0d\u53ef\u7528", 0).show();
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
        httpNetReq.mCallback = new INetEngineListener() { // from class: com.tencent.aelight.camera.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.8
            @Override // com.tencent.mobileqq.transfile.INetEngineListener
            public void onResp(NetResp netResp) {
                ms.a.a("AEVideoStoryDashboardPart", "downLoadMaterial---result=" + netResp.mResult + ", url=" + str);
                if (netResp.mResult == 0) {
                    int unZipFolder = ZipUtils.unZipFolder(sb6, str5);
                    String str6 = str5;
                    if (unZipFolder == 0) {
                        str6 = AEVideoStoryDashboardPart.this.H(str6);
                    }
                    ms.a.a("AEVideoStoryDashboardPart", "downLoadMaterial---realMaterialFolder=" + str6);
                    ((o) com.tencent.aelight.camera.ae.n.a(AEVideoStoryDashboardPart.this.f62649d).get(o.class)).f62692i.postValue(str6);
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.8.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AEVideoStoryDashboardPart.this.J(false);
                        }
                    });
                    return;
                }
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.8.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AEVideoStoryDashboardPart.this.J(false);
                        QQToast.makeText(AEVideoStoryDashboardPart.this.f62649d.z(), "\u4e0b\u8f7d\u7d20\u6750\u5931\u8d25", 0).show();
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

    private void G() {
        QIPCClientHelper.getInstance().callServer(IAECameraGetInfoServer.NAME, "ACTION_GET_ENV_INFO", null, new EIPCResultCallback() { // from class: com.tencent.aelight.camera.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.18
            @Override // eipc.EIPCResultCallback
            public void onCallback(final EIPCResult eIPCResult) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.18.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AEVideoStoryDashboardPart.this.I.setText(eIPCResult.data.getString("KEY_ENV_INFO") + ", PerfLevel: " + OfflineConfig.getPhonePerfLevel(BaseApplication.getContext()));
                    }
                });
            }
        });
    }

    private void I() {
        this.Y = Pattern.compile("https?://.+\\.zip");
        ClipboardManager clipboardManager = (ClipboardManager) this.f62649d.z().getSystemService("clipboard");
        if (ClipboardMonitor.hasPrimaryClip(clipboardManager) && ClipboardMonitor.getPrimaryClipDescription(clipboardManager).hasMimeType("text/plain")) {
            Matcher matcher = this.Y.matcher(ClipboardMonitor.getPrimaryClip(clipboardManager).getItemAt(0).getText());
            if (matcher.find()) {
                this.V.setText(matcher.group(0));
            }
        }
        this.W.setOnClickListener(new l());
        this.X.setOnClickListener(new m());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        AEResInfo aEResInfo = AEResInfo.LIGHT_RES_BUNDLE_PIC_ENHANCE;
        boolean U = AEResUtil.U(aEResInfo);
        AEResInfo aEResInfo2 = AEResInfo.LIGHT_RES_BUNDLE_PIC_QUALITY;
        boolean U2 = AEResUtil.U(aEResInfo2);
        ms.a.a("AEVideoStoryDashboardPart", "picEnhanceExists=" + U + ", picQualityExists=" + U2);
        if (!U) {
            AEResUtil.h(aEResInfo.agentType);
        }
        if (U2) {
            return;
        }
        AEResUtil.h(aEResInfo2.agentType);
    }

    private void initViewModel() {
        AEDashboardUtil.k().observe(this.f62649d, new Observer<AEDashboardUtil.d>() { // from class: com.tencent.aelight.camera.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.19
            @Override // androidx.lifecycle.Observer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onChanged(AEDashboardUtil.d dVar) {
                List<AEDashboardUtil.d> i3 = AEDashboardUtil.i(dVar);
                final LinkedList linkedList = new LinkedList();
                for (AEDashboardUtil.d dVar2 : i3) {
                    q qVar = new q();
                    qVar.f62694a = s.b(dVar2);
                    linkedList.add(qVar);
                }
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.19.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AEVideoStoryDashboardPart.this.Q.putData(linkedList);
                    }
                });
            }
        });
        AEDashboardUtil.l().observe(this.f62649d, new Observer<Float>() { // from class: com.tencent.aelight.camera.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.20
            @Override // androidx.lifecycle.Observer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onChanged(final Float f16) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.20.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AEVideoStoryDashboardPart.this.J.setText("\u5f53\u524d\u5e27\u7387:" + f16);
                    }
                });
            }
        });
    }

    public String H(String str) {
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.ae.part.b
    public void initView() {
        View inflate = ((ViewStub) this.mRootView.findViewById(R.id.rm9)).inflate();
        this.f62650e = (TextView) inflate.findViewById(R.id.rmu);
        this.f62651f = (ScrollView) inflate.findViewById(R.id.s0d);
        this.f62650e.setOnClickListener(new i());
        this.Z = (EditText) this.mRootView.findViewById(R.id.f163748rt0);
        TextView textView = (TextView) this.mRootView.findViewById(R.id.s3a);
        this.f62647a0 = textView;
        textView.setOnClickListener(new j());
        this.V = (EditText) inflate.findViewById(R.id.rms);
        this.W = (TextView) inflate.findViewById(R.id.rmq);
        this.X = (TextView) inflate.findViewById(R.id.rmr);
        this.I = (TextView) inflate.findViewById(R.id.rmi);
        this.J = (TextView) inflate.findViewById(R.id.rmn);
        this.L = (TextView) inflate.findViewById(R.id.rmc);
        this.K = (TextView) inflate.findViewById(R.id.rmj);
        this.f62652h = (CheckBox) inflate.findViewById(R.id.rmb);
        this.f62653i = (CheckBox) inflate.findViewById(R.id.rmm);
        this.f62654m = (CheckBox) inflate.findViewById(R.id.rmt);
        this.C = (CheckBox) inflate.findViewById(R.id.rmp);
        CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.rmg);
        this.D = checkBox;
        checkBox.setChecked(AEDashboardUtil.r());
        CheckBox checkBox2 = (CheckBox) inflate.findViewById(R.id.rmh);
        this.E = checkBox2;
        checkBox2.setChecked(AEDashboardUtil.q());
        this.F = (CheckBox) inflate.findViewById(R.id.rmk);
        this.G = (CheckBox) inflate.findViewById(R.id.rns);
        this.H = (CheckBox) inflate.findViewById(R.id.rnr);
        this.M = (RecyclerView) inflate.findViewById(R.id.rma);
        this.P = (RecyclerView) inflate.findViewById(R.id.rml);
        this.R = (RecyclerView) inflate.findViewById(R.id.rm_);
        this.T = (RecyclerView) inflate.findViewById(R.id.rmo);
        I();
        D();
        E();
        G();
        this.K.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.aelight.camera.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.aelight.camera.ae.camera.autotest.c.c().b();
                        eq.a.f396953f = true;
                    }
                }, 64, null, true);
                AEVideoStoryDashboardPart.this.K.setVisibility(8);
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        this.I.setOnClickListener(new k());
        this.L.setOnClickListener(new AnonymousClass5());
        initViewModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(boolean z16) {
        if (z16) {
            Activity activity = this.mActivity;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            if (this.f62648b0 == null) {
                ReportDialog reportDialog = new ReportDialog(this.mActivity, R.style.qZoneInputDialog);
                this.f62648b0 = reportDialog;
                reportDialog.setCancelable(false);
                this.f62648b0.setCanceledOnTouchOutside(false);
                this.f62648b0.setContentView(R.layout.f168383uh);
            }
            this.f62648b0.show();
            return;
        }
        Dialog dialog = this.f62648b0;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.f62648b0.dismiss();
    }

    @Override // com.tencent.aelight.camera.ae.part.b
    public void send(int i3, Object... objArr) {
        if (i3 == 720897) {
            List<AEDashboardUtil.c> list = (List) objArr[0];
            List<AEDashboardUtil.b> list2 = (List) objArr[1];
            LinkedList linkedList = new LinkedList();
            for (AEDashboardUtil.c cVar : list) {
                q qVar = new q();
                qVar.f62694a = s.a(cVar);
                linkedList.add(qVar);
            }
            LinkedList linkedList2 = new LinkedList();
            for (AEDashboardUtil.b bVar : list2) {
                q qVar2 = new q();
                qVar2.f62694a = bVar.toString();
                linkedList2.add(qVar2);
            }
            this.N.putData(linkedList);
            this.S.putData(linkedList2);
            return;
        }
        if (i3 != 720898 || this.U == null) {
            return;
        }
        List<String> k3 = AEDashboardUtil.f62611d.k();
        LinkedList linkedList3 = new LinkedList();
        for (String str : k3) {
            q qVar3 = new q();
            qVar3.f62694a = str;
            linkedList3.add(qVar3);
        }
        this.U.putData(linkedList3);
    }
}
