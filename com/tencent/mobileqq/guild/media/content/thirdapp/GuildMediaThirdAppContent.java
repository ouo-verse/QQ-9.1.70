package com.tencent.mobileqq.guild.media.content.thirdapp;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.activity.result.ActivityResultCaller;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.media.GuildMediaUtils;
import com.tencent.mobileqq.guild.media.content.GuildMediaContentFragmentBase;
import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.guild.media.core.data.p;
import com.tencent.mobileqq.guild.media.core.data.r;
import com.tencent.mobileqq.guild.media.core.logic.trtc.TRTCAudioRoomLocalNew;
import com.tencent.mobileqq.guild.media.core.notify.ThirdAppBarClickEvent;
import com.tencent.mobileqq.guild.media.core.notify.aa;
import com.tencent.mobileqq.guild.media.core.notify.ai;
import com.tencent.mobileqq.guild.media.core.notify.av;
import com.tencent.mobileqq.guild.media.core.notify.aw;
import com.tencent.mobileqq.guild.media.core.notify.ax;
import com.tencent.mobileqq.guild.media.core.notify.ay;
import com.tencent.mobileqq.guild.media.core.notify.o;
import com.tencent.mobileqq.guild.media.core.notify.y;
import com.tencent.mobileqq.guild.media.thirdapp.ContentSize;
import com.tencent.mobileqq.guild.media.thirdapp.ScreenMode;
import com.tencent.mobileqq.guild.media.thirdapp.container.ContainerLifeEvent;
import com.tencent.mobileqq.guild.media.thirdapp.container.GuildOpenContainerLauncher;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.ContainerMsgIntent;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.MainProcessIntent;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.ToolProcessIntent;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.c;
import com.tencent.mobileqq.guild.media.thirdapp.container.report.GuildMediaWebJsReportTask;
import com.tencent.mobileqq.guild.media.thirdapp.container.webview.GuildMediaWebIPCServer;
import com.tencent.mobileqq.guild.media.thirdapp.widget.GuildMediaThirdAppFullScreenActionBar;
import com.tencent.mobileqq.guild.media.thirdapp.widget.GuildMediaThirdAppNormalContentView;
import com.tencent.mobileqq.guild.media.thirdapp.widget.f;
import com.tencent.mobileqq.guild.media.z;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelUserNum;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyAppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import com.tencent.util.UiThreadUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.Constants;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00e9\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007*\u000f\u007f\u0083\u0001\u0087\u0001\u008f\u0001\u0093\u0001\u0097\u0001\u009b\u0001\u009f\u0001\b\u0016\u0018\u0000 \u00a8\u00012\u00020\u00012\u00020\u0002:\u0002\u00a9\u0001B\t\u00a2\u0006\u0006\b\u00a6\u0001\u0010\u00a7\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0005H\u0002J\b\u0010\u0013\u001a\u00020\u0005H\u0002J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u0015\u001a\u00020\u0005H\u0002J\b\u0010\u0016\u001a\u00020\u0005H\u0002J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u0005H\u0002J\b\u0010\u001d\u001a\u00020\u0005H\u0002J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010!\u001a\u00020\u0005H\u0002J\u0010\u0010#\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\"H\u0002J\b\u0010$\u001a\u00020\u0005H\u0002J\b\u0010%\u001a\u00020\u0005H\u0002J\b\u0010&\u001a\u00020\u0005H\u0002J\b\u0010'\u001a\u00020\u0005H\u0002J\b\u0010(\u001a\u00020\u0005H\u0002J\b\u0010)\u001a\u00020\u000bH\u0016J&\u00101\u001a\u0004\u0018\u0001002\u0006\u0010+\u001a\u00020*2\b\u0010-\u001a\u0004\u0018\u00010,2\b\u0010/\u001a\u0004\u0018\u00010.H\u0016J\u001a\u00103\u001a\u00020\u00052\u0006\u00102\u001a\u0002002\b\u0010/\u001a\u0004\u0018\u00010.H\u0016J\u0012\u00105\u001a\u00020\u00052\b\b\u0002\u00104\u001a\u00020\rH\u0004J\u0010\u00108\u001a\u00020\u00052\u0006\u00107\u001a\u000206H\u0016J\b\u00109\u001a\u00020\u0005H\u0016J\u0006\u0010:\u001a\u00020\u0005J\b\u0010;\u001a\u00020\rH\u0016J\b\u0010<\u001a\u00020\rH\u0016J\b\u0010=\u001a\u00020\u0005H\u0016J\b\u0010>\u001a\u00020\u0005H\u0016J\b\u0010?\u001a\u00020\u0005H\u0016J\b\u0010@\u001a\u00020\rH\u0016J\b\u0010A\u001a\u00020\u0005H\u0004J\b\u0010B\u001a\u00020\u0005H\u0016J\b\u0010C\u001a\u00020\u0005H\u0016J\b\u0010D\u001a\u00020\u0005H\u0016J\b\u0010E\u001a\u00020\u0005H\u0016R\"\u0010L\u001a\u0002008\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\"\u0010T\u001a\u00020M8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\"\u0010\\\u001a\u00020U8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R$\u0010d\u001a\u0004\u0018\u00010]8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\"\u0010l\u001a\u00020e8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\u0018\u0010o\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010nR\u0016\u0010r\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bp\u0010qR\u0018\u0010u\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bs\u0010tR\u0016\u0010x\u001a\u00020v8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bw\u0010mR\u0018\u0010|\u001a\u0004\u0018\u00010y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bz\u0010{R\u0016\u0010~\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b}\u0010fR\u0017\u0010\u0082\u0001\u001a\u00020\u007f8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0018\u0010\u0086\u0001\u001a\u00030\u0083\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R\u0018\u0010\u008a\u0001\u001a\u00030\u0087\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R \u0010\u008e\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u008b\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R\u0018\u0010\u0092\u0001\u001a\u00030\u008f\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001R\u0018\u0010\u0096\u0001\u001a\u00030\u0093\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0094\u0001\u0010\u0095\u0001R\u0018\u0010\u009a\u0001\u001a\u00030\u0097\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0098\u0001\u0010\u0099\u0001R\u0018\u0010\u009e\u0001\u001a\u00030\u009b\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u009c\u0001\u0010\u009d\u0001R\u0018\u0010\u00a2\u0001\u001a\u00030\u009f\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a0\u0001\u0010\u00a1\u0001R\u0017\u0010\u00a5\u0001\u001a\u00030\u00a3\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bq\u0010\u00a4\u0001\u00a8\u0006\u00aa\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/media/content/thirdapp/GuildMediaThirdAppContent;", "Lcom/tencent/mobileqq/guild/media/content/GuildMediaContentFragmentBase;", "Lcom/tencent/mobileqq/guild/media/thirdapp/widget/g;", "", "Qh", "", "li", "mi", "Lcom/tencent/mobileqq/guild/media/thirdapp/d;", "appInfo", "Zh", "", "input", "", "send", "ai", "Lcom/tencent/mobileqq/guild/media/thirdapp/a;", "Rh", WidgetCacheLunarData.YI, "zi", "ii", "Bi", "Ai", "Landroidx/fragment/app/Fragment;", "Oh", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/ToolProcessIntent$ShowInputIntent;", "showInputIntent", "gi", "Nh", "vi", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/ToolProcessIntent$NotifyOfflineResCompleted;", "intent", "bi", "ki", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/MainProcessIntent$ContainerLifeIntent;", "hi", "Yh", "fi", "ei", "ci", WidgetCacheLunarData.JI, "Xh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "isEnd", "ni", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "pi", "Ph", "onBackEvent", "J2", "onDestroyView", SensorJsPlugin.SENSOR_INTERVAL_UI, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "C0", "wi", "C7", "l5", "tg", "L3", "E", "Landroid/view/View;", "Uh", "()Landroid/view/View;", "ri", "(Landroid/view/View;)V", "mRootView", "Landroid/widget/FrameLayout;", UserInfo.SEX_FEMALE, "Landroid/widget/FrameLayout;", "Sh", "()Landroid/widget/FrameLayout;", "qi", "(Landroid/widget/FrameLayout;)V", "mContentContainerView", "Lcom/tencent/mobileqq/guild/media/thirdapp/widget/GuildMediaThirdAppFullScreenActionBar;", "G", "Lcom/tencent/mobileqq/guild/media/thirdapp/widget/GuildMediaThirdAppFullScreenActionBar;", "Vh", "()Lcom/tencent/mobileqq/guild/media/thirdapp/widget/GuildMediaThirdAppFullScreenActionBar;", "si", "(Lcom/tencent/mobileqq/guild/media/thirdapp/widget/GuildMediaThirdAppFullScreenActionBar;)V", "mThirdAppFullScreenActionBar", "Lcom/tencent/mobileqq/guild/media/thirdapp/widget/f;", "H", "Lcom/tencent/mobileqq/guild/media/thirdapp/widget/f;", "Th", "()Lcom/tencent/mobileqq/guild/media/thirdapp/widget/f;", "setMContentView", "(Lcom/tencent/mobileqq/guild/media/thirdapp/widget/f;)V", "mContentView", "Lnt1/c;", "I", "Lnt1/c;", "Wh", "()Lnt1/c;", "ti", "(Lnt1/c;)V", "mThirdAppViewModel", "J", "Landroidx/fragment/app/Fragment;", "mThirdAppFragment", "K", "Z", "isLoadThirdAppContent", "L", "Lcom/tencent/mobileqq/guild/media/thirdapp/d;", "mLastMediaThirdAppInfo", "", "M", "mWebViewLoadingBeginTime", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/c;", "N", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/c;", "mShowInputCallback", "P", "lastVolume", "com/tencent/mobileqq/guild/media/content/thirdapp/GuildMediaThirdAppContent$f", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/guild/media/content/thirdapp/GuildMediaThirdAppContent$f;", "mThirdAppGlobalWebJSEvent", "com/tencent/mobileqq/guild/media/content/thirdapp/GuildMediaThirdAppContent$e", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/guild/media/content/thirdapp/GuildMediaThirdAppContent$e;", "mThirdAppBarClickEvent", "com/tencent/mobileqq/guild/media/content/thirdapp/GuildMediaThirdAppContent$k", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/guild/media/content/thirdapp/GuildMediaThirdAppContent$k;", "orientationChangedEvent", "", "T", "Ljava/util/List;", "containerActionTypeList", "com/tencent/mobileqq/guild/media/content/thirdapp/GuildMediaThirdAppContent$c", "U", "Lcom/tencent/mobileqq/guild/media/content/thirdapp/GuildMediaThirdAppContent$c;", "containerActionCallback", "com/tencent/mobileqq/guild/media/content/thirdapp/GuildMediaThirdAppContent$j", "V", "Lcom/tencent/mobileqq/guild/media/content/thirdapp/GuildMediaThirdAppContent$j;", "mThirdAppLoadFailedEvent", "com/tencent/mobileqq/guild/media/content/thirdapp/GuildMediaThirdAppContent$g", "W", "Lcom/tencent/mobileqq/guild/media/content/thirdapp/GuildMediaThirdAppContent$g;", "mThirdAppInfoPreloadEvent", "com/tencent/mobileqq/guild/media/content/thirdapp/GuildMediaThirdAppContent$h", "X", "Lcom/tencent/mobileqq/guild/media/content/thirdapp/GuildMediaThirdAppContent$h;", "mThirdAppInfoUpdateEvent", "com/tencent/mobileqq/guild/media/content/thirdapp/GuildMediaThirdAppContent$i", "Y", "Lcom/tencent/mobileqq/guild/media/content/thirdapp/GuildMediaThirdAppContent$i;", "mThirdAppInputResultEvent", "Lcom/tencent/mobileqq/guild/media/core/notify/y;", "Lcom/tencent/mobileqq/guild/media/core/notify/y;", "mAudioRoomObserver", "<init>", "()V", "a0", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public class GuildMediaThirdAppContent extends GuildMediaContentFragmentBase implements com.tencent.mobileqq.guild.media.thirdapp.widget.g {

    /* renamed from: E, reason: from kotlin metadata */
    public View mRootView;

    /* renamed from: F, reason: from kotlin metadata */
    public FrameLayout mContentContainerView;

    /* renamed from: G, reason: from kotlin metadata */
    public GuildMediaThirdAppFullScreenActionBar mThirdAppFullScreenActionBar;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.guild.media.thirdapp.widget.f mContentView;

    /* renamed from: I, reason: from kotlin metadata */
    public nt1.c mThirdAppViewModel;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private Fragment mThirdAppFragment;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean isLoadThirdAppContent;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.guild.media.thirdapp.d mLastMediaThirdAppInfo;

    /* renamed from: M, reason: from kotlin metadata */
    private long mWebViewLoadingBeginTime;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.guild.media.thirdapp.container.intent.c mShowInputCallback;

    /* renamed from: P, reason: from kotlin metadata */
    private int lastVolume;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final f mThirdAppGlobalWebJSEvent = new f();

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final e mThirdAppBarClickEvent = new e();

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final k orientationChangedEvent = new k();

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final List<String> containerActionTypeList;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final c containerActionCallback;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final j mThirdAppLoadFailedEvent;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final g mThirdAppInfoPreloadEvent;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private final h mThirdAppInfoUpdateEvent;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private final i mThirdAppInputResultEvent;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private final y mAudioRoomObserver;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f228016a;

        static {
            int[] iArr = new int[ContainerLifeEvent.values().length];
            try {
                iArr[ContainerLifeEvent.ON_SURFACE_CREATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ContainerLifeEvent.ON_BEFORE_LOAD_URL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ContainerLifeEvent.ON_SURFACE_CHANGED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ContainerLifeEvent.ON_REMOTE_WEB_DESTROY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ContainerLifeEvent.ON_REMOTE_WEB_REBUILD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ContainerLifeEvent.ON_SURFACE_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f228016a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/content/thirdapp/GuildMediaThirdAppContent$c", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/f;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/ContainerMsgIntent;", "intent", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements com.tencent.mobileqq.guild.media.thirdapp.container.intent.f {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.media.thirdapp.container.intent.f
        public void a(@NotNull ContainerMsgIntent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildMediaThirdAppContent", 1, "WebViewFragment intent: " + intent);
            if (intent instanceof MainProcessIntent.ContainerLifeIntent) {
                GuildMediaThirdAppContent.this.hi((MainProcessIntent.ContainerLifeIntent) intent);
                return;
            }
            if (intent instanceof ToolProcessIntent.CloseLoadingIntent) {
                GuildMediaThirdAppContent.this.Nh();
                return;
            }
            if (intent instanceof ToolProcessIntent.ShowInputIntent) {
                GuildMediaThirdAppContent.this.gi((ToolProcessIntent.ShowInputIntent) intent);
            } else if (intent instanceof ToolProcessIntent.ShowFullScreenIconIntent) {
                GuildMediaThirdAppContent.this.vi();
            } else if (intent instanceof ToolProcessIntent.NotifyOfflineResCompleted) {
                GuildMediaThirdAppContent.this.bi((ToolProcessIntent.NotifyOfflineResCompleted) intent);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\u000e\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/guild/media/content/thirdapp/GuildMediaThirdAppContent$d", "Lcom/tencent/mobileqq/guild/media/core/notify/y;", "", "guildId", "channelId", "Lcom/tencent/mobileqq/guild/media/core/data/f;", "localUserInfo", "Lcom/tencent/mobileqq/guild/media/core/data/r;", "userInfoList", "", "w", "from", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelUserNum;", "channelNumber", "j", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d extends y {
        d() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.q
        public void j(@Nullable String from, @Nullable IGProChannelUserNum channelNumber) {
            if (GuildMediaThirdAppContent.this.Vh().getVisibility() == 0) {
                GuildMediaThirdAppContent.this.Vh().q();
            }
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.y
        public void w(@Nullable String guildId, @Nullable String channelId, @Nullable com.tencent.mobileqq.guild.media.core.data.f localUserInfo, @Nullable r userInfoList) {
            p pVar;
            if (userInfoList != null && !userInfoList.f228125a.isEmpty()) {
                Iterator<p> it = userInfoList.f228125a.iterator();
                while (true) {
                    if (it.hasNext()) {
                        pVar = it.next();
                        if (pVar.f228109q > 0) {
                            int i3 = GuildMediaThirdAppContent.this.lastVolume;
                            int i16 = pVar.f228109q;
                            if (i3 != i16) {
                                GuildMediaThirdAppContent.this.lastVolume = i16;
                                break;
                            }
                        }
                    } else {
                        pVar = null;
                        break;
                    }
                }
                if (GuildMediaThirdAppContent.this.Vh().getVisibility() == 0 || pVar == null) {
                    GuildMediaThirdAppContent.this.Vh().w(pVar);
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/content/thirdapp/GuildMediaThirdAppContent$e", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/ThirdAppBarClickEvent;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e implements o<ThirdAppBarClickEvent> {

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes14.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f228020a;

            static {
                int[] iArr = new int[ThirdAppBarClickEvent.values().length];
                try {
                    iArr[ThirdAppBarClickEvent.MINIMIZE_PORTRAIT.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ThirdAppBarClickEvent.MINIMIZE_LAND.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f228020a = iArr;
            }
        }

        e() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull ThirdAppBarClickEvent event) {
            IGProLobbyAppInfo appInfo;
            IGProLobbyAppInfo appInfo2;
            Intrinsics.checkNotNullParameter(event, "event");
            int i3 = a.f228020a[event.ordinal()];
            int i16 = 0;
            if (i3 != 1) {
                if (i3 == 2) {
                    com.tencent.mobileqq.guild.media.thirdapp.widget.f mContentView = GuildMediaThirdAppContent.this.getMContentView();
                    if (mContentView != null) {
                        com.tencent.mobileqq.guild.media.thirdapp.d S1 = GuildMediaThirdAppContent.this.Wh().S1();
                        if (S1 != null && (appInfo2 = S1.getAppInfo()) != null) {
                            i16 = appInfo2.getFullScreenMode();
                        }
                        mContentView.setResetUI(i16);
                    }
                    GuildMediaThirdAppContent.this.Vh().r();
                    GuildMediaThirdAppContent.this.ph().a2().postValue(Boolean.FALSE);
                    return;
                }
                return;
            }
            com.tencent.mobileqq.guild.media.thirdapp.widget.f mContentView2 = GuildMediaThirdAppContent.this.getMContentView();
            if (mContentView2 != null) {
                com.tencent.mobileqq.guild.media.thirdapp.d S12 = GuildMediaThirdAppContent.this.Wh().S1();
                if (S12 != null && (appInfo = S12.getAppInfo()) != null) {
                    i16 = appInfo.getFullScreenMode();
                }
                mContentView2.setResetUI(i16);
            }
            GuildMediaThirdAppContent.this.Vh().r();
            GuildMediaThirdAppContent.this.ph().b2().postValue(Boolean.FALSE);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/content/thirdapp/GuildMediaThirdAppContent$f", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/aa;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class f implements o<aa> {
        f() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull aa event) {
            com.tencent.mobileqq.guild.media.thirdapp.container.b bVar;
            Intrinsics.checkNotNullParameter(event, "event");
            Logger logger = Logger.f235387a;
            String Xh = GuildMediaThirdAppContent.this.Xh();
            logger.d().i(Xh, 1, "onEventReceive: MediaGlobalWebJsEvent. " + event);
            if (!(event.getIntent() instanceof ToolProcessIntent.GetScreenContentSizeIntent)) {
                ActivityResultCaller activityResultCaller = GuildMediaThirdAppContent.this.mThirdAppFragment;
                if (activityResultCaller instanceof com.tencent.mobileqq.guild.media.thirdapp.container.b) {
                    bVar = (com.tencent.mobileqq.guild.media.thirdapp.container.b) activityResultCaller;
                } else {
                    bVar = null;
                }
                if (bVar != null) {
                    bVar.Rf(event.getIntent());
                    return;
                }
                return;
            }
            String jSONObject = lt1.a.h(GuildMediaThirdAppContent.this.Rh()).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "getContentPlaceHolderSize().toWebJSON().toString()");
            com.tencent.mobileqq.guild.media.thirdapp.container.intent.c asyncResult = ((ToolProcessIntent.GetScreenContentSizeIntent) event.getIntent()).getAsyncResult();
            Bundle bundle = new Bundle();
            bundle.putString("ScreenModeInfo", jSONObject);
            Unit unit = Unit.INSTANCE;
            asyncResult.a(0L, "", bundle);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/content/thirdapp/GuildMediaThirdAppContent$g", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/aw;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class g implements o<aw> {
        g() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull aw event) {
            Intrinsics.checkNotNullParameter(event, "event");
            Logger logger = Logger.f235387a;
            logger.d().i(GuildMediaThirdAppContent.this.Xh(), 1, "onEventReceive: ThirdAppInfoPreloadEvent.");
            GuildMediaThirdAppContent.this.ji();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/content/thirdapp/GuildMediaThirdAppContent$h", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/ax;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class h implements o<ax> {
        h() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull ax event) {
            Intrinsics.checkNotNullParameter(event, "event");
            Logger logger = Logger.f235387a;
            logger.d().i(GuildMediaThirdAppContent.this.Xh(), 1, "onEventReceive: ThirdAppInfoUpdateEvent.");
            GuildMediaThirdAppContent guildMediaThirdAppContent = GuildMediaThirdAppContent.this;
            guildMediaThirdAppContent.Zh(guildMediaThirdAppContent.Wh().S1());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/content/thirdapp/GuildMediaThirdAppContent$i", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/ay;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class i implements o<ay> {
        i() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull ay event) {
            Intrinsics.checkNotNullParameter(event, "event");
            Logger logger = Logger.f235387a;
            String Xh = GuildMediaThirdAppContent.this.Xh();
            logger.d().i(Xh, 1, "onEventReceive: ThirdAppInputResultEvent event " + event + ".");
            GuildMediaThirdAppContent.this.ai(event.getInput(), event.getIsSend());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/content/thirdapp/GuildMediaThirdAppContent$j", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/av;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class j implements o<av> {
        j() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull av event) {
            Intrinsics.checkNotNullParameter(event, "event");
            Logger logger = Logger.f235387a;
            logger.d().i(GuildMediaThirdAppContent.this.Xh(), 1, "onEventReceive: ThirdAppInfoFailedEvent.");
            GuildMediaThirdAppContent.this.ji();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/content/thirdapp/GuildMediaThirdAppContent$k", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/ai;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class k implements o<ai> {
        k() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull ai event) {
            Intrinsics.checkNotNullParameter(event, "event");
            Boolean value = GuildMediaThirdAppContent.this.ph().b2().getValue();
            if (value == null) {
                value = Boolean.FALSE;
            }
            boolean booleanValue = value.booleanValue();
            Boolean value2 = GuildMediaThirdAppContent.this.ph().a2().getValue();
            if (value2 == null) {
                value2 = Boolean.FALSE;
            }
            boolean booleanValue2 = value2.booleanValue();
            QLog.d("QGMC.MediaThirdApp.GuildMediaThirdAppContent", 1, "[OrientationChangedEvent.onEventReceive] " + event.getOrientation() + ", isExpandView: " + booleanValue + ", isLandView: " + booleanValue2);
            int orientation = event.getOrientation();
            if (orientation != 1) {
                if (orientation == 2 && booleanValue) {
                    QLog.d("QGMC.MediaThirdApp.GuildMediaThirdAppContent", 1, "[OrientationChangedEvent.onEventReceive] update to land");
                    GuildMediaThirdAppContent.this.ph().a2().postValue(Boolean.TRUE);
                    return;
                }
                return;
            }
            GuildMediaThirdAppContent.this.ph().a2().postValue(Boolean.FALSE);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class l<T> implements Observer<T> {
        public l() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            Boolean it = (Boolean) t16;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (it.booleanValue()) {
                GuildMediaThirdAppContent.this.wi();
                GuildMediaThirdAppContent.this.Wh().R1().setValue(Boolean.FALSE);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class m<T> implements Observer<T> {
        public m() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            Boolean it = (Boolean) t16;
            QLog.d(GuildMediaThirdAppContent.this.Xh(), 1, "toExpandView " + it);
            GuildMediaThirdAppContent.oi(GuildMediaThirdAppContent.this, false, 1, null);
            GuildMediaThirdAppContent.this.wi();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (it.booleanValue()) {
                GuildMediaThirdAppContent.this.Vh().q();
                GuildMediaThirdAppContent.this.Vh().setVisibility(0);
            } else {
                GuildMediaThirdAppContent.this.Vh().r();
                GuildMediaThirdAppContent.this.Vh().setVisibility(8);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007\u00b8\u0006\u0000"}, d2 = {"androidx/core/view/ViewKt$doOnAttach$1", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "view", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "core-ktx_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class n implements View.OnAttachStateChangeListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f228029d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GuildMediaThirdAppContent f228030e;

        public n(View view, GuildMediaThirdAppContent guildMediaThirdAppContent) {
            this.f228029d = view;
            this.f228030e = guildMediaThirdAppContent;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.f228029d.removeOnAttachStateChangeListener(this);
            com.tencent.mobileqq.guild.media.thirdapp.d dVar = this.f228030e.mLastMediaThirdAppInfo;
            if (dVar != null) {
                this.f228030e.ii(dVar);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    public GuildMediaThirdAppContent() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{Reflection.getOrCreateKotlinClass(MainProcessIntent.ContainerLifeIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(ToolProcessIntent.CloseLoadingIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(ToolProcessIntent.ShowInputIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(ToolProcessIntent.ShowFullScreenIconIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(ToolProcessIntent.NotifyOfflineResCompleted.class).getQualifiedName()});
        this.containerActionTypeList = listOf;
        this.containerActionCallback = new c();
        this.mThirdAppLoadFailedEvent = new j();
        this.mThirdAppInfoPreloadEvent = new g();
        this.mThirdAppInfoUpdateEvent = new h();
        this.mThirdAppInputResultEvent = new i();
        this.mAudioRoomObserver = new d();
    }

    private final void Ai() {
        if (this.mContentView == null) {
            return;
        }
        nt1.c Wh = Wh();
        Boolean value = ph().b2().getValue();
        if (value == null) {
            value = Boolean.FALSE;
        }
        Pair<Integer, Integer> P1 = Wh.P1(value.booleanValue());
        int intValue = P1.getFirst().intValue();
        int intValue2 = P1.getSecond().intValue();
        com.tencent.mobileqq.guild.media.thirdapp.widget.f fVar = this.mContentView;
        if (fVar != null) {
            fVar.setThirdAppSize(intValue, intValue2);
        }
    }

    private final void Bi() {
        if (this.mContentView == null) {
            return;
        }
        nt1.c Wh = Wh();
        Boolean value = ph().b2().getValue();
        if (value == null) {
            value = Boolean.FALSE;
        }
        boolean booleanValue = value.booleanValue();
        Boolean value2 = ph().a2().getValue();
        if (value2 == null) {
            value2 = Boolean.FALSE;
        }
        Pair<Integer, Integer> Q1 = Wh.Q1(booleanValue, value2.booleanValue());
        int intValue = Q1.getFirst().intValue();
        int intValue2 = Q1.getSecond().intValue();
        com.tencent.mobileqq.guild.media.thirdapp.widget.f fVar = this.mContentView;
        if (fVar != null) {
            fVar.setThirdAppSize(intValue, intValue2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Nh() {
        com.tencent.mobileqq.guild.media.thirdapp.widget.f fVar = this.mContentView;
        if (fVar != null) {
            fVar.b(false);
        }
        vi();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Fragment Oh(com.tencent.mobileqq.guild.media.thirdapp.d appInfo) {
        String str;
        String U1 = Wh().U1();
        GuildOpenContainerLauncher guildOpenContainerLauncher = GuildOpenContainerLauncher.f229226a;
        String appId = appInfo.getAppInfo().getAppId();
        String guildID = com.tencent.mobileqq.guild.media.core.j.a().getGuildID();
        String E = com.tencent.mobileqq.guild.media.core.j.a().E();
        String h5Url = appInfo.getAppInfo().getH5Url();
        long lobbyId = appInfo.getRoomInfo().getLobbyId();
        Bundle bundle = new Bundle();
        nt1.c Wh = Wh();
        Boolean value = ph().b2().getValue();
        if (value == null) {
            value = Boolean.FALSE;
        }
        Intrinsics.checkNotNullExpressionValue(value, "mChannelViewModel.toPort\u2026FullScreen.value ?: false");
        boolean booleanValue = value.booleanValue();
        Boolean value2 = ph().a2().getValue();
        if (value2 == null) {
            value2 = Boolean.FALSE;
        }
        Intrinsics.checkNotNullExpressionValue(value2, "mChannelViewModel.toLandView.value ?: false");
        Pair<Integer, Integer> Q1 = Wh.Q1(booleanValue, value2.booleanValue());
        bundle.putInt("guild_webview_width", Q1.getFirst().intValue());
        bundle.putInt("guild_webview_height", Q1.getSecond().intValue());
        bundle.putSerializable("guildInfo", com.tencent.mobileqq.guild.media.core.j.a().getGuildInfo());
        bundle.putSerializable("channelInfo", com.tencent.mobileqq.guild.media.core.j.a().getChannelInfo());
        IGProChannelInfo channelInfo = com.tencent.mobileqq.guild.media.core.j.a().getChannelInfo();
        com.tencent.mobileqq.guild.media.thirdapp.container.b bVar = null;
        if (channelInfo != null) {
            str = channelInfo.getChannelName();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str, "MediaChannel.getCore().g\u2026Info()?.channelName ?: \"\"");
        }
        bundle.putString("channel_name", str);
        bundle.putInt("user_type", z.h(com.tencent.mobileqq.guild.media.core.j.a().getGuildID(), com.tencent.mobileqq.guild.media.core.j.a().E()));
        bundle.putInt("start_permission", GuildMediaUtils.k(com.tencent.mobileqq.guild.media.core.j.a().getGuildID(), com.tencent.mobileqq.guild.media.core.j.a().E()) ? 1 : 0);
        bundle.putString("key_web_attach_web_page_id", U1);
        Unit unit = Unit.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(appId, "appId");
        Intrinsics.checkNotNullExpressionValue(h5Url, "h5Url");
        Fragment c16 = GuildOpenContainerLauncher.c(guildOpenContainerLauncher, new GuildOpenContainerLauncher.StartParams(appId, h5Url, guildID, E, "", lobbyId, U1, bundle), null, 2, null);
        this.mThirdAppFragment = c16;
        if (c16 instanceof com.tencent.mobileqq.guild.media.thirdapp.container.b) {
            bVar = (com.tencent.mobileqq.guild.media.thirdapp.container.b) c16;
        }
        if (bVar != null) {
            for (String str2 : this.containerActionTypeList) {
                if (str2 == null) {
                    str2 = "";
                }
                bVar.mb(str2, this.containerActionCallback);
            }
        }
        Fragment fragment = this.mThirdAppFragment;
        Intrinsics.checkNotNull(fragment);
        return fragment;
    }

    private final int Qh() {
        if (this instanceof GuildMediaThirdAppLandContent) {
            return 3;
        }
        if (Intrinsics.areEqual(ph().b2().getValue(), Boolean.TRUE)) {
            return 2;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ContentSize Rh() {
        int i3;
        int i16;
        ScreenMode screenMode = ScreenMode.NORMAL;
        Boolean value = ph().b2().getValue();
        Boolean bool = Boolean.TRUE;
        int i17 = 110;
        if (Intrinsics.areEqual(value, bool)) {
            screenMode = ScreenMode.FULL_PORTRAIT;
            i3 = 0;
            i16 = 0;
        } else if (Intrinsics.areEqual(ph().a2().getValue(), bool)) {
            screenMode = ScreenMode.LAND;
            i3 = 50;
            i16 = 110;
            i17 = 0;
        } else {
            i3 = 0;
            i16 = 0;
            i17 = 0;
        }
        ContentSize contentSize = new ContentSize(0, i3, i16, i17, screenMode);
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildMediaThirdAppContent", 1, "[getContentPlaceHolderSize] contentSize " + contentSize);
        return contentSize;
    }

    private final void Yh() {
        Logger logger = Logger.f235387a;
        logger.d().d(Xh(), 1, "[handleConfigurationChanged]");
        this.isLoadThirdAppContent = false;
        ji();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Zh(com.tencent.mobileqq.guild.media.thirdapp.d appInfo) {
        String str;
        IGProLobbyAppInfo appInfo2;
        Logger logger = Logger.f235387a;
        String Xh = Xh();
        logger.d().i(Xh, 1, "handleMediaThirdAppInfoUpdated: old[" + this.mLastMediaThirdAppInfo + "] new[" + appInfo + "]");
        if (appInfo == null) {
            return;
        }
        com.tencent.mobileqq.guild.media.thirdapp.d dVar = this.mLastMediaThirdAppInfo;
        if (dVar != null && (appInfo2 = dVar.getAppInfo()) != null) {
            str = appInfo2.getAppId();
        } else {
            str = null;
        }
        if (!TextUtils.equals(str, appInfo.getAppInfo().getAppId())) {
            this.isLoadThirdAppContent = false;
        }
        ji();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ai(String input, boolean send) {
        Logger logger = Logger.f235387a;
        String Xh = Xh();
        logger.d().i(Xh, 1, "handleMediaThirdAppInputResult: input[" + input + "] send " + send);
        Bundle bundle = new Bundle();
        bundle.putString("input_text", input);
        bundle.putBoolean(QQBrowserActivity.KEY_IS_SEND, send);
        com.tencent.mobileqq.guild.media.thirdapp.container.intent.c cVar = this.mShowInputCallback;
        if (cVar != null) {
            c.a.a(cVar, 0L, null, bundle, 3, null);
        }
        this.mShowInputCallback = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bi(ToolProcessIntent.NotifyOfflineResCompleted intent) {
        boolean z16;
        com.tencent.mobileqq.guild.media.thirdapp.container.report.a thirdAppLoadReportTask;
        if (intent.getUrl().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && intent.getTimeCost() > 0 && (thirdAppLoadReportTask = com.tencent.mobileqq.guild.media.core.j.a().d0().getThirdAppLoadReportTask()) != null) {
            thirdAppLoadReportTask.m(intent.getUrl(), intent.getTimeCost());
        }
    }

    private final void ci() {
        Logger logger = Logger.f235387a;
        String Xh = Xh();
        Logger.b bVar = new Logger.b();
        bVar.a().add("handleOnThirdPartLoadStarted:");
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e(Xh, 1, (String) it.next(), null);
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.media.content.thirdapp.b
            @Override // java.lang.Runnable
            public final void run() {
                GuildMediaThirdAppContent.di(GuildMediaThirdAppContent.this);
            }
        }, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void di(GuildMediaThirdAppContent this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.guild.media.thirdapp.widget.f fVar = this$0.mContentView;
        if (fVar != null) {
            fVar.b(false);
        }
    }

    private final void ei() {
        Wh().Z1(System.currentTimeMillis() - this.mWebViewLoadingBeginTime, 0L);
        com.tencent.mobileqq.guild.media.thirdapp.container.report.a thirdAppLoadReportTask = com.tencent.mobileqq.guild.media.core.j.a().d0().getThirdAppLoadReportTask();
        if (thirdAppLoadReportTask != null) {
            thirdAppLoadReportTask.k();
        }
    }

    private final void fi() {
        TRTCAudioRoomLocalNew.INSTANCE.a().h();
        this.mShowInputCallback = null;
        this.isLoadThirdAppContent = false;
        ji();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void gi(ToolProcessIntent.ShowInputIntent showInputIntent) {
        Wh().d2(showInputIntent.getHintText(), showInputIntent.getActionText(), showInputIntent.getDefaultText());
        this.mShowInputCallback = showInputIntent.getInputResult();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hi(MainProcessIntent.ContainerLifeIntent intent) {
        switch (b.f228016a[intent.getEvent().ordinal()]) {
            case 1:
                GuildMediaWebJsReportTask webJsReportTask = com.tencent.mobileqq.guild.media.core.j.a().d0().getWebJsReportTask();
                if (webJsReportTask != null) {
                    webJsReportTask.o(true);
                }
                com.tencent.mobileqq.guild.media.thirdapp.container.report.a thirdAppLoadReportTask = com.tencent.mobileqq.guild.media.core.j.a().d0().getThirdAppLoadReportTask();
                if (thirdAppLoadReportTask != null) {
                    thirdAppLoadReportTask.l();
                }
                this.mWebViewLoadingBeginTime = System.currentTimeMillis();
                return;
            case 2:
                ei();
                ci();
                return;
            case 3:
                Nh();
                return;
            case 4:
                Logger logger = Logger.f235387a;
                String Xh = Xh();
                Logger.b bVar = new Logger.b();
                bVar.a().add("remote web had destroy, rebuild UI!");
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e(Xh, 1, (String) it.next(), null);
                }
                fi();
                return;
            case 5:
                Yh();
                return;
            case 6:
                GuildMediaWebJsReportTask webJsReportTask2 = com.tencent.mobileqq.guild.media.core.j.a().d0().getWebJsReportTask();
                if (webJsReportTask2 != null) {
                    webJsReportTask2.o(false);
                    return;
                }
                return;
            default:
                Logger logger2 = Logger.f235387a;
                String Xh2 = Xh();
                logger2.d().w(Xh2, 1, "[handleThirdAppEvent] not handle " + intent);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ii(com.tencent.mobileqq.guild.media.thirdapp.d appInfo) {
        int i3;
        if (this.mContentView == null) {
            return;
        }
        Logger logger = Logger.f235387a;
        String Xh = Xh();
        Logger.b bVar = new Logger.b();
        String str = "loadWebPluginFragment: appInfo[" + appInfo + "]";
        if (str instanceof String) {
            bVar.a().add(str);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e(Xh, 1, (String) it.next(), null);
        }
        this.mWebViewLoadingBeginTime = System.currentTimeMillis();
        com.tencent.mobileqq.guild.media.thirdapp.widget.f fVar = this.mContentView;
        if (fVar != null) {
            i3 = fVar.d();
        } else {
            i3 = 0;
        }
        Fragment Oh = Oh(appInfo);
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "childFragmentManager.beginTransaction()");
        beginTransaction.replace(i3, Oh);
        beginTransaction.commitAllowingStateLoss();
        this.isLoadThirdAppContent = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ji() {
        Wh().R1().setValue(Boolean.TRUE);
    }

    private final void ki() {
        String str;
        com.tencent.mobileqq.guild.media.thirdapp.e T1;
        com.tencent.mobileqq.guild.media.thirdapp.d S1 = Wh().S1();
        if (S1 != null) {
            str = S1.getAppInfo().getAppId();
            Intrinsics.checkNotNullExpressionValue(str, "mediaThirdInfo.appInfo.appId");
        } else if (Wh().T1() == null || (T1 = Wh().T1()) == null || (str = T1.getAppId()) == null) {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            Logger logger = Logger.f235387a;
            String Xh = Xh();
            Logger.b bVar = new Logger.b();
            bVar.a().add("openThirdAppProfileDialog: app id is null.");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e(Xh, 1, (String) it.next(), null);
            }
            return;
        }
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        GuildMediaUtils.o(requireActivity, str, com.tencent.mobileqq.guild.media.core.j.a().getGuildID(), com.tencent.mobileqq.guild.media.core.j.a().E());
    }

    private final void li() {
        com.tencent.mobileqq.guild.media.core.j.d().V(aw.class, this.mThirdAppInfoPreloadEvent);
        com.tencent.mobileqq.guild.media.core.j.d().V(av.class, this.mThirdAppLoadFailedEvent);
        com.tencent.mobileqq.guild.media.core.j.d().V(ax.class, this.mThirdAppInfoUpdateEvent);
        com.tencent.mobileqq.guild.media.core.j.d().V(ay.class, this.mThirdAppInputResultEvent);
        com.tencent.mobileqq.guild.media.core.j.d().V(aa.class, this.mThirdAppGlobalWebJSEvent);
        com.tencent.mobileqq.guild.media.core.j.d().V(ThirdAppBarClickEvent.class, this.mThirdAppBarClickEvent);
        com.tencent.mobileqq.guild.media.core.j.d().V(ai.class, this.orientationChangedEvent);
        com.tencent.mobileqq.guild.media.core.j.a().l0().b(this.mAudioRoomObserver);
        e12.e<Boolean> R1 = Wh().R1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        R1.observe(viewLifecycleOwner, new l());
        pi();
    }

    private final void mi() {
        com.tencent.mobileqq.guild.media.core.j.d().j(aw.class, this.mThirdAppInfoPreloadEvent);
        com.tencent.mobileqq.guild.media.core.j.d().j(av.class, this.mThirdAppLoadFailedEvent);
        com.tencent.mobileqq.guild.media.core.j.d().j(ax.class, this.mThirdAppInfoUpdateEvent);
        com.tencent.mobileqq.guild.media.core.j.d().j(ay.class, this.mThirdAppInputResultEvent);
        com.tencent.mobileqq.guild.media.core.j.d().j(aa.class, this.mThirdAppGlobalWebJSEvent);
        com.tencent.mobileqq.guild.media.core.j.d().j(ThirdAppBarClickEvent.class, this.mThirdAppBarClickEvent);
        com.tencent.mobileqq.guild.media.core.j.d().j(ai.class, this.orientationChangedEvent);
        com.tencent.mobileqq.guild.media.core.j.a().l0().B(this.mAudioRoomObserver);
    }

    public static /* synthetic */ void oi(GuildMediaThirdAppContent guildMediaThirdAppContent, boolean z16, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                z16 = false;
            }
            guildMediaThirdAppContent.ni(z16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportAppWindowElement");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void vi() {
        Boolean value = ph().b2().getValue();
        Boolean bool = Boolean.TRUE;
        if (Intrinsics.areEqual(value, bool)) {
            com.tencent.mobileqq.guild.media.thirdapp.widget.f fVar = this.mContentView;
            if (fVar != null) {
                fVar.setPortraitFullUI();
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(ph().a2().getValue(), bool)) {
            com.tencent.mobileqq.guild.media.thirdapp.widget.f fVar2 = this.mContentView;
            if (fVar2 != null) {
                fVar2.setLandFullUI();
                return;
            }
            return;
        }
        com.tencent.mobileqq.guild.media.thirdapp.d S1 = Wh().S1();
        if (S1 != null) {
            int fullScreenMode = S1.getAppInfo().getFullScreenMode();
            QLog.d("QGMC.MediaThirdApp.GuildMediaThirdAppContent", 1, "fullScreenMode " + fullScreenMode);
            com.tencent.mobileqq.guild.media.thirdapp.widget.f fVar3 = this.mContentView;
            if (fVar3 != null) {
                fVar3.setResetUI(fullScreenMode);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xi(GuildMediaThirdAppContent this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.guild.media.thirdapp.widget.f fVar = this$0.mContentView;
        if (fVar != null) {
            fVar.b(false);
        }
    }

    private final void yi() {
        com.tencent.mobileqq.guild.media.thirdapp.widget.f fVar;
        com.tencent.mobileqq.guild.media.thirdapp.d S1 = Wh().S1();
        if (S1 != null && (fVar = this.mContentView) != null) {
            fVar.setThirdAppInfo(S1.getAppInfo());
        }
    }

    private final void zi() {
        com.tencent.mobileqq.guild.media.thirdapp.e T1 = Wh().T1();
        if (T1 != null) {
            com.tencent.mobileqq.guild.media.thirdapp.widget.f fVar = this.mContentView;
            if (fVar != null) {
                fVar.setThirdAppPreloadInfo(T1);
            }
            com.tencent.mobileqq.guild.media.thirdapp.widget.f fVar2 = this.mContentView;
            if (fVar2 != null) {
                fVar2.b(true);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.media.content.GuildMediaContentFragmentBase, com.tencent.mobileqq.guild.media.content.i
    public boolean C0() {
        return false;
    }

    @Override // com.tencent.mobileqq.guild.media.thirdapp.widget.g
    public void C7() {
        Wh().N1();
    }

    @Override // com.tencent.mobileqq.guild.media.content.GuildMediaContentFragmentBase, com.tencent.mobileqq.guild.media.content.i
    public boolean J2() {
        Boolean value = ph().b2().getValue();
        Boolean bool = Boolean.TRUE;
        if (!Intrinsics.areEqual(value, bool) && !Intrinsics.areEqual(ph().a2().getValue(), bool)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.guild.media.thirdapp.widget.g
    public void L3() {
        if (com.tencent.mobileqq.guild.util.o.d("COMMON_BTN_CLICK_TAG", 1500L)) {
            return;
        }
        QLog.d("QGMC.MediaThirdApp.GuildMediaThirdAppContent", 1, "onThirdAppClickedToLand, " + ph().a2().getValue());
        com.tencent.mobileqq.guild.media.core.j.d().i(ThirdAppBarClickEvent.FULL_LAND);
        ph().a2().postValue(Boolean.TRUE);
    }

    public final void Ph() {
        ViewGroup viewGroup;
        Object obj = this.mContentView;
        if (obj instanceof ViewGroup) {
            viewGroup = (ViewGroup) obj;
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            return;
        }
        Logger.f235387a.d().d(Xh(), 1, "[destroyContentView] ");
        com.tencent.mobileqq.guild.media.thirdapp.widget.f fVar = this.mContentView;
        if (fVar != null) {
            fVar.a();
        }
        Sh().removeView(viewGroup);
        this.mContentView = null;
        this.isLoadThirdAppContent = false;
    }

    @NotNull
    public final FrameLayout Sh() {
        FrameLayout frameLayout = this.mContentContainerView;
        if (frameLayout != null) {
            return frameLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mContentContainerView");
        return null;
    }

    @Nullable
    /* renamed from: Th, reason: from getter */
    public final com.tencent.mobileqq.guild.media.thirdapp.widget.f getMContentView() {
        return this.mContentView;
    }

    @NotNull
    public final View Uh() {
        View view = this.mRootView;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        return null;
    }

    @NotNull
    public final GuildMediaThirdAppFullScreenActionBar Vh() {
        GuildMediaThirdAppFullScreenActionBar guildMediaThirdAppFullScreenActionBar = this.mThirdAppFullScreenActionBar;
        if (guildMediaThirdAppFullScreenActionBar != null) {
            return guildMediaThirdAppFullScreenActionBar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mThirdAppFullScreenActionBar");
        return null;
    }

    @NotNull
    public final nt1.c Wh() {
        nt1.c cVar = this.mThirdAppViewModel;
        if (cVar != null) {
            return cVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mThirdAppViewModel");
        return null;
    }

    @NotNull
    public String Xh() {
        return "QGMC.MediaThirdApp.GuildMediaThirdAppContent";
    }

    @Override // com.tencent.mobileqq.guild.media.thirdapp.widget.g
    public void l5() {
        ki();
    }

    protected final void ni(boolean isEnd) {
        String str;
        IGProLobbyAppInfo thirdAppInfo = com.tencent.mobileqq.guild.media.core.j.a().d0().getThirdAppInfo();
        if (thirdAppInfo == null) {
            return;
        }
        if (isEnd) {
            str = "imp_end";
        } else {
            str = "imp";
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        String appId = thirdAppInfo.getAppId();
        Intrinsics.checkNotNullExpressionValue(appId, "thirdAppInfo.appId");
        hashMap.put("sgrp_appid", appId);
        String appName = thirdAppInfo.getAppName();
        Intrinsics.checkNotNullExpressionValue(appName, "thirdAppInfo.appName");
        hashMap.put("sgrp_app_name", appName);
        hashMap.put("sgrp_avchannel_app_window_status", Integer.valueOf(Qh()));
        MediaChannelUtils.f228046a.G(Sh(), "em_sgrp_avchannel_app_window", hashMap, str);
    }

    @Override // com.tencent.mobileqq.guild.media.content.GuildMediaContentFragmentBase, com.tencent.mobileqq.guild.media.content.i
    public boolean onBackEvent() {
        if (Intrinsics.areEqual(ph().b2().getValue(), Boolean.TRUE)) {
            com.tencent.mobileqq.guild.media.core.j.d().i(ThirdAppBarClickEvent.MINIMIZE_PORTRAIT);
            return true;
        }
        return false;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        Logger logger = Logger.f235387a;
        logger.d().d(Xh(), 1, "[onConfigurationChanged] ");
        wi();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Logger logger = Logger.f235387a;
        logger.d().d(Xh(), 1, "[onCreateView] ");
        View inflate = inflater.inflate(R.layout.ey7, container, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026rd_app, container, false)");
        ri(inflate);
        View findViewById = Uh().findViewById(R.id.f96715if);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R\u2026d_app_sub_view_container)");
        qi((FrameLayout) findViewById);
        View findViewById2 = Uh().findViewById(R.id.f96495hu);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R\u2026rd_app_action_bar_layout)");
        si((GuildMediaThirdAppFullScreenActionBar) findViewById2);
        Vh().setMediaMicStateViewModel(qh(), new WeakReference(this));
        if (this.mContentView != null) {
            String Xh = Xh();
            Logger.b bVar = new Logger.b();
            bVar.a().add("[onCreateView] destroyContentView");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e(Xh, 1, (String) it.next(), null);
            }
            Ph();
        }
        View Uh = Uh();
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, Uh);
        return Uh;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        Logger logger = Logger.f235387a;
        logger.d().d(Xh(), 1, "[onDestroy] ");
        mi();
        ViewGroup viewGroup = null;
        this.mShowInputCallback = null;
        Ph();
        if (this.mThirdAppViewModel != null) {
            Wh().X1();
        }
        if (this.mRootView != null) {
            View Uh = Uh();
            if (Uh instanceof ViewGroup) {
                viewGroup = (ViewGroup) Uh;
            }
            if (viewGroup != null) {
                viewGroup.removeAllViews();
            }
        }
        super.onDestroy();
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        ni(true);
        Ph();
        ui();
        super.onDestroyView();
        Logger logger = Logger.f235387a;
        logger.d().d(Xh(), 1, "[onDestroyView] ");
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ViewModel viewModel = new ViewModelProvider(this).get(nt1.c.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this)[\u2026AppViewModel::class.java]");
        ti((nt1.c) viewModel);
        Wh().init();
        li();
        wi();
        Boolean value = ph().b2().getValue();
        if (value == null) {
            value = Boolean.FALSE;
        }
        boolean booleanValue = value.booleanValue();
        Boolean value2 = ph().a2().getValue();
        if (value2 == null) {
            value2 = Boolean.FALSE;
        }
        boolean booleanValue2 = value2.booleanValue();
        if (booleanValue) {
            Vh().setOrientationIsPortrait(!booleanValue2);
        }
        oi(this, false, 1, null);
        Logger logger = Logger.f235387a;
        String Xh = Xh();
        logger.d().d(Xh, 1, "[onViewCreated] isLandView: " + booleanValue2 + ", isExpandView: " + booleanValue);
    }

    public void pi() {
        MutableLiveData<Boolean> b26 = ph().b2();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        b26.observe(viewLifecycleOwner, new m());
    }

    public final void qi(@NotNull FrameLayout frameLayout) {
        Intrinsics.checkNotNullParameter(frameLayout, "<set-?>");
        this.mContentContainerView = frameLayout;
    }

    public final void ri(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.mRootView = view;
    }

    public final void si(@NotNull GuildMediaThirdAppFullScreenActionBar guildMediaThirdAppFullScreenActionBar) {
        Intrinsics.checkNotNullParameter(guildMediaThirdAppFullScreenActionBar, "<set-?>");
        this.mThirdAppFullScreenActionBar = guildMediaThirdAppFullScreenActionBar;
    }

    @Override // com.tencent.mobileqq.guild.media.thirdapp.widget.g
    public void tg() {
        QLog.d("QGMC.MediaThirdApp.GuildMediaThirdAppContent", 1, "onThirdAppClickedZoomIn");
        MediaChannelUtils mediaChannelUtils = MediaChannelUtils.f228046a;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        if (mediaChannelUtils.j(requireActivity) == 1) {
            com.tencent.mobileqq.guild.media.core.j.d().i(ThirdAppBarClickEvent.FULL_PORTRAIT);
            com.tencent.mobileqq.guild.media.thirdapp.widget.f fVar = this.mContentView;
            if (fVar != null) {
                fVar.setPortraitFullUI();
            }
            ph().b2().postValue(Boolean.TRUE);
            Vh().setOrientationIsPortrait(true);
            return;
        }
        com.tencent.mobileqq.guild.media.core.j.d().i(ThirdAppBarClickEvent.FULL_LAND);
        ph().a2().postValue(Boolean.TRUE);
    }

    public final void ti(@NotNull nt1.c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<set-?>");
        this.mThirdAppViewModel = cVar;
    }

    public void ui() {
        if (!Intrinsics.areEqual(ph().a2().getValue(), Boolean.TRUE)) {
            com.tencent.mobileqq.guild.media.core.j.d().i(ThirdAppBarClickEvent.MINIMIZE_PORTRAIT);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void wi() {
        if (this.mContentView == null) {
            Logger.f235387a.d().i(Xh(), 1, "updateContentView: init third app content view.");
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            GuildMediaThirdAppNormalContentView guildMediaThirdAppNormalContentView = new GuildMediaThirdAppNormalContentView(requireContext);
            this.mContentView = guildMediaThirdAppNormalContentView;
            guildMediaThirdAppNormalContentView.setThirdAppClickListener(this);
            FrameLayout Sh = Sh();
            Object obj = this.mContentView;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.view.ViewGroup");
            Sh.addView((ViewGroup) obj);
            com.tencent.mobileqq.guild.media.thirdapp.widget.f fVar = this.mContentView;
            if (fVar != null) {
                fVar.c();
            }
        }
        com.tencent.mobileqq.guild.media.thirdapp.e T1 = Wh().T1();
        com.tencent.mobileqq.guild.media.thirdapp.d S1 = Wh().S1();
        if (T1 != null) {
            Logger.f235387a.d().i(Xh(), 1, "updateContentView: load third app preload info.");
            Ai();
            zi();
        } else {
            ViewGroup viewGroup = null;
            if (S1 != null) {
                Logger logger = Logger.f235387a;
                logger.d().i(Xh(), 1, "updateContentView: load third app real info.");
                Bi();
                yi();
                this.mLastMediaThirdAppInfo = S1;
                if (!this.isLoadThirdAppContent) {
                    logger.d().i(Xh(), 1, "updateContentView: reload third content view.");
                    GuildMediaWebIPCServer.INSTANCE.a().i(com.tencent.mobileqq.guild.media.core.j.a().d0().E1(), new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.media.content.thirdapp.GuildMediaThirdAppContent$updateContentView$5
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
                            f mContentView = GuildMediaThirdAppContent.this.getMContentView();
                            if (mContentView != null) {
                                mContentView.b(!z16);
                            }
                        }
                    });
                    Object obj2 = this.mContentView;
                    if (obj2 instanceof ViewGroup) {
                        viewGroup = (ViewGroup) obj2;
                    }
                    if (viewGroup != null) {
                        if (ViewCompat.isAttachedToWindow(viewGroup)) {
                            com.tencent.mobileqq.guild.media.thirdapp.d dVar = this.mLastMediaThirdAppInfo;
                            if (dVar != null) {
                                ii(dVar);
                            }
                        } else {
                            viewGroup.addOnAttachStateChangeListener(new n(viewGroup, this));
                        }
                    }
                } else {
                    UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.media.content.thirdapp.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            GuildMediaThirdAppContent.xi(GuildMediaThirdAppContent.this);
                        }
                    }, 500L);
                }
            } else {
                Logger logger2 = Logger.f235387a;
                String Xh = Xh();
                Logger.b bVar = new Logger.b();
                bVar.a().add("updateContentView: error. has not any info.");
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e(Xh, 1, (String) it.next(), null);
                }
                com.tencent.mobileqq.guild.media.thirdapp.widget.f fVar2 = this.mContentView;
                if (fVar2 != null) {
                    fVar2.b(true);
                }
            }
        }
        ContentSize Rh = Rh();
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildMediaThirdAppContent", 1, "[updateContentView] contentSize " + Rh);
        ph().l2(Rh);
    }
}
