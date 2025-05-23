package com.tencent.mobileqq.springhb.main;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.springhb.api.ISpringLoongCardApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.util.InputMethodUtil;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bI\u0010JJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\u0010\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u001c\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00112\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u0007H\u0002J\b\u0010\u0014\u001a\u00020\u0007H\u0002J\b\u0010\u0015\u001a\u00020\u0007H\u0002J\b\u0010\u0016\u001a\u00020\u0007H\u0002J\u0018\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J6\u0010 \u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002J\u0010\u0010#\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020!H\u0007J\u0016\u0010$\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0004J:\u0010'\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\u0006\u0010&\u001a\u00020%2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eR\u001e\u0010+\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010.R\"\u00108\u001a\u00020%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0014\u0010;\u001a\u0002098\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b \u0010:R\u0018\u0010>\u001a\u0004\u0018\u00010<8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010=R\u0014\u0010@\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010:R\u0017\u0010E\u001a\u00020A8\u0006\u00a2\u0006\f\n\u0004\b4\u0010B\u001a\u0004\bC\u0010DR\u0014\u0010H\u001a\u00020F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010G\u00a8\u0006K"}, d2 = {"Lcom/tencent/mobileqq/springhb/main/SpringToMainHelper;", "", "Landroid/content/Context;", "context", "", WadlProxyConsts.KEY_JUMP_URL, "fromSrc", "", "k", "schemeUrl", "l", "j", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/animation/Animation;", "animation", "u", "", DomainData.DOMAIN_NAME, "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "g", "r", "Landroid/content/Intent;", "intent", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "url", "", "from", "keyword", "Landroid/os/Bundle;", "extras", "f", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "o", "w", "", "needAnimation", HippyTKDListViewAdapter.X, "Lmqq/util/WeakReference;", "b", "Lmqq/util/WeakReference;", "mLoadingViewContainer", "", "c", "J", "addLoadingViewTime", "d", "gLastLoadToolsProcessTime", "e", "Z", "i", "()Z", "t", "(Z)V", "isLoadingShow", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "gIsLoaded", "Lcom/tencent/mobileqq/springhb/main/SpringHbVideoView;", "Lcom/tencent/mobileqq/springhb/main/SpringHbVideoView;", "gSpringHbVideoViewCache", tl.h.F, "mReceiverRegistered", "Landroid/content/BroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "getMReceiver", "()Landroid/content/BroadcastReceiver;", "mReceiver", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "removeLoadingViewRunnable", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SpringToMainHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final SpringToMainHelper f289366a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static WeakReference<ViewGroup> mLoadingViewContainer;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static long addLoadingViewTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static volatile long gLastLoadToolsProcessTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static boolean isLoadingShow;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static final AtomicBoolean gIsLoaded;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @Nullable
    public static volatile SpringHbVideoView gSpringHbVideoViewCache;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final AtomicBoolean mReceiverRegistered;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final BroadcastReceiver mReceiver;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Runnable removeLoadingViewRunnable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/springhb/main/SpringToMainHelper$a", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class a implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f289376d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Intent f289377e;

        a(Context context, Intent intent) {
            this.f289376d = context;
            this.f289377e = intent;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) intent);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@Nullable Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                SpringToMainHelper.f289366a.m(this.f289376d, this.f289377e);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@Nullable Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@Nullable Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61147);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        f289366a = new SpringToMainHelper();
        gIsLoaded = new AtomicBoolean(false);
        mReceiverRegistered = new AtomicBoolean(false);
        mReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.springhb.main.SpringToMainHelper$mReceiver$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(@NotNull Context context, @NotNull Intent intent) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                    return;
                }
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                String action = intent.getAction();
                if (action != null && action.hashCode() == 1859329829 && action.equals("action_spring_close_tool_loading")) {
                    SpringToMainHelper.f289366a.g();
                }
                QLog.i("SpringToMainHelper", 2, "onReceive: action:" + intent.getAction());
            }
        };
        removeLoadingViewRunnable = new Runnable() { // from class: com.tencent.mobileqq.springhb.main.s
            @Override // java.lang.Runnable
            public final void run() {
                SpringToMainHelper.s();
            }
        };
    }

    SpringToMainHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final Intent f(Context context, String url, int from, String keyword, Bundle extras) {
        Intent intent = new Intent(context, (Class<?>) QQTranslucentBrowserActivity.class);
        intent.putExtra("url", url);
        intent.putExtra("injectrecommend", true);
        intent.putExtra("fragmentClass", SpringHbTranslucentWebViewFragment.class);
        intent.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, true);
        intent.putExtra("spring_play_video_type", 16);
        intent.putExtra("spring_from_type", from);
        if (keyword != null) {
            intent.putExtra("spring_key_word", keyword);
        }
        if (extras != null) {
            intent.putExtras(extras);
        }
        intent.setData(Uri.parse(url));
        intent.setFlags(268435456);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.springhb.main.u
            @Override // java.lang.Runnable
            public final void run() {
                SpringToMainHelper.h();
            }
        });
        QLog.i("SpringToMainHelper", 2, "h5NotifyLoadFinished...time:" + System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h() {
        f289366a.r();
    }

    private final void j(Context context, String jumpUrl) {
        QLog.i("SpringToMainHelper", 1, "jumpToScheme jumpUrl = " + jumpUrl);
        context.startActivity(new Intent(context, (Class<?>) JumpActivity.class).setData(Uri.parse(jumpUrl)));
    }

    @JvmStatic
    public static final void k(@NotNull Context context, @NotNull String jumpUrl, @NotNull String fromSrc) {
        boolean startsWith$default;
        boolean startsWith$default2;
        boolean startsWith$default3;
        boolean startsWith$default4;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        Intrinsics.checkNotNullParameter(fromSrc, "fromSrc");
        boolean z16 = false;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(jumpUrl, "http://", false, 2, null);
        if (!startsWith$default) {
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(jumpUrl, "https://", false, 2, null);
            if (!startsWith$default2) {
                startsWith$default3 = StringsKt__StringsJVMKt.startsWith$default(jumpUrl, "mqqapi://springhb/openUrl", false, 2, null);
                if (!startsWith$default3) {
                    startsWith$default4 = StringsKt__StringsJVMKt.startsWith$default(jumpUrl, "mqqapi://", false, 2, null);
                    if (startsWith$default4) {
                        f289366a.j(context, jumpUrl);
                    } else {
                        QLog.e("SpringToMainHelper", 1, "jumpUrl error : " + jumpUrl);
                    }
                } else {
                    SpringToMainHelper springToMainHelper = f289366a;
                    String str = springToMainHelper.n(jumpUrl).get("url");
                    if (str == null || str.length() == 0) {
                        z16 = true;
                    }
                    if (z16) {
                        return;
                    } else {
                        springToMainHelper.x(context, str, 0, null, true, null);
                    }
                }
                QLog.d("SpringToMainHelper", 2, "jumpToUrlAndScheme : " + jumpUrl);
            }
        }
        f289366a.l(context, jumpUrl);
        QLog.d("SpringToMainHelper", 2, "jumpToUrlAndScheme : " + jumpUrl);
    }

    private final void l(Context context, String schemeUrl) {
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent.putExtra("url", schemeUrl));
        QLog.i("SpringToMainHelper", 1, "jumpToWeb jumpUrl = " + schemeUrl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(Context context, Intent intent) {
        QLog.i("SpringToMainHelper", 1, "startSpringWebView");
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(R.anim.f154740cc, R.anim.f154740cc);
        }
        context.startActivity(intent);
    }

    private final Map<String, String> n(String jumpUrl) {
        List split$default;
        List split$default2;
        List split$default3;
        HashMap hashMap = new HashMap();
        split$default = StringsKt__StringsKt.split$default((CharSequence) jumpUrl, new String[]{QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER}, false, 0, 6, (Object) null);
        if (split$default.size() == 2) {
            split$default2 = StringsKt__StringsKt.split$default((CharSequence) split$default.get(1), new String[]{ContainerUtils.FIELD_DELIMITER}, false, 0, 6, (Object) null);
            int size = split$default2.size();
            for (int i3 = 0; i3 < size; i3++) {
                split$default3 = StringsKt__StringsKt.split$default((CharSequence) split$default2.get(i3), new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 0, 6, (Object) null);
                if (split$default3.size() == 2) {
                    Object obj = split$default3.get(0);
                    String decode = URLDecoder.decode((String) split$default3.get(1), "UTF-8");
                    Intrinsics.checkNotNullExpressionValue(decode, "decode(keyValues[1], \"UTF-8\")");
                    hashMap.put(obj, decode);
                }
            }
            return hashMap;
        }
        return hashMap;
    }

    @JvmStatic
    public static final void o(@NotNull QQAppInterface app) {
        Intrinsics.checkNotNullParameter(app, "app");
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - gLastLoadToolsProcessTime > 60000) {
            QLog.i("SpringToMainHelper", 1, "preloadToolsProcess, nowCallTime =" + currentTimeMillis + "gLastLoadToolsProcessTime =" + gLastLoadToolsProcessTime);
            gLastLoadToolsProcessTime = currentTimeMillis;
            ((IWebProcessManagerService) app.getRuntimeService(IWebProcessManagerService.class, "")).startWebProcess(13, null);
        }
    }

    private final void p() {
        if (mReceiverRegistered.compareAndSet(false, true)) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("action_spring_close_tool_loading");
            MobileQQ.sMobileQQ.registerReceiver(mReceiver, intentFilter);
            QLog.i("SpringToMainHelper", 2, "registerBroadcast");
        }
    }

    private final void q() {
        if (mReceiverRegistered.compareAndSet(true, false)) {
            MobileQQ.sMobileQQ.unregisterReceiver(mReceiver);
            QLog.i("SpringToMainHelper", 2, "removeBroadcast");
        }
    }

    private final void r() {
        ViewGroup viewGroup;
        View findViewWithTag;
        isLoadingShow = false;
        WeakReference<ViewGroup> weakReference = mLoadingViewContainer;
        if (weakReference != null && (viewGroup = weakReference.get()) != null && (findViewWithTag = viewGroup.findViewWithTag("loading_view_tag")) != null) {
            viewGroup.removeView(findViewWithTag);
        }
        mLoadingViewContainer = null;
        q();
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(removeLoadingViewRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s() {
        f289366a.r();
    }

    private final void u(ViewGroup container, Animation animation) {
        mLoadingViewContainer = new WeakReference<>(container);
        View loadingView = ((ISpringLoongCardApi) QRoute.api(ISpringLoongCardApi.class)).getLoadingView(container.getContext());
        loadingView.setTag("loading_view_tag");
        loadingView.setZ(1.0f);
        container.addView(loadingView, new RelativeLayout.LayoutParams(-1, -1));
        loadingView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.springhb.main.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SpringToMainHelper.v(view);
            }
        });
        isLoadingShow = true;
        p();
        ThreadManagerV2.getUIHandlerV2().postDelayed(removeLoadingViewRunnable, 15000L);
        addLoadingViewTime = SystemClock.uptimeMillis();
        if (animation != null) {
            loadingView.startAnimation(animation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(View view) {
        ViewParent viewParent;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (SystemClock.uptimeMillis() - addLoadingViewTime >= 7500) {
            f289366a.r();
            ViewGroup viewGroup = null;
            if (view != null) {
                viewParent = view.getParent();
            } else {
                viewParent = null;
            }
            if (viewParent instanceof ViewGroup) {
                viewGroup = (ViewGroup) viewParent;
            }
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public final boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return isLoadingShow;
    }

    public final void t(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            isLoadingShow = z16;
        }
    }

    public final void w(@NotNull Context context, @NotNull String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, (Object) url);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        QLog.i("SpringToMainHelper", 1, "startSpringGameWebView, url = " + url);
        Intent intent = new Intent(context, (Class<?>) SpringHbTranslucentBrowserActivity.class);
        intent.putExtra("url", url);
        intent.putExtra("injectrecommend", true);
        intent.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, false);
        intent.putExtra("spring_play_video_type", 8);
        intent.setData(Uri.parse(url));
        intent.setFlags(268435456);
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(R.anim.f154740cc, R.anim.f154740cc);
        }
        context.startActivity(intent);
    }

    public final void x(@NotNull Context context, @NotNull String url, int from, @Nullable String keyword, boolean needAnimation, @Nullable Bundle extras) {
        Activity activity;
        View view;
        ViewGroup viewGroup;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, context, url, Integer.valueOf(from), keyword, Boolean.valueOf(needAnimation), extras);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = QBaseActivity.sTopActivity;
        }
        Intent f16 = f(context, url, from, keyword, extras);
        if (activity != null) {
            InputMethodUtil.hide(activity);
        }
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            Window window = activity.getWindow();
            TranslateAnimation translateAnimation = null;
            if (window != null) {
                view = window.getDecorView();
            } else {
                view = null;
            }
            if (view instanceof ViewGroup) {
                viewGroup = (ViewGroup) view;
            } else {
                viewGroup = null;
            }
            if (viewGroup == null) {
                return;
            }
            if (needAnimation) {
                translateAnimation = new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
                translateAnimation.setDuration(210L);
                translateAnimation.setAnimationListener(new a(context, f16));
            }
            u(viewGroup, translateAnimation);
            if (needAnimation && translateAnimation != null) {
                return;
            }
            m(context, f16);
            return;
        }
        QLog.e("SpringToMainHelper", 1, "startSpringWebView failed! Activity not available");
    }
}
