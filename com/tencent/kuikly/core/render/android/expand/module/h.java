package com.tencent.kuikly.core.render.android.expand.module;

import android.app.Activity;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/module/h;", "Li01/e;", "Lcom/tencent/kuikly/core/render/android/expand/module/s;", "listener", "", "a", "c", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/kuikly/core/render/android/expand/module/KeyboardStatusWatcher;", "d", "Lcom/tencent/kuikly/core/render/android/expand/module/KeyboardStatusWatcher;", "keyboardStatusWatcher", "<init>", "()V", "e", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class h extends i01.e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private KeyboardStatusWatcher keyboardStatusWatcher;

    public final void a(@NotNull s listener) {
        Activity activity;
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.keyboardStatusWatcher == null && (activity = getActivity()) != null) {
            this.keyboardStatusWatcher = new KeyboardStatusWatcher(activity, get_kuiklyRenderContext());
        }
        KeyboardStatusWatcher keyboardStatusWatcher = this.keyboardStatusWatcher;
        if (keyboardStatusWatcher != null) {
            keyboardStatusWatcher.c(listener);
        }
    }

    public final void c(@NotNull s listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        KeyboardStatusWatcher keyboardStatusWatcher = this.keyboardStatusWatcher;
        if (keyboardStatusWatcher != null) {
            keyboardStatusWatcher.h(listener);
        }
    }

    @Override // i01.e, i01.a
    public void onDestroy() {
        super.onDestroy();
        KeyboardStatusWatcher keyboardStatusWatcher = this.keyboardStatusWatcher;
        if (keyboardStatusWatcher != null) {
            keyboardStatusWatcher.d();
        }
    }
}
