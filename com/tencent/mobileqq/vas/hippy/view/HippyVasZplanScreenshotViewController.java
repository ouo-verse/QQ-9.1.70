package com.tencent.mobileqq.vas.hippy.view;

import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@HippyController(name = HippyVasZplanScreenshotViewController.CLASS_NAME)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014J0\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/vas/hippy/view/HippyVasZplanScreenshotViewController;", "Lcom/tencent/mtt/hippy/uimanager/HippyViewController;", "Lcom/tencent/mobileqq/vas/hippy/view/HippyVasZplanScreenshotView;", "Landroid/content/Context;", "p0", "Landroid/view/View;", "createViewImpl", "screenshotView", "", "functionName", "Lcom/tencent/mtt/hippy/common/HippyArray;", "hippyArray", "Lcom/tencent/mtt/hippy/modules/Promise;", "promise", "", "dispatchFunction", "<init>", "()V", "Companion", "a", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class HippyVasZplanScreenshotViewController extends HippyViewController<HippyVasZplanScreenshotView> {

    @NotNull
    public static final String CLASS_NAME = "VASZplanScreenshotView";

    @NotNull
    private static final String TAG = "HippyVasZplanScreenshotViewController";

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    @NotNull
    protected View createViewImpl(@Nullable Context p06) {
        return new HippyVasZplanScreenshotView(p06);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void dispatchFunction(@Nullable HippyVasZplanScreenshotView screenshotView, @Nullable String functionName, @Nullable HippyArray hippyArray, @Nullable Promise promise) {
        if (screenshotView != null) {
            screenshotView.dispatchFunction(functionName, hippyArray, promise);
        }
    }
}
