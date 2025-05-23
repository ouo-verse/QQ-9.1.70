package com.tencent.qqmini.minigame.notifybubble;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 -2\u00020\u0001:\u0001.B\u0007\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J&\u0010\u0012\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u0002J\u0006\u0010\u0018\u001a\u00020\u0004R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010'\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010&R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010(R\u0016\u0010*\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010$\u00a8\u0006/"}, d2 = {"Lcom/tencent/qqmini/minigame/notifybubble/MiniGameNotifyBubbleControl;", "Landroid/os/Handler$Callback;", "", MiniChatConstants.MINI_APP_LANDSCAPE, "", "l", "Lorg/json/JSONObject;", "result", "Lcom/tencent/qqmini/minigame/notifybubble/a;", DomainData.DOMAIN_NAME, "k", "o", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;", "miniAppInfo", "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "p", "Landroid/os/Message;", "msg", "handleMessage", "fromUser", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "d", "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;", "Lcom/tencent/qqmini/minigame/notifybubble/MiniGameNotifyBubbleView;", "e", "Lcom/tencent/qqmini/minigame/notifybubble/MiniGameNotifyBubbleView;", "bubbleView", "Landroid/os/Handler;", "f", "Landroid/os/Handler;", "mainHandler", h.F, "Z", "isDestroy", "Lcom/tencent/qqmini/minigame/notifybubble/a;", "data", "Landroid/view/ViewGroup;", BdhLogUtil.LogTag.Tag_Conn, "isBubbleClose", "<init>", "()V", "D", "a", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class MiniGameNotifyBubbleControl implements Handler.Callback {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isBubbleClose;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private MiniAppInfo miniAppInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private MiniGameNotifyBubbleView bubbleView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Handler mainHandler = new Handler(Looper.getMainLooper(), this);

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isDestroy;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private MiniGameNotifyBubbleData data;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ViewGroup rootView;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n\u00a2\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "isSucc", "", "<anonymous parameter 1>", "Lorg/json/JSONObject;", "onReceiveResult"}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes23.dex */
    public static final class b implements AsyncResult {

        /* renamed from: a, reason: collision with root package name */
        public static final b f346545a = new b();

        b() {
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
        public final void onReceiveResult(boolean z16, @Nullable JSONObject jSONObject) {
            QMLog.i("MiniGameNotifyBubbleControl", "closeFloatBubble isSucc:" + z16);
        }
    }

    public static /* synthetic */ void j(MiniGameNotifyBubbleControl miniGameNotifyBubbleControl, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        miniGameNotifyBubbleControl.i(z16);
    }

    private final void k() {
        MiniGameNotifyBubbleView miniGameNotifyBubbleView = this.bubbleView;
        if (miniGameNotifyBubbleView != null) {
            miniGameNotifyBubbleView.e(2);
        }
        MiniGameNotifyBubbleData miniGameNotifyBubbleData = this.data;
        if (miniGameNotifyBubbleData != null) {
            MiniAppInfo miniAppInfo = this.miniAppInfo;
            SDKMiniProgramLpReportDC04239.reportWithR7(miniAppInfo, SDKMiniProgramLpReportDC04239.getAppType(miniAppInfo), "page_view", "em_expo", "minigame_notice_bubble", "2", String.valueOf(miniGameNotifyBubbleData.getBubbleType()), "", String.valueOf(miniGameNotifyBubbleData.getTaskId()), "", String.valueOf(miniGameNotifyBubbleData.getTaskType()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(boolean isLandscape) {
        float f16;
        if (this.bubbleView != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 8388611;
            if (isLandscape) {
                f16 = 16.0f;
            } else {
                f16 = 50.0f;
            }
            layoutParams.topMargin = ViewUtils.dip2px(f16);
            layoutParams.leftMargin = ViewUtils.dip2px(16.0f);
            MiniGameNotifyBubbleView miniGameNotifyBubbleView = this.bubbleView;
            if (miniGameNotifyBubbleView != null) {
                miniGameNotifyBubbleView.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MiniGameNotifyBubbleData n(JSONObject result) {
        return new MiniGameNotifyBubbleData(result.optBoolean(AppConstants.Key.COLUMN_IS_VALID), result.optLong(WidgetCacheConstellationData.INTERVAL), result.optInt("bubbleType"), result.optString("bigBubbleTitle"), result.optString("bigBubbleSubTitle"), result.optString("smallBubbleTitle"), result.optString("bubbleIcon"), result.optString("bubbleClickSchema"), result.optString("closePopupText"), result.optString(MiniAppGetGameTaskTicketServlet.KEY_TASKID), result.optInt("taskType"), result.optBoolean("isTaskFinish"), result.optInt("taskProgress"));
    }

    private final void o() {
        if (this.miniAppInfo != null) {
            ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
            MiniAppInfo miniAppInfo = this.miniAppInfo;
            if (miniAppInfo == null) {
                Intrinsics.throwNpe();
            }
            channelProxy.getFloatBubble(miniAppInfo.appId, new AsyncResult() { // from class: com.tencent.qqmini.minigame.notifybubble.MiniGameNotifyBubbleControl$requestBubbleData$1
                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                public final void onReceiveResult(boolean z16, @Nullable JSONObject jSONObject) {
                    boolean z17;
                    boolean z18;
                    final MiniGameNotifyBubbleData n3;
                    QMLog.i("MiniGameNotifyBubbleControl", "requestBubbleData isSucc:" + z16);
                    if (!z16) {
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.notifybubble.MiniGameNotifyBubbleControl$requestBubbleData$1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                MiniGameNotifyBubbleControl.this.i(false);
                            }
                        });
                        return;
                    }
                    if (jSONObject != null) {
                        z17 = MiniGameNotifyBubbleControl.this.isDestroy;
                        if (!z17) {
                            z18 = MiniGameNotifyBubbleControl.this.isBubbleClose;
                            if (!z18) {
                                n3 = MiniGameNotifyBubbleControl.this.n(jSONObject);
                                if (!n3.getIsValid()) {
                                    QMLog.i("MiniGameNotifyBubbleControl", "requestBubbleData isValid false");
                                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.notifybubble.MiniGameNotifyBubbleControl$requestBubbleData$1.2
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            MiniGameNotifyBubbleControl.this.i(false);
                                        }
                                    });
                                } else {
                                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.notifybubble.MiniGameNotifyBubbleControl$requestBubbleData$1.3
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            MiniGameNotifyBubbleView miniGameNotifyBubbleView;
                                            Handler handler;
                                            Handler handler2;
                                            miniGameNotifyBubbleView = MiniGameNotifyBubbleControl.this.bubbleView;
                                            if (miniGameNotifyBubbleView != null) {
                                                miniGameNotifyBubbleView.setBubbleData(n3);
                                            }
                                            MiniGameNotifyBubbleControl.this.data = n3;
                                            if (n3.getInterval() > 0) {
                                                handler = MiniGameNotifyBubbleControl.this.mainHandler;
                                                handler.removeMessages(1);
                                                handler2 = MiniGameNotifyBubbleControl.this.mainHandler;
                                                handler2.sendEmptyMessageDelayed(1, n3.getInterval() * 1000);
                                            }
                                        }
                                    });
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NotNull Message msg2) {
        Intrinsics.checkParameterIsNotNull(msg2, "msg");
        int i3 = msg2.what;
        if (i3 != 1) {
            if (i3 == 2) {
                k();
            }
        } else {
            o();
        }
        return true;
    }

    public final void i(boolean fromUser) {
        ViewGroup viewGroup;
        String str = null;
        this.mainHandler.removeCallbacksAndMessages(null);
        try {
            MiniGameNotifyBubbleView miniGameNotifyBubbleView = this.bubbleView;
            if (miniGameNotifyBubbleView != null && (viewGroup = this.rootView) != null) {
                viewGroup.removeView(miniGameNotifyBubbleView);
            }
        } catch (Exception e16) {
            QMLog.e("MiniGameNotifyBubbleControl", "closeBubble exception:", e16);
        }
        MiniGameNotifyBubbleData miniGameNotifyBubbleData = this.data;
        if (miniGameNotifyBubbleData != null) {
            this.isBubbleClose = true;
            if (miniGameNotifyBubbleData != null && miniGameNotifyBubbleData.getBubbleType() == 2 && fromUser && this.miniAppInfo != null) {
                ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
                MiniAppInfo miniAppInfo = this.miniAppInfo;
                if (miniAppInfo == null) {
                    Intrinsics.throwNpe();
                }
                String str2 = miniAppInfo.appId;
                MiniGameNotifyBubbleData miniGameNotifyBubbleData2 = this.data;
                if (miniGameNotifyBubbleData2 != null) {
                    str = miniGameNotifyBubbleData2.getTaskId();
                }
                channelProxy.closeFloatBubble(str2, str, b.f346545a);
            }
        }
    }

    public final void m() {
        this.isDestroy = true;
        this.mainHandler.removeCallbacksAndMessages(null);
        MiniGameNotifyBubbleView miniGameNotifyBubbleView = this.bubbleView;
        if (miniGameNotifyBubbleView != null) {
            miniGameNotifyBubbleView.destroy();
        }
    }

    public final void p(@NotNull final Activity activity, @NotNull final MiniAppInfo miniAppInfo, @NotNull final ViewGroup rootView, final boolean isLandscape) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(miniAppInfo, "miniAppInfo");
        Intrinsics.checkParameterIsNotNull(rootView, "rootView");
        this.miniAppInfo = miniAppInfo;
        this.rootView = rootView;
        ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).getFloatBubble(miniAppInfo.appId, new AsyncResult() { // from class: com.tencent.qqmini.minigame.notifybubble.MiniGameNotifyBubbleControl$showNotifyBubble$1
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public final void onReceiveResult(boolean z16, @Nullable JSONObject jSONObject) {
                final MiniGameNotifyBubbleData n3;
                QMLog.i("MiniGameNotifyBubbleControl", "getFloatBubble isSucc:" + z16);
                if (z16 && jSONObject != null) {
                    n3 = MiniGameNotifyBubbleControl.this.n(jSONObject);
                    if (n3.getIsValid()) {
                        MiniGameNotifyBubbleControl.this.data = n3;
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.notifybubble.MiniGameNotifyBubbleControl$showNotifyBubble$1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                MiniGameNotifyBubbleView miniGameNotifyBubbleView;
                                MiniGameNotifyBubbleView miniGameNotifyBubbleView2;
                                MiniGameNotifyBubbleView miniGameNotifyBubbleView3;
                                MiniGameNotifyBubbleView miniGameNotifyBubbleView4;
                                MiniGameNotifyBubbleView miniGameNotifyBubbleView5;
                                MiniGameNotifyBubbleView miniGameNotifyBubbleView6;
                                Handler handler;
                                Handler handler2;
                                Handler handler3;
                                Handler handler4;
                                MiniGameNotifyBubbleControl.this.bubbleView = new MiniGameNotifyBubbleView(rootView.getContext(), isLandscape);
                                miniGameNotifyBubbleView = MiniGameNotifyBubbleControl.this.bubbleView;
                                if (miniGameNotifyBubbleView != null) {
                                    miniGameNotifyBubbleView.setController(MiniGameNotifyBubbleControl.this);
                                }
                                miniGameNotifyBubbleView2 = MiniGameNotifyBubbleControl.this.bubbleView;
                                if (miniGameNotifyBubbleView2 != null) {
                                    miniGameNotifyBubbleView2.setActivity(activity);
                                }
                                miniGameNotifyBubbleView3 = MiniGameNotifyBubbleControl.this.bubbleView;
                                if (miniGameNotifyBubbleView3 != null) {
                                    miniGameNotifyBubbleView3.setBubbleData(n3);
                                }
                                miniGameNotifyBubbleView4 = MiniGameNotifyBubbleControl.this.bubbleView;
                                if (miniGameNotifyBubbleView4 != null) {
                                    miniGameNotifyBubbleView4.setMiniAppInfo(miniAppInfo);
                                }
                                MiniGameNotifyBubbleControl$showNotifyBubble$1 miniGameNotifyBubbleControl$showNotifyBubble$1 = MiniGameNotifyBubbleControl$showNotifyBubble$1.this;
                                ViewGroup viewGroup = rootView;
                                miniGameNotifyBubbleView5 = MiniGameNotifyBubbleControl.this.bubbleView;
                                viewGroup.addView(miniGameNotifyBubbleView5);
                                miniGameNotifyBubbleView6 = MiniGameNotifyBubbleControl.this.bubbleView;
                                if (miniGameNotifyBubbleView6 != null) {
                                    miniGameNotifyBubbleView6.bringToFront();
                                }
                                MiniGameNotifyBubbleControl$showNotifyBubble$1 miniGameNotifyBubbleControl$showNotifyBubble$12 = MiniGameNotifyBubbleControl$showNotifyBubble$1.this;
                                MiniGameNotifyBubbleControl.this.l(isLandscape);
                                if (n3.getInterval() > 0) {
                                    handler3 = MiniGameNotifyBubbleControl.this.mainHandler;
                                    handler3.removeMessages(1);
                                    handler4 = MiniGameNotifyBubbleControl.this.mainHandler;
                                    handler4.sendEmptyMessageDelayed(1, n3.getInterval() * 1000);
                                }
                                handler = MiniGameNotifyBubbleControl.this.mainHandler;
                                handler.removeMessages(2);
                                handler2 = MiniGameNotifyBubbleControl.this.mainHandler;
                                handler2.sendEmptyMessageDelayed(2, 3000L);
                                MiniAppInfo miniAppInfo2 = miniAppInfo;
                                SDKMiniProgramLpReportDC04239.reportWithR7(miniAppInfo2, SDKMiniProgramLpReportDC04239.getAppType(miniAppInfo2), "page_view", "em_expo", "minigame_notice_bubble", "1", String.valueOf(n3.getBubbleType()), "", String.valueOf(n3.getTaskId()), "", String.valueOf(n3.getTaskType()));
                            }
                        });
                    } else {
                        QMLog.i("MiniGameNotifyBubbleControl", "getFloatBubble isValid false");
                    }
                }
            }
        });
    }
}
