package com.tencent.qqmini.minigame.yungame.va;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.minigame.R;
import com.tencent.qqmini.minigame.yungame.va.a;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.DialogUtil;
import com.tencent.qqmini.sdk.launcher.core.proxy.QQCustomizedProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VACustomTextConfig;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.ImmersiveUtils;
import com.tencent.qqmini.sdk.utils.ViewUtils;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ac\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 \u008f\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0004\u008f\u0001\u0090\u0001B\u001b\u0012\b\u0010G\u001a\u0004\u0018\u00010F\u0012\u0006\u0010+\u001a\u00020\u000b\u00a2\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0014H\u0002J\b\u0010\u0018\u001a\u00020\u0014H\u0002J\b\u0010\u0019\u001a\u00020\u0014H\u0002J\b\u0010\u001a\u001a\u00020\u0014H\u0002J\b\u0010\u001b\u001a\u00020\u0006H\u0002J\b\u0010\u001c\u001a\u00020\u0006H\u0002J\b\u0010\u001d\u001a\u00020\u0006H\u0002J\b\u0010\u001e\u001a\u00020\u0006H\u0002J\b\u0010\u001f\u001a\u00020\u0006H\u0002J\u0018\u0010\"\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000bH\u0002J&\u0010'\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00042\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0014J\u000e\u0010*\u001a\u00020\u00062\u0006\u0010)\u001a\u00020(J\u000e\u0010,\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u000bJ\u0010\u0010.\u001a\u00020\u00062\b\u0010-\u001a\u0004\u0018\u00010\u0014J\u000e\u0010/\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0004J\u000e\u00101\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u000bJ\u0006\u00102\u001a\u00020\u0006J\u001e\u00107\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u000b2\u0006\u00105\u001a\u0002042\u0006\u00106\u001a\u000204J\u000e\u00107\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u000bJ\u000e\u0010:\u001a\u00020\u00062\u0006\u00109\u001a\u000208J\u0006\u0010;\u001a\u00020\u0006J\u0006\u0010<\u001a\u00020\u000bJ\u000e\u0010>\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\u0004J\b\u0010?\u001a\u00020\u0004H\u0016J\u0012\u0010B\u001a\u00020\u00062\b\u0010A\u001a\u0004\u0018\u00010@H\u0016J\u0012\u0010E\u001a\u00020\u00042\b\u0010D\u001a\u0004\u0018\u00010CH\u0016J@\u0010N\u001a\u0004\u0018\u00010M2\b\u0010G\u001a\u0004\u0018\u00010F2\u0006\u0010H\u001a\u00020\u00042\u0006\u0010I\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u000b2\b\u0010K\u001a\u0004\u0018\u00010J2\b\u0010L\u001a\u0004\u0018\u00010JH\u0016R\u0014\u0010P\u001a\u00020O8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0014\u0010S\u001a\u00020R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0014\u0010V\u001a\u00020U8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0014\u0010X\u001a\u00020R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bX\u0010TR\u0014\u0010Y\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0014\u0010[\u001a\u00020R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b[\u0010TR\u0014\u0010\\\u001a\u00020R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\\\u0010TR\u0016\u00100\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010]R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010^R\u0016\u00103\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010]R\u0016\u00105\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010_R\u0016\u00106\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010_R\u0018\u0010`\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010#\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010^R\u0017\u0010c\u001a\u00020b8\u0006\u00a2\u0006\f\n\u0004\bc\u0010d\u001a\u0004\be\u0010fR\u0016\u0010g\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010^R\u0016\u0010h\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010^R\u0016\u0010i\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010]R\u0016\u0010j\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010]R\u0016\u0010k\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010]R\"\u0010m\u001a\u00020l8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bm\u0010n\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR\"\u0010s\u001a\u00020l8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bs\u0010n\u001a\u0004\bt\u0010p\"\u0004\bu\u0010rR\"\u0010v\u001a\u0002048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bv\u0010_\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR\"\u0010{\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b{\u0010^\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~R#\u0010\u007f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0013\n\u0004\b\u007f\u0010^\u001a\u0004\b\u007f\u0010|\"\u0005\b\u0080\u0001\u0010~R\u001b\u0010\u0081\u0001\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0019\u0010&\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b&\u0010\u0083\u0001R\u0019\u0010-\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b-\u0010\u0083\u0001R\u0018\u0010\u0085\u0001\u001a\u00030\u0084\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0018\u0010\u0087\u0001\u001a\u00030\u0084\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0087\u0001\u0010\u0086\u0001R\u001b\u0010\u0088\u0001\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0018\u0010\u008b\u0001\u001a\u00030\u008a\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001R\u0016\u0010+\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010]\u00a8\u0006\u0091\u0001"}, d2 = {"Lcom/tencent/qqmini/minigame/yungame/va/VAFloatDownloadTips;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/qqmini/minigame/yungame/va/a$a;", "", "expand", "", "updateExpand", "showDualChannelDownloadTips", VasPerfReportUtils.WHILE_UPDATE_ITEM, "checkAndUpdateViewLp", "", "newState", "checkAutoFold", "updateTipsView", "updateLoadingView", "updateStopView", "updateRestartView", "updateAutoRestartView", "updateErrorView", "", "getTipsText", "getFoldedTipsText", "getExpandTipsText", "getWifiExpandTipsText", "getWlanExpandTipsText", "getProcessText", "onDualChanelRefuseClick", "onSwitchOnDualChannel", "handleRightTextClick", "handleLeftTextClick", "handleSingleTextClick", "xDistance", "yDistance", "handleMoveAction", "isWifi", "Lcom/tencent/qqmini/minigame/yungame/va/b;", "buttonRect", VirtualAppProxy.KEY_GAME_ID, "show", "Lcom/tencent/qqmini/minigame/yungame/va/a;", "delegate", "setDualChannelDelegate", "scene", "setScene", VirtualAppProxy.KEY_GAME_VERSION_CODE, "setGameVersionCode", "updateWifiState", "state", "updateState", "resetDownloadProcess", "process", "", "downloadedSize", VirtualAppProxy.KEY_PKG_SIZE, "updateDownloadProcess", "Lcom/tencent/qqmini/minigame/yungame/va/VAFloatDownloadTips$a;", "clickListener", "setOperateClickListener", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "getProcess", "enable", "enableDualChannelTask", "showDualChannelTips", "Landroid/view/View;", "view", NodeProps.ON_CLICK, "Landroid/view/MotionEvent;", "event", "onTouchEvent", "Landroid/content/Context;", "context", "needAwardIcon", "type", "Landroid/content/DialogInterface$OnClickListener;", "onConfirm", "onCancel", "Landroid/app/Dialog;", "createYunGameVARetainDialog", "Landroid/widget/ImageView;", "tipsIcon", "Landroid/widget/ImageView;", "Landroid/widget/TextView;", "tipsText", "Landroid/widget/TextView;", "Landroid/widget/FrameLayout;", "operateLayout", "Landroid/widget/FrameLayout;", "operateSingleText", "operatePairLayout", "Landroid/widget/LinearLayout;", "operateLeftText", "operateRightText", "I", "Z", "J", "operateClickListener", "Lcom/tencent/qqmini/minigame/yungame/va/VAFloatDownloadTips$a;", "Lcom/tencent/qqmini/sdk/launcher/core/proxy/va/VACustomTextConfig;", "tipsTextData", "Lcom/tencent/qqmini/sdk/launcher/core/proxy/va/VACustomTextConfig;", "getTipsTextData", "()Lcom/tencent/qqmini/sdk/launcher/core/proxy/va/VACustomTextConfig;", "hideCancelAndStop", "dualChannelShowing", NodeProps.MAX_WIDTH, "sw", "sh", "", "dragDownX", UserInfo.SEX_FEMALE, "getDragDownX", "()F", "setDragDownX", "(F)V", "dragDownY", "getDragDownY", "setDragDownY", "touchStart", "getTouchStart", "()J", "setTouchStart", "(J)V", "isDraging", "()Z", "setDraging", "(Z)V", "isDrag", "setDrag", "menuButtonRect", "Lcom/tencent/qqmini/minigame/yungame/va/b;", "Ljava/lang/String;", "Ljava/lang/Runnable;", "foldedRunnable", "Ljava/lang/Runnable;", "dualChannelSwitchTimeoutRunnable", "dualChannelDelegate", "Lcom/tencent/qqmini/minigame/yungame/va/a;", "Landroid/os/Handler;", "uiHandler", "Landroid/os/Handler;", "<init>", "(Landroid/content/Context;I)V", "Companion", "a", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public class VAFloatDownloadTips extends LinearLayout implements View.OnClickListener, a.InterfaceC9397a {
    private static final long EXPAND_TIME_OUT = 3000;
    public static final int SCENE_GAME = 2;
    public static final int SCENE_QUEUE = 1;
    public static final int SCENE_VA = 3;
    public static final int STATE_AUTO_RESTART = 7;
    public static final int STATE_CANCEL = 6;
    public static final int STATE_DOWNLOADED = 4;
    public static final int STATE_DOWNLOADING = 2;
    public static final int STATE_ERROR = 5;
    public static final int STATE_STOP = 3;
    public static final int STATE_TIPS = 1;
    private static final String TAG = "VAFloatDownloadTips";
    private HashMap _$_findViewCache;
    private long downloadedSize;
    private float dragDownX;
    private float dragDownY;
    private com.tencent.qqmini.minigame.yungame.va.a dualChannelDelegate;
    private boolean dualChannelShowing;
    private final Runnable dualChannelSwitchTimeoutRunnable;
    private boolean expand;
    private final Runnable foldedRunnable;
    private String gameId;
    private String gameVersionCode;
    private boolean hideCancelAndStop;
    private boolean isDrag;
    private boolean isDraging;
    private boolean isWifi;
    private int maxWidth;
    private MenuButtonRect menuButtonRect;
    private a operateClickListener;
    private final FrameLayout operateLayout;
    private final TextView operateLeftText;
    private final LinearLayout operatePairLayout;
    private final TextView operateRightText;
    private final TextView operateSingleText;
    private long pkgSize;
    private int process;
    private int scene;
    private int sh;
    private int state;
    private int sw;
    private final ImageView tipsIcon;
    private final TextView tipsText;

    @NotNull
    private final VACustomTextConfig tipsTextData;
    private long touchStart;
    private final Handler uiHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0002H&J\b\u0010\b\u001a\u00020\u0002H&J\b\u0010\t\u001a\u00020\u0002H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqmini/minigame/yungame/va/VAFloatDownloadTips$a;", "", "", "onStartDownloadClick", "onStopClick", "onContinueClick", "onCancelClick", "onRestartClick", "onRetryClick", "onDualChannelSwitch", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes23.dex */
    public interface a {
        void onCancelClick();

        void onContinueClick();

        void onDualChannelSwitch();

        void onRestartClick();

        void onRetryClick();

        void onStartDownloadClick();

        void onStopClick();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", NodeProps.ON_CLICK}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes23.dex */
    public static final class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i3) {
            String str;
            VAFloatDownloadTips.this.hideCancelAndStop = true;
            String str2 = VAFloatDownloadTips.this.gameId;
            int i16 = VAFloatDownloadTips.this.scene;
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 != 3) {
                        str = "";
                    } else {
                        str = "5";
                    }
                } else {
                    str = "3";
                }
            } else {
                str = "1";
            }
            com.tencent.qqmini.minigame.yungame.va.d.a("989331", "20", str2, null, str, "", null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", NodeProps.ON_CLICK}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes23.dex */
    public static final class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i3) {
            String str;
            a aVar = VAFloatDownloadTips.this.operateClickListener;
            if (aVar != null) {
                aVar.onCancelClick();
            }
            String str2 = VAFloatDownloadTips.this.gameId;
            int i16 = VAFloatDownloadTips.this.scene;
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 != 3) {
                        str = "";
                    } else {
                        str = "5";
                    }
                } else {
                    str = "3";
                }
            } else {
                str = "1";
            }
            com.tencent.qqmini.minigame.yungame.va.d.a("989330", "20", str2, null, str, "", null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", NodeProps.ON_CLICK}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes23.dex */
    public static final class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i3) {
            String str;
            VAFloatDownloadTips.this.hideCancelAndStop = true;
            String str2 = VAFloatDownloadTips.this.gameId;
            int i16 = VAFloatDownloadTips.this.scene;
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 != 3) {
                        str = "";
                    } else {
                        str = "6";
                    }
                } else {
                    str = "4";
                }
            } else {
                str = "2";
            }
            com.tencent.qqmini.minigame.yungame.va.d.a("989331", "20", str2, null, str, "", null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", NodeProps.ON_CLICK}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes23.dex */
    public static final class e implements DialogInterface.OnClickListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i3) {
            String str;
            a aVar = VAFloatDownloadTips.this.operateClickListener;
            if (aVar != null) {
                aVar.onStopClick();
            }
            VAFloatDownloadTips.this.updateExpand(false);
            String str2 = VAFloatDownloadTips.this.gameId;
            int i16 = VAFloatDownloadTips.this.scene;
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 != 3) {
                        str = "";
                    } else {
                        str = "6";
                    }
                } else {
                    str = "4";
                }
            } else {
                str = "2";
            }
            com.tencent.qqmini.minigame.yungame.va.d.a("989330", "20", str2, null, str, "", null, null);
        }
    }

    public VAFloatDownloadTips(@Nullable Context context, int i3) {
        super(context);
        VACustomTextConfig vACustomTextConfig;
        this.scene = i3;
        this.state = 1;
        this.expand = true;
        this.sw = -1;
        this.sh = -1;
        this.gameId = "";
        this.gameVersionCode = "";
        this.foldedRunnable = new Runnable() { // from class: com.tencent.qqmini.minigame.yungame.va.VAFloatDownloadTips$foldedRunnable$1
            @Override // java.lang.Runnable
            public final void run() {
                boolean z16;
                z16 = VAFloatDownloadTips.this.expand;
                if (z16 && !VAFloatDownloadTips.this.getIsDraging()) {
                    VAFloatDownloadTips.this.updateExpand(false);
                }
            }
        };
        this.dualChannelSwitchTimeoutRunnable = new Runnable() { // from class: com.tencent.qqmini.minigame.yungame.va.VAFloatDownloadTips$dualChannelSwitchTimeoutRunnable$1
            @Override // java.lang.Runnable
            public final void run() {
                QMLog.i("VAFloatDownloadTips", "dualChannelSwitchTimeoutRunnable");
                VAFloatDownloadTips.this.dualChannelShowing = false;
                VAFloatDownloadTips.this.updateView();
            }
        };
        this.uiHandler = new Handler(Looper.getMainLooper());
        View inflate = LayoutInflater.from(context).inflate(R.layout.mini_game_va_float_download_tips, (ViewGroup) this, true);
        View findViewById = inflate.findViewById(R.id.mini_game_va_tips_left_iv);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "rootView.findViewById(R.\u2026ini_game_va_tips_left_iv)");
        this.tipsIcon = (ImageView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.mini_game_va_tips_main_tv);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "rootView.findViewById(R.\u2026ini_game_va_tips_main_tv)");
        this.tipsText = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.mini_game_va_tips_operate_layout);
        Intrinsics.checkExpressionValueIsNotNull(findViewById3, "rootView.findViewById(R.\u2026e_va_tips_operate_layout)");
        this.operateLayout = (FrameLayout) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.mini_game_va_tips_operate_single_tv);
        Intrinsics.checkExpressionValueIsNotNull(findViewById4, "rootView.findViewById(R.\u2026a_tips_operate_single_tv)");
        TextView textView = (TextView) findViewById4;
        this.operateSingleText = textView;
        textView.setOnClickListener(this);
        View findViewById5 = inflate.findViewById(R.id.mini_game_va_tips_operate_pair_layout);
        Intrinsics.checkExpressionValueIsNotNull(findViewById5, "rootView.findViewById(R.\u2026tips_operate_pair_layout)");
        this.operatePairLayout = (LinearLayout) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.mini_game_va_tips_operate_left_tv);
        Intrinsics.checkExpressionValueIsNotNull(findViewById6, "rootView.findViewById(R.\u2026_va_tips_operate_left_tv)");
        TextView textView2 = (TextView) findViewById6;
        this.operateLeftText = textView2;
        textView2.setOnClickListener(this);
        View findViewById7 = inflate.findViewById(R.id.mini_game_va_tips_operate_right_tv);
        Intrinsics.checkExpressionValueIsNotNull(findViewById7, "rootView.findViewById(R.\u2026va_tips_operate_right_tv)");
        TextView textView3 = (TextView) findViewById7;
        this.operateRightText = textView3;
        textView3.setOnClickListener(this);
        setOnClickListener(this);
        setVisibility(8);
        VirtualAppProxy virtualAppProxy = (VirtualAppProxy) ProxyManager.get(VirtualAppProxy.class);
        this.tipsTextData = (virtualAppProxy == null || (vACustomTextConfig = virtualAppProxy.getVACustomTextConfig()) == null) ? new VACustomTextConfig(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 131071, null) : vACustomTextConfig;
    }

    private final void checkAndUpdateViewLp() {
        int i3;
        DisplayMetrics displayMetrics;
        int i16;
        DisplayMetrics displayMetrics2;
        this.maxWidth = Math.max(getWidth(), this.maxWidth);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (!(layoutParams instanceof FrameLayout.LayoutParams)) {
            layoutParams = null;
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            if (this.sw < 0) {
                Resources resources = getResources();
                if (resources != null && (displayMetrics2 = resources.getDisplayMetrics()) != null) {
                    i16 = displayMetrics2.widthPixels;
                    String str = ImmersiveUtils.TAG;
                } else {
                    i16 = 0;
                }
                this.sw = i16;
            }
            if (this.sh < 0) {
                Resources resources2 = getResources();
                if (resources2 != null && (displayMetrics = resources2.getDisplayMetrics()) != null) {
                    i3 = displayMetrics.heightPixels;
                } else {
                    i3 = 0;
                }
                this.sh = i3;
            }
            if (this.expand && layoutParams2.leftMargin + this.maxWidth + layoutParams2.rightMargin > this.sw) {
                int i17 = layoutParams2.gravity;
                if (i17 == 8388613) {
                    layoutParams2.gravity = 8388611;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.rightMargin = 0;
                } else if (i17 == 8388611) {
                    layoutParams2.gravity = 8388613;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.rightMargin = 0;
                }
                setLayoutParams(layoutParams2);
            }
        }
    }

    private final void checkAutoFold(int newState) {
        if (this.state != 2 && newState == 4) {
            this.expand = false;
            removeCallbacks(this.foldedRunnable);
        }
    }

    private final String getExpandTipsText() {
        if (this.isWifi) {
            return getWifiExpandTipsText();
        }
        return getWlanExpandTipsText();
    }

    private final String getFoldedTipsText() {
        switch (this.state) {
            case 1:
            case 6:
                return this.tipsTextData.getFoldedTipsText();
            case 2:
            case 3:
                return getProcessText();
            case 4:
                int i3 = this.scene;
                if (i3 != 1 && i3 != 2) {
                    if (i3 != 3) {
                        QMLog.e(TAG, "getFoldedTipsText state:" + this.state + " scene:" + this.scene + " scene invalid!");
                        return "";
                    }
                    return this.tipsTextData.getVaRestartText();
                }
                return this.tipsTextData.getRestartText();
            case 5:
                return this.tipsTextData.getErrorText();
            case 7:
                return this.tipsTextData.getAutoRestartText();
            default:
                QMLog.e(TAG, "getWifiExpandTipsText state:" + this.state + " invalid!");
                return "";
        }
    }

    private final String getProcessText() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.process);
        sb5.append('%');
        return sb5.toString();
    }

    private final String getTipsText() {
        if (this.expand) {
            return getExpandTipsText();
        }
        return getFoldedTipsText();
    }

    private final String getWifiExpandTipsText() {
        switch (this.state) {
            case 1:
            case 6:
                int i3 = this.scene;
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            QMLog.e(TAG, "getWifiExpandTipsText state:" + this.state + " scene:" + this.scene + " invalid!");
                            return "";
                        }
                        return this.tipsTextData.getVaInitText();
                    }
                    return this.tipsTextData.getWifiTipsInGameText();
                }
                return this.tipsTextData.getWifiTipsInQueueText();
            case 2:
                int i16 = this.scene;
                if (i16 != 1) {
                    if (i16 != 2) {
                        if (i16 != 3) {
                            QMLog.e(TAG, "getWifiExpandTipsText state:" + this.state + " scene:" + this.scene + " invalid!");
                            return "";
                        }
                        return com.tencent.qqmini.minigame.utils.c.f346835a.a(this.tipsTextData.getVaWifiLoadingText(), "\u52a0\u8f7d\u4e2d", Integer.valueOf(this.process));
                    }
                    return com.tencent.qqmini.minigame.utils.c.f346835a.a(this.tipsTextData.getWifiLoadingInGameText(), "\u52a0\u8f7d\u4e2d", Integer.valueOf(this.process));
                }
                return com.tencent.qqmini.minigame.utils.c.f346835a.a(this.tipsTextData.getWifiLoadingInQueueText(), "\u52a0\u8f7d\u4e2d", Integer.valueOf(this.process));
            case 3:
                int i17 = this.scene;
                if (i17 != 1 && i17 != 2) {
                    if (i17 != 3) {
                        QMLog.e(TAG, "getWifiExpandTipsText state:" + this.state + " scene:" + this.scene + " scene invalid!");
                        return "";
                    }
                    return com.tencent.qqmini.minigame.utils.c.f346835a.a(this.tipsTextData.getVaWifiStopText(), "\u66f4\u65b0\u5df2\u6682\u505c", Integer.valueOf(this.process));
                }
                return com.tencent.qqmini.minigame.utils.c.f346835a.a(this.tipsTextData.getWifiStopText(), "\u5df2\u6682\u505c\u52a0\u8f7d", Integer.valueOf(this.process));
            case 4:
                int i18 = this.scene;
                if (i18 != 1 && i18 != 2) {
                    if (i18 != 3) {
                        QMLog.e(TAG, "getWifiExpandTipsText state:" + this.state + " scene:" + this.scene + " scene invalid!");
                        return "";
                    }
                    return this.tipsTextData.getVaRestartText();
                }
                return this.tipsTextData.getRestartText();
            case 5:
                return this.tipsTextData.getErrorText();
            case 7:
                return this.tipsTextData.getAutoRestartText();
            default:
                QMLog.e(TAG, "getWifiExpandTipsText state:" + this.state + " invalid!");
                return "";
        }
    }

    private final String getWlanExpandTipsText() {
        switch (this.state) {
            case 1:
            case 6:
                int i3 = this.scene;
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            QMLog.e(TAG, "getWlanExpandTipsText state:" + this.state + " scene:" + this.scene + " invalid!");
                            return "";
                        }
                        return this.tipsTextData.getVaInitText();
                    }
                    return this.tipsTextData.getWlanTipsInGameText();
                }
                return this.tipsTextData.getWlanTipsInQueueText();
            case 2:
                int i16 = this.scene;
                if (i16 != 1) {
                    if (i16 != 2) {
                        if (i16 != 3) {
                            QMLog.e(TAG, "getWlanExpandTipsText state:" + this.state + " scene:" + this.scene + " scene invalid!");
                            return "";
                        }
                        return com.tencent.qqmini.minigame.utils.c.f346835a.a(this.tipsTextData.getVaWlanLoadingText(), "\u6b63\u5728\u52a0\u8f7d\u4e2d", Integer.valueOf(this.process), com.tencent.qqmini.minigame.yungame.va.c.b(this.downloadedSize, this.pkgSize));
                    }
                    return com.tencent.qqmini.minigame.utils.c.f346835a.a(this.tipsTextData.getWlanLoadingInGameText(), "\u6b63\u5728\u52a0\u8f7d\u4e2d", Integer.valueOf(this.process), com.tencent.qqmini.minigame.yungame.va.c.b(this.downloadedSize, this.pkgSize));
                }
                return com.tencent.qqmini.minigame.utils.c.f346835a.a(this.tipsTextData.getWlanLoadingInQueueText(), "\u6b63\u5728\u52a0\u8f7d\u4e2d", Integer.valueOf(this.process), com.tencent.qqmini.minigame.yungame.va.c.b(this.downloadedSize, this.pkgSize));
            case 3:
                int i17 = this.scene;
                if (i17 != 1 && i17 != 2) {
                    if (i17 != 3) {
                        QMLog.e(TAG, "getWlanExpandTipsText state:" + this.state + " scene:" + this.scene + " scene invalid!");
                        return "";
                    }
                    return com.tencent.qqmini.minigame.utils.c.f346835a.a(this.tipsTextData.getVaWlanStopText(), "\u5df2\u6682\u505c", Integer.valueOf(this.process), com.tencent.qqmini.minigame.yungame.va.c.b(this.downloadedSize, this.pkgSize));
                }
                return com.tencent.qqmini.minigame.utils.c.f346835a.a(this.tipsTextData.getWlanStopText(), "\u5df2\u6682\u505c", Integer.valueOf(this.process), com.tencent.qqmini.minigame.yungame.va.c.b(this.downloadedSize, this.pkgSize));
            case 4:
                int i18 = this.scene;
                if (i18 != 1 && i18 != 2) {
                    if (i18 != 3) {
                        QMLog.e(TAG, "getWlanExpandTipsText state:" + this.state + " scene:" + this.scene + " scene invalid!");
                        return "";
                    }
                    return this.tipsTextData.getVaRestartText();
                }
                return this.tipsTextData.getRestartText();
            case 5:
                return this.tipsTextData.getErrorText();
            case 7:
                return this.tipsTextData.getAutoRestartText();
            default:
                QMLog.e(TAG, "getWlanExpandTipsText state:" + this.state + " invalid!");
                return "";
        }
    }

    private final void handleLeftTextClick() {
        boolean z16;
        String str;
        String str2;
        QMLog.d(TAG, "on left text Click");
        if (this.dualChannelShowing) {
            onDualChanelRefuseClick();
            com.tencent.qqmini.minigame.yungame.va.d.a("989481", "20", this.gameId, null, null, null, null, null);
            return;
        }
        View rootView = getRootView();
        Intrinsics.checkExpressionValueIsNotNull(rootView, "rootView");
        Context context = rootView.getContext();
        if (this.scene != 3) {
            z16 = true;
        } else {
            z16 = false;
        }
        Dialog createYunGameVARetainDialog = createYunGameVARetainDialog(context, z16, 230, 6, new b(), new c());
        String str3 = "1";
        if (createYunGameVARetainDialog != null) {
            createYunGameVARetainDialog.show();
            String str4 = this.gameId;
            int i3 = this.scene;
            if (i3 == 1) {
                str = "1";
            } else {
                if (i3 != 2) {
                    if (i3 == 3) {
                        str = "5";
                    } else {
                        str2 = "";
                    }
                } else {
                    str2 = "3";
                }
                str = str2;
            }
            com.tencent.qqmini.minigame.yungame.va.d.a("989329", "8", str4, null, str, "", null, null);
        } else {
            QMLog.e(TAG, "create left dialog error");
            a aVar = this.operateClickListener;
            if (aVar != null) {
                aVar.onCancelClick();
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.put("ext6", String.valueOf(this.gameVersionCode));
        hashMap.put("ext7", "5");
        if (this.scene == 3) {
            str3 = "2";
        }
        hashMap.put("ext8", str3);
        hashMap.put("ext29", String.valueOf(this.scene));
        hashMap.put("ext49", String.valueOf(this.process));
        com.tencent.qqmini.minigame.yungame.va.d.b("929208", "20", this.gameId, hashMap);
    }

    private final void handleMoveAction(int xDistance, int yDistance) {
        int bottom;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (!(layoutParams instanceof FrameLayout.LayoutParams)) {
            layoutParams = null;
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        if (layoutParams2 == null) {
            layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        }
        int i3 = layoutParams2.rightMargin;
        int i16 = layoutParams2.leftMargin;
        int i17 = layoutParams2.topMargin;
        int i18 = this.sh;
        int i19 = 0;
        if (i18 <= 0) {
            bottom = 0;
        } else {
            bottom = i18 - getBottom();
        }
        int max = i17 + Math.max(Math.min(yDistance, bottom), -getTop());
        if (layoutParams2.gravity == 8388613) {
            i3 -= Math.max(Math.min(xDistance, layoutParams2.rightMargin), -getLeft());
            if (this.menuButtonRect != null) {
                int dpToPx = ViewUtils.dpToPx(r10.getBottom()) + ViewUtils.dip2px(8.0f);
                int i26 = this.sw;
                if (i26 > 0) {
                    i19 = (i26 - ViewUtils.dpToPx(r10.getLeft())) + ViewUtils.dip2px(20.0f);
                }
                if (max < dpToPx && i3 < i19) {
                    i3 = i19;
                }
            }
        } else {
            int i27 = this.sw;
            if (this.menuButtonRect != null && max < ViewUtils.dpToPx(r4.getBottom()) + ViewUtils.dip2px(8.0f)) {
                i27 = ViewUtils.dpToPx(r4.getLeft()) - ViewUtils.dip2px(20.0f);
            }
            if (i27 > 0) {
                i19 = i27 - getRight();
            }
            i16 += Math.max(Math.min(xDistance, i19), -layoutParams2.leftMargin);
        }
        layoutParams2.rightMargin = i3;
        layoutParams2.leftMargin = i16;
        layoutParams2.topMargin = max;
        setLayoutParams(layoutParams2);
    }

    private final void handleRightTextClick() {
        boolean z16;
        Object obj;
        String str;
        if (this.dualChannelShowing) {
            onSwitchOnDualChannel();
            com.tencent.qqmini.minigame.yungame.va.d.a("989480", "20", this.gameId, null, null, null, null, null);
            return;
        }
        int i3 = this.state;
        String str2 = "1";
        String str3 = "4";
        if (i3 != 2) {
            if (i3 == 3) {
                a aVar = this.operateClickListener;
                if (aVar != null) {
                    aVar.onContinueClick();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("ext6", String.valueOf(this.gameVersionCode));
                hashMap.put("ext7", "4");
                if (this.scene == 3) {
                    str2 = "2";
                }
                hashMap.put("ext8", str2);
                hashMap.put("ext29", String.valueOf(this.scene));
                hashMap.put("ext49", String.valueOf(this.process));
                com.tencent.qqmini.minigame.yungame.va.d.b("929208", "20", this.gameId, hashMap);
                return;
            }
            return;
        }
        QMLog.d(TAG, "onStopClick");
        View rootView = getRootView();
        Intrinsics.checkExpressionValueIsNotNull(rootView, "rootView");
        Context context = rootView.getContext();
        if (this.scene != 3) {
            z16 = true;
        } else {
            z16 = false;
        }
        Dialog createYunGameVARetainDialog = createYunGameVARetainDialog(context, z16, 230, 3, new d(), new e());
        if (createYunGameVARetainDialog != null) {
            createYunGameVARetainDialog.show();
            String str4 = this.gameId;
            int i16 = this.scene;
            if (i16 == 1) {
                str = "2";
            } else {
                if (i16 != 2) {
                    if (i16 != 3) {
                        str3 = "";
                    } else {
                        str3 = "6";
                    }
                }
                str = str3;
            }
            com.tencent.qqmini.minigame.yungame.va.d.a("989329", "8", str4, null, str, "", null, null);
        } else {
            QMLog.e(TAG, "create right dialog error");
            a aVar2 = this.operateClickListener;
            if (aVar2 != null) {
                aVar2.onStopClick();
            }
            updateExpand(false);
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("ext6", String.valueOf(this.gameVersionCode));
        hashMap2.put("ext7", "2");
        if (this.scene != 3) {
            obj = "1";
        } else {
            obj = "2";
        }
        hashMap2.put("ext8", obj);
        hashMap2.put("ext29", String.valueOf(this.scene));
        hashMap2.put("ext49", String.valueOf(this.process));
        com.tencent.qqmini.minigame.yungame.va.d.b("929208", "20", this.gameId, hashMap2);
    }

    private final void handleSingleTextClick() {
        int i3 = this.state;
        String str = "2";
        if (i3 != 1) {
            if (i3 != 4) {
                if (i3 == 5 || i3 == 6) {
                    a aVar = this.operateClickListener;
                    if (aVar != null) {
                        aVar.onRetryClick();
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("ext6", String.valueOf(this.gameVersionCode));
                    hashMap.put("ext7", "3");
                    if (this.scene != 3) {
                        str = "1";
                    }
                    hashMap.put("ext8", str);
                    hashMap.put("ext29", String.valueOf(this.scene));
                    hashMap.put("ext49", String.valueOf(this.process));
                    com.tencent.qqmini.minigame.yungame.va.d.b("929208", "20", this.gameId, hashMap);
                    return;
                }
                return;
            }
            a aVar2 = this.operateClickListener;
            if (aVar2 != null) {
                aVar2.onRestartClick();
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("ext6", String.valueOf(this.gameVersionCode));
            if (this.scene != 3) {
                str = "1";
            }
            hashMap2.put("ext8", str);
            hashMap2.put("ext29", "1");
            com.tencent.qqmini.minigame.yungame.va.d.b("929213", "20", this.gameId, hashMap2);
            return;
        }
        a aVar3 = this.operateClickListener;
        if (aVar3 != null) {
            aVar3.onStartDownloadClick();
        }
        HashMap hashMap3 = new HashMap();
        hashMap3.put("ext6", String.valueOf(this.gameVersionCode));
        hashMap3.put("ext7", "1");
        if (this.scene != 3) {
            str = "1";
        }
        hashMap3.put("ext8", str);
        hashMap3.put("ext29", "1");
        hashMap3.put("ext49", String.valueOf(this.process));
        com.tencent.qqmini.minigame.yungame.va.d.b("929208", "20", this.gameId, hashMap3);
    }

    private final void onDualChanelRefuseClick() {
        this.uiHandler.removeCallbacks(this.dualChannelSwitchTimeoutRunnable);
        this.dualChannelShowing = false;
        updateView();
        com.tencent.qqmini.minigame.yungame.va.a aVar = this.dualChannelDelegate;
        if (aVar != null) {
            aVar.reset();
        }
    }

    private final void onSwitchOnDualChannel() {
        this.uiHandler.removeCallbacks(this.dualChannelSwitchTimeoutRunnable);
        this.dualChannelShowing = false;
        updateView();
        com.tencent.qqmini.minigame.yungame.va.a aVar = this.dualChannelDelegate;
        if (aVar != null) {
            aVar.b(true);
        }
        a aVar2 = this.operateClickListener;
        if (aVar2 != null) {
            aVar2.onDualChannelSwitch();
        }
    }

    public static /* synthetic */ void show$default(VAFloatDownloadTips vAFloatDownloadTips, boolean z16, MenuButtonRect menuButtonRect, String str, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                menuButtonRect = null;
            }
            if ((i3 & 4) != 0) {
                str = null;
            }
            vAFloatDownloadTips.show(z16, menuButtonRect, str);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: show");
    }

    private final void showDualChannelDownloadTips() {
        this.expand = false;
        this.dualChannelShowing = true;
        this.tipsIcon.setVisibility(8);
        this.tipsText.setText(this.tipsTextData.getDualChannelDownloadTipsTest());
        this.operateLayout.setVisibility(0);
        this.operateSingleText.setVisibility(8);
        this.operateLeftText.setText(this.tipsTextData.getDualChannelDownloadLeftBtnTest());
        this.operateRightText.setText(this.tipsTextData.getDualChannelDownloadRightBtnTest());
        this.operatePairLayout.setVisibility(0);
        com.tencent.qqmini.minigame.yungame.va.d.a("989479", "8", this.gameId, null, null, null, null, null);
    }

    private final void updateAutoRestartView() {
        this.tipsIcon.setImageResource(R.drawable.mini_game_va_float_download_tips_normal_icon);
        this.tipsIcon.setVisibility(8);
        this.tipsText.setText(getTipsText());
        this.operateLayout.setVisibility(8);
    }

    private final void updateErrorView() {
        this.tipsIcon.setImageResource(R.drawable.mini_game_va_float_download_tips_normal_icon);
        this.tipsIcon.setVisibility(8);
        this.tipsText.setText(getTipsText());
        this.operateSingleText.setText(this.tipsTextData.getErrorBtnText());
        this.operateLayout.setVisibility(0);
        this.operateSingleText.setVisibility(0);
        this.operatePairLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateExpand(boolean expand2) {
        this.expand = expand2;
        updateView();
    }

    private final void updateLoadingView() {
        if (this.dualChannelShowing) {
            return;
        }
        int i3 = 0;
        if (this.expand) {
            this.tipsIcon.setVisibility(8);
            this.tipsText.setText(getTipsText());
            this.operateLayout.setVisibility(0);
            this.operateSingleText.setVisibility(8);
            this.operateLeftText.setText(this.tipsTextData.getLoadingLeftBtnText());
            this.operateRightText.setText(this.tipsTextData.getLoadingRightBtnText());
            LinearLayout linearLayout = this.operatePairLayout;
            if (this.isWifi && this.scene != 3 && this.hideCancelAndStop) {
                i3 = 8;
            }
            linearLayout.setVisibility(i3);
            return;
        }
        this.tipsIcon.setImageResource(R.drawable.mini_game_va_float_download_tips_pause_icon);
        this.tipsIcon.setVisibility(0);
        this.tipsText.setText(getTipsText());
        this.operateLayout.setVisibility(8);
    }

    private final void updateRestartView() {
        this.tipsIcon.setImageResource(R.drawable.mini_game_va_float_download_tips_normal_icon);
        this.tipsIcon.setVisibility(8);
        this.tipsText.setText(getTipsText());
        this.operateSingleText.setText(this.tipsTextData.getRestartBtnText());
        this.operateLayout.setVisibility(0);
        this.operateSingleText.setVisibility(0);
        this.operatePairLayout.setVisibility(8);
    }

    private final void updateStopView() {
        if (this.expand) {
            this.tipsIcon.setVisibility(8);
            this.tipsText.setText(getTipsText());
            this.operateLayout.setVisibility(0);
            this.operateSingleText.setVisibility(8);
            this.operateLeftText.setText(this.tipsTextData.getStopLeftBtnText());
            this.operateRightText.setText(this.tipsTextData.getStopRightBtnText());
            this.operatePairLayout.setVisibility(0);
            return;
        }
        this.tipsIcon.setImageResource(R.drawable.mini_game_va_float_download_tips_download_icon);
        this.tipsIcon.setVisibility(0);
        this.tipsText.setText(getTipsText());
        this.operateLayout.setVisibility(8);
    }

    private final void updateTipsView() {
        if (this.expand) {
            this.tipsIcon.setVisibility(8);
            this.tipsText.setText(getTipsText());
            this.operateSingleText.setText(this.tipsTextData.getTipsBtnText());
            this.operateLayout.setVisibility(0);
            this.operateSingleText.setVisibility(0);
            this.operatePairLayout.setVisibility(8);
            return;
        }
        this.tipsIcon.setImageResource(R.drawable.mini_game_va_float_download_tips_download_icon);
        this.tipsIcon.setVisibility(0);
        this.tipsText.setText(getTipsText());
        this.operateLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateView() {
        switch (this.state) {
            case 1:
                updateTipsView();
                break;
            case 2:
                updateLoadingView();
                break;
            case 3:
                updateStopView();
                break;
            case 4:
                updateRestartView();
                break;
            case 5:
                updateErrorView();
                break;
            case 6:
                updateTipsView();
                break;
            case 7:
                updateAutoRestartView();
                break;
        }
        checkAndUpdateViewLp();
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i3) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i3));
        if (view == null) {
            View findViewById = findViewById(i3);
            this._$_findViewCache.put(Integer.valueOf(i3), findViewById);
            return findViewById;
        }
        return view;
    }

    @Nullable
    public Dialog createYunGameVARetainDialog(@Nullable Context context, boolean needAwardIcon, int type, int state, @Nullable DialogInterface.OnClickListener onConfirm, @Nullable DialogInterface.OnClickListener onCancel) {
        String vaRetainStopText;
        String vaRetainStopLeftBtnText;
        String vaRetainStopRightBtnText;
        String vaRetainStopText2;
        String vaRetainStopLeftBtnText2;
        String vaRetainStopRightBtnText2;
        String retainStopText;
        String retainStopRightBtnText;
        String retainStopLeftBtnText;
        Dialog dialog = null;
        if (context == null) {
            QMLog.e(TAG, "createQQCenterTextDialog context is null");
            return null;
        }
        if (needAwardIcon) {
            lu3.b bVar = new lu3.b(context, com.tencent.qqmini.sdk.R.style.mini_sdk_MiniAppInputDialog);
            bVar.setContentView(R.layout.mini_game_va_download_retain_dialog);
            VACustomTextConfig vACustomTextConfig = this.tipsTextData;
            if (state == 6) {
                retainStopText = vACustomTextConfig.getRetainCancelText();
            } else {
                retainStopText = vACustomTextConfig.getRetainStopText();
            }
            bVar.S(retainStopText);
            bVar.Q(this.tipsTextData.getRetainDialogBgUrl());
            VACustomTextConfig vACustomTextConfig2 = this.tipsTextData;
            if (state == 6) {
                retainStopRightBtnText = vACustomTextConfig2.getRetainCancelRightBtnText();
            } else {
                retainStopRightBtnText = vACustomTextConfig2.getRetainStopRightBtnText();
            }
            bVar.P(retainStopRightBtnText, onConfirm);
            VACustomTextConfig vACustomTextConfig3 = this.tipsTextData;
            if (state == 6) {
                retainStopLeftBtnText = vACustomTextConfig3.getRetainCancelLeftBtnText();
            } else {
                retainStopLeftBtnText = vACustomTextConfig3.getRetainStopLeftBtnText();
            }
            bVar.R(retainStopLeftBtnText, onCancel);
            bVar.O(onConfirm);
            bVar.setCanceledOnTouchOutside(false);
            return bVar;
        }
        QQCustomizedProxy qQCustomizedProxy = (QQCustomizedProxy) ProxyManager.get(QQCustomizedProxy.class);
        if (qQCustomizedProxy != null) {
            VACustomTextConfig vACustomTextConfig4 = this.tipsTextData;
            if (state == 6) {
                vaRetainStopText2 = vACustomTextConfig4.getVaRetainCancelText();
            } else {
                vaRetainStopText2 = vACustomTextConfig4.getVaRetainStopText();
            }
            String str = vaRetainStopText2;
            VACustomTextConfig vACustomTextConfig5 = this.tipsTextData;
            if (state == 6) {
                vaRetainStopLeftBtnText2 = vACustomTextConfig5.getVaRetainCancelLeftBtnText();
            } else {
                vaRetainStopLeftBtnText2 = vACustomTextConfig5.getVaRetainStopLeftBtnText();
            }
            String str2 = vaRetainStopLeftBtnText2;
            VACustomTextConfig vACustomTextConfig6 = this.tipsTextData;
            if (state == 6) {
                vaRetainStopRightBtnText2 = vACustomTextConfig6.getVaRetainCancelRightBtnText();
            } else {
                vaRetainStopRightBtnText2 = vACustomTextConfig6.getVaRetainStopRightBtnText();
            }
            dialog = qQCustomizedProxy.createQQCenterTextDialog(context, type, null, str, str2, vaRetainStopRightBtnText2, onConfirm, onCancel);
        }
        if (dialog == null) {
            VACustomTextConfig vACustomTextConfig7 = this.tipsTextData;
            if (state == 6) {
                vaRetainStopText = vACustomTextConfig7.getVaRetainCancelText();
            } else {
                vaRetainStopText = vACustomTextConfig7.getVaRetainStopText();
            }
            String str3 = vaRetainStopText;
            VACustomTextConfig vACustomTextConfig8 = this.tipsTextData;
            if (state == 6) {
                vaRetainStopLeftBtnText = vACustomTextConfig8.getVaRetainCancelLeftBtnText();
            } else {
                vaRetainStopLeftBtnText = vACustomTextConfig8.getVaRetainStopLeftBtnText();
            }
            String str4 = vaRetainStopLeftBtnText;
            VACustomTextConfig vACustomTextConfig9 = this.tipsTextData;
            if (state == 6) {
                vaRetainStopRightBtnText = vACustomTextConfig9.getVaRetainCancelRightBtnText();
            } else {
                vaRetainStopRightBtnText = vACustomTextConfig9.getVaRetainStopRightBtnText();
            }
            return DialogUtil.createCustomDialog(context, type, (String) null, str3, str4, vaRetainStopRightBtnText, onConfirm, onCancel);
        }
        return dialog;
    }

    public final void enableDualChannelTask(boolean enable) {
        com.tencent.qqmini.minigame.yungame.va.a aVar = this.dualChannelDelegate;
        if (aVar != null) {
            aVar.c(enable);
        }
        if (!enable) {
            this.uiHandler.removeCallbacks(this.dualChannelSwitchTimeoutRunnable);
            this.dualChannelShowing = false;
            updateView();
        }
    }

    public final float getDragDownX() {
        return this.dragDownX;
    }

    public final float getDragDownY() {
        return this.dragDownY;
    }

    public final int getProcess() {
        return this.process;
    }

    @NotNull
    public final VACustomTextConfig getTipsTextData() {
        return this.tipsTextData;
    }

    public final long getTouchStart() {
        return this.touchStart;
    }

    /* renamed from: isDrag, reason: from getter */
    public final boolean getIsDrag() {
        return this.isDrag;
    }

    /* renamed from: isDraging, reason: from getter */
    public final boolean getIsDraging() {
        return this.isDraging;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.uiHandler.removeCallbacks(this.foldedRunnable);
        if (Intrinsics.areEqual(view, this.operateSingleText)) {
            handleSingleTextClick();
        } else if (Intrinsics.areEqual(view, this.operateLeftText)) {
            handleLeftTextClick();
        } else if (Intrinsics.areEqual(view, this.operateRightText)) {
            handleRightTextClick();
        } else if (Intrinsics.areEqual(view, this) && !this.expand) {
            updateExpand(true);
        }
        this.uiHandler.postDelayed(this.foldedRunnable, 3000L);
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void onDestroy() {
        this.uiHandler.removeCallbacks(this.foldedRunnable);
    }

    @Override // android.view.View
    public boolean onTouchEvent(@Nullable MotionEvent event) {
        if (event != null) {
            float x16 = event.getX();
            float y16 = event.getY();
            int action = event.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        int i3 = (int) (x16 - this.dragDownX);
                        int i16 = (int) (y16 - this.dragDownY);
                        if (i3 != 0 && i16 != 0) {
                            handleMoveAction(i3, i16);
                            this.isDraging = true;
                            this.isDrag = true;
                        }
                    }
                } else if (this.isDraging) {
                    this.uiHandler.removeCallbacks(this.foldedRunnable);
                    this.uiHandler.postDelayed(this.foldedRunnable, 3000L);
                    this.isDraging = false;
                }
            } else {
                this.touchStart = System.currentTimeMillis();
                this.dragDownX = event.getX();
                this.dragDownY = event.getY();
                this.isDraging = false;
                this.isDrag = false;
            }
            if (this.isDrag) {
                return true;
            }
            return super.onTouchEvent(event);
        }
        return super.onTouchEvent(event);
    }

    public final void resetDownloadProcess() {
        this.process = 0;
        this.downloadedSize = 0L;
        this.pkgSize = 0L;
        updateView();
        com.tencent.qqmini.minigame.yungame.va.a aVar = this.dualChannelDelegate;
        if (aVar != null) {
            aVar.reset();
        }
    }

    public final void setDrag(boolean z16) {
        this.isDrag = z16;
    }

    public final void setDragDownX(float f16) {
        this.dragDownX = f16;
    }

    public final void setDragDownY(float f16) {
        this.dragDownY = f16;
    }

    public final void setDraging(boolean z16) {
        this.isDraging = z16;
    }

    public final void setDualChannelDelegate(@NotNull com.tencent.qqmini.minigame.yungame.va.a delegate) {
        Intrinsics.checkParameterIsNotNull(delegate, "delegate");
        this.dualChannelDelegate = delegate;
        if (delegate != null) {
            delegate.d(this);
        }
    }

    public final void setGameVersionCode(@Nullable String gameVersionCode) {
        this.gameVersionCode = gameVersionCode;
    }

    public final void setOperateClickListener(@NotNull a clickListener) {
        Intrinsics.checkParameterIsNotNull(clickListener, "clickListener");
        this.operateClickListener = clickListener;
    }

    public final void setScene(int scene) {
        this.scene = scene;
        if (scene != 3) {
            lu3.b.INSTANCE.a(getContext(), this.tipsTextData.getRetainDialogBgUrl());
        }
    }

    public final void setTouchStart(long j3) {
        this.touchStart = j3;
    }

    public final void show(boolean isWifi, @Nullable MenuButtonRect buttonRect, @Nullable String gameId) {
        if (QMLog.isColorLevel()) {
            QMLog.d(TAG, "show");
        }
        this.gameId = gameId;
        this.isWifi = isWifi;
        this.menuButtonRect = buttonRect;
        updateView();
        setVisibility(0);
        this.uiHandler.removeCallbacks(this.foldedRunnable);
        this.uiHandler.postDelayed(this.foldedRunnable, 3000L);
        if (this.scene != 3) {
            lu3.b.INSTANCE.a(getContext(), this.tipsTextData.getRetainDialogBgUrl());
        }
    }

    @Override // com.tencent.qqmini.minigame.yungame.va.a.InterfaceC9397a
    public boolean showDualChannelTips() {
        QMLog.i(TAG, "showDualChannelTips state:" + this.state);
        if (this.state != 2) {
            com.tencent.qqmini.minigame.yungame.va.a aVar = this.dualChannelDelegate;
            if (aVar != null) {
                aVar.reset();
                return false;
            }
            return false;
        }
        showDualChannelDownloadTips();
        this.uiHandler.postDelayed(this.dualChannelSwitchTimeoutRunnable, 10000L);
        return true;
    }

    public final void updateDownloadProcess(int process, long downloadedSize, long pkgSize) {
        this.process = process;
        this.downloadedSize = downloadedSize;
        this.pkgSize = pkgSize;
        updateView();
    }

    public final void updateState(int state) {
        com.tencent.qqmini.minigame.yungame.va.a aVar;
        checkAutoFold(state);
        this.state = state;
        updateView();
        if (state != 2 && (aVar = this.dualChannelDelegate) != null) {
            aVar.reset();
        }
    }

    public final void updateWifiState(boolean isWifi) {
        if (QMLog.isColorLevel()) {
            QMLog.d(TAG, "updateWifiState isWifi:" + isWifi);
        }
        if (this.isWifi && !isWifi) {
            this.hideCancelAndStop = false;
        }
        this.isWifi = isWifi;
        updateView();
    }

    public final void updateDownloadProcess(int process) {
        this.process = process;
        updateView();
    }
}
