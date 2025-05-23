package com.tencent.mobileqq.guild.profile.me.avatar;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.fragment.app.FragmentActivity;
import com.tencent.image.URLDrawable;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.impl.GuildDTReportApiImpl;
import com.tencent.mobileqq.guild.avatar.GuildUserAvatarRepository;
import com.tencent.mobileqq.guild.avatar.e;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.common.upload.GuildCgiUploader;
import com.tencent.mobileqq.guild.common.upload.c;
import com.tencent.mobileqq.guild.data.w;
import com.tencent.mobileqq.guild.nt.album.api.IPhotoPickAndEditApi;
import com.tencent.mobileqq.guild.nt.misc.api.ISnapshotApi;
import com.tencent.mobileqq.guild.nt.misc.api.IUploadApi;
import com.tencent.mobileqq.guild.performance.report.n;
import com.tencent.mobileqq.guild.profile.me.avatar.GuildCheckAvatarFragment;
import com.tencent.mobileqq.guild.temp.api.IGuildPhotoUtilsApi;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.br;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.annotation.QQPermissionConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.util.QQToastUtil;
import com.tencent.util.UiThreadUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@QQPermissionConfig(id = QQPermissionConstants.Business.ID.QQ_CHANNEL_MAINFRAME, scene = QQPermissionConstants.Business.SCENE.QQCHANEL_AVATAR_SAVE_ALBUM)
/* loaded from: classes14.dex */
public class GuildCheckAvatarFragment extends QQGuildTitleBarFragment implements View.OnClickListener, e {
    private GuildUserAvatarView T;
    private Button U;
    private GuildCgiUploader V;
    private String W;
    private QQPermission X;
    private Uri Y;
    private String Z;

    /* renamed from: a0, reason: collision with root package name */
    private int f231139a0 = 0;

    /* renamed from: b0, reason: collision with root package name */
    private String f231140b0 = "";

    /* renamed from: c0, reason: collision with root package name */
    private String f231141c0 = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a implements IUploadApi.b {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(IUploadApi.c cVar, IUploadApi.d dVar) {
            GuildCheckAvatarFragment.this.Rh(cVar, dVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(IUploadApi.c cVar, IUploadApi.d dVar) {
            GuildCheckAvatarFragment.this.Th(cVar, dVar);
        }

        @Override // com.tencent.mobileqq.guild.nt.misc.api.IUploadApi.b
        public void a(final IUploadApi.c cVar, final IUploadApi.d dVar) {
            int i3 = dVar.f230931a;
            if (i3 == 0) {
                GuildCheckAvatarFragment.this.Sh(cVar, dVar);
            } else {
                if (i3 != 1) {
                    if (i3 == 2) {
                        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.profile.me.avatar.a
                            @Override // java.lang.Runnable
                            public final void run() {
                                GuildCheckAvatarFragment.a.this.d(cVar, dVar);
                            }
                        });
                        return;
                    }
                    return;
                }
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.profile.me.avatar.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        GuildCheckAvatarFragment.a.this.e(cVar, dVar);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class b extends QQPermission.BasePermissionsListener {
        b() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            GuildCheckAvatarFragment guildCheckAvatarFragment = GuildCheckAvatarFragment.this;
            guildCheckAvatarFragment.Zh(guildCheckAvatarFragment.W);
        }
    }

    private String Kh() {
        return getQBaseActivity().getAppRuntime().getCurrentUin();
    }

    private URLDrawable.URLDrawableOptions Lh() {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(QQGuildUIUtil.j(true));
        obtain.mLoadingDrawable = bitmapDrawable;
        obtain.mFailedDrawable = bitmapDrawable;
        return obtain;
    }

    private void Mh(Intent intent) {
        String stringExtra = intent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
        if (!TextUtils.isEmpty(stringExtra)) {
            if (QLog.isColorLevel()) {
                QLog.i("Guild.profile.GuildCheckAvatarFragment", 2, String.format("doOnNewIntent path=%s", stringExtra));
            }
            this.Z = stringExtra;
            Xh(stringExtra);
            this.V.f(stringExtra, c.personalAvatar, com.tencent.mobileqq.guild.common.upload.b.a(), new a());
        }
    }

    private void Nh() {
        this.T.setLogTag("Guild.profile.GuildCheckAvatarFragment");
        if (this.f231139a0 == 1 && !TextUtils.isEmpty(this.f231140b0) && !TextUtils.isEmpty(this.f231141c0)) {
            this.T.setAvatarTinyId(this.f231141c0, this.f231140b0);
        } else {
            this.T.setAvatarTinyId("0", ch.f());
        }
        this.T.setRoundRect(0);
        this.T.setAvatarSize(2);
        this.T.setNeedListenChange(false);
    }

    private void Oh() {
        this.V = new GuildCgiUploader(Kh(), "0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit Ph(ISnapshotApi iSnapshotApi, FragmentActivity fragmentActivity) {
        this.Y = iSnapshotApi.enterSnapshot(fragmentActivity, 257);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Qh(ActionSheet actionSheet, View view, int i3) {
        if (TextUtils.isEmpty(this.W)) {
            QLog.d("Guild.profile.GuildCheckAvatarFragment", 1, "filePath is null try get avatar cache file");
            Yh(((IGPSService) ch.R0(IGPSService.class)).getFullGuildUserUserAvatarUrl(this.f231141c0, this.f231140b0, 2));
        }
        if (!TextUtils.isEmpty(this.W) && new File(this.W).exists()) {
            GuildDTReportApiImpl guildDTReportApiImpl = new GuildDTReportApiImpl();
            if (i3 != 0) {
                if (i3 == 1) {
                    guildDTReportApiImpl.setElementExposureAndClickParams(view, "pg_sgrp_mine_avatar_save", null);
                    VideoReport.reportEvent("dt_clck", view, new HashMap());
                    ai();
                }
            } else {
                guildDTReportApiImpl.setElementExposureAndClickParams(view, "pg_sgrp_mine_avatar_send", null);
                VideoReport.reportEvent("dt_clck", view, new HashMap());
                ((IGuildPhotoUtilsApi) QRoute.api(IGuildPhotoUtilsApi.class)).forward(this.W, getQBaseActivity());
            }
            actionSheet.dismiss();
            return;
        }
        QLog.w("Guild.profile.GuildCheckAvatarFragment", 1, "can't find avatar cache! " + this.W);
        actionSheet.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void Sh(IUploadApi.c cVar, IUploadApi.d dVar) {
        if (QLog.isColorLevel()) {
            QLog.i("Guild.profile.GuildCheckAvatarFragment", 2, "onUploadProgress: " + dVar.f230933c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uh() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        ((IPhotoPickAndEditApi) QRoute.api(IPhotoPickAndEditApi.class)).startPhotoPick(activity, 103);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vh() {
        final FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        final ISnapshotApi iSnapshotApi = (ISnapshotApi) QRoute.api(ISnapshotApi.class);
        if (iSnapshotApi.isOnVideoCalling()) {
            QQToast.makeText(activity, 0, R.string.f142640jx, 0).show();
        } else {
            br.a(br.PermissionParam.e(activity, QQPermissionConstants.Business.ID.QQ_CHANNEL_MAINFRAME, QQPermissionConstants.Business.SCENE.QQCHANEL_AVATAR_EDIT_CAMERA, Collections.singletonList(QQPermissionConstants.Permission.CAMERA)), new Function0() { // from class: nv1.d
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit Ph;
                    Ph = GuildCheckAvatarFragment.this.Ph(iSnapshotApi, activity);
                    return Ph;
                }
            }, null);
        }
    }

    private void Wh() {
        z02.a.a(getActivity(), new Runnable() { // from class: nv1.b
            @Override // java.lang.Runnable
            public final void run() {
                GuildCheckAvatarFragment.this.Vh();
            }
        }, new Runnable() { // from class: nv1.c
            @Override // java.lang.Runnable
            public final void run() {
                GuildCheckAvatarFragment.this.Uh();
            }
        });
    }

    private void Xh(String str) {
        n.b(str, "3");
    }

    private void Yh(String str) {
        if (!TextUtils.isEmpty(str)) {
            Option requestHeight = Option.obtain().setUrl(str).setFromPreLoad(true).setPredecode(true).setNeedFilterUrl(false).setRequestWidth(this.T.getWidth()).setRequestHeight(this.T.getHeight());
            com.tencent.mobileqq.guild.picload.e.a().f(requestHeight, null);
            String c16 = com.tencent.mobileqq.guild.picload.e.a().c(requestHeight);
            this.W = c16;
            QLog.d("Guild.profile.GuildCheckAvatarFragment", 1, "resetFilePath mFilePath:", c16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zh(String str) {
        ((IGuildPhotoUtilsApi) QRoute.api(IGuildPhotoUtilsApi.class)).savePic(str, getQBaseActivity());
    }

    private void ai() {
        if (this.X == null) {
            this.X = QQPermissionFactory.getQQPermission(this);
        }
        QQPermission qQPermission = this.X;
        if (qQPermission == null) {
            QQToastUtil.showQQToast(1, R.string.f155091gk);
        } else if (qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) != 0) {
            this.X.requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new b());
        } else {
            Zh(this.W);
        }
    }

    private void bi() {
        new GuildDTReportApiImpl().setElementExposureAndClickParams(this.C, "pg_sgrp_mine_avatar_back", null);
    }

    private void ci() {
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(this.P, "pg_sgrp_mine_avatar");
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        w.a(hashMap);
        VideoReport.setPageParams(this.P, new PageParams(hashMap));
    }

    private void di() {
        final ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(getContext(), null);
        actionSheet.addButton(R.string.f155801ih, 1);
        actionSheet.addButton(R.string.f145840sk, 1);
        actionSheet.addCancelButton(R.string.f140850f3);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: nv1.a
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                GuildCheckAvatarFragment.this.Qh(actionSheet, view, i3);
            }
        });
        actionSheet.show();
    }

    private void ei(String str) {
        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
            this.T.setImageDrawable(URLDrawable.getDrawable(new File(str), Lh()));
        } else {
            String f16 = ch.f();
            if (!TextUtils.isEmpty(f16)) {
                this.T.setAvatarTinyId("0", f16);
            }
        }
    }

    private void initListener() {
        GuildUserAvatarRepository.f(this);
    }

    private void initView() {
        setTitle(getResources().getString(R.string.f143370lw));
        this.G.setImageDrawable(getResources().getDrawable(R.drawable.guild_me_more));
        this.G.setVisibility(0);
        this.G.setOnClickListener(this);
        this.T = (GuildUserAvatarView) this.P.findViewById(R.id.wk5);
        Button button = (Button) this.P.findViewById(R.id.f165446w15);
        this.U = button;
        button.setOnClickListener(this);
        if (this.f231139a0 == 1) {
            this.U.setVisibility(8);
        }
        Bundle arguments = getArguments();
        if (arguments == null) {
            QLog.w("Guild.profile.GuildCheckAvatarFragment", 1, "arguments is null");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Guild.profile.GuildCheckAvatarFragment", 2, "initView arguments:", arguments);
        }
        Nh();
        Oh();
    }

    private static void showToast(String str, int i3) {
        QQToast.makeText(BaseApplication.getContext(), i3, str, 1).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
    }

    public void Rh(IUploadApi.c cVar, IUploadApi.d dVar) {
        int i3;
        QLog.i("Guild.profile.GuildCheckAvatarFragment", 1, "onUploadFail task: " + cVar + " state:" + dVar);
        GuildCgiUploader.b b16 = GuildCgiUploader.b.b(dVar);
        String str = b16.f215491b;
        if (b16.f215490a == 0) {
            i3 = 2;
        } else {
            i3 = 0;
        }
        showToast(str, i3);
        n.a("3", this.Z, b16);
    }

    public void Th(IUploadApi.c cVar, IUploadApi.d dVar) {
        int i3;
        QLog.i("Guild.profile.GuildCheckAvatarFragment", 1, "onUploadSuccess task: " + cVar + " state:" + dVar);
        FragmentActivity activity = getActivity();
        GuildCgiUploader.b c16 = GuildCgiUploader.b.c(dVar.f230934d);
        if (c16.e()) {
            SecurityTipHelperKt.L(c16.f215492c, activity, dVar.f230932b, "", false, null);
        } else {
            if (c16.f215490a == 0) {
                ei(this.Z);
            }
            String str = c16.f215491b;
            if (c16.f215490a == 0) {
                i3 = 2;
            } else {
                i3 = 0;
            }
            showToast(str, i3);
        }
        ((IGPSService) ch.R0(IGPSService.class)).refreshGuildUserProfileInfo("0", ch.f());
        n.a("3", this.Z, c16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        this.f231139a0 = getActivity().getIntent().getIntExtra("from", 0);
        this.f231140b0 = getActivity().getIntent().getStringExtra("tinyId");
        this.f231141c0 = getActivity().getIntent().getStringExtra("guildId");
        QLog.d("Guild.profile.GuildCheckAvatarFragment", 1, "from:" + this.f231139a0 + "tinyId:" + this.f231140b0 + "guildId:" + this.f231141c0);
        rh();
        initView();
        initListener();
        ci();
        bi();
    }

    @Override // com.tencent.mobileqq.guild.avatar.e
    public void doOnUrlChange(@NonNull String str, @NonNull String str2) {
        if (TextUtils.equals(str, "0") && TextUtils.equals(str2, ch.f())) {
            String fullGuildUserUserAvatarUrl = ((IGPSService) ch.R0(IGPSService.class)).getFullGuildUserUserAvatarUrl(str, ch.f(), 2);
            Yh(fullGuildUserUserAvatarUrl);
            QLog.d("Guild.profile.GuildCheckAvatarFragment", 1, "doOnUrlChange guildId:", str, " tinyId:", str2, " avatarUrl:", fullGuildUserUserAvatarUrl);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f168050ej2;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, @Nullable Intent intent) {
        Uri uri;
        super.onActivityResult(i3, i16, intent);
        FragmentActivity activity = getActivity();
        if (activity != null && i16 == -1 && i3 == 257 && (uri = this.Y) != null) {
            this.Y = null;
            ((IPhotoPickAndEditApi) QRoute.api(IPhotoPickAndEditApi.class)).startPhotoEdit(activity, BaseImageUtil.getRealPathFromContentURI(activity, uri), 103);
        }
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        VideoReport.reportEvent("dt_clck", this.C, new HashMap());
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f165446w15) {
            Wh();
        } else if (id5 == R.id.ivTitleBtnRightImage) {
            di();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        GuildUserAvatarRepository.k(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Mh(intent);
    }
}
