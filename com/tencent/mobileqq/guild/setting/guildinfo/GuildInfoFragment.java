package com.tencent.mobileqq.guild.setting.guildinfo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.IGuildEmotionCodecApi;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.channel.managev2.utils.ChannelSettingUtils;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.facade.FacadeArgsData;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.report.Reporters;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.r;
import com.tencent.mobileqq.guild.setting.group.groupshow.GuildGroupChatShowFragment;
import com.tencent.mobileqq.guild.setting.guildinfo.GuildInfoDialogViewModel;
import com.tencent.mobileqq.guild.setting.guildmanage.avatar.QQGuildAvatarSettingFragment;
import com.tencent.mobileqq.guild.setting.guildmanage.profile.GuildProfileFragment;
import com.tencent.mobileqq.guild.setting.guildsetting.data.UpdateMemberDataEvent;
import com.tencent.mobileqq.guild.setting.guildsetting.fragment.GuildSettingQRCodeFragment;
import com.tencent.mobileqq.guild.setting.member.fragments.GuildMemberListFragment;
import com.tencent.mobileqq.guild.setting.member.view.topcard.GuildMemberLoopView;
import com.tencent.mobileqq.guild.util.GuildMedalUtils;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.bt;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.widget.GuildDefaultThemeNavBarCommon;
import com.tencent.mobileqq.guild.widget.GuildExpandableTextView;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedalInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildAuditBaseItem;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rz1.PageData;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00e6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u0095\u00012\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0002\u0096\u0001B\t\u00a2\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0016\u0010\u000e\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u001e\u0010\u001c\u001a\u00020\u00042\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u000b2\u0006\u0010\u001b\u001a\u00020\u0014H\u0002J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0018\u0010!\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u0014H\u0002J\b\u0010\"\u001a\u00020\u0004H\u0002J\b\u0010#\u001a\u00020\u0016H\u0014J\b\u0010$\u001a\u00020\u0016H\u0014J\b\u0010%\u001a\u00020\u0016H\u0014J$\u0010,\u001a\u00020\u00042\u0006\u0010'\u001a\u00020&2\b\u0010)\u001a\u0004\u0018\u00010(2\b\u0010+\u001a\u0004\u0018\u00010*H\u0014J\u001a\u0010-\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010+\u001a\u0004\u0018\u00010*H\u0016J\b\u0010.\u001a\u00020\u0004H\u0016J\u0012\u00101\u001a\u00020\u00042\b\u00100\u001a\u0004\u0018\u00010/H\u0016J\b\u00102\u001a\u00020\u0004H\u0016J\b\u00103\u001a\u00020\u0004H\u0016J\u0012\u00105\u001a\u00020\u00042\b\u00104\u001a\u0004\u0018\u00010\u0003H\u0016J$\u00109\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030706j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000307`8H\u0016J\b\u0010;\u001a\u00020:H\u0016R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010E\u001a\u00020@8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u0010BR\u0016\u0010G\u001a\u00020@8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bF\u0010BR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010M\u001a\u00020H8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bL\u0010JR\u0016\u0010O\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bN\u0010>R\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010U\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bT\u0010>R\u0016\u0010Y\u001a\u00020V8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010\\\u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010^\u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b]\u0010[R\u0016\u0010`\u001a\u00020H8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b_\u0010JR\u0016\u0010b\u001a\u00020H8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\ba\u0010JR\u0016\u0010f\u001a\u00020c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u0016\u0010h\u001a\u00020H8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bg\u0010JR\u0016\u0010l\u001a\u00020i8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010p\u001a\u00020m8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bn\u0010oR\u0016\u0010r\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bq\u0010>R\u0016\u0010t\u001a\u00020H8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bs\u0010JR\u0016\u0010v\u001a\u00020P8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bu\u0010RR\u0016\u0010z\u001a\u00020w8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bx\u0010yR\u0016\u0010|\u001a\u00020@8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b{\u0010BR\u0016\u0010~\u001a\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b}\u0010NR'\u0010\u0082\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u007f06j\b\u0012\u0004\u0012\u00020\u007f`88\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0018\u0010\u0084\u0001\u001a\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0083\u0001\u0010NR\u0019\u0010\u0087\u0001\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R\u001b\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\u001c\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008b\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R\u001c\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u008f\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001\u00a8\u0006\u0097\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildinfo/GuildInfoFragment;", "Lcom/tencent/mobileqq/guild/base/QQGuildTitleBarFragment;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "initData", "vi", "initView", "oi", "Lcom/tencent/mobileqq/guild/widget/GuildDefaultThemeNavBarCommon$a;", "di", "", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProUserInfo;", "userInfoList", "zi", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "xi", "", PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, "", "fi", "", "population", "ei", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProMedalInfo;", "medalInfoList", "name", "Ai", "Landroid/view/View;", "view", "gi", "elementId", SensorJsPlugin.SENSOR_INTERVAL_UI, "wi", "getContentLayoutId", "qh", "ph", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "initWindowStyleAndAnimation", "onFinish", "onDestroyView", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "", "onBackEvent", "Landroid/widget/LinearLayout;", "T", "Landroid/widget/LinearLayout;", "rootContainer", "Landroid/widget/ImageView;", "U", "Landroid/widget/ImageView;", "guildIcon", "V", "memberArrow", "W", "guildStrNumberIv", "Landroid/widget/TextView;", "X", "Landroid/widget/TextView;", "guildName", "Y", "guildStrNumber", "Z", "guildNumberContainer", "Lcom/tencent/mobileqq/guild/setting/member/view/topcard/GuildMemberLoopView;", "a0", "Lcom/tencent/mobileqq/guild/setting/member/view/topcard/GuildMemberLoopView;", "avatarList", "b0", "memberLly", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "c0", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "guildJoin", "d0", "Landroid/view/View;", "bottomSpace", "e0", "shadow", "f0", "guildMember", "g0", "guildProfileTitle", "Lcom/tencent/mobileqq/guild/widget/GuildExpandableTextView;", "h0", "Lcom/tencent/mobileqq/guild/widget/GuildExpandableTextView;", "guildProfileView", "i0", "guildRuleTitle", "Lcom/tencent/mobileqq/guild/setting/guildinfo/GuildRuleListView;", "j0", "Lcom/tencent/mobileqq/guild/setting/guildinfo/GuildRuleListView;", "guildRuleListView", "Lcom/tencent/mobileqq/guild/setting/guildinfo/GuildInfoDialogViewModel;", "k0", "Lcom/tencent/mobileqq/guild/setting/guildinfo/GuildInfoDialogViewModel;", "viewModel", "l0", "bindGroupLayout", "m0", "bindGroupNumber", "n0", "bindGroupAvatarList", "Landroidx/constraintlayout/widget/ConstraintLayout;", "o0", "Landroidx/constraintlayout/widget/ConstraintLayout;", "guildInfoLayout", "p0", "guildQrcode", "q0", "isPreview", "Lcom/tencent/mobileqq/guild/setting/guildinfo/ProfileRuleData;", "r0", "Ljava/util/ArrayList;", "profileRuleDatas", "s0", "hasRuleInit", "t0", "Ljava/lang/String;", "guildId", "u0", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "proGuildInfo", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "v0", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "facadeArgsData", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "w0", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "perfReportTask", "<init>", "()V", "x0", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildInfoFragment extends QQGuildTitleBarFragment implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: x0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: T, reason: from kotlin metadata */
    private LinearLayout rootContainer;

    /* renamed from: U, reason: from kotlin metadata */
    private ImageView guildIcon;

    /* renamed from: V, reason: from kotlin metadata */
    private ImageView memberArrow;

    /* renamed from: W, reason: from kotlin metadata */
    private ImageView guildStrNumberIv;

    /* renamed from: X, reason: from kotlin metadata */
    private TextView guildName;

    /* renamed from: Y, reason: from kotlin metadata */
    private TextView guildStrNumber;

    /* renamed from: Z, reason: from kotlin metadata */
    private LinearLayout guildNumberContainer;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private GuildMemberLoopView avatarList;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private LinearLayout memberLly;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private QUIButton guildJoin;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private View bottomSpace;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private View shadow;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private TextView guildMember;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private TextView guildProfileTitle;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private GuildExpandableTextView guildProfileView;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private TextView guildRuleTitle;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private GuildRuleListView guildRuleListView;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private GuildInfoDialogViewModel viewModel;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    private LinearLayout bindGroupLayout;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    private TextView bindGroupNumber;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    private GuildMemberLoopView bindGroupAvatarList;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    private ConstraintLayout guildInfoLayout;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    private ImageView guildQrcode;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    private boolean isPreview;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    private boolean hasRuleInit;

    /* renamed from: u0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IGProGuildInfo proGuildInfo;

    /* renamed from: v0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FacadeArgsData facadeArgsData;

    /* renamed from: w0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IPerformanceReportTask perfReportTask;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<ProfileRuleData> profileRuleDatas = new ArrayList<>();

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String guildId = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J.\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fR\u0014\u0010\u000f\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildinfo/GuildInfoFragment$a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "facadeArgsData", "", "a", "", "guildId", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/setting/guildinfo/ProfileRuleData;", "Lkotlin/collections/ArrayList;", "profileRuleDatas", "b", "PARAM_FACADE_ARGS_DATA", "Ljava/lang/String;", "PARAM_IS_PREVIEW", "PARAM_PREVIEW_RULES", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.setting.guildinfo.GuildInfoFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull FacadeArgsData facadeArgsData) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(facadeArgsData, "facadeArgsData");
            Intent intent = new Intent();
            intent.putExtra("param_facade_args_data", facadeArgsData);
            qw1.b.r(intent, Reporters.f231995a.b().a("guild_info").setAppChannel(com.tencent.mobileqq.guild.report.b.c()));
            GuildSplitViewUtils.p(GuildSplitViewUtils.f235370a, context, intent, GuildInfoFragment.class, null, 8, null);
        }

        public final void b(@NotNull Context context, @NotNull String guildId, @NotNull ArrayList<ProfileRuleData> profileRuleDatas) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(profileRuleDatas, "profileRuleDatas");
            Intent intent = new Intent();
            intent.putExtra("param_is_preview", true);
            intent.putExtra("extra_guild_id", guildId);
            intent.putParcelableArrayListExtra("param_preview_rules", profileRuleDatas);
            qw1.b.r(intent, Reporters.f231995a.b().a("guild_info").setAppChannel(com.tencent.mobileqq.guild.report.b.c()));
            QPublicFragmentActivity.b.b(context, intent, QPublicFragmentActivity.class, GuildInfoFragment.class);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/setting/guildinfo/GuildInfoFragment$b", "Lcom/tencent/mobileqq/guild/widget/GuildDefaultThemeNavBarCommon$a;", "Landroid/view/View;", "view", "", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "onItemSelect", "v", "", "onItemLongClick", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements GuildDefaultThemeNavBarCommon.a {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.widget.GuildDefaultThemeNavBarCommon.a
        public boolean onItemLongClick(@Nullable View v3, int item) {
            return false;
        }

        @Override // com.tencent.mobileqq.guild.widget.GuildDefaultThemeNavBarCommon.a
        public void onItemSelect(@NotNull View view, int item) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (item != 1) {
                if (item == 4) {
                    GuildInfoFragment guildInfoFragment = GuildInfoFragment.this;
                    if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard") && guildInfoFragment.getActivity() != null) {
                        guildInfoFragment.gi(view);
                        guildInfoFragment.ui(view, "em_sgrp_share");
                        return;
                    }
                    return;
                }
                return;
            }
            GuildInfoFragment guildInfoFragment2 = GuildInfoFragment.this;
            if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
                guildInfoFragment2.requireActivity().onBackPressed();
            }
        }
    }

    private final void Ai(List<? extends IGProMedalInfo> medalInfoList, final String name) {
        TextView textView = this.guildName;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildName");
            textView = null;
        }
        textView.setText(name);
        final List<IGProMedalInfo> s16 = GuildMedalUtils.s(new ArrayList(medalInfoList), medalInfoList.size());
        if (s16.isEmpty()) {
            return;
        }
        TextView textView3 = this.guildName;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildName");
        } else {
            textView2 = textView3;
        }
        textView2.post(new Runnable() { // from class: com.tencent.mobileqq.guild.setting.guildinfo.h
            @Override // java.lang.Runnable
            public final void run() {
                GuildInfoFragment.Bi(name, s16, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bi(String name, List validMediaList, GuildInfoFragment this$0) {
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

    private final GuildDefaultThemeNavBarCommon.a di() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String ei(int population) {
        boolean z16;
        String valueOf;
        double d16 = population;
        if (d16 < 10000.0d) {
            return population + "\u6210\u5458";
        }
        double d17 = d16 / 10000.0d;
        double d18 = d17 % 1;
        if (d18 == 0.0d) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && d18 >= 0.1d) {
            DecimalFormat decimalFormat = new DecimalFormat("#.#");
            decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
            decimalFormat.setMaximumFractionDigits(1);
            valueOf = decimalFormat.format(d17);
        } else {
            valueOf = String.valueOf((int) d17);
        }
        return valueOf + "\u4e07";
    }

    private final String fi(long timeStamp) {
        String format = new SimpleDateFormat("yyyy\u5e74M\u6708d\u65e5").format(new Date(timeStamp));
        Intrinsics.checkNotNullExpressionValue(format, "SimpleDateFormat(\"yyyy\u5e74M\u2026).format(Date(timeStamp))");
        return format;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void gi(View view) {
        if (com.tencent.mobileqq.guild.util.o.a(view)) {
            QLog.w("GuildInfoDialogFragment", 1, "handleGuildShareClick isFastClick, ignore!");
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            if (this.proGuildInfo == null) {
                QLog.w("GuildInfoDialogFragment", 1, "proGuildInfo is null");
                return;
            }
            IGProGuildInfo iGProGuildInfo = this.proGuildInfo;
            Intrinsics.checkNotNull(iGProGuildInfo);
            com.tencent.mobileqq.guild.share.m mVar = new com.tencent.mobileqq.guild.share.m(activity, iGProGuildInfo, null, GuildSharePageSource.GUILD_PROFILE);
            com.tencent.mobileqq.guild.share.util.c.c(mVar, 1);
            mVar.z();
            return;
        }
        QLog.w("GuildInfoDialogFragment", 1, "handleGuildShareClick activity:" + activity);
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

    private final void initData() {
        GuildInfoDialogViewModel a16 = GuildInfoDialogViewModel.INSTANCE.a(this, this.guildId);
        this.viewModel = a16;
        ConstraintLayout constraintLayout = null;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            a16 = null;
        }
        LiveData<IGProGuildInfo> a26 = a16.a2();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<IGProGuildInfo, Unit> function1 = new Function1<IGProGuildInfo, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildinfo.GuildInfoFragment$initData$1
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
                    GuildInfoFragment.this.xi(iGProGuildInfo);
                } else {
                    Logger.f235387a.d().w("GuildInfoDialogFragment", 1, "guildInfo is null, finish");
                    GuildInfoFragment.this.onBackEvent();
                }
            }
        };
        a26.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildinfo.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildInfoFragment.hi(Function1.this, obj);
            }
        });
        GuildMemberLoopView guildMemberLoopView = this.avatarList;
        if (guildMemberLoopView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarList");
            guildMemberLoopView = null;
        }
        guildMemberLoopView.setMaxAvatarCount(5);
        GuildMemberLoopView guildMemberLoopView2 = this.avatarList;
        if (guildMemberLoopView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarList");
            guildMemberLoopView2 = null;
        }
        guildMemberLoopView2.setGuildId(this.guildId);
        GuildMemberLoopView guildMemberLoopView3 = this.avatarList;
        if (guildMemberLoopView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarList");
            guildMemberLoopView3 = null;
        }
        guildMemberLoopView3.setLoadType(2);
        GuildMemberLoopView guildMemberLoopView4 = this.avatarList;
        if (guildMemberLoopView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarList");
            guildMemberLoopView4 = null;
        }
        guildMemberLoopView4.setAnimateEnable(false);
        GuildInfoDialogViewModel guildInfoDialogViewModel = this.viewModel;
        if (guildInfoDialogViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildInfoDialogViewModel = null;
        }
        LiveData<List<IGProUserInfo>> c26 = guildInfoDialogViewModel.c2();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<List<? extends IGProUserInfo>, Unit> function12 = new Function1<List<? extends IGProUserInfo>, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildinfo.GuildInfoFragment$initData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends IGProUserInfo> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends IGProUserInfo> memberList) {
                List<? extends IGProUserInfo> list = memberList;
                if (list == null || list.isEmpty()) {
                    Logger.f235387a.d().w("GuildInfoDialogFragment", 1, "memberList is null");
                    return;
                }
                GuildInfoFragment guildInfoFragment = GuildInfoFragment.this;
                Intrinsics.checkNotNullExpressionValue(memberList, "memberList");
                guildInfoFragment.zi(memberList);
            }
        };
        c26.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildinfo.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildInfoFragment.ii(Function1.this, obj);
            }
        });
        GuildInfoDialogViewModel guildInfoDialogViewModel2 = this.viewModel;
        if (guildInfoDialogViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildInfoDialogViewModel2 = null;
        }
        LiveData<List<String>> b26 = guildInfoDialogViewModel2.b2();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        final Function1<List<? extends String>, Unit> function13 = new Function1<List<? extends String>, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildinfo.GuildInfoFragment$initData$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list) {
                invoke2((List<String>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<String> avatarMetas) {
                GuildMemberLoopView guildMemberLoopView5;
                List<String> list = avatarMetas;
                if (!(list == null || list.isEmpty())) {
                    guildMemberLoopView5 = GuildInfoFragment.this.avatarList;
                    if (guildMemberLoopView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("avatarList");
                        guildMemberLoopView5 = null;
                    }
                    Intrinsics.checkNotNullExpressionValue(avatarMetas, "avatarMetas");
                    GuildMemberLoopView.J(guildMemberLoopView5, avatarMetas, false, 2, null);
                    return;
                }
                Logger.f235387a.d().w("GuildInfoDialogFragment", 1, "avatarMetas is null");
            }
        };
        b26.observe(viewLifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildinfo.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildInfoFragment.ji(Function1.this, obj);
            }
        });
        GuildInfoDialogViewModel guildInfoDialogViewModel3 = this.viewModel;
        if (guildInfoDialogViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildInfoDialogViewModel3 = null;
        }
        LiveData<Boolean> g26 = guildInfoDialogViewModel3.g2();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function14 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildinfo.GuildInfoFragment$initData$4
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
            public final void invoke2(Boolean isExitGuild) {
                Intrinsics.checkNotNullExpressionValue(isExitGuild, "isExitGuild");
                if (isExitGuild.booleanValue()) {
                    Logger.f235387a.d().w("GuildInfoDialogFragment", 1, "isExitGuild, finish");
                    GuildInfoFragment.this.onBackEvent();
                }
            }
        };
        g26.observe(viewLifecycleOwner4, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildinfo.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildInfoFragment.ki(Function1.this, obj);
            }
        });
        GuildInfoDialogViewModel guildInfoDialogViewModel4 = this.viewModel;
        if (guildInfoDialogViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildInfoDialogViewModel4 = null;
        }
        LiveData<Integer> e26 = guildInfoDialogViewModel4.e2();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        final Function1<Integer, Unit> function15 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildinfo.GuildInfoFragment$initData$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer cnt) {
                TextView textView;
                String ei5;
                Intrinsics.checkNotNullExpressionValue(cnt, "cnt");
                int intValue = cnt.intValue();
                boolean z16 = false;
                if (1 <= intValue && intValue < 10000) {
                    z16 = true;
                }
                if (z16) {
                    textView = GuildInfoFragment.this.guildMember;
                    if (textView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("guildMember");
                        textView = null;
                    }
                    ei5 = GuildInfoFragment.this.ei(cnt.intValue());
                    textView.setText(ei5);
                }
            }
        };
        e26.observe(viewLifecycleOwner5, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildinfo.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildInfoFragment.li(Function1.this, obj);
            }
        });
        GuildInfoDialogViewModel guildInfoDialogViewModel5 = this.viewModel;
        if (guildInfoDialogViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildInfoDialogViewModel5 = null;
        }
        MutableLiveData<GuildInfoDialogViewModel.RelativeGroupShowItem> d26 = guildInfoDialogViewModel5.d2();
        final Function1<GuildInfoDialogViewModel.RelativeGroupShowItem, Unit> function16 = new Function1<GuildInfoDialogViewModel.RelativeGroupShowItem, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildinfo.GuildInfoFragment$initData$6
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GuildInfoDialogViewModel.RelativeGroupShowItem relativeGroupShowItem) {
                invoke2(relativeGroupShowItem);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GuildInfoDialogViewModel.RelativeGroupShowItem relativeGroupShowItem) {
                LinearLayout linearLayout;
                TextView textView;
                GuildMemberLoopView guildMemberLoopView5;
                int collectionSizeOrDefault;
                IPerformanceReportTask iPerformanceReportTask;
                IPerformanceReportTask iPerformanceReportTask2;
                IPerformanceReportTask iPerformanceReportTask3;
                String str;
                linearLayout = GuildInfoFragment.this.bindGroupLayout;
                if (linearLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bindGroupLayout");
                    linearLayout = null;
                }
                boolean z16 = false;
                linearLayout.setVisibility(relativeGroupShowItem.getIsShow() ? 0 : 8);
                textView = GuildInfoFragment.this.bindGroupNumber;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bindGroupNumber");
                    textView = null;
                }
                textView.setText(relativeGroupShowItem.a().size() + "\u4e2a");
                guildMemberLoopView5 = GuildInfoFragment.this.bindGroupAvatarList;
                if (guildMemberLoopView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bindGroupAvatarList");
                    guildMemberLoopView5 = null;
                }
                List<Long> a17 = relativeGroupShowItem.a();
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(a17, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = a17.iterator();
                while (it.hasNext()) {
                    arrayList.add(String.valueOf(((Number) it.next()).longValue()));
                }
                GuildMemberLoopView.J(guildMemberLoopView5, arrayList, false, 2, null);
                iPerformanceReportTask = GuildInfoFragment.this.perfReportTask;
                if (iPerformanceReportTask != null && !iPerformanceReportTask.getIsReported()) {
                    z16 = true;
                }
                if (z16) {
                    iPerformanceReportTask2 = GuildInfoFragment.this.perfReportTask;
                    if (iPerformanceReportTask2 != null) {
                        str = GuildInfoFragment.this.guildId;
                        iPerformanceReportTask2.setParam("guild_id", str);
                    }
                    iPerformanceReportTask3 = GuildInfoFragment.this.perfReportTask;
                    if (iPerformanceReportTask3 != null) {
                        qw1.b.n(iPerformanceReportTask3);
                    }
                }
            }
        };
        d26.observe(this, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildinfo.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildInfoFragment.mi(Function1.this, obj);
            }
        });
        SimpleEventBus.getInstance().registerReceiver(this);
        if (r.p().getGuildPermission(this.guildId).a(10001) && !this.isPreview) {
            ConstraintLayout constraintLayout2 = this.guildInfoLayout;
            if (constraintLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildInfoLayout");
                constraintLayout2 = null;
            }
            constraintLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildinfo.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildInfoFragment.ni(GuildInfoFragment.this, view);
                }
            });
            IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
            ConstraintLayout constraintLayout3 = this.guildInfoLayout;
            if (constraintLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildInfoLayout");
            } else {
                constraintLayout = constraintLayout3;
            }
            iGuildDTReportApi.setElementExposureAllAndClickPolicy(constraintLayout, "em_sgrp_channel_set_channel_profile");
        }
    }

    private final void initView() {
        View findViewById = this.P.findViewById(R.id.f782746m);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewById(R.id.rootContainer)");
        this.rootContainer = (LinearLayout) findViewById;
        View findViewById2 = this.P.findViewById(R.id.f165417vw2);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mContentView.findViewById(R.id.guildIcon)");
        this.guildIcon = (ImageView) findViewById2;
        View findViewById3 = this.P.findViewById(R.id.vw7);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mContentView.findViewById(R.id.guildName)");
        this.guildName = (TextView) findViewById3;
        View findViewById4 = this.P.findViewById(R.id.vwc);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mContentView.findViewById(R.id.guildStrNumber)");
        this.guildStrNumber = (TextView) findViewById4;
        View findViewById5 = this.P.findViewById(R.id.vw8);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "mContentView.findViewByI\u2026.id.guildNumberContainer)");
        this.guildNumberContainer = (LinearLayout) findViewById5;
        View findViewById6 = this.P.findViewById(R.id.z1e);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "mContentView.findViewById(R.id.memberLly)");
        this.memberLly = (LinearLayout) findViewById6;
        View findViewById7 = this.P.findViewById(R.id.t0q);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "mContentView.findViewById(R.id.avatarList)");
        this.avatarList = (GuildMemberLoopView) findViewById7;
        View findViewById8 = this.P.findViewById(R.id.iql);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "mContentView.findViewById(R.id.shadow)");
        this.shadow = findViewById8;
        View findViewById9 = this.P.findViewById(R.id.vw5);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "mContentView.findViewById(R.id.guildJoin)");
        this.guildJoin = (QUIButton) findViewById9;
        View findViewById10 = this.P.findViewById(R.id.t9x);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "mContentView.findViewById(R.id.bottomSpace)");
        this.bottomSpace = findViewById10;
        View findViewById11 = this.P.findViewById(R.id.vw6);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "mContentView.findViewById(R.id.guildMember)");
        this.guildMember = (TextView) findViewById11;
        View findViewById12 = this.P.findViewById(R.id.vw9);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "mContentView.findViewById(R.id.guildProfileTitle)");
        this.guildProfileTitle = (TextView) findViewById12;
        View findViewById13 = this.P.findViewById(R.id.vw_);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "mContentView.findViewById(R.id.guildProfileView)");
        this.guildProfileView = (GuildExpandableTextView) findViewById13;
        View findViewById14 = this.P.findViewById(R.id.vwb);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "mContentView.findViewById(R.id.guildRuleTitle)");
        this.guildRuleTitle = (TextView) findViewById14;
        View findViewById15 = this.P.findViewById(R.id.f786247k);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "mContentView.findViewById(R.id.ruleList)");
        this.guildRuleListView = (GuildRuleListView) findViewById15;
        View findViewById16 = this.P.findViewById(R.id.z1c);
        Intrinsics.checkNotNullExpressionValue(findViewById16, "mContentView.findViewById(R.id.memberArrow)");
        this.memberArrow = (ImageView) findViewById16;
        View findViewById17 = this.P.findViewById(R.id.vwd);
        Intrinsics.checkNotNullExpressionValue(findViewById17, "mContentView.findViewById(R.id.guildStrNumberIv)");
        this.guildStrNumberIv = (ImageView) findViewById17;
        View findViewById18 = this.P.findViewById(R.id.f165419vw4);
        Intrinsics.checkNotNullExpressionValue(findViewById18, "mContentView.findViewById(R.id.guildInfoLayout)");
        this.guildInfoLayout = (ConstraintLayout) findViewById18;
        View findViewById19 = this.P.findViewById(R.id.vwa);
        Intrinsics.checkNotNullExpressionValue(findViewById19, "mContentView.findViewById(R.id.guildQrcode)");
        ImageView imageView = (ImageView) findViewById19;
        this.guildQrcode = imageView;
        View view = null;
        if (this.isPreview) {
            ImageView imageView2 = this.guildStrNumberIv;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildStrNumberIv");
                imageView2 = null;
            }
            imageView2.setVisibility(8);
        } else {
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildQrcode");
                imageView = null;
            }
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildinfo.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    GuildInfoFragment.ri(GuildInfoFragment.this, view2);
                }
            });
            ImageView imageView3 = this.guildStrNumberIv;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildStrNumberIv");
                imageView3 = null;
            }
            Context context = this.P.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "mContentView.context");
            imageView3.setImageDrawable(GuildUIUtils.y(context, R.drawable.qui_copy, QQGuildUIUtil.i(this.P.getContext(), R.color.qui_common_text_secondary)));
            LinearLayout linearLayout = this.guildNumberContainer;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildNumberContainer");
                linearLayout = null;
            }
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildinfo.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    GuildInfoFragment.si(GuildInfoFragment.this, view2);
                }
            });
        }
        ImageView imageView4 = this.guildIcon;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildIcon");
            imageView4 = null;
        }
        imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildinfo.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GuildInfoFragment.ti(GuildInfoFragment.this, view2);
            }
        });
        QUIButton qUIButton = this.guildJoin;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildJoin");
            qUIButton = null;
        }
        qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildinfo.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GuildInfoFragment.qi(GuildInfoFragment.this, view2);
            }
        });
        Context context2 = this.P.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "mContentView.context");
        Drawable y16 = GuildUIUtils.y(context2, R.drawable.qui_chevron_up, QQGuildUIUtil.i(this.P.getContext(), R.color.qui_common_text_link));
        Context context3 = this.P.getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "mContentView.context");
        Drawable y17 = GuildUIUtils.y(context3, R.drawable.qui_chevron_down, QQGuildUIUtil.i(this.P.getContext(), R.color.qui_common_text_link));
        GuildExpandableTextView guildExpandableTextView = this.guildProfileView;
        if (guildExpandableTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildProfileView");
            guildExpandableTextView = null;
        }
        guildExpandableTextView.setCollapseDrawable(y16);
        GuildExpandableTextView guildExpandableTextView2 = this.guildProfileView;
        if (guildExpandableTextView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildProfileView");
            guildExpandableTextView2 = null;
        }
        guildExpandableTextView2.setExpandDrawable(y17);
        View view2 = this.shadow;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shadow");
        } else {
            view = view2;
        }
        view.setBackground(GuildUIUtils.f235378a.i(getResources().getColor(R.color.qui_common_bg_bottom_light), getResources().getColor(R.color.ajr), 255));
        oi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ji(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ki(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void li(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ni(GuildInfoFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GuildProfileFragment.Companion companion = GuildProfileFragment.INSTANCE;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "it.context");
        companion.a(context, this$0.guildId);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void oi() {
        View findViewById = this.P.findViewById(R.id.f165416vw1);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewByI\u2026.id.guildBindGroupLayout)");
        LinearLayout linearLayout = (LinearLayout) findViewById;
        this.bindGroupLayout = linearLayout;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindGroupLayout");
            linearLayout = null;
        }
        TextView textView = (TextView) linearLayout.findViewById(R.id.f110166hs);
        LinearLayout linearLayout3 = this.bindGroupLayout;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindGroupLayout");
            linearLayout3 = null;
        }
        View findViewById2 = linearLayout3.findViewById(R.id.t0q);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "bindGroupLayout.findView\u2026oopView>(R.id.avatarList)");
        this.bindGroupAvatarList = (GuildMemberLoopView) findViewById2;
        LinearLayout linearLayout4 = this.bindGroupLayout;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindGroupLayout");
            linearLayout4 = null;
        }
        View findViewById3 = linearLayout4.findViewById(R.id.f109236f_);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "bindGroupLayout.findView\u2026TextView>(R.id.tv_member)");
        this.bindGroupNumber = (TextView) findViewById3;
        textView.setText(getString(R.string.f146360tz));
        GuildMemberLoopView guildMemberLoopView = this.bindGroupAvatarList;
        if (guildMemberLoopView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindGroupAvatarList");
            guildMemberLoopView = null;
        }
        guildMemberLoopView.setLoadType(3);
        GuildMemberLoopView guildMemberLoopView2 = this.bindGroupAvatarList;
        if (guildMemberLoopView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindGroupAvatarList");
            guildMemberLoopView2 = null;
        }
        guildMemberLoopView2.setMaxAvatarCount(5);
        GuildMemberLoopView guildMemberLoopView3 = this.bindGroupAvatarList;
        if (guildMemberLoopView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindGroupAvatarList");
            guildMemberLoopView3 = null;
        }
        guildMemberLoopView3.setGuildId(this.guildId);
        GuildMemberLoopView guildMemberLoopView4 = this.bindGroupAvatarList;
        if (guildMemberLoopView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindGroupAvatarList");
            guildMemberLoopView4 = null;
        }
        guildMemberLoopView4.setAnimateEnable(false);
        LinearLayout linearLayout5 = this.bindGroupLayout;
        if (linearLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindGroupLayout");
            linearLayout5 = null;
        }
        linearLayout5.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildinfo.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildInfoFragment.pi(GuildInfoFragment.this, view);
            }
        });
        LinearLayout linearLayout6 = this.bindGroupLayout;
        if (linearLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindGroupLayout");
            linearLayout6 = null;
        }
        VideoReport.setElementId(linearLayout6, "em_sgrp_group");
        LinearLayout linearLayout7 = this.bindGroupLayout;
        if (linearLayout7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindGroupLayout");
            linearLayout7 = null;
        }
        VideoReport.setElementExposePolicy(linearLayout7, ExposurePolicy.REPORT_ALL);
        LinearLayout linearLayout8 = this.bindGroupLayout;
        if (linearLayout8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindGroupLayout");
        } else {
            linearLayout2 = linearLayout8;
        }
        VideoReport.setElementClickPolicy(linearLayout2, ClickPolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pi(GuildInfoFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getContext();
        if (context != null) {
            GuildGroupChatShowFragment.Companion companion = GuildGroupChatShowFragment.INSTANCE;
            FacadeArgsData facadeArgsData = this$0.facadeArgsData;
            Intrinsics.checkNotNull(facadeArgsData);
            companion.a(context, facadeArgsData);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qi(GuildInfoFragment this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.mobileqq.guild.util.o.a(it)) {
            Context requireContext = this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            FacadeArgsData facadeArgsData = this$0.facadeArgsData;
            Intrinsics.checkNotNull(facadeArgsData);
            com.tencent.mobileqq.guild.channel.joinchannel.q.d(requireContext, facadeArgsData, false, 1, new Function1<IGProJoinGuildResult, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildinfo.GuildInfoFragment$initView$4$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull IGProJoinGuildResult it5) {
                    Intrinsics.checkNotNullParameter(it5, "it");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(IGProJoinGuildResult iGProJoinGuildResult) {
                    invoke2(iGProJoinGuildResult);
                    return Unit.INSTANCE;
                }
            });
            Intrinsics.checkNotNullExpressionValue(it, "it");
            this$0.ui(it, "em_sgrp_bottom_join_channel");
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ri(GuildInfoFragment this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GuildSettingQRCodeFragment.Companion companion = GuildSettingQRCodeFragment.INSTANCE;
        Context context = it.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "it.context");
        companion.a(context, this$0.guildId);
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.ui(it, "em_sgrp_channel_code_qr");
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void si(GuildInfoFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.mobileqq.guild.util.o.a(view)) {
            String guildNumber = ch.L(this$0.guildId).getGuildNumber();
            if (guildNumber == null) {
                guildNumber = "";
            }
            com.tencent.mobileqq.guild.util.b.a(guildNumber);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ti(GuildInfoFragment this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQGuildAvatarSettingFragment.Rh(this$0.getActivity(), this$0.proGuildInfo, 0);
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.ui(it, "em_sgrp_head");
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ui(View view, String elementId) {
        VideoReport.setElementId(view, elementId);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("clck", view, null);
    }

    private final void vi() {
        FacadeArgsData facadeArgsData;
        String str;
        Intent intent = requireActivity().getIntent();
        boolean z16 = false;
        boolean booleanExtra = intent.getBooleanExtra("param_is_preview", false);
        this.isPreview = booleanExtra;
        String str2 = "";
        IPerformanceReportTask iPerformanceReportTask = null;
        if (booleanExtra) {
            String stringExtra = intent.getStringExtra("extra_guild_id");
            if (stringExtra != null) {
                str2 = stringExtra;
            }
            this.guildId = str2;
            ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("param_preview_rules");
            this.profileRuleDatas.clear();
            if (parcelableArrayListExtra == null || parcelableArrayListExtra.isEmpty()) {
                z16 = true;
            }
            if (!z16) {
                this.profileRuleDatas.addAll(parcelableArrayListExtra);
            }
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                facadeArgsData = (FacadeArgsData) arguments.getParcelable("param_facade_args_data");
            } else {
                facadeArgsData = null;
            }
            this.facadeArgsData = facadeArgsData;
            if (facadeArgsData != null) {
                str = facadeArgsData.f227656e;
            } else {
                str = null;
            }
            if (str != null) {
                str2 = str;
            }
            this.guildId = str2;
        }
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            iPerformanceReportTask = qw1.b.g(arguments2, null, 1, null);
        }
        this.perfReportTask = iPerformanceReportTask;
    }

    private final void wi() {
        String str;
        int i3;
        Bundle bundle;
        VideoReport.addToDetectionWhitelist(getActivity());
        HashMap hashMap = new HashMap();
        hashMap.putAll(com.tencent.mobileqq.guild.report.b.d());
        FacadeArgsData facadeArgsData = this.facadeArgsData;
        if (facadeArgsData == null || (bundle = facadeArgsData.C) == null || (str = bundle.getString(JumpGuildParam.EXTRA_KEY_TRACE_ID)) == null) {
            str = "";
        }
        hashMap.put(JumpGuildParam.EXTRA_KEY_TRACE_ID, str);
        if (this.isPreview) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        hashMap.put("sgrp_pg_status", Integer.valueOf(i3));
        VideoReport.setPageId(this.N, "pg_sgrp_channel_info_float");
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(this.N, this.guildId, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0047, code lost:
    
        if (r2 == false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void xi(final IGProGuildInfo guildInfo) {
        boolean z16;
        boolean z17;
        boolean z18;
        GuildExpandableTextView guildExpandableTextView;
        List<ProfileRuleData> arrayList;
        int collectionSizeOrDefault;
        boolean z19;
        String str;
        GuildRuleListView guildRuleListView;
        String str2;
        boolean equals$default;
        boolean z26;
        if (guildInfo.getIsBanned()) {
            Logger.f235387a.d().w("GuildInfoDialogFragment", 1, "guildInfo is isBanned, finish");
            onBackEvent();
        }
        IGProGuildInfo iGProGuildInfo = this.proGuildInfo;
        if (iGProGuildInfo != null) {
            if (iGProGuildInfo != null) {
                str2 = iGProGuildInfo.getGuildName();
            } else {
                str2 = null;
            }
            equals$default = StringsKt__StringsJVMKt.equals$default(str2, guildInfo.getGuildName(), false, 2, null);
            if (equals$default) {
                IGProGuildInfo iGProGuildInfo2 = this.proGuildInfo;
                if (iGProGuildInfo2 != null && iGProGuildInfo2.isMember() == guildInfo.isMember()) {
                    z26 = true;
                } else {
                    z26 = false;
                }
            }
        }
        ArrayList<IGProMedalInfo> medalInfoList = guildInfo.getMedalInfoList();
        Intrinsics.checkNotNullExpressionValue(medalInfoList, "guildInfo.medalInfoList");
        String guildName = guildInfo.getGuildName();
        Intrinsics.checkNotNullExpressionValue(guildName, "guildInfo.guildName");
        Ai(medalInfoList, guildName);
        this.proGuildInfo = guildInfo;
        String avatarUrl = guildInfo.getAvatarUrl(100);
        Intrinsics.checkNotNullExpressionValue(avatarUrl, "guildInfo.getAvatarUrl(I\u2026ldAvatarUrlType.SIZE_100)");
        LinearLayout linearLayout = this.bindGroupLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindGroupLayout");
            linearLayout = null;
        }
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.z1c);
        if (TextUtils.isEmpty(avatarUrl)) {
            ImageView imageView2 = this.guildIcon;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildIcon");
                imageView2 = null;
            }
            imageView2.setVisibility(8);
        } else {
            ImageView imageView3 = this.guildIcon;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildIcon");
                imageView3 = null;
            }
            imageView3.setVisibility(0);
            Drawable J = ch.J(avatarUrl, Utils.n(68.0f, getResources()), BaseImageUtil.getDefaultFaceDrawable(false), false);
            ImageView imageView4 = this.guildIcon;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildIcon");
                imageView4 = null;
            }
            imageView4.setImageDrawable(J);
        }
        TextView textView = this.guildStrNumber;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildStrNumber");
            textView = null;
        }
        textView.setText("\u9891\u9053\u53f7\uff1a" + guildInfo.getGuildNumber());
        View view = this.shadow;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shadow");
            view = null;
        }
        if (!guildInfo.isMember() && !this.isPreview) {
            z16 = false;
        } else {
            z16 = true;
        }
        Boolean valueOf = Boolean.valueOf(z16);
        view.setVisibility(8);
        if (((View) com.tencent.guild.aio.util.ex.g.a(valueOf, view)) == null) {
            view.setVisibility(0);
        }
        QUIButton qUIButton = this.guildJoin;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildJoin");
            qUIButton = null;
        }
        if (!guildInfo.isMember() && !this.isPreview) {
            z17 = false;
        } else {
            z17 = true;
        }
        Boolean valueOf2 = Boolean.valueOf(z17);
        qUIButton.setVisibility(8);
        if (((View) com.tencent.guild.aio.util.ex.g.a(valueOf2, qUIButton)) == null) {
            qUIButton.setVisibility(0);
        }
        View view2 = this.bottomSpace;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomSpace");
            view2 = null;
        }
        if (!guildInfo.isMember() && !this.isPreview) {
            z18 = false;
        } else {
            z18 = true;
        }
        Boolean valueOf3 = Boolean.valueOf(z18);
        view2.setVisibility(8);
        if (((View) com.tencent.guild.aio.util.ex.g.a(valueOf3, view2)) == null) {
            view2.setVisibility(0);
        }
        TextView textView2 = this.guildMember;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildMember");
            textView2 = null;
        }
        textView2.setText(ei(guildInfo.getUserNum()));
        if (guildInfo.isMember() && !this.isPreview) {
            LinearLayout linearLayout2 = this.memberLly;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("memberLly");
                linearLayout2 = null;
            }
            linearLayout2.setClickable(true);
            ImageView imageView5 = this.memberArrow;
            if (imageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("memberArrow");
                imageView5 = null;
            }
            imageView5.setVisibility(0);
            imageView.setVisibility(0);
            LinearLayout linearLayout3 = this.bindGroupLayout;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bindGroupLayout");
                linearLayout3 = null;
            }
            linearLayout3.setClickable(true);
            LinearLayout linearLayout4 = this.memberLly;
            if (linearLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("memberLly");
                linearLayout4 = null;
            }
            linearLayout4.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildinfo.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    GuildInfoFragment.yi(GuildInfoFragment.this, guildInfo, view3);
                }
            });
        } else {
            QUIButton qUIButton2 = this.guildJoin;
            if (qUIButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildJoin");
                qUIButton2 = null;
            }
            ChannelSettingUtils.h(qUIButton2, "em_sgrp_bottom_join_channel", null, 4, null);
            LinearLayout linearLayout5 = this.memberLly;
            if (linearLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("memberLly");
                linearLayout5 = null;
            }
            linearLayout5.setClickable(false);
            ImageView imageView6 = this.memberArrow;
            if (imageView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("memberArrow");
                imageView6 = null;
            }
            imageView6.setVisibility(8);
            imageView.setVisibility(8);
            LinearLayout linearLayout6 = this.bindGroupLayout;
            if (linearLayout6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bindGroupLayout");
                linearLayout6 = null;
            }
            linearLayout6.setClickable(false);
        }
        if (!this.hasRuleInit) {
            this.hasRuleInit = true;
            if (this.isPreview) {
                arrayList = this.profileRuleDatas;
            } else if (guildInfo.getUint32GuildRuleChangeTime() == 0) {
                PageData.Companion companion = PageData.INSTANCE;
                arrayList = CollectionsKt__CollectionsJVMKt.listOf(new ProfileRuleData(companion.a().getFirst(), companion.a().getSecond(), false, 4, null));
            } else {
                ArrayList<GProGuildAuditBaseItem> guildRules = guildInfo.getGuildRules();
                Intrinsics.checkNotNullExpressionValue(guildRules, "guildInfo.guildRules");
                ArrayList<GProGuildAuditBaseItem> arrayList2 = new ArrayList();
                for (Object obj : guildRules) {
                    if (((GProGuildAuditBaseItem) obj).status == 1) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    if (z19) {
                        arrayList2.add(obj);
                    }
                }
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
                arrayList = new ArrayList<>(collectionSizeOrDefault);
                for (GProGuildAuditBaseItem gProGuildAuditBaseItem : arrayList2) {
                    String byteAuditTitleStr = gProGuildAuditBaseItem.getByteAuditTitleStr();
                    Intrinsics.checkNotNullExpressionValue(byteAuditTitleStr, "it.getByteAuditTitleStr()");
                    arrayList.add(new ProfileRuleData(byteAuditTitleStr, gProGuildAuditBaseItem.auditContentStr, false, 4, null));
                }
            }
            if (arrayList.isEmpty()) {
                TextView textView3 = this.guildRuleTitle;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("guildRuleTitle");
                    textView3 = null;
                }
                textView3.setVisibility(8);
                GuildRuleListView guildRuleListView2 = this.guildRuleListView;
                if (guildRuleListView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("guildRuleListView");
                    guildRuleListView2 = null;
                }
                guildRuleListView2.setVisibility(8);
            } else {
                TextView textView4 = this.guildRuleTitle;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("guildRuleTitle");
                    textView4 = null;
                }
                textView4.setVisibility(0);
                GuildRuleListView guildRuleListView3 = this.guildRuleListView;
                if (guildRuleListView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("guildRuleListView");
                    guildRuleListView3 = null;
                }
                guildRuleListView3.setVisibility(0);
                GuildRuleListView guildRuleListView4 = this.guildRuleListView;
                if (guildRuleListView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("guildRuleListView");
                    guildRuleListView4 = null;
                }
                guildRuleListView4.setRules(arrayList);
                TextView textView5 = this.guildRuleTitle;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("guildRuleTitle");
                    textView5 = null;
                }
                if (this.isPreview) {
                    str = "\u9891\u9053\u89c4\u5219 \u00b7 \u66f4\u65b0\u4e8e" + fi(System.currentTimeMillis());
                } else if (guildInfo.getUint32GuildRuleChangeTime() == 0) {
                    str = "\u9891\u9053\u89c4\u5219";
                } else {
                    str = "\u9891\u9053\u89c4\u5219 \u00b7 \u66f4\u65b0\u4e8e" + fi(guildInfo.getUint32GuildRuleChangeTime() * 1000);
                }
                textView5.setText(str);
                bt btVar = bt.f235484a;
                GuildRuleListView guildRuleListView5 = this.guildRuleListView;
                if (guildRuleListView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("guildRuleListView");
                    guildRuleListView = null;
                } else {
                    guildRuleListView = guildRuleListView5;
                }
                bt.h(btVar, guildRuleListView, "em_sgrp_channel_rule", "imp", null, 8, null);
            }
        }
        boolean isEmpty = TextUtils.isEmpty(guildInfo.getProfile());
        TextView textView6 = this.guildProfileTitle;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildProfileTitle");
            textView6 = null;
        }
        Boolean valueOf4 = Boolean.valueOf(isEmpty);
        textView6.setVisibility(8);
        if (((View) com.tencent.guild.aio.util.ex.g.a(valueOf4, textView6)) == null) {
            textView6.setVisibility(0);
        }
        GuildExpandableTextView guildExpandableTextView2 = this.guildProfileView;
        if (guildExpandableTextView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildProfileView");
            guildExpandableTextView2 = null;
        }
        Boolean valueOf5 = Boolean.valueOf(isEmpty);
        guildExpandableTextView2.setVisibility(8);
        if (((View) com.tencent.guild.aio.util.ex.g.a(valueOf5, guildExpandableTextView2)) == null) {
            guildExpandableTextView2.setVisibility(0);
        }
        if (!isEmpty) {
            TextView textView7 = this.guildRuleTitle;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildRuleTitle");
                textView7 = null;
            }
            if (textView7.getVisibility() == 8) {
                GuildExpandableTextView guildExpandableTextView3 = this.guildProfileView;
                if (guildExpandableTextView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("guildProfileView");
                    guildExpandableTextView3 = null;
                }
                guildExpandableTextView3.setMaxHeight(Integer.MAX_VALUE);
            } else {
                GuildExpandableTextView guildExpandableTextView4 = this.guildProfileView;
                if (guildExpandableTextView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("guildProfileView");
                    guildExpandableTextView4 = null;
                }
                guildExpandableTextView4.setMaxHeight(7);
            }
            GuildExpandableTextView guildExpandableTextView5 = this.guildProfileView;
            if (guildExpandableTextView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildProfileView");
                guildExpandableTextView = null;
            } else {
                guildExpandableTextView = guildExpandableTextView5;
            }
            guildExpandableTextView.setContextText(((IGuildEmotionCodecApi) QRoute.api(IGuildEmotionCodecApi.class)).toQQText(guildInfo.getProfile(), 20));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yi(GuildInfoFragment this$0, IGProGuildInfo guildInfo, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(guildInfo, "$guildInfo");
        com.tencent.mobileqq.guild.performance.report.o.c();
        Context context = this$0.getContext();
        if (context != null) {
            GuildMemberListFragment.INSTANCE.c(context, guildInfo, "");
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.ui(it, "em_sgrp_cover_member_list");
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zi(List<? extends IGProUserInfo> userInfoList) {
        List take;
        ArrayList arrayList = new ArrayList();
        if (userInfoList.size() >= 5) {
            take = CollectionsKt___CollectionsKt.take(userInfoList, 5);
            Iterator it = take.iterator();
            while (it.hasNext()) {
                arrayList.add(((IGProUserInfo) it.next()).getAvatarMeta());
            }
        } else {
            Iterator<T> it5 = userInfoList.iterator();
            while (it5.hasNext()) {
                arrayList.add(((IGProUserInfo) it5.next()).getAvatarMeta());
            }
        }
        GuildMemberLoopView guildMemberLoopView = this.avatarList;
        if (guildMemberLoopView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarList");
            guildMemberLoopView = null;
        }
        GuildMemberLoopView.J(guildMemberLoopView, arrayList, false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        super.doOnCreateView(inflater, container, savedInstanceState);
        vi();
        initView();
        initData();
        wi();
        GuildSplitViewUtils.f235370a.B(this.N);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f168108ev0;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(UpdateMemberDataEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(@Nullable Activity activity) {
        if (activity != null) {
            activity.overridePendingTransition(R.anim.f154424l, R.anim.f154442w);
        }
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        return GuildSplitViewUtils.u(GuildSplitViewUtils.f235370a, getActivity(), false, 2, null);
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        this.proGuildInfo = null;
        this.hasRuleInit = false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        super.onFinish();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.overridePendingTransition(R.anim.f154442w, R.anim.f154423k);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        GuildInfoDialogViewModel guildInfoDialogViewModel;
        if ((event instanceof UpdateMemberDataEvent) && (guildInfoDialogViewModel = this.viewModel) != null) {
            if (guildInfoDialogViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                guildInfoDialogViewModel = null;
            }
            guildInfoDialogViewModel.W1(100, true);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        ViewGroup viewGroup;
        super.onResume();
        GuildSplitViewUtils guildSplitViewUtils = GuildSplitViewUtils.f235370a;
        if (guildSplitViewUtils.n(getActivity())) {
            guildSplitViewUtils.A(getActivity(), this.N, R.drawable.qui_common_bg_bottom_light_bg);
            return;
        }
        ViewParent parent = this.P.getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            viewGroup.setBackgroundColor(0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        rh();
        View titleBarView = getTitleBarView();
        Intrinsics.checkNotNull(titleBarView, "null cannot be cast to non-null type com.tencent.mobileqq.guild.widget.GuildDefaultThemeNavBarCommon");
        GuildDefaultThemeNavBarCommon guildDefaultThemeNavBarCommon = (GuildDefaultThemeNavBarCommon) titleBarView;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        guildDefaultThemeNavBarCommon.f().setBackground(GuildUIUtils.w(context, R.drawable.guild_close_icon, Integer.valueOf(R.color.qui_common_icon_primary)));
        if (!this.isPreview) {
            guildDefaultThemeNavBarCommon.setRightDrawable(R.drawable.guild_token_share_icon);
        }
        guildDefaultThemeNavBarCommon.setOnItemSelectListener(di());
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    protected int ph() {
        return GuildSplitViewUtils.f235370a.m(getActivity(), R.color.qui_common_bg_bottom_light);
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    protected int qh() {
        return R.drawable.qui_common_bg_bottom_light_bg;
    }
}
