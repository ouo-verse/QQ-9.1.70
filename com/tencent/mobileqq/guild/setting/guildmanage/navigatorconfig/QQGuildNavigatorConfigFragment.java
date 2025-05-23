package com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.guild.api.IQQGuildService;
import com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.home.viewmodels.header.GuildHomeCoverColors;
import com.tencent.mobileqq.guild.home.viewmodels.header.uidata.GuildHomeHeaderNavigationBar;
import com.tencent.mobileqq.guild.home.viewmodels.header.uidata.GuildNavigationInfo;
import com.tencent.mobileqq.guild.home.views.widget.GuildNavigatorView;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.setting.guildmanage.navigation.GuildNavigationStatus;
import com.tencent.mobileqq.guild.setting.guildmanage.navigation.GuildNavigationStatusChangeEvent;
import com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.QQGuildNavigatorConfigFragment;
import com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.ThemeWidgetColorData;
import com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.viewmodel.QQGuildNavigatorConfigViewModel;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.util.GuildBannerPalette;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.widget.GuildDefaultThemeNavBarCommon;
import com.tencent.mobileqq.guild.widget.GuildLevelRoleView;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetNavigationStatusRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetPreviewNavigationRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildNavIconInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildNavIconTheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationV2Info;
import com.tencent.mobileqq.qqguildsdk.data.genc.bs;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pr1.VisitorColorPicker;
import vp1.cg;
import wh2.cq;
import wh2.ct;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ce\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u008f\u00012\u00020\u0001:\u0002\u0090\u0001B\t\u00a2\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0014J&\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\"\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0014\u001a\u00020\nH\u0002J\b\u0010\u0015\u001a\u00020\nH\u0002J\b\u0010\u0016\u001a\u00020\nH\u0002J\b\u0010\u0017\u001a\u00020\nH\u0002J\b\u0010\u0018\u001a\u00020\nH\u0002J \u0010\u001d\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\nH\u0002J\u0014\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001fH\u0002J\u0012\u0010%\u001a\u0004\u0018\u00010\u00192\u0006\u0010$\u001a\u00020#H\u0002J\b\u0010'\u001a\u00020&H\u0002J\b\u0010(\u001a\u00020\nH\u0002J\u0016\u0010+\u001a\u00020\n2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020 0)H\u0002J\u0014\u0010/\u001a\u00020\n*\u00020,2\u0006\u0010.\u001a\u00020-H\u0002J\u0018\u00103\u001a\u00020\n2\u0006\u00100\u001a\u00020\u00192\u0006\u00102\u001a\u000201H\u0002J\u0018\u00104\u001a\u00020\n2\u0006\u00100\u001a\u00020\u00192\u0006\u00102\u001a\u000201H\u0002J\u0010\u00106\u001a\u00020\n2\u0006\u00105\u001a\u00020\u0019H\u0002J0\u0010=\u001a\u00020<2\u0006\u00107\u001a\u00020-2\u0006\u00108\u001a\u00020-2\u0006\u00109\u001a\u00020-2\u0006\u0010:\u001a\u00020-2\u0006\u0010;\u001a\u00020\u0002H\u0002J\u0010\u0010?\u001a\u00020\n2\u0006\u0010>\u001a\u00020\fH\u0002J\u0010\u0010A\u001a\u00020<2\u0006\u0010@\u001a\u00020\u0002H\u0002J\u0010\u0010C\u001a\u00020\n2\u0006\u0010B\u001a\u00020 H\u0002J\b\u0010D\u001a\u00020\nH\u0002R'\u0010I\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\u001b\u0010N\u001a\u00020J8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bK\u0010F\u001a\u0004\bL\u0010MR#\u0010T\u001a\n P*\u0004\u0018\u00010O0O8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bQ\u0010F\u001a\u0004\bR\u0010SR#\u0010X\u001a\n P*\u0004\u0018\u000101018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bU\u0010F\u001a\u0004\bV\u0010WR#\u0010]\u001a\n P*\u0004\u0018\u00010Y0Y8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bZ\u0010F\u001a\u0004\b[\u0010\\R#\u0010b\u001a\n P*\u0004\u0018\u00010^0^8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b_\u0010F\u001a\u0004\b`\u0010aR#\u0010e\u001a\n P*\u0004\u0018\u000101018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bc\u0010F\u001a\u0004\bd\u0010WR#\u0010j\u001a\n P*\u0004\u0018\u00010f0f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bg\u0010F\u001a\u0004\bh\u0010iR#\u0010o\u001a\n P*\u0004\u0018\u00010k0k8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bl\u0010F\u001a\u0004\bm\u0010nR#\u0010r\u001a\n P*\u0004\u0018\u00010f0f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bp\u0010F\u001a\u0004\bq\u0010iR#\u0010v\u001a\n P*\u0004\u0018\u00010,0,8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bs\u0010F\u001a\u0004\bt\u0010uR#\u0010y\u001a\n P*\u0004\u0018\u00010f0f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bw\u0010F\u001a\u0004\bx\u0010iR#\u0010|\u001a\n P*\u0004\u0018\u00010f0f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bz\u0010F\u001a\u0004\b{\u0010iR\u001d\u0010\u0081\u0001\u001a\u00020}8BX\u0082\u0084\u0002\u00a2\u0006\r\n\u0004\b~\u0010F\u001a\u0005\b\u007f\u0010\u0080\u0001R\"\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0082\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u0083\u0001\u0010F\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001R\u0018\u0010\u0088\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0087\u0001\u0010cR\u001a\u0010\u008c\u0001\u001a\u00030\u0089\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001\u00a8\u0006\u0091\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/navigatorconfig/QQGuildNavigatorConfigFragment;", "Lcom/tencent/mobileqq/guild/base/QQGuildTitleBarFragment;", "", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "doOnCreateView", "", "onBackEvent", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "setStatusBar", "initUI", "Ki", "initData", "initTitleBar", "", "errorMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGetPreviewNavigationRsp;", "resp", "Xi", "xi", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/g;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/navigatorconfig/model/c;", "Lvp1/cg;", "pi", "", "iconId", "vi", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "zi", "li", "", "dataList", "oi", "Landroid/view/View;", "", "radius", "Yi", LayoutAttrDefine.CLICK_URI, "Landroid/widget/ImageView;", "view", "Vi", "Si", "guildId", "Ui", "tl", ReportConstant.COSTREPORT_TRANS, TtmlNode.TAG_BR, "bl", "color", "Landroid/graphics/drawable/GradientDrawable;", "qi", "isSort", "dj", "coverMainColor", "si", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Zi", "ri", "T", "Lkotlin/Lazy;", "ti", "()Lcom/tencent/mobileqq/guild/widget/adapterdelegates/g;", "adapter", "Lcom/tencent/mobileqq/guild/setting/guildmanage/navigatorconfig/viewmodel/QQGuildNavigatorConfigViewModel;", "U", "Ji", "()Lcom/tencent/mobileqq/guild/setting/guildmanage/navigatorconfig/viewmodel/QQGuildNavigatorConfigViewModel;", "viewModel", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType", "V", WidgetCacheLunarData.YI, "()Landroidx/recyclerview/widget/RecyclerView;", "configRv", "W", "Ai", "()Landroid/widget/ImageView;", "ivGuildAvatar", "Lcom/tencent/mobileqq/guild/home/views/widget/GuildNavigatorView;", "X", "Di", "()Lcom/tencent/mobileqq/guild/home/views/widget/GuildNavigatorView;", "layoutConfigsShow", "Landroid/widget/FrameLayout;", "Y", "wi", "()Landroid/widget/FrameLayout;", "configContainer", "Z", "Ci", "ivTips", "Landroid/widget/TextView;", "a0", "Ii", "()Landroid/widget/TextView;", "tvTips", "Lcom/tencent/mobileqq/widget/RoundImageView;", "b0", "Bi", "()Lcom/tencent/mobileqq/widget/RoundImageView;", "ivGuildSmallAvatar", "c0", "Hi", "tvGuildName", "d0", SensorJsPlugin.SENSOR_INTERVAL_UI, "()Landroid/view/View;", "avatarMask", "e0", "Gi", "tvConfigPreview", "f0", "Fi", "tvBottomTips", "Landroidx/recyclerview/widget/ItemTouchHelper;", "g0", "Ei", "()Landroidx/recyclerview/widget/ItemTouchHelper;", "touchHelper", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "h0", "getGuildInfo", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "i0", "isSortMode", "Lcom/tencent/mobileqq/guild/setting/guildmanage/navigatorconfig/model/d;", "j0", "Lcom/tencent/mobileqq/guild/setting/guildmanage/navigatorconfig/model/d;", "widgetColorData", "<init>", "()V", "k0", "Companion", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class QQGuildNavigatorConfigFragment extends QQGuildTitleBarFragment {

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final Lazy adapter;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final Lazy configRv;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final Lazy ivGuildAvatar;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private final Lazy layoutConfigsShow;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private final Lazy configContainer;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private final Lazy ivTips;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy tvTips;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy ivGuildSmallAvatar;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy tvGuildName;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy avatarMask;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy tvConfigPreview;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy tvBottomTips;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy touchHelper;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy guildInfo;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private boolean isSortMode;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ThemeWidgetColorData widgetColorData;

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ&\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0002J \u0010\u000e\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0005J\u001c\u0010\u000f\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007R\u0014\u0010\u0011\u001a\u00020\u00108\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00108\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00108\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0012R\u0014\u0010\u0018\u001a\u00020\u00108\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0012R\u0014\u0010\u0019\u001a\u00020\u00108\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0012R\u0014\u0010\u001a\u001a\u00020\u00108\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0012R\u0014\u0010\u001b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0014\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/navigatorconfig/QQGuildNavigatorConfigFragment$Companion;", "", "", "guildId", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/navigation/GuildNavigationStatus;", "", "resultFun", "c", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "curStatus", "e", "f", "", "COMMIT_LOWER_LIMIT", "I", "KEY_GUILD_INFO", "Ljava/lang/String;", "KEY_NAVIGATION_STATUS", "PAGE_STATUS_AUDITING", "PAGE_STATUS_AUDIT_FAIR", "PAGE_STATUS_AUDIT_SUCCESS", "PAGE_STATUS_EDIT", "REQ_ADD_CONFIG", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void c(final String guildId, final Function1<? super GuildNavigationStatus, Unit> resultFun) {
            IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
            bs bsVar = new bs();
            bsVar.b(Long.parseLong(guildId));
            iGPSService.getNavigationStatus(bsVar, new cq() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.v
                @Override // wh2.cq
                public final void a(int i3, String str, IGProGetNavigationStatusRsp iGProGetNavigationStatusRsp) {
                    QQGuildNavigatorConfigFragment.Companion.d(Function1.this, guildId, i3, str, iGProGetNavigationStatusRsp);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(Function1 resultFun, String guildId, int i3, String errMsg, IGProGetNavigationStatusRsp iGProGetNavigationStatusRsp) {
            boolean z16;
            Intrinsics.checkNotNullParameter(resultFun, "$resultFun");
            Intrinsics.checkNotNullParameter(guildId, "$guildId");
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            boolean z17 = true;
            QLog.i("QQGuildNavigatorConfigFragment", 1, "[getGuildNavigationStatus]onGetNavigationStatus result:" + i3 + ", errMsg:" + errMsg + ", rsp:" + iGProGetNavigationStatusRsp);
            if (i3 == 0 && iGProGetNavigationStatusRsp != null) {
                if (iGProGetNavigationStatusRsp.getEnableSetting() == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (iGProGetNavigationStatusRsp.getExistNavigation() != 1) {
                    z17 = false;
                }
                resultFun.invoke(new GuildNavigationStatus(guildId, z16, z17, iGProGetNavigationStatusRsp.getAuditStatus()));
                return;
            }
            resultFun.invoke(null);
        }

        public final void e(@Nullable Context context, @NotNull IGProGuildInfo guildInfo, @NotNull GuildNavigationStatus curStatus) {
            Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
            Intrinsics.checkNotNullParameter(curStatus, "curStatus");
            Intent intent = new Intent();
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            Bundle bundle = new Bundle();
            bundle.putSerializable("guildInfo", guildInfo);
            bundle.putParcelable("navigationStatus", curStatus);
            intent.putExtras(bundle);
            QPublicFragmentActivity.b.b(context, intent, QPublicFragmentActivity.class, QQGuildNavigatorConfigFragment.class);
        }

        @JvmStatic
        public final void f(@Nullable final Context context, @Nullable final String guildId) {
            if (guildId != null) {
                GuildMainFrameUtils.l(guildId, true, new Function1<IGProGuildInfo, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.QQGuildNavigatorConfigFragment$Companion$open$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(IGProGuildInfo iGProGuildInfo) {
                        invoke2(iGProGuildInfo);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable final IGProGuildInfo iGProGuildInfo) {
                        if (iGProGuildInfo != null && (iGProGuildInfo.getUserType() == 2 || iGProGuildInfo.getUserType() == 1)) {
                            QQGuildNavigatorConfigFragment.Companion companion = QQGuildNavigatorConfigFragment.INSTANCE;
                            String str = guildId;
                            final Context context2 = context;
                            companion.c(str, new Function1<GuildNavigationStatus, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.QQGuildNavigatorConfigFragment$Companion$open$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(GuildNavigationStatus guildNavigationStatus) {
                                    invoke2(guildNavigationStatus);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@Nullable GuildNavigationStatus guildNavigationStatus) {
                                    if (guildNavigationStatus != null && guildNavigationStatus.getEnableShowNavBar()) {
                                        QQGuildNavigatorConfigFragment.INSTANCE.e(context2, iGProGuildInfo, guildNavigationStatus);
                                    } else {
                                        QQToastUtil.showQQToast(R.string.f1489510z);
                                    }
                                }
                            });
                            return;
                        }
                        QQToastUtil.showQQToast(R.string.f1489510z);
                    }
                });
            } else {
                QQToastUtil.showQQToast(R.string.f1489510z);
            }
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\u001a\u0010\u0010\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0012"}, d2 = {"com/tencent/mobileqq/guild/setting/guildmanage/navigatorconfig/QQGuildNavigatorConfigFragment$a", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "", "getMovementFlags", "target", "", "onMove", "direction", "", "onSwiped", "isLongPressDragEnabled", "actionState", "onSelectedChanged", "clearView", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a extends ItemTouchHelper.Callback {
        a() {
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void clearView(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            super.clearView(recyclerView, viewHolder);
            viewHolder.itemView.setTranslationZ(0.0f);
            QQGuildNavigatorConfigFragment.this.ti().notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public int getMovementFlags(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            return ItemTouchHelper.Callback.makeFlag(2, 3) | ItemTouchHelper.Callback.makeFlag(0, 3);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean isLongPressDragEnabled() {
            return false;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean onMove(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder, @NotNull RecyclerView.ViewHolder target) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            Intrinsics.checkNotNullParameter(target, "target");
            int adapterPosition = viewHolder.getAdapterPosition();
            int adapterPosition2 = target.getAdapterPosition();
            com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c cVar = QQGuildNavigatorConfigFragment.this.Ji().W1().get(adapterPosition2);
            if (adapterPosition2 != adapterPosition && !(cVar instanceof com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.a)) {
                List<com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c> W1 = QQGuildNavigatorConfigFragment.this.Ji().W1();
                W1.add(adapterPosition2, W1.remove(adapterPosition));
                QQGuildNavigatorConfigFragment.this.ti().notifyItemMoved(adapterPosition, adapterPosition2);
                QQGuildNavigatorConfigFragment qQGuildNavigatorConfigFragment = QQGuildNavigatorConfigFragment.this;
                qQGuildNavigatorConfigFragment.oi(qQGuildNavigatorConfigFragment.Ji().W1());
                QQGuildNavigatorConfigFragment.this.Ji().S1();
                return true;
            }
            return true;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSelectedChanged(@Nullable RecyclerView.ViewHolder viewHolder, int actionState) {
            View view;
            super.onSelectedChanged(viewHolder, actionState);
            if (actionState == 2) {
                if (viewHolder != null) {
                    view = viewHolder.itemView;
                } else {
                    view = null;
                }
                if (view != null) {
                    view.setTranslationZ(20.0f);
                }
            }
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSwiped(@NotNull RecyclerView.ViewHolder viewHolder, int direction) {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/setting/guildmanage/navigatorconfig/QQGuildNavigatorConfigFragment$b", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f234026a;

        b(float f16) {
            this.f234026a = f16;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(@Nullable View view, @Nullable Outline outline) {
            if (view != null) {
                float f16 = this.f234026a;
                if (outline != null) {
                    outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), ViewUtils.dip2px(f16));
                }
            }
        }
    }

    public QQGuildNavigatorConfigFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Lazy lazy7;
        Lazy lazy8;
        Lazy lazy9;
        Lazy lazy10;
        Lazy lazy11;
        Lazy lazy12;
        Lazy lazy13;
        Lazy lazy14;
        Lazy lazy15;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.guild.widget.adapterdelegates.g<com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c, cg>>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.QQGuildNavigatorConfigFragment$adapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.guild.widget.adapterdelegates.g<com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c, cg> invoke() {
                com.tencent.mobileqq.guild.widget.adapterdelegates.g<com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c, cg> pi5;
                pi5 = QQGuildNavigatorConfigFragment.this.pi();
                return pi5;
            }
        });
        this.adapter = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<QQGuildNavigatorConfigViewModel>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.QQGuildNavigatorConfigFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QQGuildNavigatorConfigViewModel invoke() {
                return (QQGuildNavigatorConfigViewModel) new ViewModelProvider(QQGuildNavigatorConfigFragment.this).get(QQGuildNavigatorConfigViewModel.class);
            }
        });
        this.viewModel = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<RecyclerView>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.QQGuildNavigatorConfigFragment$configRv$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RecyclerView invoke() {
                View view;
                view = ((QQGuildCustomTitleBarFragment) QQGuildNavigatorConfigFragment.this).P;
                return (RecyclerView) view.findViewById(R.id.f7884486);
            }
        });
        this.configRv = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.QQGuildNavigatorConfigFragment$ivGuildAvatar$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                View view;
                view = ((QQGuildCustomTitleBarFragment) QQGuildNavigatorConfigFragment.this).P;
                return (ImageView) view.findViewById(R.id.f165930y40);
            }
        });
        this.ivGuildAvatar = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<GuildNavigatorView>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.QQGuildNavigatorConfigFragment$layoutConfigsShow$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final GuildNavigatorView invoke() {
                View view;
                view = ((QQGuildCustomTitleBarFragment) QQGuildNavigatorConfigFragment.this).P;
                return (GuildNavigatorView) view.findViewById(R.id.ynu);
            }
        });
        this.layoutConfigsShow = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.QQGuildNavigatorConfigFragment$configContainer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FrameLayout invoke() {
                View view;
                view = ((QQGuildCustomTitleBarFragment) QQGuildNavigatorConfigFragment.this).P;
                return (FrameLayout) view.findViewById(R.id.v7p);
            }
        });
        this.configContainer = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.QQGuildNavigatorConfigFragment$ivTips$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                View view;
                view = ((QQGuildCustomTitleBarFragment) QQGuildNavigatorConfigFragment.this).P;
                return (ImageView) view.findViewById(R.id.y9y);
            }
        });
        this.ivTips = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.QQGuildNavigatorConfigFragment$tvTips$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                View view;
                view = ((QQGuildCustomTitleBarFragment) QQGuildNavigatorConfigFragment.this).P;
                return (TextView) view.findViewById(R.id.kbr);
            }
        });
        this.tvTips = lazy8;
        lazy9 = LazyKt__LazyJVMKt.lazy(new Function0<RoundImageView>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.QQGuildNavigatorConfigFragment$ivGuildSmallAvatar$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RoundImageView invoke() {
                View view;
                view = ((QQGuildCustomTitleBarFragment) QQGuildNavigatorConfigFragment.this).P;
                return (RoundImageView) view.findViewById(R.id.f165935y45);
            }
        });
        this.ivGuildSmallAvatar = lazy9;
        lazy10 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.QQGuildNavigatorConfigFragment$tvGuildName$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                View view;
                view = ((QQGuildCustomTitleBarFragment) QQGuildNavigatorConfigFragment.this).P;
                return (TextView) view.findViewById(R.id.f108476d8);
            }
        });
        this.tvGuildName = lazy10;
        lazy11 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.QQGuildNavigatorConfigFragment$avatarMask$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                View view;
                view = ((QQGuildCustomTitleBarFragment) QQGuildNavigatorConfigFragment.this).P;
                return view.findViewById(R.id.t1p);
            }
        });
        this.avatarMask = lazy11;
        lazy12 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.QQGuildNavigatorConfigFragment$tvConfigPreview$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                View view;
                view = ((QQGuildCustomTitleBarFragment) QQGuildNavigatorConfigFragment.this).P;
                return (TextView) view.findViewById(R.id.f107016__);
            }
        });
        this.tvConfigPreview = lazy12;
        lazy13 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.QQGuildNavigatorConfigFragment$tvBottomTips$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                View view;
                view = ((QQGuildCustomTitleBarFragment) QQGuildNavigatorConfigFragment.this).P;
                return (TextView) view.findViewById(R.id.f1063468g);
            }
        });
        this.tvBottomTips = lazy13;
        lazy14 = LazyKt__LazyJVMKt.lazy(new Function0<ItemTouchHelper>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.QQGuildNavigatorConfigFragment$touchHelper$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ItemTouchHelper invoke() {
                ItemTouchHelper.Callback zi5;
                zi5 = QQGuildNavigatorConfigFragment.this.zi();
                return new ItemTouchHelper(zi5);
            }
        });
        this.touchHelper = lazy14;
        lazy15 = LazyKt__LazyJVMKt.lazy(new Function0<IGProGuildInfo>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.QQGuildNavigatorConfigFragment$guildInfo$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final IGProGuildInfo invoke() {
                Bundle arguments = QQGuildNavigatorConfigFragment.this.getArguments();
                return (IGProGuildInfo) (arguments != null ? arguments.get("guildInfo") : null);
            }
        });
        this.guildInfo = lazy15;
        this.widgetColorData = ThemeWidgetColorData.INSTANCE.b();
    }

    private final ImageView Ai() {
        return (ImageView) this.ivGuildAvatar.getValue();
    }

    private final RoundImageView Bi() {
        return (RoundImageView) this.ivGuildSmallAvatar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView Ci() {
        return (ImageView) this.ivTips.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GuildNavigatorView Di() {
        return (GuildNavigatorView) this.layoutConfigsShow.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ItemTouchHelper Ei() {
        return (ItemTouchHelper) this.touchHelper.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView Fi() {
        return (TextView) this.tvBottomTips.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView Gi() {
        return (TextView) this.tvConfigPreview.getValue();
    }

    private final TextView Hi() {
        return (TextView) this.tvGuildName.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView Ii() {
        return (TextView) this.tvTips.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QQGuildNavigatorConfigViewModel Ji() {
        return (QQGuildNavigatorConfigViewModel) this.viewModel.getValue();
    }

    private final void Ki() {
        MutableLiveData<List<com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c>> X1 = Ji().X1();
        final Function1<List<? extends com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c>, Unit> function1 = new Function1<List<? extends com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c>, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.QQGuildNavigatorConfigFragment$initObserver$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c> data) {
                QQGuildNavigatorConfigFragment.this.ti().submitList(data);
                QQGuildNavigatorConfigFragment qQGuildNavigatorConfigFragment = QQGuildNavigatorConfigFragment.this;
                Intrinsics.checkNotNullExpressionValue(data, "data");
                qQGuildNavigatorConfigFragment.oi(data);
            }
        };
        X1.observe(this, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildNavigatorConfigFragment.Li(Function1.this, obj);
            }
        });
        MutableLiveData<GuildHomeHeaderNavigationBar> g26 = Ji().g2();
        final Function1<GuildHomeHeaderNavigationBar, Unit> function12 = new Function1<GuildHomeHeaderNavigationBar, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.QQGuildNavigatorConfigFragment$initObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GuildHomeHeaderNavigationBar guildHomeHeaderNavigationBar) {
                invoke2(guildHomeHeaderNavigationBar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GuildHomeHeaderNavigationBar it) {
                GuildNavigatorView Di;
                GuildNavigatorView Di2;
                if (it.getIsJustChangeHigh()) {
                    Di2 = QQGuildNavigatorConfigFragment.this.Di();
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    Di2.I(it);
                } else {
                    Di = QQGuildNavigatorConfigFragment.this.Di();
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    Di.H(it);
                }
            }
        };
        g26.observe(this, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildNavigatorConfigFragment.Mi(Function1.this, obj);
            }
        });
        MutableLiveData<Integer> h26 = Ji().h2();
        final Function1<Integer, Unit> function13 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.QQGuildNavigatorConfigFragment$initObserver$3
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
            public final void invoke2(Integer num) {
                TextView Fi;
                Fi = QQGuildNavigatorConfigFragment.this.Fi();
                Fi.setText(QQGuildNavigatorConfigFragment.this.getString(R.string.f1509216a, num));
            }
        };
        h26.observe(this, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildNavigatorConfigFragment.Ni(Function1.this, obj);
            }
        });
        MutableLiveData<Integer> k26 = Ji().k2();
        final Function1<Integer, Unit> function14 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.QQGuildNavigatorConfigFragment$initObserver$4
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
            public final void invoke2(Integer num) {
                TextView tvTips;
                ImageView ivTips;
                TextView tvConfigPreview;
                TextView tvTips2;
                TextView Ii;
                TextView Ii2;
                ImageView Ci;
                ImageView Ci2;
                TextView Ii3;
                TextView Ii4;
                ImageView Ci3;
                ImageView Ci4;
                tvTips = QQGuildNavigatorConfigFragment.this.Ii();
                Intrinsics.checkNotNullExpressionValue(tvTips, "tvTips");
                tvTips.setVisibility((num == null || num.intValue() != 1) && (num == null || num.intValue() != 4) ? 0 : 8);
                ivTips = QQGuildNavigatorConfigFragment.this.Ci();
                Intrinsics.checkNotNullExpressionValue(ivTips, "ivTips");
                ivTips.setVisibility((num == null || num.intValue() != 1) && (num == null || num.intValue() != 4) ? 0 : 8);
                tvConfigPreview = QQGuildNavigatorConfigFragment.this.Gi();
                Intrinsics.checkNotNullExpressionValue(tvConfigPreview, "tvConfigPreview");
                tvTips2 = QQGuildNavigatorConfigFragment.this.Ii();
                Intrinsics.checkNotNullExpressionValue(tvTips2, "tvTips");
                tvConfigPreview.setVisibility((tvTips2.getVisibility() == 0) ^ true ? 0 : 8);
                if (num != null && num.intValue() == 2) {
                    Ii3 = QQGuildNavigatorConfigFragment.this.Ii();
                    Ii3.setTextColor(AppCompatResources.getColorStateList(QQGuildNavigatorConfigFragment.this.requireContext(), R.color.qui_common_feedback_warning));
                    Ii4 = QQGuildNavigatorConfigFragment.this.Ii();
                    Ii4.setText(QQGuildNavigatorConfigFragment.this.getString(R.string.f147410wt));
                    Ci3 = QQGuildNavigatorConfigFragment.this.Ci();
                    Ci3.setImageResource(R.drawable.guild_info_filled);
                    Ci4 = QQGuildNavigatorConfigFragment.this.Ci();
                    Ci4.setImageTintList(AppCompatResources.getColorStateList(QQGuildNavigatorConfigFragment.this.requireContext(), R.color.qui_common_feedback_warning));
                    return;
                }
                if (num != null && num.intValue() == 3) {
                    Ii = QQGuildNavigatorConfigFragment.this.Ii();
                    Ii.setTextColor(AppCompatResources.getColorStateList(QQGuildNavigatorConfigFragment.this.requireContext(), R.color.qui_common_feedback_error));
                    Ii2 = QQGuildNavigatorConfigFragment.this.Ii();
                    Ii2.setText(QQGuildNavigatorConfigFragment.this.getString(R.string.f1509116_));
                    Ci = QQGuildNavigatorConfigFragment.this.Ci();
                    Ci.setImageResource(R.drawable.guild_info_filled);
                    Ci2 = QQGuildNavigatorConfigFragment.this.Ci();
                    Ci2.setImageTintList(AppCompatResources.getColorStateList(QQGuildNavigatorConfigFragment.this.requireContext(), R.color.qui_common_feedback_error));
                }
            }
        };
        k26.observe(this, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildNavigatorConfigFragment.Oi(Function1.this, obj);
            }
        });
        MutableLiveData<Integer> k27 = Ji().k2();
        final Function1<Integer, Unit> function15 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.QQGuildNavigatorConfigFragment$initObserver$5
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
            public final void invoke2(Integer num) {
                if (num != null && num.intValue() == 1) {
                    QQGuildNavigatorConfigFragment.this.setRightButtonEnable(true);
                }
            }
        };
        k27.observe(this, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildNavigatorConfigFragment.Pi(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Li(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ni(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Pi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qi(QQGuildNavigatorConfigFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.li();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ri(QQGuildNavigatorConfigFragment this$0, IGProGuildInfo it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        int width = this$0.Ai().getWidth();
        String imageUri = it.getCoverUrl(width, (int) (width * 0.46629214f));
        Intrinsics.checkNotNullExpressionValue(imageUri, "imageUri");
        ImageView ivGuildAvatar = this$0.Ai();
        Intrinsics.checkNotNullExpressionValue(ivGuildAvatar, "ivGuildAvatar");
        this$0.Si(imageUri, ivGuildAvatar);
        String guildID = it.getGuildID();
        Intrinsics.checkNotNullExpressionValue(guildID, "it.guildID");
        this$0.Ui(guildID);
    }

    private final void Si(String uri, final ImageView view) {
        com.tencent.mobileqq.guild.util.v.f(uri, view.getWidth(), view.getHeight(), new GuildLevelRoleView.a() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.u
            @Override // com.tencent.mobileqq.guild.widget.GuildLevelRoleView.a
            public final void a(Bitmap bitmap) {
                QQGuildNavigatorConfigFragment.Ti(view, this, bitmap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ti(ImageView view, QQGuildNavigatorConfigFragment this$0, Bitmap bitmap) {
        ThemeWidgetColorData c16;
        String str;
        GuildHomeCoverColors c17;
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (bitmap != null) {
            view.setImageBitmap(bitmap);
            int e16 = GuildBannerPalette.e(bitmap);
            boolean b16 = VisitorColorPicker.INSTANCE.b(e16);
            this$0.ui().setBackground(this$0.si(e16));
            this$0.wi().setBackground(this$0.qi(0.0f, 0.0f, ViewUtils.dip2px(8.0f), ViewUtils.dip2px(8.0f), e16));
            if (b16) {
                c16 = ThemeWidgetColorData.INSTANCE.c().c(this$0.widgetColorData);
                str = "black";
            } else {
                c16 = ThemeWidgetColorData.INSTANCE.a().c(this$0.widgetColorData);
                str = "white";
            }
            this$0.widgetColorData = c16;
            QQGuildNavigatorConfigViewModel Ji = this$0.Ji();
            if (b16) {
                c17 = GuildHomeCoverColors.INSTANCE.b(2, e16);
            } else {
                c17 = GuildHomeCoverColors.INSTANCE.c(1, e16);
            }
            Ji.v2(c17);
            this$0.Ji().r2(str);
            this$0.xi();
            this$0.ri();
        }
    }

    private final void Ui(String guildId) {
        Bi().setImageDrawable(((IQQGuildService) ch.m().getRuntimeService(IQQGuildService.class, "")).getAvatarDrawable(guildId, 140, null, false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Vi(String uri, ImageView view) {
        com.tencent.mobileqq.guild.util.v.i(uri, view);
    }

    @JvmStatic
    public static final void Wi(@Nullable Context context, @Nullable String str) {
        INSTANCE.f(context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Xi(int resultCode, String errorMsg, IGProGetPreviewNavigationRsp resp) {
        int i3;
        Map mapOf;
        VideoReport.addToDetectionWhitelist(getActivity());
        com.tencent.mobileqq.guild.api.impl.e.a(getView(), "pg_sgrp_navigation_bar_set", null, null, ExposurePolicy.REPORT_ALL, EndExposurePolicy.REPORT_ALL, null);
        switch (resp.getGuildNavigation().getAuditStatus()) {
            case 0:
            default:
                i3 = 1;
                break;
            case 1:
            case 2:
            case 4:
                i3 = 2;
                break;
            case 3:
            case 6:
                i3 = 4;
                break;
            case 5:
                i3 = 3;
                break;
        }
        View view = getView();
        IGProGuildInfo guildInfo = getGuildInfo();
        Intrinsics.checkNotNull(guildInfo);
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("sgrp_channel_id", guildInfo.getGuildID()), TuplesKt.to("sgrp_config_status", Integer.valueOf(i3)));
        VideoReport.setPageParams(view, new PageParams((Map<String, ?>) mapOf));
    }

    private final void Yi(View view, float f16) {
        view.setOutlineProvider(new b(f16));
        view.setClipToOutline(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.tencent.widget.ActionSheet, T] */
    public final void Zi(final com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c item) {
        Map mapOf;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Dialog createDialog = ActionSheetHelper.createDialog(requireActivity(), null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        ?? r16 = (ActionSheet) createDialog;
        r16.addButton(getString(R.string.f156961lm));
        r16.addButton(getString(R.string.ajx), 3);
        r16.addCancelButton(R.string.cancel);
        VideoReport.setLogicParent(r16.getRootView(), getView());
        com.tencent.mobileqq.guild.api.impl.e.a(r16.getRootView(), null, "em_sgrp_navigation_bar_set_pop", null, ExposurePolicy.REPORT_NONE, EndExposurePolicy.REPORT_NONE, ClickPolicy.REPORT_NONE);
        objectRef.element = r16;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getString(R.string.f1509616e);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.guild_nav_config_edit_s)");
        int i3 = 1;
        String format = String.format(string, Arrays.copyOf(new Object[]{item.getConfigName()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        r16.setMainTitle(format);
        ((ActionSheet) objectRef.element).setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.i
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i16) {
                QQGuildNavigatorConfigFragment.aj(Ref.ObjectRef.this, item, this, view, i16);
            }
        });
        ((ActionSheet) objectRef.element).show();
        ViewGroup rootView = ((ActionSheet) objectRef.element).getRootView();
        Pair[] pairArr = new Pair[4];
        pairArr[0] = TuplesKt.to("sgrp_icon_id", Long.valueOf(item.getId()));
        pairArr[1] = TuplesKt.to("sgrp_navigation_name", item.getConfigName());
        pairArr[2] = TuplesKt.to("sgrp_navigation_url", item.getSubDesc());
        if (!item.getIsShowAttention()) {
            i3 = 2;
        }
        pairArr[3] = TuplesKt.to("sgrp_state_tags", Integer.valueOf(i3));
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        VideoReport.reportEvent("imp", rootView, mapOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void aj(Ref.ObjectRef moreOperateDialog, final com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c item, final QQGuildNavigatorConfigFragment this$0, View view, int i3) {
        Map mapOf;
        int i16;
        Map mapOf2;
        Intrinsics.checkNotNullParameter(moreOperateDialog, "$moreOperateDialog");
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i17 = 2;
        if (i3 != 0) {
            if (i3 == 1) {
                ViewGroup rootView = ((ActionSheet) moreOperateDialog.element).getRootView();
                Pair[] pairArr = new Pair[5];
                pairArr[0] = TuplesKt.to("sgrp_icon_id", Long.valueOf(item.getId()));
                pairArr[1] = TuplesKt.to("sgrp_navigation_name", item.getConfigName());
                pairArr[2] = TuplesKt.to("sgrp_navigation_url", item.getSubDesc());
                if (item.getIsShowAttention()) {
                    i16 = 1;
                } else {
                    i16 = 2;
                }
                pairArr[3] = TuplesKt.to("sgrp_state_tags", Integer.valueOf(i16));
                pairArr[4] = TuplesKt.to("sgrp_btn_type", 2);
                mapOf2 = MapsKt__MapsKt.mapOf(pairArr);
                VideoReport.reportEvent("clck", rootView, mapOf2);
                Context requireContext = this$0.requireContext();
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = this$0.getString(R.string.f1509516d);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.guild_nav_config_delete_tip_s)");
                String format = String.format(string, Arrays.copyOf(new Object[]{item.getConfigName()}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                DialogUtil.createCustomDialog(requireContext, 230, (String) null, format, this$0.getString(R.string.f140850f3), this$0.getString(R.string.f143030kz), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.k
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i18) {
                        QQGuildNavigatorConfigFragment.bj(QQGuildNavigatorConfigFragment.this, item, dialogInterface, i18);
                    }
                }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.l
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i18) {
                        QQGuildNavigatorConfigFragment.cj(dialogInterface, i18);
                    }
                }).show();
            }
        } else {
            ViewGroup rootView2 = ((ActionSheet) moreOperateDialog.element).getRootView();
            Pair[] pairArr2 = new Pair[5];
            pairArr2[0] = TuplesKt.to("sgrp_icon_id", Long.valueOf(item.getId()));
            pairArr2[1] = TuplesKt.to("sgrp_navigation_name", item.getConfigName());
            pairArr2[2] = TuplesKt.to("sgrp_navigation_url", item.getSubDesc());
            if (item.getIsShowAttention()) {
                i17 = 1;
            }
            pairArr2[3] = TuplesKt.to("sgrp_state_tags", Integer.valueOf(i17));
            pairArr2[4] = TuplesKt.to("sgrp_btn_type", 1);
            mapOf = MapsKt__MapsKt.mapOf(pairArr2);
            VideoReport.reportEvent("clck", rootView2, mapOf);
            this$0.dj(true);
            this$0.ti().notifyDataSetChanged();
            this$0.Ji().S1();
        }
        ((ActionSheet) moreOperateDialog.element).dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bj(QQGuildNavigatorConfigFragment this$0, final com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c item, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        dialogInterface.dismiss();
        QQGuildNavigatorConfigViewModel viewModel = this$0.Ji();
        Intrinsics.checkNotNullExpressionValue(viewModel, "viewModel");
        QQGuildNavigatorConfigViewModel.R1(viewModel, false, new Function1<List<com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c>, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.QQGuildNavigatorConfigFragment$showMoreOperateDialog$1$dialog$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull List<com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c> editConfigList) {
                Intrinsics.checkNotNullParameter(editConfigList, "$this$editConfigList");
                editConfigList.remove(com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c.this);
            }
        }, 1, null);
        this$0.Ji().S1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cj(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dj(boolean isSort) {
        int i3;
        int i16;
        Object obj;
        int i17 = 0;
        if (isSort) {
            this.isSortMode = true;
            Ji().S1();
            this.J.setRightText(R.string.h3s);
            this.J.setTitle(getString(R.string.f170789aa3));
            Ji().P1();
        } else {
            this.isSortMode = false;
            this.J.setRightText(R.string.f15083162);
            this.J.setTitle(getString(R.string.f15087166));
        }
        TextView f16 = this.J.f();
        Intrinsics.checkNotNullExpressionValue(f16, "vg.leftBackIcon");
        if (!isSort) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        f16.setVisibility(i3);
        TextView g16 = this.J.g();
        Intrinsics.checkNotNullExpressionValue(g16, "vg.leftViewNotBack");
        if (isSort) {
            i16 = 0;
        } else {
            i16 = 8;
        }
        g16.setVisibility(i16);
        TextView tvBottomTips = Fi();
        Intrinsics.checkNotNullExpressionValue(tvBottomTips, "tvBottomTips");
        if (!(!isSort)) {
            i17 = 8;
        }
        tvBottomTips.setVisibility(i17);
        Iterator<T> it = Ji().W1().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c) obj) instanceof com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.a) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c cVar = (com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c) obj;
        if (isSort) {
            if (cVar != null) {
                Ji().W1().remove(cVar);
            }
        } else {
            Ji().w2();
        }
        ti().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGProGuildInfo getGuildInfo() {
        return (IGProGuildInfo) this.guildInfo.getValue();
    }

    private final void initData() {
        IGProGuildInfo guildInfo = getGuildInfo();
        if (guildInfo != null) {
            QQGuildNavigatorConfigViewModel Ji = Ji();
            String guildID = guildInfo.getGuildID();
            Intrinsics.checkNotNullExpressionValue(guildID, "it.guildID");
            Ji.m2(Long.parseLong(guildID));
        }
    }

    private final void initTitleBar() {
        this.J.a();
        this.J.setTitle(getString(R.string.f15087166));
        this.J.setRightText(R.string.f15083162);
        this.J.setLeftText(R.string.cancel);
        setRightButtonEnable(false);
        this.J.setOnItemSelectListener(new GuildDefaultThemeNavBarCommon.a() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.QQGuildNavigatorConfigFragment$initTitleBar$1
            @Override // com.tencent.mobileqq.guild.widget.GuildDefaultThemeNavBarCommon.a
            public boolean onItemLongClick(@Nullable View v3, int item) {
                return false;
            }

            @Override // com.tencent.mobileqq.guild.widget.GuildDefaultThemeNavBarCommon.a
            public void onItemSelect(@Nullable View v3, int item) {
                boolean z16;
                IGProGuildInfo guildInfo;
                boolean z17;
                if (item == 2) {
                    z16 = QQGuildNavigatorConfigFragment.this.isSortMode;
                    if (z16) {
                        QQGuildNavigatorConfigFragment.this.dj(false);
                        return;
                    }
                    guildInfo = QQGuildNavigatorConfigFragment.this.getGuildInfo();
                    if (guildInfo != null) {
                        final QQGuildNavigatorConfigFragment qQGuildNavigatorConfigFragment = QQGuildNavigatorConfigFragment.this;
                        Integer value = qQGuildNavigatorConfigFragment.Ji().k2().getValue();
                        if (value != null && value.intValue() == 1) {
                            QQGuildNavigatorConfigViewModel Ji = qQGuildNavigatorConfigFragment.Ji();
                            String guildID = guildInfo.getGuildID();
                            Intrinsics.checkNotNullExpressionValue(guildID, "it.guildID");
                            Ji.o2(Long.parseLong(guildID), new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.QQGuildNavigatorConfigFragment$initTitleBar$1$onItemSelect$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    FragmentActivity activity = QQGuildNavigatorConfigFragment.this.getActivity();
                                    if (activity != null) {
                                        activity.finish();
                                    }
                                }
                            });
                            return;
                        }
                        FragmentActivity activity = qQGuildNavigatorConfigFragment.getActivity();
                        if (activity != null) {
                            activity.finish();
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (item == 8) {
                    z17 = QQGuildNavigatorConfigFragment.this.isSortMode;
                    if (z17) {
                        QQGuildNavigatorConfigFragment.this.Ji().n2();
                        QQGuildNavigatorConfigFragment.this.dj(false);
                    }
                }
            }
        });
        TextView g16 = this.J.g();
        Intrinsics.checkNotNullExpressionValue(g16, "vg.leftViewNotBack");
        g16.setVisibility(8);
        TextView f16 = this.J.f();
        Intrinsics.checkNotNullExpressionValue(f16, "vg.leftBackIcon");
        f16.setVisibility(0);
        this.J.f().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQGuildNavigatorConfigFragment.Qi(QQGuildNavigatorConfigFragment.this, view);
            }
        });
        this.J.setBackground(getResources().getDrawable(R.drawable.qui_common_bg_bottom_standard));
    }

    private final void initUI() {
        GuildNavigationStatus guildNavigationStatus;
        Bundle arguments = getArguments();
        if (arguments != null && (guildNavigationStatus = (GuildNavigationStatus) arguments.getParcelable("navigationStatus")) != null) {
            Ji().t2(guildNavigationStatus.getEnableShowNavBar());
            Ji().u2(guildNavigationStatus.getHasNavigationInfo());
            Ji().s2(guildNavigationStatus.getStatus());
        }
        initTitleBar();
        ImageView ivGuildAvatar = Ai();
        Intrinsics.checkNotNullExpressionValue(ivGuildAvatar, "ivGuildAvatar");
        Yi(ivGuildAvatar, 8.0f);
        RecyclerView configRv = yi();
        Intrinsics.checkNotNullExpressionValue(configRv, "configRv");
        Yi(configRv, 6.0f);
        yi().setLayoutManager(new LinearLayoutManager(requireContext(), 1, false));
        yi().setAdapter(ti());
        Ei().attachToRecyclerView(yi());
        final IGProGuildInfo guildInfo = getGuildInfo();
        if (guildInfo != null) {
            Hi().setText(guildInfo.getGuildName());
            if (guildInfo.getCoverFontColorId() == 0) {
                Hi().setTextColor(-1);
            } else {
                Hi().setTextColor(-16777216);
            }
            Ai().post(new Runnable() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.h
                @Override // java.lang.Runnable
                public final void run() {
                    QQGuildNavigatorConfigFragment.Ri(QQGuildNavigatorConfigFragment.this, guildInfo);
                }
            });
        }
        ThemeWidgetColorData themeWidgetColorData = this.widgetColorData;
        TextView tvGuildName = Hi();
        Intrinsics.checkNotNullExpressionValue(tvGuildName, "tvGuildName");
        ThemeWidgetColorData.b(themeWidgetColorData, tvGuildName, null, false, 6, null);
        com.tencent.mobileqq.guild.api.impl.e.a(this.J.h(), null, "em_sgrp_complete_btn", null, null, null, ClickPolicy.REPORT_ALL);
        GuildNavigatorView Di = Di();
        QQGuildNavigatorConfigViewModel viewModel = Ji();
        Intrinsics.checkNotNullExpressionValue(viewModel, "viewModel");
        Di.setUpdateExpandStatus(new QQGuildNavigatorConfigFragment$initUI$3(viewModel));
        Di().setNeedHandleItemClick(false);
        Di().setColumnCount(5);
        Di().setRowCount(3);
        Di().setNeedPlaceholder(true);
        wi().setBackground(qi(0.0f, 0.0f, ViewUtils.dip2px(8.0f), ViewUtils.dip2px(8.0f), getResources().getColor(R.color.qui_common_bg_middle_light)));
    }

    private final void li() {
        Map mapOf;
        Integer value = Ji().k2().getValue();
        if (value != null && value.intValue() == 1) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(requireContext(), 230, (String) null, getString(R.string.f1510016i), getString(R.string.f1509416c), getString(R.string.f1509316b), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.m
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    QQGuildNavigatorConfigFragment.mi(QQGuildNavigatorConfigFragment.this, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.n
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    QQGuildNavigatorConfigFragment.ni(QQGuildNavigatorConfigFragment.this, dialogInterface, i3);
                }
            });
            VideoReport.setLogicParent(createCustomDialog.getRootView(), getView());
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("dt_pgid", "pg_sgrp_navigation_bar_set"));
            com.tencent.mobileqq.guild.api.impl.e.a(createCustomDialog.getRootView(), null, "em_sgrp_not_save_second_confirm_pop", mapOf, ExposurePolicy.REPORT_ALL, null, null);
            createCustomDialog.show();
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mi(final QQGuildNavigatorConfigFragment this$0, DialogInterface dialogInterface, int i3) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(dialogInterface, "null cannot be cast to non-null type com.tencent.mobileqq.utils.QQCustomDialog");
        ViewGroup rootView = ((QQCustomDialog) dialogInterface).getRootView();
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_btn_type", 2));
        VideoReport.reportEvent("clck", rootView, mapOf);
        dialogInterface.dismiss();
        IGProGuildInfo guildInfo = this$0.getGuildInfo();
        if (guildInfo != null) {
            QQGuildNavigatorConfigViewModel Ji = this$0.Ji();
            String guildID = guildInfo.getGuildID();
            Intrinsics.checkNotNullExpressionValue(guildID, "it.guildID");
            Ji.o2(Long.parseLong(guildID), new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.QQGuildNavigatorConfigFragment$clickBack$confirmDialog$1$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    FragmentActivity activity = QQGuildNavigatorConfigFragment.this.getActivity();
                    if (activity != null) {
                        activity.finish();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ni(QQGuildNavigatorConfigFragment this$0, DialogInterface dialogInterface, int i3) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(dialogInterface, "null cannot be cast to non-null type com.tencent.mobileqq.utils.QQCustomDialog");
        ViewGroup rootView = ((QQCustomDialog) dialogInterface).getRootView();
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_btn_type", 1));
        VideoReport.reportEvent("clck", rootView, mapOf);
        dialogInterface.dismiss();
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void oi(List<? extends com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c> dataList) {
        int collectionSizeOrDefault;
        GuildNavigationInfo guildNavigationInfo;
        boolean z16;
        ArrayList<com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c> arrayList = new ArrayList();
        for (Object obj : dataList) {
            com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c cVar = (com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c) obj;
            if (!(cVar instanceof com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.a) && !(cVar instanceof com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.b)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        for (com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c cVar2 : arrayList) {
            Object extras = cVar2.getExtras();
            if (extras instanceof IGProNavigationV2Info) {
                IGProNavigationV2Info iGProNavigationV2Info = (IGProNavigationV2Info) extras;
                String iconUrl = iGProNavigationV2Info.getIconUrl();
                Intrinsics.checkNotNullExpressionValue(iconUrl, "extras.iconUrl");
                String title = iGProNavigationV2Info.getTitle();
                Intrinsics.checkNotNullExpressionValue(title, "extras.title");
                String jumpUrl = iGProNavigationV2Info.getJumpUrl();
                Intrinsics.checkNotNullExpressionValue(jumpUrl, "extras.jumpUrl");
                int jumpUrlType = iGProNavigationV2Info.getJumpUrlType();
                boolean showBubble = iGProNavigationV2Info.getShowBubble();
                String bubbleDesc = iGProNavigationV2Info.getBubbleDesc();
                Intrinsics.checkNotNullExpressionValue(bubbleDesc, "extras.bubbleDesc");
                guildNavigationInfo = new GuildNavigationInfo(iconUrl, title, jumpUrl, jumpUrlType, showBubble, bubbleDesc);
            } else {
                String icon = cVar2.getIcon();
                if (icon == null) {
                    icon = "";
                }
                guildNavigationInfo = new GuildNavigationInfo(icon, cVar2.getConfigName(), cVar2.getSubDesc(), 0, false, "");
            }
            arrayList2.add(guildNavigationInfo);
        }
        Ji().y2(arrayList2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.guild.widget.adapterdelegates.g<com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c, cg> pi() {
        return new com.tencent.mobileqq.guild.widget.adapterdelegates.g<>(new Function1<ViewGroup, cg>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.QQGuildNavigatorConfigFragment$createConfigAdapter$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final cg invoke(@NotNull ViewGroup parent) {
                Intrinsics.checkNotNullParameter(parent, "parent");
                cg g16 = cg.g(com.tencent.guild.aio.reserve2.busi.chosen.view.c.a(parent), parent, false);
                Intrinsics.checkNotNullExpressionValue(g16, "inflate(parent.layoutInflater, parent, false)");
                return g16;
            }
        }, new QQGuildNavigatorConfigFragment$createConfigAdapter$2(this), new com.tencent.mobileqq.guild.widget.adapterdelegates.f());
    }

    private final GradientDrawable qi(float tl5, float tr5, float br5, float bl5, int color) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadii(new float[]{tl5, tl5, tr5, tr5, br5, br5, bl5, bl5});
        gradientDrawable.setColor(color);
        return gradientDrawable;
    }

    private final void ri() {
        this.widgetColorData.f();
        this.widgetColorData.e();
    }

    private final void setStatusBar() {
        QQGuildUIUtil.L(getActivity(), getResources().getColor(R.color.qui_common_bg_bottom_standard));
        boolean z16 = !GuildThemeManager.f235286a.b();
        Window window = requireActivity().getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "requireActivity().window");
        GuildThemeManager.i(z16, window);
    }

    private final GradientDrawable si(int coverMainColor) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setGradientType(0);
        gradientDrawable.setOrientation(GradientDrawable.Orientation.BOTTOM_TOP);
        gradientDrawable.setColors(new int[]{coverMainColor, 0});
        return gradientDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.guild.widget.adapterdelegates.g<com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.c, cg> ti() {
        return (com.tencent.mobileqq.guild.widget.adapterdelegates.g) this.adapter.getValue();
    }

    private final View ui() {
        return (View) this.avatarMask.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String vi(long iconId) {
        IGProGuildNavIconInfo iGProGuildNavIconInfo = null;
        for (IGProGuildNavIconTheme iGProGuildNavIconTheme : Ji().l2()) {
            boolean areEqual = Intrinsics.areEqual(iGProGuildNavIconTheme.getIconSelectorColor(), "white");
            Iterator<IGProGuildNavIconInfo> it = iGProGuildNavIconTheme.getIcons().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                IGProGuildNavIconInfo next = it.next();
                if (next.getIconId() == iconId) {
                    iGProGuildNavIconInfo = next;
                    break;
                }
            }
            if (areEqual) {
                break;
            }
        }
        if (iGProGuildNavIconInfo == null) {
            return null;
        }
        return iGProGuildNavIconInfo.getIconUrl();
    }

    private final FrameLayout wi() {
        return (FrameLayout) this.configContainer.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void xi() {
        IGProGuildInfo guildInfo = getGuildInfo();
        if (guildInfo != null) {
            QQGuildNavigatorConfigViewModel Ji = Ji();
            String guildID = guildInfo.getGuildID();
            Intrinsics.checkNotNullExpressionValue(guildID, "it.guildID");
            Ji.T1(Long.parseLong(guildID), new ct() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.t
                @Override // wh2.ct
                public final void a(int i3, String str, IGProGetPreviewNavigationRsp iGProGetPreviewNavigationRsp) {
                    QQGuildNavigatorConfigFragment.this.Xi(i3, str, iGProGetPreviewNavigationRsp);
                }
            }, new QQGuildNavigatorConfigFragment$getConfigInfo$1$2(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RecyclerView yi() {
        return (RecyclerView) this.configRv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ItemTouchHelper.Callback zi() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.doOnCreateView(inflater, container, savedInstanceState);
        setStatusBar();
        initUI();
        Ki();
        initData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f168143f15;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        String str;
        String str2;
        String str3;
        String stringExtra;
        String stringExtra2;
        String stringExtra3;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101 && resultCode == -1) {
            long j3 = -99;
            if (data != null) {
                j3 = data.getLongExtra("resIconId", -99L);
            }
            long j16 = j3;
            if (data == null || (stringExtra3 = data.getStringExtra("resIconUri")) == null) {
                str = "";
            } else {
                str = stringExtra3;
            }
            if (data == null || (stringExtra2 = data.getStringExtra("resConfigName")) == null) {
                str2 = "";
            } else {
                str2 = stringExtra2;
            }
            if (data == null || (stringExtra = data.getStringExtra("resMagnet")) == null) {
                str3 = "";
            } else {
                str3 = stringExtra;
            }
            Ji().z2(j16, str, str2, str3);
        }
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        li();
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        int i3;
        IGProGuildInfo guildInfo = getGuildInfo();
        if (guildInfo != null) {
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            String guildID = guildInfo.getGuildID();
            Intrinsics.checkNotNullExpressionValue(guildID, "it.guildID");
            boolean enableShowNavBar = Ji().getEnableShowNavBar();
            boolean hasNavigationInfo = Ji().getHasNavigationInfo();
            if (!Ji().getHasCommitted()) {
                i3 = Ji().getDefaultAuditStatus();
            } else {
                Integer value = Ji().k2().getValue();
                if (value == null || value.intValue() != 2) {
                    if (value != null && value.intValue() == 3) {
                        i3 = 6;
                    } else if (!Ji().getHasNavigationInfo()) {
                        i3 = 100;
                    }
                }
                i3 = 1;
            }
            simpleEventBus.dispatchEvent(new GuildNavigationStatusChangeEvent(new GuildNavigationStatus(guildID, enableShowNavBar, hasNavigationInfo, i3)));
        }
        this.widgetColorData.g();
        super.onDestroy();
    }
}
