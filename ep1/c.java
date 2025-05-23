package ep1;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension;
import com.tencent.smtt.sdk.WebViewCallbackClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010+\u001a\u00020$\u00a2\u0006\u0004\b,\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016JX\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J0\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\tH\u0016J0\u0010\"\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010#\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016R\"\u0010+\u001a\u00020$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*\u00a8\u0006-"}, d2 = {"Lep1/c;", "Lcom/tencent/smtt/export/external/extension/proxy/ProxyWebViewClientExtension;", "", "invalidate", "", "data", "onReceivedViewSource", "Landroid/view/MotionEvent;", "event", "Landroid/view/View;", "view", "", "onTouchEvent", "ev", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "dispatchTouchEvent", "", "deltaX", "deltaY", "scrollX", "scrollY", "scrollRangeX", "scrollRangeY", "maxOverScrollX", "maxOverScrollY", "isTouchEvent", "overScrollBy", "l", "t", "oldl", "oldt", "onScrollChanged", "clampedX", "clampedY", "onOverScrolled", "computeScroll", "Lcom/tencent/smtt/sdk/WebViewCallbackClient;", "b", "Lcom/tencent/smtt/sdk/WebViewCallbackClient;", "getMCallbackClient", "()Lcom/tencent/smtt/sdk/WebViewCallbackClient;", "setMCallbackClient", "(Lcom/tencent/smtt/sdk/WebViewCallbackClient;)V", "mCallbackClient", "<init>", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c extends ProxyWebViewClientExtension {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private WebViewCallbackClient mCallbackClient;

    public c(@NotNull WebViewCallbackClient mCallbackClient) {
        Intrinsics.checkNotNullParameter(mCallbackClient, "mCallbackClient");
        this.mCallbackClient = mCallbackClient;
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void computeScroll(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.mCallbackClient.computeScroll(view);
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public boolean dispatchTouchEvent(@NotNull MotionEvent ev5, @NotNull View view) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        Intrinsics.checkNotNullParameter(view, "view");
        return this.mCallbackClient.dispatchTouchEvent(ev5, view);
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public boolean onInterceptTouchEvent(@NotNull MotionEvent ev5, @NotNull View view) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        Intrinsics.checkNotNullParameter(view, "view");
        return this.mCallbackClient.onInterceptTouchEvent(ev5, view);
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY, @NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.mCallbackClient.onOverScrolled(scrollX, scrollX, clampedX, clampedY, view);
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onReceivedViewSource(@NotNull String data) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void onScrollChanged(int l3, int t16, int oldl, int oldt, @NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.mCallbackClient.onScrollChanged(l3, t16, oldl, oldt, view);
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public boolean onTouchEvent(@NotNull MotionEvent event, @NotNull View view) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(view, "view");
        return this.mCallbackClient.onTouchEvent(event, view);
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent, @NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return this.mCallbackClient.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, maxOverScrollY, isTouchEvent, view);
    }

    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
    public void invalidate() {
    }
}
