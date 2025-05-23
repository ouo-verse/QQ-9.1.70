package com.tencent.qqnt.aio;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOContact;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.Part;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.Page;
import com.tencent.cache.api.PageHierarchy;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.aio.event.ThemeEvent;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ei;
import com.tencent.mobileqq.vas.pendant.api.IPendantManager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqnt.aio.SplashAIOFragment;
import com.tencent.qqnt.aio.activity.AIODelegate;
import com.tencent.qqnt.aio.api.IAIOAnimationApi;
import com.tencent.qqnt.aio.gallery.api.INTGalleryApi;
import com.tencent.qqnt.aio.part.SendPicPart;
import com.tencent.qqnt.aio.part.l;
import com.tencent.qqnt.aio.part.o;
import com.tencent.qqnt.aio.part.p;
import com.tencent.qqnt.aio.utils.AIOLocalActivitySwitch;
import com.tencent.qqnt.mainframe.api.IMainFrameApi;
import com.tencent.qqperf.tools.PerformanceReportUtils;
import com.tencent.richframework.preload.activity.ActivityPreloadManager;
import com.tencent.richframework.preload.activity.BaseActivityResPreloadTask;
import cooperation.qzone.QzoneIPCModule;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ce\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b*\u0006\u0084\u0001\u0088\u0001\u008c\u0001\b\u0017\u0018\u0000 \u0096\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0097\u0001B\t\u00a2\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u0017\u001a\u00020\u000eH\u0016J\b\u0010\u0018\u001a\u00020\u000eH\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0016J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u000eH\u0016J\u0012\u0010 \u001a\u00020\u000e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010!\u001a\u00020\u000eH\u0016J\b\u0010\"\u001a\u00020\u000eH\u0016J\"\u0010&\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u00132\b\u0010%\u001a\u0004\u0018\u00010\u001eH\u0016J\u0006\u0010'\u001a\u00020\u001aJ\u0006\u0010(\u001a\u00020\u000eJ\b\u0010)\u001a\u0004\u0018\u00010\nJ\b\u0010*\u001a\u00020\u000eH\u0016J\u0006\u0010+\u001a\u00020\u000eJ\u0006\u0010,\u001a\u00020\u000eJ\b\u0010-\u001a\u00020\u001aH\u0016J\b\u0010.\u001a\u00020\u001aH\u0016J\b\u0010/\u001a\u00020\u000eH\u0016J\"\u00104\u001a\u0004\u0018\u0001032\u0006\u00100\u001a\u00020\u00132\u0006\u00101\u001a\u00020\u001a2\u0006\u00102\u001a\u00020\u0013H\u0016J\b\u00105\u001a\u00020\u000eH\u0016J\b\u00107\u001a\u000206H\u0016J\u0010\u00109\u001a\n 8*\u0004\u0018\u00010\u001e0\u001eH\u0016J\b\u0010;\u001a\u00020:H\u0016J\u0010\u0010=\u001a\n 8*\u0004\u0018\u00010<0<H\u0016J\b\u0010?\u001a\u00020>H\u0016J\u0010\u0010B\u001a\u00020\u000e2\u0006\u0010A\u001a\u00020@H\u0016J\b\u0010C\u001a\u00020\u001aH\u0016J\b\u0010D\u001a\u00020\u001aH\u0016J\u0006\u0010E\u001a\u00020\u001aJ\u0010\u0010I\u001a\u00020H2\u0006\u0010G\u001a\u00020FH\u0014J\u0010\u0010J\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0012\u0010L\u001a\u00020\u000e2\b\b\u0002\u0010K\u001a\u00020\u001aH\u0002J\b\u0010M\u001a\u00020\u000eH\u0002J\b\u0010N\u001a\u00020\u000eH\u0002J\b\u0010O\u001a\u00020\u000eH\u0002J\b\u0010P\u001a\u00020\u001aH\u0002J\b\u0010Q\u001a\u00020\u000eH\u0002J\b\u0010R\u001a\u00020\u000eH\u0002J\b\u0010S\u001a\u00020\u001aH\u0002J\u0010\u0010T\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010U\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010V\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020\fH\u0002J\n\u0010W\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010X\u001a\u00020\u000eH\u0002J\b\u0010Y\u001a\u00020\u001aH\u0002J\b\u0010Z\u001a\u00020\u000eH\u0002J\b\u0010[\u001a\u00020HH\u0002R\u0016\u0010^\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010a\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010d\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010g\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010fR\u0016\u0010i\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010fR\u0018\u0010m\u001a\u0004\u0018\u00010j8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010lR\u0018\u0010p\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bn\u0010oR0\u0010u\u001a\u001e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020H0qj\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020H`r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bs\u0010tR\u0016\u0010w\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bv\u0010fR\u0016\u0010y\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bx\u0010fR\u001b\u0010\u007f\u001a\u00020z8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~R\u0018\u0010\u0083\u0001\u001a\u00030\u0080\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0018\u0010\u0087\u0001\u001a\u00030\u0084\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0018\u0010\u008b\u0001\u001a\u00030\u0088\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R\u0018\u0010\u008f\u0001\u001a\u00030\u008c\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R\u0018\u0010\u0093\u0001\u001a\u00030\u0090\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0091\u0001\u0010\u0092\u0001\u00a8\u0006\u0098\u0001"}, d2 = {"Lcom/tencent/qqnt/aio/SplashAIOFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Lcom/tencent/mobileqq/pad/g;", "Lcom/tencent/qqnt/aio/e;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "initWindowStyleAndAnimation", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "from", "d5", "onAttach", "onStart", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "", "hidden", "onHiddenChanged", "qOnNewIntent", "Landroid/content/Intent;", "intent", "onNewIntent", DKHippyEvent.EVENT_STOP, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "requestCode", QzoneIPCModule.RESULT_CODE, "data", "onActivityResult", "Bh", "Eh", "getRootView", "onAccountChanged", "Ph", "Qh", "onBackEvent", "qOnBackPressed", "onPostThemeChanged", "transit", BaseConstants.BROADCAST_USERSYNC_ENTER, "nextAnim", "Landroid/view/animation/Animation;", "onCreateAnimation", "onActivityEnterAnimationComplete", "Landroid/content/Context;", "getContext", "kotlin.jvm.PlatformType", "getIntent", "Landroidx/fragment/app/FragmentManager;", "getSupportFragmentManager", "Landroid/view/Window;", "getWindow", "Lcom/tencent/aio/data/AIOContact;", "getAIOContact", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "sendMessage", "isAttach", "isScale", "Hh", "", "type", "Lcom/tencent/qqnt/aio/activity/j;", "Ch", "Zh", "switchAnim", "Uh", "Oh", "Yh", "Th", "ai", "Mh", "Rh", "Gh", "Kh", "Ih", "Jh", "Wh", "bi", "Fh", "Sh", "Xh", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/ViewGroup;", "mRootView", "D", "Landroid/app/Activity;", "mActivity", "E", "Landroid/content/Context;", "mContext", UserInfo.SEX_FEMALE, "Z", "mNeedInitPreloadLayerTaskSwitch", "G", "mOpenLayerActivityPreload", "Lcom/tencent/richframework/preload/activity/BaseActivityResPreloadTask;", "H", "Lcom/tencent/richframework/preload/activity/BaseActivityResPreloadTask;", "mPreloadTask", "I", "Lcom/tencent/qqnt/aio/activity/j;", "mCurAIOProxy", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "J", "Ljava/util/HashMap;", "mAIOProxyMap", "K", "mCreateView", "L", "mBackToConversationTab", "Lcom/tencent/qqnt/aio/report/a;", "M", "Lkotlin/Lazy;", "Dh", "()Lcom/tencent/qqnt/aio/report/a;", "enterReport", "Lcom/tencent/qqnt/aio/a;", "N", "Lcom/tencent/qqnt/aio/a;", "aioContextWrapper", "com/tencent/qqnt/aio/SplashAIOFragment$b", "P", "Lcom/tencent/qqnt/aio/SplashAIOFragment$b;", "closeAIOAction", "com/tencent/qqnt/aio/SplashAIOFragment$c", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/qqnt/aio/SplashAIOFragment$c;", "drawerFrameScrollEvent", "com/tencent/qqnt/aio/SplashAIOFragment$d", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/qqnt/aio/SplashAIOFragment$d;", "expandFullScreenAction", "Landroid/view/animation/Animation$AnimationListener;", ExifInterface.LATITUDE_SOUTH, "Landroid/view/animation/Animation$AnimationListener;", "mExitAnimationListener", "<init>", "()V", "T", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
@Page(business = Business.AIO, type = PageHierarchy.MainPage)
/* loaded from: classes23.dex */
public class SplashAIOFragment extends QPublicBaseFragment implements com.tencent.mobileqq.pad.g, com.tencent.qqnt.aio.e {
    static IPatchRedirector $redirector_;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static boolean U;
    private static boolean V;
    private static boolean W;

    /* renamed from: C, reason: from kotlin metadata */
    private ViewGroup mRootView;

    /* renamed from: D, reason: from kotlin metadata */
    private Activity mActivity;

    /* renamed from: E, reason: from kotlin metadata */
    private Context mContext;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean mNeedInitPreloadLayerTaskSwitch;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean mOpenLayerActivityPreload;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private BaseActivityResPreloadTask mPreloadTask;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.aio.activity.j mCurAIOProxy;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final HashMap<String, com.tencent.qqnt.aio.activity.j> mAIOProxyMap;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean mCreateView;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean mBackToConversationTab;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Lazy enterReport;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final a aioContextWrapper;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final b closeAIOAction;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final c drawerFrameScrollEvent;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final d expandFullScreenAction;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final Animation.AnimationListener mExitAnimationListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0004\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/aio/SplashAIOFragment$a;", "", "", "isScaleAIOForeground", "Z", "a", "()Z", "b", "(Z)V", "", "ENABLE_PERF_KEY", "Ljava/lang/String;", "EXIT_ANIM", "", "FULL_SCREEN_DIM_AMOUNT", UserInfo.SEX_FEMALE, "SCALE_SCREEN_DIM_AMOUNT", "TAG", "setHighScreenRefreshRate", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.SplashAIOFragment$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return;
            }
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) defaultConstructorMarker);
        }

        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return SplashAIOFragment.U;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }

        public final void b(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                SplashAIOFragment.U = z16;
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/SplashAIOFragment$b", "Lcom/tencent/aio/runtime/message/b;", "Landroid/os/Bundle;", "data", "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements com.tencent.aio.runtime.message.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SplashAIOFragment.this);
            }
        }

        @Override // com.tencent.aio.runtime.message.b
        public void a(@NotNull Bundle data) {
            boolean z16;
            View aIORootView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) data);
                return;
            }
            Intrinsics.checkNotNullParameter(data, "data");
            QLog.d("SplashAIOFragment", 1, "receive closeAction");
            com.tencent.qqnt.aio.activity.j jVar = SplashAIOFragment.this.mCurAIOProxy;
            if (jVar != null && jVar.c()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 || data.getBoolean("key_force_close_aio", false)) {
                com.tencent.qqnt.aio.activity.j jVar2 = SplashAIOFragment.this.mCurAIOProxy;
                if (jVar2 != null && (aIORootView = jVar2.getAIORootView()) != null) {
                    com.tencent.mobileqq.aio.utils.b.f194119a.d(aIORootView, data);
                }
                if (SplashAIOFragment.this.mBackToConversationTab) {
                    Activity activity = SplashAIOFragment.this.mActivity;
                    Activity activity2 = null;
                    if (activity == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mActivity");
                        activity = null;
                    }
                    activity.finish();
                    IMainFrameApi iMainFrameApi = (IMainFrameApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IMainFrameApi.class);
                    Activity activity3 = SplashAIOFragment.this.mActivity;
                    if (activity3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mActivity");
                    } else {
                        activity2 = activity3;
                    }
                    iMainFrameApi.toMainMsgList(activity2);
                    return;
                }
                SplashAIOFragment.this.Uh(data.getBoolean(SplashActivity.SWITCH_ANIM, true));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/SplashAIOFragment$c", "Lcom/tencent/aio/runtime/message/b;", "Landroid/os/Bundle;", "data", "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class c implements com.tencent.aio.runtime.message.b {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SplashAIOFragment.this);
            }
        }

        @Override // com.tencent.aio.runtime.message.b
        public void a(@NotNull Bundle data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) data);
                return;
            }
            Intrinsics.checkNotNullParameter(data, "data");
            if (!SplashAIOFragment.this.Hh()) {
                return;
            }
            com.tencent.qqnt.aio.drawer.a aVar = com.tencent.qqnt.aio.drawer.a.f349869a;
            int i3 = data.getInt(aVar.b(), -1);
            int i16 = data.getInt(aVar.a(), -1);
            if (i3 != -1 && i16 != -1) {
                if (i3 == 0) {
                    QLog.i("SplashAIOFragment", 1, "[onReceive] frame drawer close.");
                    SplashAIOFragment.INSTANCE.b(true);
                } else if (i16 == 0) {
                    QLog.i("SplashAIOFragment", 1, "[onReceive] frame drawer open.");
                    SplashAIOFragment.INSTANCE.b(false);
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/SplashAIOFragment$d", "Lcom/tencent/aio/runtime/message/b;", "Landroid/os/Bundle;", "data", "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class d implements com.tencent.aio.runtime.message.b {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SplashAIOFragment.this);
            }
        }

        @Override // com.tencent.aio.runtime.message.b
        public void a(@NotNull Bundle data) {
            Drawable drawable;
            Intent intent;
            Intent intent2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) data);
                return;
            }
            Intrinsics.checkNotNullParameter(data, "data");
            if (!SplashAIOFragment.this.isScale()) {
                QLog.d("SplashAIOFragment", 1, "[onReceive] current not is scale.");
                return;
            }
            QLog.d("SplashAIOFragment", 1, "[onReceive] zoom in .");
            FragmentActivity activity = SplashAIOFragment.this.getActivity();
            if (activity != null && (intent2 = activity.getIntent()) != null) {
                intent2.putExtra("key_is_scale_chat", false);
            }
            FragmentActivity activity2 = SplashAIOFragment.this.getActivity();
            if (activity2 != null && (intent = activity2.getIntent()) != null) {
                intent.putExtra("key_is_expand_full_chat", true);
            }
            FragmentActivity activity3 = SplashAIOFragment.this.getActivity();
            if (activity3 != null) {
                Window window = activity3.getWindow();
                window.clearFlags(2);
                window.setDimAmount(1.0f);
                if ((activity3 instanceof QBaseActivity) && !(activity3 instanceof SplashActivity)) {
                    SystemBarActivityModule.setImmersiveStatus((QBaseActivity) activity3);
                }
            }
            SplashAIOFragment.this.mBackToConversationTab = true;
            View rootView = SplashAIOFragment.this.getRootView();
            if (rootView != null) {
                drawable = rootView.getBackground();
            } else {
                drawable = null;
            }
            if (drawable == null && rootView != null) {
                j.b(rootView, SplashAIOFragment.this.isScale());
            }
            com.tencent.qqnt.aio.activity.j jVar = SplashAIOFragment.this.mCurAIOProxy;
            if (jVar != null) {
                jVar.g(103);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/aio/SplashAIOFragment$e", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationRepeat", "onAnimationEnd", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class e implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SplashAIOFragment.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(SplashAIOFragment this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            com.tencent.qqnt.aio.activity.j jVar = this$0.mCurAIOProxy;
            if (jVar != null) {
                jVar.hide();
            }
            com.tencent.qqnt.aio.activity.j jVar2 = this$0.mCurAIOProxy;
            if (jVar2 != null) {
                jVar2.g(102);
            }
            IAIOAnimationApi iAIOAnimationApi = (IAIOAnimationApi) QRoute.api(IAIOAnimationApi.class);
            Context context = this$0.mActivity;
            FragmentActivity fragmentActivity = null;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mActivity");
                context = null;
            }
            if (context instanceof FragmentActivity) {
                fragmentActivity = (FragmentActivity) context;
            }
            iAIOAnimationApi.onAIOAnimationEnd(fragmentActivity, IAIOAnimationApi.AnimationScene.AIO_EXIT);
            ((IPendantManager) QRoute.api(IPendantManager.class)).resume();
            QUIImmersiveHelper.u(this$0.getWindow(), true, true);
            this$0.Rh();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@NotNull Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
                return;
            }
            Intrinsics.checkNotNullParameter(animation, "animation");
            QLog.d("SplashAIOFragment", 1, "AIO onAnimationEnd");
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final SplashAIOFragment splashAIOFragment = SplashAIOFragment.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.qqnt.aio.h
                @Override // java.lang.Runnable
                public final void run() {
                    SplashAIOFragment.e.b(SplashAIOFragment.this);
                }
            });
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@NotNull Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            } else {
                Intrinsics.checkNotNullParameter(animation, "animation");
                QLog.d("SplashAIOFragment", 2, "AIO onAnimationRepeat");
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@NotNull Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            } else {
                Intrinsics.checkNotNullParameter(animation, "animation");
                SplashAIOFragment.this.Oh();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/aio/SplashAIOFragment$f", "Lcom/tencent/mobileqq/anim/aio/a;", "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class f implements com.tencent.mobileqq.anim.aio.a {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SplashAIOFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.anim.aio.a
        public boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                com.tencent.qqnt.aio.activity.j jVar = SplashAIOFragment.this.mCurAIOProxy;
                if (jVar != null) {
                    return jVar.f();
                }
                return false;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/aio/SplashAIOFragment$g", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class g implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SplashAIOFragment.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b() {
            com.tencent.qqperf.opt.threadpriority.b.k(false);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@Nullable Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                SplashAIOFragment.this.Mh();
                ((IPendantManager) QRoute.api(IPendantManager.class)).resume();
                ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.qqnt.aio.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        SplashAIOFragment.g.b();
                    }
                }, 200L);
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@Nullable Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@Nullable Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
                return;
            }
            IAIOAnimationApi iAIOAnimationApi = (IAIOAnimationApi) QRoute.api(IAIOAnimationApi.class);
            Context context = SplashAIOFragment.this.mActivity;
            FragmentActivity fragmentActivity = null;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mActivity");
                context = null;
            }
            if (context instanceof FragmentActivity) {
                fragmentActivity = (FragmentActivity) context;
            }
            iAIOAnimationApi.onAIOAnimationStart(fragmentActivity, IAIOAnimationApi.AnimationScene.AIO_ENTER);
            ((IPendantManager) QRoute.api(IPendantManager.class)).pause();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63282);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 37)) {
            redirector.redirect((short) 37);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public SplashAIOFragment() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        QLog.i("SplashAIOFragment", 1, "SplashAIOFragment init hashCode= " + hashCode());
        this.mNeedInitPreloadLayerTaskSwitch = true;
        this.mAIOProxyMap = new HashMap<>();
        lazy = LazyKt__LazyJVMKt.lazy(SplashAIOFragment$enterReport$2.INSTANCE);
        this.enterReport = lazy;
        this.aioContextWrapper = new a(this);
        this.closeAIOAction = new b();
        this.drawerFrameScrollEvent = new c();
        this.expandFullScreenAction = new d();
        this.mExitAnimationListener = new e();
    }

    private final com.tencent.qqnt.aio.report.a Dh() {
        return (com.tencent.qqnt.aio.report.a) this.enterReport.getValue();
    }

    private final boolean Fh() {
        String stringExtra = getIntent().getStringExtra("key_peerId");
        long longExtra = getIntent().getLongExtra("key_peerUin", 0L);
        if (stringExtra == null && longExtra == 0) {
            return false;
        }
        return true;
    }

    private final boolean Gh() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        return from.decodeBool("enable_aio_frame_perf", false);
    }

    private final boolean Ih(Activity activity) {
        Intent intent = activity.getIntent();
        if (intent == null) {
            return false;
        }
        return intent.getBooleanExtra("key_is_expand_full_chat", false);
    }

    private final boolean Jh(Activity activity) {
        Intent intent = activity.getIntent();
        if (intent == null) {
            return false;
        }
        return intent.getBooleanExtra("key_is_miniaio", false);
    }

    private final boolean Kh(Activity activity) {
        Intent intent = activity.getIntent();
        if (intent == null) {
            return false;
        }
        return intent.getBooleanExtra("key_is_scale_chat", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Lh() {
        com.tencent.qqperf.opt.threadpriority.b.k(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Mh() {
        FragmentActivity fragmentActivity;
        Th();
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.qqnt.aio.g
            @Override // java.lang.Runnable
            public final void run() {
                SplashAIOFragment.Nh(SplashAIOFragment.this);
            }
        }, 50L);
        Rh();
        IAIOAnimationApi iAIOAnimationApi = (IAIOAnimationApi) QRoute.api(IAIOAnimationApi.class);
        Activity Wh = Wh();
        if (Wh instanceof FragmentActivity) {
            fragmentActivity = (FragmentActivity) Wh;
        } else {
            fragmentActivity = null;
        }
        iAIOAnimationApi.onAIOAnimationEnd(fragmentActivity, IAIOAnimationApi.AnimationScene.AIO_ENTER);
        com.tencent.qqnt.aio.activity.j jVar = this.mCurAIOProxy;
        if (jVar != null) {
            jVar.g(102);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nh(SplashAIOFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QUIImmersiveHelper.u(this$0.getWindow(), true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Oh() {
        QLog.d("SplashAIOFragment", 2, "[onExitAnimationStart]");
        IAIOAnimationApi iAIOAnimationApi = (IAIOAnimationApi) QRoute.api(IAIOAnimationApi.class);
        Context context = this.mActivity;
        FragmentActivity fragmentActivity = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivity");
            context = null;
        }
        if (context instanceof FragmentActivity) {
            fragmentActivity = (FragmentActivity) context;
        }
        iAIOAnimationApi.onAIOAnimationStart(fragmentActivity, IAIOAnimationApi.AnimationScene.AIO_EXIT);
        ((IPendantManager) QRoute.api(IPendantManager.class)).pause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Rh() {
        if (this.mNeedInitPreloadLayerTaskSwitch) {
            boolean z16 = false;
            this.mNeedInitPreloadLayerTaskSwitch = false;
            if (Build.VERSION.SDK_INT >= 29 && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("open_layer_preload", true)) {
                z16 = true;
            }
            this.mOpenLayerActivityPreload = z16;
        }
        if (this.mOpenLayerActivityPreload) {
            if (this.mPreloadTask == null) {
                this.mPreloadTask = ((INTGalleryApi) QRoute.api(INTGalleryApi.class)).getNTAIOLayerActivityPreloadTask();
            }
            ActivityPreloadManager activityPreloadManager = ActivityPreloadManager.INSTANCE;
            BaseActivityResPreloadTask baseActivityResPreloadTask = this.mPreloadTask;
            Intrinsics.checkNotNull(baseActivityResPreloadTask);
            activityPreloadManager.addPreloadTask(baseActivityResPreloadTask);
        }
    }

    private final void Sh() {
        Activity Wh = Wh();
        if (Wh != null && Kh(Wh)) {
            getIntent().getStringExtra("key_peerId");
            long longExtra = getIntent().getLongExtra("key_peerUin", 0L);
            int intExtra = getIntent().getIntExtra("key_chat_type", -1);
            v61.b.a().e(Wh);
            v61.b.a().d(v61.a.a(Wh.getClass(), String.valueOf(longExtra), intExtra, true));
        }
    }

    private final void Th() {
        if (ai()) {
            getWindow().getDecorView().setBackground(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Uh(boolean switchAnim) {
        Activity activity = this.mActivity;
        Activity activity2 = null;
        if (activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivity");
            activity = null;
        }
        if (activity instanceof SplashActivity) {
            Intent intent = new Intent();
            intent.putExtra(SplashActivity.SWITCH_ANIM, switchAnim);
            Activity activity3 = this.mActivity;
            if (activity3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mActivity");
                activity3 = null;
            }
            Intent intent2 = activity3.getIntent();
            if (intent2 != null) {
                intent2.putExtra("isFromAioFragment", true);
            }
            Activity activity4 = this.mActivity;
            if (activity4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mActivity");
                activity4 = null;
            }
            FragmentManager supportFragmentManager = ((BaseActivity) activity4).getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "mActivity as BaseActivity).supportFragmentManager");
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "fragmentManager.beginTransaction()");
            if (supportFragmentManager.findFragmentByTag(MainFragment.class.getName()) == null) {
                SplashActivity.currentFragment = 1;
                MainFragment.Sj(false).mPendingIntent = intent;
                if (switchAnim) {
                    beginTransaction.setCustomAnimations(R.anim.f154567be, R.anim.f154563bb);
                }
                beginTransaction.add(R.id.vea, MainFragment.Sj(true), MainFragment.class.getName());
                beginTransaction.hide(this);
                beginTransaction.commitAllowingStateLoss();
                QLog.i("SplashAIOFragment", 1, "returnMainFragment mainFragment==null");
            } else {
                Activity activity5 = this.mActivity;
                if (activity5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mActivity");
                } else {
                    activity2 = activity5;
                }
                ((SplashActivity) activity2).openMainFragment(intent);
            }
            if (Dh().e()) {
                Dh().f(true);
            }
            com.tencent.qqnt.aio.activity.j jVar = this.mCurAIOProxy;
            if (jVar != null) {
                jVar.g(101);
                return;
            }
            return;
        }
        Activity activity6 = this.mActivity;
        if (activity6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivity");
        } else {
            activity2 = activity6;
        }
        activity2.finish();
    }

    static /* synthetic */ void Vh(SplashAIOFragment splashAIOFragment, boolean z16, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                z16 = true;
            }
            splashAIOFragment.Uh(z16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: returnMainFragment");
    }

    private final Activity Wh() {
        Activity activity = this.mActivity;
        if (activity == null) {
            return null;
        }
        if (activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivity");
            return null;
        }
        return activity;
    }

    private final com.tencent.qqnt.aio.activity.j Xh() {
        if (!AIOLocalActivitySwitch.f352244a.a()) {
            return Ch("type_normal");
        }
        if (MobileQQ.sMobileQQ.peekAppRuntime() != null && (Wh() instanceof SplashActivity)) {
            if (com.tencent.qqnt.aio.palette.b.f351744a.b(new com.tencent.qqnt.aio.palette.a(getIntent().getIntExtra("key_chat_type", 0), getIntent().getExtras()))) {
                return Ch("type_local_activity");
            }
        }
        return Ch("type_normal");
    }

    private final void Yh() {
        if (ai()) {
            getWindow().getDecorView().setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.qui_common_bg_primary_bg, null));
        }
    }

    private final void Zh(Activity activity) {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("splash_enable_high_screen_refresh_rate", true)) {
            QLog.i("SplashAIOFragment", 1, "[setHighScreenRefreshRate] switch is off");
            return;
        }
        QLog.i("SplashAIOFragment", 1, "screen refresh rate current: " + ScreenUtil.getCurrentScreenRefreshRate(activity) + " max: " + ScreenUtil.getMaxRefreshRate());
        ScreenUtil.useHighScreenRefreshRate(activity);
    }

    private final boolean ai() {
        return Wh() instanceof SplashActivity;
    }

    private final void bi() {
        ViewGroup viewGroup;
        Drawable drawable;
        BaseAIOUtils.d(getIntent().getStringExtra("key_peerId"));
        com.tencent.qqnt.aio.activity.j Xh = Xh();
        com.tencent.qqnt.aio.activity.j jVar = this.mCurAIOProxy;
        if (jVar != null && !Intrinsics.areEqual(Xh, jVar) && jVar.e()) {
            QLog.i("SplashAIOFragment", 1, "[startAIO]: aioProxy change and curProxy is show, then hide curProxy");
            jVar.hide();
        }
        View show = Xh.show();
        Xh.h("close_aio", this.closeAIOAction);
        Xh.h("expand_full_screen", this.expandFullScreenAction);
        Xh.h("drawer_frame_scroll_event", this.drawerFrameScrollEvent);
        ViewGroup viewGroup2 = null;
        if (Fh()) {
            if (Dh().e()) {
                Dh().f(false);
                Xh.b(true);
            }
            Yh();
            Sh();
            Xh.g(101);
            View rootView = getRootView();
            if (rootView != null) {
                drawable = rootView.getBackground();
            } else {
                drawable = null;
            }
            if (drawable == null && rootView != null) {
                j.b(rootView, isScale());
            }
        } else {
            com.tencent.qqnt.aio.palette.f.f351749a.c();
        }
        this.mCurAIOProxy = Xh;
        ViewGroup viewGroup3 = this.mRootView;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            viewGroup3 = null;
        }
        if (viewGroup3.indexOfChild(show) < 0) {
            ViewGroup viewGroup4 = this.mRootView;
            if (viewGroup4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                viewGroup4 = null;
            }
            viewGroup4.removeAllViews();
            ViewParent parent = show.getParent();
            if (parent instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent;
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                viewGroup.removeAllViews();
            }
            ViewGroup viewGroup5 = this.mRootView;
            if (viewGroup5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            } else {
                viewGroup2 = viewGroup5;
            }
            viewGroup2.addView(show);
        }
    }

    public final boolean Bh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        Activity activity = this.mActivity;
        if (activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivity");
            activity = null;
        }
        if ((activity instanceof SplashActivity) && SplashActivity.currentFragment == 1) {
            return true;
        }
        return false;
    }

    @NotNull
    protected com.tencent.qqnt.aio.activity.j Ch(@NotNull String type) {
        com.tencent.qqnt.aio.activity.j aIODelegate;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (com.tencent.qqnt.aio.activity.j) iPatchRedirector.redirect((short) 36, (Object) this, (Object) type);
        }
        Intrinsics.checkNotNullParameter(type, "type");
        com.tencent.qqnt.aio.activity.j jVar = this.mAIOProxyMap.get(type);
        if (jVar != null) {
            return jVar;
        }
        if (Intrinsics.areEqual(type, "type_local_activity")) {
            aIODelegate = new com.tencent.qqnt.aio.c(this);
        } else {
            aIODelegate = new AIODelegate(this, "SplashAIOFragment");
            aIODelegate.b(Gh());
        }
        this.mAIOProxyMap.put(type, aIODelegate);
        return aIODelegate;
    }

    public final void Eh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        if (isVisible()) {
            FragmentManager fragmentManager = getFragmentManager();
            Intrinsics.checkNotNull(fragmentManager);
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "fm!!.beginTransaction()");
            beginTransaction.hide(this);
            beginTransaction.commitAllowingStateLoss();
            String str = null;
            ei.a("AIO_preLoad_Cost", null);
            long uptimeMillis = SystemClock.uptimeMillis() - com.tencent.mobileqq.activity.aio.c.f178327m;
            Context context = this.mContext;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                context = null;
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                str = peekAppRuntime.getCurrentAccountUin();
            }
            PerformanceReportUtils.j(context, str, 10, uptimeMillis);
            if (QLog.isColorLevel()) {
                QLog.d("SplashAIOFragment", 2, "AIO preLoad cost:" + uptimeMillis);
            }
        }
    }

    public final boolean Hh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Boolean) iPatchRedirector.redirect((short) 35, (Object) this)).booleanValue();
        }
        Activity Wh = Wh();
        if (Wh != null) {
            return Ih(Wh);
        }
        return false;
    }

    public final void Ph() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        }
    }

    public final void Qh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new com.tencent.qqnt.aio.part.e(this.aioContextWrapper), new l(this.aioContextWrapper), new com.tencent.qqnt.aio.part.a(this.aioContextWrapper), new SendPicPart(this.aioContextWrapper), new com.tencent.qqnt.aio.part.j(this.aioContextWrapper), new com.tencent.qqnt.aio.part.f(this.aioContextWrapper), new com.tencent.qqnt.aio.part.i(this.aioContextWrapper), new com.tencent.qqnt.aio.part.g(this.aioContextWrapper), new o(this.aioContextWrapper), new com.tencent.qqnt.aio.part.h(this.aioContextWrapper), new p(this.aioContextWrapper), new com.tencent.qqnt.aio.part.b(), new com.tencent.qqnt.aio.part.d(this.aioContextWrapper), new com.tencent.qqnt.aio.part.c(this.aioContextWrapper));
            return mutableListOf;
        }
        return (List) iPatchRedirector.redirect((short) 4, (Object) this);
    }

    @Override // com.tencent.mobileqq.pad.g
    public void d5(int from) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, from);
        }
    }

    @Override // com.tencent.qqnt.aio.e
    @NotNull
    public AIOContact getAIOContact() {
        AIOContact aIOContact;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (AIOContact) iPatchRedirector.redirect((short) 31, (Object) this);
        }
        com.tencent.qqnt.aio.activity.j jVar = this.mCurAIOProxy;
        if (jVar == null || (aIOContact = jVar.getAIOContact()) == null) {
            return new AIOContact(0, "", "", null, 8, null);
        }
        return aIOContact;
    }

    @Override // androidx.fragment.app.Fragment, com.tencent.qqnt.aio.e
    @NotNull
    public Context getContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (Context) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        Context context = this.mContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            return null;
        }
        return context;
    }

    @Override // com.tencent.qqnt.aio.e
    public Intent getIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (Intent) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        Activity activity = this.mActivity;
        if (activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivity");
            activity = null;
        }
        return activity.getIntent();
    }

    @Nullable
    public final View getRootView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (View) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        ViewGroup viewGroup = this.mRootView;
        if (viewGroup == null) {
            return null;
        }
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            viewGroup = null;
        }
        return viewGroup;
    }

    @Override // com.tencent.qqnt.aio.e
    @NotNull
    public FragmentManager getSupportFragmentManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (FragmentManager) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        return childFragmentManager;
    }

    @Override // com.tencent.qqnt.aio.e
    public Window getWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (Window) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        Activity activity = this.mActivity;
        if (activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivity");
            activity = null;
        }
        return activity.getWindow();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(@NotNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.initWindowStyleAndAnimation(activity);
        if ((activity instanceof QBaseActivity) && !(activity instanceof SplashActivity)) {
            SystemBarActivityModule.setImmersiveStatus((QBaseActivity) activity, 0);
        }
        if (Kh(activity)) {
            Window window = activity.getWindow();
            window.addFlags(2);
            window.setDimAmount(0.5f);
        }
    }

    @Override // com.tencent.qqnt.aio.e
    public boolean isAttach() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this)).booleanValue();
        }
        return isAdded();
    }

    @Override // com.tencent.qqnt.aio.e
    public boolean isScale() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Boolean) iPatchRedirector.redirect((short) 34, (Object) this)).booleanValue();
        }
        Activity Wh = Wh();
        if (Wh != null) {
            return Kh(Wh);
        }
        QLog.i("SplashAIOFragment", 1, "[isScale]: not attach to activity");
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment
    public void onAccountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment
    public void onActivityEnterAnimationComplete() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        QLog.i("SplashAIOFragment", 1, "onActivityEnterAnimationComplete");
        super.onActivityEnterAnimationComplete();
        Mh();
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.qqnt.aio.f
            @Override // java.lang.Runnable
            public final void run() {
                SplashAIOFragment.Lh();
            }
        }, 200L);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
        com.tencent.qqnt.aio.activity.j jVar = this.mCurAIOProxy;
        if (jVar != null) {
            jVar.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NotNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        QLog.d("SplashAIOFragment", 1, "onAttach");
        super.onAttach(activity);
        this.mActivity = activity;
        this.mContext = activity;
        if (!W) {
            W = true;
            Zh(activity);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        if (!getIntent().getBooleanExtra("key_is_scale_chat", true)) {
            Activity Wh = Wh();
            if (qOnBackPressed()) {
                return true;
            }
            if (Wh != null) {
                ((IMainFrameApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IMainFrameApi.class)).toMainMsgList(Wh);
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        FragmentActivity fragmentActivity;
        IAIOAnimationApi.AnimationScene animationScene;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (Animation) iPatchRedirector.redirect((short) 25, this, Integer.valueOf(transit), Boolean.valueOf(enter), Integer.valueOf(nextAnim));
        }
        if (nextAnim == 0) {
            IAIOAnimationApi iAIOAnimationApi = (IAIOAnimationApi) QRoute.api(IAIOAnimationApi.class);
            Activity Wh = Wh();
            if (Wh instanceof FragmentActivity) {
                fragmentActivity = (FragmentActivity) Wh;
            } else {
                fragmentActivity = null;
            }
            if (enter) {
                animationScene = IAIOAnimationApi.AnimationScene.AIO_ENTER;
            } else {
                animationScene = IAIOAnimationApi.AnimationScene.AIO_EXIT;
            }
            iAIOAnimationApi.onAIOAnimationEnd(fragmentActivity, animationScene);
            return null;
        }
        if (nextAnim == R.anim.f154445lb) {
            com.tencent.mobileqq.anim.aio.f fVar = com.tencent.mobileqq.anim.aio.f.f194321a;
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            Animation b16 = fVar.b(requireContext, new f());
            b16.setAnimationListener(new g());
            return b16;
        }
        com.tencent.mobileqq.anim.aio.f fVar2 = com.tencent.mobileqq.anim.aio.f.f194321a;
        Context requireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
        Animation c16 = fVar2.c(requireContext2);
        c16.setAnimationListener(this.mExitAnimationListener);
        return c16;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            view = (View) iPatchRedirector.redirect((short) 2, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            QLog.d("SplashAIOFragment", 1, "onCreateView");
            com.tencent.qqnt.trace.a.f362326a.e("AIO_FRAGMENT_ON_CREATE");
            FrameLayout frameLayout = new FrameLayout(inflater.getContext());
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.mRootView = frameLayout;
            bi();
            this.mCreateView = true;
            view = this.mRootView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                view = null;
            }
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        QLog.d("SplashAIOFragment", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        super.onDestroy();
        Collection<com.tencent.qqnt.aio.activity.j> values = this.mAIOProxyMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "mAIOProxyMap.values");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            ((com.tencent.qqnt.aio.activity.j) it.next()).d(5);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, hidden);
            return;
        }
        super.onHiddenChanged(hidden);
        if (hidden) {
            Bundle arguments = getArguments();
            boolean z16 = false;
            if (arguments != null) {
                z16 = arguments.getBoolean("exit_anim", false);
            }
            QLog.i("SplashAIOFragment", 1, "[onHiddenChanged]: exitAnim " + z16);
            if (!z16) {
                QLog.i("SplashAIOFragment", 1, "[onHiddenChanged]: aioDelegateHide");
                com.tencent.qqnt.aio.activity.j jVar = this.mCurAIOProxy;
                if (jVar != null) {
                    jVar.hide();
                }
                Bundle arguments2 = getArguments();
                if (arguments2 != null) {
                    arguments2.remove("exit_anim");
                }
            }
        }
        QLog.d("SplashAIOFragment", 1, "onHiddenChanged " + hidden);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(@Nullable Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) intent);
            return;
        }
        QLog.d("SplashAIOFragment", 1, "onNewIntent");
        super.onNewIntent(intent);
        if (intent != null) {
            Iterator<T> it = assembleParts().iterator();
            while (it.hasNext()) {
                ((Part) it.next()).onNewIntent(intent);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0060, code lost:
    
        if (Ih(r0) != false) goto L18;
     */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        QLog.d("SplashAIOFragment", 1, "[onPause]: hashCode is " + hashCode() + " uid is " + getAIOContact().j());
        super.onPause();
        Activity activity = this.mActivity;
        Activity activity2 = null;
        if (activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivity");
            activity = null;
        }
        if (!Kh(activity)) {
            Activity activity3 = this.mActivity;
            if (activity3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mActivity");
                activity3 = null;
            }
        }
        U = false;
        Activity activity4 = this.mActivity;
        if (activity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivity");
        } else {
            activity2 = activity4;
        }
        if (Jh(activity2)) {
            V = false;
        }
        com.tencent.qqnt.aio.activity.j jVar = this.mCurAIOProxy;
        if (jVar != null) {
            jVar.d(3);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        com.tencent.qqnt.aio.activity.j jVar = this.mCurAIOProxy;
        if (jVar != null) {
            jVar.a(ThemeEvent.PostThemeChanged.f188712d);
        }
        com.tencent.qqnt.aio.activity.j jVar2 = this.mCurAIOProxy;
        if (jVar2 != null) {
            jVar2.clearAIOCache();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0072, code lost:
    
        if (Ih(r0) != false) goto L22;
     */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onResume();
        boolean Bh = Bh();
        QLog.d("SplashAIOFragment", 1, "[onResume]: hashCode is " + hashCode() + " fragmentState is " + Bh + " uid is " + getAIOContact().j());
        if (Bh) {
            Eh();
            return;
        }
        Activity activity = this.mActivity;
        Activity activity2 = null;
        if (activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivity");
            activity = null;
        }
        if (!Kh(activity)) {
            Activity activity3 = this.mActivity;
            if (activity3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mActivity");
                activity3 = null;
            }
        }
        U = true;
        Activity activity4 = this.mActivity;
        if (activity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActivity");
        } else {
            activity2 = activity4;
        }
        if (Jh(activity2)) {
            V = true;
        }
        com.tencent.qqnt.aio.activity.j jVar = this.mCurAIOProxy;
        if (jVar != null) {
            jVar.d(2);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        QLog.d("SplashAIOFragment", 1, "[onStart]: hashCode is " + hashCode() + ", uid is " + getAIOContact().j());
        super.onStart();
        com.tencent.qqnt.aio.activity.j jVar = this.mCurAIOProxy;
        if (jVar != null) {
            jVar.d(1);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        QLog.d("SplashAIOFragment", 1, DKHippyEvent.EVENT_STOP);
        super.onStop();
        com.tencent.qqnt.aio.activity.j jVar = this.mCurAIOProxy;
        if (jVar != null) {
            jVar.d(4);
        }
    }

    @Override // com.tencent.mobileqq.pad.f
    public boolean qOnBackPressed() {
        boolean z16;
        View aIORootView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        QLog.d("SplashAIOFragment", 1, "qOnBackPressed");
        boolean isVisible = isVisible();
        com.tencent.qqnt.aio.activity.j jVar = this.mCurAIOProxy;
        if (jVar != null && jVar.c()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!(isVisible & (!z16))) {
            return true;
        }
        com.tencent.qqnt.aio.activity.j jVar2 = this.mCurAIOProxy;
        if (jVar2 != null && (aIORootView = jVar2.getAIORootView()) != null) {
            com.tencent.mobileqq.aio.utils.b bVar = com.tencent.mobileqq.aio.utils.b.f194119a;
            Bundle bundle = new Bundle();
            bundle.putString("aio_disappear_type", "2");
            Unit unit = Unit.INSTANCE;
            bVar.d(aIORootView, bundle);
        }
        Vh(this, false, 1, null);
        return false;
    }

    @Override // com.tencent.mobileqq.pad.f
    public void qOnNewIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        QLog.d("SplashAIOFragment", 1, "qOnNewIntent");
        if (!this.mCreateView) {
            QLog.i("SplashAIOFragment", 1, "[qOnNewIntent]: not complete createView");
        } else {
            com.tencent.qqnt.trace.a.f362326a.e("AIO_FRAGMENT_ON_NEW_INTENT");
            bi();
        }
    }

    @Override // com.tencent.qqnt.aio.e
    public void sendMessage(@NotNull MsgIntent msgIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) msgIntent);
            return;
        }
        Intrinsics.checkNotNullParameter(msgIntent, "msgIntent");
        com.tencent.qqnt.aio.activity.j jVar = this.mCurAIOProxy;
        if (jVar != null) {
            jVar.a(msgIntent);
        }
    }
}
