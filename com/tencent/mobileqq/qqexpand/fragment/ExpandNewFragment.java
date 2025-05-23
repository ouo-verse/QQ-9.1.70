package com.tencent.mobileqq.qqexpand.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendReport;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.matchchat.MatchChatMsgUtil;
import com.tencent.mobileqq.qqexpand.chat.ExtendFriendSendMsgHelper;
import com.tencent.mobileqq.qqexpand.entrance.IExpandFragmentRouter;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.mobileqq.qqexpand.utils.CampusHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.observer.RedpointObserver;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.widget.AbsSlidingIndicator;
import com.tencent.mobileqq.widget.SimpleSlidingIndicator;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ExpandNewFragment extends QPublicBaseFragment implements View.OnClickListener, AbsSlidingIndicator.f, AbsSlidingIndicator.e {
    private QBaseActivity C;
    private QQAppInterface D;
    private FragmentManager E;
    private com.tencent.mobileqq.qqexpand.manager.e F;
    private QBaseFragment G;
    private ExtendFriendSquareFragment H;
    private ViewGroup I;
    private ViewGroup J;
    private SimpleSlidingIndicator K;
    private TextView L;
    private View M;
    private String N;
    private RedTouch P;
    private long Q;
    private String[] T;
    private int[] U;
    private boolean W;
    private boolean X;
    private long R = 0;
    private int S = -1;
    private int V = 0;
    private final RedpointObserver Y = new a();
    private final ExpandObserver Z = new b();

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a extends RedpointObserver {
        a() {
        }

        @Override // com.tencent.mobileqq.tianshu.observer.RedpointObserver
        public void onDataChange(boolean z16) {
            if (QLog.isColorLevel()) {
                QLog.i("ExtendFriendNewFragment", 2, String.format("onDataChange success=%s", Boolean.valueOf(z16)));
            }
            ExpandNewFragment.this.Dh();
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class b extends ExpandObserver {
        b() {
        }

        @Override // com.tencent.mobileqq.qqexpand.network.ExpandObserver
        protected void B(int i3) {
            MatchChatMsgUtil.h(ExpandNewFragment.this.P, ExpandNewFragment.this.D);
            BaseApplicationImpl.getApplication().sendBroadcast(new Intent("match_chat_notify_update"));
        }
    }

    static {
        com.tencent.mobileqq.qqexpand.utils.d.d();
    }

    private void Ah(int i3) {
        if (QLog.isColorLevel()) {
            QLog.i("ExtendFriendNewFragment", 2, String.format("redDotTouchClick position=%s", Integer.valueOf(i3)));
        }
        String str = "";
        IRedTouchManager iRedTouchManager = (IRedTouchManager) this.D.getRuntimeService(IRedTouchManager.class, "");
        if (this.S == i3) {
            str = "7720.772001";
        }
        iRedTouchManager.onRedTouchItemClick(str);
        SimpleSlidingIndicator simpleSlidingIndicator = this.K;
        if (simpleSlidingIndicator != null) {
            int[] iArr = this.U;
            if (iArr.length > i3) {
                simpleSlidingIndicator.f(iArr[i3]);
            }
        }
        Dh();
    }

    private void Bh() {
        String str;
        if (this.G != this.H) {
            str = "";
        } else {
            str = "exit#voice_tab#view";
        }
        if (this.R != 0 && !TextUtils.isEmpty(str)) {
            long currentTimeMillis = System.currentTimeMillis() - this.R;
            HashMap hashMap = new HashMap();
            hashMap.put("duration", currentTimeMillis + "");
            com.tencent.mobileqq.qqexpand.utils.d.e(str, true, -1L, -1L, hashMap, true, true);
            this.R = 0L;
            return;
        }
        QLog.w("ExtendFriendNewFragment", 4, "report error " + str);
    }

    private void Ch(String str) {
        if (this.W || this.X) {
            return;
        }
        this.X = true;
        zh();
        xh(str);
        Dh();
        uh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dh() {
        QQAppInterface qQAppInterface;
        if (this.C == null || (qQAppInterface = this.D) == null || this.K == null) {
            return;
        }
        try {
            IRedTouchManager iRedTouchManager = (IRedTouchManager) qQAppInterface.getRuntimeService(IRedTouchManager.class, "");
            if (this.S != -1) {
                this.K.v(this.U[this.S], iRedTouchManager.getAppInfoByPath("7720.772001"));
            }
            MatchChatMsgUtil.h(this.P, this.D);
        } catch (Exception e16) {
            QLog.e("ExtendFriendNewFragment", 1, "updateExtendRedDot fail.", e16);
        }
    }

    private void preLoadData() {
        Ch(this.N);
    }

    private void uh() {
        QQAppInterface qQAppInterface = this.D;
        if (qQAppInterface != null) {
            IRedTouchManager iRedTouchManager = (IRedTouchManager) qQAppInterface.getRuntimeService(IRedTouchManager.class, "");
            if (iRedTouchManager.getAppInfoByPath("7720.772001").iNewFlag.get() == 1) {
                iRedTouchManager.onRedTouchItemClick("7720.772001");
                this.K.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.fragment.ExpandNewFragment.3
                    @Override // java.lang.Runnable
                    public void run() {
                        ExpandNewFragment.this.K.f(ExpandNewFragment.this.U[0]);
                    }
                }, 1500L);
            }
        }
    }

    private void vh() {
        ExtendFriendSquareFragment extendFriendSquareFragment = this.H;
        if (extendFriendSquareFragment == null || extendFriendSquareFragment != this.G) {
            return;
        }
        extendFriendSquareFragment.Ih();
    }

    private boolean wh(int i3) {
        return i3 == this.S;
    }

    private void xh(String str) {
        ViewGroup viewGroup = this.J;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
        if (str != null && str.equals("voice")) {
            this.V = this.S;
            yh();
        } else {
            this.V = 0;
            yh();
        }
        this.K.setCurrentPosition(this.V, false);
    }

    private void yh() {
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendNewFragment", 2, "loadSquareFragment");
        }
        if (this.E != null) {
            if (this.H == null) {
                ExtendFriendSquareFragment extendFriendSquareFragment = new ExtendFriendSquareFragment();
                this.H = extendFriendSquareFragment;
                extendFriendSquareFragment.ph(this.S);
            }
            QBaseFragment qBaseFragment = this.G;
            ExtendFriendSquareFragment extendFriendSquareFragment2 = this.H;
            if (qBaseFragment != extendFriendSquareFragment2) {
                FragmentTransaction beginTransaction = this.E.beginTransaction();
                QBaseFragment qBaseFragment2 = this.G;
                if (qBaseFragment2 != null) {
                    beginTransaction.hide(qBaseFragment2);
                }
                if (!this.H.isAdded()) {
                    beginTransaction.add(R.id.b9w, this.H, "squareFragment");
                } else {
                    beginTransaction.show(this.H);
                }
                beginTransaction.commitAllowingStateLoss();
                vh();
                this.G = this.H;
                return;
            }
            extendFriendSquareFragment2.zh();
        }
    }

    @Override // com.tencent.mobileqq.widget.AbsSlidingIndicator.e
    public void k1(int i3) {
        if (i3 == this.S) {
            yh();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        ExtendFriendSquareFragment extendFriendSquareFragment;
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendNewFragment", 2, String.format("onActivityResult requestCode=%s resultCode=%s", Integer.valueOf(i3), Integer.valueOf(i16)));
        }
        super.onActivityResult(i3, i16, intent);
        if ((i3 == 1031 || i3 == 1 || i3 == 3 || i3 == 2) && (extendFriendSquareFragment = this.H) != null) {
            extendFriendSquareFragment.onActivityResult(i3, i16, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        QBaseActivity qBaseActivity;
        if (view.getId() == R.id.jok && (qBaseActivity = this.C) != null) {
            qBaseActivity.doOnBackPressed();
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        QLog.i("ExtendFriendNewFragment", 4, "onCreateView ");
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.gwk, (ViewGroup) null);
        this.I = viewGroup2;
        this.J = (ViewGroup) viewGroup2.findViewById(R.id.jp7);
        this.K = (SimpleSlidingIndicator) this.I.findViewById(R.id.ixv);
        this.L = (TextView) this.I.findViewById(R.id.kdo);
        this.M = this.I.findViewById(R.id.f_1);
        this.N = getActivity().getIntent().getStringExtra(IExpandFragmentRouter.TYPE_URL);
        ViewGroup viewGroup3 = this.J;
        if (viewGroup3 != null) {
            viewGroup3.setVisibility(4);
            if (ImmersiveUtils.isSupporImmersive() == 1) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.J.getLayoutParams();
                layoutParams.topMargin = ImmersiveUtils.getStatusBarHeight(this.C);
                this.J.setLayoutParams(layoutParams);
            }
        }
        View findViewById = this.I.findViewById(R.id.jok);
        if (findViewById != null) {
            findViewById.setOnClickListener(this);
        }
        if (this.M != null) {
            this.M.setVisibility(ThemeUtil.isInNightMode(this.D) ? 0 : 8);
        }
        if (bundle != null) {
            this.H = (ExtendFriendSquareFragment) this.E.findFragmentByTag("squareFragment");
        }
        preLoadData();
        ((com.tencent.mobileqq.qqexpand.manager.e) this.D.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).n();
        return this.I;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        int intExtra = intent.getIntExtra("position", 0);
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendNewFragment", 2, String.format("onNewIntent position=%s", Integer.valueOf(intExtra)));
        }
        if (intExtra < 0 || !wh(intExtra)) {
            return;
        }
        this.K.setCurrentPosition(intExtra, false);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ApngImage.pauseAll();
        Bh();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ApngImage.resumeAll();
        int intExtra = getActivity().getIntent().getIntExtra(IExpandFragmentRouter.FROM_TYPE, 0);
        HashMap hashMap = new HashMap();
        hashMap.put("frompage", String.valueOf(intExtra));
        com.tencent.mobileqq.qqexpand.utils.d.e("expose#all_page#view", true, -1L, -1L, hashMap, true, true);
        if (this.R == 0) {
            this.R = System.currentTimeMillis();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        QLog.i("ExtendFriendNewFragment", 4, "onCreate");
        super.onCreate(bundle);
        this.W = false;
        this.X = false;
        QBaseActivity qBaseActivity = getQBaseActivity();
        this.C = qBaseActivity;
        QQAppInterface qQAppInterface = (QQAppInterface) qBaseActivity.getAppRuntime();
        this.D = qQAppInterface;
        if (qQAppInterface != null) {
            this.E = this.C.getSupportFragmentManager();
            com.tencent.mobileqq.qqexpand.manager.e eVar = (com.tencent.mobileqq.qqexpand.manager.e) this.D.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
            this.F = eVar;
            eVar.R(0);
            this.D.addObserver(this.Y);
            this.D.addObserver(this.Z);
            IWebProcessManagerService iWebProcessManagerService = (IWebProcessManagerService) this.D.getRuntimeService(IWebProcessManagerService.class, "");
            if (iWebProcessManagerService != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("ExtendFriendNewFragment", 2, "onCreate, preload web process");
                }
                iWebProcessManagerService.startWebProcess(29, null);
            }
            this.F.A(this.C, this.D);
        }
        ExtendFriendReport.a().j();
        this.Q = System.currentTimeMillis();
        this.R = System.currentTimeMillis();
        ReportController.o(this.D, "dc00898", "", "", "0X80092F0", "0X80092F0", 0, 0, "", "", "", "");
    }

    private void zh() {
        String[] strArr = new String[10];
        int[] iArr = new int[10];
        strArr[0] = getString(R.string.f199034ob);
        iArr[0] = R.id.f165119c03;
        this.S = 0;
        this.K.setVisibility(0);
        this.L.setVisibility(8);
        String[] strArr2 = new String[1];
        this.T = strArr2;
        this.U = new int[1];
        System.arraycopy(strArr, 0, strArr2, 0, 1);
        System.arraycopy(iArr, 0, this.U, 0, 1);
        this.K.setTabData(this.T, this.U);
        this.K.setOnTabListener(this);
        this.K.setOnTabClickListener(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        com.tencent.mobileqq.qqexpand.manager.e eVar;
        QQAppInterface qQAppInterface = this.D;
        if (qQAppInterface != null && (eVar = (com.tencent.mobileqq.qqexpand.manager.e) qQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)) != null) {
            eVar.b();
        }
        QLog.i("ExtendFriendNewFragment", 4, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        this.W = true;
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendNewFragment", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        super.onDestroy();
        QQAppInterface qQAppInterface2 = this.D;
        if (qQAppInterface2 != null) {
            qQAppInterface2.removeObserver(this.Y);
            this.D.removeObserver(this.Z);
            CampusHelper.i(this.D, false);
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = this.Q;
        int i3 = (int) ((currentTimeMillis - j3) / 1000);
        if (j3 > 0 && i3 > 0 && i3 < 86400) {
            QQAppInterface qQAppInterface3 = this.D;
            if (qQAppInterface3 != null) {
                ReportController.o(qQAppInterface3, "dc00898", "", "", "0X80092EF", "0X80092EF", 0, i3, "", "", "", "");
            }
            ExtendFriendReport.a().k(i3);
        }
        ExtendFriendSendMsgHelper e16 = ExtendFriendSendMsgHelper.e(this.D);
        if (e16 != null) {
            e16.c();
        }
        com.tencent.mobileqq.qqexpand.manager.e eVar2 = this.F;
        if (eVar2 != null) {
            eVar2.R(-1);
        }
    }

    @Override // com.tencent.mobileqq.widget.AbsSlidingIndicator.f
    public int I0(int i3, boolean z16) {
        String str;
        String str2;
        SosoLocation sosoLocation;
        Bh();
        if (i3 == this.S) {
            yh();
            SosoLbsInfo cachedLbsInfo = ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("extend_friend");
            String str3 = "";
            if (cachedLbsInfo == null || (sosoLocation = cachedLbsInfo.mLocation) == null) {
                str = "";
                str2 = str;
            } else {
                if (!TextUtils.isEmpty(sosoLocation.city)) {
                    str3 = sosoLocation.city;
                }
                str2 = String.format("%s;%s", Double.valueOf(sosoLocation.mLat02), Double.valueOf(sosoLocation.mLon02));
                str = str3;
            }
            ReportController.o(this.D, "dc00898", "", "", "0X80092D2", "0X80092D2", 0, 0, "", "", str, str2);
            com.tencent.mobileqq.qqexpand.utils.d.e("click#voice_tab#voice_btn", true, -1L, -1L, null, true, true);
        }
        this.F.R(i3);
        Ah(i3);
        this.R = System.currentTimeMillis();
        return 0;
    }
}
