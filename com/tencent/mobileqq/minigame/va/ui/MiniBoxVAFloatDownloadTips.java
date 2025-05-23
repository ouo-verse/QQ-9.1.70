package com.tencent.mobileqq.minigame.va.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.minibox.common.log.LogUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.minigame.va.ui.MiniBoxVAFloatDownloadTips;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqmini.minigame.yungame.va.VAFloatDownloadTips;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VACustomTextConfig;
import com.tencent.tuxmeterqui.config.TuxUIConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000  2\u00020\u0001:\u0002 !B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J@\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0002J\u0012\u0010\u001d\u001a\u00020\u00132\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/minigame/va/ui/MiniBoxVAFloatDownloadTips;", "Lcom/tencent/qqmini/minigame/yungame/va/VAFloatDownloadTips;", "hostContext", "Landroid/content/Context;", "gameActivity", "Landroid/app/Activity;", "(Landroid/content/Context;Landroid/app/Activity;)V", "actRef", "Lmqq/util/WeakReference;", "downX", "", "downY", "hostContextRef", "lastX", "lastY", "createYunGameVARetainDialog", "Landroid/app/Dialog;", "context", "needAwardIcon", "", "type", "state", "onConfirm", "Landroid/content/DialogInterface$OnClickListener;", "onCancel", "handleDragMove", "", "movedX", "movedY", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "Companion", "MiniBoxVAUpgradeRetainDialog", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniBoxVAFloatDownloadTips extends VAFloatDownloadTips {
    private static final String TAG = "MiniBoxVAFloatDownloadTips";
    private final WeakReference<Activity> actRef;
    private int downX;
    private int downY;
    private final WeakReference<Context> hostContextRef;
    private int lastX;
    private int lastY;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001a\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u001a\u0010\u0013\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00050\u00050\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00030\u00030\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/minigame/va/ui/MiniBoxVAFloatDownloadTips$MiniBoxVAUpgradeRetainDialog;", "Landroid/app/Dialog;", "hostContext", "Landroid/content/Context;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "(Landroid/content/Context;Landroid/app/Activity;)V", "contentView", "Landroid/view/View;", "gameActRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "hostContextRef", "setLeftBtn", "", TuxUIConstants.POP_BTN_TEXT, "", NodeProps.ON_CLICK, "Landroid/content/DialogInterface$OnClickListener;", "setRightBtn", IECSearchBar.METHOD_SET_TEXT, "tips", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class MiniBoxVAUpgradeRetainDialog extends Dialog {
        private static final String TAG = "MiniBoxVAUpgradeRetainDialog";
        private final View contentView;
        private final java.lang.ref.WeakReference<Activity> gameActRef;
        private final java.lang.ref.WeakReference<Context> hostContextRef;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MiniBoxVAUpgradeRetainDialog(Context hostContext, Activity activity) {
            super(activity);
            Intrinsics.checkNotNullParameter(hostContext, "hostContext");
            Intrinsics.checkNotNullParameter(activity, "activity");
            this.hostContextRef = new java.lang.ref.WeakReference<>(hostContext);
            this.gameActRef = new java.lang.ref.WeakReference<>(activity);
            Window window = getWindow();
            if (window != null) {
                window.setDimAmount(0.5f);
            }
            Window window2 = getWindow();
            if (window2 != null) {
                window2.setBackgroundDrawable(new ColorDrawable(0));
            }
            View inflate = LayoutInflater.from(hostContext).inflate(R.layout.djq, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(hostContext).inflat\u2026rade_retain_dialog, null)");
            this.contentView = inflate;
            setContentView(inflate);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setLeftBtn$lambda$1$lambda$0(DialogInterface.OnClickListener onClickListener, MiniBoxVAUpgradeRetainDialog this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (onClickListener != null) {
                onClickListener.onClick(this$0, 0);
            }
            this$0.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setRightBtn$lambda$3$lambda$2(DialogInterface.OnClickListener onClickListener, MiniBoxVAUpgradeRetainDialog this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (onClickListener != null) {
                onClickListener.onClick(this$0, 1);
            }
            this$0.dismiss();
        }

        public final void setLeftBtn(String btnText, final DialogInterface.OnClickListener onClick) {
            TextView textView = (TextView) this.contentView.findViewById(R.id.f163669rd1);
            if (textView != null) {
                textView.setText(btnText);
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.minigame.va.ui.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MiniBoxVAFloatDownloadTips.MiniBoxVAUpgradeRetainDialog.setLeftBtn$lambda$1$lambda$0(onClick, this, view);
                    }
                });
            }
        }

        public final void setRightBtn(String btnText, final DialogInterface.OnClickListener onClick) {
            TextView textView = (TextView) this.contentView.findViewById(R.id.f163670rd2);
            if (textView != null) {
                textView.setText(btnText);
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.minigame.va.ui.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MiniBoxVAFloatDownloadTips.MiniBoxVAUpgradeRetainDialog.setRightBtn$lambda$3$lambda$2(onClick, this, view);
                    }
                });
            }
        }

        public final void setText(String tips) {
            TextView textView = (TextView) this.contentView.findViewById(R.id.rd5);
            if (textView == null) {
                return;
            }
            textView.setText(tips);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniBoxVAFloatDownloadTips(Context hostContext, Activity gameActivity) {
        super(hostContext, 3);
        Intrinsics.checkNotNullParameter(hostContext, "hostContext");
        Intrinsics.checkNotNullParameter(gameActivity, "gameActivity");
        this.actRef = new WeakReference<>(gameActivity);
        this.hostContextRef = new WeakReference<>(hostContext);
    }

    private final void handleDragMove(int movedX, int movedY) {
        int screenWidth;
        int screenHeight;
        Window window;
        WindowManager windowManager;
        Window window2;
        View decorView;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        Display display = null;
        WindowManager.LayoutParams layoutParams2 = layoutParams instanceof WindowManager.LayoutParams ? (WindowManager.LayoutParams) layoutParams : null;
        if (layoutParams2 == null) {
            return;
        }
        Activity activity = this.actRef.get();
        if (activity != null && (window2 = activity.getWindow()) != null && (decorView = window2.getDecorView()) != null) {
            display = decorView.getDisplay();
        }
        if (display != null) {
            screenWidth = display.getWidth();
        } else {
            screenWidth = DisplayUtil.getScreenWidth();
        }
        if (display != null) {
            screenHeight = display.getHeight();
        } else {
            screenHeight = DisplayUtil.getScreenHeight();
        }
        int i3 = layoutParams2.x - movedX;
        layoutParams2.x = i3;
        layoutParams2.y += movedY;
        if (i3 < 0) {
            layoutParams2.x = 0;
        }
        if (layoutParams2.x > screenWidth - getWidth()) {
            layoutParams2.x = screenWidth - getWidth();
        }
        if (layoutParams2.y < 0) {
            layoutParams2.y = 0;
        }
        if (layoutParams2.y > screenHeight - getHeight()) {
            layoutParams2.y = screenHeight - getHeight();
        }
        try {
            Activity activity2 = this.actRef.get();
            if (activity2 == null || (window = activity2.getWindow()) == null || (windowManager = window.getWindowManager()) == null) {
                return;
            }
            windowManager.updateViewLayout(this, layoutParams2);
        } catch (Throwable th5) {
            LogUtils.e(TAG, "handleDragMove: updateViewLayout exception: " + th5.getMessage());
        }
    }

    @Override // com.tencent.qqmini.minigame.yungame.va.VAFloatDownloadTips
    public Dialog createYunGameVARetainDialog(Context context, boolean needAwardIcon, int type, int state, DialogInterface.OnClickListener onConfirm, DialogInterface.OnClickListener onCancel) {
        String vaRetainStopText;
        String vaRetainStopLeftBtnText;
        String vaRetainStopRightBtnText;
        VACustomTextConfig tipsTextData = getTipsTextData();
        if (state == 6) {
            vaRetainStopText = tipsTextData.getVaRetainCancelText();
        } else {
            vaRetainStopText = tipsTextData.getVaRetainStopText();
        }
        VACustomTextConfig tipsTextData2 = getTipsTextData();
        if (state == 6) {
            vaRetainStopLeftBtnText = tipsTextData2.getVaRetainCancelLeftBtnText();
        } else {
            vaRetainStopLeftBtnText = tipsTextData2.getVaRetainStopLeftBtnText();
        }
        if (state == 6) {
            vaRetainStopRightBtnText = getTipsTextData().getVaRetainCancelRightBtnText();
        } else {
            vaRetainStopRightBtnText = getTipsTextData().getVaRetainStopRightBtnText();
        }
        Context context2 = this.hostContextRef.get();
        Activity activity = this.actRef.get();
        if (context2 == null || activity == null) {
            return null;
        }
        MiniBoxVAUpgradeRetainDialog miniBoxVAUpgradeRetainDialog = new MiniBoxVAUpgradeRetainDialog(context2, activity);
        miniBoxVAUpgradeRetainDialog.setText(vaRetainStopText);
        miniBoxVAUpgradeRetainDialog.setLeftBtn(vaRetainStopLeftBtnText, onCancel);
        miniBoxVAUpgradeRetainDialog.setRightBtn(vaRetainStopRightBtnText, onConfirm);
        return miniBoxVAUpgradeRetainDialog;
    }

    @Override // com.tencent.qqmini.minigame.yungame.va.VAFloatDownloadTips, android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (event == null) {
            return super.onTouchEvent(event);
        }
        int action = event.getAction();
        if (action == 0) {
            setTouchStart(System.currentTimeMillis());
            setDragDownX(event.getX());
            setDragDownY(event.getY());
            this.downX = (int) event.getRawX();
            int rawY = (int) event.getRawY();
            this.downY = rawY;
            this.lastX = this.downX;
            this.lastY = rawY;
            setDraging(false);
            setDrag(false);
        } else {
            if (action == 1) {
                return super.onTouchEvent(event);
            }
            if (action == 2) {
                int rawX = (int) event.getRawX();
                int rawY2 = (int) event.getRawY();
                int i3 = rawX - this.lastX;
                int i16 = rawY2 - this.lastY;
                ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
                if (Math.abs(i3) > viewConfiguration.getScaledTouchSlop() || Math.abs(i16) > viewConfiguration.getScaledTouchSlop()) {
                    this.lastX = rawX;
                    this.lastY = rawY2;
                    handleDragMove(i3, i16);
                    setDraging(true);
                    setDrag(true);
                }
            }
        }
        if (getIsDrag()) {
            return true;
        }
        return super.onTouchEvent(event);
    }
}
