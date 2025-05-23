package com.tencent.mobileqq.guild.setting.guildmanage.avatar;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.common.upload.GuildCgiUploader;
import com.tencent.mobileqq.guild.component.multitouchimg.MultiTouchImageView;
import com.tencent.mobileqq.guild.nt.album.api.IPhotoPickAndEditApi;
import com.tencent.mobileqq.guild.nt.misc.api.ISnapshotApi;
import com.tencent.mobileqq.guild.nt.misc.api.IUploadApi;
import com.tencent.mobileqq.guild.performance.report.n;
import com.tencent.mobileqq.guild.setting.guildmanage.avatar.QQGuildAvatarSettingFragment;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.br;
import com.tencent.mobileqq.guild.util.bt;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.guild.util.v;
import com.tencent.mobileqq.guild.widget.GuildLevelRoleView;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildAuditBaseItem;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildAuditInfo;
import com.tencent.util.QQToastUtil;
import com.tencent.util.UiThreadUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes14.dex */
public class QQGuildAvatarSettingFragment extends QPublicBaseFragment implements View.OnClickListener {
    private IGProGuildInfo C;
    private Button D;
    private GuildCgiUploader E;
    private MultiTouchImageView F;
    private RelativeLayout G;
    private ImageView H;
    private String I;
    private Uri J;
    private String K;
    private GPServiceObserver L = new a();

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a extends GPServiceObserver {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildInfoUpdated(String str) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(QQGuildAvatarSettingFragment.this.I) && TextUtils.equals(QQGuildAvatarSettingFragment.this.I, str)) {
                super.onGuildInfoUpdated(str);
                QQGuildAvatarSettingFragment.this.C = ((IGPSService) ch.R0(IGPSService.class)).getGuildInfo(str);
                QQGuildAvatarSettingFragment qQGuildAvatarSettingFragment = QQGuildAvatarSettingFragment.this;
                qQGuildAvatarSettingFragment.Ih(qQGuildAvatarSettingFragment.C);
                QQGuildAvatarSettingFragment.this.Th();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class b implements IUploadApi.b {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(IUploadApi.c cVar, IUploadApi.d dVar) {
            QQGuildAvatarSettingFragment.this.Jh(cVar, dVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(IUploadApi.c cVar, IUploadApi.d dVar) {
            QQGuildAvatarSettingFragment.this.Lh(cVar, dVar);
        }

        @Override // com.tencent.mobileqq.guild.nt.misc.api.IUploadApi.b
        public void a(final IUploadApi.c cVar, final IUploadApi.d dVar) {
            QLog.i("Guild.mnr.QQGuildAvatarSettingFragment", 2, "task: " + cVar + " " + dVar);
            int i3 = dVar.f230931a;
            if (i3 == 0) {
                QQGuildAvatarSettingFragment.this.Kh(cVar, dVar);
            } else {
                if (i3 != 1) {
                    if (i3 == 2) {
                        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.avatar.l
                            @Override // java.lang.Runnable
                            public final void run() {
                                QQGuildAvatarSettingFragment.b.this.d(cVar, dVar);
                            }
                        });
                        return;
                    }
                    return;
                }
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.avatar.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        QQGuildAvatarSettingFragment.b.this.e(cVar, dVar);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class c implements Function1<Integer, Unit> {
        c() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(Integer num) {
            QQGuildAvatarSettingFragment.this.onBackEvent();
            return null;
        }
    }

    private String Ch() {
        return getQBaseActivity().getAppRuntime().getAccount();
    }

    private void Dh(Intent intent) {
        String stringExtra = intent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
        if (!TextUtils.isEmpty(stringExtra)) {
            if (QLog.isColorLevel()) {
                QLog.i("Guild.mnr.QQGuildAvatarSettingFragment", 2, String.format("doOnNewIntent path=%s", stringExtra));
            }
            this.K = stringExtra;
            Oh(stringExtra);
            this.E.f(stringExtra, com.tencent.mobileqq.guild.common.upload.c.guildAvatar, com.tencent.mobileqq.guild.common.upload.b.a(), new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean Fh(View view) {
        Ph();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Gh(Bitmap bitmap) {
        if (bitmap != null) {
            this.F.setImageBitmap(bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit Hh(ISnapshotApi iSnapshotApi, FragmentActivity fragmentActivity) {
        lv1.a aVar = lv1.a.f415618a;
        aVar.e(null);
        Uri enterSnapshot = iSnapshotApi.enterSnapshot(fragmentActivity, 257);
        this.J = enterSnapshot;
        aVar.e(enterSnapshot);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ih(IGProGuildInfo iGProGuildInfo) {
        if (iGProGuildInfo == null) {
            QLog.e("Guild.mnr.QQGuildAvatarSettingFragment", 2, "loadAvatarImage error ");
        } else {
            v.f(iGProGuildInfo.getAvatarUrl(0), this.F.getWidth(), this.F.getHeight(), new GuildLevelRoleView.a() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.avatar.e
                @Override // com.tencent.mobileqq.guild.widget.GuildLevelRoleView.a
                public final void a(Bitmap bitmap) {
                    QQGuildAvatarSettingFragment.this.Gh(bitmap);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void Kh(IUploadApi.c cVar, IUploadApi.d dVar) {
        QLog.i("Guild.mnr.QQGuildAvatarSettingFragment", 2, "onUploadProgress: " + dVar.f230933c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mh() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        cz1.a.c(activity, 105);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nh() {
        final FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        final ISnapshotApi iSnapshotApi = (ISnapshotApi) QRoute.api(ISnapshotApi.class);
        if (iSnapshotApi.isOnVideoCalling()) {
            QQToast.makeText(activity, 0, R.string.f142640jx, 0).show();
        } else {
            br.a(br.PermissionParam.e(activity, QQPermissionConstants.Business.ID.QQ_CHANNEL_MAINFRAME, QQPermissionConstants.Business.SCENE.QQCHANEL_GUILD_AVATAR, Collections.singletonList(QQPermissionConstants.Permission.CAMERA)), new Function0() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.avatar.k
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit Hh;
                    Hh = QQGuildAvatarSettingFragment.this.Hh(iSnapshotApi, activity);
                    return Hh;
                }
            }, null);
        }
    }

    private void Oh(String str) {
        n.b(str, "2");
    }

    private void Qh() {
        ArrayList<GProGuildAuditBaseItem> auditContentList;
        if (QQGuildUIUtil.v()) {
            return;
        }
        IGProGuildInfo iGProGuildInfo = this.C;
        if (iGProGuildInfo == null) {
            QLog.e("Guild.mnr.QQGuildAvatarSettingFragment", 1, "loadAvatarImage error ");
            return;
        }
        GProGuildAuditInfo guildAuditInfo = iGProGuildInfo.getGuildAuditInfo();
        QLog.d("Guild.mnr.QQGuildAvatarSettingFragment", 2, "showSelectDialog guildAuditInfo:", guildAuditInfo);
        if (guildAuditInfo != null && (auditContentList = guildAuditInfo.getAuditContentList()) != null && !auditContentList.isEmpty()) {
            Iterator<GProGuildAuditBaseItem> it = auditContentList.iterator();
            while (it.hasNext()) {
                if (it.next().getType() == 2) {
                    QQToastUtil.showQQToast(0, "\u5ba1\u6838\u4e2d\uff0c\u6682\u4e0d\u652f\u6301\u4fee\u6539");
                    return;
                }
            }
        }
        z02.a.a(getActivity(), new Runnable() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.avatar.h
            @Override // java.lang.Runnable
            public final void run() {
                QQGuildAvatarSettingFragment.this.Nh();
            }
        }, new Runnable() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.avatar.i
            @Override // java.lang.Runnable
            public final void run() {
                QQGuildAvatarSettingFragment.this.Mh();
            }
        });
    }

    public static void Rh(Context context, IGProGuildInfo iGProGuildInfo, int i3) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable("extra_guild_guild_info", iGProGuildInfo);
        intent.putExtras(bundle);
        QPublicFragmentActivity.b.f(context, intent, QPublicFragmentActivity.class, QQGuildAvatarSettingFragment.class, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sh(MotionEvent motionEvent) {
        if (Math.abs(this.F.getScale() - 1.0f) > 0.15d) {
            this.F.setScale(1.0f, true);
        } else {
            MultiTouchImageView multiTouchImageView = this.F;
            multiTouchImageView.setScale(multiTouchImageView.getMaximumScale(), motionEvent.getX(), motionEvent.getY(), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Th() {
        if (ch.m0(this.I)) {
            this.D.setVisibility(0);
        } else {
            this.D.setVisibility(8);
        }
    }

    private void initData() {
        IGProGuildInfo iGProGuildInfo = (IGProGuildInfo) requireActivity().getIntent().getExtras().getSerializable("extra_guild_guild_info");
        this.C = iGProGuildInfo;
        if (iGProGuildInfo == null) {
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.f157721no, 1).show();
            requireActivity().finish();
            return;
        }
        String guildID = iGProGuildInfo.getGuildID();
        this.I = guildID;
        if (TextUtils.isEmpty(guildID)) {
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.f157721no, 1).show();
            requireActivity().finish();
        }
        this.E = new GuildCgiUploader(Ch(), this.I);
        ((IGPSService) ch.R0(IGPSService.class)).addObserver(this.L);
        Ih(this.C);
        Th();
        if (ch.l0(this.C)) {
            ((IGPSService) ch.R0(IGPSService.class)).fetchGuildInfoWithSource(this.I, 107, new vh2.v() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.avatar.j
                @Override // vh2.v
                public final void a(int i3, String str, IGProGuildInfo iGProGuildInfo2) {
                    QQGuildAvatarSettingFragment.Eh(i3, str, iGProGuildInfo2);
                }
            });
        }
    }

    private void initDtReport() {
        VideoReport.addToDetectionWhitelist(getQBaseActivity());
        VideoReport.setPageId(this.G, "pg_sgrp_channel_head_set");
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_channel_id", this.I);
        hashMap.put("sgrp_user_type", Integer.valueOf(com.tencent.mobileqq.guild.data.v.c(this.I)));
        hashMap.put("sgrp_duration_flag", 1);
        VideoReport.setPageParams(this.G, new PageParams(hashMap));
        bt.a(this.D, "em_sgrp_head_change");
    }

    private void initView() {
        Button button = (Button) this.G.findViewById(R.id.afx);
        this.D = button;
        button.setOnClickListener(this);
        this.F = (MultiTouchImageView) this.G.findViewById(R.id.f165437w02);
        ImageView imageView = (ImageView) this.G.findViewById(R.id.ivTitleBtnLeft);
        this.H = imageView;
        imageView.setOnClickListener(this);
        this.F.setOnDoubleTabListener(new com.tencent.mobileqq.guild.component.multitouchimg.d() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.avatar.f
            @Override // com.tencent.mobileqq.guild.component.multitouchimg.d
            public final void onDoubleTap(MotionEvent motionEvent) {
                QQGuildAvatarSettingFragment.this.Sh(motionEvent);
            }
        });
        this.F.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.avatar.g
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean Fh;
                Fh = QQGuildAvatarSettingFragment.this.Fh(view);
                return Fh;
            }
        });
    }

    private static void showToast(String str, int i3) {
        QQToast.makeText(BaseApplication.getContext(), i3, str, 1).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
    }

    public void Jh(IUploadApi.c cVar, IUploadApi.d dVar) {
        int i3 = 2;
        QLog.i("Guild.mnr.QQGuildAvatarSettingFragment", 2, "onUploadFail: " + dVar + " task: " + cVar);
        GuildCgiUploader.b b16 = GuildCgiUploader.b.b(dVar);
        String str = b16.f215491b;
        if (b16.f215490a != 0) {
            i3 = 0;
        }
        showToast(str, i3);
        n.a("2", this.K, b16);
    }

    public void Lh(IUploadApi.c cVar, IUploadApi.d dVar) {
        String str;
        int i3 = 0;
        if (QLog.isColorLevel()) {
            QLog.d("Guild.mnr.QQGuildAvatarSettingFragment", 2, "onUploadSuccess state:", cVar.getTaskState(), "state:", dVar);
        }
        FragmentActivity activity = getActivity();
        GuildCgiUploader.b c16 = GuildCgiUploader.b.c(dVar.f230934d);
        if (c16.e()) {
            SecurityTipHelperKt.L(c16.f215492c, activity, dVar.f230932b, "", false, new c());
        } else {
            int i16 = c16.f215490a;
            if (i16 == 0) {
                str = "\u5df2\u63d0\u4ea4\u5ba1\u6838\uff0c\u901a\u8fc7\u540e\u751f\u6548";
            } else {
                str = c16.f215491b;
            }
            if (i16 == 0) {
                i3 = 2;
            }
            showToast(str, i3);
            if (activity != null) {
                activity.setResult(-1);
                onBackEvent();
            }
        }
        n.a("2", this.K, c16);
    }

    public void Ph() {
        IGProGuildInfo iGProGuildInfo = this.C;
        if (iGProGuildInfo == null) {
            QLog.e("Guild.mnr.QQGuildAvatarSettingFragment", 1, "loadAvatarImage error ");
        } else {
            new GuildImageShareActionSheet(requireActivity(), iGProGuildInfo.getAvatarUrl(0)).D();
        }
    }

    public AppInterface getAppInterface() {
        if (getQBaseActivity().getAppRuntime() instanceof AppInterface) {
            return (AppInterface) getQBaseActivity().getAppRuntime();
        }
        return null;
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
        Uri uri;
        super.onActivityResult(i3, i16, intent);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        if (this.J == null) {
            lv1.a aVar = lv1.a.f415618a;
            if (aVar.d() != null) {
                this.J = aVar.d();
            }
        }
        if (i16 == -1 && i3 == 257 && (uri = this.J) != null) {
            this.J = null;
            ((IPhotoPickAndEditApi) QRoute.api(IPhotoPickAndEditApi.class)).startPhotoEdit(activity, BaseImageUtil.getRealPathFromContentURI(activity, uri), 105);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        if (getActivity() != null) {
            getActivity().finish();
            return false;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.D) {
            Qh();
        } else if (view == this.H) {
            getActivity().finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.G = (RelativeLayout) layoutInflater.inflate(R.layout.egm, (ViewGroup) null);
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            this.G.setFitsSystemWindows(true);
        }
        initView();
        initData();
        initDtReport();
        RelativeLayout relativeLayout = this.G;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, relativeLayout);
        return relativeLayout;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (getAppInterface() != null) {
            ((IGPSService) getAppInterface().getRuntimeService(IGPSService.class, "")).deleteObserver(this.L);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Dh(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Eh(int i3, String str, IGProGuildInfo iGProGuildInfo) {
    }
}
