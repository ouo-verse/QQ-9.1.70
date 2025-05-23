package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.beans.SubscribeColorNoteReserveBean;
import com.tencent.biz.subscribe.utils.h;
import com.tencent.biz.subscribe.widget.SubscribeShareHelper;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.f;
import com.tencent.mobileqq.colornote.g;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.SdCardUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qqfav.QfavBuilder;
import java.io.File;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class SubscribeBaseFragment extends IphoneTitleBarFragment implements bf0.a {
    protected CertifiedAccountMeta$StFeed C;
    protected ExtraTypeInfo D;
    protected SubscribeShareHelper E;
    protected IColorNoteController F;
    protected boolean G;
    private Handler H;
    protected boolean I;
    protected af0.b J;
    private MiniMsgUser K;
    private boolean L;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements f {
        b() {
        }

        @Override // com.tencent.mobileqq.colornote.f
        public ColorNote getColorNote() {
            SubscribeBaseFragment subscribeBaseFragment = SubscribeBaseFragment.this;
            CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed = subscribeBaseFragment.C;
            if (certifiedAccountMeta$StFeed != null && subscribeBaseFragment.D != null) {
                byte[] b16 = h.b(new SubscribeColorNoteReserveBean(certifiedAccountMeta$StFeed.toByteArray(), SubscribeBaseFragment.this.D.pageType));
                ve0.b bVar = new ve0.b();
                SubscribeBaseFragment subscribeBaseFragment2 = SubscribeBaseFragment.this;
                bVar.f441502b = subscribeBaseFragment2.C;
                bVar.f441505e = subscribeBaseFragment2.D;
                String h16 = bVar.h();
                String c16 = bVar.c();
                String b17 = bVar.b();
                String str = "";
                switch (bVar.f441505e.pageType) {
                    case 7000:
                    case 7001:
                        c16 = bVar.f();
                        str = "" + bVar.f441502b.f24925id.get();
                        break;
                    case 7002:
                        str = "" + bVar.f441502b.poster.f24929id.get();
                        break;
                }
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                return new ColorNote.a().g(R.id.edit).i(str).d(h16).h(c16).e(b17).f(b16).a();
            }
            QLog.e("SubscribeBaseFragment", 1, "initColorNote, shareInfoBean is null");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class c implements ha1.a {
        c() {
        }

        @Override // ha1.a
        public void onColorNoteAnimFinish() {
            if (SubscribeBaseFragment.this.getBaseActivity() != null) {
                SubscribeBaseFragment.this.getBaseActivity().finish();
                SubscribeBaseFragment.this.getBaseActivity().overridePendingTransition(0, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class d extends g {
        d() {
        }

        @Override // com.tencent.mobileqq.colornote.g
        public void onAddColorNote(Bundle bundle, boolean z16) {
            super.onAddColorNote(bundle, z16);
            ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplication.getContext(), 2, true);
            if (SubscribeBaseFragment.this.getBaseActivity() != null) {
                SubscribeBaseFragment.this.getBaseActivity().finish();
                SubscribeBaseFragment.this.getBaseActivity().overridePendingTransition(0, 0);
            }
        }
    }

    private void Ch() {
        ExtraTypeInfo extraTypeInfo;
        String str;
        if (getBaseActivity() != null && getBaseActivity().getIntent() != null) {
            long longExtra = getBaseActivity().getIntent().getLongExtra("PERF_OPEN_PAGE_TIME", 0L);
            if (longExtra != 0 && (extraTypeInfo = this.D) != null) {
                switch (extraTypeInfo.pageType) {
                    case 7000:
                        str = "subscribe_open_video_detail_page_time";
                        break;
                    case 7001:
                        str = "subscribe_open_muti_pic_page_time";
                        break;
                    case 7002:
                        str = "subscribe_open_personal_detail_page_time";
                        break;
                    default:
                        str = "SubscribeBaseFragment";
                        break;
                }
                VSReporter.q(str, VSReporter.e(0L, System.currentTimeMillis() - longExtra));
            }
        }
    }

    private void Dh(int i3, ExtraTypeInfo extraTypeInfo) {
        CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed = this.C;
        if (certifiedAccountMeta$StFeed != null && !StringUtil.isEmpty(certifiedAccountMeta$StFeed.poster.f24929id.get())) {
            VSReporter.n(this.C.poster.f24929id.get(), "auth_share", "exp_" + SubscribeShareHelper.s(extraTypeInfo), i3, 0, new String[0]);
        }
    }

    private void qh() {
        View view = new View(getBaseActivity());
        view.setBackgroundColor(1711276032);
        ((ViewGroup) getBaseActivity().getWindow().getDecorView()).addView(view, new RelativeLayout.LayoutParams(-1, -1));
    }

    private void rh() {
        QLog.i("SubscribeBaseFragment", 1, "downloadAnimationPic");
        for (String str : com.tencent.biz.subscribe.b.f95702j) {
            String str2 = com.tencent.biz.subscribe.b.f95700h.get(str);
            File file = new File(str2);
            if (file.exists() && file.isDirectory()) {
                QLog.i("DownLoadZipFile", 1, "DownLoadZipFile " + str2 + " Save file is exist");
                return;
            }
            SubscribeUtils.h(file, (String) VSConfigManager.c().e(com.tencent.biz.subscribe.b.f95701i.get(str), com.tencent.biz.subscribe.b.f95699g.get(str)), com.tencent.biz.subscribe.b.f95697e);
        }
    }

    private void sh() {
        File file = new File(SubscribeUtils.j());
        if (!file.exists() && SdCardUtil.getSdCardDirectory() != null) {
            SubscribeUtils.g(file, (String) VSConfigManager.c().e("KEY_SUBSCRIBE_LOADING_VIEW_DOWNLOAD_URL", "https://downv6.qq.com/video_story/certified_account/certified_account_download_pics.zip"));
        } else {
            QLog.i("DownLoadZipFile", 1, "DownLoadZipFile Save file is exist");
        }
    }

    private void zh() {
        if (this.F != null) {
            return;
        }
        IColorNoteController iColorNoteController = (IColorNoteController) QRoute.api(IColorNoteController.class);
        this.F = iColorNoteController;
        iColorNoteController.init(getBaseActivity(), false, true);
        this.F.attachToActivity(getBaseActivity());
        this.F.setServiceInfo(new b());
        this.F.setOnColorNoteAnimFinishListener(new c());
        this.F.setOnColorNoteCurdListener(new d());
    }

    protected boolean Ah() {
        if (th() != null && uh() != null) {
            return true;
        }
        return false;
    }

    protected abstract void Bh(View view);

    public void Eh(ve0.b bVar) {
        ExtraTypeInfo extraTypeInfo;
        CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed;
        if (bVar != null) {
            if (bVar.f441502b == null && (certifiedAccountMeta$StFeed = this.C) != null) {
                bVar.f441502b = certifiedAccountMeta$StFeed;
            }
            if (bVar.f441505e == null && (extraTypeInfo = this.D) != null) {
                bVar.f441505e = extraTypeInfo;
            }
            if (this.E != null) {
                Dh(bVar.f441501a, this.D);
                this.E.T(bVar, this.F);
            }
            if (Ah() && uh() != null && bVar.f441501a == 1 && uh().getVisibility() == 0 && vh() != null) {
                vh().onClick(th());
            }
        }
    }

    public void Fh(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        if (certifiedAccountMeta$StFeed != null) {
            this.C = certifiedAccountMeta$StFeed;
        }
    }

    @Override // bf0.a
    public int I1() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        sh();
        rh();
        if (getBaseActivity().getIntent() != null) {
            CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed = new CertifiedAccountMeta$StFeed();
            this.C = certifiedAccountMeta$StFeed;
            try {
                this.C = certifiedAccountMeta$StFeed.mergeFrom(getBaseActivity().getIntent().getByteArrayExtra("bundle_key_subscribe_feed_bytes_array"));
                ExtraTypeInfo extraTypeInfo = (ExtraTypeInfo) getBaseActivity().getIntent().getSerializableExtra(ExtraTypeInfo.KEY_SUBSCRIBE_INTENT_EXTRA_TYPE_INFO);
                this.D = extraTypeInfo;
                if (extraTypeInfo == null) {
                    this.D = new ExtraTypeInfo();
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        this.E = new SubscribeShareHelper(getBaseActivity(), new a());
        if (getBaseActivity().getIntent().hasExtra("bundle_key_parms_extra")) {
            Bundle bundleExtra = getBaseActivity().getIntent().getBundleExtra("bundle_key_parms_extra");
            if (af0.b.t(bundleExtra)) {
                af0.b bVar = new af0.b(bundleExtra, this);
                this.J = bVar;
                if (bVar.m() != null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    layoutParams.addRule(3, com.tencent.mobileqq.R.id.rlCommenTitle);
                    this.titleRoot.addView(this.J.m(), layoutParams);
                }
            }
        }
        if (Ah()) {
            this.K = new MiniMsgUser(getBaseActivity(), wh());
        }
        yh();
        Ch();
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, com.qzone.common.activities.titlebuilder.f
    public Handler getMainHandler() {
        if (this.H == null) {
            this.H = new Handler(Looper.getMainLooper());
        }
        return this.H;
    }

    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    protected boolean isTransparent() {
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        byte[] byteArrayExtra;
        if (QLog.isColorLevel()) {
            QLog.d("SubscribeBaseFragment", 2, "SubscribeVideoDetailFragment onActivityResult,requestCode=" + i3 + ",resultCode=" + i16);
        }
        if (i16 == -1 && i3 == 2) {
            QfavBuilder.l0(super.getBaseActivity(), intent);
            return;
        }
        if (i3 == 3 && i16 == -1 && (byteArrayExtra = intent.getByteArrayExtra("feed")) != null) {
            CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed = new CertifiedAccountMeta$StFeed();
            try {
                certifiedAccountMeta$StFeed.mergeFrom(byteArrayExtra);
                this.C = certifiedAccountMeta$StFeed;
                xh(certifiedAccountMeta$StFeed);
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("SubscribeBaseFragment", 4, "onActivityResult: prase stFeed error:" + e16.toString());
            }
        }
        super.onActivityResult(i3, i16, intent);
    }

    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        ExtraTypeInfo extraTypeInfo;
        CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed = this.C;
        if (certifiedAccountMeta$StFeed != null) {
            VSReporter.n(certifiedAccountMeta$StFeed.poster.f24929id.get(), "auth_" + SubscribeShareHelper.s(this.D), "clk_return", 0, 0, "", "");
        }
        if (getBaseActivity() != null && getBaseActivity().getIntent() != null && (extraTypeInfo = this.D) != null && extraTypeInfo.sourceType == 9001) {
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(getBaseActivity(), QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.PUBLIC_ACCOUNT_DISCOVER_PAGE_SCHEMA, QzoneConfig.DEFAULT_PUBLIC_ACCOUNT_DISCOVER_PAGE_SCHEMA), 2016, null, null);
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (Ah()) {
            MiniMsgUser miniMsgUser = this.K;
            if (miniMsgUser != null) {
                miniMsgUser.destroy();
                this.K = null;
            }
            IColorNoteController iColorNoteController = this.F;
            if (iColorNoteController != null) {
                iColorNoteController.onDestroy();
            }
        }
        this.I = true;
        getMainHandler().removeCallbacksAndMessages(null);
        SubscribeShareHelper subscribeShareHelper = this.E;
        if (subscribeShareHelper != null) {
            subscribeShareHelper.M();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (Ah()) {
            MiniMsgUser miniMsgUser = this.K;
            if (miniMsgUser != null) {
                miniMsgUser.onBackground();
            }
            IColorNoteController iColorNoteController = this.F;
            if (iColorNoteController != null) {
                iColorNoteController.onPause();
            }
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (Ah()) {
            MiniMsgUser miniMsgUser = this.K;
            if (miniMsgUser != null) {
                miniMsgUser.onForeground();
            }
            zh();
            IColorNoteController iColorNoteController = this.F;
            if (iColorNoteController != null) {
                iColorNoteController.onResume();
            }
        }
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onWindowFocusChanged(boolean z16) {
        MiniMsgUser miniMsgUser;
        super.onWindowFocusChanged(z16);
        if (z16 && !this.L) {
            if (Ah() && (miniMsgUser = this.K) != null) {
                miniMsgUser.showOnFirst();
            }
            this.L = true;
        }
    }

    protected View th() {
        return null;
    }

    protected TextView uh() {
        return null;
    }

    public MiniMsgUser vh() {
        return this.K;
    }

    protected MiniMsgUserParam wh() {
        MiniMsgUserParam miniMsgUserParam = new MiniMsgUserParam();
        miniMsgUserParam.businessName = 25;
        miniMsgUserParam.accessType = 1;
        miniMsgUserParam.unreadView = uh();
        return miniMsgUserParam;
    }

    @Override // bf0.a
    public int[] x1(int i3, int i16) {
        return new int[2];
    }

    protected void yh() {
        if (SubscribeUtils.m()) {
            qh();
        }
        Bh(((IphoneTitleBarFragment) this).mContentView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements SubscribeShareHelper.e {
        a() {
        }

        @Override // com.tencent.biz.subscribe.widget.SubscribeShareHelper.e
        public void onClick(int i3) {
        }
    }

    protected void xh(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
    }
}
