package com.tencent.mobileqq.wink.editor.aielimination.doodle.view;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u001d\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R$\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0017\u0010\u001a\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/b;", "Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/h;", "Landroid/view/MotionEvent;", "event", "", "onTouchEvent", "Lz53/c;", "a", "Lz53/c;", "()Lz53/c;", "setMOnTouchGestureListener", "(Lz53/c;)V", "mOnTouchGestureListener", "Lz53/e;", "b", "Lz53/e;", "getMWinkScaleGestureDetector", "()Lz53/e;", "setMWinkScaleGestureDetector", "(Lz53/e;)V", "mWinkScaleGestureDetector", "Landroid/view/GestureDetector;", "c", "Landroid/view/GestureDetector;", "getMGestureDetector", "()Landroid/view/GestureDetector;", "mGestureDetector", "Landroid/content/Context;", "context", "listener", "<init>", "(Landroid/content/Context;Lz53/c;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b implements h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private z53.c mOnTouchGestureListener;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private z53.e mWinkScaleGestureDetector;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GestureDetector mGestureDetector;

    public b(@NotNull Context context, @NotNull z53.c listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mOnTouchGestureListener = listener;
        GestureDetector gestureDetector = new GestureDetector(context, listener);
        this.mGestureDetector = gestureDetector;
        gestureDetector.setOnDoubleTapListener(listener);
        z53.e eVar = new z53.e(context, this.mOnTouchGestureListener);
        this.mWinkScaleGestureDetector = eVar;
        eVar.l(1);
        z53.e eVar2 = this.mWinkScaleGestureDetector;
        if (eVar2 != null) {
            eVar2.j(1);
        }
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final z53.c getMOnTouchGestureListener() {
        return this.mOnTouchGestureListener;
    }

    @Override // com.tencent.mobileqq.wink.editor.aielimination.doodle.view.h
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        z53.c cVar;
        boolean z16;
        Intrinsics.checkNotNullParameter(event, "event");
        boolean z17 = true;
        if ((event.getAction() == 1 || event.getAction() == 3 || event.getAction() == 4) && (cVar = this.mOnTouchGestureListener) != null) {
            cVar.l(event);
        }
        z53.e eVar = this.mWinkScaleGestureDetector;
        if (eVar != null && eVar.i(event)) {
            z16 = true;
        } else {
            z16 = false;
        }
        z53.e eVar2 = this.mWinkScaleGestureDetector;
        if (eVar2 == null || eVar2.getMInProgress()) {
            z17 = false;
        }
        if (z17) {
            return z16 | this.mGestureDetector.onTouchEvent(event);
        }
        return z16;
    }
}
