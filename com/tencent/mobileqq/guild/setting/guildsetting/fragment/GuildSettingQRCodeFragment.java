package com.tencent.mobileqq.guild.setting.guildsetting.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.component.qrcode.QUIColorfulQRCodeView;
import com.tencent.mobileqq.guild.base.QQGuildTokenTitleBarFragment;
import com.tencent.mobileqq.guild.data.ark.AttaIdReportData;
import com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.GuildSettingQrCodeViewModel;
import com.tencent.mobileqq.guild.share.util.GuildActionSheetAttaUtil;
import com.tencent.mobileqq.guild.util.GuildMedalUtils;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedalInfo;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.annotation.QQPermissionConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.sharepanel.api.ISharePanelApi;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@QQPermissionConfig(id = QQPermissionConstants.Business.ID.QQ_CHANNEL_MAINFRAME, scene = QQPermissionConstants.Business.SCENE.QQCHANEL_QRCODE_SAVE_ALBUM)
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 T2\u00020\u0001:\u0002UVB\u0007\u00a2\u0006\u0004\bR\u0010SJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\bJ\"\u0010\u0011\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0012\u001a\u00020\bH\u0016J\b\u0010\u0013\u001a\u00020\bH\u0002J\b\u0010\u0014\u001a\u00020\bH\u0002J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u001e\u0010\u001d\u001a\u00020\b2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J.\u0010\"\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001b2\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020 \u0018\u00010\u001fH\u0002J\b\u0010#\u001a\u00020\bH\u0002J\u0010\u0010%\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u001bH\u0002R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u0010(R\u0016\u00103\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u0010(R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00106R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010@\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010K\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010O\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010Q\u00a8\u0006W"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildsetting/fragment/GuildSettingQRCodeFragment;", "Lcom/tencent/mobileqq/guild/base/QQGuildTokenTitleBarFragment;", "", "getContentLayoutId", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "initView", "initClickListener", "initViewModel", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "rh", "bi", "Xh", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "ci", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProMedalInfo;", "medalInfoList", "", "name", "li", "elementId", "", "", "params", "ki", "Wh", "attaContentId", "Vh", "Landroid/widget/TextView;", "T", "Landroid/widget/TextView;", "guildQrcodeDownload", "U", "guildQrcodeShare", "Landroid/widget/ImageView;", "V", "Landroid/widget/ImageView;", "guildIcon", "W", "guildName", "X", "guildStrNumber", "Landroid/widget/LinearLayout;", "Y", "Landroid/widget/LinearLayout;", "guildNumberContainer", "Z", "guildQrCodeContainer", "Lcom/tencent/mobileqq/component/qrcode/QUIColorfulQRCodeView;", "a0", "Lcom/tencent/mobileqq/component/qrcode/QUIColorfulQRCodeView;", "guildQrCode", "b0", "Landroid/view/View;", "shareLayout", "Lcom/tencent/mobileqq/guild/setting/guildsetting/viewmodel/GuildSettingQrCodeViewModel;", "c0", "Lcom/tencent/mobileqq/guild/setting/guildsetting/viewmodel/GuildSettingQrCodeViewModel;", "viewModel", "Lyz1/p;", "d0", "Lyz1/p;", "shareHelper", "e0", "Ljava/lang/String;", "showNumber", "Lcom/tencent/mobileqq/qqpermission/QQPermission;", "f0", "Lcom/tencent/mobileqq/qqpermission/QQPermission;", "qqPermission", "g0", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "<init>", "()V", "h0", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildSettingQRCodeFragment extends QQGuildTokenTitleBarFragment {

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: T, reason: from kotlin metadata */
    private TextView guildQrcodeDownload;

    /* renamed from: U, reason: from kotlin metadata */
    private TextView guildQrcodeShare;

    /* renamed from: V, reason: from kotlin metadata */
    private ImageView guildIcon;

    /* renamed from: W, reason: from kotlin metadata */
    private TextView guildName;

    /* renamed from: X, reason: from kotlin metadata */
    private TextView guildStrNumber;

    /* renamed from: Y, reason: from kotlin metadata */
    private LinearLayout guildNumberContainer;

    /* renamed from: Z, reason: from kotlin metadata */
    private LinearLayout guildQrCodeContainer;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private QUIColorfulQRCodeView guildQrCode;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private View shareLayout;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private GuildSettingQrCodeViewModel viewModel;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private yz1.p shareHelper;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String showNumber = "";

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QQPermission qqPermission;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IGProGuildInfo guildInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0007R\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildsetting/fragment/GuildSettingQRCodeFragment$a;", "", "Landroid/content/Context;", "context", "", "guildId", "", "a", "Landroid/os/Bundle;", "extra", "b", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.setting.guildsetting.fragment.GuildSettingQRCodeFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull Context context, @NotNull String guildId) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            b(context, guildId, new Bundle());
        }

        @JvmStatic
        public final void b(@NotNull Context context, @NotNull String guildId, @NotNull Bundle extra) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(extra, "extra");
            Intent intent = new Intent();
            intent.putExtra("extra_guild_id", guildId);
            intent.putExtras(extra);
            QPublicFragmentActivity.start(context, intent, GuildSettingQRCodeFragment.class);
        }

        Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildsetting/fragment/GuildSettingQRCodeFragment$b;", "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "", "event", "", "", "getDynamicParams", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/guild/setting/guildsetting/fragment/GuildSettingQRCodeFragment;", "a", "Lmqq/util/WeakReference;", "mFragmentRef", "fragment", "<init>", "(Lcom/tencent/mobileqq/guild/setting/guildsetting/fragment/GuildSettingQRCodeFragment;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<GuildSettingQRCodeFragment> mFragmentRef;

        public b(@NotNull GuildSettingQRCodeFragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            this.mFragmentRef = new WeakReference<>(fragment);
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        @NotNull
        public Map<String, Object> getDynamicParams(@NotNull String event) {
            Intrinsics.checkNotNullParameter(event, "event");
            HashMap hashMap = new HashMap();
            GuildSettingQRCodeFragment guildSettingQRCodeFragment = this.mFragmentRef.get();
            if (guildSettingQRCodeFragment != null && guildSettingQRCodeFragment.guildInfo != null) {
                IGProGuildInfo iGProGuildInfo = guildSettingQRCodeFragment.guildInfo;
                Intrinsics.checkNotNull(iGProGuildInfo);
                String guildID = iGProGuildInfo.getGuildID();
                Intrinsics.checkNotNullExpressionValue(guildID, "guildInfo!!.guildID");
                hashMap.put("sgrp_channel_id", guildID);
                hashMap.put("sgrp_user_type", Integer.valueOf(com.tencent.mobileqq.guild.data.v.d(iGProGuildInfo.isMember(), iGProGuildInfo.getUserType())));
                hashMap.put("sgrp_code_validity", Integer.valueOf(iGProGuildInfo.getQRCodePeriod()));
            }
            return hashMap;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/setting/guildsetting/fragment/GuildSettingQRCodeFragment$c", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c extends QQPermission.BasePermissionsListener {
        c() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            GuildSettingQrCodeViewModel guildSettingQrCodeViewModel = GuildSettingQRCodeFragment.this.viewModel;
            yz1.p pVar = null;
            if (guildSettingQrCodeViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                guildSettingQrCodeViewModel = null;
            }
            FragmentActivity requireActivity = GuildSettingQRCodeFragment.this.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            yz1.p pVar2 = GuildSettingQRCodeFragment.this.shareHelper;
            if (pVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shareHelper");
                pVar2 = null;
            }
            Bitmap r16 = pVar2.r();
            yz1.p pVar3 = GuildSettingQRCodeFragment.this.shareHelper;
            if (pVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shareHelper");
            } else {
                pVar = pVar3;
            }
            guildSettingQrCodeViewModel.d2(requireActivity, r16, pVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Vh(String attaContentId) {
        Intent intent;
        AttaIdReportData attaIdReportData;
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null && (attaIdReportData = (AttaIdReportData) intent.getParcelableExtra("extra_key_atta_report_id")) != null) {
            attaIdReportData.g(attaContentId);
            GuildActionSheetAttaUtil.g(attaIdReportData);
        }
    }

    private final void Wh() {
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(this.P, "pg_sgrp_qr_set");
        VideoReport.setEventDynamicParams(this.P, new b(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Xh() {
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_qr_code_type", "pic4");
        TextView textView = this.guildQrcodeDownload;
        yz1.p pVar = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildQrcodeDownload");
            textView = null;
        }
        ki(textView, "em_sgrp_qr_save", hashMap);
        if (this.qqPermission == null) {
            this.qqPermission = QQPermissionFactory.getQQPermission(this);
        }
        QQPermission qQPermission = this.qqPermission;
        boolean z16 = false;
        if (qQPermission != null && qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0) {
            z16 = true;
        }
        if (!z16) {
            String[] strArr = {QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE};
            QQPermission qQPermission2 = this.qqPermission;
            if (qQPermission2 != null) {
                qQPermission2.requestPermissions(strArr, 2, new c());
                return;
            }
            return;
        }
        GuildSettingQrCodeViewModel guildSettingQrCodeViewModel = this.viewModel;
        if (guildSettingQrCodeViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildSettingQrCodeViewModel = null;
        }
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        yz1.p pVar2 = this.shareHelper;
        if (pVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareHelper");
            pVar2 = null;
        }
        Bitmap r16 = pVar2.r();
        yz1.p pVar3 = this.shareHelper;
        if (pVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareHelper");
        } else {
            pVar = pVar3;
        }
        guildSettingQrCodeViewModel.d2(requireActivity, r16, pVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Yh(GuildSettingQRCodeFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.mobileqq.guild.util.o.a(view)) {
            this$0.Xh();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Zh(GuildSettingQRCodeFragment this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.mobileqq.guild.util.o.a(it)) {
            if (((ISharePanelApi) QRoute.api(ISharePanelApi.class)).useNewSharePanel("pindao_qrcode")) {
                yz1.p pVar = this$0.shareHelper;
                if (pVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("shareHelper");
                    pVar = null;
                }
                FragmentActivity requireActivity = this$0.requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                pVar.D(requireActivity);
            } else {
                yz1.p pVar2 = this$0.shareHelper;
                if (pVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("shareHelper");
                    pVar2 = null;
                }
                FragmentActivity requireActivity2 = this$0.requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity()");
                pVar2.A(requireActivity2);
            }
            Intrinsics.checkNotNullExpressionValue(it, "it");
            this$0.ki(it, "em_sgrp_qr_share", null);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ai(GuildSettingQRCodeFragment this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.mobileqq.guild.util.o.a(it)) {
            com.tencent.mobileqq.guild.util.b.a(this$0.showNumber);
            Intrinsics.checkNotNullExpressionValue(it, "it");
            this$0.ki(it, "em_sgrp_set_copy_group_num", null);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void bi() {
        int d16 = bi.d();
        int b16 = bi.b(360);
        if (d16 < b16) {
            float f16 = b16;
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams((int) (f16 * (d16 / f16)), -2);
            layoutParams.startToStart = 0;
            layoutParams.endToEnd = 0;
            LinearLayout linearLayout = this.guildQrCodeContainer;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildQrCodeContainer");
                linearLayout = null;
            }
            linearLayout.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ci(IGProGuildInfo guildInfo) {
        String guildNumber = guildInfo.getGuildNumber();
        Intrinsics.checkNotNullExpressionValue(guildNumber, "guildInfo.guildNumber");
        this.showNumber = guildNumber;
        TextView textView = this.guildStrNumber;
        ImageView imageView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildStrNumber");
            textView = null;
        }
        textView.setText("\u9891\u9053\u53f7: " + guildInfo.getGuildNumber());
        TextView textView2 = this.guildName;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildName");
            textView2 = null;
        }
        textView2.setText(guildInfo.getGuildName());
        ArrayList<IGProMedalInfo> medalInfoList = guildInfo.getMedalInfoList();
        Intrinsics.checkNotNullExpressionValue(medalInfoList, "guildInfo.medalInfoList");
        String guildName = guildInfo.getGuildName();
        Intrinsics.checkNotNullExpressionValue(guildName, "guildInfo.guildName");
        li(medalInfoList, guildName);
        String avatarUrl = guildInfo.getAvatarUrl(140);
        Intrinsics.checkNotNullExpressionValue(avatarUrl, "guildInfo.getAvatarUrl(I\u2026ldAvatarUrlType.SIZE_140)");
        if (TextUtils.isEmpty(avatarUrl)) {
            ImageView imageView2 = this.guildIcon;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildIcon");
            } else {
                imageView = imageView2;
            }
            imageView.setVisibility(8);
            return;
        }
        ImageView imageView3 = this.guildIcon;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildIcon");
            imageView3 = null;
        }
        imageView3.setVisibility(0);
        ImageView imageView4 = this.guildIcon;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildIcon");
            imageView4 = null;
        }
        Drawable J = ch.J(avatarUrl, Utils.n(68.0f, imageView4.getContext().getResources()), BaseImageUtil.getDefaultFaceDrawable(false), false);
        ImageView imageView5 = this.guildIcon;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildIcon");
        } else {
            imageView = imageView5;
        }
        imageView.setImageDrawable(J);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void di() {
        QLog.i("GuildSettingQRCodeFragment", 1, "OnFirstTimeDrawn");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ei(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void gi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ii(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @JvmStatic
    public static final void ji(@NotNull Context context, @NotNull String str) {
        INSTANCE.a(context, str);
    }

    private final void ki(View view, String elementId, Map<String, ? extends Object> params) {
        VideoReport.setElementId(view, elementId);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("clck", view, params);
    }

    private final void li(List<? extends IGProMedalInfo> medalInfoList, final String name) {
        final List<IGProMedalInfo> e16 = yz1.q.f451648a.e(new ArrayList(medalInfoList));
        if (e16.isEmpty()) {
            return;
        }
        TextView textView = this.guildName;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildName");
            textView = null;
        }
        textView.setText(name);
        TextView textView3 = this.guildName;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildName");
        } else {
            textView2 = textView3;
        }
        textView2.post(new Runnable() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.fragment.u
            @Override // java.lang.Runnable
            public final void run() {
                GuildSettingQRCodeFragment.mi(name, e16, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mi(String name, List validMediaList, GuildSettingQRCodeFragment this$0) {
        Intrinsics.checkNotNullParameter(name, "$name");
        Intrinsics.checkNotNullParameter(validMediaList, "$validMediaList");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GuildMedalUtils guildMedalUtils = GuildMedalUtils.f235347a;
        TextView textView = this$0.guildName;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildName");
            textView = null;
        }
        GuildMedalUtils.w(guildMedalUtils, name, validMediaList, textView, null, 0, null, 56, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f8j;
    }

    public final void initClickListener() {
        TextView textView = this.guildQrcodeDownload;
        LinearLayout linearLayout = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildQrcodeDownload");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.fragment.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildSettingQRCodeFragment.Yh(GuildSettingQRCodeFragment.this, view);
            }
        });
        TextView textView2 = this.guildQrcodeShare;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildQrcodeShare");
            textView2 = null;
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.fragment.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildSettingQRCodeFragment.Zh(GuildSettingQRCodeFragment.this, view);
            }
        });
        LinearLayout linearLayout2 = this.guildNumberContainer;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildNumberContainer");
        } else {
            linearLayout = linearLayout2;
        }
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.fragment.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildSettingQRCodeFragment.ai(GuildSettingQRCodeFragment.this, view);
            }
        });
    }

    public final void initView() {
        String str;
        Intent intent;
        rh();
        FragmentActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null || (str = intent.getStringExtra("extra_guild_id")) == null) {
            str = "";
        }
        View findViewById = this.P.findViewById(R.id.x1i);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewByI\u2026ild_str_number_container)");
        this.guildNumberContainer = (LinearLayout) findViewById;
        View findViewById2 = this.P.findViewById(R.id.x1h);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mContentView.findViewById(R.id.guild_str_number)");
        this.guildStrNumber = (TextView) findViewById2;
        View findViewById3 = this.P.findViewById(R.id.wrw);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mContentView.findViewById(R.id.guild_name)");
        this.guildName = (TextView) findViewById3;
        View findViewById4 = this.P.findViewById(R.id.wij);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mContentView.findViewById(R.id.guild_icon_head)");
        this.guildIcon = (ImageView) findViewById4;
        View findViewById5 = this.P.findViewById(R.id.wus);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "mContentView.findViewByI\u2026id.guild_qrcode_download)");
        this.guildQrcodeDownload = (TextView) findViewById5;
        View findViewById6 = this.P.findViewById(R.id.wuu);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "mContentView.findViewById(R.id.guild_qrcode_share)");
        this.guildQrcodeShare = (TextView) findViewById6;
        View findViewById7 = this.P.findViewById(R.id.wum);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "mContentView.findViewById(R.id.guild_qr_code)");
        this.guildQrCode = (QUIColorfulQRCodeView) findViewById7;
        View findViewById8 = this.P.findViewById(R.id.wun);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "mContentView.findViewByI\u2026.guild_qr_code_container)");
        this.guildQrCodeContainer = (LinearLayout) findViewById8;
        View findViewById9 = this.P.findViewById(R.id.x0b);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "mContentView.findViewById(R.id.guild_share_layout)");
        this.shareLayout = findViewById9;
        GuildSettingQrCodeViewModel.Companion companion = GuildSettingQrCodeViewModel.INSTANCE;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        this.viewModel = companion.a(requireActivity, str);
        QUIColorfulQRCodeView qUIColorfulQRCodeView = this.guildQrCode;
        View view = null;
        if (qUIColorfulQRCodeView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildQrCode");
            qUIColorfulQRCodeView = null;
        }
        QUIColorfulQRCodeView.o(qUIColorfulQRCodeView, -16776961, null, 2, null);
        QUIColorfulQRCodeView qUIColorfulQRCodeView2 = this.guildQrCode;
        if (qUIColorfulQRCodeView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildQrCode");
            qUIColorfulQRCodeView2 = null;
        }
        qUIColorfulQRCodeView2.g(new com.tencent.mobileqq.component.qrcode.i(R.drawable.guild_qrcode_logo, null, null, 0));
        QUIColorfulQRCodeView qUIColorfulQRCodeView3 = this.guildQrCode;
        if (qUIColorfulQRCodeView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildQrCode");
            qUIColorfulQRCodeView3 = null;
        }
        qUIColorfulQRCodeView3.setOnFirstTimeDrawnListener(new com.tencent.mobileqq.component.qrcode.h() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.fragment.q
            @Override // com.tencent.mobileqq.component.qrcode.h
            public final void a() {
                GuildSettingQRCodeFragment.di();
            }
        });
        yz1.p pVar = new yz1.p();
        View view2 = this.shareLayout;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareLayout");
            view2 = null;
        }
        pVar.s(view2);
        this.shareHelper = pVar;
        bi();
        if (QQTheme.isVasTheme()) {
            LinearLayout linearLayout = this.guildQrCodeContainer;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildQrCodeContainer");
                linearLayout = null;
            }
            linearLayout.setBackgroundResource(R.drawable.qui_common_fill_standard_primary_bg_corner_16);
            View view3 = this.shareLayout;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shareLayout");
            } else {
                view = view3;
            }
            view.setBackgroundResource(R.drawable.qui_common_bg_bottom_standard_bg);
            return;
        }
        LinearLayout linearLayout2 = this.guildQrCodeContainer;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildQrCodeContainer");
            linearLayout2 = null;
        }
        linearLayout2.setBackgroundResource(R.drawable.qui_common_fill_light_secondary_bg_corner_16);
        View view4 = this.shareLayout;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareLayout");
        } else {
            view = view4;
        }
        view.setBackgroundResource(R.drawable.qui_common_fill_light_secondary_bg);
    }

    public final void initViewModel() {
        GuildSettingQrCodeViewModel guildSettingQrCodeViewModel = this.viewModel;
        GuildSettingQrCodeViewModel guildSettingQrCodeViewModel2 = null;
        if (guildSettingQrCodeViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildSettingQrCodeViewModel = null;
        }
        LiveData<IGProGuildInfo> Z1 = guildSettingQrCodeViewModel.Z1();
        FragmentActivity requireActivity = requireActivity();
        final Function1<IGProGuildInfo, Unit> function1 = new Function1<IGProGuildInfo, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.fragment.GuildSettingQRCodeFragment$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IGProGuildInfo iGProGuildInfo) {
                invoke2(iGProGuildInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable IGProGuildInfo iGProGuildInfo) {
                if (iGProGuildInfo != null) {
                    GuildSettingQRCodeFragment.this.guildInfo = iGProGuildInfo;
                    GuildSettingQRCodeFragment.this.ci(iGProGuildInfo);
                    yz1.p pVar = GuildSettingQRCodeFragment.this.shareHelper;
                    GuildSettingQrCodeViewModel guildSettingQrCodeViewModel3 = null;
                    if (pVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("shareHelper");
                        pVar = null;
                    }
                    GuildSettingQrCodeViewModel guildSettingQrCodeViewModel4 = GuildSettingQRCodeFragment.this.viewModel;
                    if (guildSettingQrCodeViewModel4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    } else {
                        guildSettingQrCodeViewModel3 = guildSettingQrCodeViewModel4;
                    }
                    pVar.v(iGProGuildInfo, guildSettingQrCodeViewModel3);
                }
            }
        };
        Z1.observe(requireActivity, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.fragment.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildSettingQRCodeFragment.ei(Function1.this, obj);
            }
        });
        GuildSettingQrCodeViewModel guildSettingQrCodeViewModel3 = this.viewModel;
        if (guildSettingQrCodeViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildSettingQrCodeViewModel3 = null;
        }
        LiveData<String> a26 = guildSettingQrCodeViewModel3.a2();
        FragmentActivity requireActivity2 = requireActivity();
        final GuildSettingQRCodeFragment$initViewModel$2 guildSettingQRCodeFragment$initViewModel$2 = new GuildSettingQRCodeFragment$initViewModel$2(this);
        a26.observe(requireActivity2, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.fragment.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildSettingQRCodeFragment.fi(Function1.this, obj);
            }
        });
        GuildSettingQrCodeViewModel guildSettingQrCodeViewModel4 = this.viewModel;
        if (guildSettingQrCodeViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildSettingQrCodeViewModel4 = null;
        }
        LiveData<Boolean> W1 = guildSettingQrCodeViewModel4.W1();
        FragmentActivity requireActivity3 = requireActivity();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.fragment.GuildSettingQRCodeFragment$initViewModel$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean isDownload) {
                Intrinsics.checkNotNullExpressionValue(isDownload, "isDownload");
                if (isDownload.booleanValue()) {
                    GuildSettingQRCodeFragment.this.Xh();
                }
            }
        };
        W1.observe(requireActivity3, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.fragment.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildSettingQRCodeFragment.gi(Function1.this, obj);
            }
        });
        GuildSettingQrCodeViewModel guildSettingQrCodeViewModel5 = this.viewModel;
        if (guildSettingQrCodeViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildSettingQrCodeViewModel5 = null;
        }
        LiveData<String> b26 = guildSettingQrCodeViewModel5.b2();
        FragmentActivity requireActivity4 = requireActivity();
        final Function1<String, Unit> function13 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.fragment.GuildSettingQRCodeFragment$initViewModel$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String shareInfo) {
                yz1.p pVar = GuildSettingQRCodeFragment.this.shareHelper;
                if (pVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("shareHelper");
                    pVar = null;
                }
                Intrinsics.checkNotNullExpressionValue(shareInfo, "shareInfo");
                pVar.y(shareInfo);
            }
        };
        b26.observe(requireActivity4, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.fragment.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildSettingQRCodeFragment.hi(Function1.this, obj);
            }
        });
        GuildSettingQrCodeViewModel guildSettingQrCodeViewModel6 = this.viewModel;
        if (guildSettingQrCodeViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            guildSettingQrCodeViewModel2 = guildSettingQrCodeViewModel6;
        }
        LiveData<String> U1 = guildSettingQrCodeViewModel2.U1();
        FragmentActivity requireActivity5 = requireActivity();
        final Function1<String, Unit> function14 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.fragment.GuildSettingQRCodeFragment$initViewModel$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String attaContentId) {
                GuildSettingQRCodeFragment guildSettingQRCodeFragment = GuildSettingQRCodeFragment.this;
                Intrinsics.checkNotNullExpressionValue(attaContentId, "attaContentId");
                guildSettingQRCodeFragment.Vh(attaContentId);
            }
        };
        U1.observe(requireActivity5, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.fragment.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildSettingQRCodeFragment.ii(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101 && resultCode == -1) {
            QQToast.makeText(requireActivity(), 2, "\u5df2\u5206\u4eab", 0).show();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
        initClickListener();
        initViewModel();
        Wh();
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void rh() {
        this.J.a();
        this.J.setBackgroundResource(R.drawable.lvj);
    }
}
