package com.tencent.mobileqq.minigame.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.image.URLDrawable;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.minigame.data.SparkIncomeInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.launcher.utils.LiuHaiUtils;
import cooperation.vip.tianshu.TianShuMMKVConstant;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 '2\u00020\u0001:\u0004&'()B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\rH\u0002J\u0018\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0016H\u0002J\b\u0010\u001e\u001a\u00020\nH\u0002J\u0006\u0010\u001f\u001a\u00020\u0012J\u0006\u0010 \u001a\u00020\u0012J\u0006\u0010!\u001a\u00020\u0012J\u0010\u0010\"\u001a\u00020\u00122\b\u0010#\u001a\u0004\u0018\u00010$J\b\u0010%\u001a\u00020\u0012H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00060\u0010R\u00020\u0000X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/minigame/ui/SparkRewardPopup;", "", "context", "Landroid/content/Context;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/view/View;", "(Landroid/content/Context;Landroid/view/View;)V", "appId", "", TianShuMMKVConstant.LicenseInfoKey.CAN_SHOW, "", "infoQueue", "Ljava/util/LinkedList;", "Lcom/tencent/mobileqq/minigame/data/SparkRewardInfo;", "isShowing", "receiver", "Lcom/tencent/mobileqq/minigame/ui/SparkRewardPopup$SparkRewardReceiver;", "autoDismiss", "", "popupWindow", "Landroid/widget/PopupWindow;", "calculateYOffset", "", "createSparkView", "info", "dip2px", "value", "", "exposureReport", "type", "isPortrait", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onResume", DKHippyEvent.EVENT_STOP, "setAppInfo", "miniAppInfo", "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;", "showPrompt", "AutoDismissTask", "Companion", "DismissListener", "SparkRewardReceiver", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class SparkRewardPopup {
    private static final String TAG = "SparkRewardPopup";
    private String appId;
    private boolean canShow;
    private final Context context;
    private final LinkedList<SparkIncomeInfo> infoQueue;
    private boolean isShowing;
    private final SparkRewardReceiver receiver;
    private final View rootView;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0016R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00030\u00030\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/minigame/ui/SparkRewardPopup$AutoDismissTask;", "Ljava/lang/Runnable;", "popupWindow", "Landroid/widget/PopupWindow;", "(Landroid/widget/PopupWindow;)V", "popupWindowRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", TencentLocation.RUN_MODE, "", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class AutoDismissTask implements Runnable {
        private final WeakReference<PopupWindow> popupWindowRef;

        public AutoDismissTask(PopupWindow popupWindow) {
            Intrinsics.checkNotNullParameter(popupWindow, "popupWindow");
            this.popupWindowRef = new WeakReference<>(popupWindow);
        }

        @Override // java.lang.Runnable
        public void run() {
            PopupWindow popupWindow = this.popupWindowRef.get();
            if (popupWindow != null) {
                popupWindow.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0016R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00030\u00030\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/minigame/ui/SparkRewardPopup$DismissListener;", "Landroid/widget/PopupWindow$OnDismissListener;", "rewardPopup", "Lcom/tencent/mobileqq/minigame/ui/SparkRewardPopup;", "(Lcom/tencent/mobileqq/minigame/ui/SparkRewardPopup;)V", "rewardPopupRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "onDismiss", "", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class DismissListener implements PopupWindow.OnDismissListener {
        private final WeakReference<SparkRewardPopup> rewardPopupRef;

        public DismissListener(SparkRewardPopup rewardPopup) {
            Intrinsics.checkNotNullParameter(rewardPopup, "rewardPopup");
            this.rewardPopupRef = new WeakReference<>(rewardPopup);
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            SparkRewardPopup sparkRewardPopup = this.rewardPopupRef.get();
            if (sparkRewardPopup != null) {
                sparkRewardPopup.isShowing = false;
                sparkRewardPopup.showPrompt();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/minigame/ui/SparkRewardPopup$SparkRewardReceiver;", "Landroid/content/BroadcastReceiver;", "(Lcom/tencent/mobileqq/minigame/ui/SparkRewardPopup;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public final class SparkRewardReceiver extends BroadcastReceiver {
        public SparkRewardReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            SparkIncomeInfo sparkIncomeInfo = intent != null ? (SparkIncomeInfo) intent.getParcelableExtra(MiniConst.Spark.KEY_SPARK_REWARD_INFO) : null;
            if (sparkIncomeInfo != null) {
                try {
                    SparkRewardPopup.this.infoQueue.offer(sparkIncomeInfo);
                    SparkRewardPopup.this.showPrompt();
                    return;
                } catch (Exception e16) {
                    QLog.e(SparkRewardPopup.TAG, 1, "onReceive: exception.", e16);
                    return;
                }
            }
            QLog.e(SparkRewardPopup.TAG, 1, "SparkIncomeReceiver onReceiver, info is null");
        }
    }

    public SparkRewardPopup(Context context, View rootView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.context = context;
        this.rootView = rootView;
        SparkRewardReceiver sparkRewardReceiver = new SparkRewardReceiver();
        this.receiver = sparkRewardReceiver;
        this.infoQueue = new LinkedList<>();
        context.registerReceiver(sparkRewardReceiver, new IntentFilter(MiniConst.Spark.RECEIVER_SPARK_REWARD));
    }

    private final void autoDismiss(PopupWindow popupWindow) {
        ThreadManager.getUIHandler().postDelayed(new AutoDismissTask(popupWindow), 3000L);
    }

    private final int calculateYOffset() {
        return DisplayUtil.dip2px(this.context, 49.0f) + ((LiuHaiUtils.isLiuHaiUseValid() && isPortrait()) ? DisplayUtil.getStatusBarHeight(this.context) : 0);
    }

    private final View createSparkView(SparkIncomeInfo info) {
        View rootView = LayoutInflater.from(this.context).inflate(R.layout.dki, (ViewGroup) null, false);
        ViewGroup viewGroup = (ViewGroup) rootView.findViewById(R.id.ren);
        ViewGroup viewGroup2 = (ViewGroup) rootView.findViewById(R.id.rkz);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(dip2px(this.context, 6.0f));
        gradientDrawable.setColor(Color.parseColor("#B3000000"));
        URLDrawable drawable = URLDrawable.getDrawable(info.getIconUrl(), URLDrawable.URLDrawableOptions.obtain());
        boolean z16 = true;
        if (info.getType() == 1) {
            viewGroup2.setVisibility(0);
            viewGroup.setVisibility(8);
            viewGroup2.setBackground(gradientDrawable);
            ((ImageView) rootView.findViewById(R.id.rdv)).setImageDrawable(drawable);
            TextView textView = (TextView) rootView.findViewById(R.id.rls);
            textView.setText(info.getTitle());
            TextView textView2 = (TextView) rootView.findViewById(R.id.rlr);
            String subTitle = info.getSubTitle();
            if (subTitle != null && subTitle.length() != 0) {
                z16 = false;
            }
            if (z16) {
                textView2.setVisibility(8);
            } else {
                textView2.setVisibility(0);
                textView2.setText(info.getSubTitle());
            }
            if (isPortrait()) {
                textView.setMaxWidth((this.context.getResources().getDisplayMetrics().widthPixels * 4) / 7);
            } else {
                textView.setMaxWidth((this.context.getResources().getDisplayMetrics().widthPixels * 3) / 4);
            }
        } else if (info.getType() == 2) {
            viewGroup2.setVisibility(8);
            viewGroup.setVisibility(0);
            viewGroup.setBackground(gradientDrawable);
            ((ImageView) rootView.findViewById(R.id.rdw)).setImageDrawable(drawable);
            ((TextView) rootView.findViewById(R.id.rlk)).setText(info.getTitle());
        }
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        return rootView;
    }

    private final int dip2px(Context context, float value) {
        return DisplayUtil.dip2px(context, value);
    }

    private final void exposureReport(int type) {
        MiniProgramLpReportDC04239.reportAsync("page_view", "em_expo", "minigame_spark_mission_detail", (String) null, String.valueOf(type), (String) null);
    }

    private final boolean isPortrait() {
        return this.context.getResources().getConfiguration().orientation == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showPrompt() {
        boolean z16 = this.isShowing;
        if (!z16 && this.canShow) {
            if (this.infoQueue.isEmpty()) {
                return;
            }
            SparkIncomeInfo poll = this.infoQueue.poll();
            if (poll != null && poll.getType() != -1) {
                String str = this.appId;
                if (!(str == null || str.length() == 0) && Intrinsics.areEqual(this.appId, poll.getAppId())) {
                    this.isShowing = true;
                    PopupWindow popupWindow = new PopupWindow();
                    popupWindow.setContentView(createSparkView(poll));
                    popupWindow.setWidth(-2);
                    popupWindow.setHeight(dip2px(this.context, 56.0f));
                    popupWindow.showAtLocation(this.rootView, 49, 0, calculateYOffset());
                    popupWindow.setOnDismissListener(new DismissListener(this));
                    exposureReport(poll.getType());
                    autoDismiss(popupWindow);
                    return;
                }
                QLog.e(TAG, 1, "showPrompt: not the same game. appId=" + this.appId + ", infoAppId=" + poll.getAppId());
                return;
            }
            QLog.e(TAG, 1, "showPrompt: info=" + poll);
            return;
        }
        QLog.i(TAG, 1, "showPrompt: isShowing=" + z16 + ", canShow=" + this.canShow);
    }

    public final void onDestroy() {
        this.context.unregisterReceiver(this.receiver);
    }

    public final void onResume() {
        this.canShow = true;
        showPrompt();
    }

    public final void onStop() {
        this.canShow = false;
    }

    public final void setAppInfo(MiniAppInfo miniAppInfo) {
        this.appId = miniAppInfo != null ? miniAppInfo.appId : null;
    }
}
