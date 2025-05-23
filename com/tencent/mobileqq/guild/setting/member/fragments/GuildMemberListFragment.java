package com.tencent.mobileqq.guild.setting.member.fragments;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.component.GuildQUIEmptyState;
import com.tencent.mobileqq.guild.config.QQGuildMCParser;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.nt.perf.api.IPerfApi;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.GuildProfileCard;
import com.tencent.mobileqq.guild.profile.profilecard.dialog.GuildRemoveGuildDialogFragment;
import com.tencent.mobileqq.guild.robot.components.console.RobotInfoFragment;
import com.tencent.mobileqq.guild.rolegroup.levelrole.GuildLevelRoleUtils;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.r;
import com.tencent.mobileqq.guild.setting.guildmanage.dialog.GuildAgainConfirmData;
import com.tencent.mobileqq.guild.setting.guildmanage.dialog.GuildAgainConfirmDialog;
import com.tencent.mobileqq.guild.setting.guildsetting.data.InviteFriendUpdateEvent;
import com.tencent.mobileqq.guild.setting.guildsetting.data.UpdateMemberDataEvent;
import com.tencent.mobileqq.guild.setting.member.fragments.GuildMemberListFragment;
import com.tencent.mobileqq.guild.setting.member.oldmemberlist.QQGuildMemberListViewModel;
import com.tencent.mobileqq.guild.setting.member.view.GuildLoadingMemberEmptyView;
import com.tencent.mobileqq.guild.setting.member.view.GuildTransferRuleDialog;
import com.tencent.mobileqq.guild.setting.member.view.QQGuildColorMemberListView;
import com.tencent.mobileqq.guild.setting.member.view.j;
import com.tencent.mobileqq.guild.setting.member.view.topcard.GuildMemberTopCardList;
import com.tencent.mobileqq.guild.setting.member.viewmodel.GuildRoleMemberListViewModel;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.bc;
import com.tencent.mobileqq.guild.util.bt;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.guild.widget.GuildDefaultThemeNavBarCommon;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProFeedSummary;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.QQToastUtil;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.SwipListView;
import cooperation.qzone.QzoneIPCModule;
import ef1.c;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import oh1.DrawableType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00d2\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000 \u00de\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\b\u0012\u0004\u0012\u00020\u00070\u0006:\b\u00df\u0001\u00e0\u0001\u00e1\u0001\u00e2\u0001B\t\u00a2\u0006\u0006\b\u00dc\u0001\u0010\u00dd\u0001J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0003J\u0019\u0010\u000f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0011\u001a\u00020\bH\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\u0016\u0010\u0017\u001a\u00020\b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\b\u0010\u0018\u001a\u00020\bH\u0002J\b\u0010\u0019\u001a\u00020\bH\u0002J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\b\u0010\u001d\u001a\u00020\bH\u0002J\b\u0010\u001e\u001a\u00020\bH\u0002J\u0010\u0010 \u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u000bH\u0002J\u0010\u0010!\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u0010\"\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010$\u001a\u00020\b2\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u001e\u0010'\u001a\u00020\b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00142\u0006\u0010&\u001a\u00020\u000bH\u0002J.\u0010+\u001a\u00020\b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00142\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020)2\u0006\u0010&\u001a\u00020\u000bH\u0002J\u0010\u0010-\u001a\u00020\b2\u0006\u0010,\u001a\u00020\u001aH\u0002J\b\u0010.\u001a\u00020\bH\u0002J\b\u0010/\u001a\u00020\bH\u0002J\b\u00101\u001a\u000200H\u0002J\u0012\u00103\u001a\u00020\b2\b\b\u0002\u00102\u001a\u00020\u000bH\u0002J\u0018\u00107\u001a\u00020\b2\u0006\u00105\u001a\u0002042\u0006\u00106\u001a\u00020\u000bH\u0002J\u0016\u00109\u001a\u00020\b2\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u0018\u0010<\u001a\u00020\b2\u0006\u0010:\u001a\u00020\u001a2\u0006\u0010;\u001a\u00020\u000bH\u0002J\b\u0010>\u001a\u00020=H\u0002J\b\u0010@\u001a\u00020?H\u0002J\b\u0010A\u001a\u00020\u001aH\u0002J\b\u0010B\u001a\u00020\bH\u0002J\u0010\u0010D\u001a\u00020\b2\u0006\u0010C\u001a\u00020\u0015H\u0002J\u0010\u0010E\u001a\u00020\b2\u0006\u0010C\u001a\u00020\u0015H\u0002J\b\u0010F\u001a\u00020\bH\u0002J\b\u0010G\u001a\u00020\bH\u0002J\b\u0010H\u001a\u00020\bH\u0002J\u0010\u0010K\u001a\u00020J2\u0006\u0010I\u001a\u00020\u001aH\u0002J\b\u0010L\u001a\u00020)H\u0014J&\u0010S\u001a\u00020\b2\b\u0010N\u001a\u0004\u0018\u00010M2\b\u0010P\u001a\u0004\u0018\u00010O2\b\u0010R\u001a\u0004\u0018\u00010QH\u0014J\b\u0010T\u001a\u00020)H\u0014J\b\u0010U\u001a\u00020\bH\u0016J\u0010\u0010X\u001a\u00020\b2\u0006\u0010W\u001a\u00020VH\u0016J\b\u0010Y\u001a\u00020\u000bH\u0016J\b\u0010Z\u001a\u00020\bH\u0016J\b\u0010\\\u001a\u00020[H\u0016J\u0016\u0010^\u001a\u00020\b2\f\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016J\u0010\u0010a\u001a\u00020\u000b2\u0006\u0010`\u001a\u00020_H\u0016J\b\u0010b\u001a\u00020\bH\u0016J\"\u0010g\u001a\u00020\b2\u0006\u0010c\u001a\u00020)2\u0006\u0010d\u001a\u00020)2\b\u0010f\u001a\u0004\u0018\u00010eH\u0016J$\u0010k\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070i0hj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070i`jH\u0016J\u0012\u0010m\u001a\u00020\b2\b\u0010l\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010n\u001a\u00020\bH\u0016J\u0012\u0010q\u001a\u00020\b2\b\u0010p\u001a\u0004\u0018\u00010oH\u0016J\u0018\u0010s\u001a\u00020\b2\u0006\u0010I\u001a\u00020\u001a2\u0006\u0010r\u001a\u00020)H\u0016J\u0018\u0010x\u001a\u00020\b2\u0006\u0010u\u001a\u00020t2\u0006\u0010w\u001a\u00020vH\u0016R\u0014\u0010{\u001a\u00020)8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\by\u0010zR\u0014\u0010}\u001a\u00020)8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b|\u0010zR\u001e\u0010\u0082\u0001\u001a\u00020?8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0004\b~\u0010\u007f\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R\u001f\u0010\u0086\u0001\u001a\u00020=8BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u0083\u0001\u0010\u007f\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001R\u0017\u0010\u0089\u0001\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u0018\u0010\u008d\u0001\u001a\u00030\u008a\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001R\u001a\u0010\u0091\u0001\u001a\u00030\u008e\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R\u0018\u0010\u0095\u0001\u001a\u00030\u0092\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R\u001a\u0010\u0099\u0001\u001a\u00030\u0096\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001R\u001a\u0010\u009d\u0001\u001a\u00030\u009a\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001R\u001a\u0010\u00a1\u0001\u001a\u00030\u009e\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u009f\u0001\u0010\u00a0\u0001R\u001a\u0010\u00a5\u0001\u001a\u00030\u00a2\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00a3\u0001\u0010\u00a4\u0001R\u001a\u0010\u00a9\u0001\u001a\u00030\u00a6\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00a7\u0001\u0010\u00a8\u0001R\u001a\u0010\u00ad\u0001\u001a\u00030\u00aa\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00ab\u0001\u0010\u00ac\u0001R\u001a\u0010\u00b1\u0001\u001a\u00030\u00ae\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00af\u0001\u0010\u00b0\u0001R\u001a\u0010\u00b5\u0001\u001a\u00030\u00b2\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00b3\u0001\u0010\u00b4\u0001R\u001a\u0010\u00b7\u0001\u001a\u00030\u00a2\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00b6\u0001\u0010\u00a4\u0001R\u001a\u0010\u00bb\u0001\u001a\u00030\u00b8\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00b9\u0001\u0010\u00ba\u0001R\u001a\u0010\u00bd\u0001\u001a\u00030\u00aa\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00bc\u0001\u0010\u00ac\u0001R\u001a\u0010\u00c1\u0001\u001a\u00030\u00be\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00bf\u0001\u0010\u00c0\u0001R\u001a\u0010\u00c5\u0001\u001a\u00030\u00c2\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00c3\u0001\u0010\u00c4\u0001R\u001a\u0010\u00c9\u0001\u001a\u00030\u00c6\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00c7\u0001\u0010\u00c8\u0001R\u001a\u0010\u00cb\u0001\u001a\u00030\u00a2\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00ca\u0001\u0010\u00a4\u0001R\u001a\u0010\u00cf\u0001\u001a\u00030\u00cc\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00cd\u0001\u0010\u00ce\u0001R)\u0010\u00d1\u0001\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00d0\u0001\u0010\u008f\u0001\u001a\u0006\b\u00d1\u0001\u0010\u00d2\u0001\"\u0006\b\u00d3\u0001\u0010\u00d4\u0001R)\u0010\u00d8\u0001\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00d5\u0001\u0010\u008f\u0001\u001a\u0006\b\u00d6\u0001\u0010\u00d2\u0001\"\u0006\b\u00d7\u0001\u0010\u00d4\u0001R\u0017\u0010\u00db\u0001\u001a\u00020V8BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u00d9\u0001\u0010\u00da\u0001\u00a8\u0006\u00e3\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/member/fragments/GuildMemberListFragment;", "Lcom/tencent/mobileqq/guild/base/QQGuildTitleBarFragment;", "Landroid/view/View$OnClickListener;", "La02/a;", "Landroid/os/Handler$Callback;", "Ld02/b;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "initView", "initData", "", "enable", "ti", "canInvite", "aj", "(Ljava/lang/Boolean;)V", "zi", "Lcom/tencent/widget/AbsListView$OnScrollListener;", "si", "", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProUserInfo;", "list", "Ji", "Li", "Ei", "", "text", "Ki", "Ni", "Mi", "showInvite", "Wi", "Oi", "Pi", "selectedUsers", "Ri", "deleteTinyIds", "isAllRobot", "Ui", "toBlack", "", "msgRevokeType", WidgetCacheLunarData.YI, "keyword", "startSearch", "Zi", "Yi", "Lcom/tencent/mobileqq/guild/setting/member/view/j$b;", "qi", "keepPending", "Hi", "Lcom/tencent/mobileqq/guild/setting/member/view/j$c;", "userUIData", "addAdmin", "Bi", "selectedIdList", "Di", "tinyId", "isRobot", "Gi", "Lcom/tencent/mobileqq/guild/robot/components/console/RobotInfoFragment$a;", "ri", "Lcom/tencent/mobileqq/guild/profile/profilecard/baseprofile/card/GuildProfileCard$e;", "pi", "getChannelId", "initDtReport", ITVKPlayerEventListener.KEY_USER_INFO, "mi", "oi", "Qi", "Xi", "Ti", "channelId", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "xi", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", "ph", "onResume", "Landroid/view/View;", "view", NodeProps.ON_CLICK, "onBackEvent", "onPostThemeChanged", "Lcom/tencent/mobileqq/app/QBaseActivity;", "getHostActivity", "memberList", "U3", "Landroid/os/Message;", "msg", "handleMessage", "onDetach", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "event", "onReceiveEvent", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "initWindowStyleAndAnimation", "channelType", "z0", "Ldg1/b;", "channelInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProFeedSummary;", "feedSummary", "q1", "T", "I", "MSG_CODE_SHOW_LOADING_DIALOG", "U", "MSG_CODE_REMOVE_DELETE_DIALOG", "V", "Lkotlin/Lazy;", "vi", "()Lcom/tencent/mobileqq/guild/profile/profilecard/baseprofile/card/GuildProfileCard$e;", "onProfileCardShow", "W", "wi", "()Lcom/tencent/mobileqq/guild/robot/components/console/RobotInfoFragment$a;", "onRobotCardShow", "X", "Lcom/tencent/mobileqq/guild/setting/member/view/j$b;", "onMemberListViewHandler", "Lcom/tencent/mobileqq/guild/avatar/a;", "Y", "Lcom/tencent/mobileqq/guild/avatar/a;", "preLoadHelper", "Lcom/tencent/mobileqq/guild/setting/member/fragments/GuildMemberListFragment$Param;", "Z", "Lcom/tencent/mobileqq/guild/setting/member/fragments/GuildMemberListFragment$Param;", "param", "Lcom/tencent/util/WeakReferenceHandler;", "a0", "Lcom/tencent/util/WeakReferenceHandler;", "uiHandler", "Lcom/tencent/mobileqq/guild/setting/member/view/GuildLoadingMemberEmptyView;", "b0", "Lcom/tencent/mobileqq/guild/setting/member/view/GuildLoadingMemberEmptyView;", "loadingMemberEmptyView", "Lcom/tencent/mobileqq/guild/setting/member/view/topcard/GuildMemberTopCardList;", "c0", "Lcom/tencent/mobileqq/guild/setting/member/view/topcard/GuildMemberTopCardList;", "channelMemberCardView", "Lcom/tencent/mobileqq/guild/setting/member/view/QQGuildColorMemberListView;", "d0", "Lcom/tencent/mobileqq/guild/setting/member/view/QQGuildColorMemberListView;", "memberListView", "Landroid/widget/ImageView;", "e0", "Landroid/widget/ImageView;", "topInviteView", "Lcom/tencent/widget/SwipListView;", "f0", "Lcom/tencent/widget/SwipListView;", "searchListView", "Landroid/widget/TextView;", "g0", "Landroid/widget/TextView;", "searchFootView", "Landroid/widget/RelativeLayout;", "h0", "Landroid/widget/RelativeLayout;", "searchBar", "Landroid/widget/EditText;", "i0", "Landroid/widget/EditText;", "searchEditText", "j0", "closeSearchButton", "Landroid/widget/LinearLayout;", "k0", "Landroid/widget/LinearLayout;", "searchEmptyView", "l0", "mSearchCancel", "Lcom/tencent/mobileqq/guild/setting/member/oldmemberlist/a;", "m0", "Lcom/tencent/mobileqq/guild/setting/member/oldmemberlist/a;", "searchListAdapter", "Lcom/tencent/mobileqq/guild/setting/member/oldmemberlist/QQGuildMemberListViewModel;", "n0", "Lcom/tencent/mobileqq/guild/setting/member/oldmemberlist/QQGuildMemberListViewModel;", "viewModel", "Lcom/tencent/mobileqq/guild/setting/member/viewmodel/GuildRoleMemberListViewModel;", "o0", "Lcom/tencent/mobileqq/guild/setting/member/viewmodel/GuildRoleMemberListViewModel;", "memberListViewModel", "p0", "leftSearchIconView", "Lcom/tencent/mobileqq/guild/setting/member/fragments/GuildMemberListFragment$PendingAction;", "q0", "Lcom/tencent/mobileqq/guild/setting/member/fragments/GuildMemberListFragment$PendingAction;", "pendingAction", "r0", "isEditModel", "()Z", "setEditModel", "(Z)V", "s0", "Ai", "setTransferGuild", "isTransferGuild", "getContentView", "()Landroid/view/View;", "contentView", "<init>", "()V", "t0", "a", "Param", "PendingAction", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMemberListFragment extends QQGuildTitleBarFragment implements View.OnClickListener, a02.a, Handler.Callback, d02.b, SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: T, reason: from kotlin metadata */
    private final int MSG_CODE_SHOW_LOADING_DIALOG = 15;

    /* renamed from: U, reason: from kotlin metadata */
    private final int MSG_CODE_REMOVE_DELETE_DIALOG = 15 + 1;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final Lazy onProfileCardShow;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final Lazy onRobotCardShow;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private final j.b onMemberListViewHandler;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.avatar.a preLoadHelper;

    /* renamed from: Z, reason: from kotlin metadata */
    private Param param;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReferenceHandler uiHandler;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private GuildLoadingMemberEmptyView loadingMemberEmptyView;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private GuildMemberTopCardList channelMemberCardView;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private QQGuildColorMemberListView memberListView;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private ImageView topInviteView;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private SwipListView searchListView;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private TextView searchFootView;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout searchBar;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private EditText searchEditText;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private ImageView closeSearchButton;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private LinearLayout searchEmptyView;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    private TextView mSearchCancel;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.guild.setting.member.oldmemberlist.a searchListAdapter;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    private QQGuildMemberListViewModel viewModel;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    private GuildRoleMemberListViewModel memberListViewModel;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    private ImageView leftSearchIconView;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private PendingAction pendingAction;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    private boolean isEditModel;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    private boolean isTransferGuild;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001J\u0006\u0010\u0016\u001a\u00020\u0017J\t\u0010\u0018\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/member/fragments/GuildMemberListFragment$PendingAction;", "Ljava/io/Serializable;", "tinyId", "", "isRobot", "", "(Ljava/lang/String;Z)V", "()Z", "setRobot", "(Z)V", "getTinyId", "()Ljava/lang/String;", "setTinyId", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "reset", "", "toString", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final /* data */ class PendingAction implements Serializable {
        private boolean isRobot;

        @NotNull
        private String tinyId;

        public PendingAction() {
            this(null, false, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ PendingAction copy$default(PendingAction pendingAction, String str, boolean z16, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = pendingAction.tinyId;
            }
            if ((i3 & 2) != 0) {
                z16 = pendingAction.isRobot;
            }
            return pendingAction.copy(str, z16);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getTinyId() {
            return this.tinyId;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsRobot() {
            return this.isRobot;
        }

        @NotNull
        public final PendingAction copy(@NotNull String tinyId, boolean isRobot) {
            Intrinsics.checkNotNullParameter(tinyId, "tinyId");
            return new PendingAction(tinyId, isRobot);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PendingAction)) {
                return false;
            }
            PendingAction pendingAction = (PendingAction) other;
            if (Intrinsics.areEqual(this.tinyId, pendingAction.tinyId) && this.isRobot == pendingAction.isRobot) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String getTinyId() {
            return this.tinyId;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = this.tinyId.hashCode() * 31;
            boolean z16 = this.isRobot;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return hashCode + i3;
        }

        public final boolean isRobot() {
            return this.isRobot;
        }

        public final void reset() {
            this.tinyId = "";
            this.isRobot = false;
        }

        public final void setRobot(boolean z16) {
            this.isRobot = z16;
        }

        public final void setTinyId(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.tinyId = str;
        }

        @NotNull
        public String toString() {
            return "PendingAction(tinyId=" + this.tinyId + ", isRobot=" + this.isRobot + ")";
        }

        public PendingAction(@NotNull String tinyId, boolean z16) {
            Intrinsics.checkNotNullParameter(tinyId, "tinyId");
            this.tinyId = tinyId;
            this.isRobot = z16;
        }

        public /* synthetic */ PendingAction(String str, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? false : z16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0007J \u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J(\u0010\u000f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0007J(\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0007R\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0016\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/member/fragments/GuildMemberListFragment$a;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "", "channelId", "Landroid/content/Intent;", "b", "", "isEditModel", "a", "Landroid/content/Context;", "context", "", "c", "d", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "fragment", "", "requestCode", "e", "PARAM_FRAGMENT", "Ljava/lang/String;", "PARAM_IS_EDIT_MODEL", "PARAM_IS_TRANSFER_GUILD", "PARAM_IS_TRANSFER_GUILD_TYPE", "I", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.setting.member.fragments.GuildMemberListFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final Intent a(@NotNull IGProGuildInfo guildInfo, @NotNull String channelId, boolean isEditModel) {
            Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intent intent = new Intent();
            intent.putExtra("PARAM_FRAGMENT", new Param(guildInfo, channelId));
            intent.putExtra("param_is_edit_model", isEditModel);
            return intent;
        }

        @JvmStatic
        @NotNull
        public final Intent b(@NotNull IGProGuildInfo guildInfo, @NotNull String channelId) {
            Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intent intent = new Intent();
            intent.putExtra("PARAM_FRAGMENT", new Param(guildInfo, channelId));
            return intent;
        }

        @JvmStatic
        public final void c(@NotNull Context context, @NotNull IGProGuildInfo guildInfo, @NotNull String channelId) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            GuildSplitViewUtils.p(GuildSplitViewUtils.f235370a, context, b(guildInfo, channelId), GuildMemberListFragment.class, null, 8, null);
        }

        @JvmStatic
        public final void d(@NotNull Context context, @NotNull IGProGuildInfo guildInfo, @NotNull String channelId, boolean isEditModel) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            GuildSplitViewUtils.p(GuildSplitViewUtils.f235370a, context, a(guildInfo, channelId, isEditModel), GuildMemberListFragment.class, null, 8, null);
        }

        @JvmStatic
        public final void e(@NotNull QPublicBaseFragment fragment, @NotNull IGProGuildInfo guildInfo, @NotNull String channelId, int requestCode) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intent b16 = b(guildInfo, channelId);
            b16.putExtra("param_is_transfer_guild", 1);
            GuildSplitViewUtils.f235370a.q(fragment.getContext(), fragment, b16, GuildMemberListFragment.class, requestCode);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J(\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/member/fragments/GuildMemberListFragment$b;", "Landroid/text/TextWatcher;", "Landroid/text/Editable;", "arg0", "", "afterTextChanged", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "<init>", "(Lcom/tencent/mobileqq/guild/setting/member/fragments/GuildMemberListFragment;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public final class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@NotNull Editable arg0) {
            CharSequence trim;
            Intrinsics.checkNotNullParameter(arg0, "arg0");
            EditText editText = GuildMemberListFragment.this.searchEditText;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
                editText = null;
            }
            trim = StringsKt__StringsKt.trim((CharSequence) editText.getText().toString());
            GuildMemberListFragment.this.startSearch(trim.toString());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@NotNull CharSequence s16, int start, int count, int after) {
            Intrinsics.checkNotNullParameter(s16, "s");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@NotNull CharSequence s16, int start, int before, int count) {
            Intrinsics.checkNotNullParameter(s16, "s");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/setting/member/fragments/GuildMemberListFragment$c", "Lcom/tencent/mobileqq/guild/setting/guildmanage/dialog/GuildAgainConfirmDialog$b;", "Landroid/view/View;", "view", "", "b", "againConfirm", "d", "cancel", MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM, "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements GuildAgainConfirmDialog.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IGProUserInfo f234592b;

        c(IGProUserInfo iGProUserInfo) {
            this.f234592b = iGProUserInfo;
        }

        @Override // com.tencent.mobileqq.guild.setting.guildmanage.dialog.GuildAgainConfirmDialog.b
        public void a(@NotNull View view) {
            GuildAgainConfirmDialog.b.a.c(this, view);
        }

        @Override // com.tencent.mobileqq.guild.setting.guildmanage.dialog.GuildAgainConfirmDialog.b
        public void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            QQGuildMemberListViewModel qQGuildMemberListViewModel = GuildMemberListFragment.this.viewModel;
            if (qQGuildMemberListViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                qQGuildMemberListViewModel = null;
            }
            qQGuildMemberListViewModel.z2(((QQGuildCustomTitleBarFragment) GuildMemberListFragment.this).P.getContext(), this.f234592b);
        }

        @Override // com.tencent.mobileqq.guild.setting.guildmanage.dialog.GuildAgainConfirmDialog.b
        public void c(@NotNull View cancel, @NotNull View confirm) {
            Intrinsics.checkNotNullParameter(cancel, "cancel");
            Intrinsics.checkNotNullParameter(confirm, "confirm");
            VideoReport.setLogicParent(cancel, ((QQGuildCustomTitleBarFragment) GuildMemberListFragment.this).P);
            VideoReport.setLogicParent(confirm, ((QQGuildCustomTitleBarFragment) GuildMemberListFragment.this).P);
            HashMap hashMap = new HashMap();
            hashMap.put("sgrp_btn_type", 1);
            EndExposurePolicy endExposurePolicy = EndExposurePolicy.REPORT_NONE;
            bt.d(cancel, "em_sgrp_owner_transfer_pop", hashMap, null, null, endExposurePolicy, 24, null);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("sgrp_btn_type", 2);
            bt.d(confirm, "em_sgrp_owner_transfer_pop", hashMap2, null, null, endExposurePolicy, 24, null);
        }

        @Override // com.tencent.mobileqq.guild.setting.guildmanage.dialog.GuildAgainConfirmDialog.b
        public void d(@NotNull View againConfirm) {
            Intrinsics.checkNotNullParameter(againConfirm, "againConfirm");
            VideoReport.setLogicParent(againConfirm, ((QQGuildCustomTitleBarFragment) GuildMemberListFragment.this).P);
            bt.d(againConfirm, "em_sgrp_owner_transfer_pop_second_btn", null, null, null, EndExposurePolicy.REPORT_NONE, 28, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0016\u0010\n\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016\u00a8\u0006\u0013"}, d2 = {"com/tencent/mobileqq/guild/setting/member/fragments/GuildMemberListFragment$e", "Lcom/tencent/mobileqq/guild/setting/member/view/j$b;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProUserInfo;", ITVKPlayerEventListener.KEY_USER_INFO, "", "isRobot", "", "d", "", "selectedIdList", "b", "Lcom/tencent/mobileqq/guild/setting/member/view/j$c;", "userUIData", "f", "setAdmin", "g", "e", "a", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e implements j.b {
        e() {
        }

        @Override // com.tencent.mobileqq.guild.setting.member.view.j.b
        public void a() {
            QQGuildMemberListViewModel qQGuildMemberListViewModel = GuildMemberListFragment.this.viewModel;
            if (qQGuildMemberListViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                qQGuildMemberListViewModel = null;
            }
            qQGuildMemberListViewModel.w2(false);
        }

        @Override // com.tencent.mobileqq.guild.setting.member.view.j.b
        public void b(@NotNull List<? extends IGProUserInfo> selectedIdList) {
            Intrinsics.checkNotNullParameter(selectedIdList, "selectedIdList");
            GuildMemberListFragment.this.Di(selectedIdList);
        }

        @Override // com.tencent.mobileqq.guild.setting.member.view.j.b
        public void c() {
            GuildRoleMemberListViewModel guildRoleMemberListViewModel = GuildMemberListFragment.this.memberListViewModel;
            if (guildRoleMemberListViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("memberListViewModel");
                guildRoleMemberListViewModel = null;
            }
            guildRoleMemberListViewModel.loadMore();
        }

        @Override // com.tencent.mobileqq.guild.setting.member.view.j.b
        public void d(@NotNull IGProUserInfo userInfo, boolean isRobot) {
            Intrinsics.checkNotNullParameter(userInfo, "userInfo");
            if (GuildMemberListFragment.this.getIsTransferGuild()) {
                GuildMemberListFragment.this.mi(userInfo);
                return;
            }
            GuildMemberListFragment guildMemberListFragment = GuildMemberListFragment.this;
            String tinyId = userInfo.getTinyId();
            Intrinsics.checkNotNullExpressionValue(tinyId, "userInfo.tinyId");
            guildMemberListFragment.Gi(tinyId, isRobot);
        }

        @Override // com.tencent.mobileqq.guild.setting.member.view.j.b
        public void e() {
            Unit unit;
            FragmentActivity activity = GuildMemberListFragment.this.getActivity();
            if (activity != null) {
                Param param = GuildMemberListFragment.this.param;
                if (param == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("param");
                    param = null;
                }
                String guildID = param.getGuildInfo().getGuildID();
                Intrinsics.checkNotNullExpressionValue(guildID, "param.guildInfo.guildID");
                GuildLevelRoleUtils.a(activity, guildID, 5);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                bVar.a().add("onLVRoleCLick nut activity null");
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("Guild.userl.GuildMemberListFragment", 1, (String) it.next(), null);
                }
            }
        }

        @Override // com.tencent.mobileqq.guild.setting.member.view.j.b
        public void f(@NotNull j.c userUIData) {
            List listOf;
            Intrinsics.checkNotNullParameter(userUIData, "userUIData");
            GuildMemberListFragment guildMemberListFragment = GuildMemberListFragment.this;
            listOf = CollectionsKt__CollectionsJVMKt.listOf(userUIData.f234733f);
            guildMemberListFragment.Ri(listOf);
        }

        @Override // com.tencent.mobileqq.guild.setting.member.view.j.b
        public void g(@NotNull j.c userUIData, boolean setAdmin) {
            Intrinsics.checkNotNullParameter(userUIData, "userUIData");
            GuildMemberListFragment.this.Bi(userUIData, setAdmin);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/setting/member/fragments/GuildMemberListFragment$h", "Lcom/tencent/mobileqq/guild/setting/member/view/b;", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/qqguildsdk/data/IGProUserInfo;", ITVKPlayerEventListener.KEY_USER_INFO, "", "isRobot", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class h implements com.tencent.mobileqq.guild.setting.member.view.b {
        h() {
        }

        @Override // com.tencent.mobileqq.guild.setting.member.view.b
        public void a(@NotNull QBaseActivity activity, @NotNull IGProUserInfo userInfo, boolean isRobot) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(userInfo, "userInfo");
            if (GuildMemberListFragment.this.getIsTransferGuild()) {
                GuildMemberListFragment.this.mi(userInfo);
                return;
            }
            QQGuildMemberListViewModel qQGuildMemberListViewModel = GuildMemberListFragment.this.viewModel;
            if (qQGuildMemberListViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                qQGuildMemberListViewModel = null;
            }
            qQGuildMemberListViewModel.t2(activity, userInfo.getTinyId(), isRobot, GuildMemberListFragment.this.vi());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class i<T> implements Observer {
        public i() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            cf1.b bVar = (cf1.b) t16;
            if (bVar != null && bVar.f30775b != 0) {
                SecurityTipHelperKt.E(GuildMemberListFragment.this.getContext(), bVar, GuildMemberListFragment.this.getString(R.string.f145790sf));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class j<T> implements Observer {
        public j() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            Integer num = (Integer) t16;
            QQGuildMemberListViewModel qQGuildMemberListViewModel = GuildMemberListFragment.this.viewModel;
            if (qQGuildMemberListViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                qQGuildMemberListViewModel = null;
            }
            if (qQGuildMemberListViewModel.q2() && !GuildMemberListFragment.this.getIsTransferGuild()) {
                TextView centerView = GuildMemberListFragment.this.E;
                Intrinsics.checkNotNullExpressionValue(centerView, "centerView");
                com.tencent.mobileqq.guild.base.extension.s.c(centerView, R.string.f1502114d, num);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class k<T> implements Observer {
        public k() {
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            List<String> list = (List) t16;
            QQGuildMemberListViewModel qQGuildMemberListViewModel = GuildMemberListFragment.this.viewModel;
            if (qQGuildMemberListViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                qQGuildMemberListViewModel = null;
            }
            qQGuildMemberListViewModel.Q1(list);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class l<T> implements Observer {
        public l() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            GuildMemberListFragment.this.aj((Boolean) t16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class m<T> implements Observer {
        public m() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            Boolean it = (Boolean) t16;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (it.booleanValue()) {
                FragmentActivity activity = GuildMemberListFragment.this.getActivity();
                if (activity != null) {
                    activity.setResult(-1, new Intent());
                }
                GuildSplitViewUtils.f235370a.t(GuildMemberListFragment.this.getActivity(), true);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class n<T> implements Observer {
        public n() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            Resources resources;
            Resources resources2;
            Resources resources3;
            Integer num = (Integer) t16;
            String str = null;
            if (num != null && num.intValue() == 0) {
                TextView textView = GuildMemberListFragment.this.searchFootView;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("searchFootView");
                    textView = null;
                }
                textView.setText((CharSequence) null);
                return;
            }
            if (num != null && num.intValue() == 4) {
                TextView textView2 = GuildMemberListFragment.this.searchFootView;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("searchFootView");
                    textView2 = null;
                }
                Context context = GuildMemberListFragment.this.getContext();
                if (context != null && (resources3 = context.getResources()) != null) {
                    str = resources3.getString(R.string.f155501ho);
                }
                textView2.setText(str);
                return;
            }
            if (num != null && num.intValue() == 3) {
                TextView textView3 = GuildMemberListFragment.this.searchFootView;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("searchFootView");
                    textView3 = null;
                }
                Context context2 = GuildMemberListFragment.this.getContext();
                if (context2 != null && (resources2 = context2.getResources()) != null) {
                    str = resources2.getString(R.string.f155511hp);
                }
                textView3.setText(str);
                return;
            }
            if (num != null && num.intValue() == 5) {
                TextView textView4 = GuildMemberListFragment.this.searchFootView;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("searchFootView");
                    textView4 = null;
                }
                Context context3 = GuildMemberListFragment.this.getContext();
                if (context3 != null && (resources = context3.getResources()) != null) {
                    str = resources.getString(R.string.f155491hn);
                }
                textView4.setText(str);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class o<T> implements Observer {
        public o() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            Boolean bool = (Boolean) t16;
            if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                GuildMemberListFragment.this.Zi();
            } else if (Intrinsics.areEqual(bool, Boolean.FALSE)) {
                GuildMemberListFragment.this.Yi();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class p<T> implements Observer {
        public p() {
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            List list = (List) t16;
            GuildMemberListFragment guildMemberListFragment = GuildMemberListFragment.this;
            Intrinsics.checkNotNullExpressionValue(list, "list");
            guildMemberListFragment.Ji(list);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class q<T> implements Observer {
        public q() {
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            List<? extends dg1.b> list = (List) t16;
            GuildMemberTopCardList guildMemberTopCardList = GuildMemberListFragment.this.channelMemberCardView;
            if (guildMemberTopCardList == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelMemberCardView");
                guildMemberTopCardList = null;
            }
            Intrinsics.checkNotNullExpressionValue(list, "list");
            guildMemberTopCardList.g(list);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class r<T> implements Observer {
        public r() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            GuildSplitViewUtils.u(GuildSplitViewUtils.f235370a, GuildMemberListFragment.this.getQBaseActivity(), false, 2, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class s<T> implements Observer {
        public s() {
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            boolean z16;
            IGProUserInfo iGProUserInfo = (IGProUserInfo) t16;
            PendingAction pendingAction = GuildMemberListFragment.this.pendingAction;
            if (iGProUserInfo.getRobotType() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            pendingAction.setRobot(z16);
            PendingAction pendingAction2 = GuildMemberListFragment.this.pendingAction;
            String tinyId = iGProUserInfo.getTinyId();
            Intrinsics.checkNotNullExpressionValue(tinyId, "it.tinyId");
            pendingAction2.setTinyId(tinyId);
            com.tencent.mobileqq.guild.setting.member.oldmemberlist.a aVar = null;
            GuildMemberListFragment.Ii(GuildMemberListFragment.this, false, 1, null);
            com.tencent.mobileqq.guild.setting.member.oldmemberlist.a aVar2 = GuildMemberListFragment.this.searchListAdapter;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchListAdapter");
            } else {
                aVar = aVar2;
            }
            aVar.o(iGProUserInfo);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class t<T> implements Observer {
        public t() {
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            boolean z16;
            IGProUserInfo iGProUserInfo = (IGProUserInfo) t16;
            PendingAction pendingAction = GuildMemberListFragment.this.pendingAction;
            if (iGProUserInfo.getRobotType() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            pendingAction.setRobot(z16);
            PendingAction pendingAction2 = GuildMemberListFragment.this.pendingAction;
            String tinyId = iGProUserInfo.getTinyId();
            Intrinsics.checkNotNullExpressionValue(tinyId, "it.tinyId");
            pendingAction2.setTinyId(tinyId);
            com.tencent.mobileqq.guild.setting.member.oldmemberlist.a aVar = null;
            GuildMemberListFragment.Ii(GuildMemberListFragment.this, false, 1, null);
            com.tencent.mobileqq.guild.setting.member.oldmemberlist.a aVar2 = GuildMemberListFragment.this.searchListAdapter;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchListAdapter");
            } else {
                aVar = aVar2;
            }
            aVar.o(iGProUserInfo);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class u<T> implements Observer {
        public u() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            PendingAction pendingAction = (PendingAction) t16;
            GuildMemberListFragment.this.pendingAction.setTinyId(pendingAction.getTinyId());
            GuildMemberListFragment.this.pendingAction.setRobot(pendingAction.isRobot());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class v<T> implements Observer {
        public v() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            boolean z16;
            Integer state = (Integer) t16;
            if (state != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                Intrinsics.checkNotNullExpressionValue(state, "state");
                int intValue = state.intValue();
                GuildLoadingMemberEmptyView guildLoadingMemberEmptyView = null;
                if (intValue == 0) {
                    QQGuildColorMemberListView qQGuildColorMemberListView = GuildMemberListFragment.this.memberListView;
                    if (qQGuildColorMemberListView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("memberListView");
                        qQGuildColorMemberListView = null;
                    }
                    GuildLoadingMemberEmptyView guildLoadingMemberEmptyView2 = GuildMemberListFragment.this.loadingMemberEmptyView;
                    if (guildLoadingMemberEmptyView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("loadingMemberEmptyView");
                        guildLoadingMemberEmptyView2 = null;
                    }
                    qQGuildColorMemberListView.i(guildLoadingMemberEmptyView2);
                    GuildLoadingMemberEmptyView guildLoadingMemberEmptyView3 = GuildMemberListFragment.this.loadingMemberEmptyView;
                    if (guildLoadingMemberEmptyView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("loadingMemberEmptyView");
                    } else {
                        guildLoadingMemberEmptyView = guildLoadingMemberEmptyView3;
                    }
                    guildLoadingMemberEmptyView.c();
                    return;
                }
                if (intValue == 2) {
                    GuildLoadingMemberEmptyView guildLoadingMemberEmptyView4 = GuildMemberListFragment.this.loadingMemberEmptyView;
                    if (guildLoadingMemberEmptyView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("loadingMemberEmptyView");
                        guildLoadingMemberEmptyView4 = null;
                    }
                    guildLoadingMemberEmptyView4.a();
                    QQGuildColorMemberListView qQGuildColorMemberListView2 = GuildMemberListFragment.this.memberListView;
                    if (qQGuildColorMemberListView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("memberListView");
                        qQGuildColorMemberListView2 = null;
                    }
                    GuildLoadingMemberEmptyView guildLoadingMemberEmptyView5 = GuildMemberListFragment.this.loadingMemberEmptyView;
                    if (guildLoadingMemberEmptyView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("loadingMemberEmptyView");
                    } else {
                        guildLoadingMemberEmptyView = guildLoadingMemberEmptyView5;
                    }
                    qQGuildColorMemberListView2.p(guildLoadingMemberEmptyView);
                    return;
                }
                if (intValue == 3) {
                    GuildLoadingMemberEmptyView guildLoadingMemberEmptyView6 = GuildMemberListFragment.this.loadingMemberEmptyView;
                    if (guildLoadingMemberEmptyView6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("loadingMemberEmptyView");
                        guildLoadingMemberEmptyView6 = null;
                    }
                    guildLoadingMemberEmptyView6.a();
                    QQGuildColorMemberListView qQGuildColorMemberListView3 = GuildMemberListFragment.this.memberListView;
                    if (qQGuildColorMemberListView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("memberListView");
                        qQGuildColorMemberListView3 = null;
                    }
                    GuildLoadingMemberEmptyView guildLoadingMemberEmptyView7 = GuildMemberListFragment.this.loadingMemberEmptyView;
                    if (guildLoadingMemberEmptyView7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("loadingMemberEmptyView");
                    } else {
                        guildLoadingMemberEmptyView = guildLoadingMemberEmptyView7;
                    }
                    qQGuildColorMemberListView3.p(guildLoadingMemberEmptyView);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class w<T> implements Observer {
        public w() {
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            List<j.c> list = (List) t16;
            GuildLoadingMemberEmptyView guildLoadingMemberEmptyView = GuildMemberListFragment.this.loadingMemberEmptyView;
            RelativeLayout relativeLayout = null;
            if (guildLoadingMemberEmptyView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingMemberEmptyView");
                guildLoadingMemberEmptyView = null;
            }
            guildLoadingMemberEmptyView.a();
            QQGuildColorMemberListView qQGuildColorMemberListView = GuildMemberListFragment.this.memberListView;
            if (qQGuildColorMemberListView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("memberListView");
                qQGuildColorMemberListView = null;
            }
            GuildLoadingMemberEmptyView guildLoadingMemberEmptyView2 = GuildMemberListFragment.this.loadingMemberEmptyView;
            if (guildLoadingMemberEmptyView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingMemberEmptyView");
                guildLoadingMemberEmptyView2 = null;
            }
            qQGuildColorMemberListView.p(guildLoadingMemberEmptyView2);
            QQGuildColorMemberListView qQGuildColorMemberListView2 = GuildMemberListFragment.this.memberListView;
            if (qQGuildColorMemberListView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("memberListView");
                qQGuildColorMemberListView2 = null;
            }
            qQGuildColorMemberListView2.setUIDataList(list);
            if (list.isEmpty() && GuildMemberListFragment.this.getIsTransferGuild()) {
                GuildMemberListFragment.this.Ti();
                return;
            }
            if (GuildMemberListFragment.this.getIsTransferGuild()) {
                RelativeLayout relativeLayout2 = GuildMemberListFragment.this.searchBar;
                if (relativeLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("searchBar");
                } else {
                    relativeLayout = relativeLayout2;
                }
                relativeLayout.setVisibility(0);
            }
        }
    }

    public GuildMemberListFragment() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildProfileCard.e>() { // from class: com.tencent.mobileqq.guild.setting.member.fragments.GuildMemberListFragment$onProfileCardShow$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildProfileCard.e invoke() {
                GuildProfileCard.e pi5;
                pi5 = GuildMemberListFragment.this.pi();
                return pi5;
            }
        });
        this.onProfileCardShow = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<RobotInfoFragment.a>() { // from class: com.tencent.mobileqq.guild.setting.member.fragments.GuildMemberListFragment$onRobotCardShow$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RobotInfoFragment.a invoke() {
                RobotInfoFragment.a ri5;
                ri5 = GuildMemberListFragment.this.ri();
                return ri5;
            }
        });
        this.onRobotCardShow = lazy2;
        this.onMemberListViewHandler = qi();
        this.preLoadHelper = new com.tencent.mobileqq.guild.avatar.a(com.tencent.mobileqq.guild.setting.member.view.o.X, com.tencent.mobileqq.guild.setting.member.view.o.Y);
        this.uiHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
        this.pendingAction = new PendingAction(null, false, 3, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Bi(j.c userUIData, boolean addAdmin) {
        List<String> emptyList;
        List<String> listOf;
        List<String> listOf2;
        List<String> emptyList2;
        GuildRoleMemberListViewModel guildRoleMemberListViewModel = null;
        if (addAdmin) {
            GuildRoleMemberListViewModel guildRoleMemberListViewModel2 = this.memberListViewModel;
            if (guildRoleMemberListViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("memberListViewModel");
            } else {
                guildRoleMemberListViewModel = guildRoleMemberListViewModel2;
            }
            String tinyId = userUIData.f234733f.getTinyId();
            listOf2 = CollectionsKt__CollectionsJVMKt.listOf("2");
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            guildRoleMemberListViewModel.d2(tinyId, listOf2, emptyList2);
            return;
        }
        GuildRoleMemberListViewModel guildRoleMemberListViewModel3 = this.memberListViewModel;
        if (guildRoleMemberListViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberListViewModel");
        } else {
            guildRoleMemberListViewModel = guildRoleMemberListViewModel3;
        }
        String tinyId2 = userUIData.f234733f.getTinyId();
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        listOf = CollectionsKt__CollectionsJVMKt.listOf("2");
        guildRoleMemberListViewModel.d2(tinyId2, emptyList, listOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ci() {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.userl.GuildMemberListFragment", 2, "changed:");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Di(List<? extends IGProUserInfo> selectedIdList) {
        QQGuildMemberListViewModel qQGuildMemberListViewModel = this.viewModel;
        if (qQGuildMemberListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            qQGuildMemberListViewModel = null;
        }
        if (!qQGuildMemberListViewModel.o2()) {
            return;
        }
        if (selectedIdList.isEmpty()) {
            Pi(false);
            Oi("\u79fb\u9664");
            return;
        }
        Oi("\u79fb\u9664(" + selectedIdList.size() + ")");
        Pi(true);
    }

    private final void Ei() {
        Map mapOf;
        Map mapOf2;
        if (this.isTransferGuild) {
            Xi();
            return;
        }
        QQGuildMemberListViewModel qQGuildMemberListViewModel = this.viewModel;
        QQGuildColorMemberListView qQGuildColorMemberListView = null;
        if (qQGuildMemberListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            qQGuildMemberListViewModel = null;
        }
        if (!qQGuildMemberListViewModel.O1()) {
            return;
        }
        QQGuildMemberListViewModel qQGuildMemberListViewModel2 = this.viewModel;
        if (qQGuildMemberListViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            qQGuildMemberListViewModel2 = null;
        }
        qQGuildMemberListViewModel2.w2(false);
        QQGuildMemberListViewModel qQGuildMemberListViewModel3 = this.viewModel;
        if (qQGuildMemberListViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            qQGuildMemberListViewModel3 = null;
        }
        if (qQGuildMemberListViewModel3.o2()) {
            Si(this, null, 1, null);
            TextView textView = this.F;
            mapOf2 = MapsKt__MapsJVMKt.mapOf(c02.a.f30204a.a());
            VideoReport.reportEvent("clck", textView, mapOf2);
            return;
        }
        RelativeLayout relativeLayout = this.searchBar;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBar");
            relativeLayout = null;
        }
        relativeLayout.setVisibility(8);
        GuildMemberTopCardList guildMemberTopCardList = this.channelMemberCardView;
        if (guildMemberTopCardList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelMemberCardView");
            guildMemberTopCardList = null;
        }
        guildMemberTopCardList.setOnlineChannelCardViewShow(false);
        Wi(false);
        TextView textView2 = this.F;
        mapOf = MapsKt__MapsJVMKt.mapOf(c02.a.f30204a.a());
        VideoReport.reportEvent("imp", textView2, mapOf);
        QQGuildMemberListViewModel qQGuildMemberListViewModel4 = this.viewModel;
        if (qQGuildMemberListViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            qQGuildMemberListViewModel4 = null;
        }
        qQGuildMemberListViewModel4.u2(true);
        Pi(false);
        Oi("\u79fb\u9664");
        Ki("\u53d6\u6d88");
        QQGuildColorMemberListView qQGuildColorMemberListView2 = this.memberListView;
        if (qQGuildColorMemberListView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberListView");
        } else {
            qQGuildColorMemberListView = qQGuildColorMemberListView2;
        }
        qQGuildColorMemberListView.setEditMode(true);
    }

    @JvmStatic
    public static final void Fi(@NotNull QPublicBaseFragment qPublicBaseFragment, @NotNull IGProGuildInfo iGProGuildInfo, @NotNull String str, int i3) {
        INSTANCE.e(qPublicBaseFragment, iGProGuildInfo, str, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Gi(String tinyId, boolean isRobot) {
        this.pendingAction.setRobot(isRobot);
        this.pendingAction.setTinyId(tinyId);
        Param param = this.param;
        Param param2 = null;
        if (param == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            param = null;
        }
        String guildID = param.getGuildInfo().getGuildID();
        if (isRobot) {
            FragmentActivity activity = getActivity();
            Param param3 = this.param;
            if (param3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
            } else {
                param2 = param3;
            }
            RobotInfoFragment.xh(activity, param2.getChannelId(), guildID, tinyId, "", "1", false, wi(), 14);
            return;
        }
        String channelId = getChannelId();
        GuildProfileData guildProfileData = new GuildProfileData(guildID, "", tinyId, 0, 1);
        guildProfileData.getGuildBaseProfileData().r(channelId);
        GuildProfileCard.Mh(getActivity(), guildProfileData, vi());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Hi(boolean keepPending) {
        boolean z16;
        if (this.pendingAction.getTinyId().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            GuildRoleMemberListViewModel guildRoleMemberListViewModel = this.memberListViewModel;
            if (guildRoleMemberListViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("memberListViewModel");
                guildRoleMemberListViewModel = null;
            }
            guildRoleMemberListViewModel.i2(this.pendingAction);
            if (!keepPending) {
                this.pendingAction.reset();
            }
        }
    }

    static /* synthetic */ void Ii(GuildMemberListFragment guildMemberListFragment, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        guildMemberListFragment.Hi(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x011a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Ji(List<? extends IGProUserInfo> list) {
        SwipListView swipListView;
        com.tencent.mobileqq.guild.setting.member.oldmemberlist.a aVar;
        com.tencent.mobileqq.guild.setting.member.oldmemberlist.a aVar2 = null;
        if (list.isEmpty()) {
            SwipListView swipListView2 = this.searchListView;
            if (swipListView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchListView");
                swipListView2 = null;
            }
            if (swipListView2.getVisibility() == 0) {
                SwipListView swipListView3 = this.searchListView;
                if (swipListView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("searchListView");
                    swipListView3 = null;
                }
                swipListView3.setVisibility(8);
                SwipListView swipListView4 = this.searchListView;
                if (swipListView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("searchListView");
                    swipListView4 = null;
                }
                swipListView4.hideCurShowingRightView();
                LinearLayout linearLayout = this.searchEmptyView;
                if (linearLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("searchEmptyView");
                    linearLayout = null;
                }
                linearLayout.setVisibility(0);
                LinearLayout linearLayout2 = this.searchEmptyView;
                if (linearLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("searchEmptyView");
                    linearLayout2 = null;
                }
                linearLayout2.removeAllViews();
                LinearLayout linearLayout3 = this.searchEmptyView;
                if (linearLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("searchEmptyView");
                    linearLayout3 = null;
                }
                View view = new View(linearLayout3.getContext());
                view.setLayoutParams(new LinearLayout.LayoutParams(-1, ViewUtils.dpToPx(10.0f)));
                LinearLayout linearLayout4 = this.searchEmptyView;
                if (linearLayout4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("searchEmptyView");
                    linearLayout4 = null;
                }
                view.setBackground(AppCompatResources.getDrawable(linearLayout4.getContext(), R.drawable.qui_common_fill_light_primary_bg));
                LinearLayout linearLayout5 = this.searchEmptyView;
                if (linearLayout5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("searchEmptyView");
                    linearLayout5 = null;
                }
                linearLayout5.addView(view);
                QQGuildColorMemberListView qQGuildColorMemberListView = this.memberListView;
                if (qQGuildColorMemberListView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("memberListView");
                    qQGuildColorMemberListView = null;
                }
                GuildQUIEmptyState a16 = new GuildQUIEmptyState.a(qQGuildColorMemberListView.getContext()).s(9).u("\u6ca1\u6709\u641c\u7d22\u5230\u76f8\u5173\u7ed3\u679c").r(false).n(true).o(1).a();
                LinearLayout linearLayout6 = this.searchEmptyView;
                if (linearLayout6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("searchEmptyView");
                    linearLayout6 = null;
                }
                linearLayout6.addView(a16, -1, -1);
                LinearLayout linearLayout7 = this.searchEmptyView;
                if (linearLayout7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("searchEmptyView");
                    linearLayout7 = null;
                }
                linearLayout7.setGravity(17);
                swipListView = this.searchListView;
                if (swipListView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("searchListView");
                    swipListView = null;
                }
                swipListView.hideCurShowingRightView();
                aVar = this.searchListAdapter;
                if (aVar != null) {
                    Intrinsics.throwUninitializedPropertyAccessException("searchListAdapter");
                } else {
                    aVar2 = aVar;
                }
                aVar2.setData(list);
            }
        }
        if (!list.isEmpty()) {
            LinearLayout linearLayout8 = this.searchEmptyView;
            if (linearLayout8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchEmptyView");
                linearLayout8 = null;
            }
            if (linearLayout8.getVisibility() == 0) {
                SwipListView swipListView5 = this.searchListView;
                if (swipListView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("searchListView");
                    swipListView5 = null;
                }
                swipListView5.setVisibility(0);
                LinearLayout linearLayout9 = this.searchEmptyView;
                if (linearLayout9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("searchEmptyView");
                    linearLayout9 = null;
                }
                linearLayout9.setVisibility(8);
            }
        }
        swipListView = this.searchListView;
        if (swipListView == null) {
        }
        swipListView.hideCurShowingRightView();
        aVar = this.searchListAdapter;
        if (aVar != null) {
        }
        aVar2.setData(list);
    }

    private final void Ki(String text) {
        this.C.setText(text);
        if (TextUtils.isEmpty(text)) {
            DrawableType drawableType = new DrawableType(R.drawable.guild_audio_top_back_left_btn, Integer.valueOf(R.color.qui_common_icon_primary));
            TextView leftView = this.C;
            Intrinsics.checkNotNullExpressionValue(leftView, "leftView");
            drawableType.a(leftView);
            ViewGroup.LayoutParams layoutParams = this.C.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.width = Utils.n(24.0f, MobileQQ.sMobileQQ.getResources());
            layoutParams2.height = Utils.n(24.0f, MobileQQ.sMobileQQ.getResources());
            return;
        }
        this.C.setBackgroundResource(0);
        ViewGroup.LayoutParams layoutParams3 = this.C.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
        layoutParams4.width = -2;
        layoutParams4.height = -2;
    }

    private final void Li() {
        QQGuildColorMemberListView qQGuildColorMemberListView = this.memberListView;
        RelativeLayout relativeLayout = null;
        if (qQGuildColorMemberListView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberListView");
            qQGuildColorMemberListView = null;
        }
        qQGuildColorMemberListView.setEditMode(false);
        QQGuildMemberListViewModel qQGuildMemberListViewModel = this.viewModel;
        if (qQGuildMemberListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            qQGuildMemberListViewModel = null;
        }
        boolean o26 = qQGuildMemberListViewModel.o2();
        Ni();
        Mi();
        Pi(true);
        QQGuildMemberListViewModel qQGuildMemberListViewModel2 = this.viewModel;
        if (qQGuildMemberListViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            qQGuildMemberListViewModel2 = null;
        }
        qQGuildMemberListViewModel2.u2(false);
        Ki("");
        if (o26) {
            RelativeLayout relativeLayout2 = this.searchBar;
            if (relativeLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchBar");
            } else {
                relativeLayout = relativeLayout2;
            }
            relativeLayout.setVisibility(0);
        }
    }

    private final void Mi() {
        ImageView imageView = this.topInviteView;
        QQGuildMemberListViewModel qQGuildMemberListViewModel = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topInviteView");
            imageView = null;
        }
        imageView.setOnClickListener(this);
        ImageView imageView2 = this.topInviteView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topInviteView");
            imageView2 = null;
        }
        Context context = imageView2.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "topInviteView.context");
        Drawable w3 = GuildUIUtils.w(context, R.drawable.guild_title_top_right_add_icon, Integer.valueOf(R.color.qui_common_icon_primary));
        ImageView imageView3 = this.topInviteView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topInviteView");
            imageView3 = null;
        }
        imageView3.setImageDrawable(w3);
        ImageView imageView4 = this.topInviteView;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topInviteView");
            imageView4 = null;
        }
        imageView4.setVisibility(0);
        ImageView imageView5 = this.topInviteView;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topInviteView");
            imageView5 = null;
        }
        imageView5.setScaleType(ImageView.ScaleType.FIT_CENTER);
        ImageView imageView6 = this.topInviteView;
        if (imageView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topInviteView");
            imageView6 = null;
        }
        imageView6.setPadding(0, 0, 0, 0);
        ImageView imageView7 = this.topInviteView;
        if (imageView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topInviteView");
            imageView7 = null;
        }
        ViewGroup.LayoutParams layoutParams = imageView7.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.width = QQGuildUIUtil.f(24.0f);
        layoutParams2.height = QQGuildUIUtil.f(24.0f);
        layoutParams2.addRule(11);
        QQGuildMemberListViewModel qQGuildMemberListViewModel2 = this.viewModel;
        if (qQGuildMemberListViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            qQGuildMemberListViewModel = qQGuildMemberListViewModel2;
        }
        if (qQGuildMemberListViewModel.O1()) {
            layoutParams2.rightMargin = QQGuildUIUtil.f(51.0f);
        } else {
            layoutParams2.rightMargin = QQGuildUIUtil.f(13.0f);
        }
    }

    private final void Ni() {
        QQGuildMemberListViewModel qQGuildMemberListViewModel = this.viewModel;
        ImageView imageView = null;
        if (qQGuildMemberListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            qQGuildMemberListViewModel = null;
        }
        if (qQGuildMemberListViewModel.O1() && !this.isTransferGuild) {
            this.F.setVisibility(0);
            this.F.setOnClickListener(this);
            this.F.setText("");
            ImageView imageView2 = this.topInviteView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topInviteView");
            } else {
                imageView = imageView2;
            }
            Context context = imageView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "topInviteView.context");
            this.F.setBackground(GuildUIUtils.w(context, R.drawable.guild_title_top_right_more_icon, Integer.valueOf(R.color.qui_common_icon_primary)));
            this.F.setPadding(0, 0, 0, 0);
            ViewGroup.LayoutParams layoutParams = this.F.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.width = QQGuildUIUtil.f(24.0f);
            layoutParams2.height = QQGuildUIUtil.f(24.0f);
            layoutParams2.addRule(11);
            layoutParams2.rightMargin = QQGuildUIUtil.f(13.0f);
            return;
        }
        this.F.setVisibility(8);
    }

    private final void Oi(String text) {
        this.F.setVisibility(0);
        this.F.setOnClickListener(this);
        this.F.setText(text);
        this.F.setBackgroundResource(0);
        ViewGroup.LayoutParams layoutParams = this.F.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.addRule(11);
        layoutParams2.width = -2;
        layoutParams2.height = -2;
        layoutParams2.rightMargin = QQGuildUIUtil.f(12.0f);
    }

    private final void Pi(boolean enable) {
        this.F.setEnabled(enable);
        setRightButtonEnable(enable);
    }

    private final void Qi() {
        this.E.setText("\u8f6c\u8ba9\u9891\u9053");
        Wi(false);
        this.G.setVisibility(0);
        this.G.setOnClickListener(this);
        Context context = this.G.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "rightViewImg.context");
        this.G.setImageDrawable(GuildUIUtils.w(context, R.drawable.guild_info_circle, Integer.valueOf(R.color.qui_common_text_primary)));
        QQGuildColorMemberListView qQGuildColorMemberListView = this.memberListView;
        SwipListView swipListView = null;
        if (qQGuildColorMemberListView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberListView");
            qQGuildColorMemberListView = null;
        }
        qQGuildColorMemberListView.setDragEnable(false);
        SwipListView swipListView2 = this.searchListView;
        if (swipListView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchListView");
        } else {
            swipListView = swipListView2;
        }
        swipListView.setDragEnable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ri(List<? extends IGProUserInfo> selectedUsers) {
        if (selectedUsers.isEmpty()) {
            Logger.f235387a.d().i("Guild.userl.GuildMemberListFragment", 1, "showDeleteMoreUserDialog no select delete user!");
        } else {
            U3(selectedUsers);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void Si(GuildMemberListFragment guildMemberListFragment, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            QQGuildColorMemberListView qQGuildColorMemberListView = guildMemberListFragment.memberListView;
            if (qQGuildColorMemberListView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("memberListView");
                qQGuildColorMemberListView = null;
            }
            list = qQGuildColorMemberListView.k();
            Intrinsics.checkNotNullExpressionValue(list, "memberListView.selectedUserInfoList");
        }
        guildMemberListFragment.Ri(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ti() {
        QQGuildColorMemberListView qQGuildColorMemberListView = this.memberListView;
        if (qQGuildColorMemberListView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberListView");
            qQGuildColorMemberListView = null;
        }
        GuildQUIEmptyState a16 = new GuildQUIEmptyState.a(qQGuildColorMemberListView.getContext()).s(3).u("\u6682\u65e0\u6210\u5458").r(false).n(true).o(1).a();
        View contentView = getContentView();
        Intrinsics.checkNotNull(contentView, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) contentView).removeAllViews();
        View contentView2 = getContentView();
        Intrinsics.checkNotNull(contentView2, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) contentView2).addView(a16, -1, -1);
    }

    private final void Ui(final List<String> deleteTinyIds, final boolean isAllRobot) {
        QQGuildMemberListViewModel qQGuildMemberListViewModel = null;
        Dialog createDialog = ActionSheetHelper.createDialog(getActivity(), null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        actionSheet.addButton(R.string.f140270di, 3);
        QQGuildMemberListViewModel qQGuildMemberListViewModel2 = this.viewModel;
        if (qQGuildMemberListViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            qQGuildMemberListViewModel = qQGuildMemberListViewModel2;
        }
        if (qQGuildMemberListViewModel.N1()) {
            actionSheet.addButton(R.string.f1520219_, 3);
        }
        if (deleteTinyIds.size() > 1) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String qqStr = HardCodeUtil.qqStr(R.string.f140640ei);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.guild_batch_remove_guild_title)");
            String format = String.format(qqStr, Arrays.copyOf(new Object[]{Integer.valueOf(deleteTinyIds.size())}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            actionSheet.setMainTitle(format);
        }
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.guild.setting.member.fragments.b
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                GuildMemberListFragment.Vi(deleteTinyIds, this, isAllRobot, actionSheet, view, i3);
            }
        });
        actionSheet.addCancelButton(R.string.f140850f3);
        actionSheet.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vi(List deleteTinyIds, GuildMemberListFragment this$0, boolean z16, ActionSheet actionSheet, View view, int i3) {
        Intrinsics.checkNotNullParameter(deleteTinyIds, "$deleteTinyIds");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        QQGuildMemberListViewModel qQGuildMemberListViewModel = null;
        if (i3 != 0) {
            if (i3 == 1) {
                if (deleteTinyIds.size() > 1) {
                    this$0.yi(deleteTinyIds, true, 0, z16);
                } else {
                    FragmentActivity requireActivity = this$0.requireActivity();
                    QQGuildMemberListViewModel qQGuildMemberListViewModel2 = this$0.viewModel;
                    if (qQGuildMemberListViewModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    } else {
                        qQGuildMemberListViewModel = qQGuildMemberListViewModel2;
                    }
                    GuildRemoveGuildDialogFragment.vh(requireActivity, qQGuildMemberListViewModel.getGuildInfo().getGuildID(), deleteTinyIds, true, z16, true, new y(deleteTinyIds, z16));
                }
                actionSheet.dismiss();
                return;
            }
            return;
        }
        if (deleteTinyIds.size() > 1) {
            this$0.yi(deleteTinyIds, false, 0, z16);
        } else {
            FragmentActivity requireActivity2 = this$0.requireActivity();
            QQGuildMemberListViewModel qQGuildMemberListViewModel3 = this$0.viewModel;
            if (qQGuildMemberListViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                qQGuildMemberListViewModel = qQGuildMemberListViewModel3;
            }
            GuildRemoveGuildDialogFragment.vh(requireActivity2, qQGuildMemberListViewModel.getGuildInfo().getGuildID(), deleteTinyIds, true, z16, false, new x(deleteTinyIds, z16));
        }
        actionSheet.dismiss();
    }

    private final void Wi(boolean showInvite) {
        int i3;
        ImageView imageView = this.topInviteView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topInviteView");
            imageView = null;
        }
        if (showInvite) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    private final void Xi() {
        boolean z16;
        QQGuildMCParser.Companion companion = QQGuildMCParser.INSTANCE;
        String f16 = companion.f("105827", "title", "\u8f6c\u8ba9\u89c4\u5219");
        String f17 = companion.f("105827", "content", "1.\u8f6c\u8ba9\u6210\u529f\u540e\uff0c\u5c06\u89c6\u4e3a\u4e3b\u52a8\u653e\u5f03\u9891\u9053\u4e3b\u8eab\u4efd\uff0c\u65e0\u6cd5\u8fdb\u884c\u8eab\u4efd\u6062\u590d\u3002\n\n2.\u63a5\u6536\u65b9\u9700\u6ee1\u8db3\u4ee5\u4e0b\u6761\u4ef6\u65b9\u53ef\u8f6c\u8ba9\u6210\u529f\uff1a\n\u00b7\u63a5\u6536\u65b9\u9700\u662f\u4f607\u5929\u4ee5\u4e0a\u7684QQ\u597d\u53cb\uff1b\n\u00b7\u63a5\u6536\u65b9\u9700\u662f\u8be5\u9891\u9053\u6210\u5458\u4e14\u672a\u8fdb\u5165\u9ed1\u540d\u5355\uff1b\n\u00b7\u63a5\u6536\u65b9\u9700\u786e\u4fdd\u8d26\u53f7\u6b63\u5e38\u672a\u89e6\u72afQQ\u5e73\u53f0\u89c4\u5219\u3002\n\n3.\u5e73\u53f0\u62e5\u6709\u9891\u9053\u8f6c\u8ba9\u7684\u6700\u7ec8\u89e3\u91ca\u6743\u3002\n");
        boolean z17 = false;
        if (f16 != null && f16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            if (f17 == null || f17.length() == 0) {
                z17 = true;
            }
            if (!z17) {
                GuildTransferRuleDialog.Companion companion2 = GuildTransferRuleDialog.INSTANCE;
                FragmentManager supportFragmentManager = requireActivity().getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "requireActivity().supportFragmentManager");
                companion2.a(supportFragmentManager, f16, f17);
                return;
            }
        }
        Logger.f235387a.d().i("Guild.userl.GuildMemberListFragment", 1, "showTransferRule title " + f16 + " content " + f17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Yi() {
        com.tencent.mobileqq.guild.setting.member.oldmemberlist.a aVar = this.searchListAdapter;
        EditText editText = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchListAdapter");
            aVar = null;
        }
        aVar.setData(new ArrayList());
        QQGuildMemberListViewModel qQGuildMemberListViewModel = this.viewModel;
        if (qQGuildMemberListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            qQGuildMemberListViewModel = null;
        }
        qQGuildMemberListViewModel.P1();
        SwipListView swipListView = this.searchListView;
        if (swipListView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchListView");
            swipListView = null;
        }
        swipListView.setVisibility(8);
        SwipListView swipListView2 = this.searchListView;
        if (swipListView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchListView");
            swipListView2 = null;
        }
        swipListView2.hideCurShowingRightView();
        LinearLayout linearLayout = this.searchEmptyView;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchEmptyView");
            linearLayout = null;
        }
        linearLayout.setVisibility(8);
        GuildMemberTopCardList guildMemberTopCardList = this.channelMemberCardView;
        if (guildMemberTopCardList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelMemberCardView");
            guildMemberTopCardList = null;
        }
        guildMemberTopCardList.setOnlineChannelCardViewShow(true);
        TextView textView = this.mSearchCancel;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSearchCancel");
            textView = null;
        }
        textView.setVisibility(8);
        QQGuildColorMemberListView qQGuildColorMemberListView = this.memberListView;
        if (qQGuildColorMemberListView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberListView");
            qQGuildColorMemberListView = null;
        }
        qQGuildColorMemberListView.setVisibility(0);
        EditText editText2 = this.searchEditText;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
            editText2 = null;
        }
        editText2.setHint((CharSequence) null);
        EditText editText3 = this.searchEditText;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
            editText3 = null;
        }
        editText3.setText("");
        ImageView imageView = this.leftSearchIconView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftSearchIconView");
            imageView = null;
        }
        imageView.setVisibility(8);
        RelativeLayout relativeLayout = this.searchBar;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBar");
            relativeLayout = null;
        }
        relativeLayout.findViewById(R.id.f110986k0).setVisibility(0);
        EditText editText4 = this.searchEditText;
        if (editText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
            editText4 = null;
        }
        InputMethodUtil.hide(editText4);
        EditText editText5 = this.searchEditText;
        if (editText5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
        } else {
            editText = editText5;
        }
        editText.clearFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Zi() {
        EditText editText = this.searchEditText;
        EditText editText2 = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
            editText = null;
        }
        if (editText.hasFocus()) {
            return;
        }
        GuildMemberTopCardList guildMemberTopCardList = this.channelMemberCardView;
        if (guildMemberTopCardList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelMemberCardView");
            guildMemberTopCardList = null;
        }
        guildMemberTopCardList.setOnlineChannelCardViewShow(false);
        TextView textView = this.mSearchCancel;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSearchCancel");
            textView = null;
        }
        textView.setVisibility(0);
        ImageView imageView = this.leftSearchIconView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("leftSearchIconView");
            imageView = null;
        }
        imageView.setVisibility(0);
        RelativeLayout relativeLayout = this.searchBar;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBar");
            relativeLayout = null;
        }
        relativeLayout.findViewById(R.id.f110986k0).setVisibility(8);
        EditText editText3 = this.searchEditText;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
        } else {
            editText2 = editText3;
        }
        editText2.setHint(getString(R.string.f155451hj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void aj(Boolean canInvite) {
        ImageView imageView = this.topInviteView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topInviteView");
            imageView = null;
        }
        float f16 = 1.0f;
        if (canInvite != null && !canInvite.booleanValue()) {
            f16 = 0.3f;
        }
        imageView.setAlpha(f16);
    }

    private final String getChannelId() {
        boolean z16;
        Param param = this.param;
        if (param == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            param = null;
        }
        String channelId = param.getChannelId();
        if (channelId.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return "";
        }
        return channelId;
    }

    private final View getContentView() {
        View mContentView = this.P;
        Intrinsics.checkNotNullExpressionValue(mContentView, "mContentView");
        return mContentView;
    }

    private final void initData() {
        QQGuildColorMemberListView qQGuildColorMemberListView;
        c.Companion companion = ef1.c.INSTANCE;
        QQGuildMemberListViewModel qQGuildMemberListViewModel = (QQGuildMemberListViewModel) companion.c(this, QQGuildMemberListViewModel.class, new Function0<QQGuildMemberListViewModel>() { // from class: com.tencent.mobileqq.guild.setting.member.fragments.GuildMemberListFragment$initData$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QQGuildMemberListViewModel invoke() {
                return new QQGuildMemberListViewModel(new wy1.a());
            }
        });
        this.viewModel = qQGuildMemberListViewModel;
        QQGuildMemberListViewModel qQGuildMemberListViewModel2 = null;
        if (qQGuildMemberListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            qQGuildMemberListViewModel = null;
        }
        AppInterface appInterface = getAppInterface();
        Param param = this.param;
        if (param == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            param = null;
        }
        IGProGuildInfo guildInfo = param.getGuildInfo();
        Param param2 = this.param;
        if (param2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            param2 = null;
        }
        qQGuildMemberListViewModel.l2(appInterface, guildInfo, param2.getChannelId());
        QQGuildMemberListViewModel qQGuildMemberListViewModel3 = this.viewModel;
        if (qQGuildMemberListViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            qQGuildMemberListViewModel3 = null;
        }
        qQGuildMemberListViewModel3.v2(this.isTransferGuild);
        GuildRoleMemberListViewModel guildRoleMemberListViewModel = (GuildRoleMemberListViewModel) companion.c(this, GuildRoleMemberListViewModel.class, new Function0<GuildRoleMemberListViewModel>() { // from class: com.tencent.mobileqq.guild.setting.member.fragments.GuildMemberListFragment$initData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildRoleMemberListViewModel invoke() {
                GuildMemberListFragment.Param param3 = GuildMemberListFragment.this.param;
                if (param3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("param");
                    param3 = null;
                }
                return new GuildRoleMemberListViewModel(param3.getGuildInfo(), "", r.f232798e, Boolean.valueOf(GuildMemberListFragment.this.getIsTransferGuild()));
            }
        });
        this.memberListViewModel = guildRoleMemberListViewModel;
        if (guildRoleMemberListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberListViewModel");
            guildRoleMemberListViewModel = null;
        }
        guildRoleMemberListViewModel.k2(this.preLoadHelper);
        QQGuildColorMemberListView qQGuildColorMemberListView2 = this.memberListView;
        if (qQGuildColorMemberListView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberListView");
            qQGuildColorMemberListView = null;
        } else {
            qQGuildColorMemberListView = qQGuildColorMemberListView2;
        }
        QQGuildMemberListViewModel qQGuildMemberListViewModel4 = this.viewModel;
        if (qQGuildMemberListViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            qQGuildMemberListViewModel4 = null;
        }
        String guildID = qQGuildMemberListViewModel4.getGuildInfo().getGuildID();
        Param param3 = this.param;
        if (param3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            param3 = null;
        }
        boolean v06 = ch.v0(param3.getGuildInfo());
        QQGuildMemberListViewModel qQGuildMemberListViewModel5 = this.viewModel;
        if (qQGuildMemberListViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            qQGuildMemberListViewModel5 = null;
        }
        qQGuildColorMemberListView.l(guildID, "", v06, qQGuildMemberListViewModel5.O1(), this.onMemberListViewHandler);
        QQGuildMemberListViewModel qQGuildMemberListViewModel6 = this.viewModel;
        if (qQGuildMemberListViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            qQGuildMemberListViewModel6 = null;
        }
        this.searchListAdapter = new com.tencent.mobileqq.guild.setting.member.oldmemberlist.a(this, qQGuildMemberListViewModel6, new h());
        SwipListView swipListView = this.searchListView;
        if (swipListView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchListView");
            swipListView = null;
        }
        TextView textView = new TextView(swipListView.getContext());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, ViewUtils.dpToPx(45.0f)));
        textView.setGravity(17);
        textView.setTextSize(14.0f);
        textView.setTextColor(textView.getContext().getColor(R.color.qui_common_text_tertiary));
        this.searchFootView = textView;
        SwipListView swipListView2 = this.searchListView;
        if (swipListView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchListView");
            swipListView2 = null;
        }
        TextView textView2 = this.searchFootView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchFootView");
            textView2 = null;
        }
        swipListView2.addFooterView(textView2);
        SwipListView swipListView3 = this.searchListView;
        if (swipListView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchListView");
            swipListView3 = null;
        }
        com.tencent.mobileqq.guild.setting.member.oldmemberlist.a aVar = this.searchListAdapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchListAdapter");
            aVar = null;
        }
        swipListView3.setAdapter((ListAdapter) aVar);
        ti(true);
        Li();
        zi();
        QQGuildMemberListViewModel qQGuildMemberListViewModel7 = this.viewModel;
        if (qQGuildMemberListViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            qQGuildMemberListViewModel7 = null;
        }
        qQGuildMemberListViewModel7.R1();
        GuildRoleMemberListViewModel guildRoleMemberListViewModel2 = this.memberListViewModel;
        if (guildRoleMemberListViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberListViewModel");
            guildRoleMemberListViewModel2 = null;
        }
        guildRoleMemberListViewModel2.refresh();
        boolean z16 = requireArguments().getBoolean("param_is_edit_model", false);
        this.isEditModel = z16;
        if (z16) {
            Ei();
        } else if (this.isTransferGuild) {
            Qi();
            RelativeLayout relativeLayout = this.searchBar;
            if (relativeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchBar");
                relativeLayout = null;
            }
            relativeLayout.setVisibility(8);
        }
        QQGuildMemberListViewModel qQGuildMemberListViewModel8 = this.viewModel;
        if (qQGuildMemberListViewModel8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            qQGuildMemberListViewModel2 = qQGuildMemberListViewModel8;
        }
        aj(qQGuildMemberListViewModel2.W1().getValue());
    }

    private final void initDtReport() {
        View view;
        HashMap hashMap = new HashMap();
        com.tencent.mobileqq.guild.data.w.a(hashMap);
        View contentView = getContentView();
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        Param param = this.param;
        ImageView imageView = null;
        if (param == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            param = null;
        }
        String guildID = param.getGuildInfo().getGuildID();
        Intrinsics.checkNotNullExpressionValue(guildID, "param.guildInfo.guildID");
        Object parent = contentView.getParent();
        if (parent instanceof View) {
            view = (View) parent;
        } else {
            view = null;
        }
        if (view != null) {
            contentView = view;
        }
        VideoReport.addToDetectionWhitelist(requireActivity);
        VideoReport.setPageId(contentView, "pg_sgrp_member_list");
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(contentView, guildID, hashMap);
        TextView textView = this.F;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        VideoReport.setElementId(textView, "em_sgrp_member_list_multi_member_manage_set");
        VideoReport.setElementExposePolicy(textView, exposurePolicy);
        VideoReport.setElementClickPolicy(textView, clickPolicy);
        TextView textView2 = this.E;
        ExposurePolicy exposurePolicy2 = ExposurePolicy.REPORT_ALL;
        ClickPolicy clickPolicy2 = ClickPolicy.REPORT_ALL;
        VideoReport.setElementId(textView2, "em_sgrp_member_list_member_manage");
        VideoReport.setElementExposePolicy(textView2, exposurePolicy2);
        VideoReport.setElementClickPolicy(textView2, clickPolicy2);
        ImageView imageView2 = this.closeSearchButton;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeSearchButton");
        } else {
            imageView = imageView2;
        }
        ExposurePolicy exposurePolicy3 = ExposurePolicy.REPORT_FIRST;
        VideoReport.setElementId(imageView, "em_sgrp_member_list_search");
        VideoReport.setElementExposePolicy(imageView, exposurePolicy3);
        VideoReport.setElementClickPolicy(imageView, clickPolicy);
    }

    private final void initView() {
        boolean z16 = true;
        if (requireArguments().getInt("param_is_transfer_guild", 0) != 1) {
            z16 = false;
        }
        this.isTransferGuild = z16;
        this.C.setOnClickListener(this);
        this.C.setFocusable(false);
        this.F.setFocusable(false);
        this.C.setTextColor(-16777216);
        this.E.setText(R.string.f1502014c);
        View findViewById = getContentView().findViewById(R.id.f778645i);
        Intrinsics.checkNotNullExpressionValue(findViewById, "contentView.findViewById\u2026id.role_member_list_view)");
        QQGuildColorMemberListView qQGuildColorMemberListView = (QQGuildColorMemberListView) findViewById;
        this.memberListView = qQGuildColorMemberListView;
        ImageView imageView = null;
        byte b16 = 0;
        byte b17 = 0;
        if (qQGuildColorMemberListView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberListView");
            qQGuildColorMemberListView = null;
        }
        qQGuildColorMemberListView.setPreLoadHelper(this.preLoadHelper);
        this.loadingMemberEmptyView = new GuildLoadingMemberEmptyView(requireContext());
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        GuildMemberTopCardList guildMemberTopCardList = new GuildMemberTopCardList(requireContext, b17 == true ? 1 : 0, 2, b16 == true ? 1 : 0);
        guildMemberTopCardList.e(this);
        guildMemberTopCardList.setOnMemberCardItemClickListener(this);
        this.channelMemberCardView = guildMemberTopCardList;
        QQGuildColorMemberListView qQGuildColorMemberListView2 = this.memberListView;
        if (qQGuildColorMemberListView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberListView");
            qQGuildColorMemberListView2 = null;
        }
        GuildLoadingMemberEmptyView guildLoadingMemberEmptyView = this.loadingMemberEmptyView;
        if (guildLoadingMemberEmptyView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingMemberEmptyView");
            guildLoadingMemberEmptyView = null;
        }
        qQGuildColorMemberListView2.i(guildLoadingMemberEmptyView);
        QQGuildColorMemberListView qQGuildColorMemberListView3 = this.memberListView;
        if (qQGuildColorMemberListView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberListView");
            qQGuildColorMemberListView3 = null;
        }
        GuildMemberTopCardList guildMemberTopCardList2 = this.channelMemberCardView;
        if (guildMemberTopCardList2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelMemberCardView");
            guildMemberTopCardList2 = null;
        }
        qQGuildColorMemberListView3.i(guildMemberTopCardList2);
        GuildLoadingMemberEmptyView guildLoadingMemberEmptyView2 = this.loadingMemberEmptyView;
        if (guildLoadingMemberEmptyView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingMemberEmptyView");
            guildLoadingMemberEmptyView2 = null;
        }
        guildLoadingMemberEmptyView2.c();
        View findViewById2 = getContentView().findViewById(R.id.search_box);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "contentView.findViewById(R.id.search_box)");
        this.searchBar = (RelativeLayout) findViewById2;
        View findViewById3 = getContentView().findViewById(R.id.et_search_keyword);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "contentView.findViewById(R.id.et_search_keyword)");
        this.searchEditText = (EditText) findViewById3;
        View findViewById4 = getContentView().findViewById(R.id.ib_clear_text);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "contentView.findViewById(R.id.ib_clear_text)");
        this.closeSearchButton = (ImageView) findViewById4;
        View findViewById5 = getContentView().findViewById(R.id.ijd);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "contentView.findViewById(R.id.search_cancel)");
        this.mSearchCancel = (TextView) findViewById5;
        View findViewById6 = getContentView().findViewById(R.id.search_result_list);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "contentView.findViewById(R.id.search_result_list)");
        SwipListView swipListView = (SwipListView) findViewById6;
        this.searchListView = swipListView;
        if (swipListView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchListView");
            swipListView = null;
        }
        swipListView.setOnScrollListener(si());
        View findViewById7 = getContentView().findViewById(R.id.f80874cn);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "contentView.findViewById(R.id.search_empty_view)");
        this.searchEmptyView = (LinearLayout) findViewById7;
        View findViewById8 = getContentView().findViewById(R.id.yhf);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "contentView.findViewById(R.id.left_search_icon)");
        this.leftSearchIconView = (ImageView) findViewById8;
        View titleBarView = getTitleBarView();
        Intrinsics.checkNotNull(titleBarView, "null cannot be cast to non-null type com.tencent.mobileqq.guild.widget.GuildDefaultThemeNavBarCommon");
        GuildDefaultThemeNavBarCommon guildDefaultThemeNavBarCommon = (GuildDefaultThemeNavBarCommon) titleBarView;
        View findViewById9 = guildDefaultThemeNavBarCommon.findViewById(R.id.dsr);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "titleBar.findViewById(R.\u2026TitleBtnRightImageSecond)");
        ImageView imageView2 = (ImageView) findViewById9;
        this.topInviteView = imageView2;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topInviteView");
        } else {
            imageView = imageView2;
        }
        imageView.setFocusable(false);
        guildDefaultThemeNavBarCommon.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void mi(final IGProUserInfo userInfo) {
        EditText editText = this.searchEditText;
        EditText editText2 = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
            editText = null;
        }
        Object systemService = editText.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        if (((InputMethodManager) systemService).isActive()) {
            EditText editText3 = this.searchEditText;
            if (editText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
            } else {
                editText2 = editText3;
            }
            InputMethodUtil.hide(editText2);
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.setting.member.fragments.c
                @Override // java.lang.Runnable
                public final void run() {
                    GuildMemberListFragment.ni(GuildMemberListFragment.this, userInfo);
                }
            }, 50L);
            return;
        }
        oi(userInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ni(GuildMemberListFragment this$0, IGProUserInfo userInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(userInfo, "$userInfo");
        this$0.oi(userInfo);
    }

    private final void oi(IGProUserInfo userInfo) {
        QQGuildMemberListViewModel qQGuildMemberListViewModel = this.viewModel;
        if (qQGuildMemberListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            qQGuildMemberListViewModel = null;
        }
        GuildAgainConfirmData guildAgainConfirmData = new GuildAgainConfirmData("\u8f6c\u8ba9\u201c" + qQGuildMemberListViewModel.getGuildInfo().getGuildName() + "\u201d", ch.d0(userInfo) + "\u5c06\u6210\u4e3a\u9891\u9053\u4e3b\uff0c\u786e\u8ba4\u540e\u4f60\u5c06\u7acb\u5373\u5931\u53bb\u9891\u9053\u4e3b\u8eab\u4efd\u3001\u89e3\u9664\u5e7f\u544a\u7b7e\u7ea6\u72b6\u6001\uff0c\u4e14\u65e0\u6cd5\u6062\u590d\u3002", "\u8f6c\u8ba9\u9891\u9053", "\u786e\u8ba4\u8f6c\u8ba9\u9891\u9053", 0, null, 48, null);
        GuildAgainConfirmDialog.Companion companion = GuildAgainConfirmDialog.INSTANCE;
        FragmentManager supportFragmentManager = requireActivity().getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "requireActivity().supportFragmentManager");
        companion.a(supportFragmentManager, guildAgainConfirmData, new c(userInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GuildProfileCard.e pi() {
        return new d();
    }

    private final j.b qi() {
        return new e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RobotInfoFragment.a ri() {
        return new f();
    }

    private final AbsListView.OnScrollListener si() {
        return new g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startSearch(String keyword) {
        boolean z16;
        if (keyword.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        QQGuildMemberListViewModel qQGuildMemberListViewModel = null;
        QQGuildColorMemberListView qQGuildColorMemberListView = null;
        if (z16) {
            com.tencent.mobileqq.guild.setting.member.oldmemberlist.a aVar = this.searchListAdapter;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchListAdapter");
                aVar = null;
            }
            aVar.setData(new ArrayList());
            QQGuildMemberListViewModel qQGuildMemberListViewModel2 = this.viewModel;
            if (qQGuildMemberListViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                qQGuildMemberListViewModel2 = null;
            }
            qQGuildMemberListViewModel2.P1();
            ImageView imageView = this.closeSearchButton;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("closeSearchButton");
                imageView = null;
            }
            imageView.setVisibility(8);
            SwipListView swipListView = this.searchListView;
            if (swipListView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchListView");
                swipListView = null;
            }
            swipListView.setVisibility(8);
            SwipListView swipListView2 = this.searchListView;
            if (swipListView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchListView");
                swipListView2 = null;
            }
            swipListView2.hideCurShowingRightView();
            LinearLayout linearLayout = this.searchEmptyView;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchEmptyView");
                linearLayout = null;
            }
            linearLayout.setVisibility(8);
            QQGuildColorMemberListView qQGuildColorMemberListView2 = this.memberListView;
            if (qQGuildColorMemberListView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("memberListView");
            } else {
                qQGuildColorMemberListView = qQGuildColorMemberListView2;
            }
            qQGuildColorMemberListView.setVisibility(0);
            return;
        }
        SwipListView swipListView3 = this.searchListView;
        if (swipListView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchListView");
            swipListView3 = null;
        }
        swipListView3.setVisibility(0);
        QQGuildColorMemberListView qQGuildColorMemberListView3 = this.memberListView;
        if (qQGuildColorMemberListView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberListView");
            qQGuildColorMemberListView3 = null;
        }
        qQGuildColorMemberListView3.setVisibility(8);
        ImageView imageView2 = this.closeSearchButton;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeSearchButton");
            imageView2 = null;
        }
        imageView2.setVisibility(0);
        SwipListView swipListView4 = this.searchListView;
        if (swipListView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchListView");
            swipListView4 = null;
        }
        swipListView4.setSelection(0);
        QQGuildMemberListViewModel qQGuildMemberListViewModel3 = this.viewModel;
        if (qQGuildMemberListViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            qQGuildMemberListViewModel = qQGuildMemberListViewModel3;
        }
        qQGuildMemberListViewModel.y2(keyword);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void ti(boolean enable) {
        SwipListView swipListView = this.searchListView;
        TextView textView = null;
        if (swipListView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchListView");
            swipListView = null;
        }
        swipListView.setDragEnable(enable);
        if (enable) {
            RelativeLayout relativeLayout = this.searchBar;
            if (relativeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchBar");
                relativeLayout = null;
            }
            relativeLayout.setVisibility(0);
            EditText editText = this.searchEditText;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
                editText = null;
            }
            editText.clearFocus();
            EditText editText2 = this.searchEditText;
            if (editText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
                editText2 = null;
            }
            editText2.addTextChangedListener(new b());
            EditText editText3 = this.searchEditText;
            if (editText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
                editText3 = null;
            }
            editText3.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.guild.setting.member.fragments.a
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean ui5;
                    ui5 = GuildMemberListFragment.ui(GuildMemberListFragment.this, view, motionEvent);
                    return ui5;
                }
            });
            ImageView imageView = this.closeSearchButton;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("closeSearchButton");
                imageView = null;
            }
            imageView.setOnClickListener(this);
            TextView textView2 = this.mSearchCancel;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSearchCancel");
            } else {
                textView = textView2;
            }
            textView.setOnClickListener(this);
            getContentView().setFocusableInTouchMode(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ui(GuildMemberListFragment this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQGuildMemberListViewModel qQGuildMemberListViewModel = this$0.viewModel;
        if (qQGuildMemberListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            qQGuildMemberListViewModel = null;
        }
        qQGuildMemberListViewModel.w2(true);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GuildProfileCard.e vi() {
        return (GuildProfileCard.e) this.onProfileCardShow.getValue();
    }

    private final RobotInfoFragment.a wi() {
        return (RobotInfoFragment.a) this.onRobotCardShow.getValue();
    }

    private final JumpGuildParam xi(String channelId) {
        IGProChannelInfo channelInfo = ((IGPSService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGPSService.class, "")).getChannelInfo(channelId);
        JumpGuildParam jumpGuildParam = new JumpGuildParam(channelInfo.getGuildId(), channelInfo.getChannelUin());
        jumpGuildParam.extras.putInt(JumpGuildParam.EXTRA_KEY_OPEN_FROM, 1);
        return jumpGuildParam;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void yi(List<String> deleteTinyIds, final boolean toBlack, int msgRevokeType, boolean isAllRobot) {
        GuildRoleMemberListViewModel guildRoleMemberListViewModel = this.memberListViewModel;
        if (guildRoleMemberListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberListViewModel");
            guildRoleMemberListViewModel = null;
        }
        guildRoleMemberListViewModel.j2(deleteTinyIds, toBlack, msgRevokeType, new Function1<ri1.a, Unit>() { // from class: com.tencent.mobileqq.guild.setting.member.fragments.GuildMemberListFragment$handleDeleteUserInner$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ri1.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ri1.a aVar) {
                String string;
                WeakReferenceHandler weakReferenceHandler;
                int i3;
                if (aVar.d()) {
                    SimpleEventBus.getInstance().dispatchEvent(new UpdateMemberDataEvent());
                    if (toBlack) {
                        string = this.getString(R.string.f152301_1);
                    } else {
                        string = this.getString(R.string.f1500413x);
                    }
                    Intrinsics.checkNotNullExpressionValue(string, "if (toBlack) {\n         \u2026_sucss)\n                }");
                    ch.u1(this.getContext(), string);
                    weakReferenceHandler = this.uiHandler;
                    i3 = this.MSG_CODE_REMOVE_DELETE_DIALOG;
                    weakReferenceHandler.removeMessages(i3);
                    QQGuildColorMemberListView qQGuildColorMemberListView = this.memberListView;
                    QQGuildColorMemberListView qQGuildColorMemberListView2 = null;
                    if (qQGuildColorMemberListView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("memberListView");
                        qQGuildColorMemberListView = null;
                    }
                    qQGuildColorMemberListView.k().clear();
                    GuildMemberListFragment guildMemberListFragment = this;
                    QQGuildColorMemberListView qQGuildColorMemberListView3 = guildMemberListFragment.memberListView;
                    if (qQGuildColorMemberListView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("memberListView");
                    } else {
                        qQGuildColorMemberListView2 = qQGuildColorMemberListView3;
                    }
                    List<IGProUserInfo> k3 = qQGuildColorMemberListView2.k();
                    Intrinsics.checkNotNullExpressionValue(k3, "memberListView.selectedUserInfoList");
                    guildMemberListFragment.Di(k3);
                    return;
                }
                String str = aVar.f431478b;
                if (str.length() == 0) {
                    str = HardCodeUtil.qqStr(R.string.f1500313w);
                }
                QQToastUtil.showQQToast(1, str);
            }
        });
    }

    private final void zi() {
        QQGuildMemberListViewModel qQGuildMemberListViewModel = this.viewModel;
        QQGuildMemberListViewModel qQGuildMemberListViewModel2 = null;
        if (qQGuildMemberListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            qQGuildMemberListViewModel = null;
        }
        LiveData<Boolean> Z1 = qQGuildMemberListViewModel.Z1();
        Intrinsics.checkNotNullExpressionValue(Z1, "viewModel.isSearchModeLiveData");
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        Z1.observe(viewLifecycleOwner, new o());
        QQGuildMemberListViewModel qQGuildMemberListViewModel3 = this.viewModel;
        if (qQGuildMemberListViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            qQGuildMemberListViewModel3 = null;
        }
        LiveData<List<IGProUserInfo>> d26 = qQGuildMemberListViewModel3.d2();
        Intrinsics.checkNotNullExpressionValue(d26, "viewModel.searchResultLiveData");
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        d26.observe(viewLifecycleOwner2, new p());
        QQGuildMemberListViewModel qQGuildMemberListViewModel4 = this.viewModel;
        if (qQGuildMemberListViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            qQGuildMemberListViewModel4 = null;
        }
        LiveData<List<dg1.b>> T1 = qQGuildMemberListViewModel4.T1();
        Intrinsics.checkNotNullExpressionValue(T1, "viewModel.activeChannelLiveData");
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "viewLifecycleOwner");
        T1.observe(viewLifecycleOwner3, new q());
        QQGuildMemberListViewModel qQGuildMemberListViewModel5 = this.viewModel;
        if (qQGuildMemberListViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            qQGuildMemberListViewModel5 = null;
        }
        LiveData<Boolean> X1 = qQGuildMemberListViewModel5.X1();
        Intrinsics.checkNotNullExpressionValue(X1, "viewModel.exitGuildLiveData");
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "viewLifecycleOwner");
        X1.observe(viewLifecycleOwner4, new r());
        QQGuildMemberListViewModel qQGuildMemberListViewModel6 = this.viewModel;
        if (qQGuildMemberListViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            qQGuildMemberListViewModel6 = null;
        }
        MutableLiveData<IGProUserInfo> e26 = qQGuildMemberListViewModel6.e2();
        Intrinsics.checkNotNullExpressionValue(e26, "viewModel.setAdminLiveData");
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "viewLifecycleOwner");
        e26.observe(viewLifecycleOwner5, new s());
        QQGuildMemberListViewModel qQGuildMemberListViewModel7 = this.viewModel;
        if (qQGuildMemberListViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            qQGuildMemberListViewModel7 = null;
        }
        MutableLiveData<IGProUserInfo> h26 = qQGuildMemberListViewModel7.h2();
        Intrinsics.checkNotNullExpressionValue(h26, "viewModel.unSetAdminLiveData");
        LifecycleOwner viewLifecycleOwner6 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner6, "viewLifecycleOwner");
        h26.observe(viewLifecycleOwner6, new t());
        QQGuildMemberListViewModel qQGuildMemberListViewModel8 = this.viewModel;
        if (qQGuildMemberListViewModel8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            qQGuildMemberListViewModel8 = null;
        }
        LiveData<PendingAction> b26 = qQGuildMemberListViewModel8.b2();
        Intrinsics.checkNotNullExpressionValue(b26, "viewModel.pendingAction");
        LifecycleOwner viewLifecycleOwner7 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner7, "viewLifecycleOwner");
        b26.observe(viewLifecycleOwner7, new u());
        GuildRoleMemberListViewModel guildRoleMemberListViewModel = this.memberListViewModel;
        if (guildRoleMemberListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberListViewModel");
            guildRoleMemberListViewModel = null;
        }
        LiveData<Integer> S1 = guildRoleMemberListViewModel.S1();
        Intrinsics.checkNotNullExpressionValue(S1, "memberListViewModel.liveLoadState");
        LifecycleOwner viewLifecycleOwner8 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner8, "viewLifecycleOwner");
        S1.observe(viewLifecycleOwner8, new v());
        GuildRoleMemberListViewModel guildRoleMemberListViewModel2 = this.memberListViewModel;
        if (guildRoleMemberListViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberListViewModel");
            guildRoleMemberListViewModel2 = null;
        }
        LiveData<List<j.c>> T12 = guildRoleMemberListViewModel2.T1();
        Intrinsics.checkNotNullExpressionValue(T12, "memberListViewModel.liveRoleMembers");
        LifecycleOwner viewLifecycleOwner9 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner9, "viewLifecycleOwner");
        T12.observe(viewLifecycleOwner9, new w());
        GuildRoleMemberListViewModel guildRoleMemberListViewModel3 = this.memberListViewModel;
        if (guildRoleMemberListViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberListViewModel");
            guildRoleMemberListViewModel3 = null;
        }
        cn<cf1.b> m26 = guildRoleMemberListViewModel3.m2();
        Intrinsics.checkNotNullExpressionValue(m26, "memberListViewModel.showToast()");
        LifecycleOwner viewLifecycleOwner10 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner10, "viewLifecycleOwner");
        m26.observe(viewLifecycleOwner10, new i());
        GuildRoleMemberListViewModel guildRoleMemberListViewModel4 = this.memberListViewModel;
        if (guildRoleMemberListViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberListViewModel");
            guildRoleMemberListViewModel4 = null;
        }
        MutableLiveData<Integer> X12 = guildRoleMemberListViewModel4.X1();
        Intrinsics.checkNotNullExpressionValue(X12, "memberListViewModel.totalMemberCount");
        LifecycleOwner viewLifecycleOwner11 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner11, "viewLifecycleOwner");
        X12.observe(viewLifecycleOwner11, new j());
        GuildRoleMemberListViewModel guildRoleMemberListViewModel5 = this.memberListViewModel;
        if (guildRoleMemberListViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberListViewModel");
            guildRoleMemberListViewModel5 = null;
        }
        cn<List<String>> W1 = guildRoleMemberListViewModel5.W1();
        Intrinsics.checkNotNullExpressionValue(W1, "memberListViewModel.onMemberRemoved");
        LifecycleOwner viewLifecycleOwner12 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner12, "viewLifecycleOwner");
        W1.observe(viewLifecycleOwner12, new k());
        QQGuildMemberListViewModel qQGuildMemberListViewModel9 = this.viewModel;
        if (qQGuildMemberListViewModel9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            qQGuildMemberListViewModel9 = null;
        }
        LiveData<Boolean> W12 = qQGuildMemberListViewModel9.W1();
        Intrinsics.checkNotNullExpressionValue(W12, "viewModel.enableInviteLiveData");
        LifecycleOwner viewLifecycleOwner13 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner13, "viewLifecycleOwner");
        W12.observe(viewLifecycleOwner13, new l());
        QQGuildMemberListViewModel qQGuildMemberListViewModel10 = this.viewModel;
        if (qQGuildMemberListViewModel10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            qQGuildMemberListViewModel10 = null;
        }
        LiveData<Boolean> g26 = qQGuildMemberListViewModel10.g2();
        Intrinsics.checkNotNullExpressionValue(g26, "viewModel.transferResult");
        LifecycleOwner viewLifecycleOwner14 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner14, "viewLifecycleOwner");
        g26.observe(viewLifecycleOwner14, new m());
        QQGuildMemberListViewModel qQGuildMemberListViewModel11 = this.viewModel;
        if (qQGuildMemberListViewModel11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            qQGuildMemberListViewModel2 = qQGuildMemberListViewModel11;
        }
        LiveData<Integer> c26 = qQGuildMemberListViewModel2.c2();
        Intrinsics.checkNotNullExpressionValue(c26, "viewModel.searchLoadStateLiveData");
        LifecycleOwner viewLifecycleOwner15 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner15, "viewLifecycleOwner");
        c26.observe(viewLifecycleOwner15, new n());
    }

    /* renamed from: Ai, reason: from getter */
    public final boolean getIsTransferGuild() {
        return this.isTransferGuild;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x007b, code lost:
    
        if (r5 != false) goto L34;
     */
    @Override // a02.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void U3(@NotNull List<? extends IGProUserInfo> memberList) {
        int collectionSizeOrDefault;
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(memberList, "memberList");
        if (memberList.isEmpty()) {
            return;
        }
        QQGuildMemberListViewModel qQGuildMemberListViewModel = this.viewModel;
        if (qQGuildMemberListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            qQGuildMemberListViewModel = null;
        }
        if (qQGuildMemberListViewModel.getGuildInfo() == null) {
            return;
        }
        List<? extends IGProUserInfo> list = memberList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((IGProUserInfo) it.next()).getTinyId());
        }
        boolean z18 = true;
        if (!memberList.isEmpty()) {
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it5 = list.iterator();
                while (it5.hasNext()) {
                    if (((IGProUserInfo) it5.next()).getRobotType() == 1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        z17 = false;
                        break;
                    }
                }
            }
            z17 = true;
        }
        z18 = false;
        Ui(arrayList, z18);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Serializable serializable = requireArguments().getSerializable("PARAM_FRAGMENT");
        Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.tencent.mobileqq.guild.setting.member.fragments.GuildMemberListFragment.Param");
        this.param = (Param) serializable;
        initView();
        initData();
        initDtReport();
        GuildSplitViewUtils guildSplitViewUtils = GuildSplitViewUtils.f235370a;
        guildSplitViewUtils.B(this.N);
        guildSplitViewUtils.A(getActivity(), this.N, R.drawable.qui_common_bg_bottom_light_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.es7;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(InviteFriendUpdateEvent.class);
        return arrayListOf;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NotNull Message msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        int i3 = msg2.what;
        GuildLoadingMemberEmptyView guildLoadingMemberEmptyView = null;
        if (i3 == this.MSG_CODE_REMOVE_DELETE_DIALOG) {
            GuildLoadingMemberEmptyView guildLoadingMemberEmptyView2 = this.loadingMemberEmptyView;
            if (guildLoadingMemberEmptyView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingMemberEmptyView");
                guildLoadingMemberEmptyView2 = null;
            }
            guildLoadingMemberEmptyView2.a();
            QQGuildColorMemberListView qQGuildColorMemberListView = this.memberListView;
            if (qQGuildColorMemberListView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("memberListView");
                qQGuildColorMemberListView = null;
            }
            GuildLoadingMemberEmptyView guildLoadingMemberEmptyView3 = this.loadingMemberEmptyView;
            if (guildLoadingMemberEmptyView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingMemberEmptyView");
            } else {
                guildLoadingMemberEmptyView = guildLoadingMemberEmptyView3;
            }
            qQGuildColorMemberListView.p(guildLoadingMemberEmptyView);
            Li();
            return false;
        }
        if (i3 == this.MSG_CODE_SHOW_LOADING_DIALOG) {
            QQGuildColorMemberListView qQGuildColorMemberListView2 = this.memberListView;
            if (qQGuildColorMemberListView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("memberListView");
                qQGuildColorMemberListView2 = null;
            }
            GuildLoadingMemberEmptyView guildLoadingMemberEmptyView4 = this.loadingMemberEmptyView;
            if (guildLoadingMemberEmptyView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingMemberEmptyView");
                guildLoadingMemberEmptyView4 = null;
            }
            qQGuildColorMemberListView2.i(guildLoadingMemberEmptyView4);
            GuildLoadingMemberEmptyView guildLoadingMemberEmptyView5 = this.loadingMemberEmptyView;
            if (guildLoadingMemberEmptyView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingMemberEmptyView");
            } else {
                guildLoadingMemberEmptyView = guildLoadingMemberEmptyView5;
            }
            guildLoadingMemberEmptyView.c();
            return false;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(@Nullable Activity activity) {
        Window window;
        super.initWindowStyleAndAnimation(activity);
        if (activity != null && (window = activity.getWindow()) != null) {
            window.setSoftInputMode(32);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.userl.GuildMemberListFragment", 2, "onActivityResult " + requestCode + ", " + resultCode + ", " + data);
        }
        if (-1 == resultCode && requestCode == 6666) {
            QQGuildMemberListViewModel qQGuildMemberListViewModel = this.viewModel;
            if (qQGuildMemberListViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                qQGuildMemberListViewModel = null;
            }
            yz1.g.d(qQGuildMemberListViewModel.getGuildInfo(), data);
        }
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        GuildMemberTopCardList guildMemberTopCardList = null;
        if (this.isEditModel) {
            return GuildSplitViewUtils.u(GuildSplitViewUtils.f235370a, getActivity(), false, 2, null);
        }
        QQGuildMemberListViewModel qQGuildMemberListViewModel = this.viewModel;
        if (qQGuildMemberListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            qQGuildMemberListViewModel = null;
        }
        if (qQGuildMemberListViewModel.o2()) {
            Li();
            RelativeLayout relativeLayout = this.searchBar;
            if (relativeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchBar");
                relativeLayout = null;
            }
            relativeLayout.setVisibility(0);
            GuildMemberTopCardList guildMemberTopCardList2 = this.channelMemberCardView;
            if (guildMemberTopCardList2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelMemberCardView");
            } else {
                guildMemberTopCardList = guildMemberTopCardList2;
            }
            guildMemberTopCardList.setOnlineChannelCardViewShow(true);
            return true;
        }
        EditText editText = this.searchEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
            editText = null;
        }
        InputMethodUtil.hide(editText);
        return GuildSplitViewUtils.u(GuildSplitViewUtils.f235370a, getActivity(), false, 2, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(view, "view");
        if (FastClickUtils.isFastDoubleClick("Guild.userl.GuildMemberListFragment onClick")) {
            Logger.f235387a.d().w("Guild.userl.GuildMemberListFragment", 1, "onClick isFastDoubleClick");
        } else if (view == this.C) {
            if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
                onBackEvent();
            }
        } else if (view != this.F && view != this.G) {
            ImageView imageView = this.closeSearchButton;
            EditText editText = null;
            EditText editText2 = null;
            QQGuildMemberListViewModel qQGuildMemberListViewModel = null;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("closeSearchButton");
                imageView = null;
            }
            if (view == imageView) {
                if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
                    EditText editText3 = this.searchEditText;
                    if (editText3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
                    } else {
                        editText2 = editText3;
                    }
                    editText2.setText("");
                }
            } else {
                ImageView imageView2 = this.topInviteView;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("topInviteView");
                    imageView2 = null;
                }
                if (view == imageView2) {
                    if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
                        QQGuildMemberListViewModel qQGuildMemberListViewModel2 = this.viewModel;
                        if (qQGuildMemberListViewModel2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                            qQGuildMemberListViewModel2 = null;
                        }
                        if (Intrinsics.areEqual(qQGuildMemberListViewModel2.W1().getValue(), Boolean.FALSE)) {
                            QQToastUtil.showQQToast(0, "\u9891\u9053\u6682\u4e0d\u652f\u6301\u6210\u5458\u52a0\u5165");
                        } else {
                            QQGuildMemberListViewModel qQGuildMemberListViewModel3 = this.viewModel;
                            if (qQGuildMemberListViewModel3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                            } else {
                                qQGuildMemberListViewModel = qQGuildMemberListViewModel3;
                            }
                            qQGuildMemberListViewModel.m2(getQBaseActivity());
                        }
                    }
                } else {
                    TextView textView = this.mSearchCancel;
                    if (textView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSearchCancel");
                        textView = null;
                    }
                    if (view == textView && !com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
                        EditText editText4 = this.searchEditText;
                        if (editText4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("searchEditText");
                        } else {
                            editText = editText4;
                        }
                        editText.setText("");
                        Yi();
                    }
                }
            }
        } else if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
            Ei();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        QQGuildColorMemberListView qQGuildColorMemberListView = this.memberListView;
        if (qQGuildColorMemberListView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberListView");
            qQGuildColorMemberListView = null;
        }
        qQGuildColorMemberListView.o();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        try {
            Method declaredMethod = ViewGroup.class.getDeclaredMethod("removeDetachedView", View.class, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            QQGuildColorMemberListView qQGuildColorMemberListView = this.memberListView;
            if (qQGuildColorMemberListView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("memberListView");
                qQGuildColorMemberListView = null;
            }
            Object[] objArr = new Object[2];
            GuildMemberTopCardList guildMemberTopCardList = this.channelMemberCardView;
            if (guildMemberTopCardList == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelMemberCardView");
                guildMemberTopCardList = null;
            }
            objArr[0] = guildMemberTopCardList;
            objArr[1] = Boolean.FALSE;
            declaredMethod.invoke(qQGuildColorMemberListView, objArr);
        } catch (Exception e16) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "onDetach " + e16;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.userl.GuildMemberListFragment", 1, (String) it.next(), null);
            }
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public void onPostThemeChanged() {
        super.onPostThemeChanged();
        View contentView = getContentView();
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        contentView.setBackground(bc.b(requireContext, R.drawable.qui_common_bg_bottom_standard_bg));
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        GuildRoleMemberListViewModel guildRoleMemberListViewModel;
        boolean z16;
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            Logger.a d16 = logger.d();
            if (this.memberListViewModel != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            d16.d("Guild.userl.GuildMemberListFragment", 2, "[onReceiveEvent] event " + event + " isInit " + z16 + " ");
        }
        if ((event instanceof InviteFriendUpdateEvent) && (guildRoleMemberListViewModel = this.memberListViewModel) != null) {
            if (guildRoleMemberListViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("memberListViewModel");
                guildRoleMemberListViewModel = null;
            }
            guildRoleMemberListViewModel.refresh();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        requireActivity().getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() { // from class: com.tencent.mobileqq.guild.setting.member.fragments.d
            @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
            public final void onBackStackChanged() {
                GuildMemberListFragment.Ci();
            }
        });
        QQGuildUIUtil.d(requireActivity());
        Hi(true);
        super.onResume();
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    protected int ph() {
        return GuildSplitViewUtils.f235370a.m(getActivity(), R.color.qui_common_bg_bottom_light);
    }

    @Override // d02.b
    public void q1(@NotNull dg1.b channelInfo, @NotNull IGProFeedSummary feedSummary) {
        Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
        Intrinsics.checkNotNullParameter(feedSummary, "feedSummary");
        long channelId = channelInfo.getChannelId();
        long guildId = channelInfo.getGuildId();
        if (ch.C(ch.l(), String.valueOf(guildId), String.valueOf(channelId)) == null) {
            QLog.i("Guild.userl.GuildMemberListFragment", 1, "onItemClicked: error, channel info is null.");
            return;
        }
        QRouteApi api = QRoute.api(IGuildFeedLauncherApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGuildFeedLauncherApi::class.java)");
        IGuildFeedLauncherApi iGuildFeedLauncherApi = (IGuildFeedLauncherApi) api;
        BaseApplication baseApplication = BaseApplication.context;
        Bundle bundle = new Bundle();
        bundle.putString("guildId", String.valueOf(guildId));
        bundle.putString("channelId", String.valueOf(channelId));
        bundle.putString("feedId", feedSummary.getFeedId());
        bundle.putString("visitorTinyId", ch.g());
        Unit unit = Unit.INSTANCE;
        IGuildFeedLauncherApi.a.a(iGuildFeedLauncherApi, baseApplication, bundle, false, 4, null);
    }

    @Override // d02.b
    public void z0(@NotNull String channelId, int channelType) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        if (((IGPSService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGPSService.class, "")).getChannelInfo(channelId) == null) {
            Logger.f235387a.d().i("Guild.userl.GuildMemberListFragment", 1, "onMemberCardItemClicked: channelInfo is null! channelId[" + channelId + "]");
            String string = requireContext().getString(R.string.f15159184);
            Intrinsics.checkNotNullExpressionValue(string, "requireContext().getStri\u2026nline_channel_jump_error)");
            QQToast.makeText(requireContext(), 0, string, 0).show();
            return;
        }
        JumpGuildParam xi5 = xi(channelId);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        GuildJumpUtil.n(requireContext, xi5);
        GuildSplitViewUtils.u(GuildSplitViewUtils.f235370a, getQBaseActivity(), false, 2, null);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost, com.qzone.publish.ui.controller.a
    @NotNull
    public QBaseActivity getHostActivity() {
        QBaseActivity qBaseActivity = getQBaseActivity();
        Intrinsics.checkNotNullExpressionValue(qBaseActivity, "qBaseActivity");
        return qBaseActivity;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/member/fragments/GuildMemberListFragment$Param;", "Ljava/io/Serializable;", "guildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "channelId", "", "(Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;Ljava/lang/String;)V", "getChannelId", "()Ljava/lang/String;", "getGuildInfo", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final /* data */ class Param implements Serializable {

        @NotNull
        private final String channelId;

        @NotNull
        private final IGProGuildInfo guildInfo;

        public Param(@NotNull IGProGuildInfo guildInfo, @NotNull String channelId) {
            Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            this.guildInfo = guildInfo;
            this.channelId = channelId;
        }

        public static /* synthetic */ Param copy$default(Param param, IGProGuildInfo iGProGuildInfo, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                iGProGuildInfo = param.guildInfo;
            }
            if ((i3 & 2) != 0) {
                str = param.channelId;
            }
            return param.copy(iGProGuildInfo, str);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final IGProGuildInfo getGuildInfo() {
            return this.guildInfo;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getChannelId() {
            return this.channelId;
        }

        @NotNull
        public final Param copy(@NotNull IGProGuildInfo guildInfo, @NotNull String channelId) {
            Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            return new Param(guildInfo, channelId);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Param)) {
                return false;
            }
            Param param = (Param) other;
            if (Intrinsics.areEqual(this.guildInfo, param.guildInfo) && Intrinsics.areEqual(this.channelId, param.channelId)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String getChannelId() {
            return this.channelId;
        }

        @NotNull
        public final IGProGuildInfo getGuildInfo() {
            return this.guildInfo;
        }

        public int hashCode() {
            return (this.guildInfo.hashCode() * 31) + this.channelId.hashCode();
        }

        @NotNull
        public String toString() {
            return "Param(guildInfo=" + this.guildInfo + ", channelId=" + this.channelId + ")";
        }

        public /* synthetic */ Param(IGProGuildInfo iGProGuildInfo, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(iGProGuildInfo, (i3 & 2) != 0 ? "" : str);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/guild/setting/member/fragments/GuildMemberListFragment$d", "Lcom/tencent/mobileqq/guild/profile/profilecard/baseprofile/card/GuildProfileCard$e;", "", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements GuildProfileCard.e {
        d() {
        }

        @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.GuildProfileCard.e
        public void b() {
            GuildMemberListFragment.this.Hi(true);
        }

        @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.GuildProfileCard.e
        public /* synthetic */ void c() {
            com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.h.a(this);
        }

        @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.GuildProfileCard.e
        public void a() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/setting/member/fragments/GuildMemberListFragment$f", "Lcom/tencent/mobileqq/guild/robot/components/console/RobotInfoFragment$a;", "", "a", "", "isOperate", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class f implements RobotInfoFragment.a {
        f() {
        }

        @Override // com.tencent.mobileqq.guild.robot.components.console.RobotInfoFragment.a
        public void b(boolean isOperate) {
            GuildMemberListFragment.this.Hi(true);
        }

        @Override // com.tencent.mobileqq.guild.robot.components.console.RobotInfoFragment.a
        public void a() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/setting/member/fragments/GuildMemberListFragment$x", "Llv1/b;", "", "isBlack", "", "msgRevokeType", "", "a", "onDismiss", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class x implements lv1.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List<String> f234614b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f234615c;

        x(List<String> list, boolean z16) {
            this.f234614b = list;
            this.f234615c = z16;
        }

        @Override // lv1.b
        public void a(boolean isBlack, int msgRevokeType) {
            GuildMemberListFragment.this.yi(this.f234614b, isBlack, msgRevokeType, this.f234615c);
        }

        @Override // lv1.b
        public void onDismiss() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/setting/member/fragments/GuildMemberListFragment$y", "Llv1/b;", "", "isBlack", "", "msgRevokeType", "", "a", "onDismiss", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class y implements lv1.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List<String> f234617b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f234618c;

        y(List<String> list, boolean z16) {
            this.f234617b = list;
            this.f234618c = z16;
        }

        @Override // lv1.b
        public void a(boolean isBlack, int msgRevokeType) {
            GuildMemberListFragment.this.yi(this.f234617b, isBlack, msgRevokeType, this.f234618c);
        }

        @Override // lv1.b
        public void onDismiss() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/setting/member/fragments/GuildMemberListFragment$g", "Lcom/tencent/widget/AbsListView$OnScrollListener;", "Lcom/tencent/widget/AbsListView;", "view", "", HippyTKDListViewAdapter.SCROLL_STATE, "", "onScrollStateChanged", "firstVisibleItem", "visibleItemCount", "totalItemCount", HippyScrollViewEventHelper.EVENT_TYPE_SCROLL, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class g implements AbsListView.OnScrollListener {
        g() {
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(@Nullable AbsListView view, int scrollState) {
            SwipListView swipListView = GuildMemberListFragment.this.searchListView;
            QQGuildMemberListViewModel qQGuildMemberListViewModel = null;
            if (swipListView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchListView");
                swipListView = null;
            }
            int lastVisiblePosition = swipListView.getLastVisiblePosition();
            SwipListView swipListView2 = GuildMemberListFragment.this.searchListView;
            if (swipListView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchListView");
                swipListView2 = null;
            }
            if (lastVisiblePosition == swipListView2.getCount() - 1) {
                QQGuildMemberListViewModel qQGuildMemberListViewModel2 = GuildMemberListFragment.this.viewModel;
                if (qQGuildMemberListViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    qQGuildMemberListViewModel = qQGuildMemberListViewModel2;
                }
                qQGuildMemberListViewModel.s2();
            }
            if (scrollState == 0) {
                ((IPerfApi) QRoute.api(IPerfApi.class)).stopMonitorDropFrame("qqguild_search_member_list");
            } else {
                ((IPerfApi) QRoute.api(IPerfApi.class)).startMonitorDropFrame("qqguild_search_member_list");
            }
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScroll(@Nullable AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        }
    }
}
