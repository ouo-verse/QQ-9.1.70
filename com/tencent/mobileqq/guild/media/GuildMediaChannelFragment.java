package com.tencent.mobileqq.guild.media;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.api.IGuildStandalonePageOpenApi;
import com.tencent.mobileqq.guild.base.GuildToggles;
import com.tencent.mobileqq.guild.channel.frame.bottom.GuildChannelGuestBottomManager;
import com.tencent.mobileqq.guild.gift.module.ShowPanelTab;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.live.livemanager.QQGuildOrientationSensorManager;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.media.aio.GuildMediaAioViewModel;
import com.tencent.mobileqq.guild.media.aio.GuildMediaRoomMsgGuideController;
import com.tencent.mobileqq.guild.media.aio.b;
import com.tencent.mobileqq.guild.media.chat.view.GuildMediaLandVideoView;
import com.tencent.mobileqq.guild.media.content.GuildMediaChatContent;
import com.tencent.mobileqq.guild.media.content.GuildMediaContentFragmentBase;
import com.tencent.mobileqq.guild.media.content.loading.GuildMediaLoadingSkeletonContent;
import com.tencent.mobileqq.guild.media.content.thirdapp.GuildMediaThirdAppContent;
import com.tencent.mobileqq.guild.media.content.thirdapp.GuildMediaThirdAppLandContent;
import com.tencent.mobileqq.guild.media.core.EnterChannelState;
import com.tencent.mobileqq.guild.media.core.MediaChannelCore;
import com.tencent.mobileqq.guild.media.core.MediaChannelMiniContainerUtil;
import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.guild.media.core.notify.ScreenShareActionEvent;
import com.tencent.mobileqq.guild.media.core.notify.SwitchThemeEvent;
import com.tencent.mobileqq.guild.media.core.notify.ThirdAppBarClickEvent;
import com.tencent.mobileqq.guild.media.core.notify.ad;
import com.tencent.mobileqq.guild.media.core.notify.ai;
import com.tencent.mobileqq.guild.media.core.notify.bb;
import com.tencent.mobileqq.guild.media.core.viewpool.ViewPoolEngine;
import com.tencent.mobileqq.guild.media.floatwindow.FloatWindowPermissionHandler;
import com.tencent.mobileqq.guild.media.listen.presenter.ListenWidgetPresenter;
import com.tencent.mobileqq.guild.media.listen.widget.ListenWidget;
import com.tencent.mobileqq.guild.media.presenter.GuildMediaLayoutPresenter;
import com.tencent.mobileqq.guild.media.presenter.ImmersivePresenter;
import com.tencent.mobileqq.guild.media.widget.GuildMediaChannelFragmentBottomBar;
import com.tencent.mobileqq.guild.media.widget.GuildMediaChannelFragmentTitleBar;
import com.tencent.mobileqq.guild.media.widget.GuildMediaThirdAppInputLayout;
import com.tencent.mobileqq.guild.media.widget.GuildNestedScrollView;
import com.tencent.mobileqq.guild.temp.api.IGuildActivityApi;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.bo;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.guild.widget.operationbanner.GuildOperationBanner;
import com.tencent.mobileqq.guild.window.GuildFloatWindowUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.api.IMiniContainer;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProTopMsg;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlayInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlayNodeExtInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.QAdCardExtraData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.LiuHaiUtils;
import com.tencent.util.NumberUtil;
import com.tencent.util.UiThreadUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QzoneIPCModule;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh1.k;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00f4\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00f5\u00012\u00020\u00012\u00020\u0002:\u0002\u00f6\u0001B\t\u00a2\u0006\u0006\b\u00f3\u0001\u0010\u00f4\u0001J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0011H\u0002J\b\u0010\u0015\u001a\u00020\u0005H\u0002J\b\u0010\u0016\u001a\u00020\u0005H\u0002J\b\u0010\u0017\u001a\u00020\u0011H\u0002J\b\u0010\u0018\u001a\u00020\u0005H\u0002J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0011H\u0002J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u0005H\u0002J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u00020\u0005H\u0002J\b\u0010#\u001a\u00020\u0005H\u0002J\b\u0010$\u001a\u00020\u0005H\u0002J\b\u0010%\u001a\u00020\u0005H\u0003J\u0010\u0010'\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0011H\u0003J\u0010\u0010)\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u0011H\u0002J\u0010\u0010*\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u0011H\u0002J\b\u0010+\u001a\u00020\u0005H\u0002J\b\u0010,\u001a\u00020\u0005H\u0002J\b\u0010-\u001a\u00020\u0005H\u0002J\b\u0010.\u001a\u00020\u0005H\u0002J\b\u0010/\u001a\u00020\u0005H\u0002J\b\u00100\u001a\u00020\u0011H\u0002J\u0010\u00103\u001a\u00020\u00052\u0006\u00102\u001a\u000201H\u0002J\u0010\u00105\u001a\u00020\u00052\u0006\u00102\u001a\u000204H\u0002J\u0010\u00107\u001a\u00020\u00052\u0006\u00102\u001a\u000206H\u0002J\u0010\u00109\u001a\u00020\u00052\u0006\u00102\u001a\u000208H\u0002J\u0010\u0010;\u001a\u00020\u00052\u0006\u00102\u001a\u00020:H\u0002J\u0010\u0010=\u001a\u00020\u00052\u0006\u00102\u001a\u00020<H\u0002J\u0010\u0010?\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u0011H\u0002J\u0010\u0010A\u001a\u00020\u00052\u0006\u0010@\u001a\u00020\u0011H\u0002J\u0010\u0010C\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u0011H\u0002J\u0010\u0010D\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u0011H\u0002J\b\u0010E\u001a\u00020\u0011H\u0002J\b\u0010F\u001a\u00020\u0011H\u0002J\b\u0010G\u001a\u00020\u0005H\u0002J\b\u0010H\u001a\u00020\u0005H\u0002J\b\u0010I\u001a\u00020\u0005H\u0002J\u001c\u0010K\u001a\u00020\u00052\u0006\u0010J\u001a\u00020\u001b2\n\b\u0002\u00102\u001a\u0004\u0018\u000104H\u0002J\u001c\u0010N\u001a\u00020\u00052\u0006\u0010M\u001a\u00020L2\n\b\u0002\u00102\u001a\u0004\u0018\u000104H\u0002J\u001a\u0010Q\u001a\u00020\u00052\u0006\u0010P\u001a\u00020O2\b\u00102\u001a\u0004\u0018\u000104H\u0002J\u0010\u0010T\u001a\u00020\u00052\u0006\u0010S\u001a\u00020RH\u0002J\b\u0010U\u001a\u00020\u0005H\u0002J\b\u0010V\u001a\u00020\u0005H\u0002J\b\u0010W\u001a\u00020\u0005H\u0002J\u001c\u0010[\u001a\u00020\u00052\u0012\u0010Z\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020Y0XH\u0002J$\u0010_\u001a\u00020\u00052\u0006\u0010]\u001a\u00020\\2\u0012\u0010Z\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020Y0^H\u0002J\u0010\u0010b\u001a\u00020\u00052\u0006\u0010a\u001a\u00020`H\u0002J\b\u0010c\u001a\u00020\u0005H\u0002J\b\u0010d\u001a\u00020\u0005H\u0002J\b\u0010e\u001a\u00020\u0005H\u0002J$\u0010k\u001a\u00020\t2\u0006\u0010g\u001a\u00020f2\b\u0010i\u001a\u0004\u0018\u00010h2\b\u0010j\u001a\u0004\u0018\u00010\u0003H\u0016J\u001a\u0010m\u001a\u00020\u00052\u0006\u0010l\u001a\u00020\t2\b\u0010j\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010n\u001a\u00020\u0005H\u0016J\b\u0010o\u001a\u00020\u0011H\u0016J\u0012\u0010r\u001a\u00020\u00052\b\u0010q\u001a\u0004\u0018\u00010pH\u0016J\b\u0010s\u001a\u00020\u0005H\u0016J\b\u0010t\u001a\u00020\u0005H\u0016J\b\u0010u\u001a\u00020\u0011H\u0016J\"\u0010y\u001a\u00020\u00052\u0006\u0010v\u001a\u00020\u001b2\u0006\u0010w\u001a\u00020\u001b2\b\u0010x\u001a\u0004\u0018\u00010pH\u0016J\u0010\u0010|\u001a\u00020\u00052\u0006\u0010{\u001a\u00020zH\u0016J\b\u0010}\u001a\u00020\u0005H\u0016J\b\u0010~\u001a\u00020\u0005H\u0016J\b\u0010\u007f\u001a\u00020\u0005H\u0016J\t\u0010\u0080\u0001\u001a\u00020\u0005H\u0016J\u0015\u0010\u0083\u0001\u001a\u00020\u00052\n\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0081\u0001H\u0016J\t\u0010\u0084\u0001\u001a\u00020\u0011H\u0016J\u0007\u0010\u0085\u0001\u001a\u00020\u0005J\b\u0010\u0087\u0001\u001a\u00030\u0086\u0001J\b\u0010\u0089\u0001\u001a\u00030\u0088\u0001J\u0007\u0010\u008a\u0001\u001a\u00020\tJ\n\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008b\u0001J\b\u0010\u008e\u0001\u001a\u00030\u008d\u0001J\b\u0010\u0090\u0001\u001a\u00030\u008f\u0001J\b\u0010\u0092\u0001\u001a\u00030\u0091\u0001J\n\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0093\u0001R\u0019\u0010\u0097\u0001\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001R\u001a\u0010\u009b\u0001\u001a\u00030\u0098\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001R\u001c\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u008b\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009c\u0001\u0010\u009d\u0001R\u001a\u0010\u00a1\u0001\u001a\u00030\u008d\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u009f\u0001\u0010\u00a0\u0001R\u001a\u0010\u00a4\u0001\u001a\u00030\u008f\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00a2\u0001\u0010\u00a3\u0001R\u001c\u0010\u00a8\u0001\u001a\u0005\u0018\u00010\u00a5\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a6\u0001\u0010\u00a7\u0001R\u001a\u0010\u00ac\u0001\u001a\u00030\u00a9\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00aa\u0001\u0010\u00ab\u0001R\u001a\u0010\u00b0\u0001\u001a\u00030\u00ad\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00ae\u0001\u0010\u00af\u0001R\u001a\u0010\u00b4\u0001\u001a\u00030\u00b1\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00b2\u0001\u0010\u00b3\u0001R\u001a\u0010\u00b8\u0001\u001a\u00030\u00b5\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00b6\u0001\u0010\u00b7\u0001R\u001a\u0010\u00bc\u0001\u001a\u00030\u00b9\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00ba\u0001\u0010\u00bb\u0001R\u0019\u0010\u00be\u0001\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00bd\u0001\u0010\u0096\u0001R\u001c\u0010\u00c2\u0001\u001a\u0005\u0018\u00010\u00bf\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c0\u0001\u0010\u00c1\u0001R\u001a\u0010\u00c6\u0001\u001a\u00030\u00c3\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00c4\u0001\u0010\u00c5\u0001R\u0018\u0010\u00ca\u0001\u001a\u00030\u00c7\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00c8\u0001\u0010\u00c9\u0001R\u001a\u0010\u00cd\u0001\u001a\u00030\u0086\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00cb\u0001\u0010\u00cc\u0001R\u001a\u0010\u00d1\u0001\u001a\u00030\u00ce\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00cf\u0001\u0010\u00d0\u0001R\u001a\u0010\u00d4\u0001\u001a\u00030\u0088\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00d2\u0001\u0010\u00d3\u0001R\u001c\u0010\u00d8\u0001\u001a\u0005\u0018\u00010\u00d5\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00d6\u0001\u0010\u00d7\u0001R\u001a\u0010\u00dc\u0001\u001a\u00030\u00d9\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00da\u0001\u0010\u00db\u0001R\u001c\u0010\u00df\u0001\u001a\u0005\u0018\u00010\u0093\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00dd\u0001\u0010\u00de\u0001R!\u0010\u00e4\u0001\u001a\u00030\u0091\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00e0\u0001\u0010\u00e1\u0001\u001a\u0006\b\u00e2\u0001\u0010\u00e3\u0001R\u0019\u0010\u00e6\u0001\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00e5\u0001\u0010\u00e5\u0001R\u0019\u0010\u00e8\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00e7\u0001\u0010\u00aa\u0001R\u0018\u0010\u00ec\u0001\u001a\u00030\u00e9\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00ea\u0001\u0010\u00eb\u0001R\u0019\u0010\u00ee\u0001\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ed\u0001\u0010\u00e5\u0001R\u001e\u0010\u00f2\u0001\u001a\t\u0012\u0004\u0012\u00020\u00110\u00ef\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00f0\u0001\u0010\u00f1\u0001\u00a8\u0006\u00f7\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/media/GuildMediaChannelFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Lcom/tencent/mobileqq/pad/f;", "Landroid/os/Bundle;", "bundle", "", "checkNeedShowGiftPanel", "initOperationBanner", "Hi", "Landroid/view/View;", "root", "initView", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "Ri", "", "toShow", "ei", "Bj", "Ej", "Ei", "Mi", "di", "toVisibleWhenPortrait", "nj", "", "orientation", "Fj", "cj", "", "errMsg", "bj", "sj", "Ni", "ri", "Gi", "toLandView", "aj", "isToLand", "ni", "oi", "pi", "qi", "rj", "qj", "wj", "Ki", "Lcom/tencent/mobileqq/guild/media/core/notify/b;", "event", "Qi", "Lcom/tencent/mobileqq/guild/media/core/notify/ar;", "fj", "Lcom/tencent/mobileqq/guild/media/core/notify/u;", "Vi", "Lcom/tencent/mobileqq/guild/media/core/notify/v;", "Wi", "Lcom/tencent/mobileqq/guild/media/core/notify/bb;", "jj", "Lcom/tencent/mobileqq/guild/media/core/notify/ThirdAppBarClickEvent;", "ij", "underNeedImmersiveState", "Yi", "needOrientationSensor", "Zi", "needExit", "Xi", "Dj", "Pi", "Li", "tj", "uj", "vj", "topicType", "xj", "Lcom/tencent/mobileqq/guild/media/content/GuildMediaContentFragmentBase;", "contentFragment", "zj", "Landroidx/fragment/app/FragmentTransaction;", "trans", "bi", "Lcom/tencent/mobileqq/guild/media/core/EnterChannelState;", "enterChannelState", "Si", "oj", "initLiuHaiUtil", "pj", "Ljava/util/HashMap;", "", QAdCardExtraData.AdExtraInnerKey.AD_EXTRA_KEY_PAGE_PARAMS, "mj", "Lcom/tencent/mobileqq/guild/mainframe/GuildAppReportSourceInfo;", "sourceInfo", "", "ci", "Lcom/tencent/mobileqq/guild/media/core/notify/n;", "guestStateChangedEvent", "Ui", "Cj", "setOperationBannerVisibility", "kj", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, Constants.FILE_INSTANCE_STATE, "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "qOnNewIntent", "qOnBackPressed", "Landroid/content/Intent;", "intent", "onNewIntent", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "needImmersive", "requestCode", QzoneIPCModule.RESULT_CODE, "data", "onActivityResult", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "onDestroyView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "beforeFinish", "onFinish", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "initWindowStyleAndAnimation", "onBackEvent", "Ji", "Lcom/tencent/mobileqq/guild/media/GuildMediaChannelViewModel;", "hi", "Lcom/tencent/mobileqq/guild/media/aio/GuildMediaAioViewModel;", "fi", "getRootView", "Lcom/tencent/mobileqq/guild/media/content/i;", "ii", "Lcom/tencent/mobileqq/guild/media/widget/GuildMediaChannelFragmentTitleBar;", "mi", "Lcom/tencent/mobileqq/guild/media/widget/GuildMediaChannelFragmentBottomBar;", "gi", "Lcom/tencent/mobileqq/guild/mainframe/api/IGuildMainFrameApi;", WidgetCacheLunarData.JI, "Lcom/tencent/mobileqq/guild/media/aio/GuildMediaRoomMsgGuideController;", "li", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "mRootView", "Landroidx/fragment/app/FragmentContainerView;", "D", "Landroidx/fragment/app/FragmentContainerView;", "mChildFragmentLayout", "E", "Lcom/tencent/mobileqq/guild/media/content/i;", "mContentView", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/media/widget/GuildMediaChannelFragmentTitleBar;", "mTitleBar", "G", "Lcom/tencent/mobileqq/guild/media/widget/GuildMediaChannelFragmentBottomBar;", "mBottomBar", "Lcom/tencent/mobileqq/guild/media/content/loading/GuildMediaLoadingSkeletonContent;", "H", "Lcom/tencent/mobileqq/guild/media/content/loading/GuildMediaLoadingSkeletonContent;", "mLoadingSkeletonView", "Landroid/widget/FrameLayout;", "I", "Landroid/widget/FrameLayout;", "mCustomLayout", "Lcom/tencent/mobileqq/guild/media/listen/widget/ListenWidget;", "J", "Lcom/tencent/mobileqq/guild/media/listen/widget/ListenWidget;", "mListenWidget", "Lcom/tencent/mobileqq/guild/media/listen/presenter/ListenWidgetPresenter;", "K", "Lcom/tencent/mobileqq/guild/media/listen/presenter/ListenWidgetPresenter;", "mListenPresenter", "Lcom/tencent/mobileqq/guild/media/widget/GuildNestedScrollView;", "L", "Lcom/tencent/mobileqq/guild/media/widget/GuildNestedScrollView;", "scrollView", "Lcom/tencent/mobileqq/guild/widget/operationbanner/GuildOperationBanner;", "M", "Lcom/tencent/mobileqq/guild/widget/operationbanner/GuildOperationBanner;", "mOperationBanner", "N", "mAioContainerView", "Lcom/tencent/mobileqq/guild/media/widget/GuildMediaThirdAppInputLayout;", "P", "Lcom/tencent/mobileqq/guild/media/widget/GuildMediaThirdAppInputLayout;", "mThirdAppInputLayout", "Lcom/tencent/mobileqq/guild/media/presenter/ImmersivePresenter;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/guild/media/presenter/ImmersivePresenter;", "immersivePresenter", "Lcom/tencent/mobileqq/guild/media/presenter/GuildMediaLayoutPresenter;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/guild/media/presenter/GuildMediaLayoutPresenter;", "mediaLayoutPresenter", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/guild/media/GuildMediaChannelViewModel;", "mChannelViewModel", "Lcom/tencent/mobileqq/guild/media/viewmodel/b;", "T", "Lcom/tencent/mobileqq/guild/media/viewmodel/b;", "mMicStateViewModel", "U", "Lcom/tencent/mobileqq/guild/media/aio/GuildMediaAioViewModel;", "aioViewModel", "Lcom/tencent/mobileqq/guild/live/livemanager/QQGuildOrientationSensorManager;", "V", "Lcom/tencent/mobileqq/guild/live/livemanager/QQGuildOrientationSensorManager;", "mOrientationSensor", "Lcom/tencent/mobileqq/guild/channel/frame/bottom/GuildChannelGuestBottomManager;", "W", "Lcom/tencent/mobileqq/guild/channel/frame/bottom/GuildChannelGuestBottomManager;", "mGuestBottomManager", "X", "Lcom/tencent/mobileqq/guild/media/aio/GuildMediaRoomMsgGuideController;", "mMsgGuideController", "Y", "Lkotlin/Lazy;", "ki", "()Lcom/tencent/mobileqq/guild/mainframe/api/IGuildMainFrameApi;", "mainFrameApi", "Z", "hasDestroyed", "a0", "currentOrientation", "Lcom/tencent/mobileqq/guild/media/floatwindow/FloatWindowPermissionHandler;", "b0", "Lcom/tencent/mobileqq/guild/media/floatwindow/FloatWindowPermissionHandler;", "mFloatWindowPermissionHandler", "c0", "mExitPageTriggered", "Landroidx/lifecycle/Observer;", "d0", "Landroidx/lifecycle/Observer;", "mExitPageObserver", "<init>", "()V", "e0", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMediaChannelFragment extends QPublicBaseFragment implements com.tencent.mobileqq.pad.f {

    /* renamed from: C, reason: from kotlin metadata */
    private View mRootView;

    /* renamed from: D, reason: from kotlin metadata */
    private FragmentContainerView mChildFragmentLayout;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.guild.media.content.i mContentView;

    /* renamed from: F, reason: from kotlin metadata */
    private GuildMediaChannelFragmentTitleBar mTitleBar;

    /* renamed from: G, reason: from kotlin metadata */
    private GuildMediaChannelFragmentBottomBar mBottomBar;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private GuildMediaLoadingSkeletonContent mLoadingSkeletonView;

    /* renamed from: I, reason: from kotlin metadata */
    private FrameLayout mCustomLayout;

    /* renamed from: J, reason: from kotlin metadata */
    private ListenWidget mListenWidget;

    /* renamed from: K, reason: from kotlin metadata */
    private ListenWidgetPresenter mListenPresenter;

    /* renamed from: L, reason: from kotlin metadata */
    private GuildNestedScrollView scrollView;

    /* renamed from: M, reason: from kotlin metadata */
    private GuildOperationBanner mOperationBanner;

    /* renamed from: N, reason: from kotlin metadata */
    private View mAioContainerView;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private GuildMediaThirdAppInputLayout mThirdAppInputLayout;

    /* renamed from: Q, reason: from kotlin metadata */
    private ImmersivePresenter immersivePresenter;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final GuildMediaLayoutPresenter mediaLayoutPresenter = new GuildMediaLayoutPresenter();

    /* renamed from: S, reason: from kotlin metadata */
    private GuildMediaChannelViewModel mChannelViewModel;

    /* renamed from: T, reason: from kotlin metadata */
    private com.tencent.mobileqq.guild.media.viewmodel.b mMicStateViewModel;

    /* renamed from: U, reason: from kotlin metadata */
    private GuildMediaAioViewModel aioViewModel;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private QQGuildOrientationSensorManager mOrientationSensor;

    /* renamed from: W, reason: from kotlin metadata */
    private GuildChannelGuestBottomManager mGuestBottomManager;

    /* renamed from: X, reason: from kotlin metadata */
    @Nullable
    private GuildMediaRoomMsgGuideController mMsgGuideController;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private final Lazy mainFrameApi;

    /* renamed from: Z, reason: from kotlin metadata */
    private boolean hasDestroyed;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private int currentOrientation;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FloatWindowPermissionHandler mFloatWindowPermissionHandler;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private boolean mExitPageTriggered;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer<Boolean> mExitPageObserver;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f227755a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f227756b;

        static {
            int[] iArr = new int[ThirdAppBarClickEvent.values().length];
            try {
                iArr[ThirdAppBarClickEvent.FULL_PORTRAIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ThirdAppBarClickEvent.FULL_LAND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ThirdAppBarClickEvent.MINIMIZE_LAND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ThirdAppBarClickEvent.MINIMIZE_PORTRAIT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f227755a = iArr;
            int[] iArr2 = new int[EnterChannelState.values().length];
            try {
                iArr2[EnterChannelState.ENTER_SUC.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[EnterChannelState.ENTER_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            f227756b = iArr2;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/GuildMediaChannelFragment$c", "Lcom/tencent/mobileqq/guild/live/livemanager/QQGuildOrientationSensorManager$b;", "", "newOrientation", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements QQGuildOrientationSensorManager.b {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.live.livemanager.QQGuildOrientationSensorManager.b
        public void a(int newOrientation) {
            boolean z16;
            if (newOrientation != 0 && newOrientation != 8) {
                z16 = false;
            } else {
                z16 = true;
            }
            QLog.i("QGMC.GuildMediaChannelFragment", 1, "[initOrientationSensor] on orientation changed: " + newOrientation + ", " + z16);
            GuildMediaChannelFragment.this.aj(z16);
        }
    }

    public GuildMediaChannelFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IGuildMainFrameApi>() { // from class: com.tencent.mobileqq.guild.media.GuildMediaChannelFragment$mainFrameApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IGuildMainFrameApi invoke() {
                return (IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class);
            }
        });
        this.mainFrameApi = lazy;
        this.currentOrientation = 1;
        this.mFloatWindowPermissionHandler = new FloatWindowPermissionHandler(getActivity());
        this.mExitPageObserver = new Observer() { // from class: com.tencent.mobileqq.guild.media.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildMediaChannelFragment.Oi(GuildMediaChannelFragment.this, (Boolean) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ai(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    static /* synthetic */ void Aj(GuildMediaChannelFragment guildMediaChannelFragment, GuildMediaContentFragmentBase guildMediaContentFragmentBase, SwitchThemeEvent switchThemeEvent, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            switchThemeEvent = null;
        }
        guildMediaChannelFragment.zj(guildMediaContentFragmentBase, switchThemeEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final boolean Bj() {
        GuildMediaAioViewModel guildMediaAioViewModel = this.aioViewModel;
        if (guildMediaAioViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioViewModel");
            guildMediaAioViewModel = null;
        }
        if (!guildMediaAioViewModel.g2()) {
            return false;
        }
        GuildMediaAioViewModel guildMediaAioViewModel2 = this.aioViewModel;
        if (guildMediaAioViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioViewModel");
            guildMediaAioViewModel2 = null;
        }
        guildMediaAioViewModel2.l2(new b.h(false, 1, null));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ci(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0069, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r0.a2().getValue(), java.lang.Boolean.TRUE) == false) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Cj() {
        boolean z16;
        GuildMediaAioViewModel guildMediaAioViewModel = this.aioViewModel;
        GuildMediaChannelFragmentBottomBar guildMediaChannelFragmentBottomBar = null;
        if (guildMediaAioViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioViewModel");
            guildMediaAioViewModel = null;
        }
        Boolean value = guildMediaAioViewModel.T1().getValue();
        if (value == null) {
            value = Boolean.FALSE;
        }
        boolean booleanValue = value.booleanValue();
        FrameLayout frameLayout = this.mCustomLayout;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCustomLayout");
            frameLayout = null;
        }
        int i3 = 0;
        if (frameLayout.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        GuildMediaChannelFragmentBottomBar guildMediaChannelFragmentBottomBar2 = this.mBottomBar;
        if (guildMediaChannelFragmentBottomBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomBar");
            guildMediaChannelFragmentBottomBar2 = null;
        }
        int visibility = guildMediaChannelFragmentBottomBar2.getVisibility();
        GuildMediaChannelFragmentBottomBar guildMediaChannelFragmentBottomBar3 = this.mBottomBar;
        if (guildMediaChannelFragmentBottomBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomBar");
            guildMediaChannelFragmentBottomBar3 = null;
        }
        if (booleanValue && !z16) {
            GuildMediaChannelViewModel guildMediaChannelViewModel = this.mChannelViewModel;
            if (guildMediaChannelViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
                guildMediaChannelViewModel = null;
            }
        }
        i3 = 8;
        guildMediaChannelFragmentBottomBar3.setVisibility(i3);
        if (visibility == 8) {
            GuildMediaChannelFragmentBottomBar guildMediaChannelFragmentBottomBar4 = this.mBottomBar;
            if (guildMediaChannelFragmentBottomBar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBottomBar");
                guildMediaChannelFragmentBottomBar4 = null;
            }
            if (guildMediaChannelFragmentBottomBar4.getVisibility() == 0) {
                GuildMediaChannelFragmentBottomBar guildMediaChannelFragmentBottomBar5 = this.mBottomBar;
                if (guildMediaChannelFragmentBottomBar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBottomBar");
                    guildMediaChannelFragmentBottomBar5 = null;
                }
                guildMediaChannelFragmentBottomBar5.setAlpha(0.0f);
                GuildMediaChannelFragmentBottomBar guildMediaChannelFragmentBottomBar6 = this.mBottomBar;
                if (guildMediaChannelFragmentBottomBar6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBottomBar");
                } else {
                    guildMediaChannelFragmentBottomBar = guildMediaChannelFragmentBottomBar6;
                }
                guildMediaChannelFragmentBottomBar.animate().alpha(1.0f).setDuration(100L).start();
            }
        }
        setOperationBannerVisibility();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Di(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Dj(boolean underNeedImmersiveState) {
        GuildNestedScrollView guildNestedScrollView = this.scrollView;
        FrameLayout frameLayout = null;
        if (guildNestedScrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollView");
            guildNestedScrollView = null;
        }
        ViewGroup.LayoutParams layoutParams = guildNestedScrollView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (underNeedImmersiveState) {
            marginLayoutParams.topMargin = 0;
            marginLayoutParams.bottomMargin = 0;
            return;
        }
        GuildMediaChannelFragmentTitleBar guildMediaChannelFragmentTitleBar = this.mTitleBar;
        if (guildMediaChannelFragmentTitleBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
            guildMediaChannelFragmentTitleBar = null;
        }
        guildMediaChannelFragmentTitleBar.measure(0, 0);
        GuildMediaChannelFragmentBottomBar guildMediaChannelFragmentBottomBar = this.mBottomBar;
        if (guildMediaChannelFragmentBottomBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomBar");
            guildMediaChannelFragmentBottomBar = null;
        }
        guildMediaChannelFragmentBottomBar.measure(0, 0);
        FrameLayout frameLayout2 = this.mCustomLayout;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCustomLayout");
            frameLayout2 = null;
        }
        frameLayout2.measure(0, 0);
        GuildMediaChannelFragmentTitleBar guildMediaChannelFragmentTitleBar2 = this.mTitleBar;
        if (guildMediaChannelFragmentTitleBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
            guildMediaChannelFragmentTitleBar2 = null;
        }
        marginLayoutParams.topMargin = guildMediaChannelFragmentTitleBar2.getMeasuredHeight();
        GuildMediaChannelFragmentBottomBar guildMediaChannelFragmentBottomBar2 = this.mBottomBar;
        if (guildMediaChannelFragmentBottomBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomBar");
            guildMediaChannelFragmentBottomBar2 = null;
        }
        int measuredHeight = guildMediaChannelFragmentBottomBar2.getMeasuredHeight();
        FrameLayout frameLayout3 = this.mCustomLayout;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCustomLayout");
        } else {
            frameLayout = frameLayout3;
        }
        marginLayoutParams.bottomMargin = Math.max(measuredHeight, frameLayout.getMeasuredHeight());
    }

    private final void Ei() {
        GuildMediaChannelViewModel guildMediaChannelViewModel = this.mChannelViewModel;
        GuildChannelGuestBottomManager guildChannelGuestBottomManager = null;
        if (guildMediaChannelViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
            guildMediaChannelViewModel = null;
        }
        String guildId = guildMediaChannelViewModel.getGuildInfo().getGuildID();
        GuildMediaChannelViewModel guildMediaChannelViewModel2 = this.mChannelViewModel;
        if (guildMediaChannelViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
            guildMediaChannelViewModel2 = null;
        }
        String channelId = guildMediaChannelViewModel2.getChannelInfo().getChannelUin();
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        Intrinsics.checkNotNullExpressionValue(guildId, "guildId");
        Intrinsics.checkNotNullExpressionValue(channelId, "channelId");
        Bundle arguments = getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        GuildChannelGuestBottomManager guildChannelGuestBottomManager2 = new GuildChannelGuestBottomManager(requireContext, guildId, channelId, arguments);
        this.mGuestBottomManager = guildChannelGuestBottomManager2;
        FrameLayout frameLayout = this.mCustomLayout;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCustomLayout");
            frameLayout = null;
        }
        guildChannelGuestBottomManager2.r(frameLayout);
        GuildChannelGuestBottomManager guildChannelGuestBottomManager3 = this.mGuestBottomManager;
        if (guildChannelGuestBottomManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuestBottomManager");
        } else {
            guildChannelGuestBottomManager = guildChannelGuestBottomManager3;
        }
        guildChannelGuestBottomManager.l();
        di();
        Cj();
    }

    private final void Ej() {
        ListenWidgetPresenter listenWidgetPresenter = this.mListenPresenter;
        if (listenWidgetPresenter != null) {
            if (listenWidgetPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mListenPresenter");
                listenWidgetPresenter = null;
            }
            listenWidgetPresenter.K();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Fj(int orientation) {
        if (orientation == this.currentOrientation) {
            return;
        }
        QLog.d("QGMC.GuildMediaChannelFragment", 1, "updateOrientation: " + orientation);
        com.tencent.mobileqq.guild.media.core.j.d().i(new ai(orientation));
        this.currentOrientation = orientation;
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    private final void Gi() {
        if (AppSetting.t(getContext())) {
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setRequestedOrientation(1);
        }
        this.mOrientationSensor = new QQGuildOrientationSensorManager(new c());
    }

    private final void Hi() {
        int roomTheme = MediaChannelCore.INSTANCE.a().o0().getStartParams().getPreviewData().getRoomTheme();
        if (com.tencent.mobileqq.guild.media.core.j.a().U() && roomTheme != 0) {
            if (roomTheme == 1 || roomTheme == 2) {
                zj(y.INSTANCE.a(roomTheme), new SwitchThemeEvent(0, roomTheme));
                return;
            }
            return;
        }
        tj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ii(Activity activity) {
        boolean z16;
        if (!activity.isFinishing() && !activity.isDestroyed()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            activity.overridePendingTransition(0, R.anim.f155066i1);
        }
    }

    private final boolean Ki() {
        boolean z16;
        boolean z17;
        if (getActivity() == null) {
            return true;
        }
        FragmentActivity activity = getActivity();
        if (activity != null && activity.isFinishing()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && activity2.isDestroyed()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 || getContext() == null) {
            return true;
        }
        return false;
    }

    private final boolean Li() {
        return Intrinsics.areEqual(MediaChannelCore.INSTANCE.a().o0().getStartParams().getSourceType(), "functional_qq_little_world_feed");
    }

    private final boolean Mi() {
        Configuration configuration = getResources().getConfiguration();
        if (configuration == null || configuration.orientation != 2) {
            return false;
        }
        return true;
    }

    private final void Ni() {
        String str;
        if (!Ki() && !this.hasDestroyed && !com.tencent.mobileqq.pad.m.b(requireActivity())) {
            String s16 = com.tencent.mobileqq.guild.media.core.j.c().s();
            Bundle arguments = getArguments();
            if (arguments != null) {
                str = arguments.getString("ARG_KEY");
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(s16, str)) {
                QLog.d("QGMC.GuildMediaChannelFragment", 1, "exitWithPadJudge activity finish");
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    activity.finish();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oi(GuildMediaChannelFragment this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (it.booleanValue() && !this$0.mExitPageTriggered) {
            this$0.Xi(it.booleanValue());
            this$0.mExitPageTriggered = true;
        }
    }

    private final boolean Pi() {
        return !Li();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Qi(com.tencent.mobileqq.guild.media.core.notify.b event) {
        if (event.getIsSelf() && !event.getNotifyAll()) {
            WeakReference weakReference = new WeakReference(getContext());
            if (((Context) weakReference.get()) != null) {
                new com.tencent.mobileqq.guild.media.widget.f(weakReference, com.tencent.mobileqq.guild.media.core.j.a()).show();
            }
        }
    }

    private final void Ri(IGProGuildInfo guildInfo, IGProChannelInfo channelInfo) {
        GuildMediaChannelFragmentBottomBar guildMediaChannelFragmentBottomBar = this.mBottomBar;
        com.tencent.mobileqq.guild.media.viewmodel.b bVar = null;
        if (guildMediaChannelFragmentBottomBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomBar");
            guildMediaChannelFragmentBottomBar = null;
        }
        com.tencent.mobileqq.guild.media.viewmodel.b bVar2 = this.mMicStateViewModel;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMicStateViewModel");
        } else {
            bVar = bVar2;
        }
        guildMediaChannelFragmentBottomBar.k(this, guildInfo, channelInfo, bVar);
        ei(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00e7, code lost:
    
        if (r4 != false) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Si(EnterChannelState enterChannelState) {
        boolean z16;
        IGProPlayNodeExtInfo playNodeExInfo;
        IGProPlayNodeExtInfo playNodeExInfo2;
        GuildMediaAioViewModel guildMediaAioViewModel = this.aioViewModel;
        ListenWidgetPresenter listenWidgetPresenter = null;
        if (guildMediaAioViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioViewModel");
            guildMediaAioViewModel = null;
        }
        boolean L1 = guildMediaAioViewModel.L1();
        boolean z17 = true;
        QLog.i("QGMC.GuildMediaChannelFragment", 1, "[onEnterChannelStateChanged]  " + enterChannelState + "\uff0c canShowAioMsg = " + L1);
        int i3 = b.f227756b[enterChannelState.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                Ni();
                return;
            }
            return;
        }
        uj();
        GuildMediaChannelViewModel guildMediaChannelViewModel = this.mChannelViewModel;
        if (guildMediaChannelViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
            guildMediaChannelViewModel = null;
        }
        if (guildMediaChannelViewModel.e2()) {
            yj(this, com.tencent.mobileqq.guild.media.core.m.n(com.tencent.mobileqq.guild.media.core.j.c()), null, 2, null);
            if (com.tencent.mobileqq.guild.media.core.m.n(com.tencent.mobileqq.guild.media.core.j.c()) == 2) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.media.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        GuildMediaChannelFragment.Ti(GuildMediaChannelFragment.this);
                    }
                });
            }
        }
        if (L1) {
            if (this.mMsgGuideController == null) {
                this.mMsgGuideController = new GuildMediaRoomMsgGuideController();
            }
            GuildMediaRoomMsgGuideController guildMediaRoomMsgGuideController = this.mMsgGuideController;
            if (guildMediaRoomMsgGuideController != null) {
                View view = this.mRootView;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                    view = null;
                }
                guildMediaRoomMsgGuideController.f((ViewGroup) view);
            }
        }
        com.tencent.mobileqq.guild.media.core.logic.ab M0 = com.tencent.mobileqq.guild.media.core.j.a().M0();
        ListenWidgetPresenter listenWidgetPresenter2 = this.mListenPresenter;
        if (listenWidgetPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListenPresenter");
        } else {
            listenWidgetPresenter = listenWidgetPresenter2;
        }
        M0.X0(listenWidgetPresenter);
        IGProPlayInfo I = com.tencent.mobileqq.guild.media.core.j.c().I();
        if (I != null && (playNodeExInfo2 = I.getPlayNodeExInfo()) != null && playNodeExInfo2.getPlayState() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            IGProPlayInfo I2 = com.tencent.mobileqq.guild.media.core.j.c().I();
            if (I2 == null || (playNodeExInfo = I2.getPlayNodeExInfo()) == null || playNodeExInfo.getPlayState() != 2) {
                z17 = false;
            }
        }
        Ej();
        kj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ti(GuildMediaChannelFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GuildNestedScrollView guildNestedScrollView = this$0.scrollView;
        if (guildNestedScrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollView");
            guildNestedScrollView = null;
        }
        guildNestedScrollView.scrollTo(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ui(com.tencent.mobileqq.guild.media.core.notify.n guestStateChangedEvent) {
        nj(guestStateChangedEvent.getIsShowGuestView());
        Cj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Vi(com.tencent.mobileqq.guild.media.core.notify.u event) {
        if (event.getIsFromEnter()) {
            Dj(false);
            com.tencent.mobileqq.guild.media.core.j.a().M0().F0();
        } else {
            Ej();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Wi(com.tencent.mobileqq.guild.media.core.notify.v event) {
        GuildMediaAioViewModel guildMediaAioViewModel = this.aioViewModel;
        if (guildMediaAioViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioViewModel");
            guildMediaAioViewModel = null;
        }
        guildMediaAioViewModel.l2(new b.c(Integer.valueOf(R.drawable.guild_media_tips_icon), event.getTips(), null, null, 12, null));
    }

    private final void Xi(boolean needExit) {
        if (needExit) {
            Ni();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Yi(boolean underNeedImmersiveState) {
        QLog.i("QGMC.GuildMediaChannelFragment", 1, "[onNeedImmersiveStateChanged] " + underNeedImmersiveState);
        Dj(underNeedImmersiveState);
        ImmersivePresenter immersivePresenter = this.immersivePresenter;
        if (immersivePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("immersivePresenter");
            immersivePresenter = null;
        }
        immersivePresenter.s(underNeedImmersiveState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Zi(boolean needOrientationSensor) {
        QQGuildOrientationSensorManager qQGuildOrientationSensorManager;
        QLog.i("QGMC.GuildMediaChannelFragment", 1, "[onNeedOrientationChanged] " + needOrientationSensor);
        if (needOrientationSensor) {
            if (getActivity() != null && (qQGuildOrientationSensorManager = this.mOrientationSensor) != null) {
                qQGuildOrientationSensorManager.f();
                return;
            }
            return;
        }
        QQGuildOrientationSensorManager qQGuildOrientationSensorManager2 = this.mOrientationSensor;
        if (qQGuildOrientationSensorManager2 != null) {
            qQGuildOrientationSensorManager2.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"SourceLockedOrientationActivity"})
    public final void aj(boolean toLandView) {
        Window window;
        Window window2;
        QLog.i("QGMC.GuildMediaChannelFragment", 1, "[onOrientationChanged] " + toLandView);
        setOperationBannerVisibility();
        if (toLandView) {
            FragmentActivity activity = getActivity();
            if (activity != null && (window2 = activity.getWindow()) != null) {
                window2.addFlags(1024);
            }
        } else {
            FragmentActivity activity2 = getActivity();
            if (activity2 != null && (window = activity2.getWindow()) != null) {
                window.clearFlags(1024);
            }
        }
        com.tencent.mobileqq.guild.media.content.i iVar = this.mContentView;
        if (iVar instanceof GuildMediaChatContent) {
            Intrinsics.checkNotNull(iVar, "null cannot be cast to non-null type com.tencent.mobileqq.guild.media.content.GuildMediaChatContent");
            if (((GuildMediaChatContent) iVar).Xh()) {
                ni(toLandView);
                return;
            } else {
                if (!toLandView) {
                    oi(false);
                    return;
                }
                return;
            }
        }
        if (iVar instanceof GuildMediaLandVideoView) {
            oi(toLandView);
        } else if (iVar instanceof GuildMediaThirdAppContent) {
            if (toLandView) {
                qi();
            } else {
                pi();
            }
        }
    }

    private final void bi(FragmentTransaction trans, SwitchThemeEvent event) {
        if (event == null) {
            return;
        }
        if (event.getOldThemeType() == 1 && event.getNewThemeType() == 2) {
            trans.setCustomAnimations(R.anim.f154637p9, R.anim.f154634p6);
        }
        if (event.getOldThemeType() == 2 && event.getNewThemeType() == 1) {
            trans.setCustomAnimations(R.anim.f154633p5, R.anim.p_);
        }
        if (event.getOldThemeType() == 6 && event.getNewThemeType() == 1) {
            trans.setCustomAnimations(R.anim.f154637p9, R.anim.f154634p6);
        }
        if (event.getOldThemeType() == 6 && event.getNewThemeType() == 2) {
            trans.setCustomAnimations(R.anim.f154633p5, R.anim.p_);
        }
        if (event.getOldThemeType() == 2 && event.getNewThemeType() == 6) {
            trans.setCustomAnimations(R.anim.f154637p9, R.anim.f154634p6);
        }
        if (event.getOldThemeType() == 1 && event.getNewThemeType() == 6) {
            trans.setCustomAnimations(R.anim.f154633p5, R.anim.p_);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bj(String errMsg) {
        this.mFloatWindowPermissionHandler.f();
        com.tencent.mobileqq.guild.media.core.e a16 = com.tencent.mobileqq.guild.media.core.j.a();
        GuildMediaChannelViewModel guildMediaChannelViewModel = this.mChannelViewModel;
        String str = null;
        if (guildMediaChannelViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
            guildMediaChannelViewModel = null;
        }
        String channelUin = guildMediaChannelViewModel.getChannelInfo().getChannelUin();
        Intrinsics.checkNotNullExpressionValue(channelUin, "this.mChannelViewModel.channelInfo.channelUin");
        Bundle arguments = getArguments();
        if (arguments != null) {
            str = arguments.getString("ARG_KEY");
        }
        a16.R("", errMsg, channelUin, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0011, code lost:
    
        if (r8.getBoolean("open_gift_panel") == true) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void checkNeedShowGiftPanel(Bundle bundle) {
        boolean z16;
        if (!Ki()) {
            if (bundle != null) {
                z16 = true;
            }
            z16 = false;
            if (z16) {
                com.tencent.mobileqq.guild.media.core.logic.gift.a b06 = com.tencent.mobileqq.guild.media.core.j.a().b0();
                Long valueOf = Long.valueOf(bundle.getLong("gift_receiver"));
                FragmentActivity requireActivity = requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                b06.J(valueOf, requireActivity, ShowPanelTab.Default);
                bundle.putBoolean("open_gift_panel", false);
                bundle.putLong("gift_receiver", 0L);
                Bundle enterChannelExtraData = com.tencent.mobileqq.guild.media.core.j.c().getEnterChannelExtraData();
                if (enterChannelExtraData != null) {
                    enterChannelExtraData.putBoolean("open_gift_panel", false);
                }
                Bundle enterChannelExtraData2 = com.tencent.mobileqq.guild.media.core.j.c().getEnterChannelExtraData();
                if (enterChannelExtraData2 != null) {
                    enterChannelExtraData2.putLong("gift_receiver", 0L);
                }
            }
        }
    }

    private final void ci(GuildAppReportSourceInfo sourceInfo, Map<String, Object> pageParams) {
        Map<String, String> reportInfoMap = sourceInfo.getReportInfoMap();
        for (String key : reportInfoMap.keySet()) {
            if (reportInfoMap.get(key) != null) {
                Intrinsics.checkNotNullExpressionValue(key, "key");
                String str = reportInfoMap.get(key);
                Intrinsics.checkNotNull(str);
                pageParams.put(key, str);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("QGMC.GuildMediaChannelFragment", 2, "addReportInfoToParams sourceInfo ", sourceInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cj() {
        this.mFloatWindowPermissionHandler.f();
        if (getContext() != null) {
            Configuration configuration = getResources().getConfiguration();
            boolean z16 = false;
            if (configuration != null && configuration.orientation == 2) {
                z16 = true;
            }
            if (z16) {
                ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.media.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        GuildMediaChannelFragment.dj(GuildMediaChannelFragment.this);
                    }
                }, 100L);
                Ni();
            }
        }
        sj();
        Ni();
    }

    private final void di() {
        GuildChannelGuestBottomManager guildChannelGuestBottomManager = this.mGuestBottomManager;
        if (guildChannelGuestBottomManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuestBottomManager");
            guildChannelGuestBottomManager = null;
        }
        nj(guildChannelGuestBottomManager.e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dj(GuildMediaChannelFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sj();
    }

    private final void ei(boolean toShow) {
        GuildMediaChannelFragmentBottomBar guildMediaChannelFragmentBottomBar;
        if (!Pi() && (guildMediaChannelFragmentBottomBar = this.mBottomBar) != null) {
            if (guildMediaChannelFragmentBottomBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBottomBar");
                guildMediaChannelFragmentBottomBar = null;
            }
            guildMediaChannelFragmentBottomBar.q(toShow);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ej(GuildMediaChannelFragment this$0) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getActivity() != null) {
            FragmentActivity activity = this$0.getActivity();
            boolean z17 = true;
            if (activity != null && activity.isFinishing()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                FragmentActivity activity2 = this$0.getActivity();
                if (activity2 == null || !activity2.isDestroyed()) {
                    z17 = false;
                }
                if (!z17) {
                    this$0.ki().notifyGuildFrameVisibleChanged("media channel, on resume.", false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fj(final SwitchThemeEvent event) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.media.m
            @Override // java.lang.Runnable
            public final void run() {
                GuildMediaChannelFragment.gj(SwitchThemeEvent.this, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void gj(SwitchThemeEvent event, GuildMediaChannelFragment this$0) {
        Intrinsics.checkNotNullParameter(event, "$event");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("QGMC.GuildMediaChannelFragment", 1, "[onEventReceive] " + event.getOldThemeType() + " --> " + event.getNewThemeType());
        if (event.getNewThemeType() == 0) {
            return;
        }
        if (event.getNewThemeType() == 6 && bw.k() == 1) {
            GuildMediaAioViewModel guildMediaAioViewModel = this$0.aioViewModel;
            if (guildMediaAioViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioViewModel");
                guildMediaAioViewModel = null;
            }
            Integer valueOf = Integer.valueOf(R.drawable.guild_media_tips_icon);
            String string = BaseApplication.context.getString(R.string.f1496512v);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026.guild_media_mode_change)");
            guildMediaAioViewModel.l2(new b.c(valueOf, string, null, null, 12, null));
            MediaChannelCore.INSTANCE.a().y0().b(4);
        } else {
            MediaChannelCore.INSTANCE.a().y0().b(bw.k());
        }
        this$0.xj(event.getNewThemeType(), event);
        com.tencent.mobileqq.guild.media.core.logic.s W = com.tencent.mobileqq.guild.media.core.j.a().W();
        if (W.b()) {
            W.e(false);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.media.n
                @Override // java.lang.Runnable
                public final void run() {
                    GuildMediaChannelFragment.hj();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hj() {
        com.tencent.mobileqq.guild.media.core.j.d().i(new ScreenShareActionEvent(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ij(ThirdAppBarClickEvent event) {
        int i3 = b.f227755a[event.ordinal()];
        GuildMediaChannelFragmentBottomBar guildMediaChannelFragmentBottomBar = null;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3 || i3 == 4) {
                    GuildChannelGuestBottomManager guildChannelGuestBottomManager = this.mGuestBottomManager;
                    if (guildChannelGuestBottomManager == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mGuestBottomManager");
                        guildChannelGuestBottomManager = null;
                    }
                    FrameLayout frameLayout = this.mCustomLayout;
                    if (frameLayout == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mCustomLayout");
                        frameLayout = null;
                    }
                    guildChannelGuestBottomManager.r(frameLayout);
                    Dj(false);
                    ImmersivePresenter immersivePresenter = this.immersivePresenter;
                    if (immersivePresenter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("immersivePresenter");
                        immersivePresenter = null;
                    }
                    GuildMediaChannelFragmentTitleBar guildMediaChannelFragmentTitleBar = this.mTitleBar;
                    if (guildMediaChannelFragmentTitleBar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
                        guildMediaChannelFragmentTitleBar = null;
                    }
                    GuildMediaChannelFragmentBottomBar guildMediaChannelFragmentBottomBar2 = this.mBottomBar;
                    if (guildMediaChannelFragmentBottomBar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBottomBar");
                    } else {
                        guildMediaChannelFragmentBottomBar = guildMediaChannelFragmentBottomBar2;
                    }
                    immersivePresenter.o(guildMediaChannelFragmentTitleBar, guildMediaChannelFragmentBottomBar);
                    com.tencent.mobileqq.guild.media.core.j.a().M0().Q0(true);
                    di();
                    return;
                }
                return;
            }
            GuildChannelGuestBottomManager guildChannelGuestBottomManager2 = this.mGuestBottomManager;
            if (guildChannelGuestBottomManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGuestBottomManager");
                guildChannelGuestBottomManager2 = null;
            }
            guildChannelGuestBottomManager2.r(null);
            return;
        }
        Dj(true);
        ImmersivePresenter immersivePresenter2 = this.immersivePresenter;
        if (immersivePresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("immersivePresenter");
            immersivePresenter2 = null;
        }
        GuildMediaChannelFragmentTitleBar guildMediaChannelFragmentTitleBar2 = this.mTitleBar;
        if (guildMediaChannelFragmentTitleBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
            guildMediaChannelFragmentTitleBar2 = null;
        }
        GuildMediaChannelFragmentBottomBar guildMediaChannelFragmentBottomBar3 = this.mBottomBar;
        if (guildMediaChannelFragmentBottomBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomBar");
            guildMediaChannelFragmentBottomBar3 = null;
        }
        immersivePresenter2.n(guildMediaChannelFragmentTitleBar2, guildMediaChannelFragmentBottomBar3);
        com.tencent.mobileqq.guild.media.core.j.a().M0().Q0(false);
        nj(false);
        GuildChannelGuestBottomManager guildChannelGuestBottomManager3 = this.mGuestBottomManager;
        if (guildChannelGuestBottomManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuestBottomManager");
            guildChannelGuestBottomManager3 = null;
        }
        guildChannelGuestBottomManager3.r(null);
    }

    private final void initLiuHaiUtil() {
        if (getActivity() != null) {
            LiuHaiUtils.initLiuHaiProperty(getActivity());
            LiuHaiUtils.enableNotch(getActivity());
            LiuHaiUtils.initLiuHaiBarHeight(getActivity());
        }
    }

    private final void initOperationBanner() {
        GuildOperationBanner guildOperationBanner;
        GuildOperationBanner guildOperationBanner2 = this.mOperationBanner;
        GuildMediaChannelViewModel guildMediaChannelViewModel = null;
        if (guildOperationBanner2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOperationBanner");
            guildOperationBanner = null;
        } else {
            guildOperationBanner = guildOperationBanner2;
        }
        GuildMediaChannelViewModel guildMediaChannelViewModel2 = this.mChannelViewModel;
        if (guildMediaChannelViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
            guildMediaChannelViewModel2 = null;
        }
        long stringToLong = NumberUtil.stringToLong(guildMediaChannelViewModel2.getChannelInfo().getGuildId());
        GuildMediaChannelViewModel guildMediaChannelViewModel3 = this.mChannelViewModel;
        if (guildMediaChannelViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
            guildMediaChannelViewModel3 = null;
        }
        long stringToLong2 = NumberUtil.stringToLong(guildMediaChannelViewModel3.getChannelInfo().getChannelUin());
        GuildMediaChannelViewModel guildMediaChannelViewModel4 = this.mChannelViewModel;
        if (guildMediaChannelViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
            guildMediaChannelViewModel4 = null;
        }
        guildOperationBanner.u(stringToLong, stringToLong2, guildMediaChannelViewModel4.getChannelInfo().getType());
        GuildMediaChannelViewModel guildMediaChannelViewModel5 = this.mChannelViewModel;
        if (guildMediaChannelViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
        } else {
            guildMediaChannelViewModel = guildMediaChannelViewModel5;
        }
        MutableLiveData<Boolean> b26 = guildMediaChannelViewModel.b2();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.media.GuildMediaChannelFragment$initOperationBanner$1
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
            public final void invoke2(Boolean bool) {
                GuildMediaChannelFragment.this.setOperationBannerVisibility();
            }
        };
        b26.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.media.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildMediaChannelFragment.Fi(Function1.this, obj);
            }
        });
    }

    private final void initView(View root) {
        GuildMediaChannelViewModel guildMediaChannelViewModel = this.mChannelViewModel;
        ListenWidget listenWidget = null;
        if (guildMediaChannelViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
            guildMediaChannelViewModel = null;
        }
        IGProGuildInfo guildInfo = guildMediaChannelViewModel.getGuildInfo();
        GuildMediaChannelViewModel guildMediaChannelViewModel2 = this.mChannelViewModel;
        if (guildMediaChannelViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
            guildMediaChannelViewModel2 = null;
        }
        IGProChannelInfo channelInfo = guildMediaChannelViewModel2.getChannelInfo();
        View findViewById = root.findViewById(R.id.jp7);
        GuildMediaChannelFragmentTitleBar guildMediaChannelFragmentTitleBar = (GuildMediaChannelFragmentTitleBar) findViewById;
        guildMediaChannelFragmentTitleBar.a(this, guildInfo, channelInfo);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById<GuildM\u2026guildInfo, channelInfo) }");
        this.mTitleBar = guildMediaChannelFragmentTitleBar;
        View findViewById2 = root.findViewById(R.id.acy);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "root.findViewById<GuildM\u2026mBar>(R.id.bottom_layout)");
        this.mBottomBar = (GuildMediaChannelFragmentBottomBar) findViewById2;
        Ri(guildInfo, channelInfo);
        View view = this.mRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        View findViewById3 = view.findViewById(R.id.ucr);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R.id.custom_layout)");
        this.mCustomLayout = (FrameLayout) findViewById3;
        View view2 = this.mRootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view2 = null;
        }
        View findViewById4 = view2.findViewById(R.id.yzs);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mRootView.findViewById(R\u2026channel_root_scroll_view)");
        this.scrollView = (GuildNestedScrollView) findViewById4;
        View view3 = this.mRootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view3 = null;
        }
        View findViewById5 = view3.findViewById(R.id.wpw);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "mRootView.findViewById(R\u2026_fragment_container_view)");
        this.mListenWidget = (ListenWidget) findViewById5;
        View view4 = this.mRootView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view4 = null;
        }
        View findViewById6 = view4.findViewById(R.id.f2106000);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "mRootView.findViewById(R.id.operation_banner)");
        this.mOperationBanner = (GuildOperationBanner) findViewById6;
        ListenWidget listenWidget2 = this.mListenWidget;
        if (listenWidget2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListenWidget");
        } else {
            listenWidget = listenWidget2;
        }
        this.mListenPresenter = new ListenWidgetPresenter(listenWidget, this);
        initLiuHaiUtil();
        Bj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void jj(bb event) {
        if (this.mThirdAppInputLayout == null) {
            View view = this.mRootView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                view = null;
            }
            View inflate = ((ViewStub) view.findViewById(R.id.wql)).inflate();
            Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type com.tencent.mobileqq.guild.media.widget.GuildMediaThirdAppInputLayout");
            this.mThirdAppInputLayout = (GuildMediaThirdAppInputLayout) inflate;
        }
        GuildMediaThirdAppInputLayout guildMediaThirdAppInputLayout = this.mThirdAppInputLayout;
        if (guildMediaThirdAppInputLayout != null) {
            guildMediaThirdAppInputLayout.n(event.getHintText(), event.getActionText(), event.getCooperation.qzone.QZoneShareManager.QZONE_SHARE_VIDEO_TEXT java.lang.String(), new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.media.GuildMediaChannelFragment$onThirdAppShowInputEvent$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    GuildMediaChannelViewModel guildMediaChannelViewModel;
                    View view2;
                    View view3;
                    Logger.f235387a.d().d("QGMC.GuildMediaChannelFragment", 1, "onShowThirdAppInput callback " + z16);
                    guildMediaChannelViewModel = GuildMediaChannelFragment.this.mChannelViewModel;
                    View view4 = null;
                    if (guildMediaChannelViewModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
                        guildMediaChannelViewModel = null;
                    }
                    if (Intrinsics.areEqual(guildMediaChannelViewModel.a2().getValue(), Boolean.FALSE)) {
                        int i3 = z16 ? 4 : 0;
                        view2 = GuildMediaChannelFragment.this.mAioContainerView;
                        if (view2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mAioContainerView");
                            view2 = null;
                        }
                        if (view2.getVisibility() != i3) {
                            view3 = GuildMediaChannelFragment.this.mAioContainerView;
                            if (view3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mAioContainerView");
                            } else {
                                view4 = view3;
                            }
                            view4.setVisibility(i3);
                        }
                    }
                }
            });
        }
    }

    private final IGuildMainFrameApi ki() {
        return (IGuildMainFrameApi) this.mainFrameApi.getValue();
    }

    private final void kj() {
        if (GuildToggles.c()) {
            QLog.i("QGMC.GuildMediaChannelFragment", 1, "preload container disabled");
        } else {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.media.p
                @Override // java.lang.Runnable
                public final void run() {
                    GuildMediaChannelFragment.lj(GuildMediaChannelFragment.this);
                }
            }, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void lj(GuildMediaChannelFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.mobileqq.guild.media.core.p.f228716a.c() || this$0.hasDestroyed) {
            return;
        }
        QLog.i("QGMC.GuildMediaChannelFragment", 1, "preload container");
        MediaChannelMiniContainerUtil.b(new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.media.GuildMediaChannelFragment$prepareMiniContainerWhenIdle$1$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ((IMiniContainer) QRoute.api(IMiniContainer.class)).prepare();
            }
        });
    }

    private final void mj(HashMap<String, Object> pageParams) {
        GuildAppReportSourceInfo guildAppReportSourceInfo;
        if (getActivity() != null && (guildAppReportSourceInfo = (GuildAppReportSourceInfo) requireActivity().getIntent().getParcelableExtra("GuildAppReportSourceInfo")) != null) {
            ci(guildAppReportSourceInfo, pageParams);
            requireActivity().getIntent().removeExtra("GuildAppReportSourceInfo");
        }
    }

    private final void ni(boolean isToLand) {
        if (isToLand) {
            qj();
            vj();
        }
    }

    private final void nj(boolean toVisibleWhenPortrait) {
        boolean z16;
        boolean Mi = Mi();
        if (toVisibleWhenPortrait && Mi) {
            QLog.w("QGMC.GuildMediaChannelFragment", 1, "[setCustomLayoutVisibility] failed. never set visible in portrait view");
        }
        if (toVisibleWhenPortrait && !Mi) {
            z16 = true;
        } else {
            z16 = false;
        }
        FrameLayout frameLayout = null;
        if (z16) {
            FrameLayout frameLayout2 = this.mCustomLayout;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCustomLayout");
            } else {
                frameLayout = frameLayout2;
            }
            frameLayout.setVisibility(0);
            return;
        }
        FrameLayout frameLayout3 = this.mCustomLayout;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCustomLayout");
        } else {
            frameLayout = frameLayout3;
        }
        frameLayout.setVisibility(8);
    }

    private final void oi(boolean isToLand) {
        if (!isToLand) {
            rj();
        }
    }

    private final void oj() {
        VideoReport.addToDetectionWhitelist(getActivity());
        View view = this.mRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        VideoReport.setPageId(view, "pg_sgrp_avchannel_aio");
        pj();
    }

    private final void pi() {
        rj();
    }

    private final void pj() {
        HashMap<String, Object> hashMap = new HashMap<>();
        GuildMediaChannelViewModel guildMediaChannelViewModel = this.mChannelViewModel;
        View view = null;
        if (guildMediaChannelViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
            guildMediaChannelViewModel = null;
        }
        String guildID = guildMediaChannelViewModel.getGuildInfo().getGuildID();
        Intrinsics.checkNotNullExpressionValue(guildID, "mChannelViewModel.guildInfo.guildID");
        hashMap.put("sgrp_channel_id", guildID);
        GuildMediaChannelViewModel guildMediaChannelViewModel2 = this.mChannelViewModel;
        if (guildMediaChannelViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
            guildMediaChannelViewModel2 = null;
        }
        IGProChannelInfo channelInfo = guildMediaChannelViewModel2.getChannelInfo();
        String channelUin = channelInfo.getChannelUin();
        Intrinsics.checkNotNullExpressionValue(channelUin, "channelInfo.channelUin");
        hashMap.put("sgrp_sub_channel_id", channelUin);
        String channelName = channelInfo.getChannelName();
        Intrinsics.checkNotNullExpressionValue(channelName, "channelInfo.channelName");
        hashMap.put("sgrp_sub_channel_name", channelName);
        GuildMediaChannelViewModel guildMediaChannelViewModel3 = this.mChannelViewModel;
        if (guildMediaChannelViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
            guildMediaChannelViewModel3 = null;
        }
        hashMap.put("sgrp_user_type", Integer.valueOf(com.tencent.mobileqq.guild.data.v.c(guildMediaChannelViewModel3.getGuildInfo().getGuildID())));
        hashMap.put("sgrp_sub_channel_capacity", Integer.valueOf(channelInfo.getChannelMemberMax()));
        z zVar = z.f230084a;
        GuildMediaChannelViewModel guildMediaChannelViewModel4 = this.mChannelViewModel;
        if (guildMediaChannelViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
            guildMediaChannelViewModel4 = null;
        }
        String guildID2 = guildMediaChannelViewModel4.getGuildInfo().getGuildID();
        Intrinsics.checkNotNullExpressionValue(guildID2, "mChannelViewModel.guildInfo.guildID");
        GuildMediaChannelViewModel guildMediaChannelViewModel5 = this.mChannelViewModel;
        if (guildMediaChannelViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
            guildMediaChannelViewModel5 = null;
        }
        String channelUin2 = guildMediaChannelViewModel5.getChannelInfo().getChannelUin();
        Intrinsics.checkNotNullExpressionValue(channelUin2, "mChannelViewModel.channelInfo.channelUin");
        hashMap.put("sgrp_avchannel_enter_playmodule", Integer.valueOf(zVar.d(guildID2, channelUin2)));
        hashMap.put("sgrp_subchannel_visible_set", Integer.valueOf(channelInfo.getVisibleType()));
        GuildMediaChannelViewModel guildMediaChannelViewModel6 = this.mChannelViewModel;
        if (guildMediaChannelViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
            guildMediaChannelViewModel6 = null;
        }
        hashMap.put("sgrp_subchannel_speak_set", Integer.valueOf(zVar.f(guildMediaChannelViewModel6.getChannelInfo())));
        GuildMediaChannelViewModel guildMediaChannelViewModel7 = this.mChannelViewModel;
        if (guildMediaChannelViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
            guildMediaChannelViewModel7 = null;
        }
        hashMap.put("sgrp_avchannel_play_set", Integer.valueOf(zVar.g(guildMediaChannelViewModel7.getChannelInfo())));
        hashMap.put("sgrp_avchannel_condition", zVar.c(this.mContentView instanceof GuildMediaLandVideoView));
        hashMap.put("sgrp_stream_pgin_source", Integer.valueOf(o02.b.a()));
        ArrayList<IGProTopMsg> topMsgList = channelInfo.getTopMsgList();
        Intrinsics.checkNotNullExpressionValue(topMsgList, "channelInfo.topMsgList");
        int i3 = 1;
        hashMap.put("sgrp_announcement_state", Integer.valueOf(!topMsgList.isEmpty() ? 1 : 0));
        hashMap.put("sgrp_sub_channel_type", Integer.valueOf(channelInfo.getType()));
        hashMap.put("sgrp_subchannel_session_id", com.tencent.mobileqq.guild.media.core.j.c().L());
        hashMap.put("sgrp_invite_unmute_state", Integer.valueOf(zVar.a(channelInfo)));
        if (com.tencent.mobileqq.guild.media.core.j.c().I() == null) {
            i3 = 0;
        }
        hashMap.put("sgrp_aio_musicplayer", Integer.valueOf(i3));
        hashMap.put(JumpGuildParam.EXTRA_KEY_TRACE_ID, zVar.b(JumpGuildParam.EXTRA_KEY_TRACE_ID));
        hashMap.put("sgrp_stream_pgin_source_name", zVar.b("sgrp_stream_pgin_source_name"));
        hashMap.put("sgrp_stream_pgin_into_source", zVar.b("sgrp_stream_pgin_into_source"));
        hashMap.put("sgrp_pgin_source_mode", zVar.b("sgrp_pgin_source_mode"));
        hashMap.put("sgrp_stream_entrance_pgin_source", zVar.b("sgrp_stream_entrance_pgin_source"));
        hashMap.put("sgrp_channel_changetab_state", zVar.b("sgrp_channel_changetab_state"));
        hashMap.put("sgrp_channel_invite_code", zVar.b("sgrp_channel_invite_code"));
        hashMap.put("sgrp_subchannel_speakmode_set", Integer.valueOf(zVar.e()));
        hashMap.put("sgrp_speakmode_time", Integer.valueOf(channelInfo.getVoiceSpeakModeCfg().getSpeakSecond()));
        mj(hashMap);
        hashMap.putAll(com.tencent.mobileqq.guild.report.b.d());
        View view2 = this.mRootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        } else {
            view = view2;
        }
        VideoReport.setPageParams(view, new PageParams(hashMap));
        com.tencent.mobileqq.guild.media.core.j.a().f0().P(hashMap);
    }

    private final void qi() {
        qj();
        wj();
    }

    private final void qj() {
        GuildMediaChannelFragmentTitleBar guildMediaChannelFragmentTitleBar = this.mTitleBar;
        ListenWidget listenWidget = null;
        if (guildMediaChannelFragmentTitleBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
            guildMediaChannelFragmentTitleBar = null;
        }
        guildMediaChannelFragmentTitleBar.setVisibility(8);
        GuildMediaChannelFragmentBottomBar guildMediaChannelFragmentBottomBar = this.mBottomBar;
        if (guildMediaChannelFragmentBottomBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomBar");
            guildMediaChannelFragmentBottomBar = null;
        }
        guildMediaChannelFragmentBottomBar.setVisibility(8);
        nj(false);
        View view = this.mAioContainerView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAioContainerView");
            view = null;
        }
        view.setVisibility(8);
        ListenWidget listenWidget2 = this.mListenWidget;
        if (listenWidget2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListenWidget");
        } else {
            listenWidget = listenWidget2;
        }
        listenWidget.setVisibility(8);
        Dj(true);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setRequestedOrientation(0);
        }
        com.tencent.mobileqq.guild.media.core.j.a().M0().Q0(false);
    }

    private final void ri() {
        GuildMediaChannelViewModel guildMediaChannelViewModel = this.mChannelViewModel;
        GuildMediaAioViewModel guildMediaAioViewModel = null;
        if (guildMediaChannelViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
            guildMediaChannelViewModel = null;
        }
        MutableLiveData<com.tencent.mobileqq.guild.media.core.notify.b> L1 = guildMediaChannelViewModel.L1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<com.tencent.mobileqq.guild.media.core.notify.b, Unit> function1 = new Function1<com.tencent.mobileqq.guild.media.core.notify.b, Unit>() { // from class: com.tencent.mobileqq.guild.media.GuildMediaChannelFragment$initDataObserver$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.guild.media.core.notify.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.guild.media.core.notify.b it) {
                GuildMediaChannelFragment guildMediaChannelFragment = GuildMediaChannelFragment.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                guildMediaChannelFragment.Qi(it);
            }
        };
        L1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.media.t
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildMediaChannelFragment.Di(Function1.this, obj);
            }
        });
        GuildMediaChannelViewModel guildMediaChannelViewModel2 = this.mChannelViewModel;
        if (guildMediaChannelViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
            guildMediaChannelViewModel2 = null;
        }
        MutableLiveData<SwitchThemeEvent> U1 = guildMediaChannelViewModel2.U1();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<SwitchThemeEvent, Unit> function12 = new Function1<SwitchThemeEvent, Unit>() { // from class: com.tencent.mobileqq.guild.media.GuildMediaChannelFragment$initDataObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SwitchThemeEvent switchThemeEvent) {
                invoke2(switchThemeEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SwitchThemeEvent it) {
                GuildMediaChannelFragment guildMediaChannelFragment = GuildMediaChannelFragment.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                guildMediaChannelFragment.fj(it);
            }
        };
        U1.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.guild.media.w
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildMediaChannelFragment.si(Function1.this, obj);
            }
        });
        GuildMediaChannelViewModel guildMediaChannelViewModel3 = this.mChannelViewModel;
        if (guildMediaChannelViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
            guildMediaChannelViewModel3 = null;
        }
        MutableLiveData<com.tencent.mobileqq.guild.media.core.notify.u> N1 = guildMediaChannelViewModel3.N1();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        final Function1<com.tencent.mobileqq.guild.media.core.notify.u, Unit> function13 = new Function1<com.tencent.mobileqq.guild.media.core.notify.u, Unit>() { // from class: com.tencent.mobileqq.guild.media.GuildMediaChannelFragment$initDataObserver$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.guild.media.core.notify.u uVar) {
                invoke2(uVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.guild.media.core.notify.u it) {
                GuildMediaChannelFragment guildMediaChannelFragment = GuildMediaChannelFragment.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                guildMediaChannelFragment.Vi(it);
            }
        };
        N1.observe(viewLifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.guild.media.x
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildMediaChannelFragment.ti(Function1.this, obj);
            }
        });
        GuildMediaChannelViewModel guildMediaChannelViewModel4 = this.mChannelViewModel;
        if (guildMediaChannelViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
            guildMediaChannelViewModel4 = null;
        }
        MutableLiveData<com.tencent.mobileqq.guild.media.core.notify.v> O1 = guildMediaChannelViewModel4.O1();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        final Function1<com.tencent.mobileqq.guild.media.core.notify.v, Unit> function14 = new Function1<com.tencent.mobileqq.guild.media.core.notify.v, Unit>() { // from class: com.tencent.mobileqq.guild.media.GuildMediaChannelFragment$initDataObserver$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.guild.media.core.notify.v vVar) {
                invoke2(vVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.guild.media.core.notify.v it) {
                GuildMediaChannelFragment guildMediaChannelFragment = GuildMediaChannelFragment.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                guildMediaChannelFragment.Wi(it);
            }
        };
        O1.observe(viewLifecycleOwner4, new Observer() { // from class: com.tencent.mobileqq.guild.media.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildMediaChannelFragment.ui(Function1.this, obj);
            }
        });
        GuildMediaChannelViewModel guildMediaChannelViewModel5 = this.mChannelViewModel;
        if (guildMediaChannelViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
            guildMediaChannelViewModel5 = null;
        }
        MutableLiveData<bb> Z1 = guildMediaChannelViewModel5.Z1();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        final Function1<bb, Unit> function15 = new Function1<bb, Unit>() { // from class: com.tencent.mobileqq.guild.media.GuildMediaChannelFragment$initDataObserver$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(bb bbVar) {
                invoke2(bbVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(bb it) {
                GuildMediaChannelFragment guildMediaChannelFragment = GuildMediaChannelFragment.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                guildMediaChannelFragment.jj(it);
            }
        };
        Z1.observe(viewLifecycleOwner5, new Observer() { // from class: com.tencent.mobileqq.guild.media.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildMediaChannelFragment.vi(Function1.this, obj);
            }
        });
        GuildMediaChannelViewModel guildMediaChannelViewModel6 = this.mChannelViewModel;
        if (guildMediaChannelViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
            guildMediaChannelViewModel6 = null;
        }
        MutableLiveData<ThirdAppBarClickEvent> W1 = guildMediaChannelViewModel6.W1();
        LifecycleOwner viewLifecycleOwner6 = getViewLifecycleOwner();
        final Function1<ThirdAppBarClickEvent, Unit> function16 = new Function1<ThirdAppBarClickEvent, Unit>() { // from class: com.tencent.mobileqq.guild.media.GuildMediaChannelFragment$initDataObserver$6
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ThirdAppBarClickEvent thirdAppBarClickEvent) {
                invoke2(thirdAppBarClickEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ThirdAppBarClickEvent it) {
                GuildMediaChannelFragment guildMediaChannelFragment = GuildMediaChannelFragment.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                guildMediaChannelFragment.ij(it);
            }
        };
        W1.observe(viewLifecycleOwner6, new Observer() { // from class: com.tencent.mobileqq.guild.media.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildMediaChannelFragment.wi(Function1.this, obj);
            }
        });
        GuildMediaChannelViewModel guildMediaChannelViewModel7 = this.mChannelViewModel;
        if (guildMediaChannelViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
            guildMediaChannelViewModel7 = null;
        }
        LiveData<EnterChannelState> M1 = guildMediaChannelViewModel7.M1();
        LifecycleOwner viewLifecycleOwner7 = getViewLifecycleOwner();
        final Function1<EnterChannelState, Unit> function17 = new Function1<EnterChannelState, Unit>() { // from class: com.tencent.mobileqq.guild.media.GuildMediaChannelFragment$initDataObserver$7
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EnterChannelState enterChannelState) {
                invoke2(enterChannelState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(EnterChannelState enterChannelState) {
                GuildMediaChannelFragment guildMediaChannelFragment = GuildMediaChannelFragment.this;
                Intrinsics.checkNotNullExpressionValue(enterChannelState, "enterChannelState");
                guildMediaChannelFragment.Si(enterChannelState);
            }
        };
        M1.observe(viewLifecycleOwner7, new Observer() { // from class: com.tencent.mobileqq.guild.media.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildMediaChannelFragment.xi(Function1.this, obj);
            }
        });
        GuildMediaChannelViewModel guildMediaChannelViewModel8 = this.mChannelViewModel;
        if (guildMediaChannelViewModel8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
            guildMediaChannelViewModel8 = null;
        }
        MutableLiveData<Boolean> a26 = guildMediaChannelViewModel8.a2();
        LifecycleOwner viewLifecycleOwner8 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function18 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.media.GuildMediaChannelFragment$initDataObserver$8
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
            public final void invoke2(Boolean toLand) {
                GuildMediaChannelFragment guildMediaChannelFragment = GuildMediaChannelFragment.this;
                Intrinsics.checkNotNullExpressionValue(toLand, "toLand");
                guildMediaChannelFragment.aj(toLand.booleanValue());
            }
        };
        a26.observe(viewLifecycleOwner8, new Observer() { // from class: com.tencent.mobileqq.guild.media.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildMediaChannelFragment.yi(Function1.this, obj);
            }
        });
        GuildMediaChannelViewModel guildMediaChannelViewModel9 = this.mChannelViewModel;
        if (guildMediaChannelViewModel9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
            guildMediaChannelViewModel9 = null;
        }
        MutableLiveData<Boolean> c26 = guildMediaChannelViewModel9.c2();
        LifecycleOwner viewLifecycleOwner9 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function19 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.media.GuildMediaChannelFragment$initDataObserver$9
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
                GuildMediaChannelFragment guildMediaChannelFragment = GuildMediaChannelFragment.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                guildMediaChannelFragment.Yi(it.booleanValue());
            }
        };
        c26.observe(viewLifecycleOwner9, new Observer() { // from class: com.tencent.mobileqq.guild.media.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildMediaChannelFragment.zi(Function1.this, obj);
            }
        });
        GuildMediaChannelViewModel guildMediaChannelViewModel10 = this.mChannelViewModel;
        if (guildMediaChannelViewModel10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
            guildMediaChannelViewModel10 = null;
        }
        MutableLiveData<Boolean> Q1 = guildMediaChannelViewModel10.Q1();
        LifecycleOwner viewLifecycleOwner10 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function110 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.media.GuildMediaChannelFragment$initDataObserver$10
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
                GuildMediaChannelFragment guildMediaChannelFragment = GuildMediaChannelFragment.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                guildMediaChannelFragment.Zi(it.booleanValue());
            }
        };
        Q1.observe(viewLifecycleOwner10, new Observer() { // from class: com.tencent.mobileqq.guild.media.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildMediaChannelFragment.Ai(Function1.this, obj);
            }
        });
        GuildMediaChannelViewModel guildMediaChannelViewModel11 = this.mChannelViewModel;
        if (guildMediaChannelViewModel11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
            guildMediaChannelViewModel11 = null;
        }
        guildMediaChannelViewModel11.P1().observeForever(this.mExitPageObserver);
        GuildMediaChannelViewModel guildMediaChannelViewModel12 = this.mChannelViewModel;
        if (guildMediaChannelViewModel12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
            guildMediaChannelViewModel12 = null;
        }
        MutableLiveData<com.tencent.mobileqq.guild.media.core.notify.n> f26 = guildMediaChannelViewModel12.f2();
        LifecycleOwner viewLifecycleOwner11 = getViewLifecycleOwner();
        final Function1<com.tencent.mobileqq.guild.media.core.notify.n, Unit> function111 = new Function1<com.tencent.mobileqq.guild.media.core.notify.n, Unit>() { // from class: com.tencent.mobileqq.guild.media.GuildMediaChannelFragment$initDataObserver$11
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.guild.media.core.notify.n nVar) {
                invoke2(nVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.guild.media.core.notify.n it) {
                GuildMediaChannelFragment guildMediaChannelFragment = GuildMediaChannelFragment.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                guildMediaChannelFragment.Ui(it);
            }
        };
        f26.observe(viewLifecycleOwner11, new Observer() { // from class: com.tencent.mobileqq.guild.media.u
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildMediaChannelFragment.Bi(Function1.this, obj);
            }
        });
        GuildMediaAioViewModel guildMediaAioViewModel2 = this.aioViewModel;
        if (guildMediaAioViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioViewModel");
        } else {
            guildMediaAioViewModel = guildMediaAioViewModel2;
        }
        LiveData<Boolean> T1 = guildMediaAioViewModel.T1();
        LifecycleOwner viewLifecycleOwner12 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function112 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.media.GuildMediaChannelFragment$initDataObserver$12
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
            public final void invoke2(Boolean bool) {
                GuildMediaChannelFragment.this.Cj();
            }
        };
        T1.observe(viewLifecycleOwner12, new Observer() { // from class: com.tencent.mobileqq.guild.media.v
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildMediaChannelFragment.Ci(Function1.this, obj);
            }
        });
    }

    private final void rj() {
        GuildMediaChannelFragmentTitleBar guildMediaChannelFragmentTitleBar = this.mTitleBar;
        if (guildMediaChannelFragmentTitleBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
            guildMediaChannelFragmentTitleBar = null;
        }
        guildMediaChannelFragmentTitleBar.setVisibility(0);
        GuildMediaChannelFragmentBottomBar guildMediaChannelFragmentBottomBar = this.mBottomBar;
        if (guildMediaChannelFragmentBottomBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomBar");
            guildMediaChannelFragmentBottomBar = null;
        }
        guildMediaChannelFragmentBottomBar.setVisibility(0);
        di();
        View view = this.mAioContainerView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAioContainerView");
            view = null;
        }
        view.setVisibility(0);
        Ej();
        Dj(false);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setRequestedOrientation(-1);
        }
        yj(this, com.tencent.mobileqq.guild.media.core.m.n(com.tencent.mobileqq.guild.media.core.j.c()), null, 2, null);
        com.tencent.mobileqq.guild.media.core.j.a().M0().Q0(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0041, code lost:
    
        if (1 == r3.orientation) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0074, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r3.b2().getValue(), r4) == false) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setOperationBannerVisibility() {
        int i3;
        boolean z16;
        Resources resources;
        GuildOperationBanner guildOperationBanner = this.mOperationBanner;
        GuildOperationBanner guildOperationBanner2 = null;
        if (guildOperationBanner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOperationBanner");
            guildOperationBanner = null;
        }
        int visibility = guildOperationBanner.getVisibility();
        GuildMediaAioViewModel guildMediaAioViewModel = this.aioViewModel;
        if (guildMediaAioViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioViewModel");
            guildMediaAioViewModel = null;
        }
        Boolean value = guildMediaAioViewModel.T1().getValue();
        Boolean bool = Boolean.TRUE;
        if (Intrinsics.areEqual(value, bool)) {
            FragmentActivity activity = getActivity();
            i3 = 0;
            if (activity != null && (resources = activity.getResources()) != null && (r3 = resources.getConfiguration()) != null) {
                z16 = true;
            }
            z16 = false;
            if (z16) {
                GuildMediaChannelViewModel guildMediaChannelViewModel = this.mChannelViewModel;
                if (guildMediaChannelViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
                    guildMediaChannelViewModel = null;
                }
                if (!Intrinsics.areEqual(guildMediaChannelViewModel.a2().getValue(), bool)) {
                    GuildMediaChannelViewModel guildMediaChannelViewModel2 = this.mChannelViewModel;
                    if (guildMediaChannelViewModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
                        guildMediaChannelViewModel2 = null;
                    }
                }
            }
        }
        i3 = 8;
        GuildOperationBanner guildOperationBanner3 = this.mOperationBanner;
        if (guildOperationBanner3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOperationBanner");
            guildOperationBanner3 = null;
        }
        guildOperationBanner3.setVisibility(i3);
        if (visibility != i3 && i3 == 0) {
            GuildOperationBanner guildOperationBanner4 = this.mOperationBanner;
            if (guildOperationBanner4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOperationBanner");
                guildOperationBanner4 = null;
            }
            guildOperationBanner4.setAlpha(0.0f);
            GuildOperationBanner guildOperationBanner5 = this.mOperationBanner;
            if (guildOperationBanner5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOperationBanner");
            } else {
                guildOperationBanner2 = guildOperationBanner5;
            }
            guildOperationBanner2.animate().alpha(1.0f).setDuration(100L).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void si(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void sj() {
        GuildMediaChannelViewModel guildMediaChannelViewModel = this.mChannelViewModel;
        GuildMediaChannelViewModel guildMediaChannelViewModel2 = null;
        if (guildMediaChannelViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
            guildMediaChannelViewModel = null;
        }
        IGProGuildInfo guildInfo = guildMediaChannelViewModel.getGuildInfo();
        GuildMediaChannelViewModel guildMediaChannelViewModel3 = this.mChannelViewModel;
        if (guildMediaChannelViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
        } else {
            guildMediaChannelViewModel2 = guildMediaChannelViewModel3;
        }
        GuildFloatWindowUtils.F(guildInfo, guildMediaChannelViewModel2.getChannelInfo(), com.tencent.mobileqq.guild.media.core.m.n(com.tencent.mobileqq.guild.media.core.j.c()), true, 0, 16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ti(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void tj() {
        if (!Pi()) {
            QLog.i("QGMC.GuildMediaChannelFragment", 1, "[startLoading] ignored. call stopLoading instead");
            uj();
            return;
        }
        if (this.mLoadingSkeletonView == null) {
            View view = this.mRootView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                view = null;
            }
            View inflate = ((ViewStub) view.findViewById(R.id.yt6)).inflate();
            Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type com.tencent.mobileqq.guild.media.content.loading.GuildMediaLoadingSkeletonContent");
            this.mLoadingSkeletonView = (GuildMediaLoadingSkeletonContent) inflate;
        }
        GuildMediaLoadingSkeletonContent guildMediaLoadingSkeletonContent = this.mLoadingSkeletonView;
        if (guildMediaLoadingSkeletonContent != null) {
            guildMediaLoadingSkeletonContent.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ui(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void uj() {
        GuildMediaLoadingSkeletonContent guildMediaLoadingSkeletonContent = this.mLoadingSkeletonView;
        if (guildMediaLoadingSkeletonContent != null) {
            guildMediaLoadingSkeletonContent.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void vj() {
        QLog.i("QGMC.GuildMediaChannelFragment", 1, "[switchLandVideoContent] ");
        Aj(this, new GuildMediaLandVideoView(), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void wj() {
        Aj(this, new GuildMediaThirdAppLandContent(), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void xj(int topicType, SwitchThemeEvent event) {
        QLog.i("QGMC.GuildMediaChannelFragment", 1, "[switchTopicContent] " + topicType);
        if (topicType == 0) {
            return;
        }
        zj(y.INSTANCE.a(topicType), event);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    static /* synthetic */ void yj(GuildMediaChannelFragment guildMediaChannelFragment, int i3, SwitchThemeEvent switchThemeEvent, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            switchThemeEvent = null;
        }
        guildMediaChannelFragment.xj(i3, switchThemeEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void zj(GuildMediaContentFragmentBase contentFragment, SwitchThemeEvent event) {
        String str;
        if (event == null) {
            str = "event is null";
        } else {
            str = event.getOldThemeType() + " to " + event.getNewThemeType();
        }
        QLog.i("QGMC.GuildMediaChannelFragment", 1, "[switchView] " + str);
        if (isAdded() && getActivity() != null) {
            FragmentActivity activity = getActivity();
            boolean z16 = false;
            if (activity != null && activity.isFinishing()) {
                z16 = true;
            }
            if (!z16) {
                if (this.mContentView != null) {
                    String name = contentFragment.getClass().getName();
                    Object obj = this.mContentView;
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
                    if (Intrinsics.areEqual(name, ((Fragment) obj).getClass().getName())) {
                        Logger.f235387a.d().i("QGMC.GuildMediaChannelFragment", 1, "same Type Fragment");
                        return;
                    }
                }
                FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
                Intrinsics.checkNotNullExpressionValue(beginTransaction, "childFragmentManager.beginTransaction()");
                bi(beginTransaction, event);
                GuildMediaChannelViewModel guildMediaChannelViewModel = this.mChannelViewModel;
                com.tencent.mobileqq.guild.media.viewmodel.b bVar = null;
                if (guildMediaChannelViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
                    guildMediaChannelViewModel = null;
                }
                contentFragment.sh(guildMediaChannelViewModel);
                com.tencent.mobileqq.guild.media.viewmodel.b bVar2 = this.mMicStateViewModel;
                if (bVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMicStateViewModel");
                } else {
                    bVar = bVar2;
                }
                contentFragment.vh(bVar);
                beginTransaction.replace(R.id.f164797tw3, contentFragment);
                this.mContentView = contentFragment;
                beginTransaction.commitAllowingStateLoss();
                return;
            }
        }
        QLog.w("QGMC.GuildMediaChannelFragment", 1, "[switchView] is not added or activity is null");
    }

    public final void Ji() {
        String stackTraceToString;
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            Logger.a d16 = logger.d();
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(new Exception());
            d16.d("QGMC.GuildMediaChannelFragment", 2, "requestFloatWindowPermissionTrace: " + stackTraceToString);
        }
        GuildMediaChannelViewModel guildMediaChannelViewModel = this.mChannelViewModel;
        if (guildMediaChannelViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
            guildMediaChannelViewModel = null;
        }
        if (Intrinsics.areEqual(guildMediaChannelViewModel.getStartFrom(), "functional_qq_little_world_feed")) {
            QLog.d("QGMC.GuildMediaChannelFragment", 1, "requestFloatWindowPermission from q-circle dont need float window");
            Ni();
        } else {
            MediaChannelUtils.f228046a.H(new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.media.GuildMediaChannelFragment$invokeShowFloatWindow$2
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
                    GuildMediaChannelFragment.this.cj();
                }
            }, new Function1<String, Unit>() { // from class: com.tencent.mobileqq.guild.media.GuildMediaChannelFragment$invokeShowFloatWindow$3
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
                public final void invoke2(@NotNull String errMsg) {
                    Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                    GuildMediaChannelFragment.this.bj(errMsg);
                }
            }, "QGMC.GuildMediaChannelFragment", getActivity(), this.mFloatWindowPermissionHandler);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void beforeFinish() {
        super.beforeFinish();
        View view = this.mRootView;
        if (view != null) {
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                view = null;
            }
            view.setBackground(null);
        }
        if (!Ki()) {
            ViewPoolEngine.f228744a.p();
        }
    }

    @NotNull
    public final GuildMediaAioViewModel fi() {
        GuildMediaAioViewModel guildMediaAioViewModel = this.aioViewModel;
        if (guildMediaAioViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioViewModel");
            return null;
        }
        return guildMediaAioViewModel;
    }

    @NotNull
    public final View getRootView() {
        View view = this.mRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            return null;
        }
        return view;
    }

    @NotNull
    public final GuildMediaChannelFragmentBottomBar gi() {
        GuildMediaChannelFragmentBottomBar guildMediaChannelFragmentBottomBar = this.mBottomBar;
        if (guildMediaChannelFragmentBottomBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomBar");
            return null;
        }
        return guildMediaChannelFragmentBottomBar;
    }

    @NotNull
    public final GuildMediaChannelViewModel hi() {
        GuildMediaChannelViewModel guildMediaChannelViewModel = this.mChannelViewModel;
        if (guildMediaChannelViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
            return null;
        }
        return guildMediaChannelViewModel;
    }

    @Nullable
    /* renamed from: ii, reason: from getter */
    public final com.tencent.mobileqq.guild.media.content.i getMContentView() {
        return this.mContentView;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(@Nullable final Activity activity) {
        if (activity == null) {
            return;
        }
        if (!Pi()) {
            activity.overridePendingTransition(R.anim.f154588nw, R.anim.f154589nx);
        } else if (activity.getIntent().getBooleanExtra("jumpGuildFromLoadingPage", false)) {
            activity.overridePendingTransition(0, R.anim.f154442w);
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.media.d
                @Override // java.lang.Runnable
                public final void run() {
                    GuildMediaChannelFragment.Ii(activity);
                }
            }, 500L);
        } else {
            activity.overridePendingTransition(R.anim.f155071vn, R.anim.f155066i1);
        }
    }

    @NotNull
    public final IGuildMainFrameApi ji() {
        IGuildMainFrameApi mainFrameApi = ki();
        Intrinsics.checkNotNullExpressionValue(mainFrameApi, "mainFrameApi");
        return mainFrameApi;
    }

    @Nullable
    /* renamed from: li, reason: from getter */
    public final GuildMediaRoomMsgGuideController getMMsgGuideController() {
        return this.mMsgGuideController;
    }

    @NotNull
    public final GuildMediaChannelFragmentTitleBar mi() {
        GuildMediaChannelFragmentTitleBar guildMediaChannelFragmentTitleBar = this.mTitleBar;
        if (guildMediaChannelFragmentTitleBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
            return null;
        }
        return guildMediaChannelFragmentTitleBar;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        com.tencent.mobileqq.guild.media.core.j.a().F0().B(requestCode, resultCode, data);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        com.tencent.mobileqq.guild.media.content.i iVar = this.mContentView;
        boolean z16 = false;
        if (iVar != null && iVar.onBackEvent()) {
            z16 = true;
        }
        if (z16) {
            return true;
        }
        GuildMediaChannelViewModel guildMediaChannelViewModel = this.mChannelViewModel;
        if (guildMediaChannelViewModel == null) {
            return super.onBackEvent();
        }
        GuildMediaAioViewModel guildMediaAioViewModel = null;
        GuildMediaChannelViewModel guildMediaChannelViewModel2 = null;
        if (guildMediaChannelViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
            guildMediaChannelViewModel = null;
        }
        if (Intrinsics.areEqual(guildMediaChannelViewModel.a2().getValue(), Boolean.TRUE)) {
            GuildMediaChannelViewModel guildMediaChannelViewModel3 = this.mChannelViewModel;
            if (guildMediaChannelViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
            } else {
                guildMediaChannelViewModel2 = guildMediaChannelViewModel3;
            }
            guildMediaChannelViewModel2.a2().postValue(Boolean.FALSE);
            return true;
        }
        GuildMediaChannelViewModel guildMediaChannelViewModel4 = this.mChannelViewModel;
        if (guildMediaChannelViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
            guildMediaChannelViewModel4 = null;
        }
        if (Intrinsics.areEqual(guildMediaChannelViewModel4.getStartFrom(), "functional_qq_little_world_feed")) {
            QLog.d("QGMC.GuildMediaChannelFragment", 1, "onBackEvent from q-circle dont need float window");
            return super.onBackEvent();
        }
        GuildMediaAioViewModel guildMediaAioViewModel2 = this.aioViewModel;
        if (guildMediaAioViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioViewModel");
        } else {
            guildMediaAioViewModel = guildMediaAioViewModel2;
        }
        if (guildMediaAioViewModel.k2()) {
            return true;
        }
        if (com.tencent.mobileqq.guild.media.core.m.h(com.tencent.mobileqq.guild.media.core.j.c())) {
            Ji();
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        Bj();
        InputMethodUtil.hide(getActivity());
        com.tencent.mobileqq.guild.media.core.j.d().i(new ad(2));
        Fj(newConfig.orientation);
        ki().notifyGuildFrameVisibleChanged("media onConfigurationChanged", QQGuildUIUtil.x(getContext()));
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        QLog.d("QGMC.GuildMediaChannelFragment", 1, "onCreateView");
        if (AppSetting.t(requireContext())) {
            ((IGuildStandalonePageOpenApi) QRoute.api(IGuildStandalonePageOpenApi.class)).setGuildChatFragmentShow();
        }
        View inflate = inflater.inflate(R.layout.f168131ez3, container, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026ask_bg, container, false)");
        this.mRootView = inflate;
        ImmersiveUtils.setStatusTextColor(false, requireActivity().getWindow());
        com.tencent.mobileqq.guild.media.presenter.g gVar = com.tencent.mobileqq.guild.media.presenter.g.f229131d;
        gVar.a();
        GuildMediaAioViewModel.Companion companion = GuildMediaAioViewModel.INSTANCE;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        this.aioViewModel = companion.a(requireActivity);
        ViewModel viewModel = com.tencent.mobileqq.mvvm.h.a(gVar).get(GuildMediaChannelViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ofViewModelProvider(Guil\u2026nelViewModel::class.java)");
        this.mChannelViewModel = (GuildMediaChannelViewModel) viewModel;
        ViewModel viewModel2 = new ViewModelProvider(this).get(com.tencent.mobileqq.guild.media.viewmodel.b.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "ViewModelProvider(this).\u2026ateViewModel::class.java)");
        this.mMicStateViewModel = (com.tencent.mobileqq.guild.media.viewmodel.b) viewModel2;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        ImmersivePresenter immersivePresenter = new ImmersivePresenter(requireContext);
        this.immersivePresenter = immersivePresenter;
        immersivePresenter.p(this);
        Gi();
        this.mExitPageTriggered = false;
        View view = this.mRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        String str;
        Boolean bool;
        String str2;
        this.hasDestroyed = true;
        String s16 = com.tencent.mobileqq.guild.media.core.j.c().s();
        Bundle arguments = getArguments();
        String str3 = null;
        if (arguments != null) {
            str = arguments.getString("ARG_KEY");
        } else {
            str = null;
        }
        boolean areEqual = Intrinsics.areEqual(s16, str);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            bool = Boolean.valueOf(activity.isFinishing());
        } else {
            bool = null;
        }
        QLog.i("QGMC.GuildMediaChannelFragment", 1, "onDestroy, isValidKey[" + areEqual + "], isFinishing[" + bool + "]");
        if (areEqual) {
            if (com.tencent.mobileqq.guild.media.core.j.c().l().getValue() != EnterChannelState.ENTER_SUC) {
                com.tencent.mobileqq.guild.media.core.e a16 = com.tencent.mobileqq.guild.media.core.j.a();
                GuildMediaChannelViewModel guildMediaChannelViewModel = this.mChannelViewModel;
                if (guildMediaChannelViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
                    guildMediaChannelViewModel = null;
                }
                String channelUin = guildMediaChannelViewModel.getChannelInfo().getChannelUin();
                Intrinsics.checkNotNullExpressionValue(channelUin, "this.mChannelViewModel.channelInfo.channelUin");
                Bundle arguments2 = getArguments();
                if (arguments2 != null) {
                    str2 = arguments2.getString("ARG_KEY");
                } else {
                    str2 = null;
                }
                a16.R("", "ExitUIWithoutEnterSuccess", channelUin, str2);
            } else if (com.tencent.mobileqq.guild.media.core.j.c().getSelfUserInfo().R) {
                Ji();
            }
            GuildMediaAIOExKt.k();
            com.tencent.mobileqq.guild.media.core.j.a().M0().X0(null);
            com.tencent.mobileqq.guild.media.presenter.g.f229131d.a();
            ((IMiniContainer) QRoute.api(IMiniContainer.class)).reset();
        }
        GLiveChannelCore.f226698a.t().d0(true);
        GuildMediaChannelViewModel guildMediaChannelViewModel2 = this.mChannelViewModel;
        if (guildMediaChannelViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
            guildMediaChannelViewModel2 = null;
        }
        if (Intrinsics.areEqual(guildMediaChannelViewModel2.getStartFrom(), "functional_qq_little_world_feed")) {
            if (com.tencent.mobileqq.guild.media.qcircle.g.b() != 1) {
                com.tencent.mobileqq.guild.media.core.e a17 = com.tencent.mobileqq.guild.media.core.j.a();
                String d16 = com.dataline.util.j.d("\u4ece\u5c0f\u4e16\u754c\u8fdb\u5165\uff0c\u4f46\u662f\u8fd4\u56de\u65f6 \u5df2\u7ecf\u4e0d\u5728\u5c0f\u4e16\u754c\u7684\u97f3\u89c6\u9891\u623f\u95f4\u9875\u9762\u4e86");
                GuildMediaChannelViewModel guildMediaChannelViewModel3 = this.mChannelViewModel;
                if (guildMediaChannelViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
                    guildMediaChannelViewModel3 = null;
                }
                String channelUin2 = guildMediaChannelViewModel3.getChannelInfo().getChannelUin();
                Intrinsics.checkNotNullExpressionValue(channelUin2, "this.mChannelViewModel.channelInfo.channelUin");
                Bundle arguments3 = getArguments();
                if (arguments3 != null) {
                    str3 = arguments3.getString("ARG_KEY");
                }
                a17.R("", d16, channelUin2, str3);
            } else if (!com.tencent.mobileqq.guild.media.core.j.a().K(com.tencent.mobileqq.guild.media.qcircle.g.a())) {
                com.tencent.mobileqq.guild.media.core.e a18 = com.tencent.mobileqq.guild.media.core.j.a();
                String d17 = com.dataline.util.j.d("\u5c0f\u4e16\u754c\u97f3\u89c6\u9891\u9875\u9762\u8fd8\u5728\uff0c\u4ece\u5176\u4ed6\u7684\u97f3\u89c6\u9891\u9875\u9762\u8fd4\u56de");
                GuildMediaChannelViewModel guildMediaChannelViewModel4 = this.mChannelViewModel;
                if (guildMediaChannelViewModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
                    guildMediaChannelViewModel4 = null;
                }
                String channelUin3 = guildMediaChannelViewModel4.getChannelInfo().getChannelUin();
                Intrinsics.checkNotNullExpressionValue(channelUin3, "this.mChannelViewModel.channelInfo.channelUin");
                Bundle arguments4 = getArguments();
                if (arguments4 != null) {
                    str3 = arguments4.getString("ARG_KEY");
                }
                a18.R("", d17, channelUin3, str3);
            }
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && !((IGuildActivityApi) QRoute.api(IGuildActivityApi.class)).isSplashActivity(activity2)) {
            bo.a(activity2);
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        QLog.d("QGMC.GuildMediaChannelFragment", 1, "onDestroyView");
        GuildMediaChannelViewModel guildMediaChannelViewModel = this.mChannelViewModel;
        GuildMediaChannelViewModel guildMediaChannelViewModel2 = null;
        if (guildMediaChannelViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
            guildMediaChannelViewModel = null;
        }
        guildMediaChannelViewModel.P1().removeObserver(this.mExitPageObserver);
        GuildMediaRoomMsgGuideController guildMediaRoomMsgGuideController = this.mMsgGuideController;
        if (guildMediaRoomMsgGuideController != null) {
            guildMediaRoomMsgGuideController.l();
        }
        com.tencent.mobileqq.guild.media.core.logic.ab.f0(com.tencent.mobileqq.guild.media.core.j.a().M0(), 0, 1, null);
        GuildChannelGuestBottomManager guildChannelGuestBottomManager = this.mGuestBottomManager;
        if (guildChannelGuestBottomManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuestBottomManager");
            guildChannelGuestBottomManager = null;
        }
        guildChannelGuestBottomManager.m();
        GuildMediaChannelFragmentTitleBar guildMediaChannelFragmentTitleBar = this.mTitleBar;
        if (guildMediaChannelFragmentTitleBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
            guildMediaChannelFragmentTitleBar = null;
        }
        guildMediaChannelFragmentTitleBar.b();
        GuildMediaChannelFragmentBottomBar guildMediaChannelFragmentBottomBar = this.mBottomBar;
        if (guildMediaChannelFragmentBottomBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomBar");
            guildMediaChannelFragmentBottomBar = null;
        }
        guildMediaChannelFragmentBottomBar.l();
        com.tencent.mobileqq.guild.media.viewmodel.b bVar = this.mMicStateViewModel;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMicStateViewModel");
            bVar = null;
        }
        bVar.q2();
        FragmentContainerView fragmentContainerView = this.mChildFragmentLayout;
        if (fragmentContainerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChildFragmentLayout");
            fragmentContainerView = null;
        }
        fragmentContainerView.removeAllViews();
        QQGuildOrientationSensorManager qQGuildOrientationSensorManager = this.mOrientationSensor;
        if (qQGuildOrientationSensorManager != null) {
            qQGuildOrientationSensorManager.d();
        }
        GuildMediaLoadingSkeletonContent guildMediaLoadingSkeletonContent = this.mLoadingSkeletonView;
        if (guildMediaLoadingSkeletonContent != null) {
            guildMediaLoadingSkeletonContent.b();
        }
        this.mediaLayoutPresenter.C();
        GuildMediaChannelViewModel guildMediaChannelViewModel3 = this.mChannelViewModel;
        if (guildMediaChannelViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
        } else {
            guildMediaChannelViewModel2 = guildMediaChannelViewModel3;
        }
        guildMediaChannelViewModel2.g2();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        super.onFinish();
        if (Pi()) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.overridePendingTransition(0, R.anim.f155066i1);
            }
        } else {
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.overridePendingTransition(0, R.anim.f154589nx);
            }
        }
        ki().notifyGuildFrameVisibleChanged("media channel finish.", true);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(@Nullable Intent intent) {
        Bundle bundle;
        Bundle extras;
        super.onNewIntent(intent);
        Bundle arguments = getArguments();
        if (arguments != null) {
            arguments.putString("ARG_KEY", com.tencent.mobileqq.guild.media.core.j.c().s());
        }
        if (intent != null && (extras = intent.getExtras()) != null) {
            bundle = extras.getBundle(AppConstants.Key.GUILD_EXTRA);
        } else {
            bundle = null;
        }
        checkNeedShowGiftPanel(bundle);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ImmersivePresenter immersivePresenter = this.immersivePresenter;
        String str = null;
        if (immersivePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("immersivePresenter");
            immersivePresenter = null;
        }
        immersivePresenter.w();
        ImmersivePresenter immersivePresenter2 = this.immersivePresenter;
        if (immersivePresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("immersivePresenter");
            immersivePresenter2 = null;
        }
        immersivePresenter2.j();
        GuildMediaChannelFragmentTitleBar guildMediaChannelFragmentTitleBar = this.mTitleBar;
        if (guildMediaChannelFragmentTitleBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBar");
            guildMediaChannelFragmentTitleBar = null;
        }
        guildMediaChannelFragmentTitleBar.c();
        ListenWidgetPresenter listenWidgetPresenter = this.mListenPresenter;
        if (listenWidgetPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListenPresenter");
            listenWidgetPresenter = null;
        }
        listenWidgetPresenter.y();
        boolean z16 = false;
        com.tencent.mobileqq.guild.media.core.logic.ab.f0(com.tencent.mobileqq.guild.media.core.j.a().M0(), 0, 1, null);
        com.tencent.mobileqq.guild.media.core.j.a().Y().S();
        com.tencent.mobileqq.guild.media.core.j.a().T().V1();
        GuildOperationBanner guildOperationBanner = this.mOperationBanner;
        if (guildOperationBanner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOperationBanner");
            guildOperationBanner = null;
        }
        guildOperationBanner.setAttachedPageVisibility(false);
        FragmentActivity activity = getActivity();
        if (activity != null && activity.isFinishing()) {
            z16 = true;
        }
        if (z16) {
            Bj();
            InputMethodUtil.hide(getActivity());
            if (com.tencent.mobileqq.guild.media.core.j.c().l().getValue() != EnterChannelState.ENTER_SUC) {
                com.tencent.mobileqq.guild.media.core.e a16 = com.tencent.mobileqq.guild.media.core.j.a();
                GuildMediaChannelViewModel guildMediaChannelViewModel = this.mChannelViewModel;
                if (guildMediaChannelViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
                    guildMediaChannelViewModel = null;
                }
                String channelUin = guildMediaChannelViewModel.getChannelInfo().getChannelUin();
                Intrinsics.checkNotNullExpressionValue(channelUin, "this.mChannelViewModel.channelInfo.channelUin");
                Bundle arguments = getArguments();
                if (arguments != null) {
                    str = arguments.getString("ARG_KEY");
                }
                a16.R("", "ExitUIWithoutEnterSuccess", channelUin, str);
                return;
            }
            if (com.tencent.mobileqq.guild.media.core.j.c().getSelfUserInfo().R) {
                Ji();
            }
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        GuildMediaChannelViewModel guildMediaChannelViewModel = this.mChannelViewModel;
        Bundle bundle = null;
        if (guildMediaChannelViewModel != null) {
            if (guildMediaChannelViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
                guildMediaChannelViewModel = null;
            }
            if (Intrinsics.areEqual(guildMediaChannelViewModel.c2().getValue(), Boolean.TRUE)) {
                ImmersivePresenter immersivePresenter = this.immersivePresenter;
                if (immersivePresenter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("immersivePresenter");
                    immersivePresenter = null;
                }
                immersivePresenter.u();
            }
        }
        GuildFloatWindowUtils.r();
        com.tencent.mobileqq.guild.media.core.j.a().Y().T();
        com.tencent.mobileqq.guild.media.core.j.a().T().W1();
        com.tencent.mobileqq.guild.media.core.j.a().d0().j1();
        GuildOperationBanner guildOperationBanner = this.mOperationBanner;
        if (guildOperationBanner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOperationBanner");
            guildOperationBanner = null;
        }
        guildOperationBanner.setAttachedPageVisibility(true);
        ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).preloadWebProcess();
        View view = this.mRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        view.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.media.q
            @Override // java.lang.Runnable
            public final void run() {
                GuildMediaChannelFragment.ej(GuildMediaChannelFragment.this);
            }
        }, 100L);
        ListenWidgetPresenter listenWidgetPresenter = this.mListenPresenter;
        if (listenWidgetPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListenPresenter");
            listenWidgetPresenter = null;
        }
        listenWidgetPresenter.z();
        Bundle arguments = getArguments();
        if (arguments != null) {
            bundle = arguments.getBundle(AppConstants.Key.GUILD_EXTRA);
        }
        checkNeedShowGiftPanel(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Bundle bundle;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        QLog.d("QGMC.GuildMediaChannelFragment", 1, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED);
        com.tencent.mobileqq.guild.media.viewmodel.b bVar = this.mMicStateViewModel;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMicStateViewModel");
            bVar = null;
        }
        bVar.init();
        Bundle arguments = getArguments();
        if (arguments != null) {
            bundle = arguments.getBundle(AppConstants.Key.GUILD_EXTRA);
        } else {
            bundle = null;
        }
        GuildMediaChannelViewModel guildMediaChannelViewModel = this.mChannelViewModel;
        if (guildMediaChannelViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
            guildMediaChannelViewModel = null;
        }
        Intrinsics.checkNotNull(arguments);
        guildMediaChannelViewModel.k2(arguments);
        com.tencent.mobileqq.guild.media.core.j.a().j0(bundle);
        com.tencent.mobileqq.guild.media.core.j.a().Q().w();
        GuildMediaChannelViewModel guildMediaChannelViewModel2 = this.mChannelViewModel;
        if (guildMediaChannelViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
            guildMediaChannelViewModel2 = null;
        }
        guildMediaChannelViewModel2.init(arguments);
        ri();
        View view2 = this.mRootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view2 = null;
        }
        View findViewById = view2.findViewById(R.id.f164797tw3);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.child_fragment_layout)");
        this.mChildFragmentLayout = (FragmentContainerView) findViewById;
        View view3 = this.mRootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view3 = null;
        }
        View findViewById2 = view3.findViewById(R.id.wpr);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R\u2026_fragment_container_view)");
        this.mAioContainerView = findViewById2;
        oj();
        initView(view);
        this.mediaLayoutPresenter.u(this);
        Ei();
        initOperationBanner();
        Hi();
        k.Companion companion = vh1.k.INSTANCE;
        GuildMediaChannelViewModel guildMediaChannelViewModel3 = this.mChannelViewModel;
        if (guildMediaChannelViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
            guildMediaChannelViewModel3 = null;
        }
        String guildId = guildMediaChannelViewModel3.getChannelInfo().getGuildId();
        Intrinsics.checkNotNullExpressionValue(guildId, "mChannelViewModel.channelInfo.guildId");
        companion.b(guildId, "GuildMediaChannelFragment");
        GuildMediaChannelViewModel guildMediaChannelViewModel4 = this.mChannelViewModel;
        if (guildMediaChannelViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
            guildMediaChannelViewModel4 = null;
        }
        String guildId2 = guildMediaChannelViewModel4.getChannelInfo().getGuildId();
        GuildMediaChannelViewModel guildMediaChannelViewModel5 = this.mChannelViewModel;
        if (guildMediaChannelViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelViewModel");
            guildMediaChannelViewModel5 = null;
        }
        QLog.i("QGMC.GuildMediaChannelFragment", 1, "[onViewCreated] guildId: " + guildId2 + ", channelId: " + guildMediaChannelViewModel5.getChannelInfo().getChannelUin());
        if (com.tencent.mobileqq.guild.media.core.m.g(com.tencent.mobileqq.guild.media.core.j.c())) {
            if (getActivity() != null) {
                FragmentActivity activity = getActivity();
                Intrinsics.checkNotNull(activity);
                if (!activity.isFinishing()) {
                    FragmentActivity activity2 = getActivity();
                    Intrinsics.checkNotNull(activity2);
                    if (!activity2.isDestroyed()) {
                        Ni();
                        Logger logger = Logger.f235387a;
                        Logger.b bVar2 = new Logger.b();
                        bVar2.a().add("onViewCreated, media channel isIdleState, exit.");
                        Iterator<T> it = bVar2.a().iterator();
                        while (it.hasNext()) {
                            Logger.f235387a.d().e("QGMC.GuildMediaChannelFragment", 1, (String) it.next(), null);
                        }
                    }
                }
            }
            QLog.d("QGMC.GuildMediaChannelFragment", 1, "onViewCreated activity is null");
        }
        com.tencent.mobileqq.guild.media.core.j.a().F0().q(this);
    }

    @Override // com.tencent.mobileqq.pad.f
    public boolean qOnBackPressed() {
        return false;
    }

    @Override // com.tencent.mobileqq.pad.f
    public void qOnNewIntent() {
        if (getArguments() != null) {
            onNewIntent(new Intent().putExtras(requireArguments()));
        }
    }
}
