package k01;

import android.os.Handler;
import android.os.Message;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import d01.w;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001(B\u0007\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016R\u0016\u0010\u0017\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006)"}, d2 = {"Lk01/c;", "Lcom/tencent/kuikly/core/render/android/performace/b;", "Lk01/a;", "Landroid/os/Handler$Callback;", "", "t", "", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "p", "onInit", "e", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onResume", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "r", "Landroid/os/Message;", "msg", "", "handleMessage", "f", "Z", "isStarted", h.F, "isResumed", "Landroid/os/Handler;", "i", "Landroid/os/Handler;", "dumpHandler", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "dumpMemoryCount", BdhLogUtil.LogTag.Tag_Conn, "Lk01/a;", "memoryData", "<init>", "()V", "D", "a", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class c extends com.tencent.kuikly.core.render.android.performace.b<KRMemoryData> implements Handler.Callback {

    /* renamed from: C, reason: from kotlin metadata */
    private KRMemoryData memoryData = new KRMemoryData(0, 0, null, null, 15, null);

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isStarted;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isResumed;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Handler dumpHandler;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int dumpMemoryCount;

    private final long q() {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    private final long s() {
        return SystemMethodProxy.getPss() * 1024;
    }

    private final void t() {
        this.isStarted = true;
        this.isResumed = true;
        Handler handler = this.dumpHandler;
        if (handler != null) {
            handler.sendEmptyMessage(1);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.performace.b, com.tencent.kuikly.core.render.android.e
    public void e() {
        t();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NotNull Message msg2) {
        Handler handler;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        long s16 = s();
        long q16 = q();
        int i3 = msg2.what;
        if (i3 != 0) {
            if (i3 == 1 && this.isResumed) {
                this.memoryData.g(s16, q16);
                this.dumpMemoryCount++;
                w.f392617a.a("KRMemoryMonitor", "dumpMemory[" + this.dumpMemoryCount + "], pssSize: " + s16 + ", javaHeapSize: " + q16);
                if (this.dumpMemoryCount < 10 && (handler = this.dumpHandler) != null) {
                    handler.sendEmptyMessageDelayed(1, 10000L);
                }
            }
        } else {
            this.memoryData.e(s16, q16);
            w.f392617a.a("KRMemoryMonitor", "initMemory, pssSize: " + s16 + ", javaHeapSize: " + q16);
        }
        return true;
    }

    @Override // com.tencent.kuikly.core.render.android.performace.b, com.tencent.kuikly.core.render.android.e
    public void onDestroy() {
        Handler handler = this.dumpHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.dumpHandler = null;
    }

    @Override // com.tencent.kuikly.core.render.android.performace.b, com.tencent.kuikly.core.render.android.e
    public void onInit() {
        Handler handler = new Handler(com.tencent.kuikly.core.render.android.performace.b.INSTANCE.a(), this);
        this.dumpHandler = handler;
        handler.sendEmptyMessage(0);
    }

    @Override // com.tencent.kuikly.core.render.android.performace.b, com.tencent.kuikly.core.render.android.e
    public void onPause() {
        if (!this.isStarted) {
            return;
        }
        this.isResumed = false;
        Handler handler = this.dumpHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.performace.b, com.tencent.kuikly.core.render.android.e
    public void onResume() {
        if (!this.isStarted) {
            return;
        }
        this.isResumed = true;
        Handler handler = this.dumpHandler;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(1, 10000L);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.performace.b
    @NotNull
    public String p() {
        return "KRMemoryMonitor";
    }

    @Nullable
    public KRMemoryData r() {
        if (this.memoryData.f()) {
            return this.memoryData;
        }
        return null;
    }
}
