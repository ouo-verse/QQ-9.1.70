package com.tencent.mobileqq.zplan.avatar.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.avatar.api.IQQAvatarDataService;
import com.tencent.mobileqq.avatar.api.IQQZplanOutsideAvatarApi;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.rainbow.api.IRainbowApi;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.u;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.api.IQQWinkLauncher;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.IZootopiaApi;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.avatar.RecordResult;
import com.tencent.mobileqq.zplan.avatar.ZPlanEditAvatarEntranceScene;
import com.tencent.mobileqq.zplan.avatar.api.IZPlanEditAvatarApi;
import com.tencent.mobileqq.zplan.avatar.b;
import com.tencent.mobileqq.zplan.avatar.edit.BackgroundInfo;
import com.tencent.mobileqq.zplan.avatar.edit.ZPlanAvatarUploadParam;
import com.tencent.mobileqq.zplan.avatar.edit.ZPlanEditAvatarManager;
import com.tencent.mobileqq.zplan.avatar.edit.ZPlanEditAvatarUtils;
import com.tencent.mobileqq.zplan.avatar.fragment.d;
import com.tencent.mobileqq.zplan.avatar.fragment.e;
import com.tencent.mobileqq.zplan.avatar.image.sharpP.ZPlanAvatarShpImageUploadDownloadUtils;
import com.tencent.mobileqq.zplan.avatar.manager.ZPlanEditAvatarAllConfigInfo;
import com.tencent.mobileqq.zplan.avatar.manager.ZPlanEditAvatarDataManager;
import com.tencent.mobileqq.zplan.avatar.report.ZPlanAvatarEditDaTongReport;
import com.tencent.mobileqq.zplan.meme.api.impl.MemeHelper;
import com.tencent.mobileqq.zplan.meme.prerecord.ZPlanPreRecordManager;
import com.tencent.mobileqq.zplan.model.ZPlanUserInfo;
import com.tencent.mobileqq.zplan.persistent.api.IZPlanDataHelper;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.mobileqq.zplan.view.ZPlanAvatarSettingLoadingView;
import com.tencent.mobileqq.zplan.view.ZPlanRoundImageLayout;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.state.report.SquareReportConst;
import com.tencent.util.LoadingUtil;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.zplan.meme.Priority;
import com.tencent.zplan.record.model.Source;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
import ze3.ZPlanEditAvatarBackgroundData;
import ze3.ZPlanEditAvatarHeadActionData;

/* loaded from: classes35.dex */
public class ZPlanAvatarPicEditFragment extends QPublicBaseFragment implements View.OnClickListener, ZPlanPreRecordManager.a {
    private ReentrantLock A0;
    private final ArrayList<d.c> B0;
    private final ArrayList<e.a> C0;
    private View D;
    private com.tencent.mobileqq.zplan.avatar.fragment.b D0;
    private ImageView E;
    private com.tencent.mobileqq.zplan.avatar.fragment.b E0;
    private ImageView F;
    private final ArrayList<ZPlanEditAvatarHeadActionData> F0;
    private ImageView G;
    private final ArrayList<ZPlanEditAvatarBackgroundData> G0;
    private LinearLayout H;
    private com.tencent.mobileqq.zplan.avatar.a H0;
    private LinearLayout I;
    private final com.tencent.mobileqq.zplan.avatar.edit.g I0;
    private CheckBox J;
    private List<nu4.g> J0;
    private TextView K;
    private List<nu4.a> K0;
    private TextView L;
    private nu4.f L0;
    private TextView M;
    private List<BackgroundInfo> M0;
    private ZPlanAvatarSettingLoadingView N;
    private List<com.tencent.mobileqq.zplan.avatar.edit.d> N0;
    private List<com.tencent.mobileqq.zplan.avatar.edit.d> O0;
    private ZPlanRoundImageLayout P;
    private List<com.tencent.mobileqq.zplan.avatar.edit.d> P0;
    private com.tencent.mobileqq.zplan.avatar.fragment.d Q;
    private ConcurrentHashMap<Integer, Integer> Q0;
    private com.tencent.mobileqq.zplan.avatar.fragment.e R;
    private ConcurrentHashMap<Integer, com.tencent.mobileqq.zplan.avatar.edit.d> R0;
    private com.tencent.mobileqq.zplan.avatar.fragment.f S;
    private final com.tencent.mobileqq.rainbow.a S0;
    private RecyclerView T;
    private final com.tencent.mobileqq.zplan.servlet.b T0;
    private RecyclerView U;
    private String V;
    private volatile int W;
    private int X;

    /* renamed from: a0, reason: collision with root package name */
    private Dialog f331685a0;

    /* renamed from: v0, reason: collision with root package name */
    private final boolean f331706v0;

    /* renamed from: w0, reason: collision with root package name */
    private final boolean f331707w0;

    /* renamed from: x0, reason: collision with root package name */
    private boolean f331708x0;

    /* renamed from: y0, reason: collision with root package name */
    private final Handler f331709y0;

    /* renamed from: z0, reason: collision with root package name */
    private List<Integer> f331710z0;
    private long C = 0;
    private int Y = -1;
    private String Z = "";

    /* renamed from: b0, reason: collision with root package name */
    private int f331686b0 = 0;

    /* renamed from: c0, reason: collision with root package name */
    private int f331687c0 = 0;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f331688d0 = false;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f331689e0 = false;

    /* renamed from: f0, reason: collision with root package name */
    private int f331690f0 = 0;

    /* renamed from: g0, reason: collision with root package name */
    private int f331691g0 = -1;

    /* renamed from: h0, reason: collision with root package name */
    private int f331692h0 = -1;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f331693i0 = false;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f331694j0 = false;

    /* renamed from: k0, reason: collision with root package name */
    private String f331695k0 = "";

    /* renamed from: l0, reason: collision with root package name */
    private String f331696l0 = "\u66f4\u6362\u5934\u50cf";

    /* renamed from: m0, reason: collision with root package name */
    private IQQAvatarDataService f331697m0 = null;

    /* renamed from: n0, reason: collision with root package name */
    private String f331698n0 = "";

    /* renamed from: o0, reason: collision with root package name */
    ZPlanAvatarEditDaTongReport f331699o0 = new ZPlanAvatarEditDaTongReport();

    /* renamed from: p0, reason: collision with root package name */
    private String f331700p0 = ZPlanEditAvatarEntranceScene.UNKNOWN.getSourceString();

    /* renamed from: q0, reason: collision with root package name */
    private String f331701q0 = "-1";

    /* renamed from: r0, reason: collision with root package name */
    private int f331702r0 = 0;

    /* renamed from: s0, reason: collision with root package name */
    private int f331703s0 = 0;

    /* renamed from: t0, reason: collision with root package name */
    private int f331704t0 = 0;

    /* renamed from: u0, reason: collision with root package name */
    private ConcurrentHashMap<Integer, Source> f331705u0 = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            ZPlanAvatarPicEditFragment.this.vj("ev_zplan_popup_confirm", "click");
            dialogInterface.dismiss();
            if (ZPlanAvatarPicEditFragment.this.getActivity() != null) {
                ZPlanAvatarPicEditFragment.this.getActivity().finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            ZPlanAvatarPicEditFragment.this.vj("ev_zplan_popup_cancel", "click");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class e implements Function2<Boolean, String, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d.c f331731d;

        e(d.c cVar) {
            this.f331731d = cVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(Boolean bool, String str) {
            if (bool.booleanValue() && !TextUtils.isEmpty(str)) {
                QLog.d("ZPlanAvatarPicEditFragment-avatarEditor", 1, "[fillDefaultAppearanceAvatarActionInfo] downloadShpImagePackage url:" + this.f331731d.f331768g);
                ZPlanAvatarPicEditFragment.this.Gj(this.f331731d.f331764c, str);
                return Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class f implements IDynamicParams {
        f() {
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            return ZPlanAvatarPicEditFragment.this.cj();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class g extends RecyclerView.OnScrollListener {
        g() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            if (i3 == 0) {
                VideoReport.traversePage(ZPlanAvatarPicEditFragment.this.T);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
            super.onScrolled(recyclerView, i3, i16);
        }
    }

    /* loaded from: classes35.dex */
    class h extends Handler {
        h(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 1) {
                if (ZPlanAvatarPicEditFragment.this.N == null || !ZPlanAvatarPicEditFragment.this.N.isShown()) {
                    return;
                }
                QQToast.makeText(BaseApplication.getContext(), 1, "\u52a0\u8f7d\u5931\u8d25\u8bf7\u91cd\u8bd5", 0).show();
                ZPlanAvatarPicEditFragment.this.mj(4);
                return;
            }
            if (i3 == 2) {
                ZPlanAvatarPicEditFragment.this.Pj();
                return;
            }
            if (i3 == 3) {
                QLog.i("ZPlanAvatarPicEditFragment-avatarEditor", 4, "\u5f55\u5236\u5b8c\u4e86 set\u6570\u636e mCurrActionPosition\uff1a" + ZPlanAvatarPicEditFragment.this.f331686b0);
                ZPlanAvatarPicEditFragment.this.Wi();
                if (ZPlanAvatarPicEditFragment.this.f331693i0) {
                    return;
                }
                QLog.i("ZPlanAvatarPicEditFragment-avatarEditor", 1, "cancel loading.");
                ZPlanAvatarPicEditFragment.this.Mj(false);
                ZPlanAvatarPicEditFragment.this.uj("imp");
                ZPlanAvatarPicEditFragment.this.f331709y0.sendEmptyMessageDelayed(2, 1000L);
                ZPlanAvatarPicEditFragment.this.f331693i0 = true;
                ZPlanAvatarPicEditFragment zPlanAvatarPicEditFragment = ZPlanAvatarPicEditFragment.this;
                zPlanAvatarPicEditFragment.Nj(zPlanAvatarPicEditFragment.rj());
                ZPlanAvatarPicEditFragment.this.Ri();
                return;
            }
            if (i3 == 4) {
                QLog.e("ZPlanAvatarPicEditFragment-avatarEditor", 1, "\u4fdd\u5b58\u5934\u50cf\u8d85\u65f6");
                if (ZPlanAvatarPicEditFragment.this.f331685a0 == null || !ZPlanAvatarPicEditFragment.this.f331685a0.isShowing()) {
                    return;
                }
                ZPlanAvatarPicEditFragment.this.f331685a0.dismiss();
                QQToast.makeText(BaseApplication.getContext(), 1, ZPlanAvatarPicEditFragment.this.getString(R.string.xlb), 0).show();
                return;
            }
            if (i3 != 5) {
                return;
            }
            QLog.e("ZPlanAvatarPicEditFragment-avatarEditor", 1, "\u65e0\u7f51\u7edc");
            if (ZPlanAvatarPicEditFragment.this.N == null || !ZPlanAvatarPicEditFragment.this.N.isShown()) {
                return;
            }
            QQToast.makeText(BaseApplication.getContext(), 1, ZPlanAvatarPicEditFragment.this.getString(R.string.xlb), 0).show();
            ZPlanAvatarPicEditFragment.this.mj(1);
        }
    }

    /* loaded from: classes35.dex */
    class i implements com.tencent.mobileqq.zplan.avatar.a {
        i() {
        }

        @Override // com.tencent.mobileqq.zplan.avatar.a
        public void a(RecordResult recordResult) {
            if (ZPlanAvatarPicEditFragment.this.S == null) {
                QLog.e("ZPlanAvatarPicEditFragment-avatarEditor", 1, "recordEditAvatar onRecordDone mResourceManager is empty");
                return;
            }
            boolean isSuccess = recordResult.getIsSuccess();
            int actionId = recordResult.getActionId();
            String recordPath = recordResult.getRecordPath();
            ZPlanAvatarPicEditFragment.this.f331705u0.put(Integer.valueOf(actionId), recordResult.getSource());
            if (isSuccess && !TextUtils.isEmpty(recordPath) && actionId != -1) {
                ZPlanAvatarPicEditFragment.this.Gj(actionId, recordPath);
                QLog.d("ZPlanAvatarPicEditFragment-avatarEditor", 1, "recordEditAvatar onRecordDone success id:" + actionId + " recordPath\uff1a" + recordPath);
                return;
            }
            QLog.e("ZPlanAvatarPicEditFragment-avatarEditor", 1, "[onRecordDone]" + ("\u5f55\u5236id" + actionId + "\u5931\u8d25"));
            ZPlanAvatarPicEditFragment.this.S.a(actionId, -1, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class j implements com.tencent.mobileqq.zplan.avatar.manager.a {
        j() {
        }

        @Override // com.tencent.mobileqq.zplan.avatar.manager.a
        public void a(boolean z16, ZPlanEditAvatarAllConfigInfo zPlanEditAvatarAllConfigInfo) {
            QLog.i("ZPlanAvatarPicEditFragment-avatarEditor", 1, "[requestConfigData] onResult, isSuccess: " + z16);
            ZPlanAvatarPicEditFragment.this.f331708x0 = false;
            if (zPlanEditAvatarAllConfigInfo == null) {
                QLog.e("ZPlanAvatarPicEditFragment-avatarEditor", 1, "[requestConfigData] onResult, updatedInfos null.");
                return;
            }
            ZPlanAvatarPicEditFragment.this.J0 = zPlanEditAvatarAllConfigInfo.c();
            ZPlanAvatarPicEditFragment.this.K0 = zPlanEditAvatarAllConfigInfo.a();
            ZPlanAvatarPicEditFragment.this.L0 = zPlanEditAvatarAllConfigInfo.getGlobalConfig();
            ZPlanAvatarPicEditFragment zPlanAvatarPicEditFragment = ZPlanAvatarPicEditFragment.this;
            zPlanAvatarPicEditFragment.f331690f0 = zPlanAvatarPicEditFragment.L0.preRecNum;
            ZPlanAvatarPicEditFragment.this.lj();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class k implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f331738d;

        k(String str) {
            this.f331738d = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoReport.reportEvent("clck", ZPlanAvatarPicEditFragment.this.M, ZPlanAvatarPicEditFragment.this.cj());
            Context context = ZPlanAvatarPicEditFragment.this.getContext();
            if (TextUtils.isEmpty(this.f331738d) || context == null) {
                return;
            }
            QLog.i("ZPlanAvatarPicEditFragment-avatarEditor", 1, "jump scheme: " + this.f331738d);
            ((IZPlanApi) QRoute.api(IZPlanApi.class)).launchScheme(context, this.f331738d);
        }
    }

    /* loaded from: classes35.dex */
    class l implements com.tencent.mobileqq.zplan.avatar.edit.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zplan.avatar.edit.d f331740a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f331741b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ double f331742c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppInterface f331743d;

        l(com.tencent.mobileqq.zplan.avatar.edit.d dVar, String str, double d16, AppInterface appInterface) {
            this.f331740a = dVar;
            this.f331741b = str;
            this.f331742c = d16;
            this.f331743d = appInterface;
        }

        @Override // com.tencent.mobileqq.zplan.avatar.edit.e
        public void a(boolean z16, com.tencent.mobileqq.zplan.avatar.edit.d dVar, String str) {
            QLog.i("ZPlanAvatarPicEditFragment-avatarEditor", 1, "[onComposeFinish] isSuccess:" + z16 + " avatarData:" + this.f331740a + " mIsSyncQzone:" + ZPlanAvatarPicEditFragment.this.f331694j0);
            if (!z16 || TextUtils.isEmpty(str)) {
                ZPlanAvatarPicEditFragment.this.tj(2, this.f331740a);
                ZPlanAvatarPicEditFragment.this.I0.a(false, "");
            } else {
                ((IZPlanEditAvatarApi) QRoute.api(IZPlanEditAvatarApi.class)).uploadAvatar((QQAppInterface) this.f331743d, str, this.f331740a, ZPlanAvatarPicEditFragment.this.f331694j0, new ZPlanAvatarUploadParam(this.f331741b, str, this.f331742c, ZPlanAvatarPicEditFragment.this.Y, ZPlanAvatarPicEditFragment.this.Z), ZPlanAvatarPicEditFragment.this.f331700p0);
                ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setBoolean("ZPLAN_AVATAR_EDIT_SYNC_QZONE", ZPlanAvatarPicEditFragment.this.f331694j0);
                ZPlanAvatarPicEditFragment.this.f331695k0 = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class n extends QQPermission.BasePermissionsListener {
        n() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            QLog.d("ZPlanAvatarPicEditFragment-avatarEditor", 1, "User requestPermissions grant...");
            ZPlanAvatarPicEditFragment.this.Fj();
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            super.onDenied(list, list2);
            QLog.d("ZPlanAvatarPicEditFragment-avatarEditor", 1, "User requestPermissions denied...");
            ZPlanAvatarPicEditFragment.this.zj(2, ZPlanAvatarPicEditFragment.this.ej().j());
        }
    }

    public ZPlanAvatarPicEditFragment() {
        ZPlanQQMC zPlanQQMC = ZPlanQQMC.INSTANCE;
        this.f331706v0 = zPlanQQMC.enableZPlanEditAvatarV2();
        this.f331707w0 = zPlanQQMC.enableZPlanEditInitDataOnResume();
        this.f331708x0 = false;
        this.f331709y0 = new h(Looper.getMainLooper());
        this.f331710z0 = new CopyOnWriteArrayList();
        this.A0 = new ReentrantLock();
        this.B0 = new ArrayList<>();
        this.C0 = new ArrayList<>();
        this.F0 = new ArrayList<>();
        this.G0 = new ArrayList<>();
        this.H0 = new i();
        this.I0 = new com.tencent.mobileqq.zplan.avatar.edit.g() { // from class: com.tencent.mobileqq.zplan.avatar.fragment.ZPlanAvatarPicEditFragment.13

            /* renamed from: a, reason: collision with root package name */
            private final WeakReference<ZPlanAvatarPicEditFragment> f331713a;

            {
                this.f331713a = new WeakReference<>(ZPlanAvatarPicEditFragment.this);
            }

            @Override // com.tencent.mobileqq.zplan.avatar.edit.g
            public void a(final boolean z16, final String str) {
                final ZPlanAvatarPicEditFragment zPlanAvatarPicEditFragment = this.f331713a.get();
                if (zPlanAvatarPicEditFragment == null) {
                    return;
                }
                zPlanAvatarPicEditFragment.f331709y0.removeMessages(4);
                zPlanAvatarPicEditFragment.f331709y0.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.avatar.fragment.ZPlanAvatarPicEditFragment.13.2
                    @Override // java.lang.Runnable
                    public void run() {
                        String str2;
                        int i3 = z16 ? 2 : 1;
                        if (TextUtils.isEmpty(str)) {
                            if (z16) {
                                str2 = "\u66f4\u6362\u5934\u50cf\u6210\u529f";
                            } else {
                                str2 = "\u66f4\u6362\u5934\u50cf\u5931\u8d25";
                            }
                        } else {
                            str2 = str;
                        }
                        QQToast.makeText(BaseApplication.getContext(), i3, str2, 1).show();
                        Dialog dialog = zPlanAvatarPicEditFragment.f331685a0;
                        if (dialog != null) {
                            dialog.dismiss();
                        }
                        AppInterface c16 = bb.f335811a.c();
                        FragmentActivity activity = zPlanAvatarPicEditFragment.getActivity();
                        if (!z16 || activity == null || c16 == null) {
                            return;
                        }
                        if (sa0.b.c() && ("1".equals(ZPlanAvatarPicEditFragment.this.f331700p0) || "2".equals(ZPlanAvatarPicEditFragment.this.f331700p0) || "3".equals(ZPlanAvatarPicEditFragment.this.f331700p0) || "4".equals(ZPlanAvatarPicEditFragment.this.f331700p0))) {
                            Bundle bundle = new Bundle();
                            bundle.putString(QQWinkConstants.ENTRY_BUSINESS_NAME, "QCIRCLE");
                            bundle.putString("app_key", "00000QG6YX3X0LZH");
                            bundle.putString(QQWinkConstants.AVATAR_ORIGIN_HD_PATH, ZPlanAvatarPicEditFragment.this.f331698n0);
                            bundle.putString(QQWinkConstants.AVATAR_NEW_HD_PATH, ZPlanAvatarPicEditFragment.this.f331695k0);
                            bundle.putString(QQWinkConstants.WinkLowLevelTemplateShareConstant.WINK_TEMPLATE_FROM_TYPE, "super_qq");
                            bundle.putString(QQWinkConstants.WINK_PUBLISH_TASK_ID, "qq_avatar_superqq");
                            if (!"3".equals(ZPlanAvatarPicEditFragment.this.f331700p0) && !"4".equals(ZPlanAvatarPicEditFragment.this.f331700p0)) {
                                bundle.putInt("AVATAR_TO_EXPERIENCE_FROM_TYPE", 0);
                            } else {
                                bundle.putInt("AVATAR_TO_EXPERIENCE_FROM_TYPE", Integer.parseInt(ZPlanAvatarPicEditFragment.this.f331700p0) - 2);
                            }
                            ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).jumpToAvatarShareWindow(activity, bundle);
                        }
                        activity.finish();
                    }
                });
            }

            @Override // com.tencent.mobileqq.zplan.avatar.edit.g
            public void b() {
                final ZPlanAvatarPicEditFragment zPlanAvatarPicEditFragment = this.f331713a.get();
                if (zPlanAvatarPicEditFragment == null) {
                    return;
                }
                zPlanAvatarPicEditFragment.f331709y0.removeMessages(4);
                zPlanAvatarPicEditFragment.f331709y0.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.avatar.fragment.ZPlanAvatarPicEditFragment.13.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Dialog dialog = zPlanAvatarPicEditFragment.f331685a0;
                        if (dialog != null) {
                            dialog.dismiss();
                        }
                    }
                });
            }
        };
        this.R0 = new ConcurrentHashMap<>();
        this.S0 = new c();
        this.T0 = new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Aj(List<Integer> list) {
        this.f331699o0.i(new b.AvatarSaveReportParam(String.valueOf(this.X), this.Z, this.f331700p0, ZPlanEditAvatarUtils.f331613a.z(list), null));
    }

    private void Bj(boolean z16) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        if (z16) {
            str = "ev_zplan_avatar_loading_slide";
        } else {
            str = "ev_zplan_slide_back";
        }
        VideoReport.reportEvent(str, hashMap);
    }

    private void Cj() {
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(getQBaseActivity(), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_ZPLAN, QQPermissionConstants.Business.SCENE.VIDEO_EDITOR_SAVE_PIC));
        if (qQPermission != null && qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) != 0) {
            qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new n());
        } else {
            Fj();
        }
    }

    private void Dj() {
        List<com.tencent.mobileqq.zplan.avatar.edit.d> list = this.O0;
        if (list == null) {
            this.O0 = new ArrayList();
        } else {
            list.clear();
        }
        List<com.tencent.mobileqq.zplan.avatar.edit.d> list2 = this.P0;
        if (list2 == null) {
            this.P0 = new ArrayList();
        } else {
            list2.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fj() {
        com.tencent.mobileqq.zplan.avatar.edit.d ej5 = ej();
        if (ej5 == null) {
            QLog.w("ZPlanAvatarPicEditFragment-avatarEditor", 1, "saveToAlbum failed, editAvatarDataForSave null, return!!");
        } else {
            ((IZPlanEditAvatarApi) QRoute.api(IZPlanEditAvatarApi.class)).composeAvatar(ej5, aj(), new m());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gj(int i3, String str) {
        if (this.B0.size() == 0) {
            QLog.e("ZPlanAvatarPicEditFragment-avatarEditor", 1, "setActionPicPathByActionId mAvatarActionInfos is empty");
            return;
        }
        Runnable fj5 = fj(i3, str);
        if (ZPlanQQMC.INSTANCE.enableAvatarTimeCostOptimization()) {
            ThreadManagerV2.excute(fj5, 64, null, true);
        } else {
            ThreadManager.getFileThreadHandler().post(fj5);
        }
    }

    private void Hj() {
        this.A0.lock();
        if (this.G0.isEmpty()) {
            QLog.e("ZPlanAvatarPicEditFragment-avatarEditor", 1, "setBackgroundDataList failed, avatarBgInfosV2 invalid.");
            this.A0.unlock();
            return;
        }
        List<BackgroundInfo> list = this.M0;
        if (list == null) {
            this.M0 = new ArrayList();
        } else {
            list.clear();
        }
        QLog.i("ZPlanAvatarPicEditFragment-avatarEditor", 1, "setBackgroundDataList, listSize: " + this.G0.size());
        Iterator<ZPlanEditAvatarBackgroundData> it = this.G0.iterator();
        while (it.hasNext()) {
            ZPlanEditAvatarBackgroundData next = it.next();
            if (next != null) {
                this.M0.add(new BackgroundInfo(Integer.valueOf((int) next.getId()), next.getUrl()));
            }
        }
        this.A0.unlock();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kj() {
        List<com.tencent.mobileqq.zplan.avatar.edit.d> list;
        if (this.W == 1) {
            list = this.O0;
        } else {
            list = this.P0;
        }
        this.N0 = list;
        if (list != null && !list.isEmpty()) {
            QLog.i("ZPlanAvatarPicEditFragment-avatarEditor", 1, "setEditAvatarDataList, gender: " + this.W + ", listSize: " + this.N0.size());
            for (com.tencent.mobileqq.zplan.avatar.edit.d dVar : this.N0) {
                this.R0.put(Integer.valueOf(dVar.getActionId()), dVar);
            }
            return;
        }
        QLog.e("ZPlanAvatarPicEditFragment-avatarEditor", 1, "setBackgroundDataList failed, setEditAvatarDataList invalid.");
    }

    private Boolean Lj(d.c cVar) {
        String str = cVar.f331774m;
        if (TextUtils.isEmpty(str)) {
            QLog.i("ZPlanAvatarPicEditFragment-avatarEditor", 1, "setEventUpdateAvatarButtonIfNeed, eventInfo null.");
            return Boolean.FALSE;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("set_btn_text", "");
            String optString2 = jSONObject.optString("set_btn_bg_url", "");
            String optString3 = jSONObject.optString("jump_url", "");
            int optInt = jSONObject.optInt("has_bought", -1);
            QLog.i("ZPlanAvatarPicEditFragment-avatarEditor", 4, "setEventUpdateAvatarButtonIfNeed, actionId: " + cVar.f331764c + ", setButtonText: " + optString + ", hasBought: " + optInt);
            if (optInt == 0) {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
                obtain.mLoadingDrawable = drawable;
                obtain.mFailedDrawable = drawable;
                URLDrawable drawable2 = !TextUtils.isEmpty(optString2) ? URLDrawable.getDrawable(optString2, obtain) : null;
                this.f331696l0 = optString;
                this.M.setText(optString);
                if (drawable2 != null) {
                    this.M.setBackground(drawable2);
                } else {
                    this.M.setBackgroundResource(R.drawable.h6p);
                }
                this.M.setOnClickListener(new k(optString3));
                this.M.setVisibility(0);
                this.L.setVisibility(8);
                return Boolean.TRUE;
            }
            this.f331696l0 = "\u66f4\u6362\u5934\u50cf";
            this.M.setVisibility(8);
            this.L.setVisibility(0);
            return Boolean.FALSE;
        } catch (Throwable th5) {
            QLog.e("ZPlanAvatarPicEditFragment-avatarEditor", 1, "setEventUpdateAvatarButtonIfNeed failed.", th5);
            this.f331696l0 = "\u66f4\u6362\u5934\u50cf";
            this.M.setVisibility(8);
            this.L.setVisibility(0);
            return Boolean.FALSE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nj(boolean z16) {
        QLog.i("ZPlanAvatarPicEditFragment-avatarEditor", 4, "[setSaveFunctionEnable] enable:" + z16);
        LinearLayout linearLayout = this.H;
        if (linearLayout != null) {
            linearLayout.setEnabled(z16);
        }
        ImageView imageView = this.G;
        if (imageView != null) {
            imageView.setEnabled(z16);
            this.G.setAlpha(z16 ? 1.0f : 0.2f);
        }
        TextView textView = this.K;
        if (textView != null) {
            textView.setEnabled(z16);
            this.K.setAlpha(z16 ? 1.0f : 0.2f);
        }
        TextView textView2 = this.L;
        if (textView2 != null) {
            textView2.setEnabled(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pj() {
        int dj5;
        if (!this.f331688d0) {
            QLog.d("ZPlanAvatarPicEditFragment-avatarEditor", 1, "[showPopupTipsForNewUser] old user");
            return;
        }
        if (((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getBoolean("ZPLAN_AVATAR_EDIT_GUIDE", false)) {
            QLog.d("ZPlanAvatarPicEditFragment-avatarEditor", 1, "[showPopupTipsForNewUser] has shown");
            return;
        }
        if (!isAdded()) {
            QLog.d("ZPlanAvatarPicEditFragment-avatarEditor", 1, "[showPopupTipsForNewUser] Fragment not attached to a context");
            return;
        }
        try {
            CalloutPopupWindow.Builder textColor = CalloutPopupWindow.builder(getContext()).setText(getString(R.string.xl_)).setTextSize(14.0f).setTextColor(-1);
            textColor.setPosition(50);
            textColor.setLifetime(3);
            if (QQTheme.isNowThemeIsNight()) {
                dj5 = dj(R.color.c4t);
            } else {
                dj5 = dj(R.color.c4v);
            }
            CalloutPopupWindow build = new CalloutPopupWindow.DrawableBuilder(textColor).setBackgroundColor(dj5).setBackgroundRadius(8).build().build();
            if (build != null) {
                build.showAsPointer(this.E);
                ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setBoolean("ZPLAN_AVATAR_EDIT_GUIDE", true);
                QLog.d("ZPlanAvatarPicEditFragment-avatarEditor", 1, "[showPopupTipsForNewUser] show");
            }
        } catch (Throwable th5) {
            QLog.e("ZPlanAvatarPicEditFragment-avatarEditor", 1, "[showPopupTipsForNewUser] error", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ri() {
        AppInterface c16 = bb.f335811a.c();
        if (c16 == null) {
            return;
        }
        VideoReport.resetPageStats();
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        hashMap.put("zplan_is_avatar", Integer.valueOf(ZPlanEditAvatarUtils.f331613a.X(c16) ? 1 : 0));
        hashMap.put("zplan_avatar_edit_entrance", this.f331700p0);
        VideoReport.setPageParams(this.D, new PageParams(hashMap));
        VideoReport.setPageId(this.D, "pg_zplan_avatar_edit");
        VideoReport.setElementId(this.F, "em_zplan_back_btn");
        ImageView imageView = this.F;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_FIRST;
        VideoReport.setElementExposePolicy(imageView, exposurePolicy);
        ImageView imageView2 = this.F;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        VideoReport.setElementClickPolicy(imageView2, clickPolicy);
        VideoReport.setElementId(this.E, "em_zplan_dress_up");
        VideoReport.setElementExposePolicy(this.E, exposurePolicy);
        VideoReport.setElementClickPolicy(this.E, clickPolicy);
        VideoReport.setElementId(this.H, "em_zplan_save");
        VideoReport.setElementExposePolicy(this.H, exposurePolicy);
        VideoReport.setElementClickPolicy(this.H, clickPolicy);
        VideoReport.setElementParams(this.H, getElementParams());
        VideoReport.setElementId(this.L, "em_zplan_change_avatar");
        TextView textView = this.L;
        ExposurePolicy exposurePolicy2 = ExposurePolicy.REPORT_ALL;
        VideoReport.setElementExposePolicy(textView, exposurePolicy2);
        TextView textView2 = this.L;
        EndExposurePolicy endExposurePolicy = EndExposurePolicy.REPORT_ALL;
        VideoReport.setElementEndExposePolicy(textView2, endExposurePolicy);
        TextView textView3 = this.L;
        ClickPolicy clickPolicy2 = ClickPolicy.REPORT_ALL;
        VideoReport.setElementClickPolicy(textView3, clickPolicy2);
        VideoReport.setEventDynamicParams(this.L, bj());
        VideoReport.setElementId(this.M, "em_zplan_change_avatar");
        VideoReport.setElementExposePolicy(this.M, exposurePolicy2);
        VideoReport.setElementEndExposePolicy(this.M, endExposurePolicy);
        VideoReport.setElementClickPolicy(this.M, clickPolicy2);
        VideoReport.setEventDynamicParams(this.M, bj());
        VideoReport.setElementId(this.I, "em_avatar_share_to_qzone");
        VideoReport.setElementExposePolicy(this.I, exposurePolicy);
        VideoReport.setElementClickPolicy(this.I, clickPolicy);
        VideoReport.traversePage(this.D);
    }

    private void Rj(final String str, final int i3) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.avatar.fragment.ZPlanAvatarPicEditFragment.20
            @Override // java.lang.Runnable
            public void run() {
                QQToast.makeText(BaseApplication.getContext(), i3, str, 0).show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Si(int i3, String str) {
        this.A0.lock();
        if (this.C0.size() != 0 && !TextUtils.isEmpty(str)) {
            int i16 = 0;
            int i17 = 0;
            int i18 = -1;
            int i19 = -1;
            while (true) {
                if (i17 >= this.C0.size()) {
                    i17 = i18;
                    break;
                }
                e.a aVar = this.C0.get(i17);
                if (str.equals(aVar.f331778c)) {
                    if (TextUtils.isEmpty(this.Z) || str.equals(this.Z)) {
                        break;
                    } else {
                        i18 = i17;
                    }
                }
                if (!TextUtils.isEmpty(this.Z) && this.Z.equals(aVar.f331778c)) {
                    i19 = i17;
                }
                i17++;
            }
            if (i17 == -1) {
                QLog.e("ZPlanAvatarPicEditFragment-avatarEditor", 1, "checkCurrBgPosition index\u4e0b\u67b6 \u63d2\u5165\u961f\u5217\u5934 netBgUrl:" + str);
                this.C0.add(0, new e.a(true, i3, str));
            } else {
                i16 = i17;
            }
            if (i19 != -1) {
                this.f331687c0 = i19;
            } else {
                this.f331687c0 = i16;
            }
            this.A0.unlock();
            return;
        }
        this.A0.unlock();
    }

    private void Sj() {
        this.A0.lock();
        if (!this.F0.isEmpty() && !this.G0.isEmpty()) {
            QLog.i("ZPlanAvatarPicEditFragment-avatarEditor", 1, "transToEditAvatarData, gender: " + this.W);
            Dj();
            Iterator<ZPlanEditAvatarHeadActionData> it = this.F0.iterator();
            while (it.hasNext()) {
                com.tencent.mobileqq.zplan.avatar.edit.d a16 = ZPlanEditAvatarHeadActionData.INSTANCE.a(it.next(), this.W);
                if (a16 != null) {
                    if (this.W == 1) {
                        this.O0.add(a16);
                    } else {
                        this.P0.add(a16);
                    }
                }
            }
            this.A0.unlock();
            Kj();
            Hj();
            kj(this.N0, this.M0);
            return;
        }
        this.A0.unlock();
    }

    private void Ti(Priority priority, int i3) {
        QLog.d("ZPlanAvatarPicEditFragment-avatarEditor", 1, "checkShouldRecordAgain start");
        if (this.f331706v0) {
            QLog.i("ZPlanAvatarPicEditFragment-avatarEditor", 1, "checkShouldRecordAgain, enableZPlanEditAvatarV2 true, no need check.");
            return;
        }
        if (this.B0.size() < 1) {
            return;
        }
        String e16 = bb.f335811a.e();
        if (TextUtils.isEmpty(e16)) {
            QLog.w("ZPlanAvatarPicEditFragment-avatarEditor", 1, "checkShouldRecordAgain currentUin empty, return");
            return;
        }
        ZPlanUserInfo userZPlanInfo = ((IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class)).getUserZPlanInfo(e16);
        String str = userZPlanInfo.appearanceKey;
        int i16 = userZPlanInfo.gender;
        if ((TextUtils.isEmpty(str) || str.equals(this.V)) && i16 == this.W) {
            return;
        }
        this.V = str;
        if (i16 != this.W) {
            this.W = i16;
            QLog.d("ZPlanAvatarPicEditFragment-avatarEditor", 1, "handleAppearanceKeyChanged gender change");
            Kj();
            kj(this.N0, this.M0);
            return;
        }
        List<Integer> list = this.f331710z0;
        if (list != null) {
            QLog.d("ZPlanAvatarPicEditFragment-avatarEditor", 1, "recordEditAvatar \u4e22\u53bb\u91cd\u65b0\u5f55\u5236 actionId:", list);
            sj(priority, i3);
        }
    }

    private boolean Ui() {
        int i3;
        int i16 = this.f331691g0;
        if (i16 == -1 || (i3 = this.f331692h0) == -1) {
            return false;
        }
        return (i16 == this.f331686b0 && i3 == this.f331687c0) ? false : true;
    }

    private void Uj() {
        QLog.i("ZPlanAvatarPicEditFragment-avatarEditor", 1, "[requestConfigData] updateAvatarInfos start, isRequesting: " + this.f331708x0);
        AppInterface c16 = bb.f335811a.c();
        if (c16 == null) {
            QLog.w("ZPlanAvatarPicEditFragment-avatarEditor", 1, "getEditAvatarInfo app null, return!!");
            return;
        }
        if (this.f331708x0) {
            QLog.i("ZPlanAvatarPicEditFragment-avatarEditor", 1, "[requestConfigData] processing, please wait.");
            return;
        }
        this.f331708x0 = true;
        ZPlanEditAvatarDataManager.f331961a.f(c16.getLongAccountUin(), this.W, new j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wi() {
        com.tencent.mobileqq.zplan.avatar.fragment.d dVar = this.Q;
        if (dVar != null) {
            dVar.o0(this.B0);
            this.Q.r0(this.f331686b0);
            this.Q.notifyDataSetChanged();
            Ij(this.f331686b0);
            this.Q.q0(this.X);
        }
        com.tencent.mobileqq.zplan.avatar.fragment.e eVar = this.R;
        if (eVar != null) {
            eVar.p0(this.C0);
            this.R.r0(this.f331687c0);
            this.R.notifyDataSetChanged();
            Jj(this.f331687c0);
            this.R.q0(this.Z);
        }
    }

    private void Xi() {
        QLog.d("ZPlanAvatarPicEditFragment-avatarEditor", 1, "[fillDefaultAppearanceAvatarActionInfo]");
        if (this.B0.size() == 0) {
            QLog.e("ZPlanAvatarPicEditFragment-avatarEditor", 1, "[fillDefaultAppearanceAvatarActionInfo] mAvatarActionInfos empty");
            return;
        }
        if (this.S == null) {
            QLog.e("ZPlanAvatarPicEditFragment-avatarEditor", 1, "[fillDefaultAppearanceAvatarActionInfo] mResourceManager empty");
            return;
        }
        Iterator<d.c> it = this.B0.iterator();
        while (it.hasNext()) {
            d.c next = it.next();
            if (next != null && !TextUtils.isEmpty(next.f331768g)) {
                ZPlanAvatarShpImageUploadDownloadUtils.i().f(next.f331768g, new e(next));
            } else {
                QLog.d("ZPlanAvatarPicEditFragment-avatarEditor", 1, "[fillDefaultAppearanceAvatarActionInfo] actionDefaultPicUrl empty");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yi() {
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = this.C;
        long j16 = currentTimeMillis - j3 < 500 ? (500 - currentTimeMillis) + j3 : 0L;
        this.f331709y0.removeMessages(1);
        this.f331709y0.sendEmptyMessageDelayed(3, j16);
    }

    private d.c Zi() {
        int size = this.B0.size();
        int i3 = this.f331686b0;
        if (size > i3) {
            return this.B0.get(i3);
        }
        return null;
    }

    private String aj() {
        d.c cVar;
        String str;
        int size = this.B0.size();
        int i3 = this.f331686b0;
        return (size <= i3 || (cVar = this.B0.get(i3)) == null || (str = cVar.f331766e) == null) ? "" : str;
    }

    private IDynamicParams bj() {
        return new f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> cj() {
        Map<String, Object> elementParams = getElementParams();
        elementParams.put("zplan_btn_text", this.f331696l0);
        return elementParams;
    }

    private int dj(int i3) {
        try {
            return getQBaseActivity().getResources().getColor(i3);
        } catch (Exception e16) {
            QLog.e("ZPlanAvatarPicEditFragment-avatarEditor", 1, "[getColor] error:", e16);
            return -16777216;
        }
    }

    private Runnable fj(final int i3, final String str) {
        return new Runnable() { // from class: com.tencent.mobileqq.zplan.avatar.fragment.ZPlanAvatarPicEditFragment.12
            @Override // java.lang.Runnable
            public void run() {
                Source source;
                if (ZPlanAvatarPicEditFragment.this.B0.size() != 0) {
                    if (ZPlanAvatarPicEditFragment.this.S == null) {
                        QLog.e("ZPlanAvatarPicEditFragment-avatarEditor", 1, "setActionPicPathByActionId mResourceManager is null");
                        return;
                    }
                    com.tencent.mobileqq.zplan.avatar.edit.d dVar = (ZPlanAvatarPicEditFragment.this.R0 == null || !ZPlanAvatarPicEditFragment.this.R0.containsKey(Integer.valueOf(i3))) ? null : (com.tencent.mobileqq.zplan.avatar.edit.d) ZPlanAvatarPicEditFragment.this.R0.get(Integer.valueOf(i3));
                    ZPlanEditAvatarUtils zPlanEditAvatarUtils = ZPlanEditAvatarUtils.f331613a;
                    String B = zPlanEditAvatarUtils.B(i3, str, dVar, ZPlanAvatarPicEditFragment.this.V, 1);
                    if (TextUtils.isEmpty(B)) {
                        QLog.e("ZPlanAvatarPicEditFragment-avatarEditor", 1, "crop avatar out of frame failed.");
                        return;
                    }
                    String B2 = zPlanEditAvatarUtils.B(i3, str, dVar, ZPlanAvatarPicEditFragment.this.V, 0);
                    if (TextUtils.isEmpty(B2)) {
                        QLog.e("ZPlanAvatarPicEditFragment-avatarEditor", 1, "crop normal avatar failed.");
                        return;
                    }
                    QLog.i("ZPlanAvatarPicEditFragment-avatarEditor", 1, "crop done, id: " + i3 + ", inBoundsPath: " + B2 + ", outBoundsPath: " + B);
                    Iterator it = ZPlanAvatarPicEditFragment.this.B0.iterator();
                    while (it.hasNext()) {
                        d.c cVar = (d.c) it.next();
                        if (cVar.f331764c == i3) {
                            cVar.f331766e = B2;
                            cVar.f331765d = B;
                            cVar.f331767f = B2;
                        }
                    }
                    QLog.i("ZPlanAvatarPicEditFragment-avatarEditor", 1, "setActionPicPathByActionId id:" + i3 + " path:" + str);
                    ZPlanAvatarPicEditFragment.this.S.a(i3, 1, str);
                    List<Integer> c16 = ZPlanAvatarPicEditFragment.this.S.c(ZPlanAvatarPicEditFragment.this.f331710z0, ZPlanAvatarPicEditFragment.this.f331690f0);
                    if (c16 != null) {
                        if (!ZPlanAvatarPicEditFragment.this.f331689e0) {
                            QLog.i("ZPlanAvatarPicEditFragment-avatarEditor", 1, "\u5f55\u5236\u5b8c\u6210\u7528\u65f6" + (System.currentTimeMillis() - ZPlanAvatarPicEditFragment.this.C) + "ms");
                            Iterator<Integer> it5 = c16.iterator();
                            while (it5.hasNext()) {
                                int intValue = it5.next().intValue();
                                if (ZPlanAvatarPicEditFragment.this.f331705u0 != null && ZPlanAvatarPicEditFragment.this.f331705u0.containsKey(Integer.valueOf(intValue)) && (source = (Source) ZPlanAvatarPicEditFragment.this.f331705u0.get(Integer.valueOf(intValue))) != null) {
                                    if (source == Source.LOCAL_CACHE) {
                                        ZPlanAvatarPicEditFragment.this.f331702r0++;
                                    } else if (source == Source.CLOUD_CACHE) {
                                        ZPlanAvatarPicEditFragment.this.f331703s0++;
                                    } else {
                                        ZPlanAvatarPicEditFragment.this.f331704t0++;
                                    }
                                }
                            }
                        }
                        ZPlanAvatarPicEditFragment.this.f331689e0 = true;
                        ZPlanAvatarPicEditFragment.this.Yi();
                        return;
                    }
                    if (ZPlanAvatarPicEditFragment.this.S.b(ZPlanAvatarPicEditFragment.this.f331710z0, ZPlanAvatarPicEditFragment.this.f331690f0)) {
                        ZPlanAvatarPicEditFragment.this.mj(3);
                        return;
                    }
                    return;
                }
                QLog.e("ZPlanAvatarPicEditFragment-avatarEditor", 1, "setActionPicPathByActionId mAvatarActionInfos is empty");
            }
        };
    }

    private Map<String, Object> getElementParams() {
        HashMap hashMap = new HashMap();
        hashMap.put("zplan_current_action", Integer.valueOf(this.X));
        hashMap.put("zplan_current_background_id", this.Z);
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gj(final boolean z16) {
        AppInterface c16 = bb.f335811a.c();
        if (c16 == null) {
            QLog.w("ZPlanAvatarPicEditFragment-avatarEditor", 1, "getEditAvatarInfo app null, return!!");
            return;
        }
        long longAccountUin = c16.getLongAccountUin();
        ZPlanEditAvatarUtils zPlanEditAvatarUtils = ZPlanEditAvatarUtils.f331613a;
        if (!zPlanEditAvatarUtils.X(c16)) {
            List<Integer> list = this.f331710z0;
            if (list != null) {
                QLog.d("ZPlanAvatarPicEditFragment-avatarEditor", 1, "[getEditAvatarInfo] \u4e0d\u662fzplan\u5934\u50cf \u4e22\u53bb\u5f55\u5236 actionId:", list.toString());
            }
            sj(Priority.MIDDLE, 0);
            return;
        }
        zPlanEditAvatarUtils.J(longAccountUin, new com.tencent.mobileqq.zplan.avatar.edit.f() { // from class: com.tencent.mobileqq.zplan.avatar.fragment.ZPlanAvatarPicEditFragment.4
            @Override // com.tencent.mobileqq.zplan.avatar.edit.f
            public void a(boolean z17, com.tencent.mobileqq.zplan.avatar.edit.d dVar) {
                String str;
                QLog.d("ZPlanAvatarPicEditFragment-avatarEditor", 1, "[getEditAvatarInfo]:" + z17 + ",EditAvatarData\uff1a" + dVar);
                if (z17) {
                    if (dVar == null) {
                        ZPlanAvatarPicEditFragment.this.f331688d0 = true;
                    } else {
                        int i3 = -1;
                        if (dVar.getBackgroundInfo() != null) {
                            str = dVar.getBackgroundInfo().getUrl();
                            Integer id5 = dVar.getBackgroundInfo().getId();
                            if (id5 != null && id5.intValue() != -1) {
                                i3 = id5.intValue();
                            } else if (!TextUtils.isEmpty(str)) {
                                i3 = ZPlanEditAvatarUtils.f331613a.D(str);
                            }
                        } else {
                            QLog.w("ZPlanAvatarPicEditFragment-avatarEditor", 1, "[getEditAvatarInfo] from net, editAvatarData.backgroundInfo null.");
                            str = "";
                        }
                        ZPlanAvatarPicEditFragment.this.Ej(dVar);
                        ZPlanAvatarPicEditFragment.this.Si(i3, str);
                        ZPlanAvatarPicEditFragment zPlanAvatarPicEditFragment = ZPlanAvatarPicEditFragment.this;
                        zPlanAvatarPicEditFragment.f331710z0 = ZPlanEditAvatarUtils.f331613a.F(dVar, zPlanAvatarPicEditFragment.N0);
                    }
                } else if (z16) {
                    ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.zplan.avatar.fragment.ZPlanAvatarPicEditFragment.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ZPlanAvatarPicEditFragment.this.gj(false);
                        }
                    }, 16, null, false, 1000L);
                }
                QLog.d("ZPlanAvatarPicEditFragment-avatarEditor", 1, "recordEditAvatar \u4e22\u53bb\u5f55\u5236 actionId:", ZPlanAvatarPicEditFragment.this.f331710z0.toString());
                ZPlanAvatarPicEditFragment.this.sj(Priority.MIDDLE, 0);
            }
        });
    }

    private boolean ij() {
        String e16 = bb.f335811a.e();
        if (TextUtils.isEmpty(e16)) {
            return false;
        }
        if (TextUtils.isEmpty(this.V)) {
            this.V = ((IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class)).getUserZPlanInfo(e16).appearanceKey;
        }
        if (!TextUtils.isEmpty(this.V) && !"zplan_default_appearance_key".equals(this.V)) {
            return false;
        }
        QLog.d("ZPlanAvatarPicEditFragment-avatarEditor", 1, "[getIsZplanHasDefaultAppearance] zplan has default appearanceKey");
        return true;
    }

    private void initDtReport() {
        AppInterface c16 = bb.f335811a.c();
        if (c16 == null) {
            return;
        }
        VideoReport.addToDetectionWhitelist(getActivity());
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        hashMap.put("zplan_is_avatar", Integer.valueOf(ZPlanEditAvatarUtils.f331613a.X(c16) ? 1 : 0));
        hashMap.put("zplan_avatar_edit_entrance", this.f331700p0);
        VideoReport.setPageParams(this.N, new PageParams(hashMap));
        VideoReport.setPageId(this.N, "pg_zplan_avatar_edit_loading");
        RecyclerView recyclerView = this.T;
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(new g());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jj(List<String> list) {
        QLog.i("ZPlanAvatarPicEditFragment-avatarEditor", 1, "handleAppearanceKeyChanged");
        String e16 = bb.f335811a.e();
        if (TextUtils.isEmpty(e16)) {
            QLog.w("ZPlanAvatarPicEditFragment-avatarEditor", 1, "handleAppearanceKeyChanged, empty curUin");
        } else if (!list.contains(e16)) {
            QLog.i("ZPlanAvatarPicEditFragment-avatarEditor", 1, "handleAppearanceKeyChanged, do not contains curUin");
        } else {
            Mj(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kj(List<com.tencent.mobileqq.zplan.avatar.edit.d> list, List<BackgroundInfo> list2) {
        Integer id5;
        this.A0.lock();
        if (list != null && list.size() != 0 && list2 != null && list2.size() != 0) {
            this.B0.clear();
            for (com.tencent.mobileqq.zplan.avatar.edit.d dVar : list) {
                d.c Vi = Vi(dVar);
                if (Vi != null) {
                    this.B0.add(Vi);
                    this.f331710z0.add(Integer.valueOf(dVar.getActionId()));
                }
            }
            this.C0.clear();
            for (BackgroundInfo backgroundInfo : list2) {
                if (backgroundInfo != null && (id5 = backgroundInfo.getId()) != null && id5.intValue() != -1 && !TextUtils.isEmpty(backgroundInfo.getUrl())) {
                    e.a aVar = new e.a();
                    aVar.f331777b = id5.intValue();
                    aVar.f331778c = backgroundInfo.getUrl();
                    this.C0.add(aVar);
                }
            }
            this.A0.unlock();
            gj(true);
            return;
        }
        QLog.e("ZPlanAvatarPicEditFragment-avatarEditor", 1, "handleConfig failed, avatarList or bgList invalid.");
        this.A0.unlock();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lj() {
        this.A0.lock();
        this.F0.clear();
        for (nu4.g gVar : this.J0) {
            if (gVar != null && gVar.f421361id > 0) {
                this.F0.add(new ZPlanEditAvatarHeadActionData(gVar, this.V, "", "", false));
            }
        }
        this.G0.clear();
        for (nu4.a aVar : this.K0) {
            if (aVar != null) {
                this.G0.add(new ZPlanEditAvatarBackgroundData(aVar.f421348id, aVar.url, false));
            }
        }
        this.A0.unlock();
        Sj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mj(int i3) {
        xj(i3);
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    private void nj(boolean z16) {
        QLog.i("ZPlanAvatarPicEditFragment-avatarEditor", 4, "hideSaveAndShareFunctionIfNeed, needHideSaveAndShare : " + z16);
        if (z16) {
            this.H.setVisibility(8);
            this.I.setVisibility(8);
        } else {
            this.H.setVisibility(0);
            this.I.setVisibility(0);
        }
    }

    private void qj(LayoutInflater layoutInflater) {
        this.D.setBackgroundColor(dj(R.color.qui_common_bg_bottom_light));
        ((LinearLayout) this.D.findViewById(R.id.qi9)).setPadding(0, ImmersiveUtils.getStatusBarHeight(layoutInflater.getContext()), 0, 0);
        ZPlanAvatarSettingLoadingView zPlanAvatarSettingLoadingView = (ZPlanAvatarSettingLoadingView) this.D.findViewById(R.id.f163625r44);
        this.N = zPlanAvatarSettingLoadingView;
        ((ImageView) zPlanAvatarSettingLoadingView.findViewById(R.id.pfb)).setOnClickListener(this);
        ImageView imageView = (ImageView) this.D.findViewById(R.id.pfa);
        this.F = imageView;
        imageView.setOnClickListener(this);
        ImageView imageView2 = (ImageView) this.D.findViewById(R.id.pfi);
        this.E = imageView2;
        imageView2.setOnClickListener(this);
        TextView textView = (TextView) this.D.findViewById(R.id.pfj);
        this.L = textView;
        textView.setOnClickListener(this);
        this.M = (TextView) this.D.findViewById(R.id.pfk);
        LinearLayout linearLayout = (LinearLayout) this.D.findViewById(R.id.qj7);
        this.H = linearLayout;
        linearLayout.setOnClickListener(this);
        this.G = (ImageView) this.H.findViewById(R.id.q48);
        this.K = (TextView) this.H.findViewById(R.id.qqj);
        LinearLayout linearLayout2 = (LinearLayout) this.D.findViewById(R.id.qky);
        this.I = linearLayout2;
        linearLayout2.setOnClickListener(this);
        if (sa0.b.c() && ("1".equals(this.f331700p0) || "2".equals(this.f331700p0) || "3".equals(this.f331700p0) || "4".equals(this.f331700p0))) {
            this.I.setVisibility(8);
        }
        this.J = (CheckBox) this.D.findViewById(R.id.qkw);
        boolean z16 = ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getBoolean("ZPLAN_AVATAR_EDIT_SYNC_QZONE", false);
        this.f331694j0 = z16;
        this.J.setChecked(z16);
        this.P = (ZPlanRoundImageLayout) this.D.findViewById(R.id.f163293pc2);
        com.tencent.mobileqq.zplan.avatar.fragment.b bVar = new com.tencent.mobileqq.zplan.avatar.fragment.b(getContext());
        this.D0 = bVar;
        bVar.setOrientation(0);
        this.Q = new com.tencent.mobileqq.zplan.avatar.fragment.d(getContext(), this);
        RecyclerView recyclerView = (RecyclerView) this.D.findViewById(R.id.pbh);
        this.T = recyclerView;
        if (recyclerView != null) {
            if (recyclerView.getItemAnimator() != null) {
                ((SimpleItemAnimator) this.T.getItemAnimator()).setSupportsChangeAnimations(false);
            }
            this.T.setLayoutManager(this.D0);
            this.T.setAdapter(this.Q);
        }
        com.tencent.mobileqq.zplan.avatar.fragment.b bVar2 = new com.tencent.mobileqq.zplan.avatar.fragment.b(getContext());
        this.E0 = bVar2;
        bVar2.setOrientation(0);
        this.R = new com.tencent.mobileqq.zplan.avatar.fragment.e(getContext(), this);
        RecyclerView recyclerView2 = (RecyclerView) this.D.findViewById(R.id.pbk);
        this.U = recyclerView2;
        if (recyclerView2 != null) {
            if (recyclerView2.getItemAnimator() != null) {
                ((SimpleItemAnimator) this.U.getItemAnimator()).setSupportsChangeAnimations(false);
            }
            this.U.setLayoutManager(this.E0);
            this.U.setAdapter(this.R);
        }
        Oj();
        Nj(false);
        Mj(true);
        initDtReport();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean rj() {
        if (!this.f331693i0) {
            QLog.e("ZPlanAvatarPicEditFragment-avatarEditor", 1, "page is not ready");
            return false;
        }
        if (this.X < 1) {
            QLog.e("ZPlanAvatarPicEditFragment-avatarEditor", 4, "actionId invalid");
            return false;
        }
        if (TextUtils.isEmpty(aj())) {
            QLog.e("ZPlanAvatarPicEditFragment-avatarEditor", 1, "actionPicUrl invalid");
            return false;
        }
        if (!TextUtils.isEmpty(this.Z)) {
            return true;
        }
        QLog.e("ZPlanAvatarPicEditFragment-avatarEditor", 1, "bgUrl invalid");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sj(Priority priority, int i3) {
        QLog.d("ZPlanAvatarPicEditFragment-avatarEditor", 1, "recordEditAvatar-recordAction start");
        String e16 = bb.f335811a.e();
        if (TextUtils.isEmpty(e16)) {
            QLog.w("ZPlanAvatarPicEditFragment-avatarEditor", 1, "recordEditAvatar-recordAction currentUin null!!");
            return;
        }
        com.tencent.mobileqq.zplan.avatar.fragment.f fVar = new com.tencent.mobileqq.zplan.avatar.fragment.f(this.f331710z0, e16);
        this.S = fVar;
        fVar.prepare();
        if (ij()) {
            QLog.d("ZPlanAvatarPicEditFragment-avatarEditor", 1, "[recordAction] default appearanceKey no need to record");
            Xi();
        } else {
            this.f331689e0 = false;
            this.f331693i0 = false;
            ZPlanEditAvatarUtils.f331613a.a0(com.tencent.mobileqq.zplan.avatar.edit.d.l(this.f331710z0, e16, this.V), priority, i3, this.H0, Integer.valueOf(this.f331690f0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uj(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        hashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, "em_zplan_dress_up");
        hashMap.put("zplan_action_type", str);
        VideoReport.reportEvent("ev_zplan_external_entrance_action", hashMap);
        if ("click".equals(str)) {
            VideoReport.reportEvent("clck", this.E, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vj(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        hashMap.put("zplan_action_type", str2);
        VideoReport.reportEvent(str, hashMap);
    }

    private void wj() {
        Source source;
        com.tencent.mobileqq.zplan.avatar.fragment.f fVar = this.S;
        if (fVar == null) {
            QLog.e("ZPlanAvatarPicEditFragment-avatarEditor", 1, "reportLeaveAvatarEdit fail, mResourceManager null.");
            return;
        }
        List<Integer> d16 = fVar.d(this.f331710z0);
        if (d16 == null) {
            QLog.e("ZPlanAvatarPicEditFragment-avatarEditor", 1, "reportLeaveAvatarEdit failed, preparedList null.");
            return;
        }
        int size = d16.size();
        Iterator<Integer> it = d16.iterator();
        int i3 = 0;
        int i16 = 0;
        int i17 = 0;
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            ConcurrentHashMap<Integer, Source> concurrentHashMap = this.f331705u0;
            if (concurrentHashMap != null && concurrentHashMap.containsKey(Integer.valueOf(intValue)) && (source = this.f331705u0.get(Integer.valueOf(intValue))) != null) {
                if (source == Source.LOCAL_CACHE) {
                    i3++;
                } else if (source == Source.CLOUD_CACHE) {
                    i16++;
                } else {
                    i17++;
                }
            }
        }
        String str = this.f331700p0;
        Integer valueOf = Integer.valueOf(size);
        Integer valueOf2 = Integer.valueOf(i3);
        Integer valueOf3 = Integer.valueOf(i16);
        Integer valueOf4 = Integer.valueOf(i17);
        String str2 = this.V;
        this.f331699o0.e(new b.AvatarEditLeaveParam(str, valueOf, valueOf2, valueOf3, valueOf4, str2, Boolean.valueOf("zplan_default_appearance_key".equals(str2)), this.f331701q0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(int i3) {
        String valueOf = String.valueOf(System.currentTimeMillis() - this.C);
        String str = this.f331700p0;
        Integer valueOf2 = Integer.valueOf(this.f331702r0);
        Integer valueOf3 = Integer.valueOf(this.f331703s0);
        Integer valueOf4 = Integer.valueOf(this.f331704t0);
        String str2 = this.V;
        this.f331699o0.f(new b.AvatarLoadingReportParam(valueOf, str, valueOf2, valueOf3, valueOf4, str2, Boolean.valueOf("zplan_default_appearance_key".equals(str2)), this.f331701q0, String.valueOf(i3)));
    }

    private void yj() {
        String valueOf = String.valueOf(System.currentTimeMillis() - this.C);
        String str = this.f331700p0;
        Integer valueOf2 = Integer.valueOf(this.f331702r0);
        Integer valueOf3 = Integer.valueOf(this.f331703s0);
        Integer valueOf4 = Integer.valueOf(this.f331704t0);
        String str2 = this.V;
        this.f331699o0.g(new b.AvatarLoadingReportParam(valueOf, str, valueOf2, valueOf3, valueOf4, str2, Boolean.valueOf("zplan_default_appearance_key".equals(str2)), this.f331701q0, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zj(int i3, List<Integer> list) {
        this.f331699o0.h(new b.AvatarSaveReportParam(String.valueOf(this.X), this.Z, this.f331700p0, ZPlanEditAvatarUtils.f331613a.z(list), String.valueOf(i3)));
    }

    public void Ij(int i3) {
        if (i3 >= 0 && i3 < this.B0.size()) {
            this.f331686b0 = i3;
            d.c cVar = this.B0.get(i3);
            if (cVar == null) {
                QLog.e("ZPlanAvatarPicEditFragment-avatarEditor", 1, "setCurAction failed, curInfo null.");
                return;
            }
            boolean isOutboundHeadFeatureOn = ((IQQZplanOutsideAvatarApi) QRoute.api(IQQZplanOutsideAvatarApi.class)).isOutboundHeadFeatureOn();
            boolean j06 = ZPlanFeatureSwitch.f369852a.j0();
            boolean z16 = isOutboundHeadFeatureOn && j06;
            QLog.i("ZPlanAvatarPicEditFragment-avatarEditor", 4, "enableOutFrame: " + isOutboundHeadFeatureOn + ", enableZPlanSettingOutFrame: " + j06 + " curInfo.avatarNormalPath\uff1a" + cVar.f331766e + " curInfo.avatarOutOfFramePath\uff1a" + cVar.f331765d);
            String str = cVar.f331766e;
            if (z16) {
                str = cVar.f331765d;
            }
            if (TextUtils.isEmpty(str)) {
                Nj(false);
                return;
            }
            this.X = cVar.f331764c;
            this.P.setAvatarImageUrl(str, Boolean.valueOf(z16), cVar.f331770i);
            boolean booleanValue = this.f331706v0 ? Lj(cVar).booleanValue() : false;
            nj(booleanValue);
            Nj(rj() && !booleanValue);
            return;
        }
        QLog.e("ZPlanAvatarPicEditFragment-avatarEditor", 1, "[setCurAction] invalid position:" + i3);
        Nj(false);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        if (Ui()) {
            DialogUtil.createNoTitleDialog(getActivity(), getString(R.string.xl9), R.string.f169768xi0, R.string.xkd, new a(), new b()).show();
            vj("ev_zplan_popup_confirm", "imp");
            vj("ev_zplan_popup_cancel", "imp");
            return true;
        }
        if (getActivity() != null) {
            getActivity().finish();
        }
        ZPlanAvatarSettingLoadingView zPlanAvatarSettingLoadingView = this.N;
        if (zPlanAvatarSettingLoadingView != null && zPlanAvatarSettingLoadingView.getVisibility() == 0) {
            xj(5);
            Bj(true);
        } else {
            Bj(false);
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AppInterface appInterface;
        super.onCreate(bundle);
        this.D = layoutInflater.inflate(R.layout.d2v, viewGroup, false);
        this.f331708x0 = false;
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity != null) {
            appInterface = (AppInterface) qBaseActivity.getAppRuntime();
            Intent intent = qBaseActivity.getIntent();
            if (intent != null) {
                this.f331700p0 = intent.getStringExtra("intent_source");
            }
        } else {
            appInterface = null;
        }
        this.f331701q0 = hj(appInterface);
        qj(layoutInflater);
        pj(appInterface);
        if (!this.f331707w0) {
            oj(appInterface);
        }
        return this.D;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        AppInterface c16 = bb.f335811a.c();
        if (c16 != null) {
            c16.removeObserver(this.S0);
            c16.removeObserver(this.T0);
        }
        this.f331709y0.removeCallbacksAndMessages(null);
        getQBaseActivity().removeObserver(this.S0);
        if (c16 != null) {
            ((IZPlanEditAvatarApi) QRoute.api(IZPlanEditAvatarApi.class)).setUploadHandler(c16, null);
        }
        ZPlanPreRecordManager.f334206e.n(null);
        this.Q = null;
        this.R = null;
        this.H0 = null;
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        QLog.i("ZPlanAvatarPicEditFragment-avatarEditor", 1, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        this.f331708x0 = false;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (!this.f331706v0) {
            QLog.i("ZPlanAvatarPicEditFragment-avatarEditor", 1, "enableZPlanEditAvatarV2 false");
            return;
        }
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity == null) {
            QLog.e("ZPlanAvatarPicEditFragment-avatarEditor", 1, "onResume failed, activity null.");
            return;
        }
        AppInterface appInterface = (AppInterface) qBaseActivity.getAppRuntime();
        if (appInterface == null) {
            QLog.e("ZPlanAvatarPicEditFragment-avatarEditor", 1, "onResume failed, app null.");
            return;
        }
        Mj(true);
        QLog.i("ZPlanAvatarPicEditFragment-avatarEditor", 1, "[requestConfigData] onResume, update data from wuji.");
        if (this.f331707w0) {
            oj(appInterface);
            return;
        }
        ZPlanUserInfo userZPlanInfo = ((IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class)).getUserZPlanInfo(appInterface.getCurrentUin());
        this.V = userZPlanInfo.appearanceKey;
        this.W = userZPlanInfo.gender;
        Uj();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class m implements com.tencent.mobileqq.zplan.avatar.edit.e {
        m() {
        }

        @Override // com.tencent.mobileqq.zplan.avatar.edit.e
        public void a(boolean z16, com.tencent.mobileqq.zplan.avatar.edit.d dVar, String str) {
            if (!z16) {
                ZPlanAvatarPicEditFragment.this.zj(1, dVar.j());
            } else {
                FileManagerUtil.saveToAlbum(ZPlanAvatarPicEditFragment.this.getContext(), str);
                ZPlanAvatarPicEditFragment.this.Aj(dVar.j());
            }
        }
    }

    @Override // com.tencent.mobileqq.zplan.meme.prerecord.ZPlanPreRecordManager.a
    public void J6(Priority priority) {
        Ti(priority, 1);
    }

    public void Jj(int i3) {
        if (i3 >= 0 && i3 < this.C0.size()) {
            this.f331687c0 = i3;
            e.a aVar = this.C0.get(i3);
            if (aVar != null && !TextUtils.isEmpty(aVar.f331778c)) {
                this.Y = aVar.f331777b;
                String str = aVar.f331778c;
                this.Z = str;
                this.P.setBackgroundImageUrl(str);
                Nj(rj());
                return;
            }
            QLog.e("ZPlanAvatarPicEditFragment-avatarEditor", 4, "[setCurAction] invalid bgInfo");
            Nj(false);
            return;
        }
        QLog.e("ZPlanAvatarPicEditFragment-avatarEditor", 1, "[setCurBg] invalid position:" + i3);
        Nj(false);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        QLog.i("ZPlanAvatarPicEditFragment-avatarEditor", 1, DKHippyEvent.EVENT_STOP);
        wj();
        this.f331708x0 = false;
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ej(com.tencent.mobileqq.zplan.avatar.edit.d dVar) {
        int i3;
        int i16;
        String str;
        if (this.B0.size() == 0) {
            QLog.e("ZPlanAvatarPicEditFragment-avatarEditor", 1, "resetPositionIfNeed failed, mAvatarActionInfos null.");
            return;
        }
        if (dVar == null) {
            QLog.e("ZPlanAvatarPicEditFragment-avatarEditor", 1, "resetPositionIfNeed failed, intput editAvatarData null.");
            return;
        }
        int actionId = dVar.getActionId();
        ConcurrentHashMap<Integer, Integer> concurrentHashMap = this.Q0;
        if (concurrentHashMap != null && concurrentHashMap.containsKey(Integer.valueOf(actionId))) {
            actionId = this.Q0.get(Integer.valueOf(actionId)) == null ? -1 : this.Q0.get(Integer.valueOf(actionId)).intValue();
        }
        int i17 = 0;
        d.c cVar = null;
        int i18 = -1;
        int i19 = -1;
        for (int i26 = 0; i26 < this.B0.size(); i26++) {
            d.c cVar2 = this.B0.get(i26);
            int i27 = cVar2.f331764c;
            if (i27 == actionId) {
                int i28 = this.X;
                if (i28 == 0 || i28 == actionId) {
                    i3 = i26;
                    cVar = cVar2;
                    break;
                } else {
                    i18 = i26;
                    cVar = cVar2;
                }
            }
            if (i27 == this.X) {
                i19 = i26;
            }
        }
        i3 = i18;
        this.A0.lock();
        if (i3 == -1) {
            QLog.e("ZPlanAvatarPicEditFragment-avatarEditor", 1, "[resetPositionIfNeed] index\u4e0b\u67b6 \u63d2\u5165\u961f\u5217\u5934 actionId:" + actionId);
            Rj("\u4f7f\u7528\u4e2d\u7684\u5934\u50cf\u4e0b\u67b6\u4e86\uff0c\u6362\u4e00\u4e2a\u5427\uff5e", 0);
            str = "ZPlanAvatarPicEditFragment-avatarEditor";
            i16 = -1;
        } else if (cVar == null || !ZPlanFeatureSwitch.f369852a.m0()) {
            int i29 = i3;
            i16 = -1;
            str = "ZPlanAvatarPicEditFragment-avatarEditor";
            QLog.d(str, 1, "[resetPositionIfNeed] version 2, currPosition\uff1a" + i29);
            i19 = i19;
            i17 = i29;
        } else {
            QLog.d("ZPlanAvatarPicEditFragment-avatarEditor", 1, "[resetPositionIfNeed] version 1, move currAction to the first position, originPosition\uff1a" + i3);
            this.B0.remove(cVar);
            int i36 = i19;
            int i37 = i3;
            i16 = -1;
            Qi(dVar.b(dVar.getUin(), cVar.f331764c, cVar.f331769h, cVar.f331768g, dVar.getBackgroundInfo(), dVar.getAvatarSize(), dVar.getAppearanceKey(), cVar.f331770i.doubleValue(), cVar.f331771j, cVar.f331772k, cVar.f331773l, cVar.f331774m));
            i19 = (i36 == -1 || i37 <= i36) ? i36 : i36 + 1;
            str = "ZPlanAvatarPicEditFragment-avatarEditor";
            i17 = 0;
        }
        this.A0.unlock();
        QLog.i(str, 1, "selectAvatarIndex: " + i19 + ", selfAvatarIndex: " + i17 + "mCurrActionPosition: " + this.f331686b0 + ", mCurrActionId: " + this.X);
        if (i19 != i16 && i19 < this.B0.size() && this.B0.get(i17) != null) {
            this.B0.get(i17).f331763b = false;
            this.f331686b0 = i19;
        } else {
            this.f331686b0 = i17;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mj(final boolean z16) {
        if (z16) {
            this.C = System.currentTimeMillis();
            this.f331709y0.removeMessages(1);
            this.f331709y0.sendEmptyMessageDelayed(1, JsonGrayBusiId.UI_RESERVE_100000_110000);
        } else {
            yj();
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.avatar.fragment.ZPlanAvatarPicEditFragment.16
            @Override // java.lang.Runnable
            public void run() {
                if (ZPlanAvatarPicEditFragment.this.N != null) {
                    if (ZPlanAvatarPicEditFragment.this.N.isShown() && !z16) {
                        ZPlanAvatarPicEditFragment.this.E0.a(ZPlanAvatarPicEditFragment.this.U, new RecyclerView.State(), ZPlanAvatarPicEditFragment.this.f331687c0, 1.0f);
                        ZPlanAvatarPicEditFragment.this.D0.a(ZPlanAvatarPicEditFragment.this.T, new RecyclerView.State(), ZPlanAvatarPicEditFragment.this.f331686b0, 1.0f);
                        ZPlanAvatarPicEditFragment zPlanAvatarPicEditFragment = ZPlanAvatarPicEditFragment.this;
                        zPlanAvatarPicEditFragment.f331691g0 = zPlanAvatarPicEditFragment.f331686b0;
                        ZPlanAvatarPicEditFragment zPlanAvatarPicEditFragment2 = ZPlanAvatarPicEditFragment.this;
                        zPlanAvatarPicEditFragment2.f331692h0 = zPlanAvatarPicEditFragment2.f331687c0;
                        ZPlanAvatarPicEditFragment.this.Ri();
                    }
                    if (z16) {
                        ZPlanAvatarPicEditFragment.this.N.g();
                    } else {
                        ZPlanAvatarPicEditFragment.this.N.b();
                    }
                }
                if (ZPlanAvatarPicEditFragment.this.E != null) {
                    ZPlanAvatarPicEditFragment.this.E.setVisibility(z16 ? 8 : 0);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.tencent.mobileqq.zplan.avatar.edit.d ej() {
        AppInterface c16 = bb.f335811a.c();
        if (c16 == null) {
            QLog.w("ZPlanAvatarPicEditFragment-avatarEditor", 1, "getCurrEditAvatarData app null.");
            return null;
        }
        d.c Zi = Zi();
        if (Zi == null) {
            QLog.e("ZPlanAvatarPicEditFragment-avatarEditor", 1, "current avatarActionInfo null.");
            return null;
        }
        double doubleValue = Zi.f331770i.doubleValue();
        List<Integer> list = Zi.f331773l;
        return new com.tencent.mobileqq.zplan.avatar.edit.d(c16.getCurrentUin(), this.X, "", "", new BackgroundInfo(Integer.valueOf(this.Y), this.Z), 640, this.V, doubleValue, null, null, list, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (u.a().b()) {
            QLog.e("ZPlanAvatarPicEditFragment-avatarEditor", 1, "fast click");
            return;
        }
        String str = "1";
        switch (view.getId()) {
            case R.id.pfa /* 1997013236 */:
            case R.id.pfb /* 1997013237 */:
                VideoReport.reportEvent("clck", this.F, null);
                onBackEvent();
                return;
            case R.id.pfi /* 1997013244 */:
                uj("click");
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.avatar.fragment.ZPlanAvatarPicEditFragment.6
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean a16 = ZPlanFeatureSwitch.f369852a.a();
                        QLog.d("ZPlanAvatarPicEditFragment-avatarEditor", 1, "jumpMakeUp=" + a16);
                        ZootopiaSource create = ZootopiaSource.create(com.tencent.mobileqq.zootopia.Source.AvatarEdit, ZootopiaSource.SUB_SOURCE_ENTRANCE_PROFILE);
                        Bundle bundle = new Bundle();
                        bundle.putBoolean("backToSource", true);
                        Context context = ZPlanAvatarPicEditFragment.this.getContext();
                        if (context == null) {
                            QLog.e("ZPlanAvatarPicEditFragment-avatarEditor", 1, "click btn_change jump failed empty context");
                        } else if (a16) {
                            ((IZootopiaApi) QRoute.api(IZootopiaApi.class)).startMakeUpActivity(context, create, bundle);
                        } else {
                            ((IZootopiaApi) QRoute.api(IZootopiaApi.class)).startPortalActivity(context, create, bundle);
                        }
                    }
                }, 16, null, false);
                return;
            case R.id.pfj /* 1997013245 */:
                AppInterface c16 = bb.f335811a.c();
                if (c16 == null) {
                    QLog.e("ZPlanAvatarPicEditFragment-avatarEditor", 1, "appInterface null, can't change avatar");
                    return;
                }
                if (!rj()) {
                    QLog.e("ZPlanAvatarPicEditFragment-avatarEditor", 1, "data is not ready, can't change avatar");
                    return;
                }
                Map<String, Object> cj5 = cj();
                if (!this.f331694j0) {
                    str = "0";
                }
                cj5.put("zplan_share_is_tick", str);
                VideoReport.reportEvent("clck", this.L, cj5);
                Dialog showLoadingDialog = LoadingUtil.showLoadingDialog(getContext(), null, false);
                this.f331685a0 = showLoadingDialog;
                showLoadingDialog.show();
                this.f331709y0.sendEmptyMessageDelayed(4, 30000L);
                d.c Zi = Zi();
                if (Zi == null) {
                    QLog.e("ZPlanAvatarPicEditFragment-avatarEditor", 1, "current avatarActionInfo is null");
                    return;
                }
                String str2 = Zi.f331765d;
                String str3 = Zi.f331766e;
                double doubleValue = Zi.f331770i.doubleValue();
                List<Integer> list = Zi.f331773l;
                com.tencent.mobileqq.zplan.avatar.edit.d dVar = new com.tencent.mobileqq.zplan.avatar.edit.d(c16.getCurrentUin(), this.X, "", Zi.f331768g, new BackgroundInfo(Integer.valueOf(this.Y), this.Z), 640, this.V, doubleValue, null, null, list, null);
                ((IZPlanEditAvatarApi) QRoute.api(IZPlanEditAvatarApi.class)).composeAvatar(dVar, str3, new l(dVar, str2, doubleValue, c16));
                return;
            case R.id.qj7 /* 1997014745 */:
                if (!rj()) {
                    QLog.e("ZPlanAvatarPicEditFragment-avatarEditor", 1, "data is not ready, can't save avatar");
                    return;
                } else {
                    VideoReport.reportEvent("clck", this.H, getElementParams());
                    Cj();
                    return;
                }
            case R.id.qky /* 1997014810 */:
                this.J.setChecked(!this.f331694j0);
                this.f331694j0 = this.J.isChecked();
                Map<String, Object> elementParams = getElementParams();
                if (this.I != null) {
                    if (!this.f331694j0) {
                        str = "0";
                    }
                    elementParams.put("zplan_share_is_tick", str);
                    VideoReport.reportEvent("clck", this.I, elementParams);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* loaded from: classes35.dex */
    class c extends com.tencent.mobileqq.rainbow.a {
        c() {
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            if (i3 != 2) {
                return;
            }
            QLog.d("ZPlanAvatarPicEditFragment-avatarEditor", 1, "getCmdRainbowData:" + z16);
            if (!z16 || !(obj instanceof JSONObject)) {
                ZPlanAvatarPicEditFragment.this.xj(2);
                return;
            }
            try {
                JSONObject jSONObject = ((JSONObject) obj).getJSONObject("conf");
                ZPlanAvatarPicEditFragment zPlanAvatarPicEditFragment = ZPlanAvatarPicEditFragment.this;
                ZPlanEditAvatarUtils zPlanEditAvatarUtils = ZPlanEditAvatarUtils.f331613a;
                zPlanAvatarPicEditFragment.O0 = zPlanEditAvatarUtils.I(jSONObject, 1);
                ZPlanAvatarPicEditFragment.this.P0 = zPlanEditAvatarUtils.I(jSONObject, 2);
                ZPlanAvatarPicEditFragment.this.Kj();
                ZPlanAvatarPicEditFragment.this.M0 = zPlanEditAvatarUtils.E(jSONObject);
                ZPlanAvatarPicEditFragment.this.f331690f0 = jSONObject.getInt("pre_rec_num");
                ZPlanAvatarPicEditFragment.this.Q0 = zPlanEditAvatarUtils.v(jSONObject);
                ZPlanAvatarPicEditFragment zPlanAvatarPicEditFragment2 = ZPlanAvatarPicEditFragment.this;
                zPlanAvatarPicEditFragment2.kj(zPlanAvatarPicEditFragment2.N0, ZPlanAvatarPicEditFragment.this.M0);
            } catch (JSONException e16) {
                QLog.e("ZPlanAvatarPicEditFragment-avatarEditor", 1, "getCmdRainbowData JSONException", e16);
            }
        }
    }

    /* loaded from: classes35.dex */
    class d implements com.tencent.mobileqq.zplan.servlet.b {
        d() {
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            List emptyList;
            if (i3 == 27405) {
                try {
                    emptyList = (List) obj;
                } catch (Throwable th5) {
                    QLog.e("ZPlanAvatarPicEditFragment-avatarEditor", 1, "onUpdate PROFILE_APPEARANCE_KEY exception", th5);
                    emptyList = Collections.emptyList();
                }
                ZPlanAvatarPicEditFragment.this.jj(emptyList);
            }
        }
    }

    private void Qi(com.tencent.mobileqq.zplan.avatar.edit.d dVar) {
        if (dVar == null) {
            QLog.e("ZPlanAvatarPicEditFragment-avatarEditor", 1, "addAvatarToFirstPosition failed, input editAvatarData null.");
        } else {
            this.B0.add(0, new d.c(true, dVar.getActionId(), "", "", dVar.getDefaultUrl(), dVar.getActionName(), Double.valueOf(dVar.getMaskRate()), dVar.getInBoundsClipperInfo(), dVar.getInBoundsClipperInfo(), dVar.j(), dVar.getEventInfo()));
        }
    }

    private void Tj(AppInterface appInterface) {
        if (appInterface == null) {
            QLog.e("ZPlanAvatarPicEditFragment-avatarEditor", 1, "trySetAvatarInfos app null.");
            return;
        }
        ZPlanEditAvatarManager zPlanEditAvatarManager = (ZPlanEditAvatarManager) appInterface.getManager(QQManagerFactory.ZPLAN_EDIT_AVATAR_MANAGER);
        if (zPlanEditAvatarManager != null && zPlanEditAvatarManager.i0()) {
            this.O0 = zPlanEditAvatarManager.X();
            this.P0 = zPlanEditAvatarManager.V();
            Kj();
            this.M0 = zPlanEditAvatarManager.S();
            this.f331690f0 = zPlanEditAvatarManager.Y();
            this.Q0 = zPlanEditAvatarManager.Q();
            kj(this.N0, this.M0);
            return;
        }
        ((IRainbowApi) QRoute.api(IRainbowApi.class)).getCmdRainbowData("zplan", "head", ZPlanFeatureSwitch.f369852a.O0(), "conf", 2);
    }

    private d.c Vi(com.tencent.mobileqq.zplan.avatar.edit.d dVar) {
        if (dVar == null) {
            QLog.e("ZPlanAvatarPicEditFragment-avatarEditor", 1, "createActionInfoByAvatarData failed, input editAvatarData null.");
            return null;
        }
        d.c cVar = new d.c();
        cVar.f331764c = dVar.getActionId();
        cVar.f331769h = dVar.getActionName();
        cVar.f331768g = dVar.getDefaultUrl();
        cVar.f331770i = Double.valueOf(dVar.getMaskRate());
        cVar.f331771j = dVar.getInBoundsClipperInfo();
        cVar.f331772k = dVar.getOutBoundsClipperInfo();
        cVar.f331773l = dVar.j();
        cVar.f331774m = dVar.getEventInfo();
        return cVar;
    }

    private String hj(AppInterface appInterface) {
        if (appInterface == null) {
            QLog.e("ZPlanAvatarPicEditFragment-avatarEditor", 1, "getFirstEntryTypeForReport failed, app null.");
            return "-1";
        }
        String currentUin = appInterface.getCurrentUin();
        String str = AppSetting.f99551k;
        ZPlanEditAvatarUtils zPlanEditAvatarUtils = ZPlanEditAvatarUtils.f331613a;
        String w3 = zPlanEditAvatarUtils.w(currentUin);
        if (TextUtils.isEmpty(w3)) {
            zPlanEditAvatarUtils.c0(currentUin);
            return "1";
        }
        if (w3.equals(str)) {
            return "2";
        }
        zPlanEditAvatarUtils.c0(currentUin);
        return "0";
    }

    private void oj(AppInterface appInterface) {
        if (appInterface == null) {
            return;
        }
        if (!NetworkUtil.isNetworkAvailable()) {
            this.f331709y0.sendEmptyMessageDelayed(5, 500L);
            return;
        }
        if (sa0.b.c() && ("1".equals(this.f331700p0) || "2".equals(this.f331700p0) || "3".equals(this.f331700p0) || "4".equals(this.f331700p0))) {
            String avatarCacheOldPath = FaceUtil.getAvatarCacheOldPath(appInterface.getCurrentUin());
            if (!TextUtils.isEmpty(avatarCacheOldPath)) {
                FileUtils.deleteFile(avatarCacheOldPath);
            }
            this.f331697m0 = (IQQAvatarDataService) appInterface.getRuntimeService(IQQAvatarDataService.class, "");
            FileUtils.copyFile(FaceUtil.getAvatarCacheNewPath(appInterface.getCurrentUin()), FaceUtil.getAvatarCacheOldPath(appInterface.getCurrentUin()));
            String str = this.f331697m0.getHistoryAvatarPath() + "";
            this.f331698n0 = str;
            if (TextUtils.isEmpty(str) || !FileUtils.fileExists(this.f331698n0)) {
                FileUtils.copyFile(this.f331697m0.getCustomFaceFilePath(false, appInterface.getCurrentUin()), FaceUtil.getAvatarCacheOldPath(appInterface.getCurrentUin()));
                this.f331698n0 = FaceUtil.getAvatarCacheOldPath(appInterface.getCurrentUin());
            }
        }
        ZPlanUserInfo userZPlanInfo = ((IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class)).getUserZPlanInfo(appInterface.getCurrentUin());
        this.V = userZPlanInfo.appearanceKey;
        if (!this.f331706v0) {
            QLog.i("ZPlanAvatarPicEditFragment-avatarEditor", 1, "enableZPlanEditAvatarV2 false.");
            this.W = userZPlanInfo.gender;
            Tj(appInterface);
        } else {
            QLog.i("ZPlanAvatarPicEditFragment-avatarEditor", 1, "[requestConfigData] enableZPlanEditAvatarV2 true, init data from wuji.");
            this.W = userZPlanInfo.gender;
            Uj();
        }
    }

    private void pj(AppInterface appInterface) {
        if (appInterface == null) {
            return;
        }
        if (!this.f331706v0) {
            appInterface.addObserver(this.S0);
        }
        appInterface.addObserver(this.T0);
        ((IZPlanEditAvatarApi) QRoute.api(IZPlanEditAvatarApi.class)).setUploadHandler(appInterface, this.I0);
        ZPlanPreRecordManager.f334206e.n(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tj(int i3, com.tencent.mobileqq.zplan.avatar.edit.d dVar) {
        if (dVar == null) {
            QLog.e("ZPlanAvatarPicEditFragment-avatarEditor", 1, "reportChangeAvatarFail failed, editAvatarData null.");
        } else {
            this.f331699o0.j(new b.AvatarRenewReportParam(String.valueOf(this.X), this.Z, ZPlanEditAvatarUtils.f331613a.z(dVar.j()), this.f331700p0, "", String.valueOf(i3)));
        }
    }

    public static void Qj(Context context, Intent intent) {
        if (intent != null && context != null) {
            QPublicFragmentActivity.start(context, intent, ZPlanAvatarPicEditFragment.class);
            MemeHelper.INSTANCE.toggleQueuePauseState(false, "StartEditAvatarFragment");
        } else {
            QLog.e("ZPlanAvatarPicEditFragment-avatarEditor", 1, "[startZPlanAvatarPicEdit] error invalid param");
        }
    }

    private void Oj() {
    }
}
