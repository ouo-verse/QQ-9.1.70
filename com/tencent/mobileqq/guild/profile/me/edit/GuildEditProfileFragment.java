package com.tencent.mobileqq.guild.profile.me.edit;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import aw1.MedalItem;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.guild.api.impl.GuildDTReportApiImpl;
import com.tencent.mobileqq.guild.avatar.GuildUserAvatarRepository;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.common.upload.GuildCgiUploader;
import com.tencent.mobileqq.guild.nt.album.api.IPhotoPickAndEditApi;
import com.tencent.mobileqq.guild.nt.misc.api.ISnapshotApi;
import com.tencent.mobileqq.guild.nt.misc.api.IUploadApi;
import com.tencent.mobileqq.guild.profile.me.GuildModifyNickNameDialog;
import com.tencent.mobileqq.guild.profile.me.aj;
import com.tencent.mobileqq.guild.profile.me.avatar.GuildCheckAvatarFragment;
import com.tencent.mobileqq.guild.profile.me.edit.GuildEditProfileFragment;
import com.tencent.mobileqq.guild.profile.profilearchives.fragment.GuildProfileArchivesListFragment;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.bc;
import com.tencent.mobileqq.guild.util.bk;
import com.tencent.mobileqq.guild.util.br;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cx;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.guild.widget.FlowLayout;
import com.tencent.mobileqq.guild.widget.GuildDefaultThemeNavBarCommon;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarViewWithPendant;
import com.tencent.mobileqq.guild.widget.selector.GuildLocationActionSheet;
import com.tencent.mobileqq.qqguildsdk.data.GProLocationInfo;
import com.tencent.mobileqq.qqguildsdk.data.de;
import com.tencent.mobileqq.qqguildsdk.data.eu;
import com.tencent.mobileqq.qqguildsdk.data.ev;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUIListItemStyle;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.widget.selectorview.QActionSheet;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.util.QQToastUtil;
import com.tencent.util.UiThreadUtil;
import cooperation.qzone.util.WnsError;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import mqq.app.MobileQQ;

/* loaded from: classes14.dex */
public class GuildEditProfileFragment extends QQGuildTitleBarFragment implements View.OnClickListener, com.tencent.mobileqq.guild.avatar.e, com.tencent.mobileqq.guild.theme.d {
    private View T;
    private ImageView U;
    private RelativeLayout V;
    private FlowLayout W;
    private QUISettingsRecyclerView X;
    private GuildUserAvatarViewWithPendant Y;
    private View Z;

    /* renamed from: a0, reason: collision with root package name */
    private View f231154a0;

    /* renamed from: b0, reason: collision with root package name */
    private View f231155b0;

    /* renamed from: c0, reason: collision with root package name */
    private TextView f231156c0;

    /* renamed from: d0, reason: collision with root package name */
    private ImageView f231157d0;

    /* renamed from: e0, reason: collision with root package name */
    private ViewGroup f231158e0;

    /* renamed from: f0, reason: collision with root package name */
    private Object f231159f0;

    /* renamed from: g0, reason: collision with root package name */
    private ViewGroup f231160g0;

    /* renamed from: h0, reason: collision with root package name */
    private com.tencent.mobileqq.guild.widget.j f231161h0;

    /* renamed from: i0, reason: collision with root package name */
    private GuildCgiUploader f231162i0;

    /* renamed from: j0, reason: collision with root package name */
    private BaseQQAppInterface f231163j0;

    /* renamed from: k0, reason: collision with root package name */
    private int f231164k0;

    /* renamed from: l0, reason: collision with root package name */
    private int[] f231165l0 = new int[3];

    /* renamed from: m0, reason: collision with root package name */
    private GuildEditProfileViewModel f231166m0;

    /* renamed from: n0, reason: collision with root package name */
    private String f231167n0;

    /* renamed from: o0, reason: collision with root package name */
    private Uri f231168o0;

    /* renamed from: p0, reason: collision with root package name */
    private ev f231169p0;

    /* renamed from: q0, reason: collision with root package name */
    private xh2.c f231170q0;

    /* renamed from: r0, reason: collision with root package name */
    private aw1.g f231171r0;

    /* renamed from: s0, reason: collision with root package name */
    private QUIListItemAdapter f231172s0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public class c implements IUploadApi.b {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(IUploadApi.c cVar, IUploadApi.d dVar) {
            GuildEditProfileFragment.this.Ti(cVar, dVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(IUploadApi.c cVar, IUploadApi.d dVar) {
            GuildEditProfileFragment.this.Vi(cVar, dVar);
        }

        @Override // com.tencent.mobileqq.guild.nt.misc.api.IUploadApi.b
        public void a(final IUploadApi.c cVar, final IUploadApi.d dVar) {
            int i3 = dVar.f230931a;
            if (i3 == 0) {
                GuildEditProfileFragment.this.Ui(cVar, dVar);
            } else {
                if (i3 != 1) {
                    if (i3 == 2) {
                        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.profile.me.edit.x
                            @Override // java.lang.Runnable
                            public final void run() {
                                GuildEditProfileFragment.c.this.d(cVar, dVar);
                            }
                        });
                        return;
                    }
                    return;
                }
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.profile.me.edit.y
                    @Override // java.lang.Runnable
                    public final void run() {
                        GuildEditProfileFragment.c.this.e(cVar, dVar);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Ai(View view) {
        new GuildDTReportApiImpl().setElementExposureAndClickParams(view, "em_sgrp_mine_selfintro", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Bi(com.tencent.mobileqq.widget.listitem.x xVar, ev evVar) {
        ((x.c.g) xVar.O()).h(si(evVar));
        this.f231172s0.l0(xVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ci(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        cj();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Di(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Ri();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ei(com.tencent.mobileqq.widget.listitem.x xVar, ev evVar) {
        ((x.c.g) xVar.O()).h(qi(evVar));
        this.f231172s0.l0(xVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Fi(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Si(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Gi(View view) {
        new GuildDTReportApiImpl().setElementExposureAndClickParams(view, "em_sgrp_mine_gender", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Hi(com.tencent.mobileqq.widget.listitem.x xVar, ev evVar) {
        ((x.c.g) xVar.O()).h(ri(evVar));
        this.f231172s0.l0(xVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ii(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Oi(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ji(com.tencent.mobileqq.widget.listitem.x xVar, ev evVar) {
        ((x.c.g) xVar.O()).h(pi(evVar));
        this.f231172s0.l0(xVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ki(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Qi(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Li() {
        com.tencent.mobileqq.guild.widget.j jVar = this.f231161h0;
        if (jVar != null) {
            jVar.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit Mi(ISnapshotApi iSnapshotApi, FragmentActivity fragmentActivity) {
        lv1.a aVar = lv1.a.f415618a;
        aVar.e(null);
        Uri enterSnapshot = iSnapshotApi.enterSnapshot(fragmentActivity, 257);
        this.f231168o0 = enterSnapshot;
        aVar.e(enterSnapshot);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit Ni(String str) {
        this.f231166m0.setPersonalSignature(str);
        return null;
    }

    private void Oi(View view) {
        com.tencent.mobileqq.widget.selectorview.a aVar = new com.tencent.mobileqq.widget.selectorview.a(getContext());
        aVar.F(WnsError.WNS_CODE_LOGIN_PTLOGIN_BUSY);
        int[] iArr = this.f231165l0;
        aVar.E(iArr[0], iArr[1], iArr[2]);
        aVar.k(QQGuildUIUtil.r(R.string.f142970kt));
        aVar.i(new b(aVar, view));
        aVar.m();
    }

    private void Pi() {
        z02.a.b(getActivity(), new Runnable() { // from class: com.tencent.mobileqq.guild.profile.me.edit.a
            @Override // java.lang.Runnable
            public final void run() {
                GuildEditProfileFragment.this.Xi();
            }
        }, new Runnable() { // from class: com.tencent.mobileqq.guild.profile.me.edit.l
            @Override // java.lang.Runnable
            public final void run() {
                GuildEditProfileFragment.this.Yi();
            }
        }, new Runnable() { // from class: com.tencent.mobileqq.guild.profile.me.edit.p
            @Override // java.lang.Runnable
            public final void run() {
                GuildEditProfileFragment.this.Wi();
            }
        });
    }

    private void Qi(View view) {
        VideoReport.setElementId(view, "em_sgrp_mine_location_finish");
        VideoReport.reportEvent("dt_clck", view, new HashMap());
        GuildLocationActionSheet.g gVar = new GuildLocationActionSheet.g() { // from class: com.tencent.mobileqq.guild.profile.me.edit.n
            @Override // com.tencent.mobileqq.guild.widget.selector.GuildLocationActionSheet.g
            public final void a(String str, GProLocationInfo gProLocationInfo) {
                GuildEditProfileFragment.this.kj(str, gProLocationInfo);
            }
        };
        GuildLocationActionSheet guildLocationActionSheet = new GuildLocationActionSheet();
        guildLocationActionSheet.G(getQBaseActivity(), this.f231163j0, ch.v1(this.f231169p0), gVar);
        guildLocationActionSheet.Q();
    }

    private void Ri() {
        GuildModifyNickNameDialog.Jh(getChildFragmentManager());
    }

    private void Si(View view) {
        com.tencent.mobileqq.widget.selectorview.f fVar = new com.tencent.mobileqq.widget.selectorview.f(getContext());
        fVar.k("\u9009\u62e9\u6027\u522b");
        fVar.p(this.f231164k0);
        fVar.i(new a(fVar, view));
        fVar.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ti(IUploadApi.c cVar, IUploadApi.d dVar) {
        int i3;
        QLog.e("Guild.profile.GuildEditProfileFragment", 1, "onUploadFail task: " + cVar + " state:" + dVar);
        GuildCgiUploader.b b16 = GuildCgiUploader.b.b(dVar);
        if (b16.f215490a == 0) {
            i3 = 2;
        } else {
            i3 = 0;
        }
        QQToastUtil.showQQToast(i3, b16.f215491b);
        com.tencent.mobileqq.guild.performance.report.n.a("3", this.f231167n0, b16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ui(IUploadApi.c cVar, IUploadApi.d dVar) {
        if (QLog.isColorLevel()) {
            QLog.i("Guild.profile.GuildEditProfileFragment", 2, "onUploadProgress: " + dVar.f230933c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vi(IUploadApi.c cVar, IUploadApi.d dVar) {
        QLog.i("Guild.profile.GuildEditProfileFragment", 1, "onUploadSuccess task: " + cVar + " state:" + dVar);
        FragmentActivity activity = getActivity();
        GuildCgiUploader.b c16 = GuildCgiUploader.b.c(dVar.f230934d);
        int i3 = 0;
        if (c16.e()) {
            SecurityTipHelperKt.K(c16.f215492c, activity, dVar.f230932b, "", false);
        } else {
            if (c16.f215490a == 0) {
                ij(this.f231167n0);
            }
            if (c16.f215490a == 0) {
                i3 = 2;
            }
            QQToastUtil.showQQToast(i3, c16.f215491b);
        }
        aj.p();
        com.tencent.mobileqq.guild.performance.report.n.a("3", this.f231167n0, c16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wi() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        ((IPhotoPickAndEditApi) QRoute.api(IPhotoPickAndEditApi.class)).startPhotoPick(activity, 103);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xi() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        QPublicFragmentActivity.b.b(activity, new Intent().putExtra("tinyId", ch.f()).putExtra("guildId", "0").putExtra("from", 0), QPublicFragmentActivity.class, GuildCheckAvatarFragment.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yi() {
        final FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        final ISnapshotApi iSnapshotApi = (ISnapshotApi) QRoute.api(ISnapshotApi.class);
        if (iSnapshotApi.isOnVideoCalling()) {
            QQToast.makeText(activity, 0, R.string.f142640jx, 0).show();
        } else {
            br.a(br.PermissionParam.e(activity, QQPermissionConstants.Business.ID.QQ_CHANNEL_MAINFRAME, QQPermissionConstants.Business.SCENE.QQCHANEL_AVATAR_EDIT_CAMERA, Collections.singletonList(QQPermissionConstants.Permission.CAMERA)), new Function0() { // from class: com.tencent.mobileqq.guild.profile.me.edit.q
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit Mi;
                    Mi = GuildEditProfileFragment.this.Mi(iSnapshotApi, activity);
                    return Mi;
                }
            }, null);
        }
    }

    private void Zi() {
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity != null && !qBaseActivity.isFinishing()) {
            cx.a(qBaseActivity, "https://qun.qq.com/guild/h5/guild-medal");
        } else {
            QLog.d("Guild.profile.GuildEditProfileFragment", 1, "activity is null, do nothing.");
        }
    }

    private void aj() {
        GuildPersonalSignatureEditDialog guildPersonalSignatureEditDialog = new GuildPersonalSignatureEditDialog();
        String f16 = this.f231169p0.f();
        if (f16 == null) {
            f16 = "";
        }
        guildPersonalSignatureEditDialog.Bh(f16, this.f231166m0.getPersonalSignatureTemplates(), new Function1() { // from class: com.tencent.mobileqq.guild.profile.me.edit.m
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit Ni;
                Ni = GuildEditProfileFragment.this.Ni((String) obj);
                return Ni;
            }
        });
        com.tencent.mobileqq.guild.base.extension.d.a(guildPersonalSignatureEditDialog, getChildFragmentManager(), "Guild.profile.GuildEditProfileFragment");
    }

    private void bj() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_owner", true);
        GuildProfileArchivesListFragment.Jh(getActivity(), bundle, ch.f(), "0");
    }

    private void cj() {
        com.tencent.mobileqq.guild.base.extension.d.a(new GuildProfileSettingSwitchDialog(), getChildFragmentManager(), "GuildProfileSettingSwitchDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissCoverDialog() {
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.profile.me.edit.o
            @Override // java.lang.Runnable
            public final void run() {
                GuildEditProfileFragment.this.Li();
            }
        }, 200L);
    }

    private void dj(String str) {
        com.tencent.mobileqq.guild.performance.report.n.b(str, "3");
    }

    private void ej() {
        GuildDTReportApiImpl guildDTReportApiImpl = new GuildDTReportApiImpl();
        guildDTReportApiImpl.setElementExposureAndClickParams(this.T, "em_sgrp_mine_head", null);
        guildDTReportApiImpl.setElementExposureAndClickParams(this.Z, "em_sgrp_mine_addfile", null);
        guildDTReportApiImpl.setElementExposureAndClickParams(this.f231158e0, "em_sgrp_mine_record", null);
        guildDTReportApiImpl.setElementExposureAndClickParams(this.f231156c0, "em_sgrp_mine_allfile", null);
    }

    private void fj() {
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(this.P, "pg_sgrp_mine_edit");
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        com.tencent.mobileqq.guild.data.w.a(hashMap);
        VideoReport.setPageParams(this.P, new PageParams(hashMap));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gj(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "\u4fee\u6539\u5931\u8d25";
        }
        QQToast.makeText(MobileQQ.sMobileQQ.getApplicationContext(), 1, str, 1).show();
    }

    private void hj(xh2.c cVar) {
        mj(true);
        de a16 = cVar.a();
        t02.a aVar = new t02.a(a16.getApp(), a16.getView(), a16.getDesc(), a16.b(), a16.a(), a16.getConfig());
        aVar.h(QQGuildUIUtil.f(32.0f));
        IGuildFeatureAdapterApi iGuildFeatureAdapterApi = (IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class);
        if (this.f231160g0 == null) {
            this.f231159f0 = iGuildFeatureAdapterApi.initArkViewContainer();
            ViewGroup buildArkViewContentGroup = iGuildFeatureAdapterApi.buildArkViewContentGroup(getContext(), this.f231159f0, aVar, this.f231160g0);
            this.f231160g0 = buildArkViewContentGroup;
            buildArkViewContentGroup.setId(R.id.f165542wk2);
            this.f231158e0.addView(this.f231160g0);
            return;
        }
        this.f231160g0 = iGuildFeatureAdapterApi.buildArkViewContentGroup(getContext(), this.f231159f0, aVar, this.f231160g0);
    }

    private void ij(String str) {
        QLog.i("Guild.profile.GuildEditProfileFragment", 1, "updateAvatarImageByLocalFilePath: " + str);
        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
            this.Y.setAvatarImg(str);
        } else {
            this.Y.setAvatarTinyId("0", ch.f());
        }
    }

    private void initView() {
        this.P.setBackground(bc.b(requireContext(), R.drawable.qui_common_bg_bottom_standard_bg));
        this.C.setOnClickListener(this);
        ((GuildDefaultThemeNavBarCommon) this.N.findViewById(R.id.rlCommenTitle)).a();
        this.T = this.P.findViewById(R.id.wfw);
        this.U = (ImageView) this.P.findViewById(R.id.aok);
        this.V = (RelativeLayout) this.P.findViewById(R.id.wuc);
        this.W = (FlowLayout) this.P.findViewById(R.id.wud);
        this.X = (QUISettingsRecyclerView) this.P.findViewById(R.id.i4m);
        this.Y = (GuildUserAvatarViewWithPendant) this.P.findViewById(R.id.wk5);
        this.Z = this.P.findViewById(R.id.wfu);
        this.f231154a0 = this.P.findViewById(R.id.wvz);
        this.f231155b0 = this.P.findViewById(R.id.wom);
        this.f231156c0 = (TextView) this.P.findViewById(R.id.x2u);
        this.f231158e0 = (ViewGroup) this.P.findViewById(R.id.wfv);
        this.f231157d0 = (ImageView) this.P.findViewById(R.id.f165544wk4);
        this.Y.setAvatarSize(1);
        this.Y.setNeedListenChange(false);
        this.Y.setLogTag("Guild.profile.GuildEditProfileFragment");
        this.Y.setAvatarTinyId("0", ch.f());
        this.W.setHorizontalSpacing(10);
        aw1.g gVar = new aw1.g();
        this.f231171r0 = gVar;
        gVar.g(true);
        this.W.setAdapter(this.f231171r0);
        QUIListItemAdapter qUIListItemAdapter = new QUIListItemAdapter(QUIListItemStyle.Card);
        this.f231172s0 = qUIListItemAdapter;
        qUIListItemAdapter.t0(mi());
        this.X.setAdapter(this.f231172s0);
        Drawable drawable = this.f231156c0.getCompoundDrawables()[2];
        drawable.setBounds(0, 0, ViewUtils.dpToPx(16.0f), ViewUtils.dpToPx(16.0f));
        this.f231156c0.setCompoundDrawables(null, null, drawable, null);
        jj();
        vi();
        wi();
        GuildUserAvatarRepository.f(this);
    }

    private void initViewModel() {
        GuildEditProfileViewModel guildEditProfileViewModel = (GuildEditProfileViewModel) com.tencent.mobileqq.mvvm.h.a(this).get(GuildEditProfileViewModel.class);
        this.f231166m0 = guildEditProfileViewModel;
        guildEditProfileViewModel.getLiveProfileInfo().observe(this, new Observer() { // from class: com.tencent.mobileqq.guild.profile.me.edit.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildEditProfileFragment.this.nj((ev) obj);
            }
        });
        this.f231166m0.getErrorToast().observe(this, new Observer() { // from class: com.tencent.mobileqq.guild.profile.me.edit.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildEditProfileFragment.this.gj((String) obj);
            }
        });
        this.f231166m0.initData();
    }

    private void jj() {
        int i3;
        if (QQTheme.isVasTheme()) {
            i3 = R.color.qui_common_text_primary;
        } else {
            i3 = R.color.qui_common_icon_primary;
        }
        GuildUIUtils.d(this.U, R.drawable.qui_camera, Integer.valueOf(i3));
    }

    private void ki() {
        this.T.setOnClickListener(this);
        this.V.setOnClickListener(this);
        this.Z.setOnClickListener(this);
        this.f231154a0.setOnClickListener(this);
        this.f231155b0.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kj(String str, GProLocationInfo gProLocationInfo) {
        if (!TextUtils.isEmpty(str)) {
            this.f231166m0.setLocation(gProLocationInfo);
        }
    }

    private boolean li(xh2.c cVar) {
        if (cVar == null || cVar.getClientId() <= 0 || cVar.a() == null) {
            return false;
        }
        de a16 = cVar.a();
        if (TextUtils.isEmpty(a16.getApp()) || TextUtils.isEmpty(a16.getView()) || TextUtils.isEmpty(a16.a()) || TextUtils.isEmpty(a16.getConfig())) {
            return false;
        }
        return true;
    }

    private void lj(ArrayList<eu> arrayList) {
        if (!arrayList.isEmpty()) {
            QLog.d("Guild.profile.GuildEditProfileFragment", 1, "updateMedalList: " + arrayList.size());
            if (this.f231171r0 == null) {
                aw1.g gVar = new aw1.g();
                this.f231171r0 = gVar;
                gVar.g(true);
                this.W.setAdapter(this.f231171r0);
            }
            if (arrayList.size() > 3) {
                this.f231171r0.setData(MedalItem.c(arrayList.subList(0, 3)));
                return;
            } else {
                this.f231171r0.setData(MedalItem.c(arrayList));
                return;
            }
        }
        aw1.g gVar2 = this.f231171r0;
        if (gVar2 != null) {
            gVar2.setData(Collections.emptyList());
        }
    }

    private Group[] mi() {
        ArrayList arrayList = new ArrayList();
        final com.tencent.mobileqq.widget.listitem.x xVar = new com.tencent.mobileqq.widget.listitem.x(new x.b.d(getString(R.string.f143410m0)), new x.c.g("", true, false));
        ji(xVar, new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.profile.me.edit.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildEditProfileFragment.this.Di(view);
            }
        });
        this.f231166m0.getLiveProfileInfo().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.profile.me.edit.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildEditProfileFragment.this.Ei(xVar, (ev) obj);
            }
        });
        final com.tencent.mobileqq.widget.listitem.x xVar2 = new com.tencent.mobileqq.widget.listitem.x(new x.b.d(getString(R.string.f143400lz)), new x.c.g("", true, false));
        ji(xVar2, new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.profile.me.edit.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildEditProfileFragment.this.Fi(view);
            }
        });
        xVar2.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.guild.profile.me.edit.d
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                GuildEditProfileFragment.Gi(view);
            }
        });
        this.f231166m0.getLiveProfileInfo().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.profile.me.edit.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildEditProfileFragment.this.Hi(xVar2, (ev) obj);
            }
        });
        final com.tencent.mobileqq.widget.listitem.x xVar3 = new com.tencent.mobileqq.widget.listitem.x(new x.b.d(getString(R.string.f143390ly)), new x.c.g("", true, false));
        ji(xVar3, new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.profile.me.edit.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildEditProfileFragment.this.Ii(view);
            }
        });
        this.f231166m0.getLiveProfileInfo().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.profile.me.edit.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildEditProfileFragment.this.Ji(xVar3, (ev) obj);
            }
        });
        final com.tencent.mobileqq.widget.listitem.x xVar4 = new com.tencent.mobileqq.widget.listitem.x(new x.b.d(getString(R.string.f143380lx)), new x.c.g("", true, false));
        ji(xVar4, new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.profile.me.edit.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildEditProfileFragment.this.Ki(view);
            }
        });
        this.f231166m0.getLiveProfileInfo().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.profile.me.edit.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildEditProfileFragment.this.yi(xVar4, (ev) obj);
            }
        });
        final com.tencent.mobileqq.widget.listitem.x xVar5 = new com.tencent.mobileqq.widget.listitem.x(new x.b.d(getString(R.string.f143420m1)), new x.c.g("", true, false));
        ji(xVar5, new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.profile.me.edit.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildEditProfileFragment.this.zi(view);
            }
        });
        xVar5.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.guild.profile.me.edit.u
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                GuildEditProfileFragment.Ai(view);
            }
        });
        this.f231166m0.getLiveProfileInfo().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.profile.me.edit.v
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildEditProfileFragment.this.Bi(xVar5, (ev) obj);
            }
        });
        arrayList.add(new Group(xVar, xVar2, xVar3, xVar4, xVar5));
        arrayList.add(new Group(ji(new com.tencent.mobileqq.widget.listitem.x(new x.b.d(getString(R.string.f1522219t)), new x.c.g("", true, false)), new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.profile.me.edit.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildEditProfileFragment.this.Ci(view);
            }
        })));
        return (Group[]) arrayList.toArray(new Group[arrayList.size()]);
    }

    private void mj(boolean z16) {
        if (z16) {
            this.Z.setVisibility(8);
            this.f231158e0.setVisibility(0);
            this.f231156c0.setVisibility(0);
        } else {
            this.f231158e0.setVisibility(8);
            this.Z.setVisibility(0);
            this.f231156c0.setVisibility(8);
        }
    }

    private void ni() {
        de a16;
        xh2.c j3 = this.f231169p0.j();
        if (!li(j3)) {
            this.f231170q0 = null;
            mj(false);
            QLog.w("Guild.profile.GuildEditProfileFragment", 1, "dealGameRecord archiveArkData is error");
            return;
        }
        xh2.c cVar = this.f231170q0;
        if (cVar != null && cVar.getClientId() == j3.getClientId() && (a16 = this.f231170q0.a()) != null && bk.a(a16, j3.a())) {
            if (QLog.isColorLevel()) {
                QLog.d("Guild.profile.GuildEditProfileFragment", 2, "same archiveArk clientId don't update, ", Integer.valueOf(j3.getClientId()));
            }
        } else {
            this.f231170q0 = j3;
            hj(j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nj(ev evVar) {
        if (evVar == null) {
            QLog.w("Guild.profile.GuildEditProfileFragment", 2, "updateView get data is null");
            return;
        }
        this.f231169p0 = evVar;
        ni();
        lj(evVar.getMedals());
    }

    private String oi(ev evVar) {
        GProLocationInfo v16 = ch.v1(evVar);
        StringBuilder sb5 = new StringBuilder();
        String f16 = v16.f();
        if (v16.l() && !TextUtils.isEmpty(f16)) {
            sb5.append(f16);
        }
        String j3 = v16.j();
        if (!TextUtils.isEmpty(j3)) {
            if (sb5.length() != 0) {
                sb5.append("-");
            }
            sb5.append(j3);
        }
        String a16 = v16.a();
        if (!TextUtils.isEmpty(a16)) {
            if (sb5.length() != 0) {
                sb5.append("-");
            }
            sb5.append(a16);
        }
        if (sb5.length() > 0) {
            return sb5.toString();
        }
        return "";
    }

    private String pi(ev evVar) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append((int) evVar.getAge());
        sb5.append(QQGuildUIUtil.r(R.string.f138870_q));
        if (!TextUtils.isEmpty(evVar.t())) {
            sb5.append("-");
            sb5.append(evVar.t());
        }
        this.f231165l0[0] = evVar.o();
        this.f231165l0[1] = evVar.b();
        this.f231165l0[2] = evVar.e();
        return sb5.toString();
    }

    private String qi(ev evVar) {
        String nickName = evVar.getNickName();
        if (!TextUtils.isEmpty(nickName)) {
            return nickName;
        }
        return "";
    }

    private String ri(ev evVar) {
        int i3;
        int i16 = 1;
        if (evVar.getGender() == 1) {
            i3 = R.string.f1488310n;
        } else {
            i3 = R.string.f145780se;
        }
        String r16 = QQGuildUIUtil.r(i3);
        if (evVar.getGender() == 1) {
            i16 = 0;
        }
        this.f231164k0 = i16;
        return r16;
    }

    private String si(ev evVar) {
        String f16 = evVar.f();
        if (TextUtils.isEmpty(f16)) {
            return QQGuildUIUtil.r(R.string.f143430m2);
        }
        return f16;
    }

    private void ti(int i3, int i16) {
        if (QLog.isColorLevel()) {
            QLog.d("Guild.profile.GuildEditProfileFragment", 2, "handleActivityResult");
        }
        FragmentActivity activity = getActivity();
        if (activity == null || i16 != -1) {
            return;
        }
        if (this.f231168o0 == null) {
            lv1.a aVar = lv1.a.f415618a;
            if (aVar.d() != null) {
                this.f231168o0 = aVar.d();
            }
        }
        if (i3 == 257) {
            Uri uri = this.f231168o0;
            if (uri != null) {
                this.f231168o0 = null;
                ((IPhotoPickAndEditApi) QRoute.api(IPhotoPickAndEditApi.class)).startPhotoEdit(activity, BaseImageUtil.getRealPathFromContentURI(activity, uri), 103);
                return;
            }
            return;
        }
        if (i3 == 1) {
            if (getActivity() != null && !getActivity().isFinishing()) {
                aj.p();
                return;
            } else {
                QLog.w("Guild.profile.GuildEditProfileFragment", 1, "handleActivityResult failed!");
                return;
            }
        }
        QLog.w("Guild.profile.GuildEditProfileFragment", 1, "handleActivityResult failed requestCode " + i3);
    }

    private void ui(Intent intent) {
        String stringExtra = intent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
        if (!TextUtils.isEmpty(stringExtra)) {
            if (QLog.isColorLevel()) {
                QLog.i("Guild.profile.GuildEditProfileFragment", 2, String.format("doOnNewIntent path=%s", stringExtra));
            }
            this.f231167n0 = stringExtra;
            dj(stringExtra);
            this.f231162i0.f(stringExtra, com.tencent.mobileqq.guild.common.upload.c.personalAvatar, com.tencent.mobileqq.guild.common.upload.b.a(), new c());
        }
    }

    private void vi() {
        this.f231157d0.setImageDrawable(ch.J("https://downv6.qq.com/innovate/guild/empty_view/guild_my_empty_add_record.png", ViewUtils.dpToPx(75.0f), null, false));
        if (GuildThemeManager.f235286a.b()) {
            this.f231157d0.setAlpha(0.6f);
        } else {
            this.f231157d0.setAlpha(1.0f);
        }
    }

    private void wi() {
        this.f231162i0 = new GuildCgiUploader(ch.g(), "0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void xi(View.OnClickListener onClickListener, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!com.tencent.mobileqq.guild.util.o.a(view)) {
            onClickListener.onClick(view);
            VideoReport.reportEvent("dt_clck", view, new HashMap());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void yi(com.tencent.mobileqq.widget.listitem.x xVar, ev evVar) {
        ((x.c.g) xVar.O()).h(oi(evVar));
        this.f231172s0.l0(xVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void zi(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        aj();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        this.f231163j0 = (BaseQQAppInterface) getQBaseActivity().getAppRuntime();
        initViewModel();
        initView();
        ki();
        fj();
        ej();
        GuildThemeManager.g(this);
    }

    @Override // com.tencent.mobileqq.guild.avatar.e
    public void doOnUrlChange(@NonNull String str, @NonNull String str2) {
        if (!TextUtils.equals(str, "0") || !TextUtils.equals(str2, ch.f()) || isResumed()) {
            return;
        }
        this.Y.setAvatarTinyId("0", ch.f());
        QLog.d("Guild.profile.GuildEditProfileFragment", 1, "doOnUrlChange guildId:", str, " tinyId:", str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.em9;
    }

    com.tencent.mobileqq.widget.listitem.x ji(com.tencent.mobileqq.widget.listitem.x xVar, final View.OnClickListener onClickListener) {
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.profile.me.edit.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildEditProfileFragment.xi(onClickListener, view);
            }
        });
        return xVar;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, @Nullable Intent intent) {
        super.onActivityResult(i3, i16, intent);
        ti(i3, i16);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!com.tencent.mobileqq.guild.util.o.a(view)) {
            int id5 = view.getId();
            if (view == this.C) {
                onBackEvent();
            } else if (id5 == R.id.wfw) {
                Pi();
            } else if (id5 != R.id.wfu && id5 != R.id.wvz) {
                if (id5 == R.id.wom) {
                    bj();
                } else if (id5 == R.id.wuc) {
                    Zi();
                    VideoReport.setElementId(view, "em_sgrp_personal_medal");
                }
            } else {
                bj();
            }
            VideoReport.reportEvent("dt_clck", view, new HashMap());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        GuildThemeManager.j(this);
        super.onDestroy();
        GuildUserAvatarRepository.k(this);
        IGuildFeatureAdapterApi iGuildFeatureAdapterApi = (IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class);
        Object obj = this.f231159f0;
        if (obj != null) {
            iGuildFeatureAdapterApi.destroyArkViewContainer(obj);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        ui(intent);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public void onPostThemeChanged() {
        super.onPostThemeChanged();
        this.P.setBackground(bc.b(requireContext(), R.drawable.qui_common_bg_bottom_standard_bg));
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).invalidateArkViewContainer(this.f231159f0);
        this.f231166m0.refreshProfile();
    }

    @Override // com.tencent.mobileqq.guild.theme.d
    public void onThemeChanged() {
        ((GuildDefaultThemeNavBarCommon) this.N.findViewById(R.id.rlCommenTitle)).a();
        jj();
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    protected int ph() {
        return R.color.qui_common_bg_bottom_light;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public class a implements QActionSheet.f {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.widget.selectorview.f f231173d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f231174e;

        a(com.tencent.mobileqq.widget.selectorview.f fVar, View view) {
            this.f231173d = fVar;
            this.f231174e = view;
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void onConfirm() {
            int i3;
            GuildEditProfileFragment.this.f231164k0 = this.f231173d.o();
            if (GuildEditProfileFragment.this.f231164k0 == 0) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            GuildEditProfileFragment.this.f231166m0.setGender(i3);
            GuildEditProfileFragment.this.dismissCoverDialog();
            VideoReport.setElementId(this.f231174e, "em_sgrp_mine_gender_finish");
            VideoReport.reportEvent("dt_clck", this.f231174e, new HashMap());
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void onDismiss() {
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void t() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public class b implements QActionSheet.f {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.widget.selectorview.a f231176d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f231177e;

        b(com.tencent.mobileqq.widget.selectorview.a aVar, View view) {
            this.f231176d = aVar;
            this.f231177e = view;
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void onConfirm() {
            int z16 = this.f231176d.z();
            GuildEditProfileFragment.this.f231165l0 = com.tencent.mobileqq.guild.widget.selector.b.a(z16);
            GuildEditProfileFragment.this.f231166m0.setBirthday(GuildEditProfileFragment.this.f231165l0[0], GuildEditProfileFragment.this.f231165l0[1], GuildEditProfileFragment.this.f231165l0[2]);
            GuildEditProfileFragment.this.dismissCoverDialog();
            VideoReport.setElementId(this.f231177e, "em_sgrp_mine_age_finish");
            VideoReport.reportEvent("dt_clck", this.f231177e, new HashMap());
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void onDismiss() {
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void t() {
        }
    }
}
