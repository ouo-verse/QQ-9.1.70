package com.tencent.mobileqq.qqlive.room.frame.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.webkit.URLUtil;
import androidx.fragment.app.Fragment;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.utils.GlobalDisplayMetricsManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.config.QQLiveSDKConfigHelper;
import com.tencent.mobileqq.qqlive.api.ipc.QQLiveIPCConstants;
import com.tencent.mobileqq.qqlive.base.ipc.QQLiveServerQIPCModule;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.context.QQLiveContext;
import com.tencent.mobileqq.qqperf.api.IPerfApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.qqlive.common.report.constant.QQLiveReportConstants;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.liveroom.impl.room.event.OnActivityResultEvent;
import com.tencent.timi.game.liveroom.impl.room.match.TGLiveDefaultFragment;
import com.tencent.timi.game.liveroom.impl.room.match.TGLiveMatchWebViewFragment;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 )2\u00020\u0001:\u0001*B\u0007\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0014J\b\u0010\r\u001a\u00020\u0002H\u0014J\u0012\u0010\u0010\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\u0012\u001a\u00020\u0002H\u0014J\"\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007H\u0014J\u0012\u0010\u001a\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0002H\u0016R\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/frame/activity/QQliveRoomActivity;", "Lcom/tencent/mobileqq/qqlive/room/frame/activity/QQLiveWebShareActivity;", "", "N2", "", "url", "openUrl", "Landroid/content/Intent;", "intent", "L2", "M2", "", "themeChangeRightNow", "initRequestedOrientation", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreate", "doOnNewIntent", "doOnDestroy", "", "requestCode", QzoneIPCModule.RESULT_CODE, "data", "doOnActivityResult", "Landroid/content/res/Configuration;", "newConfig", "doOnConfigurationChanged", "finish", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "g0", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "aegisLogger", "h0", "Z", "isCloseJumpHandled", "Lcom/tencent/mobileqq/qqlive/room/frame/activity/a;", "i0", "Lcom/tencent/mobileqq/qqlive/room/frame/activity/a;", "qqLiveRoomLayoutFactory", "<init>", "()V", "j0", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public class QQliveRoomActivity extends QQLiveWebShareActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: j0, reason: collision with root package name */
    @NotNull
    private static final a f271555j0;

    /* renamed from: k0, reason: collision with root package name */
    @Deprecated
    private static boolean f271556k0;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IAegisLogApi aegisLogger;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private boolean isCloseJumpHandled;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qqlive.room.frame.activity.a qqLiveRoomLayoutFactory;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e\u00a2\u0006\f\n\u0004\b\b\u0010\t\u0012\u0004\b\n\u0010\u000b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/frame/activity/QQliveRoomActivity$a;", "", "", "a", "", "TAG", "Ljava/lang/String;", "", "isAdd", "Z", "isAdd$annotations", "()V", "<init>", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @JvmStatic
        public final void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                if (QQliveRoomActivity.f271556k0) {
                    return;
                }
                ((IPerfApi) QRoute.api(IPerfApi.class)).addFragmentForFilterFragment(TGLiveMatchWebViewFragment.class.getName(), TGLiveDefaultFragment.class.getName(), Fragment.class.getName());
                QQliveRoomActivity.f271556k0 = true;
            }
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26731);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            f271555j0 = new a(null);
        }
    }

    public QQliveRoomActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.aegisLogger = (IAegisLogApi) api;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void L2(Intent intent) {
        String str;
        boolean z16;
        QQLiveContext d16;
        boolean isBlank;
        Bundle bundleExtra;
        if (intent != null && (bundleExtra = intent.getBundleExtra("biz_ext_data")) != null) {
            str = bundleExtra.getString("traceId");
        } else {
            str = null;
        }
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z16 = false;
                if (z16) {
                    if (intent != null) {
                        str = intent.getStringExtra(QQLiveReportConstants.INTENT_TRACE_ID);
                    } else {
                        str = null;
                    }
                }
                this.aegisLogger.i("QQliveRoomActivity", "[ensureLiveContext] traceId=" + str);
                QQLiveContext.Companion companion = QQLiveContext.INSTANCE;
                d16 = companion.d(str);
                if (d16 == null) {
                    d16 = companion.b(new com.tencent.mobileqq.qqlive.context.a(QQLiveBusinessConfig.QQLIVE_APP_ID, null, null, null));
                }
                companion.f(d16);
            }
        }
        z16 = true;
        if (z16) {
        }
        this.aegisLogger.i("QQliveRoomActivity", "[ensureLiveContext] traceId=" + str);
        QQLiveContext.Companion companion2 = QQLiveContext.INSTANCE;
        d16 = companion2.d(str);
        if (d16 == null) {
        }
        companion2.f(d16);
    }

    private final void M2() {
        Resources resources = super.getResources();
        if (resources != null) {
            Configuration configuration = resources.getConfiguration();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            displayMetrics.setTo(GlobalDisplayMetricsManager.sQQDisplayMetrics);
            resources.updateConfiguration(configuration, displayMetrics);
        }
    }

    private final void N2() {
        LayoutInflater from = LayoutInflater.from(this);
        if (from.getFactory() == null && from.getFactory2() == null) {
            com.tencent.mobileqq.qqlive.room.frame.activity.a aVar = new com.tencent.mobileqq.qqlive.room.frame.activity.a();
            this.qqLiveRoomLayoutFactory = aVar;
            from.setFactory2(aVar);
            return;
        }
        this.aegisLogger.w("QQliveRoomActivity", "factory has been set,factory:" + from.getFactory() + ",factory2:" + from.getFactory2());
    }

    private final void openUrl(String url) {
        if (TextUtils.isEmpty(url)) {
            this.aegisLogger.w("QQliveRoomActivity", "url is empty");
        } else {
            if (URLUtil.isNetworkUrl(url)) {
                Bundle bundle = new Bundle();
                bundle.putString("big_brother_source_key", "biz_src_jc_vip");
                com.tencent.qqlive.common.webview.a.g(BaseApplication.context, url, bundle, QQBrowserActivity.class, new int[]{268435456}, null, QQLiveSDKConfigHelper.getQQLiveAppId());
                return;
            }
            startActivity(new Intent(getActivity(), (Class<?>) JumpActivity.class).setData(Uri.parse(url)));
        }
    }

    @Override // com.tencent.mobileqq.qqlive.room.frame.activity.QQLiveWebShareActivity, com.tencent.mobileqq.activity.QPublicFragmentActivityForTool, com.tencent.mobileqq.activity.QPublicFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqlive.room.frame.activity.QQLiveWebShareActivity, com.tencent.mobileqq.activity.QPublicFragmentActivity, mqq.app.AppActivity
    public void doOnActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
        } else {
            super.doOnActivityResult(requestCode, resultCode, data);
            SimpleEventBus.getInstance().dispatchEvent(new OnActivityResultEvent(requestCode, resultCode, data));
        }
    }

    @Override // com.tencent.mobileqq.activity.QPublicFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnConfigurationChanged(@Nullable Configuration newConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) newConfig);
        } else {
            M2();
            super.doOnConfigurationChanged(newConfig);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqlive.room.frame.activity.QQLiveWebShareActivity, com.tencent.mobileqq.activity.QPublicFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) savedInstanceState)).booleanValue();
        }
        M2();
        L2(getIntent());
        f271555j0.a();
        N2();
        QQLiveServerQIPCModule.INSTANCE.a(QQLiveIPCConstants.Action.ACTION_ROOM_REGISTER_CHAT_AUDIO_OBSERVER, null, null);
        return super.doOnCreate(savedInstanceState);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqlive.room.frame.activity.QQLiveWebShareActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.doOnDestroy();
        com.tencent.mobileqq.qqlive.room.frame.activity.a aVar = this.qqLiveRoomLayoutFactory;
        if (aVar != null) {
            aVar.c();
        }
        this.qqLiveRoomLayoutFactory = null;
        QQLiveServerQIPCModule.INSTANCE.a(QQLiveIPCConstants.Action.ACTION_ROOM_REMOVE_CHAT_AUDIO_OBSERVER, null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.QPublicFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(@Nullable Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent);
            return;
        }
        L2(intent);
        super.doOnNewIntent(intent);
        setIntent(intent);
    }

    @Override // com.tencent.mobileqq.activity.QPublicFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.finish();
        Bundle bundleExtra = getActivity().getIntent().getBundleExtra("biz_ext_data");
        if (bundleExtra == null) {
            return;
        }
        String string = bundleExtra.getString("closeJump");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        if (this.isCloseJumpHandled) {
            this.aegisLogger.i("QQliveRoomActivity", "closejump is handled");
            return;
        }
        this.isCloseJumpHandled = true;
        this.aegisLogger.i("QQliveRoomActivity", "handle closejump->" + string);
        openUrl(string);
    }

    @Override // com.tencent.mobileqq.activity.QPublicFragmentActivity
    protected void initRequestedOrientation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.room.frame.activity.QQLiveWebShareActivity, com.tencent.mobileqq.activity.QPublicFragmentActivityForTool, com.tencent.mobileqq.activity.QPublicFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.QPublicFragmentActivity, com.tencent.mobileqq.app.QBaseActivity
    public boolean themeChangeRightNow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return false;
    }
}
