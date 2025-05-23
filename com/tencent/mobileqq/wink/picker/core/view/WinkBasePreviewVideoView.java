package com.tencent.mobileqq.wink.picker.core.view;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\b\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0002H&R%\u0010\u000e\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b0\u00078\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/view/WinkBasePreviewVideoView;", "Landroid/widget/RelativeLayout;", "", "isPause", "", "b", "c", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/wink/picker/core/view/c;", "kotlin.jvm.PlatformType", "d", "Lmqq/util/WeakReference;", "a", "()Lmqq/util/WeakReference;", "videoCallbackRef", "Landroid/content/Context;", "context", "videoViewCallBack", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/wink/picker/core/view/c;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public abstract class WinkBasePreviewVideoView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<c> videoCallbackRef;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f324724e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkBasePreviewVideoView(@NotNull Context context, @NotNull c videoViewCallBack) {
        super(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(videoViewCallBack, "videoViewCallBack");
        this.f324724e = new LinkedHashMap();
        this.videoCallbackRef = new WeakReference<>(videoViewCallBack);
    }

    @NotNull
    public final WeakReference<c> a() {
        return this.videoCallbackRef;
    }

    public abstract void b(boolean isPause);

    public abstract boolean c();
}
