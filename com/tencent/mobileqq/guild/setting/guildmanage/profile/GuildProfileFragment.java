package com.tencent.mobileqq.guild.setting.guildmanage.profile;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.IGuildWebApi;
import com.tencent.mobileqq.guild.base.QQGuildTokenTitleBarFragment;
import com.tencent.mobileqq.guild.main.viewmodel.base.BaseChannelViewModel;
import com.tencent.mobileqq.guild.rolegroup.viewmodel.GuildSecondaryAuthorityViewModel;
import com.tencent.mobileqq.guild.setting.group.GuildBindGroupSettingFragment;
import com.tencent.mobileqq.guild.setting.guildmanage.QQGuildCoverSettingFragment;
import com.tencent.mobileqq.guild.setting.guildmanage.QQGuildDescriptionEditFragment;
import com.tencent.mobileqq.guild.setting.guildmanage.avatar.QQGuildAvatarSettingFragment;
import com.tencent.mobileqq.guild.setting.guildmanage.name.QQGuildNameSettingFragment;
import com.tencent.mobileqq.guild.setting.guildmanage.profile.GuildProfileViewModel;
import com.tencent.mobileqq.guild.setting.guildmanage.rule.GuildRuleEditFragment;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.bt;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.widget.GuildDefaultThemeNavBarCommon;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.listitem.DataObserver;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import com.tencent.util.QQToastUtil;
import com.tencent.util.URLUtil;
import cooperation.qzone.QzoneIPCModule;
import ef1.c;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00a8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 c2\u00020\u0001:\u0001dB\u0007\u00a2\u0006\u0004\ba\u0010bJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\u0006\u0010\u0010\u001a\u00020\nJ\"\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0016\u001a\u00020\nH\u0002J\b\u0010\u0017\u001a\u00020\nH\u0002J\b\u0010\u0018\u001a\u00020\nH\u0002J\u001c\u0010\u001d\u001a\u00020\n2\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\nH\u0002J\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010 \u001a\u00020\u001fH\u0002\u00a2\u0006\u0004\b#\u0010$J<\u0010+\u001a\b\u0012\u0004\u0012\u00020)0(2\b\b\u0001\u0010%\u001a\u00020\u00022\b\b\u0001\u0010&\u001a\u00020\u00022\u0018\u0010*\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0(\u0012\u0004\u0012\u00020\n0'H\u0002J>\u0010.\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020-0,2\b\b\u0001\u0010%\u001a\u00020\u00022\u001e\u0010*\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020-0,\u0012\u0004\u0012\u00020\n0'H\u0002J\u0012\u00100\u001a\u00020)2\b\b\u0001\u0010/\u001a\u00020\u0002H\u0002J\u0012\u00102\u001a\u0002012\b\b\u0001\u0010/\u001a\u00020\u0002H\u0003J\u0014\u00103\u001a\u0006\u0012\u0002\b\u00030\u00192\u0006\u0010 \u001a\u00020\u001fH\u0002J\u0014\u00104\u001a\u0006\u0012\u0002\b\u00030\u00192\u0006\u0010 \u001a\u00020\u001fH\u0002J\u0014\u00105\u001a\u0006\u0012\u0002\b\u00030\u00192\u0006\u0010 \u001a\u00020\u001fH\u0002J\u0018\u00107\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u00106\u001a\u00020\u001bH\u0002J\u0018\u0010<\u001a\u00020\n2\u0006\u00109\u001a\u0002082\u0006\u0010;\u001a\u00020:H\u0002J\u0018\u0010=\u001a\u00020\n2\u0006\u00109\u001a\u0002082\u0006\u0010;\u001a\u00020:H\u0002J\b\u0010>\u001a\u00020\nH\u0002J\b\u0010?\u001a\u00020\nH\u0002J\b\u0010@\u001a\u00020\nH\u0002J\b\u0010A\u001a\u00020\nH\u0002J\b\u0010B\u001a\u00020\nH\u0002J\u0010\u0010D\u001a\u00020\n2\u0006\u0010C\u001a\u00020\fH\u0002J\u0018\u0010F\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010E\u001a\u00020:H\u0002R\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010Q\u001a\u00020:8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010T\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010V\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bU\u0010SR\u0016\u0010Z\u001a\u00020W8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010^\u001a\u00020[8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b_\u0010`\u00a8\u0006e"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/profile/GuildProfileFragment;", "Lcom/tencent/mobileqq/guild/base/QQGuildTokenTitleBarFragment;", "", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "doOnCreateView", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", "Ci", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Ai", "initView", "initViewModel", "Lcom/tencent/mobileqq/widget/listitem/a;", DownloadInfo.spKey_Config, "", "show", "Di", "qi", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "di", "(Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;)[Lcom/tencent/mobileqq/widget/listitem/Group;", "leftStringRes", "rightStringRes", "Lkotlin/Function1;", "Ltz1/b;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "initConfig", "Fi", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$c$d;", "Ei", "stringRes", "ti", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "Bi", "bi", "ci", "wi", "isGroupAdmin", "li", "Landroid/widget/ImageView;", "imageView", "", PhotoCategorySummaryInfo.AVATAR_URL, SensorJsPlugin.SENSOR_INTERVAL_UI, "vi", "oi", WidgetCacheLunarData.JI, "ni", "ki", "mi", "v", "pi", "elementId", "zi", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/GuildSecondaryAuthorityViewModel;", "T", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/GuildSecondaryAuthorityViewModel;", "authorityViewModel", "Lcom/tencent/mobileqq/guild/setting/guildmanage/profile/GuildProfileViewModel;", "U", "Lcom/tencent/mobileqq/guild/setting/guildmanage/profile/GuildProfileViewModel;", "viewModel", "V", "Ljava/lang/String;", "guildId", "W", "Landroid/view/View;", "auditTipsContainer", "X", "dividerView", "Landroid/widget/TextView;", "Y", "Landroid/widget/TextView;", "auditTips", "Lcom/tencent/mobileqq/widget/listitem/QUISettingsRecyclerView;", "Z", "Lcom/tencent/mobileqq/widget/listitem/QUISettingsRecyclerView;", "recyclerView", "a0", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "<init>", "()V", "b0", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public class GuildProfileFragment extends QQGuildTokenTitleBarFragment {

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: T, reason: from kotlin metadata */
    private GuildSecondaryAuthorityViewModel authorityViewModel;

    /* renamed from: U, reason: from kotlin metadata */
    private GuildProfileViewModel viewModel;

    /* renamed from: V, reason: from kotlin metadata */
    private String guildId;

    /* renamed from: W, reason: from kotlin metadata */
    private View auditTipsContainer;

    /* renamed from: X, reason: from kotlin metadata */
    private View dividerView;

    /* renamed from: Y, reason: from kotlin metadata */
    private TextView auditTips;

    /* renamed from: Z, reason: from kotlin metadata */
    private QUISettingsRecyclerView recyclerView;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private QUIListItemAdapter adapter;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007R\u0014\u0010\b\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\rR\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\t\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/profile/GuildProfileFragment$a;", "", "Landroid/content/Context;", "context", "", "guildId", "", "a", "AUDIT_TIPS", "Ljava/lang/String;", "GUILD_NUMBER_WEB_URL", "", "PIC_SIZE", "I", "REQUEST_CODE_MODIFY_AVATAR", "REQUEST_CODE_MODIFY_COVER", "REQUEST_CODE_MODIFY_DESCRIPTION", "REQUEST_CODE_MODIFY_NAME", "REQUEST_CODE_MODIFY_RULE", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.setting.guildmanage.profile.GuildProfileFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull Context context, @NotNull String guildId) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intent intent = new Intent();
            intent.putExtra("extra_guild_id", guildId);
            QPublicFragmentActivity.b.b(context, intent, QPublicFragmentActivity.class, GuildProfileFragment.class);
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModelStoreOwner f234107a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildProfileFragment f234108b;

        public b(ViewModelStoreOwner viewModelStoreOwner, GuildProfileFragment guildProfileFragment) {
            this.f234107a = viewModelStoreOwner;
            this.f234108b = guildProfileFragment;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            long m1963markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto();
            String str = this.f234108b.guildId;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildId");
                str = null;
            }
            TimedValue timedValue = new TimedValue(new GuildProfileViewModel(str), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(m1963markNowz9LOYto), null);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildViewModelProvider", 2, "create " + com.tencent.mobileqq.guild.base.extension.m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
            }
            return (T) timedValue.getValue();
        }
    }

    private final void Ai() {
        String stringExtra = requireActivity().getIntent().getStringExtra("extra_guild_id");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.guildId = stringExtra;
    }

    @SuppressLint({"ResourceType"})
    private final x.c.g Bi(@StringRes int stringRes) {
        String str;
        if (stringRes > 0) {
            str = getString(stringRes);
        } else {
            str = "";
        }
        Intrinsics.checkNotNullExpressionValue(str, "if (stringRes > 0) getString(stringRes) else \"\"");
        return new x.c.g(str, true, false);
    }

    private final void Di(com.tencent.mobileqq.widget.listitem.a<?> config, boolean show) {
        QUIListItemAdapter qUIListItemAdapter = null;
        if (config instanceof tz1.b) {
            ((tz1.b) config).V(!show);
            QUIListItemAdapter qUIListItemAdapter2 = this.adapter;
            if (qUIListItemAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                qUIListItemAdapter = qUIListItemAdapter2;
            }
            qUIListItemAdapter.l0(config);
            return;
        }
        config.r(show);
        QUIListItemAdapter qUIListItemAdapter3 = this.adapter;
        if (qUIListItemAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            qUIListItemAdapter = qUIListItemAdapter3;
        }
        qUIListItemAdapter.l0(config);
    }

    private final com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.d> Ei(@StringRes int leftStringRes, Function1<? super com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.d>, Unit> initConfig) {
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.d> xVar = new com.tencent.mobileqq.widget.listitem.x<>(ti(leftStringRes), new x.c.d("", "", true, false));
        initConfig.invoke(xVar);
        return xVar;
    }

    private final tz1.b<x.b.d> Fi(@StringRes int leftStringRes, @StringRes int rightStringRes, Function1<? super tz1.b<x.b.d>, Unit> initConfig) {
        tz1.b<x.b.d> bVar = new tz1.b<>(ti(leftStringRes), Bi(rightStringRes), false);
        initConfig.invoke(bVar);
        return bVar;
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> bi(QUIListItemAdapter adapter) {
        GuildProfileFragment$createChannelNumberConfig$1 guildProfileFragment$createChannelNumberConfig$1 = new GuildProfileFragment$createChannelNumberConfig$1(this, adapter, ti(R.string.f156061j7), Bi(0));
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        DataObserver g16 = guildProfileFragment$createChannelNumberConfig$1.l(viewLifecycleOwner, adapter).g(false);
        GuildProfileViewModel guildProfileViewModel = this.viewModel;
        if (guildProfileViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildProfileViewModel = null;
        }
        return g16.f(guildProfileViewModel.b2(), new Function1<IGProGuildInfo, Boolean>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.profile.GuildProfileFragment$createChannelNumberConfig$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull IGProGuildInfo guildInfo) {
                Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
                return Boolean.valueOf(guildInfo.getUserType() == 2);
            }
        }).d();
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> ci(QUIListItemAdapter adapter) {
        return Ei(R.string.f152491_j, new GuildProfileFragment$createQRCodeConfig$1(this));
    }

    private final Group[] di(QUIListItemAdapter adapter) {
        String string = getString(R.string.f156331jx);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.guild\u2026tting_profile_audit_tips)");
        return new Group[]{new Group(string, Fi(R.string.f156291jt, R.string.f156471ka, new GuildProfileFragment$createSettingsItem$1(this, adapter)).w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.profile.c
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                GuildProfileFragment.ei(GuildProfileFragment.this, view);
            }
        }), Ei(R.string.f155891iq, new GuildProfileFragment$createSettingsItem$3(this, adapter)).w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.profile.d
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                GuildProfileFragment.fi(GuildProfileFragment.this, view);
            }
        }), Ei(R.string.f155971iy, new GuildProfileFragment$createSettingsItem$5(this, adapter)).w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.profile.e
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                GuildProfileFragment.gi(GuildProfileFragment.this, view);
            }
        }), Fi(R.string.f156021j3, 0, new GuildProfileFragment$createSettingsItem$7(this, adapter)).w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.profile.f
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                GuildProfileFragment.hi(GuildProfileFragment.this, view);
            }
        }), Fi(R.string.f156371k1, 0, new GuildProfileFragment$createSettingsItem$9(this, adapter)).w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.profile.g
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                GuildProfileFragment.ii(GuildProfileFragment.this, view);
            }
        })), new Group(bi(adapter), ci(adapter)), new Group(wi(adapter))};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ei(GuildProfileFragment this$0, View v3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(v3, "v");
        VideoReport.setElementReuseIdentifier(this$0.getView(), "em_sgrp_channel_set_name_submit");
        bt.d(v3, "em_sgrp_channel_set_name_submit", null, null, null, null, 60, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fi(GuildProfileFragment this$0, View v3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(v3, "v");
        VideoReport.setElementReuseIdentifier(this$0.getView(), "em_sgrp_channel_set_portrait");
        bt.d(v3, "em_sgrp_channel_set_portrait", null, null, null, null, 60, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void gi(GuildProfileFragment this$0, View v3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(v3, "v");
        VideoReport.setElementReuseIdentifier(this$0.getView(), "em_sgrp_channel_set_cover");
        bt.d(v3, "em_sgrp_channel_set_cover", null, null, null, null, 60, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hi(GuildProfileFragment this$0, View v3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(v3, "v");
        VideoReport.setElementReuseIdentifier(this$0.getView(), "em_sgrp_channel_set_introduction");
        bt.d(v3, "em_sgrp_channel_set_introduction", null, null, null, null, 60, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ii(GuildProfileFragment this$0, View v3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(v3, "v");
        VideoReport.setElementReuseIdentifier(this$0.getView(), "em_sgrp_channel_rule_set");
        bt.d(v3, "em_sgrp_channel_rule_set", null, ClickPolicy.REPORT_NONE, null, EndExposurePolicy.REPORT_NONE, 20, null);
    }

    private final void initView() {
        Object parent = this.P.getParent();
        if (parent instanceof View) {
            ((View) parent).setBackgroundResource(R.drawable.qui_common_bg_bottom_standard_bg);
        }
        setTitle(getString(R.string.f156341jy));
        View findViewById = this.P.findViewById(R.id.i4m);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewById(R.id.recycler_view)");
        this.recyclerView = (QUISettingsRecyclerView) findViewById;
        View findViewById2 = this.P.findViewById(R.id.sxb);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mContentView.findViewByI\u2026.id.audit_tips_container)");
        this.auditTipsContainer = findViewById2;
        View findViewById3 = this.P.findViewById(R.id.sxa);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mContentView.findViewById(R.id.audit_tips)");
        this.auditTips = (TextView) findViewById3;
        View findViewById4 = this.P.findViewById(R.id.bmt);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mContentView.findViewById(R.id.divider)");
        this.dividerView = findViewById4;
    }

    private final void initViewModel() {
        c.Companion companion = ef1.c.INSTANCE;
        ViewModel viewModel = new ViewModelProvider(this, new b(this, this)).get(GuildProfileViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
        this.viewModel = (GuildProfileViewModel) viewModel;
        ViewModel create = BaseChannelViewModel.sViewModelFactory.create(GuildSecondaryAuthorityViewModel.class);
        Intrinsics.checkNotNullExpressionValue(create, "sViewModelFactory.create\u2026ityViewModel::class.java)");
        GuildSecondaryAuthorityViewModel guildSecondaryAuthorityViewModel = (GuildSecondaryAuthorityViewModel) create;
        this.authorityViewModel = guildSecondaryAuthorityViewModel;
        GuildProfileViewModel guildProfileViewModel = null;
        if (guildSecondaryAuthorityViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authorityViewModel");
            guildSecondaryAuthorityViewModel = null;
        }
        String str = this.guildId;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildId");
            str = null;
        }
        guildSecondaryAuthorityViewModel.init(str, "QQGuildProfileFragmentNew");
        GuildProfileViewModel guildProfileViewModel2 = this.viewModel;
        if (guildProfileViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            guildProfileViewModel = guildProfileViewModel2;
        }
        MutableLiveData<String> X1 = guildProfileViewModel.X1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.profile.GuildProfileFragment$initViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                invoke2(str2);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r6v5, types: [android.view.View] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable String str2) {
                View view;
                View view2;
                TextView textView;
                View view3;
                ?? r65;
                TextView textView2 = null;
                if (str2 == null || str2.length() == 0) {
                    view3 = GuildProfileFragment.this.auditTipsContainer;
                    if (view3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("auditTipsContainer");
                        view3 = null;
                    }
                    view3.setVisibility(8);
                    r65 = GuildProfileFragment.this.dividerView;
                    if (r65 == 0) {
                        Intrinsics.throwUninitializedPropertyAccessException("dividerView");
                    } else {
                        textView2 = r65;
                    }
                    textView2.setVisibility(8);
                    return;
                }
                view = GuildProfileFragment.this.auditTipsContainer;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("auditTipsContainer");
                    view = null;
                }
                view.setVisibility(0);
                view2 = GuildProfileFragment.this.dividerView;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dividerView");
                    view2 = null;
                }
                view2.setVisibility(0);
                textView = GuildProfileFragment.this.auditTips;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("auditTips");
                } else {
                    textView2 = textView;
                }
                textView2.setText(str2);
            }
        };
        X1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.profile.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildProfileFragment.si(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ji() {
        boolean z16;
        GuildProfileViewModel guildProfileViewModel = this.viewModel;
        GuildProfileViewModel guildProfileViewModel2 = null;
        if (guildProfileViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildProfileViewModel = null;
        }
        GuildProfileViewModel.ItemContent value = guildProfileViewModel.Z1().getValue();
        if (value != null) {
            z16 = value.getIsAudit();
        } else {
            z16 = false;
        }
        if (z16) {
            QQToast.makeText(getActivity(), 0, "\u5ba1\u6838\u4e2d\uff0c\u6682\u4e0d\u652f\u6301\u4fee\u6539", 1).show();
            return;
        }
        FragmentActivity activity = getActivity();
        GuildProfileViewModel guildProfileViewModel3 = this.viewModel;
        if (guildProfileViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            guildProfileViewModel2 = guildProfileViewModel3;
        }
        QQGuildAvatarSettingFragment.Rh(activity, guildProfileViewModel2.b2().getValue(), 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ki() {
        boolean z16;
        GuildProfileViewModel guildProfileViewModel = this.viewModel;
        GuildProfileViewModel guildProfileViewModel2 = null;
        if (guildProfileViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildProfileViewModel = null;
        }
        GuildProfileViewModel.ItemContent value = guildProfileViewModel.a2().getValue();
        if (value != null) {
            z16 = value.getIsAudit();
        } else {
            z16 = false;
        }
        if (z16) {
            QQToast.makeText(getActivity(), 0, "\u5ba1\u6838\u4e2d\uff0c\u6682\u4e0d\u652f\u6301\u4fee\u6539", 1).show();
            return;
        }
        FragmentActivity activity = getActivity();
        GuildProfileViewModel guildProfileViewModel3 = this.viewModel;
        if (guildProfileViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            guildProfileViewModel2 = guildProfileViewModel3;
        }
        QQGuildCoverSettingFragment.Ch(activity, guildProfileViewModel2.b2().getValue(), 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void li(View view, boolean isGroupAdmin) {
        if (isGroupAdmin) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                GuildBindGroupSettingFragment.Companion companion = GuildBindGroupSettingFragment.INSTANCE;
                String str = this.guildId;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("guildId");
                    str = null;
                }
                companion.b(str, activity);
            }
        } else {
            QQToastUtil.showQQToast(0, R.string.f140840f2);
        }
        com.tencent.mobileqq.guild.setting.group.groupshow.g.INSTANCE.e(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void mi() {
        GuildProfileViewModel guildProfileViewModel = this.viewModel;
        String str = null;
        if (guildProfileViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildProfileViewModel = null;
        }
        GuildProfileViewModel.ItemContent value = guildProfileViewModel.c2().getValue();
        if (value == null) {
            Logger.f235387a.d().w("Guild.mnr.GuildProfileFragment", 1, "handleGuildIntroClick des is null");
            return;
        }
        if (value.getIsAudit()) {
            QQToast.makeText(getActivity(), 0, "\u5ba1\u6838\u4e2d\uff0c\u6682\u4e0d\u652f\u6301\u4fee\u6539", 1).show();
            return;
        }
        FragmentActivity activity = getActivity();
        String str2 = this.guildId;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildId");
        } else {
            str = str2;
        }
        QQGuildDescriptionEditFragment.Nh(activity, str, value.getContent(), 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ni() {
        boolean z16;
        GuildProfileViewModel guildProfileViewModel = this.viewModel;
        GuildProfileViewModel guildProfileViewModel2 = null;
        if (guildProfileViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildProfileViewModel = null;
        }
        GuildProfileViewModel.ItemContent value = guildProfileViewModel.d2().getValue();
        if (value != null) {
            z16 = value.getIsAudit();
        } else {
            z16 = false;
        }
        if (z16) {
            QQToast.makeText(getActivity(), 0, "\u5ba1\u6838\u4e2d\uff0c\u6682\u4e0d\u652f\u6301\u4fee\u6539", 1).show();
            return;
        }
        FragmentActivity activity = getActivity();
        GuildProfileViewModel guildProfileViewModel3 = this.viewModel;
        if (guildProfileViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            guildProfileViewModel2 = guildProfileViewModel3;
        }
        QQGuildNameSettingFragment.Yh(activity, guildProfileViewModel2.b2().getValue(), 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void oi() {
        String str;
        if (com.tencent.mobileqq.guild.util.o.c("Guild.mnr.GuildProfileFragment")) {
            return;
        }
        String str2 = this.guildId;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildId");
            str2 = null;
        }
        if (!TextUtils.isEmpty(str2)) {
            String str3 = this.guildId;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildId");
                str3 = null;
            }
            String addParameter = URLUtil.addParameter("https://qun.qq.com/guild/h5/guild-num-set/index.html?_wv=2", "guildId", str3);
            IGuildWebApi iGuildWebApi = (IGuildWebApi) QRoute.api(IGuildWebApi.class);
            FragmentActivity activity = getActivity();
            String str4 = this.guildId;
            if (str4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildId");
                str = null;
            } else {
                str = str4;
            }
            iGuildWebApi.openWebUrlOnlyForGuild(activity, addParameter, null, "", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pi(View v3) {
        Map mapOf;
        GuildProfileViewModel guildProfileViewModel = this.viewModel;
        String str = null;
        if (guildProfileViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildProfileViewModel = null;
        }
        GuildProfileViewModel.ItemContent value = guildProfileViewModel.g2().getValue();
        if (value != null) {
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_pg_status", Integer.valueOf(value.getIsAudit() ? 1 : 0)));
            VideoReport.reportEvent("clck", v3, mapOf);
            if (value.getIsAudit()) {
                QQToast.makeText(getActivity(), 0, "\u5ba1\u6838\u4e2d\uff0c\u6682\u4e0d\u652f\u6301\u4fee\u6539", 1).show();
                return;
            }
            GuildRuleEditFragment.Companion companion = GuildRuleEditFragment.INSTANCE;
            FragmentActivity activity = getActivity();
            String str2 = this.guildId;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildId");
            } else {
                str = str2;
            }
            companion.a(activity, str, 5);
            return;
        }
        Logger.f235387a.d().w("Guild.mnr.GuildProfileFragment", 1, "handleGuildRuleClick des is null");
    }

    private final void qi() {
        QUIListItemAdapter qUIListItemAdapter = null;
        this.adapter = new QUIListItemAdapter(null, false, false, 7, null);
        QUISettingsRecyclerView qUISettingsRecyclerView = this.recyclerView;
        if (qUISettingsRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            qUISettingsRecyclerView = null;
        }
        QUIListItemAdapter qUIListItemAdapter2 = this.adapter;
        if (qUIListItemAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            qUIListItemAdapter2 = null;
        }
        qUISettingsRecyclerView.setAdapter(qUIListItemAdapter2);
        QUIListItemAdapter qUIListItemAdapter3 = this.adapter;
        if (qUIListItemAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            qUIListItemAdapter3 = null;
        }
        final Group[] di5 = di(qUIListItemAdapter3);
        GuildSecondaryAuthorityViewModel guildSecondaryAuthorityViewModel = this.authorityViewModel;
        if (guildSecondaryAuthorityViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authorityViewModel");
            guildSecondaryAuthorityViewModel = null;
        }
        guildSecondaryAuthorityViewModel.getShowModifyGuildInfo().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.profile.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildProfileFragment.ri(di5, this, (Boolean) obj);
            }
        });
        QUIListItemAdapter qUIListItemAdapter4 = this.adapter;
        if (qUIListItemAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            qUIListItemAdapter = qUIListItemAdapter4;
        }
        qUIListItemAdapter.t0((Group[]) Arrays.copyOf(di5, di5.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ri(Group[] groups, GuildProfileFragment this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(groups, "$groups");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (bool == null) {
            return;
        }
        for (Group group : groups) {
            Iterator<com.tencent.mobileqq.widget.listitem.a<?>> it = group.a().iterator();
            while (it.hasNext()) {
                com.tencent.mobileqq.widget.listitem.a<?> config = it.next();
                Intrinsics.checkNotNullExpressionValue(config, "config");
                this$0.Di(config, bool.booleanValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void si(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final x.b.d ti(@StringRes int stringRes) {
        String string = getString(stringRes);
        Intrinsics.checkNotNullExpressionValue(string, "getString(stringRes)");
        return new x.b.d(string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ui(ImageView imageView, String avatarUrl) {
        int e16 = QQGuildUIUtil.e(64.0f, getResources());
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mRequestWidth = e16;
        obtain.mRequestHeight = e16;
        try {
            URLDrawable drawable = URLDrawable.getDrawable(avatarUrl, obtain);
            Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(avatarUrl, options)");
            drawable.setTag(new int[]{e16, e16});
            drawable.setDecodeHandler(ch.f235513f);
            imageView.setImageDrawable(drawable);
        } catch (Exception e17) {
            QLog.e("Guild.mnr.GuildProfileFragment", 1, e17, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void vi(ImageView imageView, String avatarUrl) {
        int e16 = QQGuildUIUtil.e(64.0f, getResources());
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mRequestWidth = e16;
        obtain.mRequestHeight = e16;
        try {
            if (TextUtils.isEmpty(avatarUrl)) {
                imageView.setVisibility(8);
                return;
            }
            imageView.setVisibility(0);
            URLDrawable drawable = URLDrawable.getDrawable(avatarUrl, obtain);
            Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(avatarUrl, options)");
            drawable.setTag(new int[]{e16, e16});
            drawable.setDecodeHandler(ch.f235513f);
            imageView.setImageDrawable(drawable);
        } catch (Exception e17) {
            QLog.e("Guild.mnr.GuildProfileFragment", 1, e17, new Object[0]);
        }
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> wi(QUIListItemAdapter adapter) {
        tz1.b bVar = new tz1.b(new x.b.d("\u76f8\u5173\u7fa4\u804a"), new x.c.g("", false, false, 6, null), false);
        bVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.profile.h
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                GuildProfileFragment.yi(view);
            }
        });
        GuildProfileViewModel guildProfileViewModel = this.viewModel;
        if (guildProfileViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildProfileViewModel = null;
        }
        MutableLiveData<GuildProfileViewModel.RelativeChatGroupItemShow> f26 = guildProfileViewModel.f2();
        final GuildProfileFragment$relativeChatGroupSettingConfig$1 guildProfileFragment$relativeChatGroupSettingConfig$1 = new GuildProfileFragment$relativeChatGroupSettingConfig$1(bVar, this, adapter);
        f26.observe(this, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.profile.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildProfileFragment.xi(Function1.this, obj);
            }
        });
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yi(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        com.tencent.mobileqq.guild.setting.group.groupshow.g.INSTANCE.j(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zi(View view, String elementId) {
        VideoReport.setElementId(view, elementId);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("clck", view, null);
    }

    public final void Ci() {
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(this.N, "pg_sgrp_channel_set_channel_profile");
        IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
        RelativeLayout relativeLayout = this.N;
        String str = this.guildId;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildId");
            str = null;
        }
        iGuildDTReportApi.setGuildPageParams(relativeLayout, str, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        super.doOnCreateView(inflater, container, savedInstanceState);
        Ai();
        initView();
        initViewModel();
        qi();
        Ci();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f2l;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Logger.f235387a.d().i("Guild.mnr.GuildProfileFragment", 1, "onActivityResult " + requestCode + ", " + resultCode);
        if (resultCode == -1) {
            GuildProfileViewModel guildProfileViewModel = this.viewModel;
            GuildProfileViewModel guildProfileViewModel2 = null;
            if (guildProfileViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                guildProfileViewModel = null;
            }
            guildProfileViewModel.k2();
            GuildProfileViewModel guildProfileViewModel3 = this.viewModel;
            if (guildProfileViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                guildProfileViewModel2 = guildProfileViewModel3;
            }
            guildProfileViewModel2.m2();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        GuildProfileViewModel guildProfileViewModel = this.viewModel;
        if (guildProfileViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildProfileViewModel = null;
        }
        guildProfileViewModel.m2();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        GuildDefaultThemeNavBarCommon guildDefaultThemeNavBarCommon = this.J;
        if (guildDefaultThemeNavBarCommon != null) {
            Context context = guildDefaultThemeNavBarCommon.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "vg.context");
            this.J.f().setBackground(GuildUIUtils.w(context, R.drawable.guild_back_left, Integer.valueOf(R.color.qui_common_icon_primary)));
            GuildDefaultThemeNavBarCommon guildDefaultThemeNavBarCommon2 = this.J;
            guildDefaultThemeNavBarCommon2.setTitleColor(AppCompatResources.getColorStateList(guildDefaultThemeNavBarCommon2.getContext(), R.color.qui_common_text_primary));
            this.J.a();
            this.J.setBackgroundResource(R.drawable.lvj);
        }
    }
}
