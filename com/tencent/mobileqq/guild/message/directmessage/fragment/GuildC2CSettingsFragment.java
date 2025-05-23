package com.tencent.mobileqq.guild.message.directmessage.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.IGuildQCircleAvatarApi;
import com.tencent.mobileqq.guild.api.IQQGuildJubaoApi;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.channel.managev2.utils.ChannelSettingUtils;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.message.directmessage.model.repositories.DirectMessageNodeRepository;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.GuildProfileCard;
import com.tencent.mobileqq.guild.robot.api.IGuildRobotPageApi;
import com.tencent.mobileqq.guild.robot.components.feedback.RobotFeedbackFragment;
import com.tencent.mobileqq.guild.robot.components.setting.DirectMsgLimitDialogFragment;
import com.tencent.mobileqq.guild.robot.display.more.MoreRobotInfoFragment;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUISingleLineListItem;
import com.tencent.mobileqq.widget.listitem.ac;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotData;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotInfoRsp;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import ef1.c;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 b2\u00020\u0001:\u0001cB\u0007\u00a2\u0006\u0004\b`\u0010aJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J&\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0014J\b\u0010\u0010\u001a\u00020\nH\u0002J\b\u0010\u0011\u001a\u00020\nH\u0002J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0013H\u0002J\b\u0010\u0018\u001a\u00020\nH\u0002J\b\u0010\u0019\u001a\u00020\nH\u0002J\b\u0010\u001a\u001a\u00020\nH\u0002J\b\u0010\u001b\u001a\u00020\nH\u0002J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u0010\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\b\u0010 \u001a\u00020\u0013H\u0002J\b\u0010!\u001a\u00020\nH\u0002J\b\u0010\"\u001a\u00020\nH\u0002J\u001c\u0010'\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0$2\u0006\u0010#\u001a\u00020\u001cH\u0002J,\u0010,\u001a\u001e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0*j\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&`+2\u0006\u0010)\u001a\u00020(H\u0002J \u0010/\u001a\u00020\n2\u0006\u0010-\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020%H\u0002J \u00101\u001a\u00020\n2\u0006\u0010-\u001a\u00020\f2\u0006\u0010.\u001a\u00020%2\u0006\u00100\u001a\u00020%H\u0002R\u0016\u00104\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00103R\u0016\u00108\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00103R\u0016\u0010:\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00103R\u0016\u0010=\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010@\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010A\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010?R\u001b\u0010G\u001a\u00020B8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u001b\u0010T\u001a\u00020P8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bQ\u0010D\u001a\u0004\bR\u0010SR$\u0010Z\u001a\u0010\u0012\u0004\u0012\u00020V\u0012\u0004\u0012\u00020W\u0018\u00010U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR$\u0010\\\u001a\u0010\u0012\u0004\u0012\u00020V\u0012\u0004\u0012\u00020W\u0018\u00010U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010YR$\u0010_\u001a\u0010\u0012\u0004\u0012\u00020V\u0012\u0004\u0012\u00020]\u0018\u00010U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010Y\u00a8\u0006d"}, d2 = {"Lcom/tencent/mobileqq/guild/message/directmessage/fragment/GuildC2CSettingsFragment;", "Lcom/tencent/mobileqq/guild/base/QQGuildTitleBarFragment;", "", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "doOnCreateView", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "ph", "init", "initView", "zi", "Lcom/tencent/mobileqq/widget/listitem/Group;", "oi", "Ai", "ki", "Ii", "Yi", "Xi", "Pi", "Ti", "", "isBlocked", "Ei", "Fi", "qi", "Zi", "Di", "isChecked", "", "", "", "vi", "Lcom/tencent/qqnt/kernel/nativeinterface/GProGuildRobotInfoRsp;", "robotInfoRsp", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "ti", "reportView", "elementId", "Hi", "event", "Gi", "T", "Ljava/lang/String;", "guildId", "U", "sourceGuildId", "V", "channelId", "W", "targetTinyId", "X", "I", "directMsgType", "Y", "Z", "isMsgNotDisturb", "isRobot", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "a0", "Lkotlin/Lazy;", "si", "()Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "Landroidx/recyclerview/widget/RecyclerView;", "b0", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/mobileqq/guild/message/directmessage/fragment/GuildC2CSettingsViewModel;", "c0", "Lcom/tencent/mobileqq/guild/message/directmessage/fragment/GuildC2CSettingsViewModel;", "vm", "Lox1/i;", "d0", SensorJsPlugin.SENSOR_INTERVAL_UI, "()Lox1/i;", "robotMoreSettingVm", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$f;", "e0", "Lcom/tencent/mobileqq/widget/listitem/x;", "msgNotDisturbConfig", "f0", "blockConfig", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "g0", "directMsgLimitConfig", "<init>", "()V", "h0", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildC2CSettingsFragment extends QQGuildTitleBarFragment {

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private String guildId = "";

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private String sourceGuildId = "";

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private String channelId = "";

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private String targetTinyId = "";

    /* renamed from: X, reason: from kotlin metadata */
    private int directMsgType;

    /* renamed from: Y, reason: from kotlin metadata */
    private boolean isMsgNotDisturb;

    /* renamed from: Z, reason: from kotlin metadata */
    private boolean isRobot;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy adapter;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private GuildC2CSettingsViewModel vm;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy robotMoreSettingVm;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> msgNotDisturbConfig;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> blockConfig;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> directMsgLimitConfig;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J@\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0007R\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/message/directmessage/fragment/GuildC2CSettingsFragment$a;", "", "Landroid/content/Context;", "context", "", "guildId", "sourceGuildId", "channelId", "targetTinyId", "", "directMessageType", "", "isMsgNotDisturb", "", "a", "DELETED", "Ljava/lang/String;", "NO_ROBOT_INFO", "TAG", "TITLE", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.message.directmessage.fragment.GuildC2CSettingsFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull Context context, @NotNull String guildId, @NotNull String sourceGuildId, @NotNull String channelId, @NotNull String targetTinyId, int directMessageType, boolean isMsgNotDisturb) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(sourceGuildId, "sourceGuildId");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(targetTinyId, "targetTinyId");
            Logger logger = Logger.f235387a;
            logger.d().d("Guild.C2C.AIO.GuildC2CSettingsFragment", 1, "[open] guildId=" + guildId + ", sourceGuildId:" + sourceGuildId + ", channelId=" + channelId + ", targetTinyId=" + targetTinyId + ", directMessageType=" + directMessageType + ", isMsgNotDisturb:" + isMsgNotDisturb);
            if (!TextUtils.isEmpty(guildId) && !TextUtils.isEmpty(sourceGuildId) && !TextUtils.isEmpty(channelId) && !TextUtils.isEmpty(targetTinyId)) {
                Intent intent = new Intent();
                intent.putExtra("extra_guild_id", guildId);
                intent.putExtra("extra_source_guild_id", sourceGuildId);
                intent.putExtra("extra_channel_id", channelId);
                intent.putExtra("extra_target_tiny_id", targetTinyId);
                intent.putExtra("extra_key_direct_message_type", directMessageType);
                intent.putExtra("extra_is_msg_not_disturb", isMsgNotDisturb);
                QPublicFragmentActivity.b.b(context, intent, QPublicFragmentActivity.class, GuildC2CSettingsFragment.class);
                return;
            }
            logger.d().w("Guild.C2C.AIO.GuildC2CSettingsFragment", 1, "[open] can not show GuildC2CSettingsFragment");
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J&\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0014\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/message/directmessage/fragment/GuildC2CSettingsFragment$b", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$a;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "Lcom/tencent/mobileqq/widget/listitem/QUISingleLineListItem;", "view", "", "position", "", "", "payloads", "", "P", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends com.tencent.mobileqq.widget.listitem.x<x.b.a, x.c.g> {
        b(x.b.a aVar, x.c.g gVar) {
            super(aVar, gVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.widget.listitem.x, com.tencent.mobileqq.widget.listitem.w
        /* renamed from: P */
        public void F(@NotNull QUISingleLineListItem view, int position, @NotNull List<? extends Object> payloads) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(payloads, "payloads");
            super.F(view, position, payloads);
            if (GuildC2CSettingsFragment.this.isRobot) {
                TextView textView = (TextView) view.findViewById(R.id.f66203a0);
                if (textView != null) {
                    textView.setCompoundDrawablePadding(ViewUtils.dip2px(4.0f));
                }
                if (textView != null) {
                    textView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.qq_troop_bot_icon, 0);
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/message/directmessage/fragment/GuildC2CSettingsFragment$c", "Lcom/tencent/mobileqq/widget/listitem/u;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "H", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c extends com.tencent.mobileqq.widget.listitem.u {
        c() {
        }

        @Override // com.tencent.mobileqq.widget.listitem.w
        @NotNull
        protected View H(@NotNull ViewGroup parent) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            TextView textView = new TextView(parent.getContext());
            GuildC2CSettingsFragment guildC2CSettingsFragment = GuildC2CSettingsFragment.this;
            textView.setLayoutParams(new ViewGroup.LayoutParams(-1, textView.getResources().getDimensionPixelOffset(R.dimen.dar)));
            textView.setGravity(17);
            textView.setTextColor(textView.getResources().getColorStateList(R.color.bu9));
            textView.setTextSize(1, 16.0f);
            textView.setText(guildC2CSettingsFragment.getString(R.string.f143080l4));
            return textView;
        }
    }

    public GuildC2CSettingsFragment() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QUIListItemAdapter>() { // from class: com.tencent.mobileqq.guild.message.directmessage.fragment.GuildC2CSettingsFragment$adapter$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QUIListItemAdapter invoke() {
                return new QUIListItemAdapter(null, false, false, 7, null);
            }
        });
        this.adapter = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ox1.i>() { // from class: com.tencent.mobileqq.guild.message.directmessage.fragment.GuildC2CSettingsFragment$robotMoreSettingVm$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes14.dex */
            public static final class a implements ViewModelProvider.Factory {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ ViewModelStoreOwner f230389a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ GuildC2CSettingsFragment f230390b;

                public a(ViewModelStoreOwner viewModelStoreOwner, GuildC2CSettingsFragment guildC2CSettingsFragment) {
                    this.f230389a = viewModelStoreOwner;
                    this.f230390b = guildC2CSettingsFragment;
                }

                @Override // androidx.lifecycle.ViewModelProvider.Factory
                @NotNull
                public <T extends ViewModel> T create(@NotNull Class<T> p06) {
                    Intrinsics.checkNotNullParameter(p06, "p0");
                    TimedValue timedValue = new TimedValue(new ox1.i(this.f230390b.targetTinyId), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
                    Logger logger = Logger.f235387a;
                    if (QLog.isColorLevel()) {
                        logger.d().d("GuildViewModelProvider", 2, "create " + com.tencent.mobileqq.guild.base.extension.m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
                    }
                    return (T) timedValue.getValue();
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ox1.i invoke() {
                c.Companion companion = ef1.c.INSTANCE;
                GuildC2CSettingsFragment guildC2CSettingsFragment = GuildC2CSettingsFragment.this;
                ViewModel viewModel = new ViewModelProvider(guildC2CSettingsFragment, new a(guildC2CSettingsFragment, guildC2CSettingsFragment)).get(ox1.i.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
                return (ox1.i) viewModel;
            }
        });
        this.robotMoreSettingVm = lazy2;
    }

    private final Group Ai() {
        String string = getString(R.string.f15050156);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.guild\u2026tify_setting_not_disturb)");
        x.b.d dVar = new x.b.d(string);
        Boolean bool = Boolean.TRUE;
        GuildC2CSettingsViewModel guildC2CSettingsViewModel = this.vm;
        if (guildC2CSettingsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            guildC2CSettingsViewModel = null;
        }
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar = new com.tencent.mobileqq.widget.listitem.x<>(dVar, new x.c.f(Intrinsics.areEqual(bool, guildC2CSettingsViewModel.n2().getValue()), new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.guild.message.directmessage.fragment.s
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                GuildC2CSettingsFragment.Bi(GuildC2CSettingsFragment.this, compoundButton, z16);
            }
        }));
        xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.guild.message.directmessage.fragment.t
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                GuildC2CSettingsFragment.Ci(GuildC2CSettingsFragment.this, view);
            }
        });
        this.msgNotDisturbConfig = xVar;
        return new Group(xVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bi(GuildC2CSettingsFragment this$0, CompoundButton view, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(view, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(view, "view");
        ChannelSettingUtils.i(view, "em_sgrp_private_details_disturb_switch", this$0.vi(z16));
        GuildC2CSettingsViewModel guildC2CSettingsViewModel = this$0.vm;
        if (guildC2CSettingsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            guildC2CSettingsViewModel = null;
        }
        guildC2CSettingsViewModel.k2(z16);
        EventCollector.getInstance().onCompoundButtonChecked(view, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ci(GuildC2CSettingsFragment this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        Boolean bool = Boolean.TRUE;
        GuildC2CSettingsViewModel guildC2CSettingsViewModel = this$0.vm;
        if (guildC2CSettingsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            guildC2CSettingsViewModel = null;
        }
        this$0.Hi(it, Intrinsics.areEqual(bool, guildC2CSettingsViewModel.n2().getValue()), "em_sgrp_private_details_disturb_switch");
    }

    private final void Di() {
        GuildProfileData guildProfileData = new GuildProfileData(this.sourceGuildId, this.guildId, this.targetTinyId, 0, 6);
        if (2 == this.directMsgType) {
            guildProfileData.getGuildBaseProfileData().y(true);
        }
        Logger.f235387a.d().d("Guild.C2C.AIO.GuildC2CSettingsFragment", 1, "[openMemberCard] guildId:" + this.guildId + ", sourceGuildId:" + this.sourceGuildId + ", targetTinyId:" + this.targetTinyId);
        guildProfileData.getExtras().putByte(AppConstants.Key.GUILD_DIRECT_MESSAGE_FLAG, (byte) 1);
        guildProfileData.getExtras().putString(AppConstants.Key.GUILD_DIRECT_MESSAGE_GUILD_ID, this.guildId);
        guildProfileData.getExtras().putString(AppConstants.Key.GUILD_DIRECT_MESSAGE_CHANNEL_ID, this.channelId);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            GuildProfileCard.Lh(activity, guildProfileData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ei(boolean isBlocked) {
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar = this.blockConfig;
        if (xVar != null) {
            Logger.f235387a.d().d("Guild.C2C.AIO.GuildC2CSettingsFragment", 1, "[refreshBlockSwitch] isBlocked:" + isBlocked);
            xVar.O().f(isBlocked);
            si().l0(xVar);
        }
        Fi(isBlocked);
    }

    private final void Fi(boolean isBlocked) {
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar;
        if (this.isRobot && (xVar = this.directMsgLimitConfig) != null) {
            Logger.f235387a.d().d("Guild.C2C.AIO.GuildC2CSettingsFragment", 1, "[refreshMsgLimit] isBlocked:" + isBlocked);
            si().m0(xVar, isBlocked ^ true);
        }
    }

    private final void Gi(View reportView, String elementId, String event) {
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).reportDtEventManual(reportView, elementId, event, new HashMap());
    }

    private final void Hi(View reportView, boolean isChecked, String elementId) {
        VideoReport.setElementReuseIdentifier(reportView, elementId);
        VideoReport.setElementId(reportView, elementId);
        VideoReport.setElementParams(reportView, vi(isChecked));
        VideoReport.setElementClickPolicy(reportView, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(reportView, ExposurePolicy.REPORT_ALL);
    }

    private final Group Ii() {
        x.Companion companion = com.tencent.mobileqq.widget.listitem.x.INSTANCE;
        String string = getString(R.string.f153841d7);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.guild\u2026t_feedback_and_complaint)");
        com.tencent.mobileqq.widget.listitem.x b16 = x.Companion.b(companion, string, null, 2, null);
        b16.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.message.directmessage.fragment.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildC2CSettingsFragment.Ji(GuildC2CSettingsFragment.this, view);
            }
        });
        String string2 = getString(R.string.f154271ec);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.guild_robot_shield_chat)");
        x.b.d dVar = new x.b.d(string2);
        Boolean bool = Boolean.TRUE;
        GuildC2CSettingsViewModel guildC2CSettingsViewModel = this.vm;
        if (guildC2CSettingsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            guildC2CSettingsViewModel = null;
        }
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar = new com.tencent.mobileqq.widget.listitem.x<>(dVar, new x.c.f(Intrinsics.areEqual(bool, guildC2CSettingsViewModel.m2().getValue()), new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.guild.message.directmessage.fragment.b
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                GuildC2CSettingsFragment.Ki(GuildC2CSettingsFragment.this, compoundButton, z16);
            }
        }));
        xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.guild.message.directmessage.fragment.c
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                GuildC2CSettingsFragment.Li(GuildC2CSettingsFragment.this, view);
            }
        });
        this.blockConfig = xVar;
        String string3 = getString(R.string.f153721cv);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.guild_robot_direct_msg_limit)");
        String string4 = getString(R.string.f153731cw, ui().T1().getValue());
        Intrinsics.checkNotNullExpressionValue(string4, "getString(R.string.guild\u2026irectMsgLimitCount.value)");
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> a16 = companion.a(string3, string4);
        this.directMsgLimitConfig = a16;
        a16.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.message.directmessage.fragment.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildC2CSettingsFragment.Mi(GuildC2CSettingsFragment.this, view);
            }
        });
        String string5 = getString(R.string.f153341bu);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(R.string.guild\u2026_action_sheet_extra_data)");
        com.tencent.mobileqq.widget.listitem.x b17 = x.Companion.b(companion, string5, null, 2, null);
        b17.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.message.directmessage.fragment.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildC2CSettingsFragment.Ni(GuildC2CSettingsFragment.this, view);
            }
        });
        String string6 = getString(R.string.f153351bv);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(R.string.guild_robot_action_sheet_faq)");
        com.tencent.mobileqq.widget.listitem.x b18 = x.Companion.b(companion, string6, null, 2, null);
        b18.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.message.directmessage.fragment.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildC2CSettingsFragment.Oi(GuildC2CSettingsFragment.this, view);
            }
        });
        return new Group(b16, xVar, a16, b17, b18);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ji(GuildC2CSettingsFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
            this$0.Yi();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ki(GuildC2CSettingsFragment this$0, CompoundButton view, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(view, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            this$0.Pi();
        } else {
            GuildC2CSettingsViewModel guildC2CSettingsViewModel = this$0.vm;
            if (guildC2CSettingsViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
                guildC2CSettingsViewModel = null;
            }
            guildC2CSettingsViewModel.q2(false);
        }
        Intrinsics.checkNotNullExpressionValue(view, "view");
        ChannelSettingUtils.i(view, "em_sgrp_block_private", this$0.vi(z16));
        EventCollector.getInstance().onCompoundButtonChecked(view, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Li(GuildC2CSettingsFragment this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        Boolean bool = Boolean.TRUE;
        GuildC2CSettingsViewModel guildC2CSettingsViewModel = this$0.vm;
        if (guildC2CSettingsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            guildC2CSettingsViewModel = null;
        }
        this$0.Hi(it, Intrinsics.areEqual(bool, guildC2CSettingsViewModel.m2().getValue()), "em_sgrp_block_private");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mi(GuildC2CSettingsFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
            this$0.Xi();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ni(GuildC2CSettingsFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
            this$0.Zi();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oi(GuildC2CSettingsFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
            GuildC2CSettingsViewModel guildC2CSettingsViewModel = this$0.vm;
            if (guildC2CSettingsViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
                guildC2CSettingsViewModel = null;
            }
            if (guildC2CSettingsViewModel.getRobotInfoRsp() == null) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                bVar.a().add("[showFeedbackAndComplaint] robotInfoRsp is null");
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("Guild.C2C.AIO.GuildC2CSettingsFragment", 1, (String) it.next(), null);
                }
                FragmentActivity activity = this$0.getActivity();
                if (activity != null) {
                    QQToast.makeText(activity, 1, "\u4fe1\u606f\u83b7\u53d6\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", 0).show();
                }
            } else {
                FragmentActivity activity2 = this$0.getActivity();
                if (activity2 != null) {
                    ((IGuildRobotPageApi) QRoute.api(IGuildRobotPageApi.class)).openRobotFaqPage(activity2, this$0.guildId);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Pi() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            final ActionSheet actionSheet = null;
            Dialog createDialog = ActionSheetHelper.createDialog(activity, null);
            if (createDialog instanceof ActionSheet) {
                actionSheet = (ActionSheet) createDialog;
            }
            if (actionSheet != null) {
                actionSheet.setMainTitle("\u5c4f\u853d\u540e\uff0c\u5c06\u4e0d\u4f1a\u6536\u5230\u5bf9\u65b9\u53d1\u6765\u7684\u79c1\u4fe1\u3002");
                actionSheet.addButton(R.string.f142570jq, 3);
                actionSheet.addCancelButton(R.string.f140850f3);
                final String str = "em_sgrp_block_private_pop";
                actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.guild.message.directmessage.fragment.k
                    @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
                    public final void onClick(View view, int i3) {
                        GuildC2CSettingsFragment.Qi(str, this, actionSheet, view, i3);
                    }
                });
                actionSheet.setOnBottomCancelListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.message.directmessage.fragment.m
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        GuildC2CSettingsFragment.Ri(str, actionSheet, this, view);
                    }
                });
                actionSheet.setOnDismissListener(new ActionSheet.OnDismissListener() { // from class: com.tencent.mobileqq.guild.message.directmessage.fragment.n
                    @Override // com.tencent.widget.ActionSheet.OnDismissListener
                    public final void onDismiss() {
                        GuildC2CSettingsFragment.Si(ActionSheet.this, this, str);
                    }
                });
                actionSheet.show();
                ViewGroup rootView = actionSheet.getRootView();
                if (rootView != null) {
                    Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
                    zi(rootView);
                }
                LinearLayout mContentContainer = actionSheet.mContentContainer;
                if (mContentContainer != null) {
                    Intrinsics.checkNotNullExpressionValue(mContentContainer, "mContentContainer");
                    Gi(mContentContainer, "em_sgrp_block_private_pop", "imp");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qi(String elementId, GuildC2CSettingsFragment this$0, ActionSheet this_apply, View clickedView, int i3) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(elementId, "$elementId");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        if (i3 == 0) {
            Intrinsics.checkNotNullExpressionValue(clickedView, "clickedView");
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_btn_type", "1"));
            ChannelSettingUtils.i(clickedView, elementId, mapOf);
            GuildC2CSettingsViewModel guildC2CSettingsViewModel = this$0.vm;
            if (guildC2CSettingsViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
                guildC2CSettingsViewModel = null;
            }
            guildC2CSettingsViewModel.q2(true);
        }
        LinearLayout linearLayout = this_apply.mContentContainer;
        if (linearLayout != null) {
            this$0.Gi(linearLayout, elementId, "imp_end");
        }
        this_apply.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ri(String elementId, ActionSheet this_apply, GuildC2CSettingsFragment this$0, View clickedView) {
        Map mapOf;
        EventCollector.getInstance().onViewClickedBefore(clickedView);
        Intrinsics.checkNotNullParameter(elementId, "$elementId");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(clickedView, "clickedView");
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_btn_type", "2"));
        ChannelSettingUtils.i(clickedView, elementId, mapOf);
        LinearLayout linearLayout = this_apply.mContentContainer;
        if (linearLayout != null) {
            this$0.Gi(linearLayout, elementId, "imp_end");
        }
        this$0.Ei(false);
        this_apply.dismiss();
        EventCollector.getInstance().onViewClicked(clickedView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Si(ActionSheet this_apply, GuildC2CSettingsFragment this$0, String elementId) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(elementId, "$elementId");
        LinearLayout linearLayout = this_apply.mContentContainer;
        if (linearLayout != null) {
            this$0.Gi(linearLayout, elementId, "imp_end");
        }
        this$0.Ei(false);
    }

    private final void Ti() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            final ActionSheet actionSheet = null;
            Dialog createDialog = ActionSheetHelper.createDialog(activity, null);
            if (createDialog instanceof ActionSheet) {
                actionSheet = (ActionSheet) createDialog;
            }
            if (actionSheet != null) {
                actionSheet.setMainTitle(R.string.f143050l1);
                actionSheet.addButton(R.string.f143030kz, 3);
                actionSheet.addCancelButton(R.string.f140850f3);
                final String str = "em_sgrp_private_delete_pop";
                actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.guild.message.directmessage.fragment.h
                    @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
                    public final void onClick(View view, int i3) {
                        GuildC2CSettingsFragment.Ui(ActionSheet.this, str, this, view, i3);
                    }
                });
                actionSheet.setOnBottomCancelListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.message.directmessage.fragment.i
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        GuildC2CSettingsFragment.Vi(str, actionSheet, this, view);
                    }
                });
                actionSheet.setOnDismissListener(new ActionSheet.OnDismissListener() { // from class: com.tencent.mobileqq.guild.message.directmessage.fragment.j
                    @Override // com.tencent.widget.ActionSheet.OnDismissListener
                    public final void onDismiss() {
                        GuildC2CSettingsFragment.Wi(ActionSheet.this, this, str);
                    }
                });
                actionSheet.show();
                ViewGroup rootView = actionSheet.getRootView();
                if (rootView != null) {
                    Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
                    zi(rootView);
                }
                LinearLayout mContentContainer = actionSheet.mContentContainer;
                if (mContentContainer != null) {
                    Intrinsics.checkNotNullExpressionValue(mContentContainer, "mContentContainer");
                    Gi(mContentContainer, "em_sgrp_private_delete_pop", "imp");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ui(ActionSheet this_apply, String elementId, GuildC2CSettingsFragment this$0, View clickedView, int i3) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(elementId, "$elementId");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0) {
            if (!NetworkUtil.isNetworkAvailable()) {
                QQToastUtil.showQQToast(1, R.string.f1511016s);
                this_apply.dismiss();
                return;
            }
            Intrinsics.checkNotNullExpressionValue(clickedView, "clickedView");
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_btn_type", "1"));
            ChannelSettingUtils.i(clickedView, elementId, mapOf);
            LinearLayout linearLayout = this_apply.mContentContainer;
            if (linearLayout != null) {
                this$0.Gi(linearLayout, elementId, "imp_end");
            }
            DirectMessageNodeRepository.v(this$0.guildId, this$0.channelId);
            FragmentActivity activity = this$0.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
        this_apply.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vi(String elementId, ActionSheet this_apply, GuildC2CSettingsFragment this$0, View clickedView) {
        Map mapOf;
        EventCollector.getInstance().onViewClickedBefore(clickedView);
        Intrinsics.checkNotNullParameter(elementId, "$elementId");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(clickedView, "clickedView");
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_btn_type", "2"));
        ChannelSettingUtils.i(clickedView, elementId, mapOf);
        LinearLayout linearLayout = this_apply.mContentContainer;
        if (linearLayout != null) {
            this$0.Gi(linearLayout, elementId, "imp_end");
        }
        this_apply.dismiss();
        EventCollector.getInstance().onViewClicked(clickedView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wi(ActionSheet this_apply, GuildC2CSettingsFragment this$0, String elementId) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(elementId, "$elementId");
        LinearLayout linearLayout = this_apply.mContentContainer;
        if (linearLayout != null) {
            this$0.Gi(linearLayout, elementId, "imp_end");
        }
    }

    private final void Xi() {
        String str;
        String str2;
        GuildC2CSettingsViewModel guildC2CSettingsViewModel = this.vm;
        String str3 = null;
        if (guildC2CSettingsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            guildC2CSettingsViewModel = null;
        }
        GProGuildRobotInfoRsp robotInfoRsp = guildC2CSettingsViewModel.getRobotInfoRsp();
        if (robotInfoRsp == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("[showDirectMsgLimitDialog] robotInfoRsp is null");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.C2C.AIO.GuildC2CSettingsFragment", 1, (String) it.next(), null);
            }
            FragmentActivity activity = getActivity();
            if (activity != null) {
                QQToast.makeText(activity, 1, "\u4fe1\u606f\u83b7\u53d6\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", 0).show();
                return;
            }
            return;
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            ox1.i ui5 = ui();
            String str4 = this.guildId;
            GProGuildRobotData gProGuildRobotData = robotInfoRsp.robotData;
            if (gProGuildRobotData == null || (str = Long.valueOf(gProGuildRobotData.robotUin).toString()) == null) {
                str = "0";
            }
            GProGuildRobotData gProGuildRobotData2 = robotInfoRsp.robotData;
            if (gProGuildRobotData2 != null) {
                str3 = gProGuildRobotData2.robotName;
            }
            if (str3 == null) {
                str2 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str3, "robotInfoRsp.robotData?.robotName ?: \"\"");
                str2 = str3;
            }
            DirectMsgLimitDialogFragment.Jh(activity2, null, ui5, str4, str, str2, 3);
        }
    }

    private final void Yi() {
        GuildC2CSettingsViewModel guildC2CSettingsViewModel = this.vm;
        String str = null;
        if (guildC2CSettingsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            guildC2CSettingsViewModel = null;
        }
        GProGuildRobotInfoRsp robotInfoRsp = guildC2CSettingsViewModel.getRobotInfoRsp();
        if (robotInfoRsp == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("[showFeedbackAndComplaint] robotInfoRsp is null");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.C2C.AIO.GuildC2CSettingsFragment", 1, (String) it.next(), null);
            }
            FragmentActivity activity = getActivity();
            if (activity != null) {
                QQToast.makeText(activity, 1, "\u4fe1\u606f\u83b7\u53d6\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", 0).show();
                return;
            }
            return;
        }
        Bundle bundle = new Bundle();
        Gson gson = new Gson();
        GProGuildRobotData gProGuildRobotData = robotInfoRsp.robotData;
        if (gProGuildRobotData != null) {
            str = gProGuildRobotData.supportUrl;
        }
        bundle.putString("ROBOT_SUPPORT_URL_KEY", str);
        bundle.putString("ROBOT_FEEDBACK_URL_KEY", robotInfoRsp.platformSupportUrl);
        bundle.putString("ROBOT_IN_GUILD_ID", this.guildId);
        bundle.putString("ROBOT_DA_TONG_PARAMS_KEY", gson.toJson(ti(robotInfoRsp)));
        Intent intent = new Intent();
        intent.putExtra("com.tencent.mobileqq.guild.robot.components.feedback.RobotFeedbackFragment", bundle);
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            QPublicFragmentActivity.start(activity2, intent, RobotFeedbackFragment.class);
        }
    }

    private final void Zi() {
        GuildC2CSettingsViewModel guildC2CSettingsViewModel = this.vm;
        GuildC2CSettingsViewModel guildC2CSettingsViewModel2 = null;
        if (guildC2CSettingsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            guildC2CSettingsViewModel = null;
        }
        GProGuildRobotInfoRsp robotInfoRsp = guildC2CSettingsViewModel.getRobotInfoRsp();
        if (robotInfoRsp == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("[showFeedbackAndComplaint] robotInfoRsp is null");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.C2C.AIO.GuildC2CSettingsFragment", 1, (String) it.next(), null);
            }
            FragmentActivity activity = getActivity();
            if (activity != null) {
                QQToast.makeText(activity, 1, "\u4fe1\u606f\u83b7\u53d6\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", 0).show();
                return;
            }
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("guildId", this.guildId);
        bundle.putString("channelId", this.channelId);
        GuildC2CSettingsViewModel guildC2CSettingsViewModel3 = this.vm;
        if (guildC2CSettingsViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        } else {
            guildC2CSettingsViewModel2 = guildC2CSettingsViewModel3;
        }
        bundle.putParcelable("MORE_ROBOT_INFO_KEY", guildC2CSettingsViewModel2.i2());
        bundle.putSerializable("MORE_ROBOT_DA_TONG_DATA", ti(robotInfoRsp));
        Intent intent = new Intent();
        intent.putExtra("com.tencent.mobileqq.guild.robot.other.MoreRobotInfoFragment", bundle);
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            QPublicFragmentActivity.start(activity2, intent, MoreRobotInfoFragment.class);
        }
    }

    private final void init() {
        String str;
        String str2;
        String str3;
        String str4;
        int i3;
        boolean z16;
        Intent intent;
        Intent intent2;
        Intent intent3;
        Intent intent4;
        Intent intent5;
        Intent intent6;
        FragmentActivity activity = getActivity();
        GuildC2CSettingsViewModel guildC2CSettingsViewModel = null;
        if (activity != null && (intent6 = activity.getIntent()) != null) {
            str = intent6.getStringExtra("extra_guild_id");
        } else {
            str = null;
        }
        String str5 = "";
        if (str == null) {
            str = "";
        }
        this.guildId = str;
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && (intent5 = activity2.getIntent()) != null) {
            str2 = intent5.getStringExtra("extra_source_guild_id");
        } else {
            str2 = null;
        }
        if (str2 == null) {
            str2 = "";
        }
        this.sourceGuildId = str2;
        FragmentActivity activity3 = getActivity();
        if (activity3 != null && (intent4 = activity3.getIntent()) != null) {
            str3 = intent4.getStringExtra("extra_channel_id");
        } else {
            str3 = null;
        }
        if (str3 == null) {
            str3 = "";
        }
        this.channelId = str3;
        FragmentActivity activity4 = getActivity();
        if (activity4 != null && (intent3 = activity4.getIntent()) != null) {
            str4 = intent3.getStringExtra("extra_target_tiny_id");
        } else {
            str4 = null;
        }
        if (str4 != null) {
            str5 = str4;
        }
        this.targetTinyId = str5;
        FragmentActivity activity5 = getActivity();
        boolean z17 = false;
        if (activity5 != null && (intent2 = activity5.getIntent()) != null) {
            i3 = intent2.getIntExtra("extra_key_direct_message_type", 0);
        } else {
            i3 = 0;
        }
        this.directMsgType = i3;
        FragmentActivity activity6 = getActivity();
        if (activity6 != null && (intent = activity6.getIntent()) != null) {
            z16 = intent.getBooleanExtra("extra_is_msg_not_disturb", false);
        } else {
            z16 = false;
        }
        this.isMsgNotDisturb = z16;
        if (2 == this.directMsgType) {
            z17 = true;
        }
        this.isRobot = z17;
        Logger.f235387a.d().d("Guild.C2C.AIO.GuildC2CSettingsFragment", 1, "[init] guildId:" + this.guildId + ", sourceGuildId:" + this.sourceGuildId + ", channelId:" + this.channelId + ", targetTinyId:" + this.targetTinyId + ", directMsgType:" + this.directMsgType + ", isMsgNotDisturb:" + this.isMsgNotDisturb + ", isRobot:" + this.isRobot);
        this.vm = GuildC2CSettingsViewModel.INSTANCE.a(this, this.guildId, this.sourceGuildId, this.channelId, this.targetTinyId, this.directMsgType, this.isMsgNotDisturb);
        initView();
        GuildC2CSettingsViewModel guildC2CSettingsViewModel2 = this.vm;
        if (guildC2CSettingsViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            guildC2CSettingsViewModel2 = null;
        }
        LiveData<Boolean> n26 = guildC2CSettingsViewModel2.n2();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.message.directmessage.fragment.GuildC2CSettingsFragment$init$2
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
            public final void invoke2(Boolean isChecked) {
                com.tencent.mobileqq.widget.listitem.x xVar;
                QUIListItemAdapter si5;
                xVar = GuildC2CSettingsFragment.this.msgNotDisturbConfig;
                if (xVar != null) {
                    GuildC2CSettingsFragment guildC2CSettingsFragment = GuildC2CSettingsFragment.this;
                    Logger.f235387a.d().d("Guild.C2C.AIO.GuildC2CSettingsFragment", 1, "[init] reset msgNotDisturbConfig:" + isChecked);
                    x.c.f fVar = (x.c.f) xVar.O();
                    Intrinsics.checkNotNullExpressionValue(isChecked, "isChecked");
                    fVar.f(isChecked.booleanValue());
                    si5 = guildC2CSettingsFragment.si();
                    si5.l0(xVar);
                }
            }
        };
        n26.observe(this, new Observer() { // from class: com.tencent.mobileqq.guild.message.directmessage.fragment.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildC2CSettingsFragment.wi(Function1.this, obj);
            }
        });
        GuildC2CSettingsViewModel guildC2CSettingsViewModel3 = this.vm;
        if (guildC2CSettingsViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            guildC2CSettingsViewModel3 = null;
        }
        LiveData<Boolean> m26 = guildC2CSettingsViewModel3.m2();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.message.directmessage.fragment.GuildC2CSettingsFragment$init$3
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
            public final void invoke2(Boolean it) {
                Logger.f235387a.d().d("Guild.C2C.AIO.GuildC2CSettingsFragment", 1, "[init] isDirectBlock:" + it);
                GuildC2CSettingsFragment guildC2CSettingsFragment = GuildC2CSettingsFragment.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                guildC2CSettingsFragment.Ei(it.booleanValue());
            }
        };
        m26.observe(this, new Observer() { // from class: com.tencent.mobileqq.guild.message.directmessage.fragment.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildC2CSettingsFragment.xi(Function1.this, obj);
            }
        });
        if (this.isRobot) {
            GuildC2CSettingsViewModel guildC2CSettingsViewModel4 = this.vm;
            if (guildC2CSettingsViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
                guildC2CSettingsViewModel4 = null;
            }
            guildC2CSettingsViewModel4.e2();
            MutableLiveData<Long> T1 = ui().T1();
            final Function1<Long, Unit> function13 = new Function1<Long, Unit>() { // from class: com.tencent.mobileqq.guild.message.directmessage.fragment.GuildC2CSettingsFragment$init$4
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                    invoke2(l3);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Long l3) {
                    com.tencent.mobileqq.widget.listitem.x xVar;
                    QUIListItemAdapter si5;
                    Logger.f235387a.d().d("Guild.C2C.AIO.GuildC2CSettingsFragment", 1, "[init] limitCount: " + l3);
                    xVar = GuildC2CSettingsFragment.this.directMsgLimitConfig;
                    if (xVar != null) {
                        GuildC2CSettingsFragment guildC2CSettingsFragment = GuildC2CSettingsFragment.this;
                        x.c.g gVar = (x.c.g) xVar.O();
                        String string = guildC2CSettingsFragment.getString(R.string.f153731cw, l3);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.guild\u2026t_msg_limit_count, count)");
                        gVar.h(string);
                        si5 = guildC2CSettingsFragment.si();
                        si5.l0(xVar);
                    }
                }
            };
            T1.observe(this, new Observer() { // from class: com.tencent.mobileqq.guild.message.directmessage.fragment.o
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    GuildC2CSettingsFragment.yi(Function1.this, obj);
                }
            });
            GuildC2CSettingsViewModel guildC2CSettingsViewModel5 = this.vm;
            if (guildC2CSettingsViewModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
            } else {
                guildC2CSettingsViewModel = guildC2CSettingsViewModel5;
            }
            guildC2CSettingsViewModel.c2();
            return;
        }
        GuildC2CSettingsViewModel guildC2CSettingsViewModel6 = this.vm;
        if (guildC2CSettingsViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        } else {
            guildC2CSettingsViewModel = guildC2CSettingsViewModel6;
        }
        guildC2CSettingsViewModel.o2();
    }

    private final void initView() {
        Group ki5;
        View findViewById = this.P.findViewById(R.id.i4m);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewById(R.id.recycler_view)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.recyclerView = recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setAdapter(si());
        Group[] groupArr = new Group[4];
        groupArr[0] = oi();
        groupArr[1] = Ai();
        if (this.isRobot) {
            ki5 = Ii();
        } else {
            ki5 = ki();
        }
        groupArr[2] = ki5;
        groupArr[3] = qi();
        si().t0((Group[]) Arrays.copyOf(groupArr, 4));
        si().notifyDataSetChanged();
    }

    private final Group ki() {
        String string = getString(R.string.f158131os);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.guild\u2026nfo_dialog_setting_block)");
        x.b.d dVar = new x.b.d(string);
        Boolean bool = Boolean.TRUE;
        GuildC2CSettingsViewModel guildC2CSettingsViewModel = this.vm;
        if (guildC2CSettingsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            guildC2CSettingsViewModel = null;
        }
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar = new com.tencent.mobileqq.widget.listitem.x<>(dVar, new x.c.f(Intrinsics.areEqual(bool, guildC2CSettingsViewModel.m2().getValue()), new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.guild.message.directmessage.fragment.p
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                GuildC2CSettingsFragment.mi(GuildC2CSettingsFragment.this, compoundButton, z16);
            }
        }));
        xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.guild.message.directmessage.fragment.q
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                GuildC2CSettingsFragment.ni(GuildC2CSettingsFragment.this, view);
            }
        });
        this.blockConfig = xVar;
        x.Companion companion = com.tencent.mobileqq.widget.listitem.x.INSTANCE;
        String string2 = getString(R.string.f141420gm);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.guild\u2026nel_detail_header_report)");
        com.tencent.mobileqq.widget.listitem.x b16 = x.Companion.b(companion, string2, null, 2, null);
        b16.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.message.directmessage.fragment.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildC2CSettingsFragment.li(GuildC2CSettingsFragment.this, view);
            }
        });
        return new Group(xVar, b16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void li(GuildC2CSettingsFragment this$0, View view) {
        QBaseActivity qBaseActivity;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
            FragmentActivity activity = this$0.getActivity();
            if (activity instanceof QBaseActivity) {
                qBaseActivity = (QBaseActivity) activity;
            } else {
                qBaseActivity = null;
            }
            QBaseActivity qBaseActivity2 = qBaseActivity;
            if (qBaseActivity2 != null) {
                ((IQQGuildJubaoApi) QRoute.api(IQQGuildJubaoApi.class)).reportGuild(qBaseActivity2, this$0.guildId, this$0.channelId, this$0.targetTinyId, false, true);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mi(GuildC2CSettingsFragment this$0, CompoundButton view, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(view, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            this$0.Pi();
        } else {
            GuildC2CSettingsViewModel guildC2CSettingsViewModel = this$0.vm;
            if (guildC2CSettingsViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
                guildC2CSettingsViewModel = null;
            }
            guildC2CSettingsViewModel.q2(false);
        }
        Intrinsics.checkNotNullExpressionValue(view, "view");
        ChannelSettingUtils.i(view, "em_sgrp_block_private", this$0.vi(z16));
        EventCollector.getInstance().onCompoundButtonChecked(view, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ni(GuildC2CSettingsFragment this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        Boolean bool = Boolean.TRUE;
        GuildC2CSettingsViewModel guildC2CSettingsViewModel = this$0.vm;
        if (guildC2CSettingsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            guildC2CSettingsViewModel = null;
        }
        this$0.Hi(it, Intrinsics.areEqual(bool, guildC2CSettingsViewModel.m2().getValue()), "em_sgrp_block_private");
    }

    private final Group oi() {
        GuildC2CSettingsViewModel guildC2CSettingsViewModel = this.vm;
        if (guildC2CSettingsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            guildC2CSettingsViewModel = null;
        }
        b bVar = new b(new x.b.a(guildC2CSettingsViewModel.h2(), ""), new x.c.g("", true, false, 4, null));
        bVar.R(new Function2<ImageView, String, Unit>() { // from class: com.tencent.mobileqq.guild.message.directmessage.fragment.GuildC2CSettingsFragment$createAvatarGroup$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(ImageView imageView, String str) {
                invoke2(imageView, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ImageView imageView, @NotNull String str) {
                Intrinsics.checkNotNullParameter(imageView, "imageView");
                Intrinsics.checkNotNullParameter(str, "<anonymous parameter 1>");
                ((IGuildQCircleAvatarApi) QRoute.api(IGuildQCircleAvatarApi.class)).loadAvatarByTinyId(GuildC2CSettingsFragment.this.sourceGuildId, GuildC2CSettingsFragment.this.targetTinyId, 3, imageView);
            }
        });
        bVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.message.directmessage.fragment.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildC2CSettingsFragment.pi(GuildC2CSettingsFragment.this, view);
            }
        });
        return new Group(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pi(GuildC2CSettingsFragment this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
            this$0.Di();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            ChannelSettingUtils.j(it, "em_sgrp_private_details_profile_pic", null, 4, null);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    private final Group qi() {
        com.tencent.mobileqq.widget.listitem.a<ac<V>> x16 = new c().x(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.message.directmessage.fragment.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildC2CSettingsFragment.ri(GuildC2CSettingsFragment.this, view);
            }
        });
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        return new Group(x16.l(viewLifecycleOwner, si()).d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ri(GuildC2CSettingsFragment this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        ChannelSettingUtils.j(it, "em_sgrp_private_delete", null, 4, null);
        this$0.Ti();
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QUIListItemAdapter si() {
        return (QUIListItemAdapter) this.adapter.getValue();
    }

    private final HashMap<String, Object> ti(GProGuildRobotInfoRsp robotInfoRsp) {
        HashMap<String, Object> hashMap = new HashMap<>();
        GProGuildRobotData robotData = robotInfoRsp.getRobotData();
        if (robotData != null) {
            hashMap.put("qq_robot_invite_state", Integer.valueOf(robotData.getShowInvite()));
            hashMap.put("qq_robot_robot_id", Long.valueOf(robotData.getRobotUin()));
        }
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        hashMap.put("qq_robot_role_type", Integer.valueOf(robotInfoRsp.getRole()));
        hashMap.put("qq_robot_user_from", "6");
        hashMap.put("qq_robot_robot_role_type", Integer.valueOf(robotInfoRsp.getRole()));
        hashMap.put("qq_robot_channel_id", this.guildId);
        hashMap.put("qq_robot_channel_name", "");
        hashMap.put("robot_import_source", 2);
        return hashMap;
    }

    private final ox1.i ui() {
        return (ox1.i) this.robotMoreSettingVm.getValue();
    }

    private final Map<String, Object> vi(boolean isChecked) {
        String str;
        Map<String, Object> mapOf;
        if (isChecked) {
            str = "1";
        } else {
            str = "2";
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_switch_type", str));
        return mapOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void zi(View view) {
        String str;
        VideoReport.addToDetectionWhitelist(getActivity());
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_channel_id", this.channelId);
        hashMap.put("sgrp_touin", this.targetTinyId);
        if (this.isRobot) {
            str = "2";
        } else {
            str = "1";
        }
        hashMap.put("sgrp_session_type", str);
        VideoReport.setPageId(view, "pg_sgrp_private_details");
        VideoReport.setPageParams(view, new PageParams(hashMap));
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.doOnCreateView(inflater, container, savedInstanceState);
        rh();
        setTitle("\u804a\u5929\u8bbe\u7f6e");
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f36;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        zi(view);
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    protected int ph() {
        return R.color.qui_common_bg_bottom_light;
    }
}
