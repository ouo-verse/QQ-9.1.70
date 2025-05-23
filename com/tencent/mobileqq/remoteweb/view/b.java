package com.tencent.mobileqq.remoteweb.view;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Surface;
import com.tencent.mobileqq.remoteweb.RemoteBusinessEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\u0002H&J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH&J0\u0010\u0015\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013H&J\u001a\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u0007H&J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H&J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001bH&\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/remoteweb/view/b;", "", "", "init", "show", "", "url", "Landroid/os/Bundle;", "urlExtraInfo", "a", "dismiss", "Landroid/view/MotionEvent;", "event", "dispatchTouchEvent", "Landroid/view/Surface;", "newSurface", "", "width", "height", "Lkotlin/Function0;", "callback", "b", "Lcom/tencent/mobileqq/remoteweb/RemoteBusinessEvent;", "type", "extraInfo", "d", "c", "Lcom/tencent/mobileqq/remoteweb/view/BaseRemoteViewPresentation;", "e", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public interface b {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes18.dex */
    public static final class a {
        public static /* synthetic */ void a(b bVar, RemoteBusinessEvent remoteBusinessEvent, Bundle bundle, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    bundle = new Bundle();
                }
                bVar.d(remoteBusinessEvent, bundle);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dispatchEvent");
        }
    }

    void a(@NotNull String url, @NotNull Bundle urlExtraInfo);

    void b(@Nullable Surface newSurface, int width, int height, @NotNull Function0<Unit> callback);

    void c(int width, int height);

    void d(@NotNull RemoteBusinessEvent type, @NotNull Bundle extraInfo);

    void dismiss();

    void dispatchTouchEvent(@NotNull MotionEvent event);

    @Nullable
    BaseRemoteViewPresentation e();

    void init();

    void show();
}
