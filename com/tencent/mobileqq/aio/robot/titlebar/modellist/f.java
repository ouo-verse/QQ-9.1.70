package com.tencent.mobileqq.aio.robot.titlebar.modellist;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.BasePopupMenuDialog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u001a\u0010\t\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u001e\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0007J\u0010\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u001e\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007J\u0006\u0010\u0017\u001a\u00020\u0002R\u0016\u0010\u001a\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001cR\u001e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u001eR\u0018\u0010!\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010#R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/aio/robot/titlebar/modellist/f;", "", "", "e", "d", "Landroid/widget/PopupWindow;", "popupWindow", "", "type", "g", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/view/View;", "contentView", "margin", "b", "Lcom/tencent/mobileqq/aio/robot/titlebar/modellist/c;", "callback", h.F, "anchorView", "xOffset", "yOffset", "i", "c", "a", "I", "mTotalPopHeight", "Lcom/tencent/widget/BasePopupMenuDialog;", "Lcom/tencent/widget/BasePopupMenuDialog;", "Lmqq/util/WeakReference;", "Lmqq/util/WeakReference;", "weakActivity", "Landroid/view/View;", "dimView", "Landroid/view/WindowManager$LayoutParams;", "Landroid/view/WindowManager$LayoutParams;", "dimViewLp", "f", "Lcom/tencent/mobileqq/aio/robot/titlebar/modellist/c;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int mTotalPopHeight;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BasePopupMenuDialog popupWindow;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<Activity> weakActivity;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View dimView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WindowManager.LayoutParams dimViewLp;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c callback;

    private final void d() {
        Activity activity;
        String str;
        int height;
        WeakReference<Activity> weakReference = this.weakActivity;
        if (weakReference != null && (activity = weakReference.get()) != null) {
            View view = new View(activity);
            if (QQTheme.isNowThemeIsNight()) {
                str = "#7F000000";
            } else {
                str = "#26000000";
            }
            view.setBackgroundColor(Color.parseColor(str));
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.type = 1000;
            layoutParams.format = -3;
            layoutParams.flags = 40;
            if (ImmersiveUtils.isSupporImmersive() == 1) {
                layoutParams.flags |= 67108864;
            }
            int i3 = -1;
            layoutParams.width = -1;
            if (activity.getWindow() != null && (height = activity.getWindow().getDecorView().getHeight()) > 0) {
                i3 = height;
            }
            layoutParams.height = i3;
            this.dimView = view;
            this.dimViewLp = layoutParams;
        }
    }

    private final void e() {
        BasePopupMenuDialog basePopupMenuDialog;
        WeakReference<Activity> weakReference = this.weakActivity;
        if (weakReference != null && weakReference.get() != null && (basePopupMenuDialog = this.popupWindow) != null) {
            basePopupMenuDialog.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.tencent.mobileqq.aio.robot.titlebar.modellist.e
                @Override // android.widget.PopupWindow.OnDismissListener
                public final void onDismiss() {
                    f.f(f.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(f this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.c();
    }

    private final void g(PopupWindow popupWindow, int type) {
        Method[] methods = PopupWindow.class.getMethods();
        Intrinsics.checkNotNullExpressionValue(methods, "methods");
        for (Method method : methods) {
            if (Intrinsics.areEqual(method.getName(), "setWindowLayoutType")) {
                try {
                    method.invoke(popupWindow, Integer.valueOf(type));
                    return;
                } catch (Exception e16) {
                    e16.printStackTrace();
                    return;
                }
            }
        }
    }

    public final void b(@NotNull Activity activity, @NotNull View contentView, int margin) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        if (this.popupWindow != null) {
            return;
        }
        this.weakActivity = new WeakReference<>(activity);
        d();
        BasePopupMenuDialog basePopupMenuDialog = new BasePopupMenuDialog(contentView, activity.getWindow().getDecorView().getWidth() - (margin * 2), -2, true);
        basePopupMenuDialog.setBackgroundDrawable(new ColorDrawable(0));
        basePopupMenuDialog.setOutsideTouchable(false);
        g(basePopupMenuDialog, 1002);
        this.mTotalPopHeight = -2;
        this.popupWindow = basePopupMenuDialog;
        e();
    }

    public final void c() {
        Activity activity;
        WeakReference<Activity> weakReference = this.weakActivity;
        if (weakReference != null && (activity = weakReference.get()) != null) {
            try {
                if (LiuHaiUtils.hasNotchInScreenWrapper(activity)) {
                    View decorView = activity.getWindow().getDecorView();
                    Intrinsics.checkNotNull(decorView, "null cannot be cast to non-null type android.view.ViewGroup");
                    ((ViewGroup) decorView).removeView(this.dimView);
                } else {
                    WindowManager windowManager = activity.getWindowManager();
                    Intrinsics.checkNotNull(windowManager, "null cannot be cast to non-null type android.view.WindowManager");
                    windowManager.removeView(this.dimView);
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.i("RobotAIModelDialog", 2, e16.toString());
                }
            }
        }
        c cVar = this.callback;
        if (cVar != null) {
            cVar.onDismiss();
        }
        this.callback = null;
        BasePopupMenuDialog basePopupMenuDialog = this.popupWindow;
        if (basePopupMenuDialog != null) {
            basePopupMenuDialog.dismiss();
        }
    }

    public final void h(@Nullable c callback) {
        this.callback = callback;
    }

    public final void i(@NotNull View anchorView, int xOffset, int yOffset) {
        Activity activity;
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        WeakReference<Activity> weakReference = this.weakActivity;
        if (weakReference != null && (activity = weakReference.get()) != null) {
            try {
                if (LiuHaiUtils.hasNotchInScreenWrapper(activity)) {
                    View decorView = activity.getWindow().getDecorView();
                    Intrinsics.checkNotNull(decorView, "null cannot be cast to non-null type android.view.ViewGroup");
                    ((ViewGroup) decorView).addView(this.dimView, this.dimViewLp);
                } else {
                    WindowManager windowManager = activity.getWindowManager();
                    Intrinsics.checkNotNull(windowManager, "null cannot be cast to non-null type android.view.WindowManager");
                    windowManager.addView(this.dimView, this.dimViewLp);
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.i("RobotAIModelDialog", 2, e16.toString());
                }
            }
        }
        BasePopupMenuDialog basePopupMenuDialog = this.popupWindow;
        if (basePopupMenuDialog != null) {
            basePopupMenuDialog.showAtLocation(anchorView, 51, xOffset, yOffset);
        }
    }
}
