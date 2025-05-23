package com.tencent.mobileqq.vaswebviewplugin;

import android.R;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.ad.tangram.statistics.metric.AdMetricID;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.springhb.api.ISpringHbReportApi;
import com.tencent.mobileqq.springhb.main.SpringToMainHelper;
import com.tencent.mobileqq.springhb.preload.SpringRes;
import com.tencent.mobileqq.springhb.preload.s;
import com.tencent.mobileqq.springhb.x;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPluginV2;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.zootopia.api.IZootopiaApi;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 %2\u00020\u0001:\u0001%B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0007J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0007J*\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0007J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0007J\b\u0010\u0016\u001a\u00020\nH\u0016J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0007J\u0018\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\nH\u0007J\b\u0010\u001a\u001a\u00020\fH\u0014J\b\u0010\u001b\u001a\u00020\fH\u0014J\u001a\u0010\u001c\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\nH\u0007J\b\u0010\u001e\u001a\u00020\fH\u0002J\b\u0010\u001f\u001a\u00020\fH\u0002J\u001a\u0010 \u001a\u00020\f2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010\r\u001a\u00020\nH\u0007J\u0018\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\nH\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/vaswebviewplugin/SpringHbJsPlugin;", "Lcom/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPluginV2;", "()V", "bubbleView", "Landroid/view/ViewGroup;", "mReceiver", "Landroid/content/BroadcastReceiver;", "mReceiverRegistered", "Ljava/util/concurrent/atomic/AtomicBoolean;", "openGameCallBack", "", "checkValid", "", "callback", "closeVideo", "draw", UIJsPlugin.EVENT_SHOW_LOADING, "", "sceneType", "", "fromSrc", "gameReady", "getNameSpace", "isSupportZplan", "notifyReady", "type", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "openGame", "url", "registerBroadcast", "removeBroadcast", "reportData", "data", "Lorg/json/JSONObject;", "showPauseBubble", "isVisible", "Companion", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class SpringHbJsPlugin extends VasWebviewJsPluginV2 {

    @NotNull
    public static final String ACTION_SPRING_CLOSE_VIDEO = "action_spring_close_video";

    @NotNull
    public static final String ACTION_SPRING_GAME_LOADING_CANCEL = "action_spring_game_cancel";

    @NotNull
    public static final String ACTION_SPRING_GAME_READY = "action_spring_game_ready";

    @NotNull
    public static final String ACTION_SPRING_NOTIFY_READY = "action_spring_notify_ready";

    @NotNull
    public static final String BUSINESS_NAME = "springhb";

    @NotNull
    private static final String TAG = "SpringHb_SpringHbJsPlugin";

    @Nullable
    private ViewGroup bubbleView;

    @Nullable
    private String openGameCallBack;

    @NotNull
    private final AtomicBoolean mReceiverRegistered = new AtomicBoolean(false);

    @NotNull
    private final BroadcastReceiver mReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.vaswebviewplugin.SpringHbJsPlugin$mReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(@NotNull Context context, @NotNull Intent intent) {
            String str;
            boolean z16;
            String str2;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            String action = intent.getAction();
            if (action != null && action.hashCode() == 1338695902 && action.equals(SpringHbJsPlugin.ACTION_SPRING_GAME_LOADING_CANCEL)) {
                str = SpringHbJsPlugin.this.openGameCallBack;
                if (str != null && str.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    SpringHbJsPlugin springHbJsPlugin = SpringHbJsPlugin.this;
                    str2 = springHbJsPlugin.openGameCallBack;
                    springHbJsPlugin.callJs(str2, "{'result' : 'cancel'}");
                    SpringHbJsPlugin.this.openGameCallBack = null;
                    SpringHbJsPlugin.this.removeBroadcast();
                }
            }
            QLog.i("SpringHb_SpringHbJsPlugin", 2, "onReceive: action:" + intent.getAction());
        }
    };

    public static /* synthetic */ void draw$default(SpringHbJsPlugin springHbJsPlugin, boolean z16, int i3, String str, String str2, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            z16 = true;
        }
        springHbJsPlugin.draw(z16, i3, str, str2);
    }

    private final void registerBroadcast() {
        if (this.mReceiverRegistered.compareAndSet(false, true)) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(ACTION_SPRING_GAME_LOADING_CANCEL);
            MobileQQ.sMobileQQ.registerReceiver(this.mReceiver, intentFilter);
            QLog.i(TAG, 2, "registerBroadcast");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeBroadcast() {
        if (this.mReceiverRegistered.compareAndSet(true, false)) {
            MobileQQ.sMobileQQ.unregisterReceiver(this.mReceiver);
            QLog.i(TAG, 2, "removeBroadcast");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPauseBubble$lambda$1$lambda$0(Activity activity, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (activity != null) {
            activity.finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "callback", method = "checkValid")
    public final void checkValid(@NotNull String callback) {
        Intent intent;
        int i3;
        int i16;
        Activity a16;
        Intrinsics.checkNotNullParameter(callback, "callback");
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null && (a16 = bVar.a()) != null) {
            intent = a16.getIntent();
        } else {
            intent = null;
        }
        if (intent != null) {
            i3 = intent.getIntExtra("spring_from_type", 0);
        } else {
            i3 = 0;
        }
        if (intent != null) {
            i16 = intent.getIntExtra("spring_backend_scene_id", 0);
        } else {
            i16 = 0;
        }
        boolean z16 = true;
        QLog.d(TAG, 1, "checkIsLoongCardValid invoke from: " + i3 + " id: " + i16);
        String[] strArr = new String[1];
        if (i3 != 2) {
            z16 = false;
        }
        strArr[0] = "{'result': " + z16 + ",'keyword': '" + i16 + "' }";
        callJs(callback, strArr);
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "callback", method = "closeVideo")
    public final void closeVideo(@NotNull String callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.d(TAG, 1, "js\u8c03\u8bd5\uff0ccloseVideo");
        MobileQQ.sMobileQQ.sendBroadcast(new Intent(ACTION_SPRING_CLOSE_VIDEO));
        callJs(callback, "{'result':'\u89c6\u9891\u5173\u95ed\u6210\u529f'}");
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "showLoading|sceneType|fromSrc|callback", method = "draw")
    public final void draw(boolean showLoading, int sceneType, @NotNull String fromSrc, @NotNull String callback) {
        Intrinsics.checkNotNullParameter(fromSrc, "fromSrc");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.d(TAG, 1, "draw, sceneType=" + sceneType + ", showLoading=" + showLoading);
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "callback", method = "gameReady")
    public final void gameReady(@NotNull String callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.d(TAG, 4, "gameReady");
        MobileQQ.sMobileQQ.sendBroadcast(new Intent(ACTION_SPRING_GAME_READY));
        callJs(callback, "{'result' : 'success'}");
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    @NotNull
    public String getNameSpace() {
        return "springhb";
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "callback", method = "isSupportZplan")
    public final void isSupportZplan(@NotNull final String callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.d(TAG, 1, "isSupportZplan");
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).isDeviceAdaptiveForMod(AdMetricID.Click.SUCCESS, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.vaswebviewplugin.SpringHbJsPlugin$isSupportZplan$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                boolean z17 = z16 && !((IZootopiaApi) QRoute.api(IZootopiaApi.class)).shouldHideSmallHomeEntry();
                QLog.d("SpringHb_SpringHbJsPlugin", 1, "isSupportZplan, isZplan=" + z17);
                if (z17) {
                    SpringHbJsPlugin.this.callJs(callback, "{'result':true}");
                } else {
                    SpringHbJsPlugin.this.callJs(callback, "{'result':false}");
                }
            }
        });
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "type|callback", method = "notifyReady")
    public final void notifyReady(int type, @NotNull String callback) {
        Activity a16;
        Intent intent;
        Intrinsics.checkNotNullParameter(callback, "callback");
        WebViewPlugin.b bVar = this.mRuntime;
        int i3 = 0;
        if (bVar != null && (a16 = bVar.a()) != null && (intent = a16.getIntent()) != null) {
            i3 = intent.getIntExtra("spring_from_type", 0);
        }
        QLog.d(TAG, 1, "notifyReady invoke type:" + type + " fromType: " + i3);
        if (i3 == 2) {
            if (type == 2) {
                MobileQQ.sMobileQQ.sendBroadcast(new Intent(ACTION_SPRING_NOTIFY_READY));
            }
        } else if (type == 1) {
            MobileQQ.sMobileQQ.sendBroadcast(new Intent(ACTION_SPRING_NOTIFY_READY));
        }
        callJs(callback, "{'result':1}");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin, com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        x.g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        super.onDestroy();
        removeBroadcast();
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "url|callback", method = "openGame")
    public final void openGame(@Nullable String url, @NotNull String callback) {
        boolean z16;
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.d(TAG, 4, "openGame url = " + url);
        Activity a16 = this.mRuntime.a();
        if (url != null && url.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && a16 != null) {
            SpringToMainHelper.f289366a.w(a16, url);
            this.openGameCallBack = callback;
            registerBroadcast();
            return;
        }
        QLog.e(TAG, 1, "openGame error url = " + url + " activity = " + a16);
        callJs(callback, "{'result' : 'error'}");
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "data|callback", method = "reportData")
    public final void reportData(@Nullable JSONObject data, @NotNull String callback) {
        ISpringHbReportApi iSpringHbReportApi;
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (data != null) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null && (iSpringHbReportApi = (ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")) != null) {
                iSpringHbReportApi.webReport(data, 0);
            }
            callJs(callback, "{'result' : 'success'}");
            return;
        }
        callJs(callback, "{'result' : 'data is empty'}");
    }

    @VasWebviewJsPluginV2.JsbridgeSubscribe(args = "isVisible|callback", method = "showPauseBubble")
    public final void showPauseBubble(boolean isVisible, @NotNull String callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        final Activity a16 = this.mRuntime.a();
        View findViewById = a16.findViewById(R.id.content);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout frameLayout = (FrameLayout) findViewById;
        int e16 = x.e();
        int f16 = x.f();
        QLog.d(TAG, 1, "showPauseBubble isVisible = " + isVisible + ", sceneType=" + e16 + ", remainSeconds=" + f16);
        ViewParent viewParent = null;
        if (isVisible && e16 == 2 && f16 > 0) {
            if (this.bubbleView == null) {
                View inflate = LayoutInflater.from(a16).inflate(com.tencent.mobileqq.R.layout.gx5, (ViewGroup) null);
                Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
                this.bubbleView = (ViewGroup) inflate;
            }
            ViewGroup viewGroup = this.bubbleView;
            Intrinsics.checkNotNull(viewGroup);
            if (viewGroup.getParent() != null) {
                frameLayout.removeView(this.bubbleView);
            }
            ViewGroup viewGroup2 = this.bubbleView;
            Intrinsics.checkNotNull(viewGroup2);
            ((ImageView) viewGroup2.findViewById(com.tencent.mobileqq.R.id.f227204h)).setImageDrawable(SpringRes.j(s.a("spring_detail_shua_pause_bubble_bg.png"), null, null, 3, null));
            ViewGroup viewGroup3 = this.bubbleView;
            Intrinsics.checkNotNull(viewGroup3);
            TextView textView = (TextView) viewGroup3.findViewById(com.tencent.mobileqq.R.id.f227304i);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("\u5237\u4e00\u5237\u5df2\u6682\u505c\n\u8fd8\u5269%s\u79d2", Arrays.copyOf(new Object[]{Integer.valueOf(f16)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            textView.setText(format);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.vaswebviewplugin.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SpringHbJsPlugin.showPauseBubble$lambda$1$lambda$0(a16, view);
                }
            });
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewUtils.dpToPx(96.0f), ViewUtils.dpToPx(40.0f));
            layoutParams.topMargin = ViewUtils.dpToPx(130.0f);
            frameLayout.addView(this.bubbleView, layoutParams);
            callJs(callback, "{'result':true}");
            x.p(this.bubbleView);
            return;
        }
        if (!isVisible) {
            ViewGroup viewGroup4 = this.bubbleView;
            if (viewGroup4 != null) {
                viewParent = viewGroup4.getParent();
            }
            if (viewParent != null) {
                frameLayout.removeView(this.bubbleView);
            }
            callJs(callback, "{'result':true}");
            return;
        }
        callJs(callback, "{'result':false}");
    }
}
