package com.tencent.guild.aio.chosen.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.common.config.AppSetting;
import com.tencent.guild.aio.article.launcher.GuildBaseFragment;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.data.v;
import com.tencent.mobileqq.guild.util.at;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import in0.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import us.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 $2\u00020\u0001:\u0001%B\u0007\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u001a\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0016J&\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0016\u0010!\u001a\u0004\u0018\u00010\u001e8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 \u00a8\u0006&"}, d2 = {"Lcom/tencent/guild/aio/chosen/fragment/GuildChosenWrapperFragment;", "Lcom/tencent/guild/aio/article/launcher/GuildBaseFragment;", "", "qh", "setStatusBar", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", "bundle", "rh", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "", "onBackEvent", "Lus/a;", BdhLogUtil.LogTag.Tag_Conn, "Lus/a;", "chatFragmentProvider", "", "D", "Ljava/lang/String;", "mGuildId", "E", "mChannelId", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "ph", "()Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "gpsService", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildChosenWrapperFragment extends GuildBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private a chatFragmentProvider;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private String mGuildId;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private String mChannelId;

    private final IGPSService ph() {
        return at.d();
    }

    private final void qh() {
        Intent intent;
        int i3;
        a aVar;
        String clsName = sn0.a.class.getName();
        Bundle arguments = getArguments();
        if (arguments != null) {
            arguments.putBoolean("is_pad", AppSetting.t(requireContext()));
        }
        a.Companion companion = in0.a.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(clsName, "clsName");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            intent = activity.getIntent();
        } else {
            intent = null;
        }
        Bundle arguments2 = getArguments();
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        us.a a16 = companion.a(clsName, intent, arguments2, childFragmentManager, R.id.w2q);
        Intrinsics.checkNotNull(a16);
        this.chatFragmentProvider = a16;
        Resources resources = BaseApplication.context.getResources();
        if (UIUtil.f112434a.A()) {
            i3 = R.drawable.skin_chat_background;
        } else {
            i3 = R.drawable.qui_common_bg_chat_bg;
        }
        Drawable drawable = ResourcesCompat.getDrawable(resources, i3, null);
        if (drawable != null && (aVar = this.chatFragmentProvider) != null) {
            aVar.k(drawable);
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            rh(activity2, getArguments());
        }
    }

    private final void rh(Activity activity, Bundle bundle) {
        String str;
        String str2;
        IGProChannelInfo iGProChannelInfo = null;
        if (bundle != null) {
            str = bundle.getString("guild_chosen_guild_id");
        } else {
            str = null;
        }
        this.mGuildId = str;
        if (bundle != null) {
            str2 = bundle.getString("guild_chosen_channel_id");
        } else {
            str2 = null;
        }
        this.mChannelId = str2;
        IGPSService ph5 = ph();
        if (ph5 != null) {
            iGProChannelInfo = ph5.getChannelInfo(this.mChannelId);
        }
        if (iGProChannelInfo == null) {
            return;
        }
        VideoReport.addToDetectionWhitelist(activity);
        VideoReport.setPageId(activity, "pg_sgrp_sticky_post_info");
        VideoReport.setPageParams(activity, "sgrp_channel_id", this.mGuildId);
        VideoReport.setPageParams(activity, "sgrp_sub_channel_id", this.mChannelId);
        VideoReport.setPageParams(activity, "sgrp_user_type", Integer.valueOf(v.c(this.mGuildId)));
        VideoReport.setPageParams(activity, "sgrp_subchannel_type", Integer.valueOf(iGProChannelInfo.getType()));
        VideoReport.setPageParams(activity, "sgrp_sticky_post_count", Integer.valueOf(iGProChannelInfo.getTopMsgList().size()));
        VideoReport.setPageParams(activity, "sgrp_sub_channel_name", iGProChannelInfo.getChannelName());
    }

    private final void setStatusBar() {
        FragmentActivity activity = requireActivity();
        UIUtil uIUtil = UIUtil.f112434a;
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        uIUtil.B(activity, activity.getResources().getColor(R.color.ajr));
        ImmersiveUtils.setStatusTextColor(!QQTheme.isNowThemeIsNight(), activity.getWindow());
        if (Build.VERSION.SDK_INT >= 26) {
            View decorView = activity.getWindow().getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 16);
        }
    }

    @Override // com.tencent.guild.aio.article.launcher.GuildBaseFragment
    public boolean onBackEvent() {
        us.a aVar = this.chatFragmentProvider;
        if (aVar != null) {
            return aVar.onBackPressed();
        }
        return super.onBackEvent();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        if (ph() == null) {
            QLog.e("GuildChosenWrapperFragment", 1, "[onCreate] fail, session is null");
            ((IQQOpenTelemetryReportApi) QRoute.api(IQQOpenTelemetryReportApi.class)).reportEvent("gpro_quality#event#chosen_service_init_error");
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
        super.onCreate(savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = LayoutInflater.from(BaseApplication.context).inflate(R.layout.ej9, container, false);
        setStatusBar();
        qh();
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }
}
