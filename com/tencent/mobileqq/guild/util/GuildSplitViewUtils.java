package com.tencent.mobileqq.guild.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.core.os.BundleKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.common.config.AppSetting;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.ep;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseActivityInjectUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.base.QPublicFragmentActivityForMainWebActivity;
import com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.facade.FacadeArgsData;
import com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.facade.FacadeJoinInfo;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.pad.SplitViewState;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bC\u0010DJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\bH\u0002J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000bH\u0002J2\u0010\u0012\u001a\u00020\u00112\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u000fJ8\u0010\u0016\u001a\u00020\u00112\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b2\u0006\u0010\u0015\u001a\u00020\u0014J:\u0010\u0018\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u000fJ&\u0010\u0019\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000bJ\u0010\u0010\u001c\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aJ\u000e\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\u001dJ\u0010\u0010\"\u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010 J\"\u0010%\u001a\u00020\u00112\b\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010#\u001a\u00020\u001a2\b\u0010$\u001a\u0004\u0018\u00010\u0001J\u0018\u0010'\u001a\u00020\u00112\b\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010&\u001a\u00020\u001aJ\u001a\u0010+\u001a\u00020\u00062\b\u0010)\u001a\u0004\u0018\u00010(2\b\b\u0002\u0010*\u001a\u00020\u0006J\u001c\u0010-\u001a\u00020\u00142\b\b\u0002\u0010,\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bJ\u000e\u0010/\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020.J\u0010\u00102\u001a\u00020\u00112\b\u00101\u001a\u0004\u0018\u000100J\u0018\u00104\u001a\u00020\u00142\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u00103\u001a\u00020\u0014J\"\u00106\u001a\u00020\u00112\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u00101\u001a\u0004\u0018\u0001002\u0006\u00105\u001a\u00020\u0014J\u0010\u00107\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0010\u00108\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bR0\u0010=\u001a\u001e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a09j\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a`:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u001d\u0010B\u001a\u0004\u0018\u00010\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/guild/util/GuildSplitViewUtils;", "", "Lcom/tencent/mobileqq/app/anim/a;", "k", "Landroid/content/Intent;", "intent", "", "d", "Landroid/content/Context;", "context", "l", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "fragmentClass", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/pad/LaunchMode;", AppConstants.Preferences.LAUNCH_MODE, "", "o", "fragment", "", "requestCode", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "isSupreme", "v", "r", "", "url", "e", "Landroidx/fragment/app/Fragment;", "Landroid/os/Bundle;", "g", "Lcom/tencent/biz/richframework/part/interfaces/IPartHost;", "partHost", tl.h.F, "key", "newValue", "E", "removeKey", "y", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "hideKeyboard", "t", "useWidthPixel", "i", "Lcom/tencent/mobileqq/guild/base/QQGuildCustomTitleBarFragment;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/view/View;", "view", "B", "colorResId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "bgResId", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "D", DomainData.DOMAIN_NAME, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "UNSUPPORTED_SOURCE_TYPE", "c", "Lkotlin/Lazy;", "f", "()Lcom/tencent/mobileqq/app/anim/a;", "animationSetter", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildSplitViewUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildSplitViewUtils f235370a = new GuildSplitViewUtils();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, String> UNSUPPORTED_SOURCE_TYPE;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy animationSetter;

    static {
        HashMap<String, String> hashMapOf;
        Lazy lazy;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("small_world", "profile"));
        UNSUPPORTED_SOURCE_TYPE = hashMapOf;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.app.anim.a>() { // from class: com.tencent.mobileqq.guild.util.GuildSplitViewUtils$animationSetter$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final com.tencent.mobileqq.app.anim.a invoke() {
                com.tencent.mobileqq.app.anim.a k3;
                k3 = GuildSplitViewUtils.f235370a.k();
                return k3;
            }
        });
        animationSetter = lazy;
    }

    GuildSplitViewUtils() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean C(View view, MotionEvent motionEvent) {
        return true;
    }

    private final boolean d(Intent intent) {
        String str;
        JumpGuildParam.JoinInfoParam a16;
        JumpGuildParam.JoinInfoParam a17;
        try {
            FacadeArgsData b16 = com.tencent.mobileqq.guild.base.extension.c.b(intent.getExtras());
            if (b16 != null) {
                FacadeJoinInfo facadeJoinInfo = b16.f227659i;
                String str2 = null;
                if (facadeJoinInfo != null && (a17 = facadeJoinInfo.a()) != null) {
                    str = a17.getMainSource();
                } else {
                    str = null;
                }
                String str3 = "";
                if (str == null) {
                    str = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(str, "it.joinInfo?.joinInfoParam?.mainSource ?: \"\"");
                }
                FacadeJoinInfo facadeJoinInfo2 = b16.f227659i;
                if (facadeJoinInfo2 != null && (a16 = facadeJoinInfo2.a()) != null) {
                    str2 = a16.getSubSource();
                }
                if (str2 != null) {
                    Intrinsics.checkNotNullExpressionValue(str2, "it.joinInfo?.joinInfoParam?.subSource ?: \"\"");
                    str3 = str2;
                }
                HashMap<String, String> hashMap = UNSUPPORTED_SOURCE_TYPE;
                if (hashMap.containsKey(str)) {
                    if (Intrinsics.areEqual(hashMap.get(str), str3)) {
                        return false;
                    }
                }
            }
        } catch (Exception e16) {
            QLog.e("GuildSplitViewUtils", 1, "checkBusiness exception: " + e16.getMessage());
        }
        return true;
    }

    private final com.tencent.mobileqq.app.anim.a f() {
        return (com.tencent.mobileqq.app.anim.a) animationSetter.getValue();
    }

    public static /* synthetic */ int j(GuildSplitViewUtils guildSplitViewUtils, boolean z16, Context context, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        if ((i3 & 2) != 0) {
            context = null;
        }
        return guildSplitViewUtils.i(z16, context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.app.anim.a k() {
        Class<com.tencent.mobileqq.app.anim.a> cls = QBaseActivityInjectUtil.sAnimationSetterClasses.get("aio");
        if (cls == null) {
            return null;
        }
        return cls.newInstance();
    }

    private final Context l(Context context) {
        Context b16 = ep.b(context);
        if (!D(b16)) {
            return null;
        }
        if (!(b16 instanceof FragmentActivity) || !(b16 instanceof com.tencent.mobileqq.pad.l)) {
            if (!((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).isSplashActivityTop()) {
                return null;
            }
            return QBaseActivity.sTopActivity;
        }
        return b16;
    }

    public static /* synthetic */ void p(GuildSplitViewUtils guildSplitViewUtils, Context context, Intent intent, Class cls, LaunchMode launchMode, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            launchMode = LaunchMode.standard;
        }
        guildSplitViewUtils.o(context, intent, cls, launchMode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(Context context, Intent intent, Class fragmentClass) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(intent, "$intent");
        Intrinsics.checkNotNullParameter(fragmentClass, "$fragmentClass");
        w(f235370a, context, intent, fragmentClass, true, null, 16, null);
    }

    public static /* synthetic */ boolean u(GuildSplitViewUtils guildSplitViewUtils, Activity activity, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return guildSplitViewUtils.t(activity, z16);
    }

    public static /* synthetic */ void w(GuildSplitViewUtils guildSplitViewUtils, Context context, Intent intent, Class cls, boolean z16, LaunchMode launchMode, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            z16 = false;
        }
        boolean z17 = z16;
        if ((i3 & 16) != 0) {
            launchMode = LaunchMode.standard;
        }
        guildSplitViewUtils.v(context, intent, cls, z17, launchMode);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean x(Context context, Class<? extends QPublicBaseFragment> fragmentClass) {
        try {
            if ((context instanceof FragmentActivity) && (context instanceof com.tencent.mobileqq.pad.l)) {
                ((com.tencent.mobileqq.pad.l) context).getqFragmentStackManager().q(fragmentClass.getName());
                ((FragmentActivity) context).getSupportFragmentManager().executePendingTransactions();
                return true;
            }
            return false;
        } catch (Exception e16) {
            QLog.e("GuildSplitViewUtils", 1, "removeGuildHomeFragment, exception: " + e16.getMessage());
            return false;
        }
    }

    public final void A(@Nullable Context context, @Nullable View view, int bgResId) {
        if (n(context) && view != null) {
            try {
                view.setBackgroundResource(bgResId);
            } catch (Exception e16) {
                QLog.e("GuildSplitViewUtils", 1, "setBgColor, exception: " + e16.getMessage());
            }
        }
    }

    public final void B(@Nullable View view) {
        Context context;
        if (view != null) {
            context = view.getContext();
        } else {
            context = null;
        }
        if (n(context) && view != null) {
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.guild.util.av
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    boolean C;
                    C = GuildSplitViewUtils.C(view2, motionEvent);
                    return C;
                }
            });
        }
    }

    public final boolean D(@Nullable Context context) {
        boolean z16;
        if (!AppSetting.t(context)) {
            return false;
        }
        try {
            boolean z17 = context instanceof JumpActivity;
            boolean isMainProcessOnTop = ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isMainProcessOnTop();
            boolean isSplashActivityTop = ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).isSplashActivityTop();
            if (com.tencent.mobileqq.pad.e.a() == SplitViewState.STATE_FLAT) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z17 || !isMainProcessOnTop || !isSplashActivityTop || !z16) {
                return false;
            }
            return true;
        } catch (Exception e16) {
            QLog.e("GuildSplitViewUtils", 1, "shouldLaunchInSplitViewMode, exception: " + e16.getMessage());
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void E(@Nullable IPartHost partHost, @NotNull String key, @Nullable Object newValue) {
        Activity hostActivity;
        Intrinsics.checkNotNullParameter(key, "key");
        if (partHost != 0 && (hostActivity = partHost.getHostActivity()) != null) {
            GuildSplitViewUtils guildSplitViewUtils = f235370a;
            Bundle h16 = guildSplitViewUtils.h(partHost);
            h16.putAll(BundleKt.bundleOf(TuplesKt.to(key, newValue)));
            if (guildSplitViewUtils.n(hostActivity) && (partHost instanceof Fragment)) {
                ((Fragment) partHost).setArguments(h16);
            } else if (hostActivity.getIntent() != null) {
                partHost.getHostActivity().getIntent().putExtras(h16);
            }
        }
    }

    public final boolean e(@Nullable String url) {
        try {
            Uri parse = Uri.parse(url);
            String queryParameter = parse.getQueryParameter("mainSourceId");
            String str = "";
            if (queryParameter == null) {
                queryParameter = "";
            }
            String queryParameter2 = parse.getQueryParameter("subSourceId");
            if (queryParameter2 != null) {
                str = queryParameter2;
            }
            HashMap<String, String> hashMap = UNSUPPORTED_SOURCE_TYPE;
            if (hashMap.containsKey(queryParameter)) {
                if (Intrinsics.areEqual(hashMap.get(queryParameter), str)) {
                    return false;
                }
            }
        } catch (Exception e16) {
            QLog.e("GuildSplitViewUtils", 1, "checkBusiness exception: " + e16.getMessage());
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0035  */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Bundle g(@NotNull Fragment fragment) {
        Bundle bundle;
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        if (fragment.getActivity() != null) {
            if (n(fragment.requireActivity())) {
                bundle = fragment.getArguments();
            } else if (fragment.requireActivity().getIntent() != null) {
                bundle = fragment.requireActivity().getIntent().getExtras();
            }
            if (bundle != null) {
                return new Bundle();
            }
            return bundle;
        }
        bundle = null;
        if (bundle != null) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final Bundle h(@Nullable IPartHost partHost) {
        Activity activity;
        Bundle bundle = null;
        if (partHost != 0) {
            activity = partHost.getHostActivity();
        } else {
            activity = null;
        }
        if (activity != null) {
            if (n(partHost.getHostActivity())) {
                if (partHost instanceof Fragment) {
                    bundle = ((Fragment) partHost).getArguments();
                }
            } else if (partHost.getHostActivity().getIntent() != null) {
                bundle = partHost.getHostActivity().getIntent().getExtras();
            }
        }
        if (bundle == null) {
            return new Bundle();
        }
        return bundle;
    }

    public final int i(boolean useWidthPixel, @Nullable Context context) {
        int screenWidth;
        if (useWidthPixel) {
            screenWidth = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
        } else {
            screenWidth = ImmersiveUtils.getScreenWidth();
        }
        if (n(context)) {
            return com.tencent.mobileqq.pad.m.d();
        }
        return screenWidth;
    }

    public final int m(@Nullable Context context, int colorResId) {
        if (n(context)) {
            return R.color.ajr;
        }
        return colorResId;
    }

    public final boolean n(@Nullable Context context) {
        boolean z16;
        if (context == null) {
            context = BaseApplication.context;
        }
        boolean isSplashActivityTop = ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).isSplashActivityTop();
        if ((context instanceof Activity) && ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isSplashActivity((Activity) context)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (AppSetting.t(context) && (isSplashActivityTop || z16)) {
            return true;
        }
        return false;
    }

    public final void o(@Nullable Context context, @NotNull Intent intent, @NotNull Class<? extends QPublicBaseFragment> fragmentClass, @NotNull LaunchMode launchMode) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(fragmentClass, "fragmentClass");
        Intrinsics.checkNotNullParameter(launchMode, "launchMode");
        if (context != null) {
            try {
                if (D(context)) {
                    v(context, intent, fragmentClass, false, launchMode);
                }
            } catch (Exception e16) {
                QLog.e("GuildSplitViewUtils", 1, "launchFragment exception: " + e16.getMessage());
                return;
            }
        }
        QPublicFragmentActivity.b.b(context, intent, QPublicFragmentActivity.class, fragmentClass);
    }

    public final void q(@Nullable Context context, @NotNull QPublicBaseFragment fragment, @NotNull Intent intent, @NotNull Class<? extends QPublicBaseFragment> fragmentClass, int requestCode) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(fragmentClass, "fragmentClass");
        if (context != null) {
            try {
                if (D(context)) {
                    w(this, context, intent, fragmentClass, false, null, 24, null);
                }
            } catch (Exception e16) {
                QLog.e("GuildSplitViewUtils", 1, "launchFragmentForResult exception: " + e16.getMessage());
                return;
            }
        }
        QPublicFragmentActivity.startForResult(fragment, intent, fragmentClass, requestCode);
    }

    public final void r(@NotNull final Context context, @NotNull final Intent intent, @NotNull final Class<? extends QPublicBaseFragment> fragmentClass) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(fragmentClass, "fragmentClass");
        try {
            Context l3 = l(context);
            if (l3 != null && d(intent)) {
                if (!x(l3, fragmentClass)) {
                    ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.util.au
                        @Override // java.lang.Runnable
                        public final void run() {
                            GuildSplitViewUtils.s(context, intent, fragmentClass);
                        }
                    }, 500L);
                } else {
                    w(this, context, intent, fragmentClass, true, null, 16, null);
                }
            } else {
                QPublicFragmentActivity.b.b(context, intent, QPublicFragmentActivityForMainWebActivity.class, fragmentClass);
            }
        } catch (Exception e16) {
            QLog.e("GuildSplitViewUtils", 1, "launchGuildHomeFragment exception: " + e16.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean t(@Nullable Activity activity, boolean hideKeyboard) {
        InputMethodManager inputMethodManager;
        if (activity == 0) {
            return false;
        }
        if (n(activity) && (activity instanceof com.tencent.mobileqq.pad.l)) {
            if (hideKeyboard) {
                try {
                    Object systemService = activity.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
                    if (systemService instanceof InputMethodManager) {
                        inputMethodManager = (InputMethodManager) systemService;
                    } else {
                        inputMethodManager = null;
                    }
                    View peekDecorView = activity.getWindow().peekDecorView();
                    if (peekDecorView != null && peekDecorView.getWindowToken() != null && inputMethodManager != null) {
                        inputMethodManager.hideSoftInputFromWindow(peekDecorView.getWindowToken(), 0);
                    }
                } catch (Exception e16) {
                    QLog.e("GuildSplitViewUtils", 1, "onBackPressed, exception: " + e16.getMessage());
                }
            }
            if (!((com.tencent.mobileqq.pad.l) activity).getqFragmentStackManager().p()) {
                QLog.e("GuildSplitViewUtils", 1, "onBackPressed, stack is empty!");
            }
        } else {
            activity.finish();
        }
        return true;
    }

    public final void v(@NotNull Context context, @NotNull Intent intent, @NotNull Class<? extends QPublicBaseFragment> fragmentClass, boolean isSupreme, @NotNull LaunchMode launchMode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(fragmentClass, "fragmentClass");
        Intrinsics.checkNotNullParameter(launchMode, "launchMode");
        QLog.i("GuildSplitViewUtils", 1, "realLaunchFragmentInSplitMode: " + fragmentClass.getName());
        com.tencent.mobileqq.pad.b h16 = new com.tencent.mobileqq.pad.b().e(false).g(false).h(launchMode);
        if (isSupreme) {
            h16.i(true);
        }
        try {
            com.tencent.mobileqq.app.anim.a f16 = f();
            if (f16 != null) {
                h16.c(f16.b().a(), f16.b().b(), 0, f16.a().b());
            }
        } catch (Exception e16) {
            QLog.w("GuildSplitViewUtils", 1, "[getAnim] causes exception " + e16);
        }
        Bundle bundle = new Bundle();
        if (intent.getExtras() != null) {
            bundle.putAll(intent.getExtras());
        }
        com.tencent.mobileqq.pad.i.e(context, bundle, fragmentClass, h16.a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y(@Nullable IPartHost partHost, @NotNull String removeKey) {
        Activity activity;
        Bundle arguments;
        Intrinsics.checkNotNullParameter(removeKey, "removeKey");
        if (partHost != 0) {
            activity = partHost.getHostActivity();
        } else {
            activity = null;
        }
        if (activity != null) {
            if (n(partHost.getHostActivity())) {
                if ((partHost instanceof Fragment) && (arguments = ((Fragment) partHost).getArguments()) != null) {
                    arguments.remove(removeKey);
                    return;
                }
                return;
            }
            if (partHost.getHostActivity().getIntent() != null) {
                partHost.getHostActivity().getIntent().removeExtra(removeKey);
            }
        }
    }

    public final void z(@NotNull QQGuildCustomTitleBarFragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        try {
            if (n(fragment.getActivity()) && fragment.C != null) {
                fragment.C = null;
            }
        } catch (Exception e16) {
            QLog.e("GuildSplitViewUtils", 1, "resetLeftView, exception: " + e16.getMessage());
        }
    }
}
