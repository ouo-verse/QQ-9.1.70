package com.tencent.qqmini.minigame.notifybubble;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.minigame.R;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncMultiObjResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.launcher.widget.SquareImageView;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.utils.ImmersiveUtils;
import com.tencent.qqmini.sdk.utils.ViewUtils;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 s2\u00020\u00012\u00020\u0002:\u0001\u0007B\u0019\u0012\b\u0010p\u001a\u0004\u0018\u00010o\u0012\u0006\u0010j\u001a\u00020 \u00a2\u0006\u0004\bq\u0010rJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002J\u000e\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0015J\u0012\u0010\u001a\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0006\u0010\u001b\u001a\u00020\u0003J\u000e\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\bJ\u0012\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016R\u0014\u0010#\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\"R\u0014\u0010$\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\"R\u0014\u0010&\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010\"R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00104\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00101R\u0014\u00106\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00101R\u0014\u0010:\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010<\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u00109R\u0014\u0010>\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010)R\u0014\u0010@\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010-R\u0014\u0010B\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u00101R\u0014\u0010D\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u00101R\u0014\u0010F\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u00109R\u0014\u0010H\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u00109R\u0014\u0010J\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010)R\u0014\u0010L\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010-R\u0014\u0010N\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u00101R\u0016\u0010\u001c\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010AR\u0016\u0010R\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010T\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010QR\u0016\u0010W\u001a\u00020U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010;R\u0016\u0010Y\u001a\u00020U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010;R\u0016\u0010\\\u001a\u00020Z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010CR\u0016\u0010^\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010AR\u0016\u0010`\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010AR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u001e\u0010f\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u001e\u0010h\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010eR\u0016\u0010j\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010QR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010lR\u0016\u0010n\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010A\u00a8\u0006t"}, d2 = {"Lcom/tencent/qqmini/minigame/notifybubble/MiniGameNotifyBubbleView;", "Landroid/widget/RelativeLayout;", "Landroid/view/View$OnClickListener;", "", VasPerfReportUtils.WHILE_UPDATE_ITEM, "d", "b", "a", "", "xDistance", "yDistance", "c", "Lcom/tencent/qqmini/minigame/notifybubble/MiniGameNotifyBubbleControl;", "controller", "setController", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "setActivity", "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;", "miniAppInfo", "setMiniAppInfo", "Lcom/tencent/qqmini/minigame/notifybubble/a;", "data", "setBubbleData", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "destroy", "state", "e", "Landroid/view/MotionEvent;", "event", "", "dispatchTouchEvent", "Landroid/widget/RelativeLayout;", "unFoldContainer", "foldContainer", "f", "minContainer", "Lcom/tencent/qqmini/sdk/launcher/widget/SquareImageView;", h.F, "Lcom/tencent/qqmini/sdk/launcher/widget/SquareImageView;", "unFoldNotifyIcon", "Landroid/widget/LinearLayout;", "i", "Landroid/widget/LinearLayout;", "unFoldProgressContainer", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "unFoldProgressTxt", BdhLogUtil.LogTag.Tag_Conn, "unFoldMainTips", "D", "unFoldSubTips", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "unFoldMinBtn", UserInfo.SEX_FEMALE, "unFoldCloseBtn", "G", "foldNotifyIcon", "H", "foldProgressContainer", "I", "foldProgressTxt", "J", "foldMainTips", "K", "foldMinBtn", "L", "foldCloseBtn", "M", "minNotifyIcon", "N", "minProgressContainer", "P", "minProgressTxt", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, BdhLogUtil.LogTag.Tag_Req, "Z", "isDraging", ExifInterface.LATITUDE_SOUTH, "isDrag", "", "T", "dragDownX", "U", "dragDownY", "", "V", "touchStart", "W", "screenWidth", "a0", "screenHeight", "b0", "Lcom/tencent/qqmini/minigame/notifybubble/a;", "Ljava/lang/ref/WeakReference;", "c0", "Ljava/lang/ref/WeakReference;", "activityRef", "d0", "controllerRef", "e0", MiniChatConstants.MINI_APP_LANDSCAPE, "f0", "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;", "g0", "foldWidth", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Z)V", "h0", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class MiniGameNotifyBubbleView extends RelativeLayout implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private final TextView unFoldMainTips;

    /* renamed from: D, reason: from kotlin metadata */
    private final TextView unFoldSubTips;

    /* renamed from: E, reason: from kotlin metadata */
    private final ImageView unFoldMinBtn;

    /* renamed from: F, reason: from kotlin metadata */
    private final ImageView unFoldCloseBtn;

    /* renamed from: G, reason: from kotlin metadata */
    private final SquareImageView foldNotifyIcon;

    /* renamed from: H, reason: from kotlin metadata */
    private final LinearLayout foldProgressContainer;

    /* renamed from: I, reason: from kotlin metadata */
    private final TextView foldProgressTxt;

    /* renamed from: J, reason: from kotlin metadata */
    private final TextView foldMainTips;

    /* renamed from: K, reason: from kotlin metadata */
    private final ImageView foldMinBtn;

    /* renamed from: L, reason: from kotlin metadata */
    private final ImageView foldCloseBtn;

    /* renamed from: M, reason: from kotlin metadata */
    private final SquareImageView minNotifyIcon;

    /* renamed from: N, reason: from kotlin metadata */
    private final LinearLayout minProgressContainer;

    /* renamed from: P, reason: from kotlin metadata */
    private final TextView minProgressTxt;

    /* renamed from: Q, reason: from kotlin metadata */
    private int state;

    /* renamed from: R, reason: from kotlin metadata */
    private boolean isDraging;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean isDrag;

    /* renamed from: T, reason: from kotlin metadata */
    private float dragDownX;

    /* renamed from: U, reason: from kotlin metadata */
    private float dragDownY;

    /* renamed from: V, reason: from kotlin metadata */
    private long touchStart;

    /* renamed from: W, reason: from kotlin metadata */
    private int screenWidth;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private int screenHeight;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private MiniGameNotifyBubbleData data;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private WeakReference<Activity> activityRef;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final RelativeLayout unFoldContainer;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private WeakReference<MiniGameNotifyBubbleControl> controllerRef;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final RelativeLayout foldContainer;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private boolean isLandscape;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final RelativeLayout minContainer;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private MiniAppInfo miniAppInfo;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private int foldWidth;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final SquareImageView unFoldNotifyIcon;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final LinearLayout unFoldProgressContainer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final TextView unFoldProgressTxt;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\n\u00a2\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "isSuccess", "", "resultObj", "", "<anonymous parameter 2>", "Lorg/json/JSONObject;", "onReceiveResult"}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes23.dex */
    public static final class b implements AsyncMultiObjResult {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MiniGameNotifyBubbleControl f346568a;

        b(MiniGameNotifyBubbleControl miniGameNotifyBubbleControl) {
            this.f346568a = miniGameNotifyBubbleControl;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncMultiObjResult
        public final void onReceiveResult(boolean z16, @Nullable Object obj, @Nullable JSONObject jSONObject) {
            if (obj != null) {
                ((DialogInterface) obj).dismiss();
                if (!z16) {
                    MiniGameNotifyBubbleControl.j(this.f346568a, false, 1, null);
                    return;
                }
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.content.DialogInterface");
        }
    }

    public MiniGameNotifyBubbleView(@Nullable Context context, boolean z16) {
        super(context);
        int i3;
        this.state = 1;
        this.isLandscape = z16;
        View inflate = LayoutInflater.from(context).inflate(R.layout.mini_game_notify_bubble_view, (ViewGroup) this, true);
        View findViewById = inflate.findViewById(R.id.container_unfold);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "rootView.findViewById(R.id.container_unfold)");
        RelativeLayout relativeLayout = (RelativeLayout) findViewById;
        this.unFoldContainer = relativeLayout;
        relativeLayout.setOnClickListener(this);
        View findViewById2 = inflate.findViewById(R.id.container_fold);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "rootView.findViewById(R.id.container_fold)");
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById2;
        this.foldContainer = relativeLayout2;
        relativeLayout2.setOnClickListener(this);
        View findViewById3 = inflate.findViewById(R.id.container_min);
        Intrinsics.checkExpressionValueIsNotNull(findViewById3, "rootView.findViewById(R.id.container_min)");
        RelativeLayout relativeLayout3 = (RelativeLayout) findViewById3;
        this.minContainer = relativeLayout3;
        relativeLayout3.setOnClickListener(this);
        View findViewById4 = inflate.findViewById(R.id.notify_icon);
        Intrinsics.checkExpressionValueIsNotNull(findViewById4, "rootView.findViewById(R.id.notify_icon)");
        SquareImageView squareImageView = (SquareImageView) findViewById4;
        this.unFoldNotifyIcon = squareImageView;
        squareImageView.setRoundRect(ViewUtils.dpToPx(40.0f));
        View findViewById5 = inflate.findViewById(R.id.progress_container);
        Intrinsics.checkExpressionValueIsNotNull(findViewById5, "rootView.findViewById(R.id.progress_container)");
        this.unFoldProgressContainer = (LinearLayout) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.progress_txt);
        Intrinsics.checkExpressionValueIsNotNull(findViewById6, "rootView.findViewById(R.id.progress_txt)");
        this.unFoldProgressTxt = (TextView) findViewById6;
        View findViewById7 = inflate.findViewById(R.id.main_tips_txt);
        Intrinsics.checkExpressionValueIsNotNull(findViewById7, "rootView.findViewById(R.id.main_tips_txt)");
        this.unFoldMainTips = (TextView) findViewById7;
        View findViewById8 = inflate.findViewById(R.id.sub_tips_txt);
        Intrinsics.checkExpressionValueIsNotNull(findViewById8, "rootView.findViewById(R.id.sub_tips_txt)");
        this.unFoldSubTips = (TextView) findViewById8;
        View findViewById9 = inflate.findViewById(R.id.min_icon);
        Intrinsics.checkExpressionValueIsNotNull(findViewById9, "rootView.findViewById(R.id.min_icon)");
        ImageView imageView = (ImageView) findViewById9;
        this.unFoldMinBtn = imageView;
        imageView.setOnClickListener(this);
        View findViewById10 = inflate.findViewById(R.id.close_icon);
        Intrinsics.checkExpressionValueIsNotNull(findViewById10, "rootView.findViewById(R.id.close_icon)");
        ImageView imageView2 = (ImageView) findViewById10;
        this.unFoldCloseBtn = imageView2;
        imageView2.setOnClickListener(this);
        View findViewById11 = inflate.findViewById(R.id.fold_notify_icon);
        Intrinsics.checkExpressionValueIsNotNull(findViewById11, "rootView.findViewById(R.id.fold_notify_icon)");
        SquareImageView squareImageView2 = (SquareImageView) findViewById11;
        this.foldNotifyIcon = squareImageView2;
        squareImageView2.setRoundRect(ViewUtils.dpToPx(24.0f));
        View findViewById12 = inflate.findViewById(R.id.fold_progress_container);
        Intrinsics.checkExpressionValueIsNotNull(findViewById12, "rootView.findViewById(R.\u2026.fold_progress_container)");
        this.foldProgressContainer = (LinearLayout) findViewById12;
        View findViewById13 = inflate.findViewById(R.id.fold_progress_txt);
        Intrinsics.checkExpressionValueIsNotNull(findViewById13, "rootView.findViewById(R.id.fold_progress_txt)");
        this.foldProgressTxt = (TextView) findViewById13;
        View findViewById14 = inflate.findViewById(R.id.fold_main_tips_txt);
        Intrinsics.checkExpressionValueIsNotNull(findViewById14, "rootView.findViewById(R.id.fold_main_tips_txt)");
        this.foldMainTips = (TextView) findViewById14;
        View findViewById15 = inflate.findViewById(R.id.fold_min_icon);
        Intrinsics.checkExpressionValueIsNotNull(findViewById15, "rootView.findViewById(R.id.fold_min_icon)");
        ImageView imageView3 = (ImageView) findViewById15;
        this.foldMinBtn = imageView3;
        imageView3.setOnClickListener(this);
        View findViewById16 = inflate.findViewById(R.id.fold_close_icon);
        Intrinsics.checkExpressionValueIsNotNull(findViewById16, "rootView.findViewById(R.id.fold_close_icon)");
        ImageView imageView4 = (ImageView) findViewById16;
        this.foldCloseBtn = imageView4;
        imageView4.setOnClickListener(this);
        View findViewById17 = inflate.findViewById(R.id.min_notify_icon);
        Intrinsics.checkExpressionValueIsNotNull(findViewById17, "rootView.findViewById(R.id.min_notify_icon)");
        SquareImageView squareImageView3 = (SquareImageView) findViewById17;
        this.minNotifyIcon = squareImageView3;
        squareImageView3.setRoundRect(ViewUtils.dpToPx(21.6f));
        View findViewById18 = inflate.findViewById(R.id.min_progress_container);
        Intrinsics.checkExpressionValueIsNotNull(findViewById18, "rootView.findViewById(R.id.min_progress_container)");
        this.minProgressContainer = (LinearLayout) findViewById18;
        View findViewById19 = inflate.findViewById(R.id.min_progress_txt);
        Intrinsics.checkExpressionValueIsNotNull(findViewById19, "rootView.findViewById(R.id.min_progress_txt)");
        this.minProgressTxt = (TextView) findViewById19;
        int screenWidth = ViewUtils.getScreenWidth();
        int screenHeight = ViewUtils.getScreenHeight();
        int i16 = ImmersiveUtils.notchHeight;
        QMLog.i("MiniGameNotifyBubbleView", "init notchHeight:" + i16);
        i16 = i16 == 0 ? DisplayUtil.getStatusBarHeight(context) : i16;
        int max = Math.max(screenWidth, screenHeight) + i16;
        int min = Math.min(screenWidth, screenHeight);
        QMLog.i("MiniGameNotifyBubbleView", "init longSide:" + max + ", shortSide:" + min + ", notchHeight:" + i16);
        if (z16) {
            i3 = max;
        } else {
            i3 = min;
        }
        this.screenWidth = i3;
        this.screenHeight = z16 ? min : max;
    }

    private final void a() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (!(layoutParams instanceof FrameLayout.LayoutParams)) {
            layoutParams = null;
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        if (layoutParams2 == null) {
            layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        }
        int i3 = layoutParams2.leftMargin;
        int i16 = this.foldWidth;
        if (i16 == 0) {
            i16 = getWidth();
        }
        int dip2px = (this.screenWidth - ViewUtils.dip2px(16.0f)) - i16;
        QMLog.i("MiniGameNotifyBubbleView", "adjustLayoutParams leftMargin:" + i3 + ", maxLeftMargin:" + dip2px + ", foldContainerWidth:" + i16);
        if (i3 > dip2px) {
            layoutParams2.leftMargin = dip2px;
            setLayoutParams(layoutParams2);
        }
    }

    private final void b() {
        MiniGameNotifyBubbleControl miniGameNotifyBubbleControl;
        Activity activity;
        String str;
        boolean z16;
        String str2;
        QMLog.i("MiniGameNotifyBubbleView", "close");
        WeakReference<MiniGameNotifyBubbleControl> weakReference = this.controllerRef;
        String str3 = null;
        if (weakReference != null) {
            miniGameNotifyBubbleControl = weakReference.get();
        } else {
            miniGameNotifyBubbleControl = null;
        }
        if (miniGameNotifyBubbleControl != null) {
            WeakReference<Activity> weakReference2 = this.activityRef;
            if (weakReference2 != null) {
                activity = weakReference2.get();
            } else {
                activity = null;
            }
            if (activity == null) {
                MiniGameNotifyBubbleControl.j(miniGameNotifyBubbleControl, false, 1, null);
                return;
            }
            MiniGameNotifyBubbleData miniGameNotifyBubbleData = this.data;
            if (miniGameNotifyBubbleData != null) {
                if (miniGameNotifyBubbleData != null) {
                    str = miniGameNotifyBubbleData.getClosePopupText();
                } else {
                    str = null;
                }
                if (str != null && str.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
                    MiniGameNotifyBubbleData miniGameNotifyBubbleData2 = this.data;
                    if (miniGameNotifyBubbleData2 != null) {
                        str3 = miniGameNotifyBubbleData2.getClosePopupText();
                    }
                    channelProxy.showDialog(activity, "\u771f\u7684\u4e0d\u53c2\u52a0\u6d3b\u52a8\u5417?", str3, "\u786e\u8ba4\u5173\u95ed", "\u6211\u518d\u60f3\u60f3", new b(miniGameNotifyBubbleControl));
                    MiniGameNotifyBubbleData miniGameNotifyBubbleData3 = this.data;
                    if (miniGameNotifyBubbleData3 != null) {
                        MiniAppInfo miniAppInfo = this.miniAppInfo;
                        String appType = SDKMiniProgramLpReportDC04239.getAppType(miniAppInfo);
                        if (this.state == 1) {
                            str2 = "1";
                        } else {
                            str2 = "2";
                        }
                        SDKMiniProgramLpReportDC04239.reportWithR7(miniAppInfo, appType, "page_view", "em_click", "minigame_notice_bubble_close_button", str2, String.valueOf(miniGameNotifyBubbleData3.getBubbleType()), "", String.valueOf(miniGameNotifyBubbleData3.getTaskId()), "", String.valueOf(miniGameNotifyBubbleData3.getTaskType()));
                        return;
                    }
                    return;
                }
            }
            MiniGameNotifyBubbleControl.j(miniGameNotifyBubbleControl, false, 1, null);
        }
    }

    private final void c(int xDistance, int yDistance) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (!(layoutParams instanceof FrameLayout.LayoutParams)) {
            layoutParams = null;
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        if (layoutParams2 == null) {
            layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        }
        int i3 = layoutParams2.leftMargin + xDistance;
        int i16 = layoutParams2.topMargin + yDistance;
        int dip2px = ViewUtils.dip2px(16.0f);
        int dip2px2 = (this.screenWidth - ViewUtils.dip2px(16.0f)) - getWidth();
        if (i3 < dip2px) {
            i3 = dip2px;
        } else if (i3 > dip2px2) {
            i3 = dip2px2;
        }
        int dip2px3 = ViewUtils.dip2px(16.0f);
        int dip2px4 = (this.screenHeight - ViewUtils.dip2px(16.0f)) - getHeight();
        if (i16 < dip2px3) {
            i16 = dip2px3;
        } else if (i16 > dip2px4) {
            i16 = dip2px4;
        }
        layoutParams2.leftMargin = i3;
        layoutParams2.topMargin = i16;
        setLayoutParams(layoutParams2);
    }

    private final void d() {
        Activity activity;
        String str;
        String bubbleClickSchema;
        boolean z16;
        QMLog.i("MiniGameNotifyBubbleView", PluginConst.SchemeJsPluginConst.API_OPEN_SCHEME);
        WeakReference<Activity> weakReference = this.activityRef;
        String str2 = null;
        if (weakReference != null) {
            activity = weakReference.get();
        } else {
            activity = null;
        }
        if (activity != null) {
            MiniGameNotifyBubbleData miniGameNotifyBubbleData = this.data;
            if (miniGameNotifyBubbleData != null && (bubbleClickSchema = miniGameNotifyBubbleData.getBubbleClickSchema()) != null) {
                if (bubbleClickSchema.length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
                    MiniGameNotifyBubbleData miniGameNotifyBubbleData2 = this.data;
                    if (miniGameNotifyBubbleData2 != null) {
                        str2 = miniGameNotifyBubbleData2.getBubbleClickSchema();
                    }
                    channelProxy.openSchemeOrUrl(activity, str2, this.isLandscape);
                }
            }
            MiniGameNotifyBubbleData miniGameNotifyBubbleData3 = this.data;
            if (miniGameNotifyBubbleData3 != null) {
                MiniAppInfo miniAppInfo = this.miniAppInfo;
                String appType = SDKMiniProgramLpReportDC04239.getAppType(miniAppInfo);
                if (this.state == 1) {
                    str = "1";
                } else {
                    str = "2";
                }
                SDKMiniProgramLpReportDC04239.reportWithR7(miniAppInfo, appType, "page_view", "em_click", "minigame_notice_bubble", str, String.valueOf(miniGameNotifyBubbleData3.getBubbleType()), "", String.valueOf(miniGameNotifyBubbleData3.getTaskId()), "", String.valueOf(miniGameNotifyBubbleData3.getTaskType()));
            }
        }
    }

    private final void updateView() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        Integer num;
        Integer num2;
        MiniGameNotifyBubbleData miniGameNotifyBubbleData = this.data;
        if (miniGameNotifyBubbleData != null) {
            TextView textView = this.unFoldMainTips;
            Integer num3 = null;
            if (miniGameNotifyBubbleData != null) {
                str = miniGameNotifyBubbleData.getBigBubbleTitle();
            } else {
                str = null;
            }
            textView.setText(str);
            TextView textView2 = this.unFoldSubTips;
            MiniGameNotifyBubbleData miniGameNotifyBubbleData2 = this.data;
            if (miniGameNotifyBubbleData2 != null) {
                str2 = miniGameNotifyBubbleData2.getBigBubbleSubTitle();
            } else {
                str2 = null;
            }
            textView2.setText(str2);
            TextView textView3 = this.foldMainTips;
            MiniGameNotifyBubbleData miniGameNotifyBubbleData3 = this.data;
            if (miniGameNotifyBubbleData3 != null) {
                str3 = miniGameNotifyBubbleData3.getSmallBubbleTitle();
            } else {
                str3 = null;
            }
            textView3.setText(str3);
            MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
            Context context = getContext();
            SquareImageView squareImageView = this.unFoldNotifyIcon;
            MiniGameNotifyBubbleData miniGameNotifyBubbleData4 = this.data;
            if (miniGameNotifyBubbleData4 != null) {
                str4 = miniGameNotifyBubbleData4.getBubbleIcon();
            } else {
                str4 = null;
            }
            miniAppProxy.loadImage(context, squareImageView, str4, ViewUtils.dpToPx(40.0f), ViewUtils.dpToPx(40.0f), new ColorDrawable(0), new ColorDrawable(0));
            Context context2 = getContext();
            SquareImageView squareImageView2 = this.foldNotifyIcon;
            MiniGameNotifyBubbleData miniGameNotifyBubbleData5 = this.data;
            if (miniGameNotifyBubbleData5 != null) {
                str5 = miniGameNotifyBubbleData5.getBubbleIcon();
            } else {
                str5 = null;
            }
            miniAppProxy.loadImage(context2, squareImageView2, str5, ViewUtils.dpToPx(24.0f), ViewUtils.dpToPx(24.0f), new ColorDrawable(0), new ColorDrawable(0));
            Context context3 = getContext();
            SquareImageView squareImageView3 = this.minNotifyIcon;
            MiniGameNotifyBubbleData miniGameNotifyBubbleData6 = this.data;
            if (miniGameNotifyBubbleData6 != null) {
                str6 = miniGameNotifyBubbleData6.getBubbleIcon();
            } else {
                str6 = null;
            }
            miniAppProxy.loadImage(context3, squareImageView3, str6, ViewUtils.dpToPx(21.6f), ViewUtils.dpToPx(21.6f), new ColorDrawable(0), new ColorDrawable(0));
            MiniGameNotifyBubbleData miniGameNotifyBubbleData7 = this.data;
            if (miniGameNotifyBubbleData7 != null && miniGameNotifyBubbleData7.getBubbleType() == 2) {
                this.unFoldProgressContainer.setVisibility(0);
                this.foldProgressContainer.setVisibility(0);
                this.minProgressContainer.setVisibility(0);
                TextView textView4 = this.unFoldProgressTxt;
                MiniGameNotifyBubbleData miniGameNotifyBubbleData8 = this.data;
                if (miniGameNotifyBubbleData8 != null) {
                    num = Integer.valueOf(miniGameNotifyBubbleData8.getTaskProgress());
                } else {
                    num = null;
                }
                textView4.setText(String.valueOf(num));
                TextView textView5 = this.foldProgressTxt;
                MiniGameNotifyBubbleData miniGameNotifyBubbleData9 = this.data;
                if (miniGameNotifyBubbleData9 != null) {
                    num2 = Integer.valueOf(miniGameNotifyBubbleData9.getTaskProgress());
                } else {
                    num2 = null;
                }
                textView5.setText(String.valueOf(num2));
                TextView textView6 = this.minProgressTxt;
                MiniGameNotifyBubbleData miniGameNotifyBubbleData10 = this.data;
                if (miniGameNotifyBubbleData10 != null) {
                    num3 = Integer.valueOf(miniGameNotifyBubbleData10.getTaskProgress());
                }
                textView6.setText(String.valueOf(num3));
                return;
            }
            this.unFoldProgressContainer.setVisibility(8);
            this.foldProgressContainer.setVisibility(8);
            this.minProgressContainer.setVisibility(8);
        }
    }

    public final void destroy() {
        WeakReference<Activity> weakReference = this.activityRef;
        if (weakReference != null) {
            weakReference.clear();
        }
        WeakReference<MiniGameNotifyBubbleControl> weakReference2 = this.controllerRef;
        if (weakReference2 != null) {
            weakReference2.clear();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@Nullable MotionEvent event) {
        if (event != null) {
            float x16 = event.getX();
            float y16 = event.getY();
            int action = event.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        int i3 = (int) (x16 - this.dragDownX);
                        int i16 = (int) (y16 - this.dragDownY);
                        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
                        int abs = Math.abs(i3);
                        Intrinsics.checkExpressionValueIsNotNull(viewConfiguration, "viewConfiguration");
                        if (abs > viewConfiguration.getScaledTouchSlop() || Math.abs(i16) > viewConfiguration.getScaledTouchSlop()) {
                            c(i3, i16);
                            this.isDraging = true;
                            this.isDrag = true;
                        }
                    }
                } else if (this.isDraging) {
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
            return super.dispatchTouchEvent(event);
        }
        return super.dispatchTouchEvent(null);
    }

    public final void e(int state) {
        if (state != 1) {
            if (state != 2) {
                if (state == 3) {
                    this.unFoldContainer.setVisibility(8);
                    this.foldContainer.setVisibility(8);
                    this.minContainer.setVisibility(0);
                }
            } else {
                this.unFoldContainer.setVisibility(8);
                this.foldContainer.setVisibility(0);
                this.minContainer.setVisibility(8);
                a();
            }
        } else {
            this.unFoldContainer.setVisibility(0);
            this.foldContainer.setVisibility(8);
            this.minContainer.setVisibility(8);
        }
        this.state = state;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (Intrinsics.areEqual(v3, this.unFoldContainer)) {
            d();
        } else if (Intrinsics.areEqual(v3, this.foldContainer)) {
            d();
        } else if (Intrinsics.areEqual(v3, this.minContainer)) {
            e(2);
            MiniGameNotifyBubbleData miniGameNotifyBubbleData = this.data;
            if (miniGameNotifyBubbleData != null) {
                MiniAppInfo miniAppInfo = this.miniAppInfo;
                SDKMiniProgramLpReportDC04239.reportWithR7(miniAppInfo, SDKMiniProgramLpReportDC04239.getAppType(miniAppInfo), "page_view", "em_click", "minigame_notice_bubble_fold_state", "", String.valueOf(miniGameNotifyBubbleData.getBubbleType()), "", String.valueOf(miniGameNotifyBubbleData.getTaskId()), "", String.valueOf(miniGameNotifyBubbleData.getTaskType()));
            }
        } else if (Intrinsics.areEqual(v3, this.unFoldMinBtn)) {
            e(3);
            MiniGameNotifyBubbleData miniGameNotifyBubbleData2 = this.data;
            if (miniGameNotifyBubbleData2 != null) {
                MiniAppInfo miniAppInfo2 = this.miniAppInfo;
                SDKMiniProgramLpReportDC04239.reportWithR7(miniAppInfo2, SDKMiniProgramLpReportDC04239.getAppType(miniAppInfo2), "page_view", "em_click", "minigame_notice_bubble_reduce_button", "1", String.valueOf(miniGameNotifyBubbleData2.getBubbleType()), "", String.valueOf(miniGameNotifyBubbleData2.getTaskId()), "", String.valueOf(miniGameNotifyBubbleData2.getTaskType()));
            }
        } else if (Intrinsics.areEqual(v3, this.unFoldCloseBtn)) {
            b();
        } else if (Intrinsics.areEqual(v3, this.foldMinBtn)) {
            this.foldWidth = getWidth();
            e(3);
            MiniGameNotifyBubbleData miniGameNotifyBubbleData3 = this.data;
            if (miniGameNotifyBubbleData3 != null) {
                MiniAppInfo miniAppInfo3 = this.miniAppInfo;
                SDKMiniProgramLpReportDC04239.reportWithR7(miniAppInfo3, SDKMiniProgramLpReportDC04239.getAppType(miniAppInfo3), "page_view", "em_click", "minigame_notice_bubble_reduce_button", "2", String.valueOf(miniGameNotifyBubbleData3.getBubbleType()), "", String.valueOf(miniGameNotifyBubbleData3.getTaskId()), "", String.valueOf(miniGameNotifyBubbleData3.getTaskType()));
            }
        } else if (Intrinsics.areEqual(v3, this.foldCloseBtn)) {
            b();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    public final void setActivity(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        this.activityRef = new WeakReference<>(activity);
    }

    public final void setBubbleData(@NotNull MiniGameNotifyBubbleData data) {
        Intrinsics.checkParameterIsNotNull(data, "data");
        this.data = data;
        updateView();
    }

    public final void setController(@NotNull MiniGameNotifyBubbleControl controller) {
        Intrinsics.checkParameterIsNotNull(controller, "controller");
        this.controllerRef = new WeakReference<>(controller);
    }

    public final void setMiniAppInfo(@NotNull MiniAppInfo miniAppInfo) {
        Intrinsics.checkParameterIsNotNull(miniAppInfo, "miniAppInfo");
        this.miniAppInfo = miniAppInfo;
    }
}
