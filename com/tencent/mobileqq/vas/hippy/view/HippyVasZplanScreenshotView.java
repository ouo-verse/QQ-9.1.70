package com.tencent.mobileqq.vas.hippy.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.views.view.HippyViewGroup;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.xaction.log.b;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0011\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J$\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/vas/hippy/view/HippyVasZplanScreenshotView;", "Lcom/tencent/mtt/hippy/views/view/HippyViewGroup;", "Lcom/tencent/mtt/hippy/common/HippyArray;", "hippyArray", "Lcom/tencent/mtt/hippy/modules/Promise;", "promise", "", "b", "", "functionName", "dispatchFunction", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "d", "a", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class HippyVasZplanScreenshotView extends HippyViewGroup {
    public HippyVasZplanScreenshotView(@Nullable Context context) {
        super(context);
    }

    private final void b(HippyArray hippyArray, final Promise promise) {
        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.vas.hippy.view.a
            @Override // java.lang.Runnable
            public final void run() {
                HippyVasZplanScreenshotView.c(HippyVasZplanScreenshotView.this, promise);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(HippyVasZplanScreenshotView this$0, Promise promise) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        File file = new File(new File(BaseApplication.getContext().getExternalCacheDir(), "square"), QAdVrReport.ElementID.AD_POSTER);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(file, "vas_screenshot_poster.png");
        Bitmap createBitmap = Bitmap.createBitmap(this$0.getWidth(), this$0.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(-1);
        this$0.draw(canvas);
        boolean z16 = false;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            try {
                createBitmap.compress(Bitmap.CompressFormat.PNG, 90, fileOutputStream);
                fileOutputStream.flush();
                z16 = true;
            } catch (Throwable th5) {
                try {
                    b.c("HippyVasZplanScreenshotView", 1, "savePosterIntoLocalPath throw:", th5);
                    fileOutputStream.close();
                } finally {
                    fileOutputStream.close();
                }
            }
        } catch (Throwable th6) {
            b.c("HippyVasZplanScreenshotView", 1, "savePosterIntoLocalPath throw:", th6);
        }
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushBoolean("success", z16);
        hippyMap.pushString("localPath", file2.getAbsolutePath());
        if (promise != null) {
            promise.resolve(hippyMap);
        }
    }

    public final void dispatchFunction(@Nullable String functionName, @Nullable HippyArray hippyArray, @Nullable Promise promise) {
        b.a("HippyVasZplanScreenshotView", 2, "dispatchFunction functionName:" + functionName);
        if (Intrinsics.areEqual(functionName, "savePosterIntoLocalPath")) {
            b(hippyArray, promise);
        }
    }
}
